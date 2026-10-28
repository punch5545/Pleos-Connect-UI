"""공개 선언과 계약을 소스에 연결합니다. 네트워크를 사용하지 않습니다."""
from pathlib import Path
import html
import re

ROOT = Path(__file__).resolve().parents[1]
MODULES = ("pleos-tokens", "pleos-compose", "pleos-aaos")


def generate():
    lines = [
        "# 공개 Kotlin API", "",
        "패키지는 `com.jade.pleos.tokens`, `com.jade.pleos.compose`, `com.jade.pleos.aaos`입니다. "
        "현재 소스의 공개 최상위 선언과 인자를 연결합니다. 멤버 함수·열거 값은 소스 링크에서 확인하십시오. "
        "생성 원본 목록은 `PleosSourceTokens`, 아이콘 목록은 `PleosIcons`에서 제공합니다.", "",
        "크기는 별도 표기가 없으면 Dp, 글자 크기·줄높이는 sp, 시간은 ms입니다. "
        "실제 기본 인자·타입·유효 조합은 아래 선언과 KDoc을 따릅니다. "
        "상태를 받는 컴포넌트의 콜백은 변경 요청이며 다음 외부 상태가 표시의 기준입니다. "
        "규격 수치·범위 처리·호스트 경계는 README.md, SPEC_DECISIONS.md, AAOS_INTEGRATION.md에 연결합니다.", "",
    ]
    declaration = re.compile(r"^(?:(?:data|sealed|enum|fun|value) )?(?:class|interface|object|fun|val)\s+")
    for module in MODULES:
        lines.extend(["## " + module, ""])
        for path in sorted((ROOT / module / "src/main/java").rglob("*.kt")):
            if path.name.startswith("Generated"):
                continue
            source = path.read_text()
            for match in re.finditer(r"^.+$", source, re.M):
                line = match.group()
                if not declaration.match(line):
                    continue
                number = source.count("\n", 0, match.start()) + 1
                signature = line
                if "(" in line:
                    pos = match.start() + line.index("(")
                    depth = 0
                    quoted = False
                    escape = False
                    end = pos
                    for end in range(pos, len(source)):
                        char = source[end]
                        if quoted:
                            if escape:
                                escape = False
                            elif char == "\\":
                                escape = True
                            elif char == '"':
                                quoted = False
                            continue
                        if char == '"':
                            quoted = True
                        elif char == "(":
                            depth += 1
                        elif char == ")":
                            depth -= 1
                            if depth == 0:
                                break
                    signature = source[match.start():end + 1]
                else:
                    signature = line.split(" {", 1)[0].split(" = ", 1)[0]
                relative = path.relative_to(ROOT).as_posix()
                # 상대 링크는 배포 ZIP에서도 저장소 구조를 그대로 따라갑니다.
                lines.extend([f"[{path.name}:{number}]({relative}#L{number})", "", "```kotlin", signature, "```", ""])
    document = "\n".join(lines)
    (ROOT / "PUBLIC_API.md").write_text(document)
    intro = document.split("## pleos-tokens", 1)[0]
    version = re.search(r'version = "([^"]+)"', (ROOT / "build.gradle.kts").read_text())[1]
    for module in MODULES:
        section = document.split("## " + module + "\n", 1)[1].split("\n## ", 1)[0]
        content = html.escape(intro + "## " + module + "\n" + section)
        content = re.sub(
            r"\[([^\]]+)\]\(([^\)]+)\)",
            lambda match: '<a href="https://github.com/punch5545/Pleos-Connect-UI/blob/v'
            + version + '/' + match[2] + '">' + match[1] + '</a>',
            content,
        )
        target = ROOT / "build/api-docs" / module
        target.mkdir(parents=True, exist_ok=True)
        (target / "index.html").write_text(
            '<!doctype html><html lang="ko"><meta charset="utf-8">'
            '<meta name="viewport" content="width=device-width, initial-scale=1">'
            '<title>' + module + ' Kotlin API</title>'
            '<style>body{max-width:1000px;margin:2rem auto;padding:0 1rem;'
            'font-family:system-ui,sans-serif}pre{white-space:pre-wrap;overflow-wrap:anywhere;'
            'line-height:1.6}a{color:#1756b8}</style><body><h1>' + module
            + ' Kotlin API</h1><p>현재 소스의 공개 선언과 기본 인자입니다. '
            '전체 KDoc과 멤버는 연결된 소스를 참고하십시오.</p><pre>' + content + '</pre></body></html>'
        )


if __name__ == "__main__":
    generate()
