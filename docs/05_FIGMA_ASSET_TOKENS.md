# Figma assets — 전체 변수 토큰

> **적용 주의:** 이 파일은 첨부의 원본 추출 증거다. 웹과 상충하는 값은 최종 구현에서 사용하지 않는다. 01·02·03·08번의 최신 웹 값과 `data/web_color_tokens.json` override가 우선한다.

사용자가 첨부한 `.fig` 파일의 내장 Kiwi 스키마와 노드에서 직접 추출한 값이다. 웹 연결 없이 이 표를 사용한다. 파일 간 같은 이름의 토큰과 collection은 자동 병합하지 않는다. 모든 수치는 원본 design unit이며 dp/sp 환산이나 기준 density를 뜻하지 않는다.

컬러 표기 `#RRGGBBAA`는 RGBA 순서다. Kotlin ARGB에는 AARRGGBB로 재배열한다. `alias → id`의 값은 해당 모드 ID, 동명 모드, 단일값 순서로 해석했다. 추가로 모드명의 제어문자를 제거한 이름이 유일하게 일치하면 연결하고 아래 정규화 내역에 ID를 기록했다. `UNRESOLVED` 값은 임의로 만들어 쓰지 않는다. `—`는 해당 모드 entry가 원본에 없다는 뜻이다. 모드 이름의 `[U+0008]`는 원본 제어문자를 가독성 있게 표기한 것이다.

동일 값도 원본 variable key를 보존해 병합 여부를 판단한다. 특히 guide 파일의 과거/신규 collection을 분리한다.

## Color — 1:33

- collection key: `9023bf9125641229eb50f7127eed620e2b5a60e8`
- 모드 식별자: `Light=11229:5`, `Dark=11486:7`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `Gray/50` | `1:34` | COLOR | #F7F8FAFF | #1D1E21FF | `b9cb8bd5ab54494f9be9bc03de769aefa5d2b7fb` |
| `GrayAlpha/100` | `1:35` | COLOR | #1314171A | #FFFFFF1A | `96d49b83cb8bbd6d11df0a3c7d7b50d13746f497` |
| `Static/white-primary` | `1:80` | COLOR | #FFFFFFFF | #FFFFFFFF | `6bfc94d0d851b02ede93cf75e993c95e98159506` |
| `Miscellaneous/Charging/normal` | `67:5026` | COLOR | #00DB25FF | #00DB25FF | `59ce862b9f7fe786b3b0cec77f7f026d992a8ab3` |
| `Miscellaneous/Charging/deep` | `67:5027` | COLOR | #00B975FF | #00B975FF | `ad4a67d8c2f23679a49c442c4f59aef80b042d83` |
| `Gray/00` | `67:5029` | COLOR | #FFFFFFFF | #131417FF | `c45206806997c76b79400abcd65b35bec26dcb85` |
| `Miscellaneous/Textfields/background` | `67:5030` | COLOR | #FFFFFFFF; alias → Gray/00 @67:5029 | #131417FF; alias → Gray/00 @67:5029 | `9857ad1dcd5ed921fb413170c48e553848bfcc43` |
| `Feature/Media/radio-primary` | `67:5068` | COLOR | #C911E7FF | #C911E7FF | `fdb1fe1c0c2b35a94566fa181075303394b5dc63` |
| `Feature/Media/music-primary` | `67:5069` | COLOR | #4781FFFF | #4781FFFF | `d74ee24502dcf82791c42ff9300d9f25dd04d48f` |
| `Button/Call/accept-normal` | `67:5073` | COLOR | #32B957FF | #3BD665FF | `76fd6765b2b1ede9791d6d600116ab46447348db` |
| `Button/Call/accept-pressed` | `67:5074` | COLOR | #279E47FF | #2DB752FF | `7085245927e7ff8d1e563f742f12d75ead4ca414` |
| `Button/Call/end-normal` | `67:5075` | COLOR | #FE3D16FF | #FF4C28FF | `9df8e14cde15e6031a6656b8727ea4ae8e8606e6` |
| `Button/Call/end-pressed` | `67:5076` | COLOR | #E73612FF | #DF4323FF | `67cc76041d44679a6fcb32e85ebce013504c1fc2` |
| `Surface/container` | `67:5078` | COLOR | #FFFFFFFF; alias → Gray/00 @67:5029 | #1D1E21FF; alias → Gray/50 @1:34 | `25a94f09c1d4c3e932d3cdff37b741ba6f69724e` |
| `Informative/active` | `67:5079` | COLOR | #02C265FF | #00E074FF | `80d0db572b2539444873c325cce6c6632f56db15` |
| `Miscellaneous/Switch/background-on` | `67:5080` | COLOR | #02C265FF; alias → Informative/active @67:5079 | #00E074FF; alias → Informative/active @67:5079 | `987b71d2fd731c47a2a0d1486c342285c7dbfe1d` |
| `Gray/900` | `67:5083` | COLOR | #131417FF | #FFFFFFFF | `b6f044d34948cb0598081f00ef9957daea7fa87c` |
| `Miscellaneous/Switch/button-on` | `67:5084` | COLOR | #FFFFFFFF; alias → Gray/00 @67:5029 | #FFFFFFFF; alias → Gray/900 @67:5083 | `a52562ec387ffbf3cbb6ffc56260486992cb0a64` |
| `Gray/400` | `67:5085` | COLOR | #A4A8AEFF | #A4A8AEFF | `f0668664ee9ad5edcdcd95bae9c15e68e7975999` |
| `Miscellaneous/Switch/button-off` | `67:5086` | COLOR | #FFFFFFFF; alias → Gray/00 @67:5029 | #A4A8AEFF; alias → Gray/400 @67:5085 | `4d23f9d710370ae78c4add69fab0f2923b1950e7` |
| `GrayAlpha/200` | `67:5087` | COLOR | #13141733 | #FFFFFF33 | `6401daa25d3e77240abea66e9fa3d22c5d8ca80c` |
| `Miscellaneous/Switch/button-disabled` | `67:5088` | COLOR | #FFFFFFFF; alias → Gray/00 @67:5029 | #FFFFFF33; alias → GrayAlpha/200 @67:5087 | `cdcbc7c93b20ef8720f107e7582f26e7138c205d` |

## Primitives — 1:4750

- collection key: `d1c4e94e97251edc9ccca01d4029eb2a423be263`
- 모드 식별자: `Value=7160:0`

| Token | ID | Type | Value | Key |
| --- | --- | --- | --- | --- |
| `Color/Base/Black` | `1:4751` | COLOR | #000000FF | `f21a0b8235beef9c3daf05b4c6450acb96cd1a1e` |
| `Color/Base/White` | `1:4752` | COLOR | #FFFFFFFF | `074abebd3a33e42ab85fa5b7a658b12cafe8c43e` |
| `Spacing/spacing-07` | `1:4755` | FLOAT | 32 | `ac3a386b9ab20fb59cc180ecf40ae780a48a1f53` |
| `Spacing/spacing-03` | `1:4756` | FLOAT | 8 | `a3f7db78ec35555d253cf3ae91e94d523238f1f6` |
| `Spacing/spacing-04` | `1:4765` | FLOAT | 12 | `1a61c8cace7a0ef77492c3a39d35acefb3874f22` |
| `Color/Cool Gray/200` | `1:4766` | COLOR | #C3C9D1FF | `ee7a82d7302a78af26fd1bef28301c91f07e21e4` |
| `Color/Cool Gray/700` | `1:4767` | COLOR | #343B45FF | `3a2060fdbd43ce94b4abbedb0e19f7f17ed498f0` |
| `Color/Cool Gray/500` | `1:4769` | COLOR | #626D7CFF | `1faf79425b0a191727b472c8130f1208b6d4974d` |
| `Color/Cool Gray/300` | `1:4813` | COLOR | #A2ABB8FF | `9b354e3c3e9a765b8aa7915a877177a0ab699abf` |
| `Color/Cool Gray/100` | `1:4815` | COLOR | #E2E5EBFF | `f6261df81ac4ea8d913ebe2b33894b2651d8cae7` |
| `Color/Cool Gray/800` | `1:4816` | COLOR | #22262EFF | `4b698749c6e0d3c70b17ae9d89e26d36adec3dc1` |
| `Spacing/spacing-05` | `67:7554` | FLOAT | 16 | `03085e454551559891fe75021089d9e1cbaacc92` |

## [Theme] ◑ Color — 1:4753

- collection key: `47e7fe66e5dd0dd30a429fcbd8f240f3726bcce0`
- 모드 식별자: `Light=7160:2`, `Dark=7160:3`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `Text/text-primary` | `1:4754` | COLOR | #000000FF; alias → Color/Base/Black @1:4751 | #FFFFFFFF; alias → Color/Base/White @1:4752 | `becf4743e4fdfa711c7d8a6109c34580e628e706` |
| `Icon/icon-primary` | `1:4757` | COLOR | #000000FF; alias → Color/Base/Black @1:4751 | #FFFFFFFF; alias → Color/Base/White @1:4752 | `ae7b3abb05a7f0bcdcbc9488638a04a8f7999024` |
| `Border/border-primary` | `1:4768` | COLOR | #C3C9D1FF; alias → Color/Cool Gray/200 @1:4766 | #343B45FF; alias → Color/Cool Gray/700 @1:4767 | `91e9facd4ae08a254add7ecaf431bec0c36cb48f` |
| `Icon/icon-secondary` | `1:4770` | COLOR | #626D7CFF; alias → Color/Cool Gray/500 @1:4769 | #626D7CFF; alias → Color/Cool Gray/500 @1:4769 | `5ab113e4019fa4deeb532b8b249c1cdf4efbe5c2` |
| `Text/text-secondary` | `1:4772` | COLOR | #626D7CFF; alias → Color/Cool Gray/500 @1:4769 | #626D7CFF; alias → Color/Cool Gray/500 @1:4769 | `6177e9bc471cc7919c4c48797aae4e18b5938ab3` |
| `Text/text-primary-muted` | `1:4814` | COLOR | #A2ABB8FF; alias → Color/Cool Gray/300 @1:4813 | #343B45FF; alias → Color/Cool Gray/700 @1:4767 | `3f62510914a4bdf83c121e257d9aff87589a7c69` |
| `Border/border-primary-muted` | `1:4817` | COLOR | #E2E5EBFF; alias → Color/Cool Gray/100 @1:4815 | #22262EFF; alias → Color/Cool Gray/800 @1:4816 | `d36ee32e52a98aa961e5f078780f4c85a2a4abbc` |

## Color — 1:5956

- collection key: `d1b3a98d537410aa1467789e6193a211c8ecf60f`
- 모드 식별자: `Light=11229:5`, `Dark=11486:7`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `Gray/900` | `1:5957` | COLOR | #131417FF | #FFFFFFFF | `c443d3c132aa0ba004a5fd352a8bd38cce9af737` |
| `Icon/gray-primary` | `1:5958` | COLOR | #131417FF; alias → Gray/900 @1:5957 | #FFFFFFFF; alias → Gray/900 @1:5957 | `8cc2324bb0285e73bc74fd9d5a3e1051e1b79c84` |

## Color — 1:6087

- collection key: `13cebf90018908e1094087593ce1e05b42999698`
- 모드 식별자: `Light=11229:5`, `Dark=11486:7`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `Regulation/blue` | `1:6088` | COLOR | #0064FFFF | #0082FFFF | `581cdbb7973a050616f494a36feb864ed83d5ca8` |
| `Regulation/red` | `1:6089` | COLOR | #F62E24FF | #FF4339FF | `fa4a47e1c979a4aedbc23ac3489eacd76663b62e` |
| `Regulation/orange` | `1:6090` | COLOR | #FF8A00FF | #FF8A00FF | `aae13c79f4acd8dc6daa9089022b0ed29b1cb47e` |
| `Gray/900` | `1:6091` | COLOR | #131417FF | #FFFFFFFF | `d8f4800ac4b0bd1eaacbaf1d8d3ed3897965c9b0` |
| `Icon/gray-primary` | `1:6092` | COLOR | #131417FF; alias → Gray/900 @1:6091 | #FFFFFFFF; alias → Gray/900 @1:6091 | `a8d1c1df5608913ea0778f6d9a540b00d66d2f6f` |
| `Regulation/green` | `1:6093` | COLOR | #00BA13FF | #55F165FF | `742640cbac2ab32a70128c8dfe256e6cf534e639` |
| `_Feature/Driving/Normal/Alert` | `1:6094` | COLOR | #FF8A00FF | #FF8A00FF | `0ef3d7f3362a51267df9745cf0c657b88e2d1255` |
| `_Feature/Driving/Normal/Warning` | `1:6096` | COLOR | #FFA133FF | #FFA133FF | `edfa7574906003b6b54ee2f9a41a183c7b53ad16` |
| `Gray/00` | `1:6097` | COLOR | #FFFFFFFF | #131417FF | `6fdfc9ac9e3a75866c9d0c29d25663662956164a` |
| `Icon/white-primary` | `1:6098` | COLOR | #FFFFFFFF; alias → Gray/00 @1:6097 | #131417FF; alias → Gray/00 @1:6097 | `5e536f06ad06e7bd6598578443fdbe557f00b142` |
| `_Feature/Driving/Normal/Positive` | `1:6099` | COLOR | #00BA13FF | #00BA13FF | `67495a84319f85d4ca56ae89c675579f525c2f86` |
| `_Legacy/Scale/White/White` | `1:6100` | COLOR | #FFFFFFFF | #000000FF | `f5c7ccaf6949786960e6d7e73fea2cd2e8bc4702` |
| `Informative/autonomous driving` | `1:6102` | COLOR | #5A46FAFF | #6A57FFFF | `43a813451bd4c73139948aaee547a33e0f83845d` |
| `System/Grayscale/Opaque/White` | `1:6103` | COLOR | #FFFFFFFF | #FFFFFFFF | `3dc28b667dc94703ab1c6945b4fb346ef7080a9b` |
| `System/Grayscale/Opaque/Black` | `1:6104` | COLOR | #000000FF | #000000FF | `6d7ce7fe25852b013b10de17ac4833dea3d06bed` |
| `_Feature/Driving/Normal/Danger` | `1:6105` | COLOR | #FF2E00FF | #FF2E00FF | `9271d6c09e6d58dd4eee5314472e19cf6d189f24` |
| `_Legacy/Scale/Black/Black` | `67:14533` | COLOR | #000000FF | #FFFFFFFF | `36bf9c50229406254cb6091ad1cb5c255f2335be` |
| `Button/Call/end-normal` | `67:14534` | COLOR | #FE3D16FF | #FF4C28FF | `bea07f0bd31ad14850094d19edab388db3d901ee` |
| `_Legacy/Solid/Cool/900` | `67:14535` | COLOR | #1B1D21FF | #F0F1F5FF | `99e763dc35508b234d758fd1b3c327dcf852bb5d` |
| `Button/Call/accept-normal` | `67:14536` | COLOR | #32B957FF | #3BD665FF | `b71c4361ee2580c4842b81a7d0fe924d1e52be20` |
| `Icon/gray-tertiary` | `67:14537` | COLOR | #131417A3 | #FFFFFFA3 | `f007523cd1439112d742b133959def9b61dff613` |
| `Icon/gray-quaternary` | `67:14580` | COLOR | #13141752 | #FFFFFF52 | `73e28b6ba64acea67053a2ec77614aeb2dbfa8a2` |

## Color — 67:15011

- collection key: `3b4c36d320aebb69b50891fbf4c5ea88a88a017f`
- 모드 식별자: `Light=11229:5`, `Dark=11486:7`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `color/basic/00` | `1:6455` | COLOR | #FFFFFFFF | #131417FF | `e97c0d271cf16ffebac08dd554144f4ecd54f4f5` |
| `color/basic/900` | `1:6456` | COLOR | #131417FF | #FFFFFFFF | `846cb6451492d1ff8f934894b5425b0c254b8070` |
| `static/light/100` | `67:15008` | COLOR | #FFFFFFFF | #FFFFFFFF | `d4951cf9d4f4d09abd9b0329943ec0765d96ad1a` |
| `static/dark/100` | `67:15009` | COLOR | #131417FF | #131417FF | `3a596029a132077d10a70214b403b266dfc26827` |
| `icon/light/primary` | `67:15010` | COLOR | #FFFFFFFF; alias → static/light/100 @67:28963 | #131417FF; alias → static/dark/100 @67:28962 | `613ebec7e109bcbf2a5a0d973fd08393a6d97f9b` |
| `icon/dark/primary` | `67:22192` | COLOR | #131417FF; alias → static/dark/100 @67:28962 | #FFFFFFFF; alias → static/light/100 @67:28963 | `c47339d1c81fe901c5f505df9394d01f8f5534e7` |
| `_Legacy/Scale/Black/Black` | `67:28961` | COLOR | #000000FF | #FFFFFFFF | `afa71b827071692576ba14016c33eef0b6489f5a` |
| `static/dark/100` | `67:28962` | COLOR | #131417FF | #131417FF | `3a596029a132077d10a70214b403b266dfc26827` |
| `static/light/100` | `67:28963` | COLOR | #FFFFFFFF | #FFFFFFFF | `d4951cf9d4f4d09abd9b0329943ec0765d96ad1a` |
| `icon/dark/primary` | `67:28964` | COLOR | #131417FF; alias → static/dark/100 @67:28962 | #FFFFFFFF; alias → static/light/100 @67:28963 | `c47339d1c81fe901c5f505df9394d01f8f5534e7` |

## ivi — 2:9522

- collection key: `d70340ec3bfa133242f15bacf1c4d764ed7ab844`
- 모드 식별자: `Eng=5958:0`, `Kor=12430:0`

| Token | ID | Type | Eng | Kor | Key |
| --- | --- | --- | --- | --- | --- |
| `New group/ivi_radio` | `2:9523` | STRING | {"textValue":"Radio"} | {"textValue":"라디오"} | `79b6221a8f521da2523a09c01fa38ad293432c94` |

## Color — 2:15157

