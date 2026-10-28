"""태그 소스·원본 배포 파일·미추적 파일 제외·변조 거부·ZIP 재현성을 실제 검사합니다."""
from pathlib import Path
import hashlib
import importlib.util
import io
import json
import subprocess
import tarfile
import tempfile
import zipfile

ROOT = Path(__file__).resolve().parents[1]


def require(condition, message):
    if not condition:
        raise AssertionError(message)


def verify():
    spec = importlib.util.spec_from_file_location("release_package", ROOT / "tools/package_release.py")
    tool = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(tool)
    tool.package()
    archive = tool.DIST / f"pleos-connect-ui-{tool.VERSION}.zip"
    first_hash = hashlib.sha256(archive.read_bytes()).hexdigest()
    tool.package()
    require(hashlib.sha256(archive.read_bytes()).hexdigest() == first_hash, "Repeated ZIP bytes differ")
    source_tar = subprocess.run(["git", "archive", "--format=tar", "v" + tool.VERSION], cwd=ROOT, check=True, capture_output=True).stdout
    with zipfile.ZipFile(archive) as output, tarfile.open(fileobj=io.BytesIO(source_tar)) as sources, zipfile.ZipFile(tool.DIST / f"central-bundle-{tool.VERSION}.zip") as bundle:
        require(output.testzip() is None, "ZIP CRC failure")
        names = output.namelist()
        require(not any("/_workspace/" in n or "/.git/" in n or n.endswith("local.properties") for n in names), "Private path included")
        expected_sources = set()
        for member in sources:
            if member.isfile():
                name = "PleosConnectUI/" + member.name
                expected_sources.add(name)
                require(output.read(name) == sources.extractfile(member).read(), "Tagged source differs: " + name)
        expected_maven = {"PleosConnectUI/build/maven/" + name for name in bundle.namelist()}
        require(set(names) == expected_sources | expected_maven | {"PleosConnectUI/RELEASE_SNAPSHOT.json"}, "Unexpected file included")
        for name in bundle.namelist():
            require(output.read("PleosConnectUI/build/maven/" + name) == bundle.read(name), "Published file differs: " + name)
            require((output.getinfo("PleosConnectUI/build/maven/" + name).external_attr >> 16) & 0o777 == 0o644, "Maven permission differs")
        require((output.getinfo("PleosConnectUI/gradlew").external_attr >> 16) & 0o111 == 0o111, "gradlew is not executable")
        snapshot = json.loads(output.read("PleosConnectUI/RELEASE_SNAPSHOT.json"))
        require(snapshot["gitArchiveTarSha256"] == hashlib.sha256(source_tar).hexdigest(), "Source tar hash differs")
        for module in tool.MODULES:
            name = "/".join((*tool.GROUP_PATH, module, tool.VERSION, f"{module}-{tool.VERSION}.aar"))
            require((tool.DIST / "aar" / f"{module}-{tool.VERSION}.aar").read_bytes() == bundle.read(name), "AAR differs")
    for line in (tool.DIST / "SHA256SUMS.txt").read_text().splitlines():
        expected, name = line.split(None, 1)
        require(hashlib.sha256((tool.DIST / name).read_bytes()).hexdigest() == expected, "Output checksum differs")
    with tempfile.TemporaryDirectory(prefix="pleos-package-negative-") as directory:
        tool.DIST = Path(directory)
        (tool.DIST / f"central-bundle-{tool.VERSION}.zip").write_bytes(b"tampered")
        try:
            tool.package()
        except ValueError:
            pass
        else:
            raise AssertionError("Tampered bundle accepted")
    report = {"status": "PASS", "sourceTag": snapshot["tag"], "sourceCommit": snapshot["commit"], "sourceFiles": snapshot["sourceFiles"], "originalMavenFiles": len(expected_maven), "allTaggedSourcesMatch": True, "gradlewExecutablePreserved": True, "workspaceAndUntrackedFilesExcluded": True, "tamperedBundleRejected": True, "repeatedZipBytesIdentical": True, "sourceZipSha256": first_hash, "verificationCommand": "python3 tools/verify_release_package.py"}
    (ROOT / "docs/verification/publishing/source-package-validation.json").write_text(json.dumps(report, indent=2) + "\n")
    print(json.dumps(report))


if __name__ == "__main__":
    verify()
