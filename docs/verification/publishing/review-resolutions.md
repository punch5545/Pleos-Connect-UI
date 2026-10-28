# 배포 검토 보정

- 최초 검토의 LICENSE 원문·JAR 포함, 버전 변경 시 문서 작업 입력, 전체 fingerprint 검증, 공개 키 서버 확인, 태그 선행 푸시 절차를 보정했습니다.
- 후속 검토가 읽었던 SourceSet 인덱스의 legacy cast 오류는 로컬 AGP 9.4.1 공개 LibraryExtension 타입으로 수정했습니다. 실패 로그와 성공한 release-build.log를 모두 보존합니다.
- POM license comments에 직접 작성한 코드에만 Apache-2.0이 적용된다는 범위와 외부 자산 고지 URL을 추가했습니다. 사용자가 동봉 자료의 공개 배포를 명시적으로 지시한 범위에서 작업했으며, 별도 원본 자산에 임의 라이선스를 부여하지 않았습니다.
- 라이선스 자산 생성은 Sync로 바꾸고 OFL 원문 경로는 pleos-tokens AAR로 명확히 했습니다.
- 전체 15개 파일을 서명·검증했고, AAR·sources/API 문서 JAR의 LICENSE·NOTICE·외부 고지를 실제 바이트와 대조했습니다. Gradle documentation variant는 별도로 제공하지 않는다고 문서에 명시했습니다.