- collection key: `994235267138968c297762f0578b4dfddb3b8126`
- 모드 식별자: `Light=11229:5`, `Dark=11486:7`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `static/dark/100` | `2:15158` | COLOR | #131417FF | #131417FF | `1e07d10f0e96dc15d2de8377cad3e3dafc187667` |
| `static/light/100` | `2:15159` | COLOR | #FFFFFFFF | #FFFFFFFF | `4c7bc411bf601f05974f8697deb6c99065532663` |
| `icon/dark/primary` | `2:15160` | COLOR | #131417FF; alias → static/dark/100 @2:15158 | #FFFFFFFF; alias → static/light/100 @2:15159 | `95c481151256faaafdee30ab9b4fff009de006b5` |
| `basic/00` | `67:4943` | COLOR | #FFFFFFFF | #131417FF | `4f98376b8f09d0d5b168735f5b387f679ab6a46f` |
| `alpha/dark/50` | `67:4944` | COLOR | #1314170D | #FFFFFF0D | `3398e4e3a2e25d1d9581f69ac838383d62cdc87d` |
| `divider/primary` | `67:4945` | COLOR | #1314170D; alias → alpha/dark/50 @67:4944 | #FFFFFF0D; alias → alpha/dark/50 @67:4944 | `af17ff00f294e10a537b38a9e4eb3d299eadbdb1` |
| `basic/50` | `67:4971` | COLOR | #F7F8FAFF | #1D1E21FF | `e622d5d06eb9cde829ad024f723719f248359b6a` |
| `basic/100` | `67:4972` | COLOR | #EDEEF2FF | #313236FF | `effa651fe57cdac371634ce89463e0c0c22866f5` |
| `basic/200` | `67:4973` | COLOR | #E0E1E6FF | #44464EFF | `75440b021474fe1f428ddb2630e9c04ce9acad71` |
| `basic/300` | `67:4974` | COLOR | #C7C9CEFF | #686A72FF | `003539e078df5c4f00216d927c3e991c6fe9340e` |
| `basic/400` | `67:4975` | COLOR | #A4A8AEFF | #A4A8AEFF | `8096a8f9035cf1066f3c5c9b22e76dc9f4fc7428` |
| `basic/500` | `67:4976` | COLOR | #686A72FF | #C7C9CEFF | `ef6e5fbdb84e8fa8112d919152ab04d601b33983` |
| `basic/600` | `67:4977` | COLOR | #44464EFF | #E0E1E6FF | `413d29bb7f4b84a10051c2ae8fb39a8c88da34bb` |
| `basic/700` | `67:4978` | COLOR | #313236FF | #EDEEF2FF | `362370a488768bb9519f05254f6d03bfdf1142c5` |
| `basic/800` | `67:4979` | COLOR | #1D1E21FF | #F7F8FAFF | `471644c46d60d9246701255da74c5f0c4fb27015` |
| `basic/900` | `67:4980` | COLOR | #131417FF | #FFFFFFFF | `b1e228e792fc8c68b905f66e7e4f2b375897311c` |
| `alpha/light/50` | `67:4981` | COLOR | #FFFFFF0D | #1314170D | `e0ace82938e4b665c754e3e47c3a95116bec2bd0` |
| `alpha/light/200` | `67:4982` | COLOR | #FFFFFF33 | #13141733 | `ae9c047304b09f4e241975c68a222c1a40dec806` |
| `alpha/light/100` | `67:4983` | COLOR | #FFFFFF1A | #1314171A | `d96856e05cce121b1183a27ee6264f2e35fda775` |
| `alpha/light/300` | `67:4984` | COLOR | #FFFFFF4D | #1314174D | `1f0a62d5f3716b72d25e489b89116f2daad74735` |
| `alpha/light/400` | `67:4985` | COLOR | #FFFFFF66 | #13141766 | `12c00d132c3943c8667279509d86082149f4fb69` |
| `alpha/light/500` | `67:4986` | COLOR | #FFFFFF80 | #13141780 | `46e020e2d4d87d3967aabe617823fe481b0a32bd` |
| `alpha/dark/100` | `67:4987` | COLOR | #1314171A | #FFFFFF1A | `47fb07584fd838bf3014d8d81889e9732ca7acec` |
| `alpha/dark/200` | `67:4988` | COLOR | #13141733 | #FFFFFF33 | `fcda5f912e3b3c16b92398226a431963f80ddf50` |
| `alpha/dark/300` | `67:4989` | COLOR | #1314174D | #FFFFFF4D | `d5354b16f8b249e49f1d0e7b4a5b10c15237fd74` |
| `alpha/dark/400` | `67:4990` | COLOR | #13141766 | #FFFFFF66 | `e146ed87bd706553c5231c40b2edd0bc6d153f8f` |
| `alpha/dark/500` | `67:4991` | COLOR | #13141780 | #FFFFFF80 | `3054f2fd4ab571924588b6aba50db84174bf91f0` |
| `static/light/200` | `67:4992` | COLOR | #FFFFFFD6 | #FFFFFFD6 | `53126f4229f0ce3c3a7cf7a85b97ca6e39fe62f8` |
| `static/light/300` | `67:4993` | COLOR | #FFFFFFA3 | #FFFFFFA3 | `d9c1942a19cd2ba9476a8d677f71692b283fedd7` |
| `static/light/400` | `67:4994` | COLOR | #FFFFFF52 | #FFFFFF52 | `5a51c4144648a071f6c2feae46b6885f7905bae6` |
| `static/dark/200` | `67:4995` | COLOR | #131417D6 | #131417D6 | `b5bc55e2f8807ce2042818c57583eb6ff879a987` |
| `static/dark/300` | `67:4996` | COLOR | #131417A3 | #131417A3 | `5350c64259b80b4d31f1b8a31d68c29bddaf0e39` |
| `static/dark/400` | `67:4997` | COLOR | #13141752 | #13141752 | `997758a4f811828ed5f1c564efac3d06dccbbe09` |
| `informative/autonomous_driving` | `67:5000` | COLOR | #5A46FAFF | #6A57FFFF | `b95f1ac8f39bc0153ba9c573bc534d75d51bbe35` |
| `background/popup` | `67:5014` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #313236FF; alias → basic/100 @67:4972 | `1338fe23523cc3e3fede2bde2e1a59569dfe4ec5` |
| `background/primary` | `67:5015` | COLOR | #F7F8FAFF; alias → basic/50 @67:4971 | #1D1E21FF; alias → basic/50 @67:4971 | `8663a8b754bb48add9afa8ead97d54221073f0e2` |
| `background/secondary` | `67:5016` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #131417FF; alias → basic/00 @67:4943 | `f43b447f68fcb23ec2c571e36588c818a18774ac` |
| `dim/dark/primary` | `67:5017` | COLOR | #1314170D; alias → alpha/dark/50 @67:4944 | #FFFFFF0D; alias → alpha/dark/50 @67:4944 | `bbcf49cac6fb49b521b15f913d800b4274a3338f` |
| `dim/dark/secondary` | `67:5018` | COLOR | #1314171A; alias → alpha/dark/100 @67:4987 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `7efc94315de7230448d83821ae8987b286bbfe57` |
| `dim/dark/tertiary` | `67:5019` | COLOR | #13141733; alias → alpha/dark/200 @67:4988 | #FFFFFF33; alias → alpha/dark/200 @67:4988 | `707875638556be9cd0c4d90576d080183c519ec6` |
| `dim/light/primary` | `67:5020` | COLOR | #FFFFFF80; alias → alpha/light/500 @67:4986 | #13141780; alias → alpha/light/500 @67:4986 | `29c158ea4dba66c67e91bdd16b804d3d9419c509` |
| `dim/light/secondary` | `67:5021` | COLOR | #FFFFFF66; alias → alpha/light/400 @67:4985 | #13141766; alias → alpha/light/400 @67:4985 | `63bba7c95a5cdce3b662beb97e00e19c81e562c6` |
| `dim/light/tertiary` | `67:5022` | COLOR | #FFFFFF4D; alias → alpha/light/300 @67:4984 | #1314174D; alias → alpha/light/300 @67:4984 | `98d00cd9f257a07aec10d9f288ecdb327c941f94` |
| `divider/secondary` | `67:5023` | COLOR | #1314171A; alias → alpha/dark/100 @67:4987 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `43d4f10c50226b2acac904f7c6cd14d10d6920d0` |
| `divider/tertiary` | `67:5024` | COLOR | #13141733; alias → alpha/dark/200 @67:4988 | #FFFFFF33; alias → alpha/dark/200 @67:4988 | `d291b6dcba054edbe3566688b14d4017dc78abef` |
| `driving_view/gradient_start` | `67:5028` | COLOR | #FFFFFF00 | #13141700 | `28eb804ca701628ab0e9bbc3868a2786d4344f04` |
| `text/dark/primary` | `67:5031` | COLOR | #131417FF; alias → static/dark/100 @2:15158 | #FFFFFFFF; alias → static/light/100 @2:15159 | `f928e3fcfa99fee2c099909ce794cad7fde4e328` |
| `text/dark/secondary` | `67:5032` | COLOR | #131417D6; alias → static/dark/200 @67:4995 | #FFFFFFD6; alias → static/light/200 @67:4992 | `3c8fc343a92e12738bedb1fdd16b44c65f045d64` |
| `icon/dark/secondary` | `67:5033` | COLOR | #131417D6; alias → static/dark/200 @67:4995 | #FFFFFFD6; alias → static/light/200 @67:4992 | `54d7f16d4dc8ef654c565420ac213d0cdf04f8ac` |
| `text/dark/tertiary` | `67:5034` | COLOR | #131417A3; alias → static/dark/300 @67:4996 | #FFFFFFA3; alias → static/light/300 @67:4993 | `fba7bba198b151202aedf827efe6e6596334b173` |
| `icon/dark/tertiary` | `67:5035` | COLOR | #131417A3; alias → static/dark/300 @67:4996 | #FFFFFFA3; alias → static/light/300 @67:4993 | `02cf653fb2a3f63a9acd7af255de48d4bdf3e658` |
| `text/dark/quaternary` | `67:5036` | COLOR | #13141752; alias → static/dark/400 @67:4997 | #FFFFFF52; alias → static/light/400 @67:4994 | `96f6c74055c01349e285a2f6c07892ec280966ea` |
| `icon/dark/quaternary` | `67:5037` | COLOR | #13141752; alias → static/dark/400 @67:4997 | #FFFFFF52; alias → static/light/400 @67:4994 | `28493bf153fef8c7b72629afdc820ab9ab4a3eec` |
| `text/light/primary` | `67:5038` | COLOR | #FFFFFFFF; alias → static/light/100 @2:15159 | #131417FF; alias → static/dark/100 @2:15158 | `3fa8f4bff01b6d0a672785eb95f470dbb5d9a3a7` |
| `icon/light/primary` | `67:5039` | COLOR | #FFFFFFFF; alias → static/light/100 @2:15159 | #131417FF; alias → static/dark/100 @2:15158 | `07b74843f3c138433ea738761406d9fde8840f7e` |
| `text/light/secondary` | `67:5040` | COLOR | #FFFFFFD6; alias → static/light/200 @67:4992 | #131417D6; alias → static/dark/200 @67:4995 | `e951025163f8e8948ea5cf5eec4126d6f39fd5a7` |
| `icon/light/secondary` | `67:5041` | COLOR | #FFFFFFD6; alias → static/light/200 @67:4992 | #131417D6; alias → static/dark/200 @67:4995 | `888cc27764030f6fa554d6cb2fcd7f6e02d678ff` |
| `text/light/tertiary` | `67:5042` | COLOR | #FFFFFFA3; alias → static/light/300 @67:4993 | #131417A3; alias → static/dark/300 @67:4996 | `b02411238791e8bd52afb51710888b58dc94f56a` |
| `icon/light/tertiary` | `67:5043` | COLOR | #FFFFFFA3; alias → static/light/300 @67:4993 | #131417A3; alias → static/dark/300 @67:4996 | `45feb9708adc3e9d0fd4aca77256142820330633` |
| `text/light/quaternary` | `67:5044` | COLOR | #FFFFFF52; alias → static/light/400 @67:4994 | #13141752; alias → static/dark/400 @67:4997 | `f6f55cdf43e82484a4448e41c93f442613b055ac` |
| `icon/light/quaternary` | `67:5045` | COLOR | #FFFFFF52; alias → static/light/400 @67:4994 | #13141752; alias → static/dark/400 @67:4997 | `8c2b8fd82b05335540e0b2f59a8aaef80abdea07` |
| `keyboard/normal/primary_normal` | `67:5046` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #686A72FF; alias → basic/300 @67:4974 | `1935fb096bafd12445fa50f8c0825ce1586ba590` |
| `keyboard/normal/primary_pressed` | `67:5047` | COLOR | #EDEEF2FF; alias → basic/100 @67:4972 | #44464EFF; alias → basic/200 @67:4973 | `589bfb1066eabb42598b9e53cb71522df458d8d0` |
| `keyboard/normal/secondary_normal` | `67:5048` | COLOR | #C7C9CEFF; alias → basic/300 @67:4974 | #44464EFF; alias → basic/200 @67:4973 | `f0429ff7dff26b156de36f9c4d057270bddd64b1` |
| `keyboard/normal/secondary_pressed` | `67:5049` | COLOR | #A4A8AEFF; alias → basic/400 @67:4975 | #686A72FF; alias → basic/300 @67:4974 | `e2d2a3c60285ef213432c3af61a2af17e3a4d9ca` |
| `keyboard/normal/active_normal` | `67:5050` | COLOR | #44464EFF; alias → basic/600 @67:4977 | #686A72FF; alias → basic/300 @67:4974 | `f8e25ae2349eb69a125853853079b1b79166f479` |
| `keyboard/normal/active_pressed` | `67:5051` | COLOR | #313236FF; alias → basic/700 @67:4978 | #44464EFF; alias → basic/200 @67:4973 | `26efad8fd38607109ffbf9ed9a643672f956110d` |
| `keyboard/normal/accents_normal` | `67:5052` | COLOR | #44464EFF; alias → basic/600 @67:4977 | #C7C9CEFF; alias → basic/500 @67:4976 | `f7df418c73cbc00c64e954c0fddfbd75024a9ba0` |
| `keyboard/normal/accents_pressed` | `67:5053` | COLOR | #313236FF; alias → basic/700 @67:4978 | #A4A8AEFF; alias → basic/400 @67:4975 | `50498952fd11cf95f989a5a635c4607bec34854b` |
| `keyboard/normal/background` | `67:5054` | COLOR | #E0E1E6FF; alias → basic/200 @67:4973 | #313236FF; alias → basic/100 @67:4972 | `b58c8498ec48293a85af15a808b831cf17233b2e` |
| `keyboard/static/primary_normal` | `67:5055` | COLOR | #686A72FF; alias → basic/500 @67:4976 | #686A72FF; alias → basic/300 @67:4974 | `b0d48f7cc2b8f43135e2421ec0fdfe38b9dfd724` |
| `keyboard/static/primary_pressed` | `67:5056` | COLOR | #44464EFF; alias → basic/600 @67:4977 | #44464EFF; alias → basic/200 @67:4973 | `b95e47e85f1f19b7c9da7e680d811c7da16598fe` |
| `keyboard/static/secondary_normal` | `67:5057` | COLOR | #44464EFF; alias → basic/600 @67:4977 | #44464EFF; alias → basic/200 @67:4973 | `f98053865787c3040c8ad5939633e7d91b4d0354` |
| `keyboard/static/secondary_pressed` | `67:5058` | COLOR | #686A72FF; alias → basic/500 @67:4976 | #686A72FF; alias → basic/300 @67:4974 | `f9ae373f5e6830b5fa82ac26537e965b734c1781` |
| `keyboard/static/active_normal` | `67:5059` | COLOR | #686A72FF; alias → basic/500 @67:4976 | #686A72FF; alias → basic/300 @67:4974 | `d35bf2baef0c145c05bf0796a0227ef4ac084520` |
| `keyboard/static/active_pressed` | `67:5060` | COLOR | #313236FF; alias → basic/700 @67:4978 | #44464EFF; alias → basic/200 @67:4973 | `fd36d26a65db8d6e801a199743ce29620f020a7a` |
| `keyboard/static/accents_normal` | `67:5061` | COLOR | #C7C9CEFF; alias → basic/300 @67:4974 | #C7C9CEFF; alias → basic/500 @67:4976 | `cb56a4c1b1d217d71226dc87628c3e0be1e54cd9` |
| `keyboard/static/accents_pressed` | `67:5062` | COLOR | #A4A8AEFF; alias → basic/400 @67:4975 | #A4A8AEFF; alias → basic/400 @67:4975 | `28aefac6e0141aae75a336436494ccb87a994032` |
| `keyboard/static/background` | `67:5063` | COLOR | #131417FF; alias → basic/900 @67:4980 | #131417FF; alias → basic/00 @67:4943 | `d23e846fd2a07c51e22ba3bf0220abff199d4247` |
| `keyboard/static/icon_light` | `67:5064` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #FFFFFFFF; alias → basic/900 @67:4980 | `06828626ae7c1e0804f7ef3ce27219064124681e` |
| `keyboard/static/icon_dark` | `67:5065` | COLOR | #131417FF; alias → basic/900 @67:4980 | #131417FF; alias → basic/00 @67:4943 | `d79b9152ba1000e3cb339f4b6abad1c9f5b86387` |
| `keyboard/static/icon_disabled` | `67:5066` | COLOR | #FFFFFF1A; alias → alpha/light/100 @67:4983 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `a9799806cfa201ba6b7a9b45b52a8133fed8a95a` |
| `keyboard/static/text` | `67:5067` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #FFFFFFFF; alias → basic/900 @67:4980 | `ab3e529e84f9657b4e42fd5742f181c36a364ff2` |
| `media/radio_gradient_start` | `67:5070` | COLOR | #FFFFFF00 | #1D1E2100 | `bf0d84d30afeddbeb48976c735cee66858cda8a5` |
| `media/radio_gradient_end` | `67:5071` | COLOR | #FFFFFFFF | #1D1E21FF | `a0c15aa46039fa37645e7c3e25666eeae6c0b4bf` |
| `overlay/default` | `67:5072` | COLOR | #13141733; alias → alpha/dark/200 @67:4988 | #13141780; alias → alpha/light/500 @67:4986 | `1fe22181337930146eb8d68319174b3a2658e677` |
| `switch/off` | `67:5081` | COLOR | #1314174D; alias → alpha/dark/300 @67:4989 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `a668d6e3c0cfb56bf12f9151bc09992ca32c83df` |
| `switch/disabled` | `67:5082` | COLOR | #1314171A; alias → alpha/dark/100 @67:4987 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `7ae7a3597ae276d7ea564a7c4cf0b2856ec64880` |
| `regulation/blue` | `67:5089` | COLOR | #0064FFFF | #0082FFFF | `163aaaf39e9024d8390bbd35d77fccea10449e97` |
| `regulation/red` | `67:5091` | COLOR | #F62E24FF | #FF4339FF | `404985165abd2e5ce68b51d802becbfe18d45f7d` |
| `_System/Brand/Primary/Normal` | `67:15012` | COLOR | #5A46FAFF | #6A57FFFF | `faf8c015eef01980dbd5623739d81c5e533f19b0` |
| `_Legacy/Scale/Black/Black` | `67:15062` | COLOR | #000000FF | #FFFFFFFF | `1150eddb763d084a81cce70f31b2d0fa7db0e526` |
| `_Legacy/Scale/White/White` | `67:15071` | COLOR | #FFFFFFFF | #000000FF | `70b12d4e82f08387d4271e6ffafc825b7cea85fd` |
| `_Legacy/Solid/Warm/300` | `67:15072` | COLOR | #C8C8C8FF | #353535FF | `1844d3396f04bed9dad3ab2b541fd4b524b96c57` |
| `informative/active` | `67:21959` | COLOR | #02C265FF | #00E074FF | `0544005de32393d44dd987d02a2816878ef7c66a` |
| `button/basic/enabled` | `67:22038` | COLOR | #1314170D; alias → alpha/dark/50 @67:4944 | #FFFFFF0D; alias → alpha/dark/50 @67:4944 | `a044c728b9a7ba456db380312936055d555c2a9c` |
| `button/basic/pressed` | `67:22108` | COLOR | #1314171A; alias → alpha/dark/100 @67:4987 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `9515b1ed686495354f6638b5717a13003a4a7235` |
| `button/basic/disabled` | `67:22110` | COLOR | #FFFFFF33; alias → alpha/light/200 @67:4982 | #13141733; alias → alpha/light/200 @67:4982 | `cfa48e0b2f19ce63d624329e62f9ba7aabb2ce48` |
| `button/filled/enabled` | `67:22125` | COLOR | #44464EFF; alias → basic/600 @67:4977 | #E0E1E6FF; alias → basic/600 @67:4977 | `e08a55c202cce0a9ccf9699ab56b904f6cf338dc` |
| `button/filled/pressed` | `67:22126` | COLOR | #313236FF; alias → basic/700 @67:4978 | #C7C9CEFF; alias → basic/500 @67:4976 | `9fe853f6b5b1b9109fddd3ab05d11d986a667aee` |
| `button/filled/disabled` | `67:22127` | COLOR | #1314170D; alias → alpha/dark/50 @67:4944 | #FFFFFF0D; alias → alpha/dark/50 @67:4944 | `18d987510225801541b3ab050454d19691533736` |
| `button/switch/enabled` | `67:22164` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #FFFFFF33; alias → alpha/dark/200 @67:4988 | `c4642f382b9682c5e21c15576c627438a86f1a4c` |
| `button/switch/pressed` | `67:22165` | COLOR | #FFFFFF80; alias → alpha/light/500 @67:4986 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `50fe683b33868dabfdedef67feca5367b52e16ab` |
| `button/switch/disabled` | `67:22166` | COLOR | #FFFFFF4D; alias → alpha/light/300 @67:4984 | #1314174D; alias → alpha/light/300 @67:4984 | `bfb65dafacdad59ad063cfc5a81b34537fb9efae` |
| `informative/positive` | `67:22170` | COLOR | #0064FFFF | #0082FFFF | `fc7cbd576fed110e87ad38960df155c67740ff97` |
| `surface/accent` | `67:22187` | COLOR | #E0E1E6FF; alias → basic/200 @67:4973 | #44464EFF; alias → basic/200 @67:4973 | `593af766359b621984bab5099e6d7ba6eb147ae2` |
| `phone/accept_normal` | `67:22189` | COLOR | #32B957FF | #3BD665FF | `ef8e89e40db4bf31f5d6a0dc01f3c499ea9abed5` |
| `phone/end_normal` | `67:22190` | COLOR | #FE3D16FF | #FF4C28FF | `2a2ad45f4a3a817534b17149c5f569cbd49fe441` |
| `_Legacy/Solid/Cool/900` | `67:22191` | COLOR | #1B1D21FF | #F0F1F5FF | `cfb9882d581e32c6cd0ad648af7e0397b56c0854` |
| `climate/slider_background` | `67:24331` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #313236FF; alias → basic/100 @67:4972 | `b5582653bc2cff861dfb4df9cbc17fc1644c8d35` |
| `climate/button_border_enabled` | `67:24332` | COLOR | #13141733; alias → alpha/dark/200 @67:4988 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `50ca1e4f3f24ac90b5ec02d9c7783080aed03b9f` |
| `controller/slider/normal` | `67:24397` | COLOR | #13141733; alias → alpha/dark/200 @67:4988 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `57c4e92fe4cd21633ef1c692c1070e9d2d305efb` |
| `controller/slider/knop` | `67:24415` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #FFFFFF4D; alias → alpha/dark/300 @67:4989 | `9bde8bc7146ca0f882a6dd1064365417aab4955f` |
| `Brand/Teritary/Black` | `67:24416` | COLOR | #000000FF; alias → _Legacy/Scale/Black/Black @67:15062 | #000000FF; alias → _Legacy/Scale/White/White @67:15071 | `50a0cc1c959bb5efe673c97a4456e7274b8f8c74` |
| `controller/slider/pressed` | `67:24472` | COLOR | #1314174D; alias → alpha/dark/300 @67:4989 | #FFFFFF33; alias → alpha/dark/200 @67:4988 | `567a064016256b32f554b97f5c87826215cc6806` |
| `controller/stepper_background` | `67:25149` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `10297715441a285b10cdfba045502e2edef5358e` |
| `dropdown/normal` | `67:25520` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #FFFFFF1A; alias → alpha/dark/100 @67:4987 | `ca6198ca8b5c5fa199e02fbaaf2c2612078a6e4c` |
| `surface/basic` | `67:25523` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #1D1E21FF; alias → basic/50 @67:4971 | `b50041ccfeed4620545be749e2dd6299cd5b87b0` |
| `_Feature/Driving/Normal/Positive` | `67:25571` | COLOR | #00BA13FF | #00BA13FF | `3b5b0f2104214979ad00b98adaae1c2acf312304` |
| `System/Grayscale/Opaque/White` | `67:25572` | COLOR | #FFFFFFFF | #FFFFFFFF | `a83afc54b44ac86d02b03cb0e1dcbb67a47e3354` |
| `dropdown/pressed` | `67:25616` | COLOR | #EDEEF2FF; alias → basic/100 @67:4972 | #FFFFFF4D; alias → alpha/dark/300 @67:4989 | `e598e6c906317d47d7ca02809c1bdc0f2f687a1c` |
| `switch/on` | `67:25640` | COLOR | #02C265FF; alias → informative/active @67:21959 | #00E074FF; alias → informative/active @67:21959 | `c5666f792f45b39e938f45342f109d52e1ca5363` |
| `switch/knob_on` | `67:25646` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #FFFFFFFF; alias → basic/900 @67:4980 | `15a3eabc06ef5200c60b262335f5fd852e7df4af` |
| `switch/knob_off` | `67:25647` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #A4A8AEFF; alias → basic/400 @67:4975 | `d112e120d31aec65a9a9cfe0c9dbf34485358297` |
| `switch/knob_disabled` | `67:25648` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #FFFFFF33; alias → alpha/dark/200 @67:4988 | `f20ddf66d9464e0e6f21f90e9f34b8207af89d74` |
| `field/background` | `67:26982` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #131417FF; alias → basic/00 @67:4943 | `2c2fddde52c845e038a9ec59869d25997445d4e2` |
| `field/focused` | `67:27000` | COLOR | #313236FF; alias → basic/700 @67:4978 | #EDEEF2FF; alias → basic/700 @67:4978 | `bcae7a20252492c8d91cce8e79f2f5420f67303d` |
| `surface/high` | `67:27001` | COLOR | #EDEEF2FF; alias → basic/100 @67:4972 | #313236FF; alias → basic/100 @67:4972 | `9ccf38c6edb52a244a1f3f33373f4d03a4acf684` |
| `color/feature/driving_view/mask/subtle_secondary` | `67:29027` | COLOR | #F7F8FAFF; alias → basic/50 @67:4971 | #1D1E21FF; alias → basic/50 @67:4971 | `8ce01bf40ce1ac74a6f58c6c918fbec9785c2f54` |
| `color/feature/driving_view/mask/filled_secondary` | `67:29028` | COLOR | #F7F8FA00 | #1D1E2100 | `9e2873d1a90dcd3e20afd1265583d6a879e1e0f6` |
| `controller/tab_background` | `67:32609` | COLOR | #1314170D; alias → alpha/dark/50 @67:4944 | #FFFFFF0D; alias → alpha/dark/50 @67:4944 | `c2f02edb4f1015c61d5bbfb8c16f393c31214b1e` |
| `gleo/Olf/surface_primary` | `67:33939` | COLOR | #FFFFFFFF; alias → basic/00 @67:4943 | #44464EFF; alias → basic/200 @67:4973 | `b0d5466b340d1a60ae6edbc2baf3fc647dd16d46` |
| `_Legacy/Solid/Cool/500` | `67:33983` | COLOR | #626675FF | #626675FF | `586cbc93532834c220dda611d9be41bb83c1d353` |
| `Common/Empty/Content` | `67:33984` | COLOR | #C8C8C8FF; alias → _Legacy/Solid/Warm/300 @67:15072 | #626675FF; alias → _Legacy/Solid/Cool/500 @67:33983 | `71e0ac65a72bcb73868ddf1632d8836d813cae8f` |

