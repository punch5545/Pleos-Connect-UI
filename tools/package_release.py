"""검증된 AAR·로컬 Maven·소스·설계/검증 문서를 한 배포물로 묶습니다."""
from pathlib import Path
import hashlib
import re
import shutil
import zipfile

ROOT = Path(__file__).resolve().parents[1]
DIST = ROOT / "dist"
VERSION = re.search(r'version = "([^"]+)"', (ROOT / "build.gradle.kts").read_text())[1]
GROUP_PATH = tuple(re.search(r'group = "([^"]+)"', (ROOT / "build.gradle.kts").read_text())[1].split("."))
MODULES = ("pleos-tokens", "pleos-compose", "pleos-aaos")


def package():
    DIST.mkdir(exist_ok=True)
    artifacts = DIST / "aar"
    artifacts.mkdir(exist_ok=True)
    for module in MODULES:
        source = ROOT / module / "build/outputs/aar" / f"{module}-release.aar"
        if not source.is_file():
            raise FileNotFoundError(source)
        shutil.copyfile(source, artifacts / f"{module}-{VERSION}.aar")
    excluded = {".gradle", ".kotlin", ".idea", ".git", "dist", "__pycache__"}
    files = []
    for path in ROOT.rglob("*"):
        if not path.is_file():
            continue
        relative = path.relative_to(ROOT)
        if any(part in excluded for part in relative.parts):
            continue
        if path.name in {"local.properties", ".DS_Store"}:
            continue
        if "build" in relative.parts and relative.parts[:2] != ("build", "maven"):
            continue
        if relative.parts[:2] == ("build", "maven") and relative.parts[2:2 + len(GROUP_PATH)] != GROUP_PATH:
            continue
        files.append(path)
    archive = DIST / f"pleos-connect-ui-{VERSION}.zip"
    with zipfile.ZipFile(archive, "w", zipfile.ZIP_DEFLATED, compresslevel=9) as output:
        for path in sorted(files):
            output.write(path, Path("PleosConnectUI") / path.relative_to(ROOT))
    checksums = DIST / "SHA256SUMS.txt"
    outputs = [artifacts / f"{module}-{VERSION}.aar" for module in MODULES] + [archive]
    checksums.write_text("".join(
        hashlib.sha256(path.read_bytes()).hexdigest() + "  " + path.relative_to(DIST).as_posix() + "\n"
        for path in outputs
    ))
    with zipfile.ZipFile(archive) as output:
        assert output.testzip() is None
        assert not any("/app/" in name or "/catalog/" in name or name.endswith("local.properties") for name in output.namelist())
    print(f"Packaged {len(files)} files: {archive.name} ({archive.stat().st_size} bytes)")


if __name__ == "__main__":
    package()
