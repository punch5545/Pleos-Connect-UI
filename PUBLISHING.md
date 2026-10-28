# Maven Central 배포

배포 대상은 Sonatype Central Portal이며 인증된 네임스페이스는 `io.github.punch5545`입니다. GitHub Pages 또는 GitHub Packages를 대체 저장소로 사용하지 않습니다.

최신 게시 상태와 공개 저장소 확인 결과는 [배포 상태 기록](https://github.com/punch5545/Pleos-Connect-UI/blob/main/docs/verification/publishing/status.json)에 기록합니다. 아래 좌표를 Maven Central 배포에 사용합니다.

| 모듈 | 공개 좌표 |
| --- | --- |
| Tokens | `io.github.punch5545:pleos-tokens:0.1.0` |
| Compose | `io.github.punch5545:pleos-compose:0.1.0` |
| AAOS | `io.github.punch5545:pleos-aaos:0.1.0` |

소비 앱은 `google()`과 `mavenCentral()`을 사용합니다. 일반 UI에는 compose만 추가하며 tokens가 전이됩니다. 차량 adapter가 필요한 앱에서만 aaos를 추가합니다. Kotlin 패키지는 기존 `com.jade.pleos.*`를 유지합니다.

## 배포물 구성

각 모듈은 AAR, sources JAR, API 문서 JAR, POM, Gradle module metadata를 제공합니다. API 문서 JAR에는 현재 공개 Kotlin 선언의 HTML·Markdown과 사용 문서가 들어갑니다. Java용 Javadoc으로 Kotlin 전체 멤버를 생성한 결과로 표시하지 않습니다. 원본 Kotlin과 KDoc은 sources JAR와 소스 링크로 제공합니다.

API 문서 JAR은 Maven의 `javadoc` classifier로 제공합니다. 별도 Gradle documentation variant는 추가하지 않습니다.

POM은 프로젝트 URL·SCM·개발자·Apache-2.0 코드 라이선스를 포함합니다. AAR·sources/API 문서 JAR에 LICENSE·NOTICE·THIRD_PARTY_NOTICES.md도 넣습니다. 폰트와 동봉 디자인 자산의 권리는 [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md)에 별도로 유지합니다.

## 재현

```sh
export JAVA_HOME='/Applications/Android Studio.app/Contents/jbr/Contents/Home'
./gradlew assembleRelease testDebugUnitTest lintRelease \
  publishAllPublicationsToProjectLocalRepository
python3 tools/central_bundle.py --unsigned
python3 tools/central_bundle.py --sign-key SIGNING_KEY_FINGERPRINT
```

`SIGNING_KEY_FINGERPRINT`는 기존 GPG 키의 공개 fingerprint로 바꿉니다. 잠긴 키는 사용자 본인이 GPG에서 해제해야 합니다. 비밀 키·암호·Central 토큰은 저장소에 넣지 않습니다.

사용하는 공개 키가 Central 지원 키 서버에서 조회되는지 확인해야 합니다. 이번에 확인한 키는 이미 `keyserver.ubuntu.com`에 등록되어 있습니다. 새 배포 키를 선택하면 해당 키의 공개 부분을 먼저 등록하고 전체 fingerprint로 조회하십시오. 로컬 키링에만 존재하는 키로 배포하지 않습니다.

unsigned bundle은 로컬 구조 검증 전용으로 파일명에 `-unsigned`를 붙입니다. 서명 옵션은 모든 AAR·POM·module metadata·sources/API 문서 JAR에 detached ASCII signature를 생성하고 실제 검증합니다. bundle에는 Maven 경로를 따르는 파일과 MD5·SHA-1·SHA-256·SHA-512를 넣고 repository metadata는 제외합니다. 모듈 간 전이 좌표와 필수 POM 값·실제 소스/API 문서 존재도 검사합니다.

최종 `dist/central-bundle-0.1.0.zip`을 로그인된 [Central Portal](https://central.sonatype.com/publishing/deployments)에 업로드하고 validation 결과를 확인한 뒤 publish합니다. Portal의 게시 진행 상태를 확인하며, 최종 배포는 공개 Maven 경로의 다운로드와 별도 소비 프로젝트의 의존성 해석·컴파일로 확인합니다. 실제 실행 상태와 증거는 `docs/verification/publishing/`에 기록합니다.

POM과 API 소스 링크는 `v0.1.0` 태그를 사용합니다. 해당 버전의 소스·라이선스를 커밋하고 `main`과 `v0.1.0` 태그를 먼저 푸시한 뒤 Central에 게시합니다. 이미 배포한 버전의 태그나 Central 파일을 덮어쓰지 않습니다.

## 0.1.0 게시 결과

세 모듈을 Maven Central에 공개했습니다. Deployment ID는 `ab5ae8c3-0442-499b-8ef4-9a39dfabeca0`이며, 릴리스 소스는 [v0.1.0](https://github.com/punch5545/Pleos-Connect-UI/tree/v0.1.0)입니다.

- AAR·POM·Gradle module metadata·sources/API 문서 JAR 15개와 서명 15개를 공개 저장소에서 익명으로 내려받아 서명한 bundle과 바이트가 같은지 확인했습니다. [다운로드 기록](docs/verification/publishing/public-download-check.json)에 URL과 SHA-256을 남겼습니다.
- `google()`과 `mavenCentral()`만 사용하는 임시 Android Library에서 `pleos-aaos:0.1.0`을 참조하고 Compose UI와 rotary adapter API를 컴파일했습니다. [컴파일 로그](docs/verification/publishing/central-consumer-build.log)와 [aaos → compose → tokens 의존성 그래프](docs/verification/publishing/central-dependency-graph.log)를 확인할 수 있습니다. 앱이나 Activity는 만들지 않았습니다.
- README의 Maven Central 배지가 `v0.1.0`, 라이선스 배지가 `Apache-2.0`을 표시하는 SVG인지 확인했습니다. [배지 확인 기록](docs/verification/publishing/badge-check.json)을 보존합니다.

배포한 파일을 다시 만들 때는 `v0.1.0` 태그를 기준으로 빌드하십시오. 게시 후 main의 문서가 바뀌어도 기존 Central 파일을 덮어쓰지 않습니다.

로컬 소스 배포 ZIP이 필요하면 main의 `tools/package_release.py`를 실행합니다. 이 도구는 작업 폴더를 수집하지 않고 `git archive v0.1.0`과 태그에 기록한 해시가 같은 원본 서명 bundle만 포장합니다. 공개 태그에 없는 개인 파일·미추적 파일·윤문 작업 폴더는 포함하지 않습니다. ZIP의 `RELEASE_SNAPSHOT.json`에 소스 태그·커밋·bundle 해시를 기록하며, 공개 Maven 파일을 재생성하지 않습니다.

`python3 tools/verify_release_package.py`는 태그의 모든 소스와 원래 Maven 파일의 바이트 일치, 실행 권한, 체크섬, 미추적 파일 제외와 변조 bundle 거부를 검사합니다. 동일 입력으로 ZIP을 두 번 생성하여 바이트가 같은지도 확인합니다. ZIP 내부에는 버전과 소스 tar 해시를 기록하고, 최종 ZIP 해시는 외부 `SHA256SUMS.txt`에 둡니다. [실행 결과](docs/verification/publishing/source-package-validation.json)와 [로그](docs/verification/publishing/source-package-check.log)를 보존합니다.

## 사용한 공식 문서

- [네임스페이스 인증](https://central.sonatype.org/register/namespace/)
- [POM·서명·소스·문서·체크섬 요구사항](https://central.sonatype.org/publish/requirements/)
- [Bundle 업로드](https://central.sonatype.org/publish/publish-portal-upload/)
- [Portal API와 상태](https://central.sonatype.org/publish/publish-portal-api/)

명세 구현에는 동봉 자료를 사용했으며, 위 외부 문서는 Central 배포 설정을 확인하는 데 사용했습니다.