## form_factor — 67:4998

- collection key: `96b6cfc06cdc17ad0e1954ab10b31bf0ffbc32bc`
- 모드 식별자: `connect-s=32062:0`, `connect-l=32257:0`, `connect-w=33219:0`, `[U+0008]connect-waterfall=33235:0`

| Token | ID | Type | connect-s | connect-l | connect-w | [U+0008]connect-waterfall | Key |
| --- | --- | --- | --- | --- | --- | --- | --- |
| `app_market/header/title/height` | `67:4999` | FLOAT | 80 | 70 | 66 | 85 | `abed0bce6d777a5dc468485de37904b3cd4de81a` |
| `buttons/basic/large/gap_horizontal` | `67:21952` | FLOAT | 16 | 14 | 14 | 17 | `2ec0745f2bad5e79ff9ccbf2f3e5a19e64d2ae5a` |
| `buttons/basic/large/padding_horizontal` | `67:21953` | FLOAT | 40 | 35 | 34 | 42 | `2921a2635b2d1fcb19f75f509800f93dad249754` |
| `buttons/basic/large/padding_vertical` | `67:21954` | FLOAT | 16 | 14 | 14 | 17 | `7e2c35291b1a053d01c2aaffad8e82dcec2ed416` |
| `buttons/basic/large/height` | `67:21955` | FLOAT | 100 | 88 | 84 | 106 | `e7a7e4fb81ec07e267d9a4e7652992a9129e4b6f` |
| `buttons/basic/large/radius_top_left` | `67:21956` | FLOAT | 32 | 28 | 27 | 35 | `3bb4c902036a9a4522c56896749b79d22a1c31ed` |
| `buttons/basic/large/min_width` | `67:21957` | FLOAT | 140 | 123 | 116 | 148 | `38365c35f03e453bf8b03b68aa49294d7ae9c9d7` |
| `buttons/text/medium/gap` | `67:21958` | FLOAT | 8 | 7 | 8 | 9 | `9992f331514dffaaf73c81f6b24dee8aa80d4e80` |
| `buttons/icon/medium/width` | `67:21973` | FLOAT | 80 | 70 | 66 | 84 | `eb79974edefd0237fbbd9c38c4e8e4290e380f2b` |
| `buttons/icon/medium/rounded_radius_top_left` | `67:21974` | FLOAT | 20 | 18 | 17 | 22 | `68cedd4e9508e09b86f45d5bff4124998f35ae0a` |
| `buttons/icon/medium/rounded_radius_top_right` | `67:21975` | FLOAT | 20 | 18 | 17 | 22 | `d76e4e53b6d81452479e8e7613711dacd6620d3e` |
| `buttons/icon/medium/rounded_radius_bottom_left` | `67:21976` | FLOAT | 20 | 18 | 17 | 22 | `cce5f59a18c7143c30aa73245bc61f5443674f99` |
| `buttons/icon/medium/rounded_radius_bottom_right` | `67:21977` | FLOAT | 20 | 18 | 17 | 22 | `a9a5cf62a729f0a91db737378c6ca4ad5cc9f9c9` |
| `buttons/icon/circle_radius_top_left` | `67:22034` | FLOAT | 999 | 999 | 999 | 999 | `d0a6fc7ad115d42e1683060e94cc86c7d1e7b7e7` |
| `buttons/icon/circle_radius_top_right` | `67:22035` | FLOAT | 999 | 999 | 999 | 999 | `689d662cd785cee31a28b7cf857afa96a0622964` |
| `buttons/icon/circle_radius_bottom_left` | `67:22036` | FLOAT | 999 | 999 | 999 | 999 | `9fda4545a4fb8a5de0098cafbb8fd55595745d30` |
| `buttons/icon/circle_radius_bottom_right` | `67:22037` | FLOAT | 999 | 999 | 999 | 999 | `904569df25648cde4a8e0231015fbb552df4b692` |
| `buttons/basic/large/icon_sqaure` | `67:22094` | FLOAT | 52 | 46 | 43 | 55 | `1138031ce646b8ad212cf1d702e0cd698741d492` |
| `buttons/basic/disabled_border` | `67:22109` | FLOAT | 2 | 2 | 2 | 3 | `f46ede2c4ff7e8cab20d891ffb006c3b4815d293` |
| `buttons/basic/medium/gap_horizontal` | `67:22111` | FLOAT | 14 | 12 | 12 | 15 | `d1807e06bb980b36bb588bb2a3973d67aa18ffe2` |
| `buttons/basic/medium/padding_horizontal` | `67:22112` | FLOAT | 32 | 28 | 27 | 35 | `724d5d33a776e673db161c9b111382a88035f1e2` |
| `buttons/basic/medium/padding_vertical` | `67:22113` | FLOAT | 16 | 14 | 14 | 17 | `f33ad0e020be7e7e58cef4434397683f96f72e20` |
| `buttons/basic/medium/height` | `67:22114` | FLOAT | 80 | 70 | 66 | 84 | `a83ce895f63b3609055ec030a6f42fbabb20ba58` |
| `buttons/basic/medium/radius_top_left_medium` | `67:22115` | FLOAT | 24 | 21 | 20 | 26 | `8d616c5959ba6748d693d57bf992a6aba585b0b0` |
| `buttons/basic/medium/min_width` | `67:22116` | FLOAT | 120 | 106 | 100 | 128 | `61c243e5168337004fdf0c4881edb5ca8f65102a` |
| `buttons/basic/medium/icon_sqaure` | `67:22117` | FLOAT | 40 | 35 | 33 | 42 | `add4b12bdc6fa1a9a06682ebc145d3b2c90ee216` |
| `buttons/basic/small/gap_horizontal` | `67:22118` | FLOAT | 12 | 11 | 10 | 13 | `8a66c1ad1e99cf95b4a9657234629a2392e37334` |
| `buttons/basic/small/padding_horizontal` | `67:22119` | FLOAT | 24 | 21 | 20 | 26 | `113353ca3a7de18abd8e2e59925d46b96ce7d4c3` |
| `buttons/basic/small/padding_vertical` | `67:22120` | FLOAT | 8 | 7 | 8 | 10 | `c1f561210050235cf2c13a549f5bb73c33caeafa` |
| `buttons/basic/small/height` | `67:22121` | FLOAT | 64 | 56 | 54 | 68 | `ca7f1a85f58bfc3b73b71773b4481dd9cad4627e` |
| `buttons/basic/small/radius_bottom_right` | `67:22122` | FLOAT | 16 | 14 | 13 | 17 | `b11259c4eca57b79a7cfd570407a77c804aa770d` |
| `buttons/basic/small/min_width` | `67:22123` | FLOAT | 100 | 88 | 84 | 106 | `0c42abfa80ca5e46d2b2f945a2e96d70a5658e00` |
| `buttons/basic/small/icon_sqaure` | `67:22124` | FLOAT | 32 | 28 | 27 | 35 | `356b222ac72584719b2c4b5888fd27e092e98161` |
| `buttons/toggle/large/gap_horizontal` | `67:22128` | FLOAT | 16 | 14 | 14 | 17 | `8749f0ac1fb862681b80ab4647646170f0de488b` |
| `buttons/toggle/large/padding_horizontal` | `67:22129` | FLOAT | 40 | 35 | 34 | 42 | `210662134df3e59fad997f9ea5480db94f7304a5` |
| `buttons/toggle/large/padding_vertical` | `67:22130` | FLOAT | 16 | 14 | 14 | 17 | `80354733f2029fc2692ae775e3cf8b3f85b865d9` |
| `buttons/toggle/large/height` | `67:22131` | FLOAT | 100 | 88 | 84 | 106 | `237bdd5e1671673ae74d9657d15f95b99807e6e7` |
| `buttons/toggle/large/radius_top_left` | `67:22132` | FLOAT | 32 | 28 | 27 | 35 | `b9630e157f14dbdb9a58fdd56c62d814e90e2a0b` |
| `buttons/toggle/large/radius_top_right` | `67:22133` | FLOAT | 32 | 28 | 27 | 35 | `ceebafdbda568e78035345c3f5282829df309663` |
| `buttons/toggle/large/radius_bottom_left` | `67:22134` | FLOAT | 32 | 28 | 27 | 35 | `e47740dcb021dba63cff023cc5e2bb60dc1a1088` |
| `buttons/toggle/large/radius_bottom_right` | `67:22135` | FLOAT | 32 | 28 | 27 | 35 | `52f35041760a59720176e78dbae5e6d6bd8925c8` |
| `buttons/toggle/large/min_width` | `67:22136` | FLOAT | 140 | 123 | 116 | 148 | `4b3e492a414c45cd4e8b34d5f257aeb5f858e87e` |
| `buttons/toggle/large/icon_sqaure` | `67:22137` | FLOAT | 52 | 46 | 43 | 55 | `face3a62143185eb176e79e3d8f5a9f907c1e1db` |
| `buttons/toggle/disabled_border` | `67:22138` | FLOAT | 2 | 2 | 2 | 3 | `a98ca8aedbfbc0437ca2473e3d2571c78a868390` |
| `buttons/toggle/medium/gap_horizontal` | `67:22139` | FLOAT | 14 | 12 | 12 | 15 | `1bd6f26b6556a31cc83fd95ce30d487ddd5efe87` |
| `buttons/toggle/medium/padding_horizontal` | `67:22140` | FLOAT | 32 | 28 | 28 | 35 | `2517f3f7201a9ee614aefc99b75e93ccfac84e64` |
| `buttons/toggle/medium/padding_vertical` | `67:22141` | FLOAT | 16 | 14 | 14 | 16 | `5b66442fcd19562bee2e75eafbfa17c86ad06efe` |
| `buttons/toggle/medium/height` | `67:22142` | FLOAT | 80 | 70 | 66 | 84 | `b9c0c9a1dac6929de9b2ce44d0c896c1441c35b7` |
| `buttons/toggle/medium/radius_top_left` | `67:22143` | FLOAT | 24 | 21 | 20 | 26 | `8657e61efa050ce31aba5a42f0e529560d575994` |
| `buttons/toggle/medium/radius_top_right` | `67:22144` | FLOAT | 24 | 21 | 20 | 26 | `7ba3f783c275e987f4512f6d7538945d662b6df6` |
| `buttons/toggle/medium/radius_bottom_left` | `67:22145` | FLOAT | 24 | 21 | 20 | 26 | `d24b4d4a0eca7ed793d572a849b7179fe3bdd702` |
| `buttons/toggle/medium/radius_bottom_right` | `67:22146` | FLOAT | 24 | 21 | 20 | 26 | `ce40e668812becadaf6539007a3738675470695e` |
| `buttons/toggle/medium/min_width` | `67:22147` | FLOAT | 120 | 106 | 100 | 128 | `0b50624b60229b82f81da3002cc49994ba59a60a` |
| `buttons/toggle/medium/icon_square` | `67:22148` | FLOAT | 40 | 35 | 33 | 42 | `4869e298376b150f0dee3aaec3708feef840555c` |
| `buttons/toggle/small/gap_horizontal` | `67:22149` | FLOAT | 12 | 11 | 10 | 12 | `2903d0f0abc8a55ecd11a3f4cf3c8ccb5313d59c` |
| `buttons/toggle/small/padding_horizontal` | `67:22150` | FLOAT | 24 | 21 | 20 | 26 | `c7e5b86db341b3fab01e78ce135827361c365447` |
| `buttons/toggle/small/padding_vertical` | `67:22151` | FLOAT | 8 | 7 | 8 | 10 | `f7766db71a087aa4da22fb7b9c4acd8c99a1488c` |
| `buttons/toggle/small/height` | `67:22152` | FLOAT | 64 | 56 | 54 | 68 | `5ecf5f16056b41e969ea495e148931b13a6e8b1c` |
| `buttons/toggle/small/radius_top_left` | `67:22153` | FLOAT | 16 | 14 | 13 | 17 | `7c63f4d7c32f38e8e2c0feb5f33b836f9f759ea5` |
| `buttons/toggle/small/radius_top_right` | `67:22154` | FLOAT | 16 | 14 | 13 | 17 | `7df54b1b9c42d9520d3e749275827f8e1e50e8c4` |
| `buttons/toggle/small/radius_bottom_left` | `67:22155` | FLOAT | 16 | 14 | 13 | 17 | `f8532e9f7920d487436a8c86edeaef696f053811` |
| `buttons/toggle/small/radius_bottom_right` | `67:22156` | FLOAT | 16 | 14 | 13 | 17 | `1c6667340a97f2135789fb5ed40d732d4a27e212` |
| `buttons/toggle/small/min_width` | `67:22157` | FLOAT | 100 | 88 | 84 | 106 | `5aec77f54fe6446704a339d79ecd706f369a8ae2` |
| `buttons/toggle/small/icon_sqaure` | `67:22158` | FLOAT | 32 | 28 | 27 | 35 | `ce9bcf90e025c2a8d716d3b1a5edbba925aa95dd` |
| `buttons/text/medium/icon` | `67:22169` | FLOAT | 32 | 28 | 27 | 35 | `8be93e58848f11ef2b7e20ede058e8ecc42fd195` |
| `buttons/text/small/gap` | `67:22171` | FLOAT | 4 | 4 | 4 | 4 | `9085999649d70f199620d39c18e4a8c1d4f708b6` |
| `buttons/text/small/icon` | `67:22172` | FLOAT | 28 | 25 | 23 | 29 | `f1733692d8c8cc029bbd79d427909823e5fa1583` |
| `buttons/icon/medium/height` | `67:22173` | FLOAT | 80 | 70 | 66 | 84 | `0ccdcf4edce9fc159c00803f32b0c143ec0c3a8b` |
| `buttons/icon/medium/content` | `67:22179` | FLOAT | 56 | 49 | 46 | 59 | `275498dccb322af211ca4640e2c3fae2ea856179` |
| `buttons/icon/small/width` | `67:22180` | FLOAT | 64 | 56 | 54 | 68 | `2e777128b296caf30185e66dd6174b751887011a` |
| `buttons/icon/small/height` | `67:22181` | FLOAT | 64 | 56 | 54 | 68 | `6e64bfc2ab90675ae547a115c7b431263c4c829e` |
| `buttons/icon/small/rounded_radius_top_left` | `67:22182` | FLOAT | 16 | 14 | 13 | 17 | `79c3faf607c463a3dc3fa5ed6078ab4b4a81fda1` |
| `buttons/icon/small/rounded_radius_top_right` | `67:22183` | FLOAT | 16 | 14 | 13 | 17 | `de5f5827dc7680b600cad9b1afb55bb435f123f9` |
| `buttons/icon/small/rounded_radius_bottom_left` | `67:22184` | FLOAT | 16 | 14 | 13 | 17 | `1cb5f0bc4b66228511ee22179ecbe6cd9c175005` |
| `buttons/icon/small/rounded_radius_bottom_right` | `67:22185` | FLOAT | 16 | 14 | 1613 | 17 | `e7cefa58caabb725b020b1ad4da8ba9d77b1dd6d` |
| `buttons/icon/small/content` | `67:22186` | FLOAT | 44 | 39 | 37 | 49 | `6fcde0515ae6b4ddbd2478df432bd8a167fb0252` |
| `buttons/keypad/height` | `67:22407` | FLOAT | 108 | 95 | 80 | 116 | `12089030bfd9fe285bca60f7e9bcbf6429cf235c` |
| `buttons/keypad/radius_top_left` | `67:22408` | FLOAT | 32 | 28 | 27 | 35 | `c8ebc049c8ffa0be5b72f96d83fcb1403b3496b1` |
| `buttons/keypad/radius_top_right` | `67:22409` | FLOAT | 32 | 28 | 27 | 35 | `1f6de8d3688ab62b62bf39f654cff60b532f9da2` |
| `buttons/keypad/radius_bottom_left` | `67:22410` | FLOAT | 32 | 28 | 27 | 35 | `6eaedae5b5926aad09155e1e5f5843f6006ac7fc` |
| `buttons/keypad/radius_bottom_right` | `67:22411` | FLOAT | 32 | 28 | 27 | 35 | `987f83c186bf28908443ba1eab2b2633d17eb478` |
| `buttons/keypad/border` | `67:22412` | FLOAT | 4 | 4 | 3 | 4 | `8bc9fc95b3d6baf850db9af6732f2dab8242673d` |
| `buttons/keypad/min_width` | `67:22413` | FLOAT | 200 | 176 | 166 | 212 | `e1351526af4b02db4624545bac5104431307f88e` |
| `buttons/keypad/icon` | `67:22434` | FLOAT | 48 | 42 | 40 | 51 | `843f74a517d48f573d0824c97a5c8f726dea184f` |
| `keyboard/keyword/normal_width` | `67:22435` | FLOAT | 100 | 88 | 96 | 106 | `2a3630f5af443207b472ccc8c261ff8beb736ba7` |
| `keyboard/keyword/height` | `67:22436` | FLOAT | 80 | 70 | 90 | 102 | `07bb74e86372dc806edf0a893c40be5c75a5f2f7` |
| `keyboard/keyword/radius_top_left` | `67:22437` | FLOAT | 20 | 18 | 17 | 22 | `e07f5128d9f711c1d59d86992eadd6348ef7c55e` |
| `keyboard/keyword/radius_top_right` | `67:22438` | FLOAT | 20 | 18 | 17 | 22 | `91e1860c16ef93fd9e6246dfbd15398b42647b57` |
| `keyboard/keyword/radius_bottom_left` | `67:22439` | FLOAT | 20 | 18 | 17 | 22 | `91520e385168adfd8a26ba4882458c286300db9f` |
| `keyboard/keyword/radius_bottom_right` | `67:22440` | FLOAT | 20 | 18 | 17 | 22 | `b1cce39efa6f5d924c001c41d32b99a52c25c8ce` |
| `keyboard/keyword/special_width` | `67:22443` | FLOAT | 120 | 106 | 100 | 128 | `877d98a77c7745cf953ca839a25b7ce48ad533b5` |
| `keyboard/keyword/icon_square` | `67:22475` | FLOAT | 44 | 39 | 37 | 49 | `abc202fcbe9373efb84944ebd4ad63c3b01140ec` |
| `keyboard/keyword/shift_width` | `67:22476` | FLOAT | 165 | 145 | 136 | 174 | `488ceca714d58b8f307b43d55defaf66edec7405` |
| `keyboard/keyword/enter_width` | `67:22478` | FLOAT | 200 | 176 | 166 | 212 | `f113f0fe8ab53760306bf59e0e05962ba9607279` |
| `controller/slider/gap_horizontal_large` | `67:24317` | FLOAT | 16 | 14 | 14 | 17 | `d3abd3b52b0d6aaf4464b6ca1d2c41a182973cdc` |
| `controller/slider/padding_horizontal_medium` | `67:24318` | FLOAT | 20 | 18 | 18 | 22 | `5c86e0d16d1662ee76c0d2ba1b194091d8324152` |
| `controller/slider/padding_vertical_medium` | `67:24319` | FLOAT | 10 | 9 | 8 | 10 | `6c10f67f0bad335ed222d37801b6b1bca908dd97` |
| `controller/slider/height_large` | `67:24320` | FLOAT | 100 | 88 | 84 | 106 | `6abc29c8f835978c652cc508c79716a3c77769fe` |
| `controller/slider/continuous/medium/radius_top_left` | `67:24321` | FLOAT | 32 | 28 | 27 | 35 | `0eef3bfd255e4ed34c418b4383116343de6ee39b` |
| `controller/slider/continuous/medium/radius_top_right` | `67:24322` | FLOAT | 32 | 28 | 27 | 35 | `523efb31ab5009ea343ec3923b9c3553482f1af8` |
| `controller/slider/continuous/medium/radius_bottom_left` | `67:24323` | FLOAT | 32 | 28 | 27 | 35 | `8682008987dcf1e925095ea5defe4df75376e66d` |
| `controller/slider/continuous/medium/radius_bottom_right` | `67:24324` | FLOAT | 32 | 28 | 27 | 35 | `57eb03043318e524c04bcbf09eb5dd21fc451a09` |
| `controller/slider/padding_horizontal_small` | `67:24325` | FLOAT | 10 | 9 | 8 | 10 | `e8a1a186cf0507275e7ff6cb6703f6fc7eb31b51` |
| `controller/slider/radius_top_left` | `67:24326` | FLOAT | 32 | 28 | 27 | 35 | `4f4ec7e63407f508e277a7302a8182aa9d17cbe7` |
| `controller/slider/radius_top_right` | `67:24327` | FLOAT | 32 | 28 | 27 | 35 | `80e6db3b740d92dd82ecf4a46c36177ed20a3532` |
| `controller/slider/radius_bottom_left` | `67:24328` | FLOAT | 32 | 28 | 27 | 35 | `c511ef320152a09495ec0d19d08150c9f286dffa` |
| `controller/slider/radius_bottom_right` | `67:24329` | FLOAT | 32 | 28 | 27 | 35 | `0abe47515a5fa335b097b253aa65502599eb2029` |
| `controller/slider/border_medium` | `67:24330` | FLOAT | 3 | 3 | 3 | 3 | `a6af1c107e58a01843701f2017d8054e517ef37a` |
| `controller/slider/centered/track/min_width` | `67:24370` | FLOAT | 320 | 282 | 266 | 340 | `f784d98a8f1d5d03e9bb6037d136d1a5f8b2c2f8` |
| `controller/slider/centered/track/height` | `67:24371` | FLOAT | 8 | 7 | 8 | 9 | `59775ac07d21705eab237ea54fb3faf582b31f31` |
| `controller/slider/centered/track/radius_top_left` | `67:24372` | FLOAT | 999 | 999 | 999 | 999 | `50c80e0162e6cc2ace46ecbc64a89a026742883f` |
| `controller/slider/centered/track/radius_top_right` | `67:24373` | FLOAT | 999 | 999 | 999 | 999 | `f289dcca2fd102ed9059be5cd8f070975adcbcad` |
| `controller/slider/centered/track/radius_bottom_left` | `67:24374` | FLOAT | 999 | 999 | 999 | 999 | `b5f6077ab34254a3fae1903a3d952daaae282137` |
| `controller/slider/centered/track/radius_bottom_right` | `67:24375` | FLOAT | 999 | 999 | 999 | 999 | `f8ba324ffc39fa318417e354f7789ce4f59d3ed1` |
| `controller/slider/padding_horizontal_large` | `67:24379` | FLOAT | 40 | 35 | 34 | 42 | `1fd0df923dc8a5ef75c4b85763c100cb2ec2f586` |
| `controller/slider/padding_vertical_large` | `67:24380` | FLOAT | 12 | 11 | 10 | 13 | `c11fdef87d076c4dd1221ba4a973f52ddfbbe38d` |
| `gnb/temperature/number_width` | `67:24383` | FLOAT | 75 | 69 | 58 | 76 | `bb6ecb66fb5f09851ce7ea76975252d5796cb89c` |
| `gnb/temperature/decimal_places_witdh` | `67:24384` | FLOAT | 38 | 33 | 32 | 36 | `9a793e9926ebda143c51777bdac40b8fcd7dc239` |
| `controller/slider/centered/temporature/text_height` | `67:24387` | FLOAT | 62 | 55 | 52 | 64 | `bf3512df90ab9492512613b5606e59fff4b8d459` |
| `controller/slider/centered/knob/enabled_circle` | `67:24388` | FLOAT | 48 | 42 | 40 | 51 | `ebefabbf220a3524ff4e9eccf5f141960b9f7c33` |
| `controller/slider/border_large` | `67:24389` | FLOAT | 4 | 4 | 3 | 4 | `797ce68f2b5d304c50ff17a466c767006d695d30` |
| `controller/slider/centered/knob/pressed_circle` | `67:24390` | FLOAT | 56 | 49 | 46 | 59 | `60adb27bf5d96fe4be9dcc33522cd859fc1b83fb` |
| `controller/slider/continuous/medium/label_width` | `67:24391` | FLOAT | 180 | 158 | 180 | 180 | `793468394d306ffc31c9449322fe75b2ba1539d8` |
| `controller/slider/continuous/track/medium/item_padding` | `67:24392` | FLOAT | 4 | 4 | 4 | 4 | `837a530a67af74c1c3f0b8e9dbbb34395f43c9b8` |
| `controller/slider/continuous/track/medium/radius_top_left` | `67:24393` | FLOAT | 24 | 21 | 20 | 26 | `32c4d1b8cb821eb19217bb289c4f49dffb7f2ff0` |
| `controller/slider/continuous/track/medium/radius_top_right` | `67:24394` | FLOAT | 24 | 21 | 20 | 26 | `bc25e84074d1008839ee5b009eda3d2de0422b50` |
| `controller/slider/continuous/track/medium/radius_bottom_left` | `67:24395` | FLOAT | 24 | 21 | 20 | 26 | `35521d370a290d0788c29a30b775f572ebb6755c` |
| `controller/slider/continuous/track/medium/radius_bottom_right` | `67:24396` | FLOAT | 24 | 21 | 20 | 26 | `6a39a6bf47a3029f021b07654d813a9450440b1f` |
| `controller/slider/border_small` | `67:24398` | FLOAT | 2 | 2 | 2 | 3 | `41d6e5c50b9acac36a4a9e3dac2d8fd96a915c56` |
| `controller/slider/gap_horizontal_small` | `67:24399` | FLOAT | 12 | 11 | 10 | 13 | `435dcc617b10274930a182bb559d69c6a87f32a7` |
| `controller/slider/padding_vertical_small` | `67:24400` | FLOAT | 8 | 7 | 8 | 9 | `b173ddb925c0dd75dbfffab6ca8c3cad431bdf5a` |
| `controller/slider/height_medium` | `67:24401` | FLOAT | 80 | 70 | 66 | 84 | `3682d4de888847b8fb7c65355b019cacc6385f1c` |
| `controller/slider/continuous/small/radius_top_left` | `67:24402` | FLOAT | 24 | 21 | 20 | 26 | `31b13d2bce76d80dd74cb0e03ad62127ef29c7a9` |
| `controller/slider/continuous/small/radius_top_right` | `67:24403` | FLOAT | 24 | 21 | 20 | 26 | `e30101ada259c2bed7d0347b0e1df8a93dfad447` |
| `controller/slider/continuous/small/radius_bottom_left` | `67:24404` | FLOAT | 24 | 21 | 20 | 26 | `7feb7b9a0a4f13c03e1c736ab97466fc0c47d3f0` |
| `controller/slider/continuous/small/radius_bottom_right` | `67:24405` | FLOAT | 24 | 21 | 20 | 26 | `18ef2e372e20848c892262f110d19acd4eef710a` |
| `controller/slider/continuous/track/small/item_padding` | `67:24406` | FLOAT | 4 | 4 | 4 | 4 | `0cad7af27733b6763afad57e00aab4ad8724ac33` |
| `controller/slider/continuous/track/small/radius_top_left` | `67:24407` | FLOAT | 20 | 18 | 17 | 22 | `b4d706b005e847356d984c113d822b55ea78635e` |
| `controller/slider/continuous/track/small/radius_top_right` | `67:24408` | FLOAT | 20 | 18 | 17 | 22 | `a10d90178d2e1ba23f20df4bc1e4b4b7c2915e53` |
| `controller/slider/continuous/track/small/radius_bottom_left` | `67:24409` | FLOAT | 20 | 18 | 17 | 22 | `64476932c42c519bb52c4ad62a309de3b3461622` |
| `controller/slider/continuous/track/small/radius_bottom_right` | `67:24410` | FLOAT | 20 | 18 | 17 | 22 | `decfbee24d0cebb5efe2d6426a929ffb0daf0651` |
| `controller/slider/continuous/medium/knob/radius_top_left` | `67:24411` | FLOAT | 20 | 18 | 17 | 22 | `f5d6f8c7755440d68430692cafcbf6f1cbdb9924` |
| `controller/slider/continuous/medium/knob/radius_top_right` | `67:24412` | FLOAT | 20 | 20 | 17 | 22 | `6d8d59bdefe85af3d211dee884225a86f670309c` |
| `controller/slider/continuous/medium/knob/radius_bottom_left` | `67:24413` | FLOAT | 20 | 20 | 17 | 22 | `8988baecfb8a841836cfb0e2e5c3ddf2f675d158` |
| `controller/slider/continuous/medium/knob/radius_bottom_right` | `67:24414` | FLOAT | 20 | 20 | 17 | 22 | `6c0a0f05c82c2264bcb1430592188d88535c9c93` |
| `controller/slider/continuous/track/medium/icon` | `67:24465` | FLOAT | 48 | 42 | 40 | 51 | `42d3781cbcaa5fa9861fa6d56fa86c0c3d05e228` |
| `controller/slider/height_small` | `67:24466` | FLOAT | 72 | 67 | 64 | 81 | `37eb8fb2358b58867a7de26ea0ccf7b4a2098feb` |
| `controller/slider/continuous/small/knob/radius_top_left` | `67:24467` | FLOAT | 16 | 14 | 13 | 17 | `0ce0a3c9bf151bd052a963b2e5ca9e7969c62c48` |
| `controller/slider/continuous/small/knob/radius_top_right` | `67:24468` | FLOAT | 16 | 14 | 13 | 17 | `1393fbdd93cb80a96860849858893e7e4ec81232` |
| `controller/slider/continuous/small/knob/radius_bottom_left` | `67:24469` | FLOAT | 16 | 14 | 13 | 17 | `3854303fda9ca4e40a967ee4911e15f904f3b697` |
| `controller/slider/continuous/small/knob/radius_bottom_right` | `67:24470` | FLOAT | 16 | 14 | 13 | 17 | `b0bdfe642d6d25f5cfddb3711cf321eb20b01355` |
| `controller/slider/continuous/track/small/icon` | `67:24471` | FLOAT | 40 | 35 | 33 | 42 | `5ac8c5cb616d4047367e4bdf3626f5e6b70330f6` |
| `controller/slider/continuous/medium/button_medium` | `67:24473` | FLOAT | 80 | 70 | 66 | 84 | `4c8ada7d0b7c15b0b61cecb21142b34283957cca` |
| `controller/slider/continuous/medium/icon_medium` | `67:24474` | FLOAT | 56 | 49 | 46 | 59 | `a182740175a57c7faf1b88d5c0aeebf612f8d0b4` |
| `controller/slider/continuous/small/button_small` | `67:24475` | FLOAT | 72 | 63 | 60 | 77 | `39f62535d92bba0c981b2ef97b20e5b02d436b58` |
| `controller/slider/continuous/small/icon_small` | `67:24476` | FLOAT | 48 | 42 | 40 | 51 | `3f9ed139c0a9eb51e9dbfc74a103cc7626f8c38c` |
| `controller/stepper/gap_horizontal` | `67:25139` | FLOAT | 24 | 21 | 20 | 26 | `267f87dad4389c2f3ba31d34254bdb6e0575fb12` |
| `controller/stepper/padding_horizontal` | `67:25140` | FLOAT | 24 | 21 | 20 | 26 | `1d5ee25a29754420234257ae10682b2df37f6507` |
| `controller/stepper/padding_vertical` | `67:25141` | FLOAT | 18 | 16 | 15 | 19 | `08af1327c3770f28b4e062de909d0daca321a9d8` |
| `controller/stepper/width` | `67:25142` | FLOAT | 420 | 352 | 340 | 426 | `93b8466422222419d2fc0f4bc94da7eff5b31332` |
| `controller/stepper/height` | `67:25143` | FLOAT | 100 | 88 | 84 | 106 | `fb438df7aebf88315d7cbcc7d0e3c92ee268edc6` |
| `controller/stepper/radius_top_left` | `67:25144` | FLOAT | 24 | 21 | 20 | 26 | `638832a726dd63f194f03c978684bfabc383929c` |
| `controller/stepper/radius_top_right` | `67:25145` | FLOAT | 24 | 21 | 20 | 26 | `4162d57fa856805f8ac10e1181818bb556186796` |
| `controller/stepper/radius_bottom_left` | `67:25146` | FLOAT | 24 | 21 | 20 | 26 | `0c1d04003cdbd51dd7d3116f60ae11c1b3447d20` |
| `controller/stepper/radius_bottom_right` | `67:25147` | FLOAT | 24 | 21 | 20 | 26 | `661165ea424376d2b20f134710e4cfedb56c8124` |
| `controller/stepper/border` | `67:25148` | FLOAT | 2 | 2 | 2 | 3 | `6f1bf621598f9483e8cbdb421fefbcc6ced5392a` |
| `controller/stepper/divider` | `67:25153` | FLOAT | 2 | 2 | 2 | 3 | `a104cef5d5af0d5ffbd33a56b6410183000c6165` |
| `dropdown/gap_vertical_small` | `67:25493` | FLOAT | 8 | 7 | 8 | 9 | `a568bd10686ef52fa31cc92855e0539b40a29955` |
| `dropdown/suffix/icon_square` | `67:25494` | FLOAT | 48 | 42 | 40 | 51 | `7f10c12d649c5c0edf2b64e2cdf9a932e0eff4bc` |
| `dropdown/medium/prefix/padding_horizontal` | `67:25495` | FLOAT | 4 | 4 | 4 | 4 | `994030208809552994d5d494d5e007d891ee5012` |
| `dropdown/padding_large` | `67:25513` | FLOAT | 20 | 18 | 18 | 22 | `93bc49c7387278cdcbb6af8dedca1201cfd74b56` |
| `dropdown/medium/height` | `67:25514` | FLOAT | 100 | 88 | 84 | 106 | `a07335b9b7d884a9322853c6d30e8b02f2ef0bc8` |
| `dropdown/medium/radius_top_left` | `67:25515` | FLOAT | 32 | 28 | 27 | 35 | `bad7fe14492d1355513fe4687d154f670e8c3d94` |
| `dropdown/medium/radius_top_right` | `67:25516` | FLOAT | 32 | 28 | 27 | 35 | `99e02514ab6f4ac0347bcd68f4d5afb5dbd40b92` |
| `dropdown/medium/radius_bottom_left` | `67:25517` | FLOAT | 32 | 28 | 27 | 35 | `88c09dbdb121a0517335344ee70b88b50366c9bd` |
| `dropdown/medium/radius_bottom_right` | `67:25518` | FLOAT | 32 | 28 | 27 | 35 | `9dc84095484a85126209d2e8c36ae38b5e1f27d8` |
| `dropdown/border` | `67:25519` | FLOAT | 2 | 2 | 2 | 3 | `e39ed68f052e5bd9df1384aecf1a7993ddb833e1` |
| `dropdown/gap_vertical_medium` | `67:25521` | FLOAT | 16 | 14 | 14 | 17 | `0bc0d27f7471f7428a3b2a1abdc9b7f2a86821e5` |
| `dropdown/padding_medium` | `67:25522` | FLOAT | 16 | 14 | 14 | 17 | `171ca3b0013f8e1a383038d064fc1a013c4224c0` |
| `dropdown/small/height` | `67:25524` | FLOAT | 80 | 70 | 66 | 84 | `9780b31984deac4151d34eab0e52fd8684ea1b76` |
| `dropdown/small/radius_top_left` | `67:25525` | FLOAT | 28 | 25 | 23 | 29 | `5f2dc5c5f298088069e146bd082dc22452528cb5` |
| `dropdown/small/radius_top_right` | `67:25526` | FLOAT | 28 | 25 | 23 | 29 | `99be65e52cf6c0b1c6f2802ffa3f78e478bcfb44` |
| `dropdown/small/radius_bottom_left` | `67:25527` | FLOAT | 28 | 25 | 23 | 29 | `a439d4d35e517f31bbcc91696340294d2a9361b7` |
| `dropdown/small/radius_bottom_right` | `67:25528` | FLOAT | 28 | 25 | 23 | 29 | `20426a60a3c71cd0293e2c7ccf59e4611e358bb9` |
| `dropdown/prefix/container_square` | `67:25564` | FLOAT | 56 | 49 | 46 | 59 | `547a332ec3d1fc3c1834531399d24223c810e5dd` |
| `dropdown/prefix/app_radius_top_left` | `67:25565` | FLOAT | 16 | 14 | 13 | 17 | `fa5c0924816d8d4635fdde9d05bd5e12514ff2ab` |
| `dropdown/prefix/app_radius_top_right` | `67:25566` | FLOAT | 16 | 14 | 13 | 17 | `22d748af69feb1a997c91bb30c6bd3041f971851` |
| `dropdown/prefix/app_radius_bottom_left` | `67:25567` | FLOAT | 16 | 14 | 13 | 17 | `2e4cf1cc3c528f99c7e8b2361697a4cfb1d26bf8` |
| `dropdown/prefix/app_radius_bottom_right` | `67:25568` | FLOAT | 16 | 14 | 13 | 17 | `297809b8a04f11ed467e8b20c6779dcb10387c10` |
| `dropdown/container/prefix_app_icon_border` | `67:25569` | FLOAT | 1; alias → line/level1 @67:25533 | 1; alias → line/level1 @67:25533 | 1; alias → line/level1 @67:25533 | 1; alias → line/level1 @67:25533 | `9be24b2c21c90636defe36cd293534e4dc721e96` |
| `dropdown/padding_small` | `67:25570` | FLOAT | 12 | 11 | 10 | 13 | `dd77684495deef21c5a35886d5250fc09f5e2254` |
| `dropdown/medium/prefix/icon_square` | `67:25615` | FLOAT | 40; alias → square/level8 @67:25614 | 35 | 33; alias → square/level8 @67:25614 | 42; alias → square/level8 @67:25614 | `df8a7ccef4b155fed7d70731668109f65f807fc0` |
| `selections/switch/medium/padding` | `67:25634` | FLOAT | 8 | 7 | 8 | 9 | `93569bb3588726bb029ceaf5859a4427cb1b09a1` |
| `selections/switch/medium/width` | `67:25635` | FLOAT | 80 | 70 | 70 | 84 | `b7cedd66e5b05b1c06d71a7919394b89cefc2f5f` |
| `selections/switch/medium/radius_top_left` | `67:25636` | FLOAT | 16 | 14 | 13 | 17 | `17ccfc9b40b73326e5947bfbf6c6d5828fd18b83` |
| `selections/switch/medium/radius_top_right` | `67:25637` | FLOAT | 16 | 14 | 13 | 17 | `8fe6f76d2cd6abd7adf71f1397edc4c92b498212` |
| `selections/switch/medium/radius_bottom_left` | `67:25638` | FLOAT | 16 | 14 | 13 | 17 | `de524b57121096db71b5a91845c0e6ce8f2af5e7` |
| `selections/switch/medium/radius_bottom_right` | `67:25639` | FLOAT | 16 | 14 | 13 | 17 | `0bb5a05793e1ad725e74df369616b78896e608b9` |
| `selections/switch/medium/knob_square` | `67:25641` | FLOAT | 32 | 28 | 27 | 35 | `7df1bb18b2e8e12cf425c5e47131d3e9175019ca` |
| `selections/switch/medium/knob_radius_top_left` | `67:25642` | FLOAT | 8 | 7 | 7 | 9 | `79ab640bbf028fd4f5b4f2d4f7ad3baaac7697f0` |
| `selections/switch/medium/knob_radius_top_right` | `67:25643` | FLOAT | 8 | 7 | 7 | 9 | `0d6ee97dd93de5d03d5721a9b7cd928ff02156e2` |
| `selections/switch/medium/knob_radius_bottom_left` | `67:25644` | FLOAT | 8 | 7 | 7 | 9 | `436599cd751fbe439af03b130e75b894fd3d27e0` |
| `selections/switch/medium/knob_radius_bottom_right` | `67:25645` | FLOAT | 8 | 7 | 7 | 9 | `1050a2c78a1e5a9e9e2b8dfa320a3d56f9a2853b` |
| `selections/switch/small/padding` | `67:25649` | FLOAT | 6 | 5 | 6 | 6 | `8742bd0e209df2d11184a4fa7757491e74187fdb` |
| `selections/switch/small/width` | `67:25650` | FLOAT | 64 | 56 | 56 | 68 | `3f6da1a94eb3b1a18d94cfbed12305da4e8e3b6b` |
| `selections/switch/small/radius_top_left` | `67:25651` | FLOAT | 12 | 11 | 10 | 13 | `3c8e3dc15ef60e7b31cd82b19ad58016d78b39dd` |
| `selections/switch/small/radius_top_right` | `67:25652` | FLOAT | 12 | 11 | 10 | 13 | `07da2dfb99ae1bfca49b376e7ae2ce1984850904` |
| `selections/switch/small/radius_bottom_left` | `67:25653` | FLOAT | 12 | 11 | 10 | 13 | `53be573b6cf202a69f4f769b3da7baa4dc1e89e7` |
| `selections/switch/small/radius_bottom_right` | `67:25654` | FLOAT | 12 | 11 | 10 | 13 | `d28981553294c187b10b8d6a01ffd888cfd2aed5` |
| `selections/switch/small/knob_square` | `67:25655` | FLOAT | 28 | 25 | 23 | 29 | `d832064a3c7a333e14752f7f32e5f490fb811bac` |
| `selections/switch/small/knob_radius_bottom_left` | `67:25656` | FLOAT | 8 | 7 | 7 | 9 | `72e0a08fbd4a2a473ae9b5980470a0495db8b604` |
| `selections/switch/small/knob_radius_bottom_right` | `67:25657` | FLOAT | 8 | 7 | 7 | 9 | `9684e7041b9197e7894ac96bbe074da30e22682c` |
| `selections/switch/small/knob_radius_top_left` | `67:25658` | FLOAT | 8 | 7 | 7 | 9 | `467e52673a7cf8832f5be0dc8f60769df2863c74` |
| `selections/switch/small/knob_radius_top_right` | `67:25659` | FLOAT | 8 | 7 | 7 | 9 | `fb5488c2a204fe7dead193d8daef08c6bfb31770` |
| `dropdown/suffix/dot_icon_square` | `67:25685` | FLOAT | 16 | 14 | 13 | 17 | `af721fd949d6376e8232c91c6b13b7a6d6b40d57` |
| `dropdown/medium/prefix/padding_vertical` | `67:25686` | FLOAT | 4 | 4 | 4 | 4 | `d6d7accda8e2cf9723b2b9a9f95d7cfa8fc099b3` |
| `dropdown/prefix/medium/app_icon_radius_top_left` | `67:25688` | FLOAT | 12; alias → radius/top_left/level4 @67:25687 | 11 | 10; alias → radius/top_left/level4 @67:25687 | 13; alias → radius/top_left/level4 @67:25687 | `271ba279eb65e2776d3dfeb548ed068ab403691a` |
| `dropdown/prefix/medium/app_icon_radius_top_right` | `67:25690` | FLOAT | 12; alias → radius/top_right/level4 @67:25689 | 11 | 10; alias → radius/top_right/level4 @67:25689 | 13; alias → radius/top_right/level4 @67:25689 | `a5e682021621a4b7f946aaf2d249946e2d185a7d` |
| `dropdown/prefix/medium/app_icon_radius_bottom_left` | `67:25692` | FLOAT | 12; alias → radius/bottom_left/level4 @67:25691 | 11 | 10; alias → radius/bottom_left/level4 @67:25691 | 13; alias → radius/bottom_left/level4 @67:25691 | `fa7815b834e46b605147d74710e9c2f47681826e` |
| `dropdown/prefix/medium/app_icon_radius_bottom_right` | `67:25694` | FLOAT | 12; alias → radius/bottom_right/level4 @67:25693 | 11 | 10; alias → radius/bottom_right/level4 @67:25693 | 13; alias → radius/bottom_right/level4 @67:25693 | `461b4fe9cc4d2626fc2e8a08c781815410064a00` |
| `fields/text/medium/help_text_gap_vertical` | `67:26968` | FLOAT | 16 | 14 | 14 | 17 | `10e97713394da99714f096b5b8042297a2eb33fb` |
| `fields/text/small/help_text_gap_vertical` | `67:26973` | FLOAT | 12 | 11 | 10 | 13 | `0d5d180934654036bac35c53c32093b86ab42c04` |
| `fields/text/small/gap_horizontal` | `67:26974` | FLOAT | 12 | 11 | 10 | 13 | `aabb1e5b62e7aeae01f295834a4b76afd9a3f8f7` |
| `fields/text/small/padding_horizontal` | `67:26975` | FLOAT | 24 | 21 | 20 | 26 | `4cfc98c052b94ea240ce0f97c3b8fe39700c275e` |
| `fields/text/small/height` | `67:26976` | FLOAT | 80 | 70 | 66 | 84 | `8a3e3d7b343dc68ecee7102aeb5bea679c273e87` |
| `fields/text/medium/radius_top_left` | `67:26977` | FLOAT | 24 | 21 | 20 | 26 | `602a946791cc050714a4c05ea0a4bc91452b46ee` |
| `fields/text/medium/radius_top_right` | `67:26978` | FLOAT | 24 | 21 | 20 | 26 | `ae45a82693f2b4391d4f4305150eaace144972a0` |
| `fields/text/medium/radius_bottom_left` | `67:26979` | FLOAT | 24 | 21 | 20 | 26 | `f4c5157cb0639c9d7614102b3185390cf3fd888c` |
| `fields/text/medium/radius_bottom_right` | `67:26980` | FLOAT | 24 | 21 | 20 | 26 | `6973ef8930b8591e3f43e1815a97ea39855777b1` |
| `fields/text/small/border` | `67:26981` | FLOAT | 2 | 2 | 2 | 3 | `07164cc4146d52f173e0b66c4bcb33196391a5ec` |
| `fields/text/small/suffix_icon_square` | `67:26983` | FLOAT | 40 | 35 | 33 | 42 | `cd93be9864426f8fc16deb204eaeb4e343e221d3` |
| `fields/text/medium/gap_horizontal` | `67:26995` | FLOAT | 16 | 14 | 14 | 17 | `b47b88f59a00b717bcd54778fb66999a5029eddf` |
| `fields/text/medium/padding_horizontal` | `67:26996` | FLOAT | 32 | 28 | 28 | 35 | `886999236217d41cf38b7c9b16c6e75661d8d63b` |
| `fields/text/medium/height` | `67:26997` | FLOAT | 100 | 88 | 84 | 106 | `c1476361c5777a7729cf78a45f6f524fd6ce8455` |
| `fields/text/medium/suffix_icon_square` | `67:26998` | FLOAT | 48 | 42 | 40 | 51 | `779435c836bd33248e5ed1e0ca58ec6bf16e7e3f` |
| `fields/text/medium/border` | `67:26999` | FLOAT | 3 | 3 | 3 | 3 | `a13e079b54535691d8fa6fdd8570d68c11886676` |
| `fields/number/large_width` | `67:27002` | FLOAT | 140 | 123 | 116 | 148 | `0dd33f1c5526a7148bd0d35c623c1a0433550d9c` |
| `fields/number/large_height` | `67:27003` | FLOAT | 180 | 158 | 150 | 190 | `e38a025b0f7b89609c14ec538a1c7c391654c7f3` |
| `fields/number/input_radius_top_left` | `67:27004` | FLOAT | 32 | 28 | 20 | 35 | `e269d5c398ede752c2c6e90afe285e3f670730a4` |
| `fields/number/input_radius_top_right` | `67:27005` | FLOAT | 32 | 28 | 20 | 35 | `73475875e224096b799edc6883c8914ea6c0ad27` |
| `fields/number/input_radius_bottom_left` | `67:27006` | FLOAT | 32 | 28 | 20 | 35 | `e8c6395dcdc56620d67e4e49c6d63142f07606f6` |
| `fields/number/input_radius_bottom_right` | `67:27007` | FLOAT | 32 | 28 | 20 | 35 | `159d334c8ef43f133d012110026ea44d7adf8fe9` |
| `fields/number/border` | `67:27008` | FLOAT | 4 | 4 | 3 | 4 | `16fc51b8d90aff7acf9002f0c9726fa9458f2aa4` |
| `fields/number/medium_square` | `67:27009` | FLOAT | 128 | 113 | 80 | 136 | `3785b2ae0fa7d85da41cad21e758fef92e21b997` |
| `fields/number/cursor_width` | `67:27010` | FLOAT | 4 | 4 | 4 | 4 | `0659edfc5334df699620ca67f0483c4ddb283f8e` |
| `fields/number/cursor_height` | `67:27011` | FLOAT | 48 | 42 | 40 | 51 | `ad2c000718c52ca22bd07be2aca89417f7cfe8e4` |
| `page_navigation/gap_large` | `67:27334` | FLOAT | 24 | 21 | 20 | 26 | `7316b7195c0bde70dbba83aa85953c5079be3bea` |
| `page_navigation/padding_extralarge` | `67:27335` | FLOAT | 40 | 35 | 32 | 42 | `24ddd8094ff94d3fba361091e95f82b4dcf062e9` |
| `page_navigation/padding_large` | `67:27336` | FLOAT | 24 | 21 | 22 | 20 | `6b9290f56a39b5527690077835cfb750eb5b7278` |
| `page_navigation/container_height` | `67:27337` | FLOAT | 80 | 70 | 66 | 84 | `2abd5978dbff247ecf9bde0605c73acadf9b86b6` |
| `page_navigation/border_bottom` | `67:27338` | FLOAT | 1 | 1 | 1 | 1 | `3fdebdcc328651c4712b5f6602dbd714ddc56a64` |
| `page_navigation/gap_samll` | `67:27339` | FLOAT | 12 | 11 | 10 | 13 | `762f1fffa5fe3ed98b20991c55fc8fe6bd357391` |
| `tabs/line/gap_horizontal` | `67:27340` | FLOAT | 24 | 21 | 12 | 26 | `8a83e0a8205155ec51b4c8f641242ae1efe0d22e` |
| `tabs/line/padding_horizontal` | `67:27341` | FLOAT | 28 | 25 | 24 | 29 | `3ef669283102edc8fcf74621f01612f597c29612` |
| `tabs/line/border_bottom` | `67:27342` | FLOAT | 1 | 1 | 1 | 1 | `ba1aba30c04274dd10234d5eb69aefa105b5ab3f` |
| `tabs/line/button/wrap_padding_vertical` | `67:27343` | FLOAT | 12 | 11 | 10 | 13 | `129f941963fd9bd153b8271134483605097546e9` |
| `tabs/line/button/gap_horizontal` | `67:27344` | FLOAT | 8 | 7 | 8 | 9 | `aeee5ad54b5af28222eccf1e75ba9084fd4dd553` |
| `tabs/line/button/padding_horizontal` | `67:27345` | FLOAT | 14 | 12 | 12 | 15 | `4245ca6b83af4fb9892d8080db3fc25bf95d9c85` |
| `tabs/line/button/padding_vertical` | `67:27346` | FLOAT | 18 | 16 | 16 | 19 | `7d6564b0436ac3cc76ff0fd81236ba971c2cfa66` |
| `tabs/line/button/pressed_radius_top_left` | `67:27347` | FLOAT | 12 | 11 | 10 | 13 | `52afd92799eb5226f87559fb448b8c7d5e6689f2` |
| `tabs/line/button/pressed_radius_top_right` | `67:27348` | FLOAT | 12 | 11 | 10 | 13 | `9219f3d05ae028c6de1b272ea8d81e1a685abca1` |
| `tabs/line/button/pressed_radius_bottom_left` | `67:27349` | FLOAT | 12 | 11 | 10 | 13 | `23e1b062c5e0f8ea7dd8c93660b373178503c973` |
| `tabs/line/button/pressed_radius_bottom_right` | `67:27350` | FLOAT | 12 | 11 | 10 | 13 | `d8d54b49b138823f37057265738afe714be0f09c` |
| `tabs/line/button/prefix_square` | `67:27351` | FLOAT | 40 | 35 | 33 | 42 | `f54742a4291d812c0c5f73ee05dbabdc83898a0d` |
| `tabs/line/selected_border_bottom` | `67:27353` | FLOAT | 4 | 4 | 3 | 4 | `8092e1b5898ca66dbf73e957490f84db57c6bf18` |
| `tabs/line/button/wrap_padding_vertical_large` | `67:27354` | FLOAT | 26 | 22 | 22 | 22 | `903b6592feafe53ad8000a3e95e44eaf7e88a466` |
| `bars/app_control/padding_top` | `67:27401` | FLOAT | 16 | 14 | 14 | 17 | `c908ee3eccb0ba1ed000f956c411bf4a849b9ab5` |
| `bars/app_control/container_width` | `67:27402` | FLOAT | 320 | 282 | 266 | 340 | `f2a6c6458bf4e32232daf7d4b88c38671c829f29` |
| `bars/app_control/container_height` | `67:27403` | FLOAT | 60 | 53 | 100 | 128 | `649067c2d28642d4753adf59d54eff37904b8484` |
| `bars/app_control/handle_width_normal` | `67:27404` | FLOAT | 140 | 123 | 116 | 148 | `a073ae3539b6d16d1160aaa406a43c647f276d3b` |
| `bars/app_control/handle_height` | `67:27405` | FLOAT | 8 | 7 | 8 | 9 | `cfd7244df65102bf40f8df2eee7d6f88859f3677` |
| `bars/radius_top_left` | `67:27406` | FLOAT | 999 | 999 | 999 | 999 | `001884ed4bca0ecea583ace2a4f9973c8ca714d1` |
| `bars/radius_top_right` | `67:27407` | FLOAT | 999 | 999 | 999 | 999 | `2c2a0fce9e0570cd903de7abf0c94b20da4e8447` |
| `bars/radius_bottom_left` | `67:27408` | FLOAT | 999 | 999 | 999 | 999 | `87c7e9ddb76af9f74092971cd70f458e92ed140b` |
| `bars/radius_bottom_right` | `67:27409` | FLOAT | 999 | 999 | 999 | 999 | `bb389bfcea4e64aa807181611d32ef4ab2b05487` |
| `page_navigation/title/group_gap_horizontal` | `67:27417` | FLOAT | 48 | 42 | 32 | 51 | `f156a3f95b77c3d1183712029b9df0f42eb22911` |
| `page_navigation/gap_medium` | `67:27418` | FLOAT | 16 | 14 | 14 | 17 | `46ac2a41a10a5fdba1654bf1d1345d0c23c1c4a5` |
| `page_navigation/title/app_icon/container_square` | `67:27419` | FLOAT | 80 | 70 | 66 | 84 | `6daffc9a46d2ee12cf0776acf7af85a3efc34454` |
| `page_navigation/title/app_icon/radius_top_left` | `67:27420` | FLOAT | 20 | 18 | 17 | 22 | `ab57ae3f5698b32eadf6694c5ae89b2b62773c0c` |
| `page_navigation/title/app_icon/radius_top_right` | `67:27421` | FLOAT | 20 | 18 | 17 | 22 | `4229bb35d50e81ecdaa77b55f7dd51b3721b468a` |
| `page_navigation/title/app_icon/radius_botttom_left` | `67:27422` | FLOAT | 20 | 18 | 17 | 22 | `158911be8d54791ec99a91d4e75d6bc1298ab243` |
| `page_navigation/title/app_icon/radius_botttom_right` | `67:27423` | FLOAT | 20 | 18 | 17 | 22 | `9b1e646996f4133c6feb0bdb5659dddb0bd62fc1` |
| `page_navigation/sub_title_gap_vertical` | `67:27424` | FLOAT | 4 | 4 | 4 | 4 | `ba4960e71718cc3d826e7c5ccd0a6bdba63d934a` |
| `page_navigation/padding_medium` | `67:27425` | FLOAT | 16 | 14 | 14 | 17 | `2486c23218c87e43d0e767ad022f827436544b31` |
| `page_navigation/padding_small` | `67:27426` | FLOAT | 8 | 7 | 8 | 9 | `e5b448613f91872ba7497bc97bea0a3f87fde06b` |
| `page_navigation/title/dropdown_menu_pressed/radius_top_left` | `67:27427` | FLOAT | 16 | 14 | 13 | 17 | `dec20c4895efd0cf1bdea54aea5a29f40ebc50df` |
| `page_navigation/title/dropdown_menu_pressed/radius_top_right` | `67:27428` | FLOAT | 16 | 14 | 13 | 17 | `0ac33885be0b579a01e12e670112d56851fdeb13` |
| `page_navigation/title/dropdown_menu_pressed/radius_botttom_left` | `67:27429` | FLOAT | 16 | 14 | 13 | 17 | `a042fcdd3a229d32899bbe8bec37b4aa29b9baa2` |
| `page_navigation/title/dropdown_menu_pressed/radius_botttom_right` | `67:27430` | FLOAT | 16 | 14 | 13 | 17 | `17a5ab69198fca6c7649a6433b46bcaefd75832e` |
| `page_navigation/gap_extrasmall` | `67:27431` | FLOAT | 8 | 7 | 8 | 9 | `70d9fbc6da0024e6d7caf2abdec47209b487994f` |
| `page_navigation/title/dropdown_icon_square` | `67:27439` | FLOAT | 28 | 25 | 23 | 29 | `0bf808eca8182744a0e0ec88555831c607db7b44` |
| `page_navigation/divider_width` | `67:27440` | FLOAT | 2 | 2 | 2 | 3 | `bd833fb6fd9a28d0a153cccb3df499e4a119d1b7` |
| `page_navigation/divider_height` | `67:27441` | FLOAT | 32 | 28 | 28 | 35 | `9fc891174f6ec91f1622b1d528e575c18c7ddc77` |
| `page_navigation/title/depth_gap_horizontal` | `67:27442` | FLOAT | 24 | 21 | 20 | 26 | `1ed1ebf91a393b94eaa77845936dec65761cb6d2` |
| `page_navigation/title/depth_icon_square` | `67:27443` | FLOAT | 56 | 49 | 46 | 59 | `95829f71edef07edcd1125aba8f4c138e8fe2789` |
| `popup/system/gap_extralarge` | `67:28784` | FLOAT | 40 | 35 | 33 | 42 | `944682b8761fc29adb53efb19bca6b3ad01a403c` |
| `popup/system/padding_large` | `67:28785` | FLOAT | 48 | 35 | 40 | 40 | `0638991d445097819fb870fd9caa9844bb9c1255` |
| `popup/system/medium_width` | `67:28786` | FLOAT | 808 | 614 | 720 | 860 | `95c8a7e509f8ea10d5b5c84692b98acc14fba4c5` |
| `popup/system/radius_top_left` | `67:28787` | FLOAT | 48 | 42 | 40 | 51 | `7fb4602b0b33c6aa8614242a4e7fb86efec9f3e1` |
| `popup/system/radius_top_right` | `67:28788` | FLOAT | 48 | 42 | 40 | 51 | `d5672dbed43cf472beb9d980c88f7dda03a2baa6` |
| `popup/system/radius_bottom_left` | `67:28789` | FLOAT | 48 | 42 | 40 | 51 | `5bff2ca79741c0d44e741e5f37bc609fbbb8e130` |
| `popup/system/radius_bottom_right` | `67:28790` | FLOAT | 48 | 42 | 40 | 51 | `2673d88409abac9779b5e9a5ece5d9bf9729781f` |
| `popup/system/border` | `67:28791` | FLOAT | 2 | 2 | 2 | 3 | `d469dcedf3a33e1d93837ac6293fb3608b211959` |
| `popup/system/max_height` | `67:28792` | FLOAT | 1152 | 827 | 770 | 810 | `2d57115eb60c1ff6d71ecd7ceade370d7fb36a0e` |
| `popup/system/padding_small` | `67:28793` | FLOAT | 16 | 14 | 12 | 12 | `1c57d12a84a56756e2b8d721cea86aaa7579918a` |
| `popup/system/gap_large` | `67:28794` | FLOAT | 24 | 21 | 24 | 24 | `5f98be24692d292b5555f94500fe40ede1c6baa9` |
| `popup/system/large_width` | `67:28795` | FLOAT | 1200 | 1056 | 1000 | 1275 | `bdb238ef1639e6f3794f4f5db8fcf0cfb41e0a6f` |
| `popup/system/max_height_extended` | `67:28796` | FLOAT | 0 | 0 | 1240 | 1240 | `775446b8fc1a5a1fbb5a3d9e82cbab5af6421c2f` |
| `popup/system/close_icon_square` | `67:28797` | FLOAT | 48 | 42 | 40 | 51 | `6fbf760c1c5147282adbece407559a46cd462d9e` |
| `popup/system/icon_square` | `67:28798` | FLOAT | 80 | 70 | 66 | 84 | `22700c8c1b834a1f0245a2560e3f4768f0fbb2ff` |
| `popup/system/header_padding_horizontal` | `67:28799` | FLOAT | 32 | 28 | 27 | 35 | `33cc82d289f616c08237e7b688d3746e18ba4efc` |
| `vehicle_settings/list/padding_horizontal` | `67:28873` | FLOAT | 20 | 18 | 20 | 20 | `c7e2d00046d6eabb25a234a894a85e1be49194be` |
| `vehicle_settings/list/padding_vertical` | `67:28874` | FLOAT | 24 | 21 | 24 | 24 | `0c7ad47358adbd7eaf3aa4ab9a591fc1394026a9` |
| `vehicle_settings/list/radius_top_left` | `67:28875` | FLOAT | 32 | 28 | 27 | 35 | `a6e16fee4fa98b866703c19d677a134ce3826b25` |
| `vehicle_settings/list/radius_top_right` | `67:28876` | FLOAT | 32 | 28 | 27 | 35 | `be92101120a08e85791d82f2b5322a376131a88b` |
| `vehicle_settings/list/radius_bottom_left` | `67:28877` | FLOAT | 32 | 28 | 27 | 35 | `1f1e627e52a2be20a477996bd7d674aa1c1d165e` |
| `vehicle_settings/list/radius_bottom_right` | `67:28878` | FLOAT | 32 | 28 | 27 | 35 | `2b7d820321eccd6f3cc282e5f8c49c6c6a95c53c` |
| `vehicle_settings/list/item/container/padding_horizontal` | `67:28879` | FLOAT | 20 | 18 | 17 | 22 | `a63f790ab6e855d6b17f8136cbe8d2dd6691b171` |
| `vehicle_settings/list/item/container/padding_vertical` | `67:28880` | FLOAT | 16 | 14 | 13 | 17 | `5ac940d37d3e71261130d600207b40a62ac6ce25` |
| `vehicle_settings/list/item/height` | `67:28881` | FLOAT | 112 | 99 | 93 | 119 | `bf6f2300b18c9f4fbe9e727149cefb9d9de6a9b8` |
| `vehicle_settings/list/item/container/radius_top_left` | `67:28882` | FLOAT | 24 | 21 | 20 | 26 | `60f7bababba85ef0e666f3451a151de99b8aeace` |
| `vehicle_settings/list/item/container/radius_top_right` | `67:28883` | FLOAT | 24 | 21 | 20 | 26 | `228cd9f15452d1107a214c962218cee78af0c49f` |
| `vehicle_settings/list/item/container/radius_bottom_left` | `67:28884` | FLOAT | 24 | 21 | 20 | 26 | `95a1dac978bb888b26ec2e613e84e72060b4cb46` |
| `vehicle_settings/list/item/container/radius_bottom_right` | `67:28885` | FLOAT | 24 | 21 | 20 | 26 | `bf0bdc1566d37ec10d041e6b6585848ac2079e8f` |
| `imagery/profile/radius_top_left` | `67:28886` | FLOAT | 999 | 999 | 999 | 999 | `57f53af76927f7fce4ea39ee2d821e7e0453c9ff` |
| `imagery/profile/radius_top_right` | `67:28887` | FLOAT | 999 | 999 | 999 | 999 | `6f9e27b58b00a15290a6a6bce2dadecfb04ce775` |
| `imagery/profile/radius_bottom_left` | `67:28888` | FLOAT | 999 | 999 | 999 | 999 | `7444d7da08dbc865dd0a6319460d74db29144765` |
| `imagery/profile/radius_bottom_right` | `67:28889` | FLOAT | 999 | 999 | 999 | 999 | `dc230eb7015e1d35dae765c1df14d6f96f5007f9` |
| `imagery/profile/circle` | `67:28891` | FLOAT | 80; alias → square/level18 @67:28890 | 70.4 | 66; alias → square/level18 @67:28890 | 84; alias → square/level18 @67:28890 | `4c7d8caaa0113f09a65d2a2895d79bffcb5eecc9` |
| `popup/system/list/item/icon_square` | `67:28907` | FLOAT | 80; alias → square/level18 @67:28890 | 70; alias → square/level18 @67:28890 | 66; alias → square/level18 @67:28890 | 84; alias → square/level18 @67:28890 | `e65dbc50a9dff14e72e749a4b0a6eeff526184ad` |
| `vehicle_settings/list/item/icon_container_square` | `67:28920` | FLOAT | 80 | 70 | 66 | 84 | `2ecf15406a89ec1bf93d25973f033092d4aafb7a` |
| `popup/system/gap_extrasmall` | `67:28921` | FLOAT | 4 | 4 | 3 | 4 | `92bb357a0c7456b7908c91450e5356fc37e6c45c` |
| `vehicle_settings/list/scroll_type_max_height` | `67:28954` | FLOAT | 528 | 465 | 324 | 560 | `07c8134c3f75b8ac5ff358eb3e078f2bdae9b1b6` |
| `bars/page_scroll/width` | `67:28955` | FLOAT | 6 | 5 | 6 | 6 | `3d42e034ee32d0531763c9a70217963cddb6a34f` |
| `bars/page_scroll/min_height` | `67:28956` | FLOAT | 48 | 42 | 40 | 51 | `4d65e2ea6f21d16718e0abe13697b6ffba905cef` |
| `scroll/padding_left` | `67:28957` | FLOAT | 12 | 11 | 10 | 13 | `4e2d07e0fc3285a3ed0e5eeb47de8ba42fb80e7d` |
| `scroll/padding_vertical` | `67:28958` | FLOAT | 16 | 14 | 13 | 17 | `6d7961f637d90ee634fd8cbecf8cc01454afad25` |
| `scroll/padding_right` | `67:28959` | FLOAT | 20 | 18 | 17 | 22 | `2954d223c4659a34589b6deaff5e211896be7730` |
| `scroll/gap` | `67:28960` | FLOAT | 16 | 14 | 13 | 17 | `ffecfb8dc09e505cc9774cf2da9df16ca3120062` |
| `spinner/gap_small` | `67:29006` | FLOAT | 16 | 14 | 14 | 17 | `1073c5ebaea712cd644a44ac4b17077b28574f02` |
| `spinner/title_top_padding` | `67:29007` | FLOAT | 16 | 14 | 14 | 17 | `bb5ac74bc08a62c4a0a60a6ed17fdb32edbe165f` |
| `spinner/wheel/padding_horizontal` | `67:29008` | FLOAT | 16 | 14 | 14 | 17 | `564adcacc67afe04f0867198d938bdb1c4aee050` |
| `spinner/panel/large_height` | `67:29009` | FLOAT | 384 | 327 | 322 | 407 | `e2139fdba2252b3afb46d1ca7bb3f75e38c1ceb9` |
| `spinner/wheel/radius_top_left` | `67:29010` | FLOAT | 32 | 28 | 27 | 35 | `8265548cfb0747f0540bb6d4ac5dd0c1cec07de1` |
| `spinner/wheel/radius_top_right` | `67:29011` | FLOAT | 32 | 28 | 27 | 35 | `5011976dc6cb8b473f36b87b2c30c8a24f54c89f` |
| `spinner/wheel/radius_bottom_left` | `67:29012` | FLOAT | 32 | 28 | 27 | 35 | `0925167fd7285560a4c73bfbf8c81966c8a6517e` |
| `spinner/wheel/radius_bottom_right` | `67:29013` | FLOAT | 32 | 28 | 27 | 35 | `685b8daa3b295e87f16939661068f09bd69ac995` |
| `spinner/wheel/date_min_width` | `67:29014` | FLOAT | 540 | 475 | 448 | 574 | `9c660dd3a09851590cecf359e59d3b326a84ba0b` |
| `spinner/gap_medium` | `67:29015` | FLOAT | 20 | 18 | 18 | 22 | `83960899406a02aa3698a4a9987b69aa5f56d8eb` |
| `spinner/list_mask_height` | `67:29016` | FLOAT | 60 | 53 | 50 | 64 | `bec2eecede3eace06a752535403d39d5fb7c06e3` |
| `spinner/number_width_small` | `67:29018` | FLOAT | 110 | 97 | 92 | 116 | `2f6571aca8e99a2a90aaafd7921cd4ad31c4b6f5` |
| `spinner/number_height` | `67:29019` | FLOAT | 88 | 77 | 74 | 93 | `65f5fbe1da086135d0b26169b274dafe6c96cb51` |
| `spinner/number_width_large` | `67:29020` | FLOAT | 200 | 176 | 166 | 212 | `ef27f938925826171344db6d1b65d68e137faaaf` |
| `spinner/list_height` | `67:29021` | FLOAT | 88 | 77 | 74 | 93 | `d7d41412ca55b3422f4c8d61366a52263c608f08` |
| `spinner/focus_radius_top_left` | `67:29022` | FLOAT | 24 | 21 | 20 | 26 | `000f53ddc6a7cb896c7dedfa543d886c8d697ca2` |
| `spinner/focus_radius_top_right` | `67:29023` | FLOAT | 24 | 21 | 20 | 26 | `ea316f87496bfafe0568825627d97ffcea53b7b4` |
| `spinner/focus_radius_bottom_left` | `67:29024` | FLOAT | 24 | 21 | 20 | 26 | `e7bd285c557fe3e438642ac39c79e96fba5f27fa` |
| `spinner/focus_radius_bottom_right` | `67:29025` | FLOAT | 24 | 21 | 20 | 26 | `59dab57e866ee060448799904d22cbd5c99c1f99` |
| `spinner/wheel/time_min_width` | `67:29029` | FLOAT | 480 | 422 | 398 | 509 | `cec43247890ef39e444d3573f33e68d68fda3181` |
| `spinner/number_width_medium` | `67:29030` | FLOAT | 140 | 123 | 116 | 148 | `ca3b0db4552eb56e40a4801f68f1fbb36a89341d` |
| `spinner/panel/medium_height` | `67:29031` | FLOAT | 288 | 245 | 234 | 297 | `f07b07601ac25305694c45332005265c97c734da` |
| `spinner/list_medium_height` | `67:29032` | FLOAT | 96 | 84 | 80 | 102 | `68542f9c8d3b28f060b2132677c41ccbf7773ff3` |
| `spinner/gap_large` | `67:29111` | FLOAT | 24 | 28 | 28 | 35 | `61fe04977bbd18d7a24e6d545b939d430f4eebee` |
| `popup/toast/padding_horizontal` | `67:32544` | FLOAT | 40 | 35 | 34 | 42 | `09b238555638b774dfed2c55f35e9418f8bc489c` |
| `popup/toast/padding_vertical` | `67:32545` | FLOAT | 24 | 21 | 20 | 26 | `7d695a0e580cedf0b666a0735ae2d57e4a4eaf0b` |
| `popup/toast/radius_top_left` | `67:32546` | FLOAT | 16 | 14 | 13 | 17 | `5422fa1cd83c92a308988dd78618045d5bcf38ed` |
| `popup/toast/radius_top_right` | `67:32547` | FLOAT | 16 | 14 | 13 | 17 | `afb20279fa5824445d9ea5c2a54b5e13cf658c79` |
| `popup/toast/radius_bottom_left` | `67:32548` | FLOAT | 16 | 14 | 13 | 17 | `1d8ca0851f973affed45b1e415c4eb1de37c3dd3` |
| `popup/toast/radius_bottom_right` | `67:32549` | FLOAT | 16 | 14 | 13 | 17 | `cbab7c409c97760f53c9793eebc4ff97415ae5c7` |
| `popup/toast/max_width` | `67:32550` | FLOAT | 792 | 696 | 760 | 840 | `f3037101b10932982b21556f244419c799854835` |
| `popup/toast/icon` | `67:32551` | FLOAT | 48 | 42 | 40 | 51 | `8440e6544926549fd61f86a1ef6bfb6a85a66155` |
| `popup/toast/margin_horizontal` | `67:32552` | FLOAT | 24 | 21 | 20 | 26 | `3cd1f8edd17de3cb93fd531141aae47ad69d4acb` |
| `popup/toast/margin_bottom` | `67:32553` | FLOAT | 24 | 21 | 20 | 26 | `eaaf19c5b8ca19e1d4314fa2321d2c506d264e66` |
| `tabs/solid/padding` | `67:32602` | FLOAT | 8 | 7 | 8 | 9 | `e5939739ea37e75d45797bd67332fc5ef744788b` |
| `tabs/solid/large/three_segments_width` | `67:32603` | FLOAT | 880 | 774 | 760 | 934 | `fc114bb0427a149b64f5089fd0b496836b66509b` |
| `tabs/solid/large/height` | `67:32604` | FLOAT | 100 | 88 | 84 | 106 | `488257316b96b113de770b7cd70562334c7f6a33` |
| `tabs/solid/large/radius_top_left` | `67:32605` | FLOAT | 32 | 28 | 27 | 35 | `4768c266ff0aedd78bd145d6506f79226cc77256` |
| `tabs/solid/large/radius_top_right` | `67:32606` | FLOAT | 32 | 28 | 27 | 35 | `3fe6a167af8f3eea9b0cef9cd05d01e0a49ff290` |
| `tabs/solid/large/radius_bottom_left` | `67:32607` | FLOAT | 32 | 28 | 27 | 35 | `eca91b0b5b076cf0e2187b6fb85fd3dabc8c13d0` |
| `tabs/solid/large/radius_bottom_right` | `67:32608` | FLOAT | 32 | 28 | 27 | 35 | `8d4d9cd05f017553be03727d7d833a80b0a5454e` |
| `tabs/solid/medium/three_segments_width` | `67:32610` | FLOAT | 780 | 686 | 670 | 828 | `36fba0fc8b3db885d372666f35daa81331783341` |
| `tabs/solid/medium/height` | `67:32611` | FLOAT | 80 | 70 | 66 | 84 | `b35873769a4bb1ed55cb698740a156660efe477b` |
| `tabs/solid/medium/radius_top_left` | `67:32612` | FLOAT | 24 | 21 | 20 | 26 | `1063b97526e2238f49ef8cc5c516e4794debc29e` |
| `tabs/solid/medium/radius_top_right` | `67:32613` | FLOAT | 24 | 21 | 20 | 26 | `5e8f1cc06142652603ce064cee7008fcac581cea` |
| `tabs/solid/medium/radius_bottom_left` | `67:32614` | FLOAT | 24 | 21 | 20 | 26 | `17d74babf179c26bbcbb3dae604b4887a1724de7` |
| `tabs/solid/medium/radius_bottom_right` | `67:32615` | FLOAT | 24 | 21 | 20 | 26 | `838a56f63d77936824f7321f8fd519e905062eac` |
| `tabs/solid/large/button/gap_horizontal` | `67:32616` | FLOAT | 14 | 12 | 12 | 16 | `83f13fea2e7717e3daa7be46e76be9c7dadd9811` |
| `tabs/solid/large/button/padding_horizontal` | `67:32617` | FLOAT | 28 | 25 | 24 | 29 | `07d28077022816944f6756c6a6b7b68fceec31e5` |
| `tabs/solid/large/button/padding_vertical` | `67:32618` | FLOAT | 16 | 14 | 14 | 17 | `cf9e4e7f58467fb312b296039784cc196baab561` |
| `tabs/solid/large/button/height` | `67:32619` | FLOAT | 84 | 74 | 70 | 90 | `ae2759a73d37aaa8b8bb7e41c13c51f501281902` |
| `tabs/solid/large/button/radius_top_left` | `67:32620` | FLOAT | 24 | 21 | 20 | 26 | `ea9d658fdedfe874a29dc8c93ad9dfe6dc055958` |
| `tabs/solid/large/button/radius_top_right` | `67:32621` | FLOAT | 24 | 21 | 20 | 26 | `c3dfe89eff442263fd217fbc01d30ff6f6360cc8` |
| `tabs/solid/large/button/radius_bottom_left` | `67:32622` | FLOAT | 24 | 21 | 20 | 26 | `79367264f810f914a676cb6723a731a78484eaff` |
| `tabs/solid/large/button/radius_bottom_right` | `67:32623` | FLOAT | 24 | 21 | 20 | 26 | `55fa8a24e24dfefb14839f0f67fbe9232388b31a` |
| `tabs/solid/large/two_segments_width` | `67:32625` | FLOAT | 880 | 774 | 760 | 934 | `96cae27919093d273554987adabec6efd83b0549` |
| `tabs/solid/medium/button/gap_horizontal` | `67:32626` | FLOAT | 8 | 7 | 8 | 9 | `da3a92814918424f0e33f3c7f1f3ea4614cc2717` |
| `tabs/solid/medium/button/padding_horizontal` | `67:32627` | FLOAT | 18 | 16 | 16 | 19 | `6ebccb9eb3e391c970b15fceb3da396fe526e006` |
| `tabs/solid/medium/button/padding_vertical` | `67:32628` | FLOAT | 12 | 11 | 10 | 13 | `0ae49d8fa44ff0295aa5407d5a25696ddc98b88f` |
| `tabs/solid/medium/button/radius_top_left` | `67:32629` | FLOAT | 16 | 14 | 13 | 17 | `6f10d797c9241fce858b3a0b1ac810d4b7e6dd76` |
| `tabs/solid/medium/button/radius_top_right` | `67:32630` | FLOAT | 16 | 14 | 13 | 17 | `9a26c442a78ea9d5080baa8d8aaac1486f3bcd5b` |
| `tabs/solid/medium/button/radius_bottom_left` | `67:32631` | FLOAT | 16 | 14 | 13 | 17 | `670d4da35f0fc9b5d5a8168113935b8bde8c575d` |
| `tabs/solid/medium/button/radius_bottom_right` | `67:32632` | FLOAT | 16 | 14 | 13 | 17 | `cef642eb43de5369bbed6bb3cf633fd7f4ebcb40` |
| `tabs/solid/medium/four_segments_width` | `67:32633` | FLOAT | 960 | 845 | 800 | 1020 | `34e5613fbfc0e7372b1345420c4f8d7e018aaa2b` |
| `tabs/solid/medium/two_segments_width` | `67:32634` | FLOAT | 780 | 686 | 670 | 828 | `5dd5b46d52ac2fd05dfd32faacd73b87e02aca16` |
| `tabs/solid/large/button/width` | `67:32635` | FLOAT | 200 | 176 | 166 | 212 | `96e6d5f41d471b260bf51083d2ff72fccb38ea6b` |
| `tabs/solid/large/button/prefix_icon_square` | `67:32648` | FLOAT | 52 | 46 | 43 | 55 | `9be66a870a964013946d931e2c0593d16e1b016b` |
| `tabs/solid/medium/button/width` | `67:32649` | FLOAT | 160 | 141 | 134 | 170 | `cfea895e5a38546882efa74ef0735055a523d9b8` |
| `tabs/solid/medium/button/height` | `67:32650` | FLOAT | 64 | 56 | 54 | 68 | `b4dfab8a2e99a888292cc8e959edfc372ba2f235` |
| `tabs/solid/medium/button/prefix_square` | `67:32651` | FLOAT | 40 | 35 | 33 | 42 | `59cf4f299d166adf67799ac3e3dd9bc9c4e36dd4` |
| `selections/container_large` | `67:33552` | FLOAT | 64 | 56 | 54 | 68 | `286b8a06f1e0748e9ffe3701d3b69f58d0e4fe7a` |
| `selections/container_medium` | `67:33553` | FLOAT | 48 | 42 | 40 | 51 | `fc69c8603111c221d2b066f05756f47d49d74b97` |
| `selections/checkbox/radius_top_left` | `67:33554` | FLOAT | 12 | 11 | 10 | 13 | `722c5ef0396a6b4eae4ca7b1065cbcd4518fc799` |
| `selections/checkbox/radius_top_right` | `67:33555` | FLOAT | 12 | 11 | 10 | 13 | `7b843ac47c3989bb2ad858e3083f870774dba739` |
| `selections/checkbox/radius_bottom_left` | `67:33556` | FLOAT | 12 | 11 | 10 | 13 | `636838d78ee58823d0da4d7a979d4d8b5ea14913` |
| `selections/checkbox/radius_bottom_right` | `67:33557` | FLOAT | 12 | 11 | 10 | 13 | `77c93198c1eb20d6447ed7022694042b4d4c886c` |
| `selections/checkbox/normal_button_border` | `67:33559` | FLOAT | 4; alias → line/level4 @67:33558 | 4 | 3; alias → line/level4 @67:33558 | 4; alias → line/level4 @67:33558 | `78a66b00ce831ba8a3e387ea62b677d477e45bc2` |
| `selections/border_large` | `67:33561` | FLOAT | 12 | 11 | 10 | 13 | `e2b57d9060d202ced5b753f4656d161b66cb81c6` |
| `selections/border_small` | `67:33562` | FLOAT | 4 | 4 | 3 | 4 | `8674b5ec9dfe273920bf8d99875b465980384594` |
| `notification/system/width` | `67:33933` | FLOAT | 700 | 616 | 582 | 745 | `42a67a178461190bfde798b2d83940b6212a343d` |
| `notification/system/radius_top_left` | `67:33934` | FLOAT | 48 | 42 | 40 | 51 | `be51495e6ee4700019787edcac273163cbceeef1` |
| `notification/system/radius_top_right` | `67:33935` | FLOAT | 48 | 42 | 40 | 51 | `54aee3de328a6c8d1374560716c36eda93940913` |
| `notification/system/radius_bottom_left` | `67:33936` | FLOAT | 48 | 42 | 40 | 51 | `f7c986c1a04ffa65c0b41ec93ae57aed72c83d98` |
| `notification/system/radius_bottom_right` | `67:33937` | FLOAT | 48 | 42 | 40 | 51 | `2f824b35367dca64d830b01b647b4fc95e763c5c` |
| `notification/border` | `67:33938` | FLOAT | 1 | 1 | 1 | 1 | `d47c4e00cac88fac139a16ab4264f791a3a3abf8` |
| `notification/gap_large` | `67:33940` | FLOAT | 24 | 21 | 20 | 26 | `e0186828f7261856936fb2eb4f6694b8bcb0d2dd` |
| `notification/padding_large` | `67:33941` | FLOAT | 32 | 28 | 28 | 35 | `fc4600bbc8760539c8bf3c33637392d20721ce96` |
| `notification/padding_small` | `67:33942` | FLOAT | 16 | 14 | 14 | 16 | `e9583526070c9900261c2f6ad01f8113cf7a3f9a` |
| `os_notification/container/width` | `67:33943` | FLOAT | 700 | 700 | 700 | 700 | `5241d920de28b2d169bd9c40ed901637824f95ef` |
| `notification/system/imagary_square` | `67:33944` | FLOAT | 100 | 88 | 83 | 106 | `1b6cb159db6afcbe35ce3ea5c497d8b42338ae52` |
| `notification/system/images/radius_top_left` | `67:33945` | FLOAT | 24 | 21 | 20 | 26 | `ee32a021f4d24c18ce387481c4679023c87998bd` |
| `notification/system/images/radius_top_right` | `67:33946` | FLOAT | 24 | 21 | 20 | 26 | `8a6471a94833256e4a597344c9c54eea88eb2835` |
| `notification/system/images/radius_bottom_left` | `67:33947` | FLOAT | 24 | 21 | 20 | 26 | `7287470eca4eaa3271c3edae8c2a9a80a6e9e509` |
| `notification/system/images/radius_bottom_right` | `67:33948` | FLOAT | 24 | 21 | 20 | 26 | `8acbd9fb87dad22a3e53ba04c72e46c99fdde712` |
| `notification/system/text_gap_vertical` | `67:33949` | FLOAT | 12 | 11 | 10 | 13 | `4ba9114fdb71381031ef66380a8ab17e5f1b1077` |
| `notification/system/text_padding_top` | `67:33950` | FLOAT | 4 | 3 | 4 | 5 | `1077d83f042f809b7dabe3299d15dee9fd56fa1a` |
| `notification/gap_medium` | `67:33951` | FLOAT | 16 | 14 | 14 | 17 | `f9187756652e04ee43804640885f0094eec9bc9d` |
| `notification/padding_medium` | `67:33952` | FLOAT | 24 | 21 | 20 | 26 | `b084132c2a3d03517071cd191dbb8d930e5ac339` |
| `notification/system/text_padding_horizontal` | `67:33953` | FLOAT | 8 | 7 | 8 | 10 | `3e53402fdfe8eeab9f8230c86e37e3b15b8ce4b4` |
| `notification/system/profile/app_radius_top_left` | `67:33954` | FLOAT | 16 | 14 | 13 | 17 | `e01d46265b04fcbb8c2e20db7bac33b984fcef06` |
| `notification/system/profile/app_radius_top_right` | `67:33955` | FLOAT | 16 | 14 | 13 | 17 | `605df8b49262b16d0d43f7aa939b0ee9e4cca553` |
| `notification/system/profile/app_radius_bottom_left` | `67:33956` | FLOAT | 16 | 14 | 13 | 17 | `99fc48c2179c1d63486b2e9130b1fd342c9fd35f` |
| `notification/system/profile/app_radius_bottom_right` | `67:33957` | FLOAT | 16 | 14 | 13 | 17 | `db72fe7428e2f300e82066eb5c0539ea624789cd` |
| `buttons/basic/medium/radius_top_right_medium` | `67:33958` | FLOAT | 24 | 21 | 20 | 26 | `d617bc02e0e290ee5d4c7b5e0172c103b72a0598` |
| `buttons/basic/medium/radius_bottom_left_medium` | `67:33959` | FLOAT | 24 | 21 | 20 | 26 | `bd402b3575a67e2d080a9b1d3f9c57b70fcec8a3` |
| `buttons/basic/medium/radius_bottom_right_medium` | `67:33960` | FLOAT | 24 | 21 | 20 | 26 | `fe1d10ede5f6d45ee68cd986d64ee64ace04083a` |
| `os_notification/contents/image_square` | `67:33962` | FLOAT | 100; alias → square/level22 @67:33961 | 88; alias → square/level22 @67:33961 | 83; alias → square/level22 @67:33961 | 106; alias → square/level22 @67:33961 | `81f86394e97fe131ea2a6617307834035848c0c8` |
| `os_notification/contents/image_thumb_radius` | `67:33963` | FLOAT | 16; alias → radius/top_left/level5 @67:25529 | 14; alias → radius/top_left/level5 @67:25529 | 13; alias → radius/top_left/level5 @67:25529 | 17; alias → radius/top_left/level5 @67:25529 | `32a1daf175a743ce7c43ed99b12be335d9534741` |
| `notification/system/profile/radius_top_left` | `67:33964` | FLOAT | 999 | 999 | 999 | 999 | `c08f331c65b269394c84de18245e87749360448d` |
| `notification/system/profile/radius_top_right` | `67:33965` | FLOAT | 999 | 999 | 999 | 999 | `ede13045c895efb78b9ec9996b6a944bd33a0369` |
| `notification/system/profile/radius_bottom_left` | `67:33966` | FLOAT | 999 | 999 | 999 | 999 | `9729195c483138bc8b0ac5624347232b02003d8e` |
| `notification/system/profile/radius_bottom_right` | `67:33967` | FLOAT | 999 | 999 | 999 | 999 | `a38d054cabb1676b0f4da7bdf9f73c668a106539` |
| `notification/system/profile/app_square` | `67:33968` | FLOAT | 48 | 42 | 40 | 51 | `1ac1b4b3c12612890cf3b992c8a66b50094ac22d` |

