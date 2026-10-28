"""공개 릴리스 태그의 소스와 원래 서명 bundle만 포장합니다. Maven 파일은 재생성하지 않습니다."""
from pathlib import Path, PurePosixPath
import hashlib
import io
import json
import re
import subprocess
import tarfile
import time
import zipfile

ROOT = Path(__file__).resolve().parents[1]
DIST = ROOT / "dist"
VERSION = re.search(r'version = "([^"]+)"', (ROOT / "build.gradle.kts").read_text())[1]
GROUP_PATH = tuple(re.search(r'group = "([^"]+)"', (ROOT / "build.gradle.kts").read_text())[1].split("."))
MODULES = ("pleos-tokens", "pleos-compose", "pleos-aaos")


def package():
    tag = "v" + VERSION
    commit = subprocess.run(["git", "rev-parse", "--verify", tag + "^{commit}"], cwd=ROOT, check=True, capture_output=True, text=True).stdout.strip()
    validation = json.loads(subprocess.run(["git", "show", tag + ":docs/verification/publishing/bundle-validation.json"], cwd=ROOT, check=True, capture_output=True, text=True).stdout)
    if not validation["signed"] or validation["version"] != VERSION:
        raise ValueError("태그에 기록한 서명 배포 정보가 필요합니다.")
    bundle = DIST / f"central-bundle-{VERSION}.zip"
    if hashlib.sha256(bundle.read_bytes()).hexdigest() != validation["bundleSha256"]:
        raise ValueError("공개 배포 때 사용한 원본 서명 bundle과 다릅니다.")
    with zipfile.ZipFile(bundle) as published:
        maven = {name: published.read(name) for name in published.namelist()}
    expected = set()
    for item in validation["artifacts"]:
        name = item["path"]
        if hashlib.sha256(maven[name]).hexdigest() != item["sha256"]:
            raise ValueError("배포 파일 해시 불일치: " + name)
        expected.add(name)
        expected.add(name + ".asc")
        for algorithm in ("md5", "sha1", "sha256", "sha512"):
            suffix = name + "." + algorithm
            if maven[suffix].decode() != hashlib.new(algorithm, maven[name]).hexdigest():
                raise ValueError("배포 체크섬 불일치: " + suffix)
            expected.add(suffix)
    if set(maven) != expected or len(validation["artifacts"]) != 15:
        raise ValueError("예정된 배포 파일 이외의 항목이 있습니다.")
    source_tar = subprocess.run(["git", "archive", "--format=tar", tag], cwd=ROOT, check=True, capture_output=True).stdout
    commit_time = int(subprocess.run(["git", "show", "-s", "--format=%ct", commit], cwd=ROOT, check=True, capture_output=True, text=True).stdout.strip())
    fixed_date = time.gmtime(max(commit_time, 315532800))[:6]
    def data_entry(name):
        info = zipfile.ZipInfo(name, fixed_date)
        info.create_system = 3
        info.external_attr = 0o100644 << 16
        info.compress_type = zipfile.ZIP_DEFLATED
        return info
    DIST.mkdir(exist_ok=True)
    artifacts = DIST / "aar"
    artifacts.mkdir(exist_ok=True)
    for module in MODULES:
        name = "/".join((*GROUP_PATH, module, VERSION, f"{module}-{VERSION}.aar"))
        (artifacts / f"{module}-{VERSION}.aar").write_bytes(maven[name])
    archive = DIST / f"pleos-connect-ui-{VERSION}.zip"
    count = 0
    with zipfile.ZipFile(archive, "w", zipfile.ZIP_DEFLATED, compresslevel=9) as output:
        with tarfile.open(fileobj=io.BytesIO(source_tar)) as sources:
            for member in sources:
                if member.isdir():
                    continue
                path = PurePosixPath(member.name)
                if not member.isfile() or path.is_absolute() or ".." in path.parts:
                    raise ValueError("지원하지 않는 소스 항목: " + member.name)
                info = zipfile.ZipInfo("PleosConnectUI/" + member.name, time.gmtime(max(member.mtime, 315532800))[:6])
                info.create_system = 3
                info.external_attr = (member.mode & 0xFFFF) << 16
                info.compress_type = zipfile.ZIP_DEFLATED
                output.writestr(info, sources.extractfile(member).read())
                count += 1
        for name, data in sorted(maven.items()):
            output.writestr(data_entry("PleosConnectUI/build/maven/" + name), data)
        output.writestr(data_entry("PleosConnectUI/RELEASE_SNAPSHOT.json"), json.dumps({"version": VERSION, "tag": tag, "commit": commit, "bundleSha256": validation["bundleSha256"], "gitArchiveTarSha256": hashlib.sha256(source_tar).hexdigest(), "sourceFiles": count}, indent=2) + "\n")
    checksums = DIST / "SHA256SUMS.txt"
    outputs = [artifacts / f"{module}-{VERSION}.aar" for module in MODULES] + [archive]
    checksums.write_text("".join(
        hashlib.sha256(path.read_bytes()).hexdigest() + "  " + path.relative_to(DIST).as_posix() + "\n"
        for path in outputs
    ))
    with zipfile.ZipFile(archive) as output:
        if output.testzip() is not None:
            raise ValueError("소스 ZIP CRC 검증에 실패했습니다.")
        if any("/app/" in name or "/catalog/" in name or name.endswith("local.properties") for name in output.namelist()):
            raise ValueError("배포 대상이 아닌 파일이 있습니다.")
    print(f"Packaged {tag} ({commit[:7]}): {count} source files and {len(maven)} original Maven files, {archive.stat().st_size} bytes")
    print(f"Source ZIP SHA-256: {hashlib.sha256(archive.read_bytes()).hexdigest()}")


if __name__ == "__main__":
    package()
