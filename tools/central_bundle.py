"""Central Portal용 Maven bundle을 검증·서명하여 구성합니다. 인증값은 사용하지 않습니다."""
from pathlib import Path
import argparse
import hashlib
import json
import re
import shutil
import subprocess
import xml.etree.ElementTree as ET
import zipfile

ROOT = Path(__file__).resolve().parents[1]
MODULES = ("pleos-tokens", "pleos-compose", "pleos-aaos")
HASHES = ("md5", "sha1", "sha256", "sha512")
NS = {"m": "http://maven.apache.org/POM/4.0.0"}


def coordinates():
    source = (ROOT / "build.gradle.kts").read_text()
    group = re.search(r'group = "([^"]+)"', source)[1]
    version = re.search(r'version = "([^"]+)"', source)[1]
    if version.endswith("-SNAPSHOT") or any(c in version for c in "/\\"):
        raise ValueError("고정된 릴리스 버전이 필요합니다.")
    return group, version


def validate_pom(path, group, module, version):
    pom = ET.parse(path).getroot()
    for tag, expected in (("groupId", group), ("artifactId", module), ("version", version), ("packaging", "aar")):
        if pom.findtext("m:" + tag, namespaces=NS) != expected:
            raise ValueError(f"잘못된 POM 좌표: {module}/{tag}")
    required = ("name", "description", "url", "licenses/license/name", "licenses/license/url", "developers/developer/name", "scm/url", "scm/connection", "scm/developerConnection")
    for field in required:
        text = pom.findtext("/".join("m:" + s for s in field.split("/")), namespaces=NS)
        if not text or not text.strip():
            raise ValueError(f"필수 POM 정보가 없습니다: {module}/{field}")
    for dependency in pom.findall("m:dependencies/m:dependency", NS):
        artifact = dependency.findtext("m:artifactId", namespaces=NS)
        if artifact in MODULES:
            if dependency.findtext("m:groupId", namespaces=NS) != group or dependency.findtext("m:version", namespaces=NS) != version:
                raise ValueError(f"전이 의존성 좌표가 다릅니다: {module}/{artifact}")


def build_bundle(sign_key=None):
    group, version = coordinates()
    if sign_key and not re.fullmatch(r"(?:[0-9A-Fa-f]{40}|[0-9A-Fa-f]{64})", sign_key):
        raise ValueError("전체 GPG fingerprint가 필요합니다.")
    if not (ROOT / "LICENSE").is_file():
        raise ValueError("사용자가 선택한 코드 라이선스 원문 LICENSE가 필요합니다.")
    target = ROOT / "build/central/staging"
    if target.exists():
        shutil.rmtree(target)
    target.mkdir(parents=True)
    artifacts = []
    for module in MODULES:
        relative = Path(*group.split(".")) / module / version
        source = ROOT / "build/maven" / relative
        destination = target / relative
        destination.mkdir(parents=True)
        base = f"{module}-{version}"
        files = [source / (base + suffix) for suffix in (".aar", ".pom", ".module", "-sources.jar", "-javadoc.jar")]
        for file in files:
            if not file.is_file():
                raise FileNotFoundError(file)
        validate_pom(source / (base + ".pom"), group, module, version)
        with zipfile.ZipFile(source / (base + "-sources.jar")) as jar:
            if not any(name.endswith(".kt") for name in jar.namelist()):
                raise ValueError(f"Kotlin 소스가 없는 source JAR: {module}")
        with zipfile.ZipFile(source / (base + "-javadoc.jar")) as jar:
            if len(jar.read("index.html")) < 1000 or "PUBLIC_API.md" not in jar.namelist():
                raise ValueError(f"API 문서가 없는 Javadoc JAR: {module}")
            for name in ("LICENSE", "THIRD_PARTY_NOTICES.md"):
                if jar.read(name) != (ROOT / name).read_bytes():
                    raise ValueError(f"배포 라이선스 문서가 다릅니다: {module}/{name}")
        for file in files:
            output = destination / file.name
            shutil.copyfile(file, output)
            for algorithm in HASHES:
                output.with_name(output.name + "." + algorithm).write_text(hashlib.new(algorithm, output.read_bytes()).hexdigest())
            if sign_key:
                signature = output.with_name(output.name + ".asc")
                subprocess.run(["gpg", "--batch", "--pinentry-mode", "error", "--armor", "--local-user", sign_key, "--output", str(signature), "--detach-sign", str(output)], check=True)
                verification = subprocess.run(["gpg", "--batch", "--status-fd", "1", "--verify", str(signature), str(output)], check=True, capture_output=True, text=True)
                valid = [line.split() for line in verification.stdout.splitlines() if line.startswith("[GNUPG:] VALIDSIG ")]
                if not any(sign_key.upper() in (fields[2].upper(), fields[-1].upper()) for fields in valid):
                    raise ValueError(f"예정한 GPG 키와 실제 서명 키가 다릅니다: {file.name}")
            artifacts.append({"path": output.relative_to(target).as_posix(), "sha256": hashlib.sha256(output.read_bytes()).hexdigest()})
    archive = ROOT / "dist" / f"central-bundle-{version}{'' if sign_key else '-unsigned'}.zip"
    archive.parent.mkdir(exist_ok=True)
    with zipfile.ZipFile(archive, "w", zipfile.ZIP_DEFLATED) as bundle:
        for file in sorted(target.rglob("*")):
            if file.is_file():
                bundle.write(file, file.relative_to(target))
    report = {"group": group, "version": version, "signed": bool(sign_key), "signingFingerprint": sign_key, "modules": list(MODULES), "artifactCount": len(artifacts), "artifacts": artifacts, "bundleSha256": hashlib.sha256(archive.read_bytes()).hexdigest()}
    (ROOT / "build/central/validation.json").write_text(json.dumps(report, indent=2) + "\n")
    print(f"Bundle: {archive}\nSigned: {bool(sign_key)}; artifacts: {len(artifacts)}")
    return archive


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description=__doc__)
    mode = parser.add_mutually_exclusive_group(required=True)
    mode.add_argument("--unsigned", action="store_true", help="로컬 검증 전용")
    mode.add_argument("--sign-key", help="기존 GPG 서명 키의 전체 fingerprint")
    args = parser.parse_args()
    build_bundle(args.sign_key)