## typo — 67:7555

- collection key: `fcaac18959901ecd6624b948186c7add2d72886a`
- 모드 식별자: `connect-s=32090:0`, `connect-l=32259:1`, `connect-w=33219:2`, `connect-waterfall=33235:1`

| Token | ID | Type | connect-s | connect-l | connect-w | connect-waterfall | Key |
| --- | --- | --- | --- | --- | --- | --- | --- |
| `size_sp/level18` | `67:7556` | FLOAT | 60 | 53 | 50 | 64 | `c67f602bf301b46ff4fe81a5823abf039c0c6211` |
| `line_height_sp/level19` | `67:7557` | FLOAT | 80 | 65 | 66 | 84 | `8e596bc3fca63f243e0ae74609318f64d74b8cad` |
| `size_sp/level17` | `67:7559` | FLOAT | 56 | 49 | 46 | 59 | `7313c8211c48ed20475d0aa37365cf13b7b5884c` |
| `line_height_sp/level17` | `67:7560` | FLOAT | 72 | 65 | 60 | 77 | `a491a00217ab9f4740cd52034b2097cbc9b54d74` |
| `size_sp/level15` | `67:7562` | FLOAT | 48 | 42 | 40 | 51 | `4e0ccd9671ba10ca4de344228c04cba048f7d21d` |
| `size_sp/level19` | `67:7563` | FLOAT | 64 | 56 | 53 | 68 | `4e7da002253b6bc395006a0556ca2cf34296f9b0` |
| `size_sp/level13` | `67:7565` | FLOAT | 40 | 35 | 33 | 42 | `1ef39e8ead1eaa16171b5b75d078010abdbb342b` |
| `size_sp/level16` | `67:7566` | FLOAT | 52 | 46 | 43 | 55 | `e3463b37f4655c48a8f03f48c1c399254a098876` |
| `size_sp/level11` | `67:7568` | FLOAT | 36 | 32 | 30 | 38 | `b03f23b6892d2fe3e257ff93f91eec4655e40632` |
| `size_sp/level14` | `67:7569` | FLOAT | 44 | 39 | 37 | 47 | `e96d219ce31393ff7d80263f291154c98ab06d5a` |
| `size_sp/level9` | `67:7571` | FLOAT | 32 | 28 | 27 | 35 | `02efbeb76962d78c57e4a7fc8728736f29ea05f3` |
| `line_height_sp/level9` | `67:7572` | FLOAT | 40 | 35 | 33 | 42 | `49512df87e801fe3de326e01a178d014966372e5` |
| `size_sp/level8` | `67:7574` | FLOAT | 30 | 26 | 25 | 34 | `02131968e376422489c7fea05604a54462185787` |
| `line_height_sp/level8` | `67:7575` | FLOAT | 38 | 33 | 32 | 41 | `9cf519cf66a8606c75b9b0df1cff17ac66e1f17c` |
| `size_sp/level7` | `67:7577` | FLOAT | 28 | 25 | 23 | 29 | `b7dbfb699fcbbc7309b1e4a6087fd1f54b48ab35` |
| `line_height_sp/level7` | `67:7578` | FLOAT | 36 | 32 | 30 | 38 | `5fc91a2d4dc3b771ee10f892c7a17a0f66424673` |
| `size_sp/level6` | `67:7580` | FLOAT | 26 | 23 | 22 | 28 | `1116120d5605797a91a3ac72abd535fbe9fb6fc6` |
| `line_height_sp/level6` | `67:7581` | FLOAT | 34 | 28 | 28 | 36 | `67b6886c5927df2c7c778752a9c8b1c93d72ddbb` |
| `size_sp/level5` | `67:7583` | FLOAT | 24 | 21 | 20 | 26 | `fb0c61dc0dacf4365cbe7de44bc3611b7e5e44ec` |
| `line_height_sp/level3` | `67:7584` | FLOAT | 28 | 25 | 23 | 29 | `7a69ce5409cd324bba40d9721f3da11cb328b1ae` |
| `size_sp/level3` | `67:7586` | FLOAT | 20 | 18 | 17 | 22 | `c5ccb84b956059962a9d5022f3f3bb27aac1e1a4` |
| `line_height_sp/level1` | `67:7587` | FLOAT | 24 | 21 | 20 | 26 | `ad96874ff1437d2da76e752c9ea295491c38d6c3` |
| `size_sp/level20` | `67:7589` | FLOAT | 112 | 99 | 130 | 119 | `a2745113254464a23fb6d20d18145d4925ea586d` |
| `line_height_sp/level20` | `67:7590` | FLOAT | 134 | 118 | 156 | 142 | `91944e0054471caef01655fc9da185e6c0dc5625` |
| `line_height_sp/level11` | `67:7592` | FLOAT | 48 | 42 | 40 | 51 | `897f0c07a719874678b81fd6ce2b9f8c2499f842` |
| `shadow/level2/blur1` | `67:22159` | FLOAT | 32 | 28 | 27 | 32 | `63b590ebccb8e2ff464283765fe0d2301e523815` |
| `shadow/level2/y1` | `67:22160` | FLOAT | 8 | 7 | 7 | 9 | `f56acda1513260751b2d9c9143a30ada08887864` |
| `shadow/level2/blur2` | `67:22161` | FLOAT | 2 | 2 | 2 | 3 | `9e0bb715caeebf86f40939292a23cdfed1e65ae9` |
| `shadow/level2/y2` | `67:22162` | FLOAT | 2 | 2 | 2 | 3 | `1dd6d111e1e9f9968b2bae5c33db8c674282b410` |
| `shadow/level1/blur` | `67:24376` | FLOAT | 24 | 21 | 20 | 26 | `90c9fbac9c16d3f7e78d7a35bad29e23183412d9` |
| `shadow/level1/y` | `67:24377` | FLOAT | 6 | 5 | 5 | 6 | `932cb23bf5060756519be9d4e60af5e91a13fe7d` |
| `line_height_sp/level16` | `67:24381` | FLOAT | 68 | 60 | 56 | 72 | `b7d65f2bf58e4d14b7c821fd7d7d169273d33fab` |
| `line_height_sp/level15` | `67:24385` | FLOAT | 64 | 55 | 53 | 68 | `2f806d52e21bc5d6157be1c2d7dbd98d475d5fa7` |
| `radius/top_left/level5` | `67:25529` | FLOAT | 16 | 14 | 13 | 17 | `8a684db63cccef959fe67d21901bb25ecbed0c28` |
| `radius/top_right/level5` | `67:25530` | FLOAT | 16 | 14 | 13 | 17 | `da09fe3855dd2c514918cce2f5e7e4608338f9ad` |
| `radius/bottom_left/level5` | `67:25531` | FLOAT | 16 | 14 | 13 | 17 | `6e308bda8b2696ed3bedf0a08e4c89194529532a` |
| `radius/bottom_right/level5` | `67:25532` | FLOAT | 16 | 14 | 13 | 17 | `62fc398c250ad848e60d80ac705d49e681b50a62` |
| `line/level1` | `67:25533` | FLOAT | 1 | 1 | 1 | 1 | `0d2ff57057fd83040ee55a1216640a8199b74e55` |
| `square/level8` | `67:25614` | FLOAT | 40 | 35 | 33 | 42 | `89835874000f967be3c8284b795737a9984ba675` |
| `radius/top_left/level4` | `67:25687` | FLOAT | 12 | 11 | 10 | 13 | `a970ab020fcf1d5362803da01bc47dd7bf91419b` |
| `radius/top_right/level4` | `67:25689` | FLOAT | 12 | 11 | 10 | 13 | `c5d067b38a1989ef329a8d282c3b62e0a3dc5437` |
| `radius/bottom_left/level4` | `67:25691` | FLOAT | 12 | 11 | 10 | 13 | `ba0f47736a5e029ef2b4f664a2a0ef800c5a3f22` |
| `radius/bottom_right/level4` | `67:25693` | FLOAT | 12 | 11 | 10 | 13 | `096fe2edb7f15f62856d1ef294514b1d2cf52ec0` |
| `square/level18` | `67:28890` | FLOAT | 80 | 70 | 66 | 84 | `7a9bd8d67d70b5df6e21c73e44ff02c00a955852` |
| `line/level4` | `67:33558` | FLOAT | 4 | 4 | 3 | 4 | `32507abb8cddede9f68035d24d16c21af985dc92` |
| `shadow/level3/blur1` | `67:33928` | FLOAT | 40 | 35 | 33 | 42 | `87f0e8b4880baec730644d3cc6e067c2a4a2a9f6` |
| `shadow/level3/y1` | `67:33929` | FLOAT | 20 | 18 | 17 | 22 | `f1c2cbac8176fc878ed8fce36dfac47f7c7e46cc` |
| `shadow/level3/blur2` | `67:33930` | FLOAT | 4 | 4 | 3 | 4 | `d20353756826c4b8c5a61250842c2576436463b6` |
| `shadow/level3/y2` | `67:33931` | FLOAT | 2 | 2 | 2 | 3 | `e36caccd27ceced916a13fc94a5cf9e5145d82f3` |
| `square/level22` | `67:33961` | FLOAT | 100 | 88 | 83 | 106 | `9ce313aa2803abaa7864ea3d82c8a25a968b7f39` |

## gleo.sys.color — 67:15073

- collection key: `faa653ec6d75ba16fc25998f139118e0e5abb9c6`
- 모드 식별자: `Mode 1=38763:0`

| Token | ID | Type | Mode 1 | Key |
| --- | --- | --- | --- | --- |
| `gleo_blue` | `67:15074` | COLOR | #596BFFFF | `4799f1b0b68721ceefce7514ca8c325725f829fb` |

## Number — 67:21941

- collection key: `60241c1e1396529afe95b81b9c5162329493edab`
- 모드 식별자: `Mode 1=11493:8`

| Token | ID | Type | Mode 1 | Key |
| --- | --- | --- | --- | --- |
| `Spacing/0` | `67:22333` | FLOAT | 0 | `adb976edbe2b8cb64e3e3f9d0e99984d894cf8fa` |
| `Common/20` | `67:22442` | FLOAT | 20 | `25f5f28263cd6412b1a4394c3e0977356249fe46` |
| `Radius/xs` | `67:27352` | FLOAT | 0 | `8b1343a7187bde96da5103590484d1d3a58c28d6` |
| `Radius/l` | `67:32624` | FLOAT | 24 | `45e806eb4249c434832a07383662f7c70d0c9117` |
| `Radius/circle` | `67:33560` | FLOAT | 999 | `011abf0e8a244a16038faeca8672b4823a503af6` |

## Number — 39667:4698

- collection key: `04bfd9277fd46d7a80b0f54e8a6d24869029a194`
- 모드 식별자: `Mode 1=11493:8`

| Token | ID | Type | Mode 1 | Key |
| --- | --- | --- | --- | --- |
| `Common/24` | `39667:4699` | FLOAT | 24 | `b2d142512a499e3ca3beeab48ac6f9032871eb88` |

## theme — 39667:4700

- collection key: `65260167b73fc0390d7bab2ceb97e83dd2564bab`
- 모드 식별자: `Hyundai-Light=100286:0`, `Hyundai-Dark=100286:1`, `Kia-Light=100286:2`, `Kia-Dark=100286:3`, `Genesis-Light=100286:4`, `Genesis-Dark=100286:5`

| Token | ID | Type | Hyundai-Light | Hyundai-Dark | Kia-Light | Kia-Dark | Genesis-Light | Genesis-Dark | Key |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `color/alpha/dark/200` | `39667:4701` | COLOR | #13141733 | #FFFFFF33 | #161A1D33 | #F5FBFF33 | #13141733 | #FFFFFF33 | `daeda483c5e70550c88849bb367f81c6496f36d4` |
| `color/divider/secondary` | `39667:4702` | COLOR | #13141733; alias → color/alpha/dark/200 @39667:4701 | #FFFFFF33; alias → color/alpha/dark/200 @39667:4701 | #161A1D33; alias → color/alpha/dark/200 @39667:4701 | #F5FBFF33; alias → color/alpha/dark/200 @39667:4701 | #13141733; alias → color/alpha/dark/200 @39667:4701 | #FFFFFF33; alias → color/alpha/dark/200 @39667:4701 | `3e7eeac2e0d2ac3593c789df4d9de0aad8d87369` |

## Global — 39667:4703

- collection key: `5077c869475e85869015c5f33a10158140d2c605`
- 모드 식별자: `Mode 1=24384:3`

| Token | ID | Type | Mode 1 | Key |
| --- | --- | --- | --- | --- |
| `Color/Neutral/60` | `39667:4704` | COLOR | #737373FF | `e486ac38992e2d6f2e912a7ec3f0a4c83cc32137` |

## 해석 결과

- 변수 722개, 해석되지 않은 모드 entry 0개.
- 같은 이름의 컬렉션이라도 원본 ID와 key가 다르면 별도로 유지한다.
- 바인딩된 컴포넌트에서는 토큰의 컬러와 노드/paint opacity를 중복 곱하지 않도록 원본 색상 구조를 확인한다.


## 모드명 정규화 내역

제어문자 U+0008이 붙은 connect-waterfall과 제어문자 없는 동명 모드만 연결했다. 숫자값은 해당 대상 variable entry의 원본 값을 사용했다.

| 요청 Token | 대상 Variable ID | 요청 Mode ID | 연결 Mode ID |
| --- | --- | --- | --- |
| dropdown/container/prefix_app_icon_border @67:25569 | 67:25533 | 33235:0 | 33235:1 |
| dropdown/medium/prefix/icon_square @67:25615 | 67:25614 | 33235:0 | 33235:1 |
| dropdown/prefix/medium/app_icon_radius_top_left @67:25688 | 67:25687 | 33235:0 | 33235:1 |
| dropdown/prefix/medium/app_icon_radius_top_right @67:25690 | 67:25689 | 33235:0 | 33235:1 |
| dropdown/prefix/medium/app_icon_radius_bottom_left @67:25692 | 67:25691 | 33235:0 | 33235:1 |
| dropdown/prefix/medium/app_icon_radius_bottom_right @67:25694 | 67:25693 | 33235:0 | 33235:1 |
| imagery/profile/circle @67:28891 | 67:28890 | 33235:0 | 33235:1 |
| popup/system/list/item/icon_square @67:28907 | 67:28890 | 33235:0 | 33235:1 |
| selections/checkbox/normal_button_border @67:33559 | 67:33558 | 33235:0 | 33235:1 |
| os_notification/contents/image_square @67:33962 | 67:33961 | 33235:0 | 33235:1 |
| os_notification/contents/image_thumb_radius @67:33963 | 67:25529 | 33235:0 | 33235:1 |