# Figma guide — 전체 변수 토큰

> **적용 주의:** 이 파일은 첨부의 원본 추출 증거다. 웹과 상충하는 값은 최종 구현에서 사용하지 않는다. 01·02·03·08번의 최신 웹 값과 `data/web_color_tokens.json` override가 우선한다.

사용자가 첨부한 `.fig` 파일의 내장 Kiwi 스키마와 노드에서 직접 추출한 값이다. 웹 연결 없이 이 표를 사용한다. 파일 간 같은 이름의 토큰과 collection은 자동 병합하지 않는다. 모든 수치는 원본 design unit이며 dp/sp 환산이나 기준 density를 뜻하지 않는다.

컬러 표기 `#RRGGBBAA`는 RGBA 순서다. Kotlin ARGB에는 AARRGGBB로 재배열한다. `alias → id`의 값은 해당 모드 ID, 동명 모드, 단일값 순서로 해석했다. 추가로 모드명의 제어문자를 제거한 이름이 유일하게 일치하면 연결하고 아래 정규화 내역에 ID를 기록했다. `UNRESOLVED` 값은 임의로 만들어 쓰지 않는다. `—`는 해당 모드 entry가 원본에 없다는 뜻이다. 모드 이름의 `[U+0008]`는 원본 제어문자를 가독성 있게 표기한 것이다.

동일 값도 원본 variable key를 보존해 병합 여부를 판단한다. 특히 guide 파일의 과거/신규 collection을 분리한다.

## Color Palette — 2003:10010

- collection key: `3b4c36d320aebb69b50891fbf4c5ea88a88a017f`
- 모드 식별자: `Light=11229:5`, `Dark=11486:7`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `basic/900-updated` | `1:3` | COLOR | #131417FF | #FFFFFFFF | `846cb6451492d1ff8f934894b5425b0c254b8070` |
| `system/label/gray_primary` | `1:4` | COLOR | #131417FF; alias → color/basic/900 @1:6560 | #FFFFFFFF; alias → color/basic/900 @1:6560 | `14df2c9fa6625e3ad073b6436d57c3e6e1f8238f` |
| `fixed/dark/100` | `1:6247` | COLOR | #131417FF | #131417FF | `3a596029a132077d10a70214b403b266dfc26827` |
| `fixed/light/100` | `1:6265` | COLOR | #FFFFFFFF | #FFFFFFFF | `d4951cf9d4f4d09abd9b0329943ec0765d96ad1a` |
| `text/dark/primary` | `1:6288` | COLOR | #131417FF; alias → basic/static/dark_primary-updated @2003:12672 | #FFFFFFFF; alias → basic/static/light_primary @2003:13201 | `14df2c9fa6625e3ad073b6436d57c3e6e1f8238f` |
| `fixed/dark/400` | `1:6315` | COLOR | #13141752 | #13141752 | `488a5f006274a51e21ced5715a006ab9d21f6dba` |
| `fixed/light/400` | `1:6316` | COLOR | #FFFFFF52 | #FFFFFF52 | `a5501ce31fd96766fe40e3590beee276606cee51` |
| `color/basic/00` | `1:6559` | COLOR | #FFFFFFFF | #131417FF | `e97c0d271cf16ffebac08dd554144f4ecd54f4f5` |
| `color/basic/900` | `1:6560` | COLOR | #131417FF | #FFFFFFFF | `846cb6451492d1ff8f934894b5425b0c254b8070` |
| `text/dark/quaternary` | `1:6809` | COLOR | #13141752; alias → color/static/dark/400 @2003:7062 | #FFFFFF52; alias → color/static/light/400 @2003:7063 | `21a4aa9245829daf76ba70837fecae1a36db75b5` |
| `basic/200` | `2003:5570` | COLOR | #E0E1E6FF | #44464EFF | `df1d9798c5631da1dc096cd3cc0eeed5b53bbe25` |
| `surface/accent` | `2003:5571` | COLOR | #E0E1E6FF; alias → basic/200 @2003:5570 | #44464EFF; alias → basic/200 @2003:5570 | `a8709086460ae36590e439122d0024e3a55025ba` |
| `phone/accept_normal` | `2003:5577` | COLOR | #32B957FF | #3BD665FF | `300df643135364c3feeec93b9ba8b7f4c36a3d80` |
| `static/dark/100` | `2003:5578` | COLOR | #131417FF | #131417FF | `3a596029a132077d10a70214b403b266dfc26827` |
| `static/light/100` | `2003:5579` | COLOR | #FFFFFFFF | #FFFFFFFF | `d4951cf9d4f4d09abd9b0329943ec0765d96ad1a` |
| `icon/dark/primary` | `2003:5580` | COLOR | #131417FF; alias → basic/static/dark_primary-updated @2003:12672 | #FFFFFFFF; alias → basic/static/light_primary @2003:13201 | `c47339d1c81fe901c5f505df9394d01f8f5534e7` |
| `_Legacy/Scale/Black/Black` | `2003:5581` | COLOR | #000000FF | #FFFFFFFF | `afa71b827071692576ba14016c33eef0b6489f5a` |
| `phone/end_normal` | `2003:5582` | COLOR | #FE3D16FF | #FF4C28FF | `6fba0b3597a8cac8cebbcbf5405d86908961c025` |
| `_Legacy/Solid/Cool/900` | `2003:5583` | COLOR | #1B1D21FF | #F0F1F5FF | `7ddff47e978053806ec7cc1a621249b3d172b433` |
| `static/dark/300` | `2003:5584` | COLOR | #131417A3 | #131417A3 | `8199f9bfde3536e49622e6d621ea34d89191ad77` |
| `static/light/300` | `2003:5585` | COLOR | #FFFFFFA3 | #FFFFFFA3 | `12b1fb17e28d834c210e40098141dbc87099e1a5` |
| `icon/dark/tertiary` | `2003:5586` | COLOR | #131417A3; alias → color/static/dark/300 @2003:7086 | #FFFFFFA3; alias → color/static/light/300 @2003:7087 | `6217f85f0e260029d8bcb5536aff5be0a9889566` |
| `phone/accept_pressed` | `2003:5630` | COLOR | #279E47FF | #2DB752FF | `8a66689c79829eaff10ac26bd207cd196e0ba08c` |
| `alpha/dark/50` | `2003:5631` | COLOR | #1314170D | #FFFFFF0D | `4bfff6967f17ded1a6ff76a11cdf62bf8490195d` |
| `alpha/dark/100` | `2003:5632` | COLOR | #1314171A | #FFFFFF1A | `463cbbf1a83157697a94c95137252f9bc9b1bd89` |
| `dim/dark/secondary` | `2003:5633` | COLOR | #1314171A; alias → basic/alpha/dark_100 @2003:12675 | #FFFFFF1A; alias → basic/alpha/dark_100 @2003:12675 | `a9b1a3e00bf19d872294df4eb00e2b540b17401f` |
| `phone/end_pressed` | `2003:5634` | COLOR | #E73612FF | #DF4323FF | `e7306cf334528609e7e5bcdec7b9a17e0fd0a7f6` |
| `informative/positive` | `2003:5635` | COLOR | #0064FFFF | #0082FFFF | `89977fb7e40e5fcccf79e38f40799bee71890ac2` |
| `alpha/dark/200` | `2003:5646` | COLOR | #13141733 | #FFFFFF33 | `4c7eca7c799f3814ac6d94a1cbb9b3cc4d6977d6` |
| `dim/dark/tertiary` | `2003:5647` | COLOR | #13141733; alias → basic/alpha/dark_200 @2003:13814 | #FFFFFF33; alias → basic/alpha/dark_200 @2003:13814 | `cbb7e7fb5628575b4244b5b62ce38b03716b4408` |
| `informative/active` | `2003:5648` | COLOR | #02C265FF | #00E074FF | `db193e04e9357ddb3ad6ce7dd43706973a511044` |
| `static/light/400` | `2003:5735` | COLOR | #FFFFFF52 | #FFFFFF52 | `a5501ce31fd96766fe40e3590beee276606cee51` |
| `static/dark/200` | `2003:5755` | COLOR | #131417D6 | #131417D6 | `6f3bbc268a4b92d2786374cfae8c4f4c5b3c90a7` |
| `text/dark/primary` | `2003:5872` | COLOR | #131417FF; alias → basic/static/dark_primary-updated @2003:12672 | #FFFFFFFF; alias → basic/static/light_primary @2003:13201 | `14df2c9fa6625e3ad073b6436d57c3e6e1f8238f` |
| `text/dark/tertiary` | `2003:5873` | COLOR | #131417A3; alias → color/static/dark/300 @2003:7086 | #FFFFFFA3; alias → color/static/light/300 @2003:7087 | `178132021dc819d784efa7d5c52714e360950c72` |
| `static/dark/100` | `2003:6059` | COLOR | #131417FF | #131417FF | `3a596029a132077d10a70214b403b266dfc26827` |
| `static/light/100` | `2003:6060` | COLOR | #FFFFFFFF | #FFFFFFFF | `d4951cf9d4f4d09abd9b0329943ec0765d96ad1a` |
| `icon/dark/primary` | `2003:6061` | COLOR | #131417FF; alias → basic/static/dark_primary-updated @2003:12672 | #FFFFFFFF; alias → basic/static/light_primary @2003:13201 | `c47339d1c81fe901c5f505df9394d01f8f5534e7` |
| `color/informative/autonomous_driving` | `2003:6331` | COLOR | #5A46FAFF | #6A57FFFF | `1a98410b5ba0768b19fe12a48b63a69f348310d7` |
| `color/driving_view/gradient_start-updated` | `2003:7012` | COLOR | #FFFFFF00 | #13141700 | `dfae5027aca247894f69fe79fafcf8e620565c65` |
| `color/driving_view/gradient_end` | `2003:7013` | COLOR | #FFFFFFFF; alias → basic/00-updated @2003:12654 | #131417FF; alias → basic/00-updated @2003:12654 | `081ca5a600922a7eb47ec9453d83363a3c56bba9` |
| `color/basic/100` | `2003:7052` | COLOR | #EDEEF2FF | #313236FF | `b7a05139a2c72eb8a3d2bc0895bf4d09ab607fbe` |
| `color/background/popup` | `2003:7053` | COLOR | #FFFFFFFF; alias → basic/00-updated @2003:12654 | #313236FF; alias → color/basic/100 @2003:7052 | `2cb1e98b7360755f3554e6c65607ef8d12f1aaca` |
| `color/alpha/dark/100` | `2003:7054` | COLOR | #1314171A | #FFFFFF1A | `463cbbf1a83157697a94c95137252f9bc9b1bd89` |
| `color/divider/secondary` | `2003:7055` | COLOR | #1314171A; alias → basic/alpha/dark_100 @2003:12675 | #FFFFFF1A; alias → basic/alpha/dark_100 @2003:12675 | `ba0be104a8c6e3192c11fb60c32be45aa76ef9a2` |
| `color/static/dark/400` | `2003:7062` | COLOR | #13141752 | #13141752 | `488a5f006274a51e21ced5715a006ab9d21f6dba` |
| `color/static/light/400` | `2003:7063` | COLOR | #FFFFFF52 | #FFFFFF52 | `a5501ce31fd96766fe40e3590beee276606cee51` |
| `color/icon/dark/quaternary` | `2003:7064` | COLOR | #13141752; alias → color/static/dark/400 @2003:7062 | #FFFFFF52; alias → color/static/light/400 @2003:7063 | `d796e7dd62c576764c1fc3e7b5eef9daec9fb3fa` |
| `color/static/dark/100` | `2003:7068` | COLOR | #131417FF | #131417FF | `3a596029a132077d10a70214b403b266dfc26827` |
| `color/static/light/100` | `2003:7069` | COLOR | #FFFFFFFF | #FFFFFFFF | `d4951cf9d4f4d09abd9b0329943ec0765d96ad1a` |
| `color/icon/dark/primary` | `2003:7070` | COLOR | #131417FF; alias → basic/static/dark_primary-updated @2003:12672 | #FFFFFFFF; alias → basic/static/light_primary @2003:13201 | `c47339d1c81fe901c5f505df9394d01f8f5534e7` |
| `color/static/dark/300` | `2003:7086` | COLOR | #131417A3 | #131417A3 | `8199f9bfde3536e49622e6d621ea34d89191ad77` |
| `color/static/light/300` | `2003:7087` | COLOR | #FFFFFFA3 | #FFFFFFA3 | `12b1fb17e28d834c210e40098141dbc87099e1a5` |
| `color/icon/dark/tertiary` | `2003:7088` | COLOR | #131417A3; alias → color/static/dark/300 @2003:7086 | #FFFFFFA3; alias → color/static/light/300 @2003:7087 | `6217f85f0e260029d8bcb5536aff5be0a9889566` |
| `color/text/dark/primary` | `2003:7104` | COLOR | #131417FF; alias → basic/static/dark_primary-updated @2003:12672 | #FFFFFFFF; alias → basic/static/light_primary @2003:13201 | `14df2c9fa6625e3ad073b6436d57c3e6e1f8238f` |
| `color/alpha/dark/50` | `2003:7110` | COLOR | #1314170D | #FFFFFF0D | `4bfff6967f17ded1a6ff76a11cdf62bf8490195d` |
| `color/button/basic/enabled` | `2003:7111` | COLOR | #1314170D; alias → basic/alpha/dark_50 @2003:13795 | #FFFFFF0D; alias → basic/alpha/dark_50 @2003:13795 | `2e05e6570d5ccbfcbd0ba780093ebe7f690cd3f3` |
| `color/button/basic/pressed` | `2003:7131` | COLOR | #1314171A; alias → basic/alpha/dark_100 @2003:12675 | #FFFFFF1A; alias → basic/alpha/dark_100 @2003:12675 | `6a1b30818fec325862bff11275112f86c68a8eaa` |
| `_Legacy/Scale/White/300` | `2003:7154` | COLOR | #FFFFFF29 | #1515151F | `4188533b83aa351a28d02d1c2df08f4a5427502f` |
| `_Legacy/Scale/White/White` | `2003:7155` | COLOR | #FFFFFFFF | #000000FF | `1c41e73a8d5c6d8e42e4839bf77d7f1824547889` |
| `color/text/light/tertiary` | `2003:7156` | COLOR | #FFFFFFA3; alias → color/static/light/300 @2003:7087 | #131417A3; alias → color/static/dark/300 @2003:7086 | `a48fe4ce2dd228c6ffcec4a60fb3319232ba3cba` |
| `color/regulation/red` | `2003:7157` | COLOR | #F62E24FF | #FF4339FF | `204522a772d874faa205d9833e52cdac29042ff7` |
| `color/regulation/orange` | `2003:7374` | COLOR | #FF8A00FF | #FF8A00FF | `4f113e309e276bcc22e4c8a7a778f74f11a39849` |
| `_Feature/Driving/Normal/Positive` | `2003:7409` | COLOR | #00BA13FF | #00BA13FF | `7b924dd42f3f5c3892c4345cc68eb009c19af52a` |
| `_Legacy/Scale/Black/Black` | `2003:7410` | COLOR | #000000FF | #FFFFFFFF | `afa71b827071692576ba14016c33eef0b6489f5a` |
| `System/Grayscale/Opaque/White` | `2003:7411` | COLOR | #FFFFFFFF | #FFFFFFFF | `35c31d80c9cda12682f1db3e14dc2f709e1ae537` |
| `color/text/dark/tertiary` | `2003:7447` | COLOR | #131417A3; alias → color/static/dark/300 @2003:7086 | #FFFFFFA3; alias → color/static/light/300 @2003:7087 | `178132021dc819d784efa7d5c52714e360950c72` |
| `color/regulation/blue` | `2003:7555` | COLOR | #0064FFFF | #0082FFFF | `688b07725256afc18b0702343eae888fedbe4d33` |
| `color/regulation/green` | `2003:7556` | COLOR | #00BA13FF | #55F165FF | `85df23117f674d97094f4f9fceefce23a1e83790` |
| `_Feature/Driving/Normal/Alert` | `2003:7557` | COLOR | #FF8A00FF | #FF8A00FF | `dbdba4ea8bb2350b444a3f22ea8c313716ef4548` |
| `_Feature/Driving/Normal/Warning` | `2003:7559` | COLOR | #FFA133FF | #FFA133FF | `6dd1706b488cbe3f7a3c95a70b8189b795bc6940` |
| `color/icon/light/primary` | `2003:7560` | COLOR | #FFFFFFFF; alias → basic/static/light_primary @2003:13201 | #131417FF; alias → basic/static/dark_primary-updated @2003:12672 | `613ebec7e109bcbf2a5a0d973fd08393a6d97f9b` |
| `System/Grayscale/Opaque/Black` | `2003:7561` | COLOR | #000000FF | #000000FF | `307583f083c27ed9ba0fc7ae13e9e0554bfd3324` |
| `color/basic/50` | `2003:7562` | COLOR | #F7F8FAFF | #1D1E21FF | `04794a310e8b06e00a4e5f12deb044794a13d161` |
| `color/surface/basic` | `2003:7563` | COLOR | #FFFFFFFF; alias → basic/00-updated @2003:12654 | #1D1E21FF; alias → color/basic/50 @2003:7562 | `054af1706a52e265ebb83d64dd8a5a8458019307` |
| `_Feature/Driving/Normal/Danger` | `2003:7564` | COLOR | #FF2E00FF | #FF2E00FF | `2087944550b26cda2311b12828ecf9a1d53a69fd` |
| `color/static/dark/200` | `2003:8048` | COLOR | #131417D6 | #131417D6 | `6f3bbc268a4b92d2786374cfae8c4f4c5b3c90a7` |
| `color/static/light/200` | `2003:8049` | COLOR | #FFFFFFD6 | #FFFFFFD6 | `713460e45f03136eb26b1561bc75f1adbc0ad9f4` |
| `color/text/dark/secondary` | `2003:8050` | COLOR | #131417D6; alias → color/static/dark/200 @2003:8048 | #FFFFFFD6; alias → color/static/light/200 @2003:8049 | `a56505703be1f948614f8b77d5ed1ec3f0ed4be2` |
| `color/alpha/light/200` | `2003:8139` | COLOR | #FFFFFF33 | #13141733 | `0d21755dfe4aa4acb1f70f0e58edf1a68f98ddb8` |
| `color/button/basic/disabled` | `2003:8140` | COLOR | #FFFFFF33; alias → color/alpha/light/200 @2003:8139 | #13141733; alias → color/alpha/light/200 @2003:8139 | `d6f2124cda29083d9374e309cf7bab51f46b9e4a` |
| `color/text/dark/quaternary` | `2003:8141` | COLOR | #13141752; alias → color/static/dark/400 @2003:7062 | #FFFFFF52; alias → color/static/light/400 @2003:7063 | `21a4aa9245829daf76ba70837fecae1a36db75b5` |
| `color/basic/600` | `2003:8157` | COLOR | #44464EFF | #E0E1E6FF | `6871dab1a349471b2840f21f09f54a64a8774c7e` |
| `color/button/filled/enabled` | `2003:8158` | COLOR | #44464EFF; alias → color/basic/600 @2003:8157 | #E0E1E6FF; alias → color/basic/600 @2003:8157 | `c0658d660004f4b9d29603a3d41646cb292729d3` |
| `color/text/light/primary` | `2003:8159` | COLOR | #FFFFFFFF; alias → basic/static/light_primary @2003:13201 | #131417FF; alias → basic/static/dark_primary-updated @2003:12672 | `c1461c14bf2974923dd10ffb4ac039f25b2d93c2` |
| `color/basic/700` | `2003:8160` | COLOR | #313236FF | #EDEEF2FF | `044a4b3a3619b9db566a64bdf76784f4c6db5744` |
| `color/basic/500` | `2003:8161` | COLOR | #686A72FF | #C7C9CEFF | `07abc4f67940db543a39f0f83e8bf9d846d20f3f` |
| `color/button/filled/pressed` | `2003:8162` | COLOR | #313236FF; alias → color/basic/700 @2003:8160 | #C7C9CEFF; alias → color/basic/500 @2003:8161 | `44a91308fa78194b85f692037b40a74d1a56aaff` |
| `color/button/filled/disabled` | `2003:8163` | COLOR | #1314170D; alias → basic/alpha/dark_50 @2003:13795 | #FFFFFF0D; alias → basic/alpha/dark_50 @2003:13795 | `258f76d79a5e6ebc1f13582b145b9c2f94715cab` |
| `color/dim/dark/primary` | `2003:8373` | COLOR | #1314170D; alias → basic/alpha/dark_50 @2003:13795 | #FFFFFF0D; alias → basic/alpha/dark_50 @2003:13795 | `c741481a3ecd88940053d90830f9faf169eacb54` |
| `color/divider/primary` | `2003:8374` | COLOR | #1314170D; alias → basic/alpha/dark_50 @2003:13795 | #FFFFFF0D; alias → basic/alpha/dark_50 @2003:13795 | `0c6e24c70ceb6a5104b57fcd4fe3a82e3c07c625` |
| `color/alpha/light/500` | `2003:8402` | COLOR | #FFFFFF80 | #13141780 | `ec8e01b09f3af453afd50bd46ab776e2cf708082` |
| `color/dim/light/primary` | `2003:8403` | COLOR | #FFFFFF80; alias → color/alpha/light/500 @2003:8402 | #13141780; alias → color/alpha/light/500 @2003:8402 | `60d6d8ee02c3bf47585bba1d46e768656d82b734` |
| `color/alpha/dark/200` | `2003:8626` | COLOR | #13141733 | #FFFFFF33 | `4c7eca7c799f3814ac6d94a1cbb9b3cc4d6977d6` |
| `color/dim/dark/tertiary` | `2003:8627` | COLOR | #13141733; alias → basic/alpha/dark_200 @2003:13814 | #FFFFFF33; alias → basic/alpha/dark_200 @2003:13814 | `cbb7e7fb5628575b4244b5b62ce38b03716b4408` |
| `color/driving_view/charging_primary` | `2003:8852` | COLOR | #00DB25FF | #00DB25FF | `a54a80b542fa592383837620441abe40a09fe7a6` |
| `color/text/light/secondary` | `2003:9752` | COLOR | #FFFFFFD6; alias → color/static/light/200 @2003:8049 | #131417D6; alias → color/static/dark/200 @2003:8048 | `920e4adc2019bda87edd59f79d22a7ed725582ad` |
| `color/alpha/light/100` | `2003:9932` | COLOR | #FFFFFF1A | #1314171A | `c75470bdce25368037a9c0e6d541ce52bcacdde2` |
| `White` | `2003:10011` | COLOR | #FFFFFFFF | #FFFFFFFF | `5511243a0be16926a814f54970f4647fd6cf558e` |
| `color/icon/dark/secondary` | `2003:10323` | COLOR | #131417D6; alias → color/static/dark/200 @2003:8048 | #FFFFFFD6; alias → color/static/light/200 @2003:8049 | `684fa11e8a6df5f06eec784657f2fde399ce279a` |
| `color/alpha/dark/400` | `2003:10460` | COLOR | #13141766 | #FFFFFF66 | `c25c70f578cde526cb6cfcbffb2254bef77bebe4` |
| `color/informative/active` | `2003:10506` | COLOR | #02C265FF | #00E074FF | `db193e04e9357ddb3ad6ce7dd43706973a511044` |
| `color/switch/on` | `2003:10507` | COLOR | #02C265FF; alias → system/informative/active @2003:12652 | #00E074FF; alias → system/informative/active @2003:12652 | `13875f4faa0cf7fcf1286e257c3d9d5fc2a84856` |
| `color/switch/knob_on` | `2003:10517` | COLOR | #FFFFFFFF; alias → basic/00-updated @2003:12654 | #FFFFFFFF; alias → color/basic/900 @1:6560 | `cdfa4123f144adaec0e0b25ab5eaa639425dd2b6` |
| `color/alpha/dark/300` | `2003:10534` | COLOR | #1314174D | #FFFFFF4D | `c1049d0d62209dbb672466a9086eb8c0f6ad7764` |
| `color/switch/off` | `2003:10535` | COLOR | #1314174D; alias → basic/alpha/dark_300 @2003:12674 | #FFFFFF1A; alias → basic/alpha/dark_100 @2003:12675 | `587e123e5dc5adc793f8e4c96f99ce75bb5dab11` |
| `Brand/Teritary/Black` | `2003:10625` | COLOR | #000000FF; alias → _Legacy/Scale/Black/Black @2003:7410 | #000000FF; alias → _Legacy/Scale/White/White @2003:7155 | `ff0a7fb93051dcf1636f0ddfb8b1ca544701f94d` |
| `Brand/Teritary/White` | `2003:10626` | COLOR | #FFFFFFFF; alias → _Legacy/Scale/White/White @2003:7155 | #FFFFFFFF; alias → _Legacy/Scale/Black/Black @2003:7410 | `440d7f40a6fefbc68bed423f39c77d5306b08f3a` |
| `color/regulation/yellow` | `2003:10627` | COLOR | #FFC224FF | #FFC224FF | `f04ee896b6f6b76fb71721644bd921bbbd23b6d8` |
| `color/dim/dark/secondary` | `2003:11721` | COLOR | #1314171A; alias → basic/alpha/dark_100 @2003:12675 | #FFFFFF1A; alias → basic/alpha/dark_100 @2003:12675 | `a9b1a3e00bf19d872294df4eb00e2b540b17401f` |
| `icon/light/primary` | `2003:12111` | COLOR | #FFFFFFFF; alias → basic/static/light_primary @2003:13201 | #131417FF; alias → basic/static/dark_primary-updated @2003:12672 | `613ebec7e109bcbf2a5a0d973fd08393a6d97f9b` |
| `system/informative/active` | `2003:12652` | COLOR | #02C265FF | #00E074FF | `db193e04e9357ddb3ad6ce7dd43706973a511044` |
| `system/switch/background_on` | `2003:12653` | COLOR | #02C265FF; alias → system/informative/active @2003:12652 | #00E074FF; alias → system/informative/active @2003:12652 | `13875f4faa0cf7fcf1286e257c3d9d5fc2a84856` |
| `basic/00-updated` | `2003:12654` | COLOR | #FFFFFFFF | #131417FF | `e97c0d271cf16ffebac08dd554144f4ecd54f4f5` |
| `system/switch/button_on` | `2003:12655` | COLOR | #FFFFFFFF; alias → basic/00-updated @2003:12654 | #FFFFFFFF; alias → color/basic/900 @1:6560 | `cdfa4123f144adaec0e0b25ab5eaa639425dd2b6` |
| `system/icon/gray_primary` | `2003:12656` | COLOR | #131417FF; alias → color/basic/900 @1:6560 | #FFFFFFFF; alias → color/basic/900 @1:6560 | `c47339d1c81fe901c5f505df9394d01f8f5534e7` |
| `basic/static/dark_primary-updated` | `2003:12672` | COLOR | #131417FF | #131417FF | `3a596029a132077d10a70214b403b266dfc26827` |
| `system/label/gray_secondary` | `2003:12673` | COLOR | #1B1C1ED6 | #FFFFFFD6 | `a56505703be1f948614f8b77d5ed1ec3f0ed4be2` |
| `basic/alpha/dark_300` | `2003:12674` | COLOR | #1314174D | #FFFFFF4D | `c1049d0d62209dbb672466a9086eb8c0f6ad7764` |
| `basic/alpha/dark_100` | `2003:12675` | COLOR | #1314171A | #FFFFFF1A | `463cbbf1a83157697a94c95137252f9bc9b1bd89` |
| `system/switch/background_off` | `2003:12676` | COLOR | #1314174D; alias → basic/alpha/dark_300 @2003:12674 | #FFFFFF1A; alias → basic/alpha/dark_100 @2003:12675 | `587e123e5dc5adc793f8e4c96f99ce75bb5dab11` |
| `system/label/gray_tertiary` | `2003:12694` | COLOR | #1B1C1EA3 | #FFFFFFA3 | `178132021dc819d784efa7d5c52714e360950c72` |
| `system/regulation/blue` | `2003:12699` | COLOR | #0064FFFF | #0082FFFF | `688b07725256afc18b0702343eae888fedbe4d33` |
| `system/regulation/red` | `2003:12700` | COLOR | #F62E24FF | #FF4339FF | `204522a772d874faa205d9833e52cdac29042ff7` |
| `system/regulation/orange` | `2003:12701` | COLOR | #FF8A00FF | #FF8A00FF | `4f113e309e276bcc22e4c8a7a778f74f11a39849` |
| `system/regulation/green` | `2003:12702` | COLOR | #00BA13FF | #55F165FF | `85df23117f674d97094f4f9fceefce23a1e83790` |
| `system/icon/white_primary` | `2003:12703` | COLOR | #FFFFFFFF; alias → basic/00-updated @2003:12654 | #131417FF; alias → basic/00-updated @2003:12654 | `613ebec7e109bcbf2a5a0d973fd08393a6d97f9b` |
| `system/informative/autonomous_driving` | `2003:12704` | COLOR | #5A46FAFF | #6A57FFFF | `1a98410b5ba0768b19fe12a48b63a69f348310d7` |
| `system/icon/gray_quaternary` | `2003:13180` | COLOR | #13141752 | #FFFFFF52 | `d796e7dd62c576764c1fc3e7b5eef9daec9fb3fa` |
| `system/label/gray_quaternary` | `2003:13181` | COLOR | #1B1C1E52 | #FFFFFF52 | `21a4aa9245829daf76ba70837fecae1a36db75b5` |
| `basic/static/light_primary` | `2003:13201` | COLOR | #FFFFFFFF | #FFFFFFFF | `d4951cf9d4f4d09abd9b0329943ec0765d96ad1a` |
| `system/regulation/yellow` | `2003:13202` | COLOR | #FFC224FF | #FFC224FF | `f04ee896b6f6b76fb71721644bd921bbbd23b6d8` |
| `feature/driving_view/gradient_end-updated` | `2003:13203` | COLOR | #FFFFFFFF; alias → basic/00-updated @2003:12654 | #131417FF; alias → basic/00-updated @2003:12654 | `081ca5a600922a7eb47ec9453d83363a3c56bba9` |
| `feature/driving_view/gradient_start-updated` | `2003:13204` | COLOR | #FFFFFF00 | #13141700 | `dfae5027aca247894f69fe79fafcf8e620565c65` |
| `basic/alpha/dark_50` | `2003:13795` | COLOR | #1314170D | #FFFFFF0D | `4bfff6967f17ded1a6ff76a11cdf62bf8490195d` |
| `system/dim/gray_primary` | `2003:13796` | COLOR | #1314170D; alias → basic/alpha/dark_50 @2003:13795 | #FFFFFF0D; alias → basic/alpha/dark_50 @2003:13795 | `c741481a3ecd88940053d90830f9faf169eacb54` |
| `system/icon/gray_tertiary` | `2003:13797` | COLOR | #131417A3 | #FFFFFFA3 | `6217f85f0e260029d8bcb5536aff5be0a9889566` |
| `basic/alpha/dark_200` | `2003:13814` | COLOR | #13141733 | #FFFFFF33 | `4c7eca7c799f3814ac6d94a1cbb9b3cc4d6977d6` |
| `system/dim/gray_tertiary` | `2003:13815` | COLOR | #13141733; alias → basic/alpha/dark_200 @2003:13814 | #FFFFFF33; alias → basic/alpha/dark_200 @2003:13814 | `cbb7e7fb5628575b4244b5b62ce38b03716b4408` |

## Number — 1:701

- collection key: `04bfd9277fd46d7a80b0f54e8a6d24869029a194`
- 모드 식별자: `Mode 1=11493:8`

| Token | ID | Type | Mode 1 | Key |
| --- | --- | --- | --- | --- |
| `Spacing/0` | `1:702` | FLOAT | 0 | `a762ed9517c1f5c2fafdb067f103e07e0688c288` |
| `Common/12` | `2003:7105` | FLOAT | 12 | `89799ece3661fcf3f607dfa156c90580ec47a756` |
| `Common/24` | `2003:7106` | FLOAT | 24 | `b2d142512a499e3ca3beeab48ac6f9032871eb88` |
| `Common/8` | `2003:7107` | FLOAT | 8 | `b45b6aef07ce51541b3031cb60819817d058abe4` |
| `Radius/m` | `2003:7109` | FLOAT | 16 | `ca404684a444bfe3e6fbc32ade4eea78e2756106` |
| `Common/40` | `2003:8365` | FLOAT | 40 | `6f38da9562bfe97d1497aa8e38f7e7730260f7fc` |
| `Common/48` | `2003:8366` | FLOAT | 48 | `92fd23af667c6f99d64d3be98631541776d71297` |
| `Common/4` | `2003:8367` | FLOAT | 4 | `498de518e275d25bcd70a06f4e63e6e7fa7c30cc` |
| `Common/16` | `2003:10509` | FLOAT | 16 | `b67722267b31878502eb266d5855da1067bb719d` |
| `Common/32` | `2003:10510` | FLOAT | 32 | `44dfe8a0d01c05095343e715d5e98136cf2cfd21` |

## Color — 1:5916

- collection key: `8d369c136481c57edd4ac2a7865a597579980813`
- 모드 식별자: `Light=2209:0`, `Dark=3636:0`, `Pleos=23275:0`

| Token | ID | Type | Light | Dark | Pleos | Key |
| --- | --- | --- | --- | --- | --- | --- |
| `Core/Desaturate/Neutral20` | `1:5917` | COLOR | #DDE1EBFF | #DDE1EBFF | #DDE1EBFF | `caf60619e13abb3db6ec141d9d4f183ebaee76a6` |
| `Core/Desaturate/Neutral75` | `1:5918` | COLOR | #2F3B57FF | #2F3B57FF | #2F3B57FF | `4a7ac0e439cdc53b36aa5c637753b91b51b77f3c` |
| `Line/Divider/Regular` | `1:5919` | COLOR | #DDE1EBFF; alias → Core/Desaturate/Neutral20 @1:5917 | #2F3B57FF; alias → Core/Desaturate/Neutral75 @1:5918 | #DDE1EBFF; alias → Core/Desaturate/Neutral20 @1:5917 | `8ee4ad5790d7907874a60fdc0b67217a478e6ce4` |
| `Core/Desaturate/Neutral90` | `1:5921` | COLOR | #0F172AFF | #0F172AFF | #0F172AFF | `d280217e07539487f23084e658a40d3b6f9acb59` |
| `Core/White` | `1:5922` | COLOR | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | `5497c6c835db9a0e7fcdb8e1d20ba27e1bc12fa9` |
| `Content/Default/Normal` | `1:5923` | COLOR | #0F172AFF; alias → Core/Desaturate/Neutral90 @1:5921 | #FFFFFFFF; alias → Core/White @1:5922 | #0F172AFF; alias → Core/Desaturate/Neutral90 @1:5921 | `53d4277c45edc14224e5daaa833d2844947fbe94` |
| `Core/Desaturate/Neutral60` | `1:5925` | COLOR | #606D8AFF | #606D8AFF | #606D8AFF | `e848bd4402bf1eae11e5242cd144a0738cf14dfe` |
| `Core/Desaturate/Neutral50` | `1:5926` | COLOR | #8793ADFF | #8793ADFF | #8793ADFF | `95a8a74c5727058857b3f6b2490e94510e95c9cf` |
| `Surface/Status/Accent/Idle` | `1:5927` | COLOR | #606D8AFF; alias → Core/Desaturate/Neutral60 @1:5925 | #8793ADFF; alias → Core/Desaturate/Neutral50 @1:5926 | #606D8AFF; alias → Core/Desaturate/Neutral60 @1:5925 | `62cfe4ff6caf8ab4df92c39f40887ec4ec65ab85` |

## Color — 1:5929

- collection key: `815ca06af400842ca40acd027ac407c3352713f7`
- 모드 식별자: `Light=2209:0`, `Dark=3636:0`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `Core/White` | `1:5930` | COLOR | #FFFFFFFF | #FFFFFFFF | `68b844695ab36af03d7e8605a49d9429a34124c7` |
| `Core/Desaturate/Neutral90` | `1:5931` | COLOR | #0F172AFF | #0F172AFF | `e249aca9bbeeed80ff885e3e3a1bc41e9b4812c0` |
| `Content/Default/Inverse/Normal` | `1:5932` | COLOR | #FFFFFFFF; alias → Core/White @1:5930 | #0F172AFF; alias → Core/Desaturate/Neutral90 @1:5931 | `fb7ad083172e2b8c43bde9c3916cd1b92066bb9d` |

## Color — 1:7247

- collection key: `994235267138968c297762f0578b4dfddb3b8126`
- 모드 식별자: `Light=11229:5`, `Dark=11486:7`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `static/dark/100` | `1:7248` | COLOR | #131417FF | #131417FF | `1e07d10f0e96dc15d2de8377cad3e3dafc187667` |
| `static/light/100` | `1:7249` | COLOR | #FFFFFFFF | #FFFFFFFF | `4c7bc411bf601f05974f8697deb6c99065532663` |
| `icon/dark/primary` | `1:7250` | COLOR | #131417FF; alias → static/dark/100 @1:7248 | #FFFFFFFF; alias → static/light/100 @1:7249 | `95c481151256faaafdee30ab9b4fff009de006b5` |
| `informative/active` | `1:7274` | COLOR | #02C265FF | #00E074FF | `0544005de32393d44dd987d02a2816878ef7c66a` |
| `icon/light/primary` | `1:7337` | COLOR | #FFFFFFFF; alias → static/light/100 @1:7249 | #131417FF; alias → static/dark/100 @1:7248 | `07b74843f3c138433ea738761406d9fde8840f7e` |
| `static/dark/200` | `2003:5557` | COLOR | #131417D6 | #131417D6 | `b5bc55e2f8807ce2042818c57583eb6ff879a987` |
| `basic/00` | `2003:5558` | COLOR | #FFFFFFFF | #131417FF | `4f98376b8f09d0d5b168735f5b387f679ab6a46f` |
| `basic/100` | `2003:5559` | COLOR | #EDEEF2FF | #313236FF | `effa651fe57cdac371634ce89463e0c0c22866f5` |
| `_Legacy/Scale/Black/Black` | `2003:5883` | COLOR | #000000FF | #FFFFFFFF | `1150eddb763d084a81cce70f31b2d0fa7db0e526` |
| `static/dark/400` | `2003:5899` | COLOR | #13141752 | #13141752 | `997758a4f811828ed5f1c564efac3d06dccbbe09` |
| `static/light/400` | `2003:5900` | COLOR | #FFFFFF52 | #FFFFFF52 | `5a51c4144648a071f6c2feae46b6885f7905bae6` |
| `icon/dark/quaternary` | `2003:5901` | COLOR | #13141752; alias → static/dark/400 @2003:5899 | #FFFFFF52; alias → static/light/400 @2003:5900 | `28493bf153fef8c7b72629afdc820ab9ab4a3eec` |
| `alpha/dark/100` | `2003:5951` | COLOR | #1314171A | #FFFFFF1A | `47fb07584fd838bf3014d8d81889e9732ca7acec` |
| `button/basic/pressed` | `2003:5952` | COLOR | #1314171A; alias → alpha/dark/100 @2003:5951 | #FFFFFF1A; alias → alpha/dark/100 @2003:5951 | `9515b1ed686495354f6638b5717a13003a4a7235` |
| `alpha/dark/50` | `2003:5953` | COLOR | #1314170D | #FFFFFF0D | `3398e4e3a2e25d1d9581f69ac838383d62cdc87d` |
| `button/basic/enabled` | `2003:5954` | COLOR | #1314170D; alias → alpha/dark/50 @2003:5953 | #FFFFFF0D; alias → alpha/dark/50 @2003:5953 | `a044c728b9a7ba456db380312936055d555c2a9c` |
| `informative/positive` | `2003:6010` | COLOR | #0064FFFF | #0082FFFF | `fc7cbd576fed110e87ad38960df155c67740ff97` |
| `_Legacy/Solid/Cool/900` | `2003:6038` | COLOR | #1B1D21FF | #F0F1F5FF | `cfb9882d581e32c6cd0ad648af7e0397b56c0854` |
| `phone/end_normal` | `2003:6119` | COLOR | #FE3D16FF | #FF4C28FF | `2a2ad45f4a3a817534b17149c5f569cbd49fe441` |
| `phone/accept_normal` | `2003:6120` | COLOR | #32B957FF | #3BD665FF | `ef8e89e40db4bf31f5d6a0dc01f3c499ea9abed5` |
| `static/dark/300` | `2003:6121` | COLOR | #131417A3 | #131417A3 | `5350c64259b80b4d31f1b8a31d68c29bddaf0e39` |
| `static/light/300` | `2003:6122` | COLOR | #FFFFFFA3 | #FFFFFFA3 | `d9c1942a19cd2ba9476a8d677f71692b283fedd7` |
| `icon/dark/tertiary` | `2003:6123` | COLOR | #131417A3; alias → static/dark/300 @2003:6121 | #FFFFFFA3; alias → static/light/300 @2003:6122 | `02cf653fb2a3f63a9acd7af255de48d4bdf3e658` |
| `text/dark/primary` | `2003:6292` | COLOR | #131417FF; alias → static/dark/100 @1:7248 | #FFFFFFFF; alias → static/light/100 @1:7249 | `f928e3fcfa99fee2c099909ce794cad7fde4e328` |
| `text/dark/quaternary` | `2003:6296` | COLOR | #13141752; alias → static/dark/400 @2003:5899 | #FFFFFF52; alias → static/light/400 @2003:5900 | `96f6c74055c01349e285a2f6c07892ec280966ea` |
| `text/dark/tertiary` | `2003:6323` | COLOR | #131417A3; alias → static/dark/300 @2003:6121 | #FFFFFFA3; alias → static/light/300 @2003:6122 | `fba7bba198b151202aedf827efe6e6596334b173` |
| `informative/negative` | `2003:6324` | COLOR | #FE3D16FF | #FF4C28FF | `5ac705b46f2378ea1697967e05a7b9abb7ce1caa` |
| `static/light/200` | `2003:11917` | COLOR | #FFFFFFD6 | #FFFFFFD6 | `53126f4229f0ce3c3a7cf7a85b97ca6e39fe62f8` |
| `text/dark/secondary` | `2003:11918` | COLOR | #131417D6; alias → static/dark/200 @2003:5557 | #FFFFFFD6; alias → static/light/200 @2003:11917 | `3c8fc343a92e12738bedb1fdd16b44c65f045d64` |
| `alpha/dark/200` | `2003:11929` | COLOR | #13141733 | #FFFFFF33 | `fcda5f912e3b3c16b92398226a431963f80ddf50` |
| `divider/tertiary` | `2003:11930` | COLOR | #13141733; alias → alpha/dark/200 @2003:11929 | #FFFFFF33; alias → alpha/dark/200 @2003:11929 | `d291b6dcba054edbe3566688b14d4017dc78abef` |
| `regulation/orange` | `2003:11931` | COLOR | #FF8A00FF | #FF8A00FF | `39abe8c0c04c6ba3354b2e5daa8402ed7334322e` |
| `regulation/red` | `2003:11991` | COLOR | #F62E24FF | #FF4339FF | `404985165abd2e5ce68b51d802becbfe18d45f7d` |
| `divider/secondary` | `2003:12076` | COLOR | #1314171A; alias → alpha/dark/100 @2003:5951 | #FFFFFF1A; alias → alpha/dark/100 @2003:5951 | `43d4f10c50226b2acac904f7c6cd14d10d6920d0` |
| `_System/Brand/Primary/Normal` | `2003:12112` | COLOR | #5A46FAFF | #6A57FFFF | `faf8c015eef01980dbd5623739d81c5e533f19b0` |
| `_Legacy/Scale/White/White` | `2003:12170` | COLOR | #FFFFFFFF | #000000FF | `70b12d4e82f08387d4271e6ffafc825b7cea85fd` |
| `_Legacy/Solid/Warm/300` | `2003:12171` | COLOR | #C8C8C8FF | #353535FF | `1844d3396f04bed9dad3ab2b541fd4b524b96c57` |
| `basic/50` | `2003:14264` | COLOR | #F7F8FAFF | #1D1E21FF | `e622d5d06eb9cde829ad024f723719f248359b6a` |
| `background/primary` | `2003:14265` | COLOR | #F7F8FAFF; alias → basic/50 @2003:14264 | #1D1E21FF; alias → basic/50 @2003:14264 | `8663a8b754bb48add9afa8ead97d54221073f0e2` |
| `alpha/dark/500` | `2003:14275` | COLOR | #13141780 | #FFFFFF80 | `3054f2fd4ab571924588b6aba50db84174bf91f0` |
| `alpha/light/200` | `2003:14303` | COLOR | #FFFFFF33 | #13141733 | `ae9c047304b09f4e241975c68a222c1a40dec806` |
| `system/divider/divider_tertiary-added` | `2003:14304` | COLOR | #FFFFFF33; alias → alpha/light/200 @2003:14303 | #13141733; alias → alpha/light/200 @2003:14303 | `7b227ac13e6e4c25339236cbbfec55c6c77d98a9` |
| `_Feature/Driving/Normal/Information` | `2003:14352` | COLOR | #2E5CFFFF | #2E5CFFFF | `512d521e8429d207a76dd2fabcd807b7dd9b9896` |
| `regulation/blue` | `2003:14353` | COLOR | #0064FFFF | #0082FFFF | `163aaaf39e9024d8390bbd35d77fccea10449e97` |
| `background/popup` | `2003:14485` | COLOR | #FFFFFFFF; alias → basic/00 @2003:5558 | #313236FF; alias → basic/100 @2003:5559 | `1338fe23523cc3e3fede2bde2e1a59569dfe4ec5` |
| `_Legacy/Scale/Black/400` | `2003:14488` | COLOR | #15151538 | #FFFFFF38 | `b72591a914b2aec37a31e3ca4f4ab305e40be2fa` |
| `Brand/Teritary/Black` | `2003:14489` | COLOR | #000000FF; alias → _Legacy/Scale/Black/Black @2003:5883 | #000000FF; alias → _Legacy/Scale/White/White @2003:12170 | `50a0cc1c959bb5efe673c97a4456e7274b8f8c74` |
| `controller/slider/normal` | `2003:14564` | COLOR | #13141733; alias → alpha/dark/200 @2003:11929 | #FFFFFF1A; alias → alpha/dark/100 @2003:5951 | `57c4e92fe4cd21633ef1c692c1070e9d2d305efb` |
| `alpha/dark/300` | `2003:14569` | COLOR | #1314174D | #FFFFFF4D | `d5354b16f8b249e49f1d0e7b4a5b10c15237fd74` |
| `controller/slider/knop` | `2003:14570` | COLOR | #FFFFFFFF; alias → basic/00 @2003:5558 | #FFFFFF4D; alias → alpha/dark/300 @2003:14569 | `9bde8bc7146ca0f882a6dd1064365417aab4955f` |
| `controller/slider/pressed` | `2003:14635` | COLOR | #1314174D; alias → alpha/dark/300 @2003:14569 | #FFFFFF33; alias → alpha/dark/200 @2003:11929 | `567a064016256b32f554b97f5c87826215cc6806` |
| `button/basic/disabled` | `2003:14713` | COLOR | #FFFFFF33; alias → alpha/light/200 @2003:14303 | #13141733; alias → alpha/light/200 @2003:14303 | `cfa48e0b2f19ce63d624329e62f9ba7aabb2ce48` |
| `basic/800` | `2003:14767` | COLOR | #1D1E21FF | #F7F8FAFF | `471644c46d60d9246701255da74c5f0c4fb27015` |
| `controller/tab_background` | `2003:14795` | COLOR | #1314170D; alias → alpha/dark/50 @2003:5953 | #FFFFFF0D; alias → alpha/dark/50 @2003:5953 | `c2f02edb4f1015c61d5bbfb8c16f393c31214b1e` |
| `button/switch/enabled` | `2003:14818` | COLOR | #FFFFFFFF; alias → basic/00 @2003:5558 | #FFFFFF33; alias → alpha/dark/200 @2003:11929 | `c4642f382b9682c5e21c15576c627438a86f1a4c` |
| `basic/600` | `2003:15025` | COLOR | #44464EFF | #E0E1E6FF | `413d29bb7f4b84a10051c2ae8fb39a8c88da34bb` |
| `button/filled/enabled` | `2003:15026` | COLOR | #44464EFF; alias → basic/600 @2003:15025 | #E0E1E6FF; alias → basic/600 @2003:15025 | `e08a55c202cce0a9ccf9699ab56b904f6cf338dc` |
| `text/light/primary` | `2003:15027` | COLOR | #FFFFFFFF; alias → static/light/100 @1:7249 | #131417FF; alias → static/dark/100 @1:7248 | `3fa8f4bff01b6d0a672785eb95f470dbb5d9a3a7` |
| `basic/700` | `2003:15028` | COLOR | #313236FF | #EDEEF2FF | `362370a488768bb9519f05254f6d03bfdf1142c5` |
| `basic/500` | `2003:15029` | COLOR | #686A72FF | #C7C9CEFF | `ef6e5fbdb84e8fa8112d919152ab04d601b33983` |
| `button/filled/pressed` | `2003:15030` | COLOR | #313236FF; alias → basic/700 @2003:15028 | #C7C9CEFF; alias → basic/500 @2003:15029 | `9fe853f6b5b1b9109fddd3ab05d11d986a667aee` |
| `button/filled/disabled` | `2003:15031` | COLOR | #1314170D; alias → alpha/dark/50 @2003:5953 | #FFFFFF0D; alias → alpha/dark/50 @2003:5953 | `18d987510225801541b3ab050454d19691533736` |
| `_Legacy/Solid/Cool/500` | `2003:15171` | COLOR | #626675FF | #626675FF | `586cbc93532834c220dda611d9be41bb83c1d353` |
| `Common/Empty/Content` | `2003:15172` | COLOR | #C8C8C8FF; alias → _Legacy/Solid/Warm/300 @2003:12171 | #626675FF; alias → _Legacy/Solid/Cool/500 @2003:15171 | `71e0ac65a72bcb73868ddf1632d8836d813cae8f` |

## typo — 1:7338

- collection key: `fcaac18959901ecd6624b948186c7add2d72886a`
- 모드 식별자: `connect-s=32090:0`, `connect-l=32259:1`, `connect-w=33219:2`, `connect-waterfall=33235:1`

| Token | ID | Type | connect-s | connect-l | connect-w | connect-waterfall | Key |
| --- | --- | --- | --- | --- | --- | --- | --- |
| `size_sp/level14` | `1:7339` | FLOAT | 44 | 39 | 37 | 47 | `e96d219ce31393ff7d80263f291154c98ab06d5a` |
| `radius/top_left/level7` | `2003:5555` | FLOAT | 24 | 21 | 20 | 26 | `6daa8a88307cc9468ae99aaaa6214c212db8f9cb` |
| `size_sp/level8` | `2003:5878` | FLOAT | 30 | 26 | 25 | 34 | `02131968e376422489c7fea05604a54462185787` |
| `line_height_sp/level8` | `2003:5879` | FLOAT | 38 | 33 | 32 | 41 | `9cf519cf66a8606c75b9b0df1cff17ac66e1f17c` |
| `square/level18` | `2003:5972` | FLOAT | 80 | 70 | 66 | 84 | `7a9bd8d67d70b5df6e21c73e44ff02c00a955852` |
| `size_sp/level11` | `2003:6290` | FLOAT | 36 | 32 | 30 | 38 | `b03f23b6892d2fe3e257ff93f91eec4655e40632` |
| `size_sp/level15` | `2003:6293` | FLOAT | 48 | 42 | 40 | 51 | `4e0ccd9671ba10ca4de344228c04cba048f7d21d` |
| `size_sp/level19` | `2003:6294` | FLOAT | 64 | 56 | 53 | 68 | `4e7da002253b6bc395006a0556ca2cf34296f9b0` |
| `size_sp/level20` | `2003:6320` | FLOAT | 112 | 99 | 130 | 119 | `a2745113254464a23fb6d20d18145d4925ea586d` |
| `line_height_sp/level20` | `2003:6321` | FLOAT | 134 | 118 | 156 | 142 | `91944e0054471caef01655fc9da185e6c0dc5625` |
| `size_sp/level17` | `2003:6325` | FLOAT | 56 | 49 | 46 | 59 | `7313c8211c48ed20475d0aa37365cf13b7b5884c` |
| `line_height_sp/level17` | `2003:6326` | FLOAT | 72 | 65 | 60 | 77 | `a491a00217ab9f4740cd52034b2097cbc9b54d74` |
| `size_sp/level13` | `2003:11858` | FLOAT | 40 | 35 | 33 | 42 | `1ef39e8ead1eaa16171b5b75d078010abdbb342b` |
| `size_sp/level16` | `2003:11859` | FLOAT | 52 | 46 | 43 | 55 | `e3463b37f4655c48a8f03f48c1c399254a098876` |
| `size_sp/level7` | `2003:11914` | FLOAT | 28 | 25 | 23 | 29 | `b7dbfb699fcbbc7309b1e4a6087fd1f54b48ab35` |
| `line_height_sp/level7` | `2003:11915` | FLOAT | 36 | 32 | 30 | 38 | `5fc91a2d4dc3b771ee10f892c7a17a0f66424673` |
| `shadow/level2/blur1` | `2003:12066` | FLOAT | 32 | 28 | 27 | 32 | `63b590ebccb8e2ff464283765fe0d2301e523815` |
| `shadow/level2/y1` | `2003:12067` | FLOAT | 8 | 7 | 7 | 9 | `f56acda1513260751b2d9c9143a30ada08887864` |
| `shadow/level2/blur2` | `2003:12068` | FLOAT | 2 | 2 | 2 | 3 | `9e0bb715caeebf86f40939292a23cdfed1e65ae9` |
| `shadow/level2/y2` | `2003:12069` | FLOAT | 2 | 2 | 2 | 3 | `1dd6d111e1e9f9968b2bae5c33db8c674282b410` |
| `radius/top_left/level5` | `2003:12071` | FLOAT | 16 | 14 | 13 | 17 | `8a684db63cccef959fe67d21901bb25ecbed0c28` |
| `radius/top_right/level5` | `2003:12072` | FLOAT | 16 | 14 | 13 | 17 | `da09fe3855dd2c514918cce2f5e7e4608338f9ad` |
| `radius/bottom_left/level5` | `2003:12073` | FLOAT | 16 | 14 | 13 | 17 | `6e308bda8b2696ed3bedf0a08e4c89194529532a` |
| `radius/bottom_right/level5` | `2003:12074` | FLOAT | 16 | 14 | 13 | 17 | `62fc398c250ad848e60d80ac705d49e681b50a62` |
| `line/level1` | `2003:12075` | FLOAT | 1 | 1 | 1 | 1 | `0d2ff57057fd83040ee55a1216640a8199b74e55` |
| `shadow/level1/blur` | `2003:14255` | FLOAT | 24 | 21 | 20 | 26 | `90c9fbac9c16d3f7e78d7a35bad29e23183412d9` |
| `shadow/level1/y` | `2003:14256` | FLOAT | 6 | 5 | 5 | 6 | `932cb23bf5060756519be9d4e60af5e91a13fe7d` |
| `size_sp/level9` | `2003:14291` | FLOAT | 32 | 28 | 27 | 35 | `02efbeb76962d78c57e4a7fc8728736f29ea05f3` |
| `line_height_sp/level9` | `2003:14292` | FLOAT | 40 | 35 | 33 | 42 | `49512df87e801fe3de326e01a178d014966372e5` |
| `size_sp/level18` | `2003:14348` | FLOAT | 60 | 53 | 50 | 64 | `c67f602bf301b46ff4fe81a5823abf039c0c6211` |
| `line_height_sp/level19` | `2003:14349` | FLOAT | 80 | 65 | 66 | 84 | `8e596bc3fca63f243e0ae74609318f64d74b8cad` |
| `radius/top_right/level7` | `2003:14694` | FLOAT | 24 | 21 | 20 | 26 | `1596053fa05d4d6d33f89d4507c59deb813efd3c` |
| `radius/bottom_left/level7` | `2003:14696` | FLOAT | 24 | 21 | 20 | 26 | `8fca97a96c4676233b74a4a30086e852f488c613` |
| `radius/bottom_right/level7` | `2003:14698` | FLOAT | 24 | 21 | 20 | 26 | `58a6ad8b6f9deda9ce3f81848814e186d4c50245` |
| `square/level10` | `2003:14943` | FLOAT | 48 | 42 | 40 | 51 | `d4076ed7f376ace42b3f69585022b3de8e902adb` |
| `size_sp/level6` | `2003:15022` | FLOAT | 26 | 23 | 22 | 28 | `1116120d5605797a91a3ac72abd535fbe9fb6fc6` |
| `line_height_sp/level6` | `2003:15023` | FLOAT | 34 | 28 | 28 | 36 | `67b6886c5927df2c7c778752a9c8b1c93d72ddbb` |

## form_factor — 1:7363

- collection key: `96b6cfc06cdc17ad0e1954ab10b31bf0ffbc32bc`
- 모드 식별자: `connect-s=32062:0`, `connect-l=32257:0`, `connect-w=33219:0`, `[U+0008]connect-waterfall=33235:0`

| Token | ID | Type | connect-s | connect-l | connect-w | [U+0008]connect-waterfall | Key |
| --- | --- | --- | --- | --- | --- | --- | --- |
| `statusbar/menus/privacy/indicator_icon_square` | `1:7364` | FLOAT | 32 | 28 | 26 | 35 | `bff399abf713f445c30a0f0cd82f4015d873bf2d` |
| `window/container_width` | `2003:5553` | FLOAT | 2560 | 1920 | 3840 | 3840 | `b22778445fed2500aab238ae98220fecee0a2d44` |
| `window/container_height` | `2003:5554` | FLOAT | 1440 | 1080 | 850 | 850 | `cbaf56e330dc232f4568a700c68505a352fbae9f` |
| `window/apps/padding` | `2003:5556` | FLOAT | 20 | 18 | 20 | 24 | `37dd0cfc1c5b47b374c2cefcef2982c470d293fe` |
| `statusbar/height` | `2003:5565` | FLOAT | 96 | 84 | 0 | 0 | `96312373cb34d05678841619c13f0b261d34f40f` |
| `statusbar/gap_medium` | `2003:5881` | FLOAT | 16 | 14 | 12 | 15 | `1ff5d73af74aefb4793e9eb8758b9ef7c5ad2515` |
| `statusbar/padding` | `2003:5882` | FLOAT | 24 | 21 | 20 | 26 | `624a5eac77ca21d2cd3110708db9dc72aa636eaf` |
| `statusbar/menus/container_square` | `2003:5894` | FLOAT | 80 | 70 | 66 | 84 | `fc36a44a4126c24f6b3395083cc287cedb006cc1` |
| `statusbar/menus/container_radius_top_left` | `2003:5895` | FLOAT | 20 | 18 | 17 | 22 | `3abbd58f2776ad786a4ba334edb85f9540cd1cd1` |
| `statusbar/menus/container_radius_top_right` | `2003:5896` | FLOAT | 20 | 18 | 17 | 22 | `d2dc94d2313510bffec0cc4c52116c81d88b5fc4` |
| `statusbar/menus/container_radius_bottom_left` | `2003:5897` | FLOAT | 20 | 18 | 17 | 22 | `4c65d2c3555f347659fa597b3fdb9cf207029b2c` |
| `statusbar/menus/container_radius_bottom_right` | `2003:5898` | FLOAT | 20 | 18 | 17 | 22 | `7afeaae99875ce86464ce046bf60ba932bc72552` |
| `statusbar/menus/icon_square` | `2003:5948` | FLOAT | 56 | 49 | 46 | 59 | `0077d03cdf4d4e1820e7de1164abb0d347e870a7` |
| `statusbar/menus/privacy/padding` | `2003:5949` | FLOAT | 8 | 7 | 7 | 9 | `f0be50a8cb45eb5592a56cc33b4887d427bb1cb0` |
| `statusbar/menus/privacy/dot` | `2003:5950` | FLOAT | 10 | 9 | 8 | 10 | `7cebc42ae0ea7f51dc011df11c0172f8643e1632` |
| `imagery/profile/radius_top_left` | `2003:5968` | FLOAT | 999 | 999 | 999 | 999 | `57f53af76927f7fce4ea39ee2d821e7e0453c9ff` |
| `imagery/profile/radius_top_right` | `2003:5969` | FLOAT | 999 | 999 | 999 | 999 | `6f9e27b58b00a15290a6a6bce2dadecfb04ce775` |
| `imagery/profile/radius_bottom_left` | `2003:5970` | FLOAT | 999 | 999 | 999 | 999 | `7444d7da08dbc865dd0a6319460d74db29144765` |
| `imagery/profile/radius_bottom_right` | `2003:5971` | FLOAT | 999 | 999 | 999 | 999 | `dc230eb7015e1d35dae765c1df14d6f96f5007f9` |
| `imagery/profile/circle` | `2003:5973` | FLOAT | 80; alias → square/level18 @2003:5972 | 70.4 | 66; alias → square/level18 @2003:5972 | 84; alias → square/level18 @2003:5972 | `4c7d8caaa0113f09a65d2a2895d79bffcb5eecc9` |
| `statusbar/menus/profile_square` | `2003:5989` | FLOAT | 60 | 53 | 50 | 64 | `98bdcd956b7d96d24eb18bdadcfe4f8aeaba1918` |
| `statusbar/menus/privacy/indicator_width_small` | `2003:6034` | FLOAT | 80 | 70 | 66 | 84 | `d9ee7ad7ca9d48af3d6419512e12306a974d3e02` |
| `statusbar/menus/privacy/indicator_height_small` | `2003:6035` | FLOAT | 80 | 70 | 66 | 84 | `b39b3ddbb551e31387ae08ba2944e554ce13ce9c` |
| `statusbar/menus/privacy/indicator_gap` | `2003:6036` | FLOAT | 4 | 4 | 3 | 4 | `c01a97c1924f11e4abff7eac88d7c97a10f5e836` |
| `statusbar/menus/privacy/indicator_padding` | `2003:6037` | FLOAT | 12 | 11 | 10 | 13 | `c1f0016f48e0135d85b9961f843178648049f0cd` |
| `statusbar/menus/privacy/indicator_width_large` | `2003:6058` | FLOAT | 100 | 88 | 84 | 106 | `921a2194cd00e29878c7a3ef0bfc899d73d00315` |
| `statusbar/menus/privacy/indicator_height_large` | `2003:6084` | FLOAT | 100 | 88 | 84 | 106 | `81fa1c022101260c5ef796a7f483775258e04abc` |
| `driving_view/left/group1/padding_horizontal_left` | `2003:6316` | FLOAT | 20 | 18 | 20 | 21 | `842557b8308b29030445f7569ac74f869bca9484` |
| `driving_view/top/group1/prnd_unit_width` | `2003:6317` | FLOAT | 30 | 26 | 30 | 32 | `e2b4bd4e3fb61f6ca1bae542954ad65fffa9f966` |
| `window/apps/driving_view_width` | `2003:6318` | FLOAT | 840 | 628 | 1040 | 1280 | `126eafb6a48fa72d0698427498ed8f838353f63a` |
| `window/apps/driving_view_height` | `2003:6319` | FLOAT | 1280 | 939 | 850 | 850 | `861f0943a30ef1c89d676e418a2dfaaa6966e8f3` |
| `driving_view(wip)/group1/indicator_padding_horizontal` | `2003:11812` | FLOAT | 20 | 18 | 20 | 20 | `cd2881752f2a0dc961b46073980d897f83652522` |
| `statusbar/width` | `2003:11813` | FLOAT | 0 | 0 | 168 | 128 | `25752add14b9ce1523ea5ac59a2de9c19f5487ea` |
| `statusbar/gap_large` | `2003:11814` | FLOAT | 24 | 21 | 16 | 20 | `312e5cfebb0bdcd51f2279795d4e2670612d5f8f` |
| `gnb/menu/container_square` | `2003:11815` | FLOAT | 124 | 109 | 108 | 138 | `b44a6957031b74ba26dc2f2621f333da50359bbf` |
| `gnb/controller/arrow_width` | `2003:11816` | FLOAT | 80 | 70 | 108 | 138 | `59bc80b7c3cfee1bfb562d2014dcd272b699bfd7` |
| `gnb/controller/pressed_square` | `2003:11817` | FLOAT | 100 | 88 | 88 | 108 | `523d94913ac15349a794c78c1f2956583286ddbb` |
| `gnb/menu/radius_top_left` | `2003:11818` | FLOAT | 28 | 25 | 23 | 29 | `5e55b60fe2c48c792787306f60b5bab8aabbe1a6` |
| `gnb/menu/radius_top_right` | `2003:11819` | FLOAT | 28 | 25 | 23 | 29 | `da70ab3b8797523de8e41ef2827c9e68904cb61f` |
| `gnb/menu/radius_bottom_left` | `2003:11820` | FLOAT | 28 | 25 | 23 | 29 | `c5f7cfc84b66c4f5433ae2f320abefa711dcb789` |
| `gnb/menu/radius_bottom_right` | `2003:11821` | FLOAT | 28 | 25 | 23 | 29 | `1d9e632945e4319834cdd297aaeab36dddd3a3d0` |
| `gnb/controller/arrow_icon_sqaure` | `2003:11835` | FLOAT | 64 | 56 | 53 | 68 | `6188bdd8fee641684e5d1b3aba1b00dd2576024f` |
| `gnb/temperature/gap_vertical` | `2003:11836` | FLOAT | -4 | -4 | 0 | -4 | `46d572e2c01e90ba27714fddc69963aaf3a869c4` |
| `gnb/temperature/container_width` | `2003:11837` | FLOAT | 164 | 116 | 108 | 138 | `10dc23c15db397b792db098cbce1f2ef1cbae1e1` |
| `gnb/temperature/wind_icon_square` | `2003:11853` | FLOAT | 48 | 28 | 27 | 35 | `c0f443d55049b15cf3be108b0770e1752761aaf1` |
| `gnb/temperature/gap_horizontal` | `2003:11854` | FLOAT | -7 | -4 | -8 | -8 | `a0c484f3b7c1930e5819545ce3450d266a3858dc` |
| `gnb/temperature/number_width` | `2003:11856` | FLOAT | 75 | 69 | 58 | 76 | `bb6ecb66fb5f09851ce7ea76975252d5796cb89c` |
| `gnb/temperature/decimal_places_padding_top` | `2003:11857` | FLOAT | 16 | 14 | 14 | 14 | `f63fbffb2f929120023fb1c16c8a4b61ffb7b242` |
| `gnb/temperature/decimal_places_witdh` | `2003:11861` | FLOAT | 38 | 33 | 32 | 36 | `9a793e9926ebda143c51777bdac40b8fcd7dc239` |
| `gnb/gap_small` | `2003:11862` | FLOAT | 4 | 4 | 4 | 5 | `773de9b4023044b8b19d84fd71d10483191893ab` |
| `gnb/temperature/icon_group_height` | `2003:11863` | FLOAT | 40 | 35 | 30 | 42 | `fb545ef994ffb7a2b5909f81deba6ca841129ad6` |
| `gnb/temperature/icon_square` | `2003:11913` | FLOAT | 36 | 28 | 27 | 35 | `83a2ff3b2fc8d0807b6ae083a82b4ab62ae92108` |
| `gnb/controller/icon_square` | `2003:11926` | FLOAT | 72 | 63 | 60 | 77 | `a6c54a37893a38bc8c2643288e32f28b4eedd3c6` |
| `gnb/controller/divider` | `2003:11927` | FLOAT | 4 | 4 | 3 | 4 | `0ec03deefabfedc18cfa3c4647b13fcf9eb6de80` |
| `gnb/controller/divider_pressed_square` | `2003:11928` | FLOAT | 64 | 56 | 52 | 67 | `b18ecd45ba9eb7ccd9457f82b99cbbbb3c91c86c` |
| `gnb/application/app_square` | `2003:12351` | FLOAT | 84 | 74 | 70 | 90 | `5aade76c270d705e80a39f13224ca31c80463078` |
| `gnb/application/radius_top_left` | `2003:12352` | FLOAT | 24 | 21 | 20 | 26 | `dd571d8ffd70e533a4eedfe2b80f89f5980a74ff` |
| `gnb/application/radius_top_right` | `2003:12353` | FLOAT | 24 | 21 | 20 | 26 | `781ba777eb32c9fcf733c56f7bd4c26dbabbe8bb` |
| `gnb/application/radius_bottom_left` | `2003:12354` | FLOAT | 24 | 21 | 20 | 26 | `d8df6cff0bef0d33fa42a61003133ca8d59dadf7` |
| `gnb/application/radius_bottom_right` | `2003:12355` | FLOAT | 24 | 21 | 20 | 26 | `5cc94667038acb94ad2868e893f0cf4958e8667a` |
| `gnb/application/app_activate_width` | `2003:12356` | FLOAT | 8 | 7 | 8 | 10 | `3c20647545567dc262579e8c3dffc33237bea417` |
| `gnb/application/app_activate_height` | `2003:12357` | FLOAT | 8 | 7 | 8 | 10 | `a2c84e38193e27eed8e6040e71256e29b5caccb1` |
| `gnb/temperature/off_gap_horizontal` | `2003:12358` | FLOAT | 4 | 4 | 4 | 3 | `2f56541ba486df5f50308c7c7c8a7022d03c9e83` |
| `gnb/remove_button/container_square` | `2003:12360` | FLOAT | 44 | 39 | 40 | 48 | `68892ba14566c42d4cdbf08eaebc93319635a518` |
| `gnb/remove_button/background_square` | `2003:12361` | FLOAT | 40 | 35 | 36 | 44 | `5fd5fc8b3c92a75be1e6a9e038d7b7c69b68502b` |
| `gnb/remove_button/icon_height` | `2003:12362` | FLOAT | 3 | 3 | 4 | 4 | `07cbfe6da50f95e1166480f660277beba2b04f82` |
| `gnb/remove_button/icon_width` | `2003:12363` | FLOAT | 16 | 14 | 16 | 18 | `bbb450813d9c7f0605357770066f9be69601e7e2` |
| `statusbar/wide_time_padding_vertical_top` | `2003:12454` | FLOAT | 0 | 0 | 8 | 26 | `6954f9d3690e3c0d6a92226092a66cb54fccd213` |
| `statusbar/wide_time_padding_horizontal_right` | `2003:12455` | FLOAT | 0 | 0 | 28 | 26 | `f3cfa3f7054c5943d1ef7c0c79087309f9c4ff6a` |
| `statusbar/wide_time_padding_vertical_bottom` | `2003:12456` | FLOAT | 0 | 0 | 20 | 26 | `cf80aa867fe0af2677a6d2ec1d8f66671559281c` |
| `window/container_extended_height` | `2003:12457` | FLOAT | 0 | 0 | 1440 | 0 | `efa849cefbd50a5ef3a468a23f39d8ccdd0f6ceb` |
| `window/apps/portrait_width` | `2003:14258` | FLOAT | 840 | 628 | 800 | 716 | `a9288d47c4965d339aa97c868afce58b95f246db` |
| `window/apps/application_height` | `2003:14259` | FLOAT | 1184 | 855 | 810 | 802 | `9e41d998ea2e06d81717c44e8356a3f9a58dcca1` |
| `window/apps/radius_top_left` | `2003:14260` | FLOAT | 40 | 35 | 33 | 42 | `1607345afdbf0793cc6e2f9b0d23e2f5d974c95e` |
| `window/apps/radius_top_right` | `2003:14261` | FLOAT | 40 | 35 | 33 | 42 | `84cfb6f2ca76fa44d19f945b12a639c9ad10d76a` |
| `window/apps/radius_bottom_left` | `2003:14262` | FLOAT | 40 | 35 | 33 | 42 | `9a3c153b1e3fee6151b49d3eaa9b678b35e30a2e` |
| `window/apps/radius_bottom_right` | `2003:14263` | FLOAT | 40 | 35 | 33 | 42 | `0484c83264caba2df51e61b7a95341353ba561ea` |
| `bars/app_control/padding_top` | `2003:14266` | FLOAT | 16 | 14 | 14 | 17 | `c908ee3eccb0ba1ed000f956c411bf4a849b9ab5` |
| `bars/app_control/container_width` | `2003:14267` | FLOAT | 320 | 282 | 266 | 340 | `f2a6c6458bf4e32232daf7d4b88c38671c829f29` |
| `bars/app_control/container_height` | `2003:14268` | FLOAT | 60 | 53 | 100 | 128 | `649067c2d28642d4753adf59d54eff37904b8484` |
| `bars/app_control/handle_width_normal` | `2003:14269` | FLOAT | 140 | 123 | 116 | 148 | `a073ae3539b6d16d1160aaa406a43c647f276d3b` |
| `bars/app_control/handle_height` | `2003:14270` | FLOAT | 8 | 7 | 8 | 9 | `cfd7244df65102bf40f8df2eee7d6f88859f3677` |
| `bars/radius_top_left` | `2003:14271` | FLOAT | 999 | 999 | 999 | 999 | `001884ed4bca0ecea583ace2a4f9973c8ca714d1` |
| `bars/radius_top_right` | `2003:14272` | FLOAT | 999 | 999 | 999 | 999 | `2c2a0fce9e0570cd903de7abf0c94b20da4e8447` |
| `bars/radius_bottom_left` | `2003:14273` | FLOAT | 999 | 999 | 999 | 999 | `87c7e9ddb76af9f74092971cd70f458e92ed140b` |
| `bars/radius_bottom_right` | `2003:14274` | FLOAT | 999 | 999 | 999 | 999 | `bb389bfcea4e64aa807181611d32ef4ab2b05487` |
| `window/overlay_guide/gap_vertical` | `2003:14283` | FLOAT | 32 | 28 | 28 | 36 | `d850f72f2fca3470fb60ec6db7781c9a214866a5` |
| `window/overlay_guide/padding_horizontal` | `2003:14284` | FLOAT | 60 | 53 | 50 | 64 | `9d28046dd7f5b59d19ebbf05092eb6402f9db0a1` |
| `window/overlay_guide/padding_vertical` | `2003:14285` | FLOAT | 60 | 53 | 50 | 64 | `61f708b5535b3dcdde5b6246b15418678576ae92` |
| `window/overlay_guide/app_square` | `2003:14286` | FLOAT | 100 | 88 | 83 | 106 | `3d5af033bd7d0a57b203ca21528240c2d0d5bf82` |
| `window/overlay_guide/app_radius_top_left` | `2003:14287` | FLOAT | 28 | 25 | 23 | 29 | `f9d09101ada79631af0fde6c3fb795a8d734ef14` |
| `window/overlay_guide/app_radius_top_right` | `2003:14288` | FLOAT | 28 | 25 | 23 | 29 | `dbfb42f27547679e4a0a327a5aa01c0420b54464` |
| `window/overlay_guide/app_radius_bottom_left` | `2003:14289` | FLOAT | 28 | 25 | 23 | 29 | `d43af06f5d292efeeb48be91be36af1447be80e8` |
| `window/overlay_guide/app_radius_bottom_right` | `2003:14290` | FLOAT | 28 | 25 | 23 | 29 | `4e23d38fe8d284993b424b21a8bf41b1c8fb202b` |
| `bars/fullscreen_control/padding_horizontal` | `2003:14297` | FLOAT | 24 | 21 | 20 | 26 | `00c23b595433d69584cfda3f7adb1fe977dd3bd5` |
| `bars/fullscreen_control/padding_top` | `2003:14298` | FLOAT | 24 | 21 | 20 | 26 | `d69b3f81510d4fb8dc605a5e77cccf3d59b52151` |
| `bars/fullscreen_control/icon_padding_horizontal` | `2003:14299` | FLOAT | 14 | 12 | 12 | 15 | `060572235f7f92628f5a354f486fdcb69510b090` |
| `bars/fullscreen_control/icon_padding_top` | `2003:14300` | FLOAT | 14 | 12 | 12 | 15 | `8ce42a71bd27ac9647c2dd94adb39bb35ba86022` |
| `bars/fullscreen_control/icon_padding_bottom` | `2003:14301` | FLOAT | 14 | 12 | 12 | 15 | `94886b0acf0947751b5535558d22721b1c4c7975` |
| `bars/fullscreen_control/icon_button_radius_top_left` | `2003:14302` | FLOAT | 28 | 25 | 23 | 29 | `76b4988bf0ec1e393f48ce81c3ba4846e0421979` |
| `bars/fullscreen_control/magnify_icon_square` | `2003:14315` | FLOAT | 56 | 49 | 46 | 59 | `2045718b07d21c04a1e2de545c4d850366f22d66` |
| `window/apps/landscape_width` | `2003:14327` | FLOAT | 1700 | 1274 | 1640 | 1480 | `d767bca163d58e0de6641cade0a186c722cc7048` |
| `gnb/padding_horizontal` | `2003:14344` | FLOAT | 60 | 20 | 0 | 0 | `67eb0035d01147a0110a99ec733782033ae99fa1` |
| `gnb/height` | `2003:14345` | FLOAT | 160 | 141 | 0 | 0 | `725849fac19378c3cb12bd02582f166ae87e53ca` |
| `gnb/gap_medium` | `2003:14346` | FLOAT | 8 | 8 | 8 | 10 | `26bdea715be8c856fdbf5ec7b3d99ebaab2a515b` |
| `gnb/controller/width` | `2003:14347` | FLOAT | 720 | 548 | 0 | 0 | `746adf13b39ec4e25558e9c9afe42f24ff2adc99` |
| `gnb/gap_large` | `2003:14474` | FLOAT | 12 | 11 | 10 | 12 | `929ddabc9954383abc80b8f7bcc8cadde2ab029e` |
| `osd/gap_horizontal_medium` | `2003:14475` | FLOAT | 16 | 14 | 14 | 18 | `29cef6685498179542000e3bf99b9b5a563dd0db` |
| `osd/padding_medium` | `2003:14476` | FLOAT | 24 | 18 | 20 | 26 | `e605ab949fb5e2c650a741c73a10b41443dbb9cc` |
| `osd/padding_small` | `2003:14477` | FLOAT | 16 | 14 | 14 | 18 | `0115bf94d2c8479f35f5333f5567a885991ad9d4` |
| `osd/width` | `2003:14478` | FLOAT | 880 | 774 | 730 | 934 | `e0a7c2cfedbd3684349bf9330c32691e8458562b` |
| `osd/height` | `2003:14479` | FLOAT | 120 | 106 | 120 | 120 | `5e29035730d6c3e0e05251f7dd16c35f1539e10e` |
| `osd/radius_top_left` | `2003:14480` | FLOAT | 32 | 28 | 27 | 35 | `642d743ce5cb6f165f0c4cb71e979e9a69e8516a` |
| `osd/radius_top_right` | `2003:14481` | FLOAT | 32 | 28 | 27 | 35 | `6743e6733b94ebcb5e562df0df34cd99680ba97c` |
| `osd/radius_bottom_left` | `2003:14482` | FLOAT | 32 | 28 | 27 | 35 | `9504935fa6975f36e8d5fcc4a80f1f7856c1b197` |
| `osd/radius_bottom_right` | `2003:14483` | FLOAT | 32 | 28 | 27 | 35 | `b3efa8aee631b7038740b79969b93bd38b95412c` |
| `osd/border` | `2003:14484` | FLOAT | 1 | 1 | 1 | 1 | `2c7d0381070f319b8fdbaa1d7efb9dc4be02cc23` |
| `osd/title/prefix_gap_horizontal` | `2003:14486` | FLOAT | 12 | 11 | 10 | 13 | `d788fd773f478b8a38f0f03c73b33f3a9a1e41a1` |
| `osd/title/width` | `2003:14487` | FLOAT | 180 | 160 | 148 | 190 | `77b55766add96e69dff6cb9d28a41987714b349e` |
| `controller/slider/continuous/track/medium/item_padding` | `2003:14561` | FLOAT | 4 | 4 | 4 | 4 | `837a530a67af74c1c3f0b8e9dbbb34395f43c9b8` |
| `controller/slider/height_medium` | `2003:14562` | FLOAT | 80 | 70 | 66 | 84 | `3682d4de888847b8fb7c65355b019cacc6385f1c` |
| `controller/slider/border_large` | `2003:14563` | FLOAT | 4 | 4 | 3 | 4 | `797ce68f2b5d304c50ff17a466c767006d695d30` |
| `controller/slider/continuous/medium/knob/radius_top_left` | `2003:14565` | FLOAT | 20 | 18 | 17 | 22 | `f5d6f8c7755440d68430692cafcbf6f1cbdb9924` |
| `controller/slider/continuous/medium/knob/radius_top_right` | `2003:14566` | FLOAT | 20 | 20 | 17 | 22 | `6d8d59bdefe85af3d211dee884225a86f670309c` |
| `controller/slider/continuous/medium/knob/radius_bottom_left` | `2003:14567` | FLOAT | 20 | 20 | 17 | 22 | `8988baecfb8a841836cfb0e2e5c3ddf2f675d158` |
| `controller/slider/continuous/medium/knob/radius_bottom_right` | `2003:14568` | FLOAT | 20 | 20 | 17 | 22 | `6c0a0f05c82c2264bcb1430592188d88535c9c93` |
| `controller/slider/continuous/track/medium/icon` | `2003:14619` | FLOAT | 48 | 42 | 40 | 51 | `42d3781cbcaa5fa9861fa6d56fa86c0c3d05e228` |
| `controller/slider/continuous/track/small/item_padding` | `2003:14620` | FLOAT | 4 | 4 | 4 | 4 | `0cad7af27733b6763afad57e00aab4ad8724ac33` |
| `controller/slider/height_small` | `2003:14621` | FLOAT | 72 | 67 | 64 | 81 | `37eb8fb2358b58867a7de26ea0ccf7b4a2098feb` |
| `controller/slider/continuous/small/knob/radius_top_left` | `2003:14622` | FLOAT | 16 | 14 | 13 | 17 | `0ce0a3c9bf151bd052a963b2e5ca9e7969c62c48` |
| `controller/slider/continuous/small/knob/radius_top_right` | `2003:14623` | FLOAT | 16 | 14 | 13 | 17 | `1393fbdd93cb80a96860849858893e7e4ec81232` |
| `controller/slider/continuous/small/knob/radius_bottom_left` | `2003:14624` | FLOAT | 16 | 14 | 13 | 17 | `3854303fda9ca4e40a967ee4911e15f904f3b697` |
| `controller/slider/continuous/small/knob/radius_bottom_right` | `2003:14625` | FLOAT | 16 | 14 | 13 | 17 | `b0bdfe642d6d25f5cfddb3711cf321eb20b01355` |
| `controller/slider/continuous/track/small/icon` | `2003:14626` | FLOAT | 40 | 35 | 33 | 42 | `5ac8c5cb616d4047367e4bdf3626f5e6b70330f6` |
| `controller/slider/continuous/track/medium/radius_top_left` | `2003:14627` | FLOAT | 24 | 21 | 20 | 26 | `32c4d1b8cb821eb19217bb289c4f49dffb7f2ff0` |
| `controller/slider/continuous/track/medium/radius_top_right` | `2003:14628` | FLOAT | 24 | 21 | 20 | 26 | `bc25e84074d1008839ee5b009eda3d2de0422b50` |
| `controller/slider/continuous/track/medium/radius_bottom_left` | `2003:14629` | FLOAT | 24 | 21 | 20 | 26 | `35521d370a290d0788c29a30b775f572ebb6755c` |
| `controller/slider/continuous/track/medium/radius_bottom_right` | `2003:14630` | FLOAT | 24 | 21 | 20 | 26 | `6a39a6bf47a3029f021b07654d813a9450440b1f` |
| `controller/slider/continuous/track/small/radius_top_left` | `2003:14631` | FLOAT | 20 | 18 | 17 | 22 | `b4d706b005e847356d984c113d822b55ea78635e` |
| `controller/slider/continuous/track/small/radius_top_right` | `2003:14632` | FLOAT | 20 | 18 | 17 | 22 | `a10d90178d2e1ba23f20df4bc1e4b4b7c2915e53` |
| `controller/slider/continuous/track/small/radius_bottom_left` | `2003:14633` | FLOAT | 20 | 18 | 17 | 22 | `64476932c42c519bb52c4ad62a309de3b3461622` |
| `controller/slider/continuous/track/small/radius_bottom_right` | `2003:14634` | FLOAT | 20 | 18 | 17 | 22 | `decfbee24d0cebb5efe2d6426a929ffb0daf0651` |
| `osd/control/radius_top_left` | `2003:14693` | FLOAT | 24; alias → radius/top_left/level7 @2003:5555 | 21 | 20; alias → radius/top_left/level7 @2003:5555 | 26; alias → radius/top_left/level7 @2003:5555 | `67111ed3ee06583abea68845a18315fb216b76cb` |
| `osd/control/radius_top_right` | `2003:14695` | FLOAT | 24; alias → radius/top_right/level7 @2003:14694 | 21 | 20; alias → radius/top_right/level7 @2003:14694 | 26; alias → radius/top_right/level7 @2003:14694 | `5c57dc6592ff8159e63a1e8683dedac395f9bbdb` |
| `osd/control/radius_bottom_left` | `2003:14697` | FLOAT | 24; alias → radius/bottom_left/level7 @2003:14696 | 21 | 20; alias → radius/bottom_left/level7 @2003:14696 | 26; alias → radius/bottom_left/level7 @2003:14696 | `1c1e3e2acd9a61def845a963c0c004ed918bc4d5` |
| `osd/control/radius_bottom_right` | `2003:14699` | FLOAT | 24; alias → radius/bottom_right/level7 @2003:14698 | 21 | 20; alias → radius/bottom_right/level7 @2003:14698 | 26; alias → radius/bottom_right/level7 @2003:14698 | `ddefcc3be87185f036ebd8b2ea2d06290c96f90c` |
| `osd/gap_horizontal_small` | `2003:14700` | FLOAT | 8 | 7 | 8 | 9 | `35d4faeda7bb6211383d2ff5c080976bd2e920fa` |
| `buttons/icon/medium/width` | `2003:14701` | FLOAT | 80 | 70 | 66 | 84 | `eb79974edefd0237fbbd9c38c4e8e4290e380f2b` |
| `buttons/icon/medium/height` | `2003:14702` | FLOAT | 80 | 70 | 66 | 84 | `0ccdcf4edce9fc159c00803f32b0c143ec0c3a8b` |
| `buttons/icon/medium/rounded_radius_top_left` | `2003:14703` | FLOAT | 20 | 18 | 17 | 22 | `68cedd4e9508e09b86f45d5bff4124998f35ae0a` |
| `buttons/icon/medium/rounded_radius_top_right` | `2003:14704` | FLOAT | 20 | 18 | 17 | 22 | `d76e4e53b6d81452479e8e7613711dacd6620d3e` |
| `buttons/icon/medium/rounded_radius_bottom_left` | `2003:14705` | FLOAT | 20 | 18 | 17 | 22 | `cce5f59a18c7143c30aa73245bc61f5443674f99` |
| `buttons/icon/medium/rounded_radius_bottom_right` | `2003:14706` | FLOAT | 20 | 18 | 17 | 22 | `a9a5cf62a729f0a91db737378c6ca4ad5cc9f9c9` |
| `buttons/icon/medium/content` | `2003:14712` | FLOAT | 56 | 49 | 46 | 59 | `275498dccb322af211ca4640e2c3fae2ea856179` |
| `buttons/icon/small/width` | `2003:14714` | FLOAT | 64 | 56 | 54 | 68 | `2e777128b296caf30185e66dd6174b751887011a` |
| `buttons/icon/small/height` | `2003:14715` | FLOAT | 64 | 56 | 54 | 68 | `6e64bfc2ab90675ae547a115c7b431263c4c829e` |
| `buttons/icon/small/rounded_radius_top_left` | `2003:14716` | FLOAT | 16 | 14 | 13 | 17 | `79c3faf607c463a3dc3fa5ed6078ab4b4a81fda1` |
| `buttons/icon/small/rounded_radius_top_right` | `2003:14717` | FLOAT | 16 | 14 | 13 | 17 | `de5f5827dc7680b600cad9b1afb55bb435f123f9` |
| `buttons/icon/small/rounded_radius_bottom_left` | `2003:14718` | FLOAT | 16 | 14 | 13 | 17 | `1cb5f0bc4b66228511ee22179ecbe6cd9c175005` |
| `buttons/icon/small/rounded_radius_bottom_right` | `2003:14719` | FLOAT | 16 | 14 | 1613 | 17 | `e7cefa58caabb725b020b1ad4da8ba9d77b1dd6d` |
| `buttons/icon/small/content` | `2003:14720` | FLOAT | 44 | 39 | 37 | 49 | `6fcde0515ae6b4ddbd2478df432bd8a167fb0252` |
| `buttons/icon/circle_radius_top_left` | `2003:14721` | FLOAT | 999 | 999 | 999 | 999 | `d0a6fc7ad115d42e1683060e94cc86c7d1e7b7e7` |
| `buttons/icon/circle_radius_top_right` | `2003:14722` | FLOAT | 999 | 999 | 999 | 999 | `689d662cd785cee31a28b7cf857afa96a0622964` |
| `buttons/icon/circle_radius_bottom_left` | `2003:14723` | FLOAT | 999 | 999 | 999 | 999 | `9fda4545a4fb8a5de0098cafbb8fd55595745d30` |
| `buttons/icon/circle_radius_bottom_right` | `2003:14724` | FLOAT | 999 | 999 | 999 | 999 | `904569df25648cde4a8e0231015fbb552df4b692` |
| `osd/icon_button_square` | `2003:14762` | FLOAT | 80; alias → square/level18 @2003:5972 | 70 | 66; alias → square/level18 @2003:5972 | 84; alias → square/level18 @2003:5972 | `604422bca1df2e0204002c502b1af9e1c7e323a9` |
| `osd/distance/text_container_square` | `2003:14763` | FLOAT | 40 | 35 | 32 | 42 | `3811b125feaa9df86921b2c565858f8ff9ae6d5f` |
| `osd/distance/image_gap_horizontal` | `2003:14764` | FLOAT | 16 | 14 | 14 | 18 | `55d6abb20536d1adffdfe302c73e37396a173aba` |
| `osd/distance/image_width` | `2003:14765` | FLOAT | 128 | 113 | 108 | 140 | `18cb01b89e5ffcbd1d0fb04d70de2f2ce3f864da` |
| `osd/distance/level 4` | `2003:14766` | FLOAT | 320 | 282 | 266 | 340 | `ec6afe25db6e337aa1d39109dcc0f614323f22ff` |
| `osd/title/prefix_icon_square` | `2003:14775` | FLOAT | 48 | 42 | 40 | 51 | `a8c12db720e5cd7f072845a3e098d1026cb1ef55` |
| `osd/title/icon_square` | `2003:14776` | FLOAT | 52 | 46 | 44 | 56 | `8a5a57ab6705b5b29df5aed4943d50e52f3796d5` |
| `tabs/solid/padding` | `2003:14789` | FLOAT | 8 | 7 | 8 | 9 | `e5939739ea37e75d45797bd67332fc5ef744788b` |
| `tabs/solid/large/height` | `2003:14790` | FLOAT | 100 | 88 | 84 | 106 | `488257316b96b113de770b7cd70562334c7f6a33` |
| `tabs/solid/large/radius_top_left` | `2003:14791` | FLOAT | 32 | 28 | 27 | 35 | `4768c266ff0aedd78bd145d6506f79226cc77256` |
| `tabs/solid/large/radius_top_right` | `2003:14792` | FLOAT | 32 | 28 | 27 | 35 | `3fe6a167af8f3eea9b0cef9cd05d01e0a49ff290` |
| `tabs/solid/large/radius_bottom_left` | `2003:14793` | FLOAT | 32 | 28 | 27 | 35 | `eca91b0b5b076cf0e2187b6fb85fd3dabc8c13d0` |
| `tabs/solid/large/radius_bottom_right` | `2003:14794` | FLOAT | 32 | 28 | 27 | 35 | `8d4d9cd05f017553be03727d7d833a80b0a5454e` |
| `tabs/solid/large/button/gap_horizontal` | `2003:14796` | FLOAT | 14 | 12 | 12 | 16 | `83f13fea2e7717e3daa7be46e76be9c7dadd9811` |
| `tabs/solid/large/button/padding_horizontal` | `2003:14797` | FLOAT | 28 | 25 | 24 | 29 | `07d28077022816944f6756c6a6b7b68fceec31e5` |
| `tabs/solid/large/button/padding_vertical` | `2003:14798` | FLOAT | 16 | 14 | 14 | 17 | `cf9e4e7f58467fb312b296039784cc196baab561` |
| `tabs/solid/large/button/width` | `2003:14799` | FLOAT | 200 | 176 | 166 | 212 | `96e6d5f41d471b260bf51083d2ff72fccb38ea6b` |
| `tabs/solid/large/button/height` | `2003:14800` | FLOAT | 84 | 74 | 70 | 90 | `ae2759a73d37aaa8b8bb7e41c13c51f501281902` |
| `tabs/solid/large/button/radius_top_left` | `2003:14801` | FLOAT | 24 | 21 | 20 | 26 | `ea9d658fdedfe874a29dc8c93ad9dfe6dc055958` |
| `tabs/solid/large/button/radius_top_right` | `2003:14802` | FLOAT | 24 | 21 | 20 | 26 | `c3dfe89eff442263fd217fbc01d30ff6f6360cc8` |
| `tabs/solid/large/button/radius_bottom_left` | `2003:14803` | FLOAT | 24 | 21 | 20 | 26 | `79367264f810f914a676cb6723a731a78484eaff` |
| `tabs/solid/large/button/radius_bottom_right` | `2003:14804` | FLOAT | 24 | 21 | 20 | 26 | `55fa8a24e24dfefb14839f0f67fbe9232388b31a` |
| `tabs/solid/large/button/prefix_icon_square` | `2003:14817` | FLOAT | 52 | 46 | 43 | 55 | `9be66a870a964013946d931e2c0593d16e1b016b` |
| `tabs/solid/medium/button/gap_horizontal` | `2003:14819` | FLOAT | 8 | 7 | 8 | 9 | `da3a92814918424f0e33f3c7f1f3ea4614cc2717` |
| `tabs/solid/medium/button/padding_horizontal` | `2003:14820` | FLOAT | 18 | 16 | 16 | 19 | `6ebccb9eb3e391c970b15fceb3da396fe526e006` |
| `tabs/solid/medium/button/padding_vertical` | `2003:14821` | FLOAT | 12 | 11 | 10 | 13 | `0ae49d8fa44ff0295aa5407d5a25696ddc98b88f` |
| `tabs/solid/medium/button/width` | `2003:14822` | FLOAT | 160 | 141 | 134 | 170 | `cfea895e5a38546882efa74ef0735055a523d9b8` |
| `tabs/solid/medium/button/height` | `2003:14823` | FLOAT | 64 | 56 | 54 | 68 | `b4dfab8a2e99a888292cc8e959edfc372ba2f235` |
| `tabs/solid/medium/button/radius_top_left` | `2003:14824` | FLOAT | 16 | 14 | 13 | 17 | `6f10d797c9241fce858b3a0b1ac810d4b7e6dd76` |
| `tabs/solid/medium/button/radius_top_right` | `2003:14825` | FLOAT | 16 | 14 | 13 | 17 | `9a26c442a78ea9d5080baa8d8aaac1486f3bcd5b` |
| `tabs/solid/medium/button/radius_bottom_left` | `2003:14826` | FLOAT | 16 | 14 | 13 | 17 | `670d4da35f0fc9b5d5a8168113935b8bde8c575d` |
| `tabs/solid/medium/button/radius_bottom_right` | `2003:14827` | FLOAT | 16 | 14 | 13 | 17 | `cef642eb43de5369bbed6bb3cf633fd7f4ebcb40` |
| `tabs/solid/medium/button/prefix_square` | `2003:14828` | FLOAT | 40 | 35 | 33 | 42 | `59cf4f299d166adf67799ac3e3dd9bc9c4e36dd4` |
| `tabs/solid/large/three_segments_width` | `2003:14861` | FLOAT | 880 | 774 | 760 | 934 | `fc114bb0427a149b64f5089fd0b496836b66509b` |
| `tabs/solid/large/two_segments_width` | `2003:14862` | FLOAT | 880 | 774 | 760 | 934 | `96cae27919093d273554987adabec6efd83b0549` |
| `tabs/solid/medium/height` | `2003:14863` | FLOAT | 80 | 70 | 66 | 84 | `b35873769a4bb1ed55cb698740a156660efe477b` |
| `tabs/solid/medium/radius_top_left` | `2003:14864` | FLOAT | 24 | 21 | 20 | 26 | `1063b97526e2238f49ef8cc5c516e4794debc29e` |
| `tabs/solid/medium/radius_top_right` | `2003:14865` | FLOAT | 24 | 21 | 20 | 26 | `5e8f1cc06142652603ce064cee7008fcac581cea` |
| `tabs/solid/medium/radius_bottom_left` | `2003:14866` | FLOAT | 24 | 21 | 20 | 26 | `17d74babf179c26bbcbb3dae604b4887a1724de7` |
| `tabs/solid/medium/radius_bottom_right` | `2003:14867` | FLOAT | 24 | 21 | 20 | 26 | `838a56f63d77936824f7321f8fd519e905062eac` |
| `tabs/solid/medium/four_segments_width` | `2003:14868` | FLOAT | 960 | 845 | 800 | 1020 | `34e5613fbfc0e7372b1345420c4f8d7e018aaa2b` |
| `tabs/solid/medium/three_segments_width` | `2003:14869` | FLOAT | 780 | 686 | 670 | 828 | `36fba0fc8b3db885d372666f35daa81331783341` |
| `tabs/solid/medium/two_segments_width` | `2003:14870` | FLOAT | 780 | 686 | 670 | 828 | `5dd5b46d52ac2fd05dfd32faacd73b87e02aca16` |
| `osd/distance/level 3` | `2003:14942` | FLOAT | 186 | 164 | 154 | 197 | `e8553c2aebcba3736c500c574b26e829e3bd20ac` |
| `osd/lights/title_prefix_icon_square` | `2003:14944` | FLOAT | 48; alias → square/level10 @2003:14943 | 42 | 40; alias → square/level10 @2003:14943 | 51; alias → square/level10 @2003:14943 | `05e76c82a2527868444380ef7945b04395e8d325` |
| `buttons/basic/large/gap_horizontal` | `2003:15000` | FLOAT | 16 | 14 | 14 | 17 | `2ec0745f2bad5e79ff9ccbf2f3e5a19e64d2ae5a` |
| `buttons/basic/large/padding_horizontal` | `2003:15001` | FLOAT | 40 | 35 | 34 | 42 | `2921a2635b2d1fcb19f75f509800f93dad249754` |
| `buttons/basic/large/padding_vertical` | `2003:15002` | FLOAT | 16 | 14 | 14 | 17 | `7e2c35291b1a053d01c2aaffad8e82dcec2ed416` |
| `buttons/basic/large/height` | `2003:15003` | FLOAT | 100 | 88 | 84 | 106 | `e7a7e4fb81ec07e267d9a4e7652992a9129e4b6f` |
| `buttons/basic/large/radius_top_left` | `2003:15004` | FLOAT | 32 | 28 | 27 | 35 | `3bb4c902036a9a4522c56896749b79d22a1c31ed` |
| `buttons/basic/large/min_width` | `2003:15005` | FLOAT | 140 | 123 | 116 | 148 | `38365c35f03e453bf8b03b68aa49294d7ae9c9d7` |
| `buttons/basic/large/icon_sqaure` | `2003:15006` | FLOAT | 52 | 46 | 43 | 55 | `1138031ce646b8ad212cf1d702e0cd698741d492` |
| `buttons/basic/disabled_border` | `2003:15007` | FLOAT | 2 | 2 | 2 | 3 | `f46ede2c4ff7e8cab20d891ffb006c3b4815d293` |
| `buttons/basic/medium/gap_horizontal` | `2003:15008` | FLOAT | 14 | 12 | 12 | 15 | `d1807e06bb980b36bb588bb2a3973d67aa18ffe2` |
| `buttons/basic/medium/padding_horizontal` | `2003:15009` | FLOAT | 32 | 28 | 27 | 35 | `724d5d33a776e673db161c9b111382a88035f1e2` |
| `buttons/basic/medium/padding_vertical` | `2003:15010` | FLOAT | 16 | 14 | 14 | 17 | `f33ad0e020be7e7e58cef4434397683f96f72e20` |
| `buttons/basic/medium/height` | `2003:15011` | FLOAT | 80 | 70 | 66 | 84 | `a83ce895f63b3609055ec030a6f42fbabb20ba58` |
| `buttons/basic/medium/radius_top_left_medium` | `2003:15012` | FLOAT | 24 | 21 | 20 | 26 | `8d616c5959ba6748d693d57bf992a6aba585b0b0` |
| `buttons/basic/medium/min_width` | `2003:15013` | FLOAT | 120 | 106 | 100 | 128 | `61c243e5168337004fdf0c4881edb5ca8f65102a` |
| `buttons/basic/medium/icon_sqaure` | `2003:15014` | FLOAT | 40 | 35 | 33 | 42 | `add4b12bdc6fa1a9a06682ebc145d3b2c90ee216` |
| `buttons/basic/small/gap_horizontal` | `2003:15015` | FLOAT | 12 | 11 | 10 | 13 | `8a66c1ad1e99cf95b4a9657234629a2392e37334` |
| `buttons/basic/small/padding_horizontal` | `2003:15016` | FLOAT | 24 | 21 | 20 | 26 | `113353ca3a7de18abd8e2e59925d46b96ce7d4c3` |
| `buttons/basic/small/padding_vertical` | `2003:15017` | FLOAT | 8 | 7 | 8 | 10 | `c1f561210050235cf2c13a549f5bb73c33caeafa` |
| `buttons/basic/small/height` | `2003:15018` | FLOAT | 64 | 56 | 54 | 68 | `ca7f1a85f58bfc3b73b71773b4481dd9cad4627e` |
| `buttons/basic/small/radius_bottom_right` | `2003:15019` | FLOAT | 16 | 14 | 13 | 17 | `b11259c4eca57b79a7cfd570407a77c804aa770d` |
| `buttons/basic/small/min_width` | `2003:15020` | FLOAT | 100 | 88 | 84 | 106 | `0c42abfa80ca5e46d2b2f945a2e96d70a5658e00` |
| `buttons/basic/small/icon_sqaure` | `2003:15021` | FLOAT | 32 | 28 | 27 | 35 | `356b222ac72584719b2c4b5888fd27e092e98161` |
| `osd/lights/button_width` | `2003:15105` | FLOAT | 120 | 120 | 120 | 120 | `581a92962a81e804dd3e67f753dc9a88851ba596` |
| `osd/distance/level 2` | `2003:15106` | FLOAT | 124 | 109 | 103 | 132 | `25f2a5b9b3c3c5b9e31d41d05b557965e0f8c60d` |
| `osd/seat_position/title_prefix_icon_square` | `2003:15154` | FLOAT | 48; alias → square/level10 @2003:14943 | 42 | 40; alias → square/level10 @2003:14943 | 51; alias → square/level10 @2003:14943 | `6c29a4b4f641bfe1be969efe19070d60cb0fdd23` |
| `osd/distance/level 1` | `2003:15155` | FLOAT | 80 | 70 | 66 | 84 | `6fec0f5d6ac20ee34b7bbf6ea22021c5eb62f6a8` |
| `osd/gap_horizontal_large` | `2003:15156` | FLOAT | 20 | 14 | 16 | 22 | `144489aa85280fd66fea19eefcf60ab47682c81d` |
| `osd/music/album_cover/radius_top_left` | `2003:15177` | FLOAT | 24 | 21 | 20 | 26 | `75d14a9d8e8624fa3d89eea84f73e73bae15842c` |
| `osd/music/album_cover/radius_top_right` | `2003:15178` | FLOAT | 24 | 21 | 20 | 26 | `5af739de5dad5866549fcb1ba1b2c47fbe2275ef` |
| `osd/music/album_cover/radius_bottom_left` | `2003:15179` | FLOAT | 24 | 21 | 20 | 26 | `d8c8e4e35af1830fdc8d3bf9d4454a94d52b03ee` |
| `osd/music/album_cover/radius_bottom_right` | `2003:15180` | FLOAT | 24 | 21 | 20 | 26 | `ded958474905928f7e458425af01b6f28856581e` |
| `osd/music/title_max_width` | `2003:15181` | FLOAT | 328 | 289 | 328 | 328 | `f401c548d8a5e15da9aa800b49da47fc77e24b45` |
| `osd/music/artist_name_min_width` | `2003:15184` | FLOAT | 160 | 141 | 160 | 160 | `e807fe7e324cae92f31e02968a84e652c7943f59` |
| `bars/window_control/padding_horizontal` | `2003:15495` | FLOAT | 8 | 7 | 16 | 20 | `ce40aaa5b0e28fe68186e982ec5b781193c9301a` |
| `bars/window_control/container_width` | `2003:15496` | FLOAT | 20 | 18 | 40 | 48 | `f4eed4c996d124ad01c14f11b4a9c3c96c882c76` |
| `bars/window_control/container_height` | `2003:15497` | FLOAT | 200 | 176 | 240 | 308 | `60cfeecebf2353b01347294cba0b2479ccbe45b6` |
| `bars/window_control/handle_width` | `2003:15498` | FLOAT | 4 | 4 | 8 | 10 | `007272667a2728e68b63c0b890c21e3af6af34a5` |
| `bars/window_control/handle_height` | `2003:15499` | FLOAT | 160 | 141 | 132 | 170 | `96c904c7a9188486fcfb38aca72b2a0eec0ec91b` |
| `bars/window_control/handle_height_pressed` | `2003:15500` | FLOAT | 80 | 70 | 66 | 84 | `3491bc57a5e84499c34e6ba884d378a157d22478` |

## form_factor_common — 2003:5868

- collection key: `f1e3260c01b1d572e607d9f2ad1d9736fc4d08eb`
- 모드 식별자: `connect-s=32090:0`, `connect-l=32259:1`, `connect-w=33219:2`, `connect-waterfall=33235:1`

| Token | ID | Type | connect-s | connect-l | connect-w | connect-waterfall | Key |
| --- | --- | --- | --- | --- | --- | --- | --- |
| `system/size/level13` | `11:8228` | FLOAT | 48 | — | — | — | `fcbf2d7eb3e5229a63f6eec3d2a63464afd0b86a` |
| `system/line_height/level10` | `11:8229` | FLOAT | 68 | — | — | — | `2565a39f01a17c343c1c4d48df0fc6a1103084a6` |
| `font/size_sp/level8` | `2003:5869` | FLOAT | 30 | 26 | 25 | 34 | `0803e9f9d62455e3700fb128fb24e0acd874e2ed` |
| `font/line_height_sp/level8` | `2003:5870` | FLOAT | 38 | 33 | 32 | 41 | `0792c6774ea67bb94c10fbf59eda21acd9403442` |
| `radius/top_left/level9` | `2003:7042` | FLOAT | 32 | 28 | 27 | 35 | `c2974fd1c416da712bbf93627b1949c78d22c402` |
| `radius/top_right/level9` | `2003:7044` | FLOAT | 32 | 28 | 27 | 35 | `e173e9decc4545eb5699b6d6260e53ddfd62ec6e` |
| `radius/bottom_left/level9` | `2003:7046` | FLOAT | 32 | 28 | 27 | 35 | `5e513d1c76cec16baefb50ba92723e04e858e999` |
| `radius/bottom_right/level9` | `2003:7048` | FLOAT | 32 | 28 | 27 | 35 | `0897b0edc09f9429c59f151d563231da45807cfc` |
| `line/level1` | `2003:7050` | FLOAT | 1 | 1 | 1 | 1 | `eab2e8e77464d08a4b86ca4b50205fc3cb6b5243` |
| `line/level5` | `2003:7056` | FLOAT | 6 | 5 | 5 | 5 | `b1a7216190a2e72607e02f5ba3ea8718dd65ae12` |
| `square/level6` | `2003:7122` | FLOAT | 32 | 28 | 27 | 35 | `5e61c47cb026a87e9460706408fe924547e22134` |
| `font/size_sp/level6` | `2003:7123` | FLOAT | 26 | 23 | 22 | 28 | `055799082a6673db937f571b83f4ea37e70ee584` |
| `font/line_height_sp/level6` | `2003:7124` | FLOAT | 34 | 28 | 28 | 36 | `9982d4862a9b81943a3a14e0087b1e27fbe181ed` |
| `font/size_sp/level13` | `2003:7146` | FLOAT | 40 | 35 | 33 | 42 | `058a320d80c16a459185bf88bdd45176a08dc3a4` |
| `font/size_sp/level16` | `2003:7147` | FLOAT | 52 | 46 | 43 | 55 | `578678380bd5968e2d4ea648e154dd441a871a1e` |
| `font/size_sp/level7` | `2003:7149` | FLOAT | 28 | 25 | 23 | 29 | `dadba03ce950307c0430084372d77164b5ec03de` |
| `font/line_height_sp/level7` | `2003:7150` | FLOAT | 36 | 32 | 30 | 38 | `3a36a8c94afa95fac23ccb0cc29e7390453f99d0` |
| `radius/top_left/level5` | `2003:7449` | FLOAT | 16 | 14 | 13 | 17 | `24e3048b1ba71d0336535f737940f1460bf8d054` |
| `radius/top_right/level5` | `2003:7451` | FLOAT | 16 | 14 | 13 | 17 | `ea0d66f6b037c74d086ecafa57bfa17ee89a9f5e` |
| `radius/bottom_left/level5` | `2003:7453` | FLOAT | 16 | 14 | 13 | 17 | `5725f258a819fe97f0fa74455f1fc394a2dc1dfd` |
| `radius/bottom_right/level5` | `2003:7455` | FLOAT | 16 | 14 | 13 | 17 | `ffdaf58028f6dcb8ff524dc6c24636b7cc1024c7` |
| `square/level11` | `2003:8119` | FLOAT | 52 | 46 | 43 | 55 | `5da46679fc0f505b7615b28cf9c5088aab563e05` |
| `font/size_sp/level9` | `2003:8121` | FLOAT | 32 | 28 | 27 | 35 | `6d91f42a8bc61b639c0a9ed479e686847a051493` |
| `font/line_height_sp/level9` | `2003:8122` | FLOAT | 40 | 35 | 33 | 42 | `2668bf31508f6c415636c6a74bc389d2ea67e280` |
| `line/level2` | `2003:8137` | FLOAT | 2 | 2 | 2 | 3 | `906f455422ad7340809ad1754d6f211b109b3fae` |
| `radius/top_left/level7` | `2003:8146` | FLOAT | 24 | 21 | 20 | 26 | `e0038433038a911487bf415ccb4125cfb2c9b472` |
| `square/level8` | `2003:8149` | FLOAT | 40 | 35 | 33 | 42 | `e431b1ed698c5ce349a75aac6de60e6d512b006c` |
| `font/size_sp/level5` | `2003:8238` | FLOAT | 24 | 21 | 20 | 26 | `b3ede9a05ae5c115f0da1efdccd871e86d384679` |
| `font/line_height_sp/level3` | `2003:8239` | FLOAT | 28 | 25 | 23 | 29 | `1b8764ec3a3a44cc7e8032d7271c8bd8616eda2d` |
| `radius/top_left/level6` | `2003:8303` | FLOAT | 20 | 18 | 17 | 22 | `723164f6a6e5a59a3a61e9b500cf73e46f5eed57` |
| `radius/top_right/level6` | `2003:8305` | FLOAT | 20 | 17 | 17 | 22 | `a0ad7746cab81128eb6ae928b267422b8e159e65` |
| `radius/bottom_left/level6` | `2003:8307` | FLOAT | 20 | 17 | 17 | 22 | `a55de8b55e0bcfe2b0cd929ace089ee5283617dc` |
| `radius/bottom_right/level6` | `2003:8309` | FLOAT | 20 | 17 | 17 | 22 | `d8434371d567d35f5ba2629b2b12c5c9163f451e` |
| `square/level12` | `2003:8311` | FLOAT | 56 | 49 | 46 | 59 | `855530be165257da9d1ac67f3f3597bf08389813` |
| `square/level9` | `2003:8318` | FLOAT | 44 | 39 | 37 | 49 | `c315a9c1702dcc195b37dd188059fa36101d4ec5` |
| `radius/top_left/max` | `2003:8320` | FLOAT | 999 | 999 | 999 | 999 | `89f08201e6e4c0cb217d43fb97b3f879273dd250` |
| `radius/top_right/max` | `2003:8322` | FLOAT | 999 | 999 | 999 | 999 | `599b5d45d488f4b5c14852a3bd151561bcff41cc` |
| `radius/bottom_left/max` | `2003:8324` | FLOAT | 999 | 999 | 999 | 999 | `2abd6e89009baa383b91504764a3fb35e1fc2f9c` |
| `radius/bottom_right/max` | `2003:8326` | FLOAT | 999 | 999 | 999 | 999 | `6af81e62278f733368194cbe208aa6a463eaf12d` |
| `line/level4` | `2003:8603` | FLOAT | 4 | 4 | 3 | 4 | `bb77431c7a2d90e89b68cd8b9d2d7ddd798100d5` |
| `square/level18` | `2003:8604` | FLOAT | 80 | 70 | 66 | 84 | `db6a2dca57009abbebb1223186b5f09bc7119d4f` |
| `font/size_sp/level15` | `2003:8622` | FLOAT | 48 | 42 | 40 | 51 | `4e18487437fa06cdddaeee7812ded192b0d8e79a` |
| `font/size_sp/level19` | `2003:8623` | FLOAT | 64 | 56 | 53 | 68 | `f1d243e857ffdec1a3b387cb46505455d7118f4f` |
| `font/size_sp/level11` | `2003:8955` | FLOAT | 36 | 32 | 30 | 38 | `daf658ca8323916420e70c32e31cc2c5e212ef4e` |
| `font/size_sp/level14` | `2003:8956` | FLOAT | 44 | 39 | 37 | 47 | `5b07b79ddf4eb99d91f755a164c321ab5967a57c` |
| `radius/top_left/level3` | `2003:9007` | FLOAT | 8 | 7 | 7 | 9 | `452a8ee4a99c8f0f6e5d343044f7e4e20691e837` |
| `radius/top_right/level3` | `2003:9009` | FLOAT | 8 | 7 | 7 | 9 | `48a91cea8e36c5b307b88e315f9e1adb2fe738e6` |
| `radius/bottom_left/level3` | `2003:9011` | FLOAT | 8 | 7 | 7 | 9 | `62b8adf0c0063133c2b27314d0a55ec183622512` |
| `radius/bottom_right/level3` | `2003:9013` | FLOAT | 8 | 7 | 7 | 9 | `fea95092ad6cfe4e91ca28d879241e6c01e787c0` |
| `radius/top_right/level7` | `2003:9742` | FLOAT | 24 | 21 | 20 | 26 | `56d22f933d4241c618d39a677f630304466aa92a` |
| `radius/bottom_left/level7` | `2003:9744` | FLOAT | 24 | 21 | 20 | 26 | `823ab82ac075b85ca198f6fb5e013d81becc5c14` |
| `radius/bottom_right/level7` | `2003:9746` | FLOAT | 24 | 21 | 20 | 26 | `3628d4e3d087c8e69a57ded7cb6b1d1e2f515df0` |
| `line/level3` | `2003:10324` | FLOAT | 3 | 3 | 3 | 3 | `cf1664a1e92ce403c3aea84d4514914e1165d1fc` |
| `font/size_sp/level18` | `2003:10495` | FLOAT | 60 | 53 | 50 | 64 | `329245d8969a11aac50d1f50d280ec832586eb74` |
| `font/line_height_sp/level19` | `2003:10496` | FLOAT | 80 | 65 | 66 | 84 | `2565a39f01a17c343c1c4d48df0fc6a1103084a6` |
| `font/size_sp/level20` | `2003:10554` | FLOAT | 112 | 99 | 93 | 119 | `110ae899b6e5986381633f24e98f4260be7fc761` |
| `font/line_height_sp/level20` | `2003:10555` | FLOAT | 134 | 118 | 120 | 142 | `503cb488ae969cbc506889f293c240634b872ce2` |
| `font/line_height_sp/level10` | `2003:10562` | FLOAT | 44 | 39 | 37 | 47 | `41fc039a4afa0cc341dd086faa9eefc94ba48853` |
| `square/level22` | `2003:10570` | FLOAT | 100 | 88 | 83 | 106 | `5f5b3cad001886e6e74d47e5f6ecd794bf7de1f7` |
| `square/level13` | `2003:10572` | FLOAT | 60 | 53 | 50 | 64 | `f53e6ac7c2d4d99bd3c2da4a387ae71c3f8b2ac8` |
| `font/line_height_sp/level14` | `2003:10576` | FLOAT | 60 | 46 | 50 | 64 | `9fc9ab6d62420f2f85ed077b165bb5cfab175e53` |
| `radius/top_left/level2` | `2003:10580` | FLOAT | 4 | 4 | 4 | 4 | `9af55d900b0cda6fda1fe39409cf82b433718c61` |
| `radius/top_right/level2` | `2003:10582` | FLOAT | 4 | 4 | 4 | 4 | `3624d975fcb1e84d1d09890e54b91be0c7df2f82` |
| `radius/bottom_left/level2` | `2003:10584` | FLOAT | 4 | 4 | 4 | 4 | `7fa6ce487a802a73653cdf948b813d9d37e5ae8c` |
| `radius/bottom_right/level2` | `2003:10586` | FLOAT | 4 | 4 | 4 | 4 | `30106dbeccdd8a33deda3c5be81c9218f405e7ad` |
| `font/line_height_sp/level11` | `2003:10619` | FLOAT | 48 | 42 | 40 | 51 | `2a277b3135c1a184baf197deb972b4a8758e8c56` |
| `font/size_sp/level2` | `2003:10622` | FLOAT | 18 | 16 | 15 | 19 | `2dd517548989d865583a3461d41d9264a7e0914a` |
| `font/line_height_sp/level1` | `2003:10623` | FLOAT | 24 | 21 | 20 | 26 | `d68a9304e2000ca5f1e3c975e4d1f71bd4059f2a` |
| `square/level16` | `2003:10628` | FLOAT | 72 | 63 | 60 | 77 | `d6a5d06b7cc1d320b00500ba8649752c2a1cf422` |
| `radius/top_right/level3` | `2003:11227` | FLOAT | 8 | 7 | 8 | 8 | `48a91cea8e36c5b307b88e315f9e1adb2fe738e6` |
| `radius/bottom_right/level3` | `2003:11230` | FLOAT | 8 | 7 | 8 | 8 | `fea95092ad6cfe4e91ca28d879241e6c01e787c0` |
| `square/level7` | `2003:11719` | FLOAT | 36 | 28 | 30 | 41 | `490772f3bfd023d1440cd6c00a199314b228ea95` |

## form_factor — 2003:6328

- collection key: `89cb27c71e4cf699e851ee93c18a16b6955e7af9`
- 모드 식별자: `connect-s=32062:0`, `connect-l=32257:0`, `connect-w=33219:0`, `[U+0008]connect-waterfall=33235:0`

| Token | ID | Type | connect-s | connect-l | connect-w | [U+0008]connect-waterfall | Key |
| --- | --- | --- | --- | --- | --- | --- | --- |
| `statusbar/gap_small` | `2003:5567` | FLOAT | 8 | — | — | — | `51882a9ea3b60c038667a1f36783ce2c2e96f24e` |
| `statusbar/height_medium` | `2003:5568` | FLOAT | 80 | — | — | — | `3f4a79bc65b829c882c1b9ebd25bde1c0427b63e` |
| `buttons/circle/container_normal` | `2003:5572` | FLOAT | 80 | — | — | — | `144434a137737406c798e7226a355bea5a8eff63` |
| `buttons/icon/circle_radius_top_left` | `2003:5573` | FLOAT | 999 | — | — | — | `bbef188da85dc76d78461c29e057569ac585e989` |
| `buttons/icon/circle_radius_top_right` | `2003:5574` | FLOAT | 999 | — | — | — | `3b2bcf545d09687315c0a5d33fc2833cba8d4272` |
| `buttons/icon/circle_radius_bottom_left` | `2003:5575` | FLOAT | 999 | — | — | — | `af36664d4a61a1d58fbf2c9364338668f8813b95` |
| `buttons/icon/circle_radius_bottom_right` | `2003:5576` | FLOAT | 999 | — | — | — | `d1b7d1b0a0c551cef41317e53363fcffc3a8b7e9` |
| `buttons/circle/icon_normal` | `2003:5629` | FLOAT | 44 | — | — | — | `2b20e667f5f57795d82cf2d0e438598aa9fe2617` |
| `buttons/circle/container_overlap` | `2003:5726` | FLOAT | 50 | — | — | — | `f22ca2c372565b47fab34b9a525eb17106c2eca9` |
| `window/apps/driving_view_width` | `2003:6329` | FLOAT | 840 | 628 | 1040 | 1280 | `8535e99140bd9effd98f3a5a4448ecf3c4402257` |
| `window/apps/driving_view_height` | `2003:6330` | FLOAT | 1280 | 939 | 850 | 850 | `e594870dc0dce4295b8a0af697a3959095e51a82` |
| `_driving_view/3dview/mask_right_gradient_width` | `2003:7011` | FLOAT | 100 | 88 | 83 | 0 | `de016f11939b8fa0d2b72a446c24d4e138e1790f` |
| `_driving_view/3dview/mask_right_solid_width` | `2003:7014` | FLOAT | 0 | 0 | 100 | 0 | `d1d456ad1a09c9d00f680935bb3f19c6ba5d67b7` |
| `_driving_view/3dview/mask_left_gradient_width` | `2003:7015` | FLOAT | 100 | 88 | 83 | 0 | `147511b31031b173b987e1f52fca8ab671a4e01a` |
| `_driving_view/3dview/mask_bottom_gradient_height` | `2003:7016` | FLOAT | 100 | 88 | 83 | 0 | `0a8ed7ae0106db3ddcb913dac4d8f124e2a2f29a` |
| `_driving_view/3dview/mask_bottom_solid_height` | `2003:7017` | FLOAT | 40 | 35 | 53 | 0 | `6e42ae4e31af233197498d090f8be89725c37e2c` |
| `_driving_view/3dview/mask_top_solid_height` | `2003:7018` | FLOAT | 78 | 137 | 79 | 0 | `1cee1f897f688da232e18e058984becb9012bba5` |
| `_driving_view/3dview/mask_top_solid_dynamic_height` | `2003:7019` | FLOAT | 66 | 58 | 55 | 0 | `226b00a7c062e214831c49055759b6d8b1e97cb1` |
| `_driving_view/3dview/mask_top_gradient_height` | `2003:7020` | FLOAT | 200 | 176 | 166 | 0 | `f748b737fa97df2853b6fccd5bd926fd17b8e4fd` |
| `_driving_view/top/group2/telltale_safety_height` | `2003:7037` | FLOAT | 222 | 253 | 134 | 0 | `6758ec48005c26ade9e8871859a00f5214d9ac35` |
| `utility/padding_horizontal` | `2003:7039` | FLOAT | 24 | 21 | 20 | 0 | `a5e58c662e03948f6724bc375be710ede2998a39` |
| `utility/padding_bottom` | `2003:7040` | FLOAT | 24 | 21 | 20 | 0 | `102fcc877c40288516e9dcc3bc6511988c73518e` |
| `utility/width` | `2003:7041` | FLOAT | 800 | 592 | 660 | 0 | `3d0801a00925c491fb554b656fbfda8762b6e90b` |
| `utility/radius_top_left` | `2003:7043` | FLOAT | 32; alias → radius/top_left/level9 @2003:7042 | 28; alias → radius/top_left/level9 @2003:7042 | 27; alias → radius/top_left/level9 @2003:7042 | 35; alias → radius/top_left/level9 @2003:7042 | `b4b7f0b08bbc95597fe4e88b6565b6e3ab8989e0` |
| `utility/radius_top_right` | `2003:7045` | FLOAT | 32; alias → radius/top_right/level9 @2003:7044 | 28; alias → radius/top_right/level9 @2003:7044 | 27; alias → radius/top_right/level9 @2003:7044 | 35; alias → radius/top_right/level9 @2003:7044 | `0d45280434dff3ceea09b30c5fd6ab3abb8dd1d6` |
| `utility/radius_bottom_left` | `2003:7047` | FLOAT | 32; alias → radius/bottom_left/level9 @2003:7046 | 28; alias → radius/bottom_left/level9 @2003:7046 | 27; alias → radius/bottom_left/level9 @2003:7046 | 35; alias → radius/bottom_left/level9 @2003:7046 | `764fa60dc88d01fa32e257f36f8f8c7ad65d168f` |
| `utility/radius_bottom_right` | `2003:7049` | FLOAT | 32; alias → radius/bottom_right/level9 @2003:7048 | 28; alias → radius/bottom_right/level9 @2003:7048 | 27; alias → radius/bottom_right/level9 @2003:7048 | 35; alias → radius/bottom_right/level9 @2003:7048 | `edd93c78c6648a76465a29f27a479d39b38e90d0` |
| `utility/border` | `2003:7051` | FLOAT | 1; alias → line/level1 @2003:7050 | 1; alias → line/level1 @2003:7050 | 1; alias → line/level1 @2003:7050 | 1; alias → line/level1 @2003:7050 | `34ef4e97056267e64a14388659bee8d2d3b0d42e` |
| `utility/handle/arrow_line` | `2003:7057` | FLOAT | 6; alias → line/level5 @2003:7056 | 5; alias → line/level5 @2003:7056 | 5; alias → line/level5 @2003:7056 | 5; alias → line/level5 @2003:7056 | `d0fccd9ddb447373cecada1f751ad74c7d57ee08` |
| `utility/handle/padding_vertical_top` | `2003:7058` | FLOAT | 12 | 11 | 10 | 0 | `e424fec6e861734cc7e17db4dfb1fc31dca10696` |
| `utility/handle/height` | `2003:7059` | FLOAT | 40 | 35 | 33 | 0 | `5ae9555661958c061f06d4abffa2e90b58d139ed` |
| `utility/handle/arrow_width` | `2003:7060` | FLOAT | 56 | 49 | 46 | 0 | `2c01a2cb9ea1de2ad518bef6b820654a2ba6fbab` |
| `utility/handle/arrow_height` | `2003:7061` | FLOAT | 16 | 14 | 13 | 0 | `f0380be03178226b9e7e1ce4914501403aa662df` |
| `utility/handle/line_width` | `2003:7065` | FLOAT | 80 | 70 | 66 | 0 | `937bcd724d52d9b765658faad885529f97bf3bfa` |
| `utility/page_indicator_gap_horizontal` | `2003:7066` | FLOAT | 10 | 9 | 8 | 0 | `f0907da88dde9a86c539bfa00e98274e09ecdbc8` |
| `utility/page_indicator_dot_square` | `2003:7067` | FLOAT | 8 | 7 | 7 | 0 | `53d6ce54c5553f583b6fc604c35e9aa6547154ab` |
| `utility/item_gap_large` | `2003:7100` | FLOAT | 24 | 21 | 20 | 0 | `5097e9f005a0a15dcdf1239f2a306908d4bfd205` |
| `utility/item_height` | `2003:7101` | FLOAT | 112 | 100 | 94 | 0 | `310f68075e5860f3877acdee8501ea7884c4591f` |
| `utility/title_width` | `2003:7102` | FLOAT | 224 | 197 | 186 | 0 | `508713e0003fbe1166a1baa46403d205295232d6` |
| `utility/title_padding_horizontal` | `2003:7103` | FLOAT | 16 | 14 | 13 | 0 | `eeebf2bab163be3e3c7b131f2eab66f38c1d8334` |
| `buttons/basic/small/height` | `2003:7108` | FLOAT | 64 | 56 | 54 | 68 | `6adb5df4939235fbe3d1f2bebcdcb3e3bbefb3ff` |
| `utility/tpms/detail_padding_horizontal` | `2003:7143` | FLOAT | 16 | 14 | 13 | 0 | `508680b198a0b75912a14cba7c0f6ee98be564d1` |
| `utility/tpms/detail_psi_gap_vertical` | `2003:7144` | FLOAT | 4 | 3 | 3 | 0 | `a54be0f2cf5d3d3b0b93682d69163e69fe847b52` |
| `utility/tpms/detail_psi_padding_vertical_bottom` | `2003:7145` | FLOAT | 4 | 3 | 3 | 0 | `6c0151e7c4318c52b81634d9f45c7a0ac1f9e797` |
| `utility/tpms/detail_psi_padding_vertical_top` | `2003:7152` | FLOAT | 4 | 3 | 3 | 0 | `839a5c9bb662fe63aaa8a2710f52ac82a960d0fe` |
| `utility/tpms/detail_vehicle_image_piece_square` | `2003:7153` | FLOAT | 56 | 50 | 47 | 0 | `52629d208d24b74e333085fbe914d7aae982b90c` |
| `utility/tpms/detail_error_gap_horizontal` | `2003:7408` | FLOAT | 8 | 7 | 7 | 0 | `eb070bf949dc58e74334228985b84d87c3bbdf44` |
| `utility/tpms/detail_error_icon_square` | `2003:7446` | FLOAT | 28 | 25 | 24 | 0 | `b5e7a1f16072616ebf1bd35d3a17dfc599459bf0` |
| `utility/tpms/detail_error_gap_vertical` | `2003:7448` | FLOAT | 8 | 7 | 7 | 0 | `e01f03aa7d655bd6649071f392663931cab07aa4` |
| `utility/tpms/detail_error_container_radius_top_left` | `2003:7450` | FLOAT | 16; alias → radius/top_left/level5 @2003:7449 | 14; alias → radius/top_left/level5 @2003:7449 | 13; alias → radius/top_left/level5 @2003:7449 | 0 | `87984f9b9e8edb0363678ade65980882062b65d1` |
| `utility/tpms/detail_error_container_radius_top_right` | `2003:7452` | FLOAT | 16; alias → radius/top_right/level5 @2003:7451 | 14; alias → radius/top_right/level5 @2003:7451 | 13; alias → radius/top_right/level5 @2003:7451 | 0 | `3dc72571ee540c6d249c610fb25ae4e35dc1b39c` |
| `utility/tpms/detail_error_container_radius_bottom_left` | `2003:7454` | FLOAT | 16; alias → radius/bottom_left/level5 @2003:7453 | 14; alias → radius/bottom_left/level5 @2003:7453 | 13; alias → radius/bottom_left/level5 @2003:7453 | 0 | `9066f588dd04204e9891bd3fc574ef3cb2d49bfd` |
| `utility/tpms/detail_error_container_radius_bottom_right` | `2003:7456` | FLOAT | 16; alias → radius/bottom_right/level5 @2003:7455 | 14; alias → radius/bottom_right/level5 @2003:7455 | 13; alias → radius/bottom_right/level5 @2003:7455 | 0 | `3f0d50f5a6f340aac465f46d41c3fb3e82866c22` |
| `utility/item_gap_medium` | `2003:7554` | FLOAT | 16 | 14 | 13 | 0 | `315fd58cbc165c64aea94a532bef944042a56289` |
| `utility/icon_square` | `2003:8044` | FLOAT | 64 | 56 | 53 | 0 | `7bf946d01c6008d78565936905731b6bbbdde653` |
| `notification/vehicle/text_max_height` | `2003:8045` | FLOAT | 144 | 127 | 120 | 154 | `e6c62c61458d06f05298933705e8d8dcdb517651` |
| `notification/vehicle/text_min_width` | `2003:8046` | FLOAT | 200 | 176 | 166 | 212 | `97c293cc6891e868c313e6c4c28c4e0aa8de7f41` |
| `notification/vehicle/text_with_icon_max_width` | `2003:8047` | FLOAT | 428 | 377 | 348 | 454 | `79048a2145456a210d2fc20865f8b51bad94a3a1` |
| `buttons/basic/large/gap_horizontal` | `2003:8058` | FLOAT | 16 | 14 | 14 | 17 | `cabe8b4459e2a1a0008a93dc85018846cf4aae82` |
| `buttons/basic/large/padding_horizontal` | `2003:8059` | FLOAT | 40 | 35 | 34 | 42 | `bec5ab97a95a5147e7997283ace3307df1e430a3` |
| `buttons/basic/large/padding_vertical` | `2003:8060` | FLOAT | 16 | 14 | 14 | 17 | `5e9b441ac390476e71f3616a0eaa2325d60785e3` |
| `buttons/basic/large/height` | `2003:8061` | FLOAT | 100 | 88 | 84 | 106 | `2423e19228ba3e25360132b3606e8d1f327d93a8` |
| `buttons/basic/large/radius_top_left` | `2003:8062` | FLOAT | 32; alias → radius/top_left/level9 @2003:7042 | 28; alias → radius/top_left/level9 @2003:7042 | 27; alias → radius/top_left/level9 @2003:7042 | 35; alias → radius/top_left/level9 @2003:7042 | `c9ec0c38a955887af503b0919ecd518f97c7f97a` |
| `buttons/basic/large/min_width` | `2003:8063` | FLOAT | 140 | 123 | 116 | 148 | `765ee1a2215123fa218c7d83584bd348d4afd822` |
| `buttons/basic/large/icon_sqaure` | `2003:8120` | FLOAT | 52; alias → square/level11 @2003:8119 | 46; alias → square/level11 @2003:8119 | 43; alias → square/level11 @2003:8119 | 55; alias → square/level11 @2003:8119 | `5c8eedb2e4c93050f4247a09ddae9124356e7af5` |
| `buttons/basic/disabled_border` | `2003:8138` | FLOAT | 2; alias → line/level2 @2003:8137 | 2; alias → line/level2 @2003:8137 | 2; alias → line/level2 @2003:8137 | 3; alias → line/level2 @2003:8137 | `23baadf03deadb961d455b2a1f6852e4cb4cf38d` |
| `buttons/basic/medium/gap_horizontal` | `2003:8142` | FLOAT | 14 | 12 | 12 | 15 | `c84ae72468e7029fcea00cb545dd5cecf12e5e77` |
| `buttons/basic/medium/padding_horizontal` | `2003:8143` | FLOAT | 32 | 28 | 27 | 35 | `03728a3d2f8131ae14580a6f2ae0b804bbb58f68` |
| `buttons/basic/medium/padding_vertical` | `2003:8144` | FLOAT | 16 | 14 | 14 | 17 | `326460dab8781e86efc5d3701ba6a9aeadaf60c2` |
| `buttons/basic/medium/height` | `2003:8145` | FLOAT | 80 | 70 | 66 | 84 | `48aa090461cc77f1f29af188a0e5a22892cdb1b6` |
| `buttons/basic/medium/radius_top_left_medium` | `2003:8147` | FLOAT | 24; alias → radius/top_left/level7 @2003:8146 | 21; alias → radius/top_left/level7 @2003:8146 | 20; alias → radius/top_left/level7 @2003:8146 | 26; alias → radius/top_left/level7 @2003:8146 | `520c0bcfaab44b2a9cbc3fc03946698c30e0755b` |
| `buttons/basic/medium/min_width` | `2003:8148` | FLOAT | 120 | 106 | 100 | 128 | `e8c4d1034dee58d0d2c44483bdd96a10c84f5392` |
| `buttons/basic/medium/icon_sqaure` | `2003:8150` | FLOAT | 40; alias → square/level8 @2003:8149 | 35; alias → square/level8 @2003:8149 | 33; alias → square/level8 @2003:8149 | 42; alias → square/level8 @2003:8149 | `e1745049cf17307f36066d238292b6a4aa58fa23` |
| `buttons/basic/small/gap_horizontal` | `2003:8151` | FLOAT | 12 | 11 | 10 | 13 | `8121b6cd66e3990510d961daac6190901f782b2c` |
| `buttons/basic/small/padding_horizontal` | `2003:8152` | FLOAT | 24 | 21 | 20 | 26 | `fa3f64449e353371520125a7938e2feb64da5ab3` |
| `buttons/basic/small/padding_vertical` | `2003:8153` | FLOAT | 8 | 7 | 8 | 10 | `72a32837b2cbf0563de85f44f1cb8dcc1c8b40e1` |
| `buttons/basic/small/radius_bottom_right` | `2003:8154` | FLOAT | 16; alias → radius/bottom_right/level5 @2003:7455 | 14; alias → radius/bottom_right/level5 @2003:7455 | 13; alias → radius/bottom_right/level5 @2003:7455 | 17; alias → radius/bottom_right/level5 @2003:7455 | `d76b886d81b980c5624251aa15036ec44d70af15` |
| `buttons/basic/small/min_width` | `2003:8155` | FLOAT | 100 | 88 | 84 | 106 | `db1f665c14f511a124869a91577789329ada40aa` |
| `buttons/basic/small/icon_sqaure` | `2003:8156` | FLOAT | 32; alias → square/level6 @2003:7122 | 28; alias → square/level6 @2003:7122 | 27; alias → square/level6 @2003:7122 | 35; alias → square/level6 @2003:7122 | `ec1c18c50492dc1a396d91f98ea6816afd7564b4` |
| `utility/button_min_width` | `2003:8237` | FLOAT | 160 | 141 | 133 | 0 | `175d8974e198aedf0104bf0f6a72deb1c82fb5ba` |
| `buttons/icon/medium/width` | `2003:8302` | FLOAT | 80 | 70 | 66 | 84 | `15d84f858a81dbabf3ea767e330fe6942e57e348` |
| `buttons/icon/medium/rounded_radius_top_left` | `2003:8304` | FLOAT | 20; alias → radius/top_left/level6 @2003:8303 | 18; alias → radius/top_left/level6 @2003:8303 | 17; alias → radius/top_left/level6 @2003:8303 | 22; alias → radius/top_left/level6 @2003:8303 | `d14ad7df4b197ebde7c1d0a75240f1e0338cb951` |
| `buttons/icon/medium/rounded_radius_top_right` | `2003:8306` | FLOAT | 20; alias → radius/top_right/level6 @2003:8305 | 17; alias → radius/top_right/level6 @2003:8305 | 17; alias → radius/top_right/level6 @2003:8305 | 22; alias → radius/top_right/level6 @2003:8305 | `de181e2201f6393024f86a6ab65c0a26bbe33b88` |
| `buttons/icon/medium/rounded_radius_bottom_left` | `2003:8308` | FLOAT | 20; alias → radius/bottom_left/level6 @2003:8307 | 17; alias → radius/bottom_left/level6 @2003:8307 | 17; alias → radius/bottom_left/level6 @2003:8307 | 22; alias → radius/bottom_left/level6 @2003:8307 | `e8c46b3d1771acfc485bc5b933820d8ca2ee6954` |
| `buttons/icon/medium/rounded_radius_bottom_right` | `2003:8310` | FLOAT | 20; alias → radius/bottom_right/level6 @2003:8309 | 17; alias → radius/bottom_right/level6 @2003:8309 | 17; alias → radius/bottom_right/level6 @2003:8309 | 22; alias → radius/bottom_right/level6 @2003:8309 | `310ba6c1413463ebc1623db54e8e4ed28165585e` |
| `buttons/icon/medium/content` | `2003:8312` | FLOAT | 56; alias → square/level12 @2003:8311 | 49; alias → square/level12 @2003:8311 | 46; alias → square/level12 @2003:8311 | 59; alias → square/level12 @2003:8311 | `32653468a9de468b47c4207a0e0fee88e36fed3d` |
| `buttons/icon/small/width` | `2003:8313` | FLOAT | 64 | 56 | 54 | 68 | `6dee730649d21212b870425d344d3af518ccc9c5` |
| `buttons/icon/small/rounded_radius_top_left` | `2003:8314` | FLOAT | 16; alias → radius/top_left/level5 @2003:7449 | 14; alias → radius/top_left/level5 @2003:7449 | 13; alias → radius/top_left/level5 @2003:7449 | 17; alias → radius/top_left/level5 @2003:7449 | `5d29aab87c683552694cb953d6020f4d076ff85d` |
| `buttons/icon/small/rounded_radius_top_right` | `2003:8315` | FLOAT | 16; alias → radius/top_right/level5 @2003:7451 | 14; alias → radius/top_right/level5 @2003:7451 | 13; alias → radius/top_right/level5 @2003:7451 | 17; alias → radius/top_right/level5 @2003:7451 | `20724f30d54f0815859715f3cafdcb4698640dde` |
| `buttons/icon/small/rounded_radius_bottom_left` | `2003:8316` | FLOAT | 16; alias → radius/bottom_left/level5 @2003:7453 | 14; alias → radius/bottom_left/level5 @2003:7453 | 13; alias → radius/bottom_left/level5 @2003:7453 | 17; alias → radius/bottom_left/level5 @2003:7453 | `1e2b82362f81fa96771b580225d6491fc302315d` |
| `buttons/icon/small/rounded_radius_bottom_right` | `2003:8317` | FLOAT | 16; alias → radius/bottom_right/level5 @2003:7455 | 14; alias → radius/bottom_right/level5 @2003:7455 | 13; alias → radius/bottom_right/level5 @2003:7455 | 17; alias → radius/bottom_right/level5 @2003:7455 | `a335bb215824a3667d3116382beed7ddb69aeb0a` |
| `buttons/icon/small/content` | `2003:8319` | FLOAT | 44; alias → square/level9 @2003:8318 | 39; alias → square/level9 @2003:8318 | 37; alias → square/level9 @2003:8318 | 49; alias → square/level9 @2003:8318 | `2ea476af5de33fc3315334c51a9734b0e15c8a71` |
| `buttons/icon/circle_radius_top_left` | `2003:8321` | FLOAT | 999; alias → radius/top_left/max @2003:8320 | 999; alias → radius/top_left/max @2003:8320 | 999; alias → radius/top_left/max @2003:8320 | 999; alias → radius/top_left/max @2003:8320 | `bbef188da85dc76d78461c29e057569ac585e989` |
| `buttons/icon/circle_radius_top_right` | `2003:8323` | FLOAT | 999; alias → radius/top_right/max @2003:8322 | 999; alias → radius/top_right/max @2003:8322 | 999; alias → radius/top_right/max @2003:8322 | 999; alias → radius/top_right/max @2003:8322 | `3b2bcf545d09687315c0a5d33fc2833cba8d4272` |
| `buttons/icon/circle_radius_bottom_left` | `2003:8325` | FLOAT | 999; alias → radius/bottom_left/max @2003:8324 | 999; alias → radius/bottom_left/max @2003:8324 | 999; alias → radius/bottom_left/max @2003:8324 | 999; alias → radius/bottom_left/max @2003:8324 | `af36664d4a61a1d58fbf2c9364338668f8813b95` |
| `buttons/icon/circle_radius_bottom_right` | `2003:8327` | FLOAT | 999; alias → radius/bottom_right/max @2003:8326 | 999; alias → radius/bottom_right/max @2003:8326 | 999; alias → radius/bottom_right/max @2003:8326 | 999; alias → radius/bottom_right/max @2003:8326 | `d1b7d1b0a0c551cef41317e53363fcffc3a8b7e9` |
| `imagery/cover/radius_top_left` | `2003:8368` | FLOAT | 20; alias → radius/top_left/level6 @2003:8303 | 18; alias → radius/top_left/level6 @2003:8303 | 17; alias → radius/top_left/level6 @2003:8303 | 22; alias → radius/top_left/level6 @2003:8303 | `589f55740daea30e2ba320169c30f19fef4ccc89` |
| `imagery/cover/radius_top_right` | `2003:8369` | FLOAT | 20; alias → radius/top_right/level6 @2003:8305 | 17; alias → radius/top_right/level6 @2003:8305 | 17; alias → radius/top_right/level6 @2003:8305 | 22; alias → radius/top_right/level6 @2003:8305 | `c4673abb4fad90ee1fc7168c2c5f8cb585905b4b` |
| `imagery/cover/radius_bottom_left` | `2003:8370` | FLOAT | 20; alias → radius/bottom_left/level6 @2003:8307 | 17; alias → radius/bottom_left/level6 @2003:8307 | 17; alias → radius/bottom_left/level6 @2003:8307 | 22; alias → radius/bottom_left/level6 @2003:8307 | `5b6fb95eb60fccd2e905b08bd7ef783847ef5fed` |
| `imagery/cover/radius_bottom_right` | `2003:8371` | FLOAT | 20; alias → radius/bottom_right/level6 @2003:8309 | 17; alias → radius/bottom_right/level6 @2003:8309 | 17; alias → radius/bottom_right/level6 @2003:8309 | 22; alias → radius/bottom_right/level6 @2003:8309 | `a7026d56c1a688d59d30fcb6289d13c17e9aecd0` |
| `imagery/cover/border` | `2003:8372` | FLOAT | 2; alias → line/level2 @2003:8137 | 2; alias → line/level2 @2003:8137 | 2; alias → line/level2 @2003:8137 | 3; alias → line/level2 @2003:8137 | `fe7f4e32c6e88c9c3362359a83d0e30c7137bf29` |
| `window/apps/portrait_width` | `2003:8538` | FLOAT | 840 | 628 | 800 | 716 | `e112b67a5a710f4ea898282d5db118dfacf9a938` |
| `_driving_view/3dview/parking_icon_square` | `2003:8605` | FLOAT | 80; alias → square/level18 @2003:8604 | 70; alias → square/level18 @2003:8604 | 66; alias → square/level18 @2003:8604 | 84; alias → square/level18 @2003:8604 | `2977791ef3f3dfe68a2d6a9cb544eebabfc5c610` |
| `_driving_view/3dview/turning_point_line` | `2003:8620` | FLOAT | 6; alias → line/level5 @2003:7056 | 5; alias → line/level5 @2003:7056 | 5; alias → line/level5 @2003:7056 | 0 | `0fef9c6d26d98dcf8615a974c6a29bbbdbf9ebb9` |
| `_driving_view/3dview/autoparking_trajectory_line` | `2003:8621` | FLOAT | 40 | 35 | 40 | 0 | `a93a913b5253ee9a058a98c1d2c68d191c9475a5` |
| `_driving_view/top/group1/gap_vertical` | `2003:8850` | FLOAT | 10 | 9 | 8 | 0 | `33dc792f9804d4ef125f2226d5bfbd33655bd57e` |
| `_driving_view/top/group1/guage_height` | `2003:8851` | FLOAT | 8 | 7 | 7 | 0 | `00d8456c4ba83a8c78a494cec896e2a9531edbb1` |
| `_driving_view/top/group1/gap_horizontal` | `2003:8907` | FLOAT | 8 | 0 | 8 | 0 | `29693af4c8b4d0d3560ebd1a139737888c4c66a3` |
| `_driving_view/top/group1/padding_horizontal` | `2003:8908` | FLOAT | 20 | 18 | 28 | 0 | `5daec3277f930fa65cc7ecc4bfbfa8806f30c961` |
| `_driving_view/top/group2/telltale_square` | `2003:8909` | FLOAT | 60 | 53 | 50 | 0 | `74d698b4405c7bb26a63d31fdbc67093c2b561c9` |
| `_driving_view/top/group1/prnd_gap_horizontal` | `2003:8910` | FLOAT | 4 | 3 | 4 | 0 | `c5757ea35a44817750d364221a9ed3a48097a2df` |
| `_driving_view/top/group1/powertrain_height` | `2003:8911` | FLOAT | 60 | 53 | 64 | 0 | `2acb9e2a9baf0f7669ad2b55d6c6d89d6a789b53` |
| `_driving_view/top/group1/prnd_unit_selected_square` | `2003:8912` | FLOAT | 48 | 42 | 48 | 0 | `809f973c6a88397ac26e63262a8fdb17c0403522` |
| `_driving_view/top/group1/prnd_unit_selected_square_radius_top_left` | `2003:8913` | FLOAT | 8 | 7 | 8 | 0 | `bb2680d570044c0d1407195d1a6339d57476b32a` |
| `_driving_view/top/group1/prnd_unit_selected_square_radius_top_right` | `2003:8914` | FLOAT | 8 | 7 | 8 | 0 | `82e1aad8d191e3756448c9b57d59a331ac138b95` |
| `_driving_view/top/group1/prnd_unit_selected_square_radius_bottom_left` | `2003:8915` | FLOAT | 8 | 7 | 8 | 0 | `eaab00c20b5ffc374fde02ee97a766ce3a00ad8c` |
| `_driving_view/top/group1/prnd_unit_selected_square_radius_bottom_right` | `2003:8916` | FLOAT | 8 | 7 | 8 | 0 | `1d8d5bb0026f227fa78467022713fdb2da2f649f` |
| `_driving_view/top/group1/prnd_unit_width` | `2003:8917` | FLOAT | 30 | 26 | 30 | 0 | `a56e086ef22bfee67b39d7ff2094d25bb1da2391` |
| `_driving_view/top/group1/powertrain_icon_square` | `2003:9004` | FLOAT | 48 | 42 | 48 | 0 | `8b2b6bca0262c54cbc3592ba2c87def4ea87598f` |
| `_driving_view/top/group1/power_guage_height` | `2003:9005` | FLOAT | 36 | 32 | 36 | 0 | `c8a5bc460d63ec39ef8d8bc42f52d138dc90f7fb` |
| `_driving_view/top/group1/power_guage_width` | `2003:9006` | FLOAT | 68 | 60 | 68 | 0 | `f385376879c2337627b71ab8ff6a46a705a6c498` |
| `_driving_view/top/group1/power_guage_radius_top_left` | `2003:9008` | FLOAT | 8; alias → radius/top_left/level3 @2003:9007 | 7; alias → radius/top_left/level3 @2003:9007 | 7; alias → radius/top_left/level3 @2003:9007 | 0 | `c376d8fd44e2338267246c885a1af6076b0d04a5` |
| `_driving_view/top/group1/power_guage_radius_top_right` | `2003:9010` | FLOAT | 8; alias → radius/top_right/level3 @2003:11227 | 7; alias → radius/top_right/level3 @2003:11227 | 8; alias → radius/top_right/level3 @2003:11227 | 0 | `5d5de579d6b422ff0cb358cb721e0457ef2076e2` |
| `_driving_view/top/group1/power_guage_radius_bottom_left` | `2003:9012` | FLOAT | 8; alias → radius/bottom_left/level3 @2003:9011 | 7; alias → radius/bottom_left/level3 @2003:9011 | 7; alias → radius/bottom_left/level3 @2003:9011 | 0 | `c7d47a490bdc819d5532fe999f99cd72cba67a75` |
| `_driving_view/top/group1/power_guage_radius_bottom_right` | `2003:9014` | FLOAT | 8; alias → radius/bottom_right/level3 @2003:11230 | 7; alias → radius/bottom_right/level3 @2003:11230 | 8; alias → radius/bottom_right/level3 @2003:11230 | 0 | `d2d89d96fd5097d5846d7ec5e459cf28323e4531` |
| `_driving_view/top/group1/power_guage_ev_gap_horizontal` | `2003:9015` | FLOAT | 2 | 2 | 2 | 0 | `927924573b4f504bd405feecb0ed1f7fb0157a61` |
| `_driving_view/top/group1/power_guage_state_icon_square` | `2003:9065` | FLOAT | 32 | 28 | 32 | 0 | `0efc7af5754da4514d560c4d0e09b3b8ef79a1a1` |
| `_driving_view/top/group2/padding_horizontal_left` | `2003:9200` | FLOAT | 232 | 151 | 193 | 0 | `5e5fdcf5d1ed519ae03943097df4c93899f342d8` |
| `_driving_view/top/group2/padding_vertical_top` | `2003:9201` | FLOAT | 18 | 15 | 5 | 8 | `104429cb466f696317454e24eeed546821116238` |
| `_driving_view/top/group2/padding_horizontal_right` | `2003:9202` | FLOAT | 20 | 18 | 28 | 0 | `64152995735249e75dbca5b42481acc6a5633e3c` |
| `_driving_view/top/group2/gap_horizontal` | `2003:9203` | FLOAT | 6 | 5 | 4 | 0 | `3deb63badaffd24c7c666a80a6170e219fbd9d77` |
| `_driving_view/top/group2/gap_vertical` | `2003:9204` | FLOAT | 6 | 5 | 4 | 0 | `ad21cb21334058badacd6644a301d5a61baca7ff` |
| `_driving_view/top/group2/min_height` | `2003:9731` | FLOAT | 0 | 0 | 50 | 0 | `aba20689c8e41b3c068b7a304401b11499720c5b` |
| `_driving_view/top/group2/max_height` | `2003:9732` | FLOAT | 258 | 227 | 105 | 0 | `38d855369454e45a0dd4d258f6008ec611963d3e` |
| `_driving_view/top/group3/gap_vertical` | `2003:9733` | FLOAT | 8 | 7 | 7 | 0 | `ea12a55c3520ba8c0dbe9cec1a5d7c6b27846847` |
| `_driving_view/top/group3/padding_horizontal_left` | `2003:9734` | FLOAT | 20 | 135 | 17 | 0 | `735e3b095ccb9be9c5ca1f5e55f9bf3fcab37b99` |
| `_driving_view/top/group3/padding_vertical_top` | `2003:9735` | FLOAT | 24 | 21 | 20 | 0 | `d8f8b0af174c0fc7b9d9fa1a44f2f3d300c3e378` |
| `_driving_view/top/group3/padding_horizontal_right` | `2003:9736` | FLOAT | 20 | 18 | 17 | 0 | `644f4e72733dbb8f458552c171032b4742b768cc` |
| `notification/gap_medium` | `2003:9738` | FLOAT | 16 | 14 | 14 | 17 | `878b5736c0df8491f6bb00d92dd69ac0aa83761a` |
| `notification/vehicle/text_side_padding_vertical` | `2003:9739` | FLOAT | 20 | 18 | 18 | 23 | `bc63a3308ba3e8ecc6fc1795471c0c1f6b8a939d` |
| `notification/padding_small` | `2003:9740` | FLOAT | 16 | 14 | 14 | 16 | `4f811847dbc9adb746f69eedc3472ae937d7dfeb` |
| `notification/vehicle/radius_top_left` | `2003:9741` | FLOAT | 24; alias → radius/top_left/level7 @2003:8146 | 21; alias → radius/top_left/level7 @2003:8146 | 20; alias → radius/top_left/level7 @2003:8146 | 26; alias → radius/top_left/level7 @2003:8146 | `dbd19243a2ef284b1b53f1593766abde7e1471cf` |
| `notification/vehicle/radius_top_right` | `2003:9743` | FLOAT | 24; alias → radius/top_right/level7 @2003:9742 | 21; alias → radius/top_right/level7 @2003:9742 | 20; alias → radius/top_right/level7 @2003:9742 | 26; alias → radius/top_right/level7 @2003:9742 | `ae619be5ff955ed3937d1ecc040aed88dffb032d` |
| `notification/vehicle/radius_bottom_left` | `2003:9745` | FLOAT | 24; alias → radius/bottom_left/level7 @2003:9744 | 21; alias → radius/bottom_left/level7 @2003:9744 | 20; alias → radius/bottom_left/level7 @2003:9744 | 26; alias → radius/bottom_left/level7 @2003:9744 | `abce28ca5d5f91479e5143f3cbc36658a8858e81` |
| `notification/vehicle/radius_bottom_right` | `2003:9747` | FLOAT | 24; alias → radius/bottom_right/level7 @2003:9746 | 21; alias → radius/bottom_right/level7 @2003:9746 | 20; alias → radius/bottom_right/level7 @2003:9746 | 26; alias → radius/bottom_right/level7 @2003:9746 | `8713164f9eb74a2e1fc0c6abf8e1f4d58a55ec61` |
| `notification/border` | `2003:9748` | FLOAT | 1; alias → line/level1 @2003:7050 | 1; alias → line/level1 @2003:7050 | 1; alias → line/level1 @2003:7050 | 1; alias → line/level1 @2003:7050 | `7617a7a366c2795b8a0b894bf55e5d35cc76f53f` |
| `notification/vehicle/max_width` | `2003:9749` | FLOAT | 540 | 475 | 448 | 573 | `5ffd2544c6eadc7ba13487a593094c4bdb54df60` |
| `notification/vehicle/text_only_max_width` | `2003:9750` | FLOAT | 500 | 440 | 412 | 532 | `aed73561f141e2cf2efe89033d4fb0f711b6655c` |
| `notification/vehicle/max_height` | `2003:9751` | FLOAT | 176 | 155 | 146 | 187 | `20448a1e603c71d8245d0b27d5278e6e5be5bae0` |
| `notification/vehicle/padding_vertical` | `2003:9753` | FLOAT | 16 | 14 | 14 | 18 | `993d4c09dfedf9e7a12e1a7a2a16b5f0f692aa0f` |
| `notification/vehicle/gap_horizontal` | `2003:9754` | FLOAT | 16 | 14 | 14 | 18 | `ab484e58ce5f336a1f0a52922d704f74bf518bc5` |
| `notification/vehicle/image_side_padding_vertical` | `2003:9755` | FLOAT | 16 | 14 | 14 | 18 | `80519dcdd1af54b0b40a6e9dc170f0b88623b819` |
| `notification/vehicle/images/small_square` | `2003:9756` | FLOAT | 64 | 56 | 54 | 69 | `67de674154cf9a0105db1f9f0e3a5106ff1e1642` |
| `notification/vehicle/text_with_icon_image_max_width` | `2003:9757` | FLOAT | 284 | 250 | 232 | 302 | `ce9f8f7b5c82e95541e0a3aa2a049f9cf9128eca` |
| `notification/vehicle/images/medium_square` | `2003:9758` | FLOAT | 128 | 113 | 106 | 136 | `0f27667972c7ce9e7a1a95c1496ead67b64bc887` |
| `notification/padding_medium` | `2003:9933` | FLOAT | 24 | 21 | 20 | 26 | `2ceb2df7048c83d978f2e4661f91c63ee66ba93b` |
| `notification/vehicle/images/large_width` | `2003:9934` | FLOAT | 160 | 141 | 134 | 172 | `8d717217115c0a27b3fe63bd11f3238a8a3d9911` |
| `_driving_view/top/group3/minitbt_[U+0008]gap_horizontal` | `2003:10001` | FLOAT | 16 | 14 | 13 | 0 | `ba32a7f2d146a0b68ade0838b47cd313285a88b3` |
| `_driving_view/top/group3/minitbt_padding_horizontal_left` | `2003:10002` | FLOAT | 8 | 7 | 7 | 0 | `d7a30f4932b167193807848f46562440f54150bb` |
| `_driving_view/top/group3/minitbt_padding_vertical` | `2003:10003` | FLOAT | 12 | 11 | 10 | 0 | `3b8a78b989e6a84f37fcfa2fa367c223cc0de145` |
| `_driving_view/top/group3/minitbt_padding_horizontal_right` | `2003:10004` | FLOAT | 20 | 18 | 17 | 0 | `342d486cf3c11203ed7e50da198bcc5b62210f35` |
| `_driving_view/top/group3/minitbt_radius_top_left` | `2003:10005` | FLOAT | 24; alias → radius/top_left/level7 @2003:8146 | 21; alias → radius/top_left/level7 @2003:8146 | 20; alias → radius/top_left/level7 @2003:8146 | 26; alias → radius/top_left/level7 @2003:8146 | `38037b9a3a36ff53d52c7120545be7c4b00c7708` |
| `_driving_view/top/group3/minitbt_radius_top_right` | `2003:10006` | FLOAT | 24; alias → radius/top_right/level7 @2003:9742 | 21; alias → radius/top_right/level7 @2003:9742 | 20; alias → radius/top_right/level7 @2003:9742 | 26; alias → radius/top_right/level7 @2003:9742 | `724acfa37ac3b50b7a6e2ae9369740961d36fe0f` |
| `_driving_view/top/group3/minitbt_radius_bottom_left` | `2003:10007` | FLOAT | 24; alias → radius/bottom_left/level7 @2003:9744 | 21; alias → radius/bottom_left/level7 @2003:9744 | 20; alias → radius/bottom_left/level7 @2003:9744 | 26; alias → radius/bottom_left/level7 @2003:9744 | `87098c4c567f191dd40b06fc28e5eb4e03835674` |
| `_driving_view/top/group3/minitbt_radius_bottom_right` | `2003:10008` | FLOAT | 24; alias → radius/bottom_right/level7 @2003:9746 | 21; alias → radius/bottom_right/level7 @2003:9746 | 20; alias → radius/bottom_right/level7 @2003:9746 | 26; alias → radius/bottom_right/level7 @2003:9746 | `be66448a4c1111062b7d98aa2aabdbfe729fc083` |
| `_driving_view/top/group3/minitbt_icon_square` | `2003:10009` | FLOAT | 80 | 70 | 66 | 0 | `f4407bdc24bff7241242c74f36af041af083de56` |
| `_driving_view/top/group3/minitbt_text_gap_vertical` | `2003:10013` | FLOAT | -4 | -3 | -3 | 0 | `fcb19e8576e9715e073f84de29aa254e2d1b4a4a` |
| `_driving_view/top/group3/minitbt_text_min_width` | `2003:10014` | FLOAT | 200 | 176 | 166 | 0 | `e7c5081b1c127776ce29eb785e72e29458ec734e` |
| `_driving_view/top/group3/minitbt_text_max_width` | `2003:10015` | FLOAT | 416 | 366 | 345 | 0 | `ea832bee17f403e353465f7ebd97e312abba7b33` |
| `_driving_view/top/mask_gradient_height` | `2003:10158` | FLOAT | 80 | 70 | 66 | 0 | `44a3b409d8035bc1e096cf9a424ae93f7555c995` |
| `_driving_view/bottom/padding_vertical_bottom` | `2003:10317` | FLOAT | 0 | 0 | 20 | 0 | `0765bdf2892dbb6d4cffe37cfdc99baddbad79ae` |
| `_driving_view/bottom/padding_horizontal` | `2003:10318` | FLOAT | 20 | 18 | 20 | 0 | `6bcb95957bfc9846d4e27ccbdd8c9e66be7f7a66` |
| `_driving_view/bottom/left_gap_vertical` | `2003:10319` | FLOAT | 12 | 11 | 10 | 0 | `3961422ce82bdad18104b239522ab6f34d13d726` |
| `_driving_view/bottom/regen_braking_width` | `2003:10320` | FLOAT | 92 | 81 | 76 | 0 | `d6191385b09410c89ca7074d0accb72d2b127e45` |
| `_driving_view/bottom/regen_braking_height` | `2003:10321` | FLOAT | 44 | 39 | 37 | 0 | `3de03214eafe8113bf33ed7406f5d19a31bb7af9` |
| `_driving_view/bottom/ipedal_padding_horizontal` | `2003:10445` | FLOAT | 8 | 7 | 7 | 0 | `c66e2f8cfc1c048f050349f96f19ab42e014129f` |
| `_driving_view/bottom/ipedal_radius_top_left` | `2003:10446` | FLOAT | 8; alias → radius/top_left/level3 @2003:9007 | 7; alias → radius/top_left/level3 @2003:9007 | 7; alias → radius/top_left/level3 @2003:9007 | 9; alias → radius/top_left/level3 @2003:9007 | `69d5bd07f5e40da3662da345a50bbbad50bc6758` |
| `_driving_view/bottom/ipedal_radius_top_right` | `2003:10447` | FLOAT | 8; alias → radius/top_right/level3 @2003:11227 | 7; alias → radius/top_right/level3 @2003:11227 | 8; alias → radius/top_right/level3 @2003:11227 | 8; alias → radius/top_right/level3 @2003:11227 | `fc9c84e7978355596da549ba04d5144179477f8a` |
| `_driving_view/bottom/ipedal_radius_bottom_left` | `2003:10448` | FLOAT | 8; alias → radius/bottom_left/level3 @2003:9011 | 7; alias → radius/bottom_left/level3 @2003:9011 | 7; alias → radius/bottom_left/level3 @2003:9011 | 9; alias → radius/bottom_left/level3 @2003:9011 | `50b36d7b9da9c5097d29aa2a985d2ed4e9726cbe` |
| `_driving_view/bottom/driving_mode_padding_horizontal` | `2003:10454` | FLOAT | 8 | 7 | 7 | 0 | `13dd7b68816c3844984b050a95c6799f35dec9fc` |
| `_driving_view/bottom/driving_mode_radius_top_left` | `2003:10455` | FLOAT | 8; alias → radius/top_left/level3 @2003:9007 | 7 | 7; alias → radius/top_left/level3 @2003:9007 | 9; alias → radius/top_left/level3 @2003:9007 | `a6d310f690e58f340fd94b2cdda00249b79b8a3e` |
| `_driving_view/bottom/driving_mode_radius_top_right` | `2003:10456` | FLOAT | 8; alias → radius/top_right/level3 @2003:11227 | 7 | 8; alias → radius/top_right/level3 @2003:11227 | 8; alias → radius/top_right/level3 @2003:11227 | `6b014483c5e3152bf80a1bebaacfb1c633fb1f9c` |
| `_driving_view/bottom/driving_mode_radius_bottom_left` | `2003:10457` | FLOAT | 8; alias → radius/bottom_left/level3 @2003:9011 | 7 | 7; alias → radius/bottom_left/level3 @2003:9011 | 9; alias → radius/bottom_left/level3 @2003:9011 | `962bf3c3ddf01dc21b2a373c38daedbac07b2816` |
| `_driving_view/bottom/driving_mode_radius_bottom_right` | `2003:10458` | FLOAT | 8; alias → radius/bottom_right/level3 @2003:11230 | 7 | 8; alias → radius/bottom_right/level3 @2003:11230 | 8; alias → radius/bottom_right/level3 @2003:11230 | `9b098af97777a402c4ca385a53ba0b16a6b72277` |
| `_driving_view/bottom/driving_mode_text_max_width` | `2003:10459` | FLOAT | 220 | 194 | 183 | 0 | `08e785815a4e4870c43bb8f7528ed0917d450b73` |
| `_driving_view/left/group1/speedgroup_gap_vertical` | `2003:10492` | FLOAT | -14 | -12 | -12 | 0 | `f53e6d8a2d157cc756f4ea70c280258226442d8b` |
| `_driving_view/left/group1/padding_horizontal_left` | `2003:10493` | FLOAT | 20 | 18 | 20 | 0 | `61e77b02e97a3790bf0a08dd0a2a87fc821dfdc4` |
| `_driving_view/left/group1/padding_vertical_top_systemcheck` | `2003:10494` | FLOAT | 8 | 8 | 12 | 0 | `0297c1ead250410bcc3c9bbda3dd454d330c8ea5` |
| `_driving_view/left/group2/doorlock_switch_container_height` | `2003:10498` | FLOAT | 80 | 70 | 66 | 0 | `64006cc64d8189123c130b48a280e81515407e3e` |
| `_driving_view/left/group2/doorlock_switch_padding_horizontal` | `2003:10499` | FLOAT | 8 | 7 | 7 | 0 | `57b2c3445cc81cc5abf918b414df6b0d3c5a31eb` |
| `_driving_view/left/group2/doorlock_switch_padding_vertical` | `2003:10500` | FLOAT | 8 | 7 | 7 | 0 | `8668c2f7878ec90f201c057edd70ad637a9a5ea1` |
| `_driving_view/left/group2/doorlock_switch_width` | `2003:10501` | FLOAT | 112 | 99 | 93 | 0 | `30ae4ec1b320322bcfa3605279c022f8e86e2f7b` |
| `_driving_view/left/group2/doorlock_switch_height` | `2003:10502` | FLOAT | 64 | 56 | 53 | 0 | `12ece1c17496976120c534be24180c91889830e1` |
| `_driving_view/left/group2/doorlock_switch_radius_top_left` | `2003:10503` | FLOAT | 999; alias → radius/top_left/max @2003:8320 | 999; alias → radius/top_left/max @2003:8320 | 999; alias → radius/top_left/max @2003:8320 | 999; alias → radius/top_left/max @2003:8320 | `c4c6f017c882c4c31a6dfcacd141207d908f0de9` |
| `_driving_view/left/group2/doorlock_switch_radius_top_right` | `2003:10504` | FLOAT | 999; alias → radius/top_right/max @2003:8322 | 999; alias → radius/top_right/max @2003:8322 | 999; alias → radius/top_right/max @2003:8322 | 999; alias → radius/top_right/max @2003:8322 | `16eda6790c28ba75843a28d5cdffa5a41df7cc61` |
| `_driving_view/left/group2/doorlock_switch_radius_bottom_left` | `2003:10505` | FLOAT | 999; alias → radius/bottom_left/max @2003:8324 | 999; alias → radius/bottom_left/max @2003:8324 | 999; alias → radius/bottom_left/max @2003:8324 | 999; alias → radius/bottom_left/max @2003:8324 | `03c7462348f2d0e0b3f7178befb09c324d01642d` |
| `_driving_view/left/group2/doorlock_switch_knob_width` | `2003:10511` | FLOAT | 56 | 49 | 46 | 0 | `ba39ce11a16cf51dc2222e19bc60cec5c833bae8` |
| `_driving_view/left/group2/doorlock_switch_knob_height` | `2003:10512` | FLOAT | 48 | 42 | 40 | 0 | `902356bb0315b44ed7fcc386f7f7870044e776ff` |
| `_driving_view/left/group2/doorlock_switch_knob_radius_top_left` | `2003:10513` | FLOAT | 999; alias → radius/top_left/max @2003:8320 | 999; alias → radius/top_left/max @2003:8320 | 999; alias → radius/top_left/max @2003:8320 | 999; alias → radius/top_left/max @2003:8320 | `e108a0ee80533448dd37761f1194e8079d782dec` |
| `_driving_view/left/group2/doorlock_switch_knob_radius_top_right` | `2003:10514` | FLOAT | 999; alias → radius/top_right/max @2003:8322 | 999; alias → radius/top_right/max @2003:8322 | 999; alias → radius/top_right/max @2003:8322 | 999; alias → radius/top_right/max @2003:8322 | `c036ebeca6e1633878f0c58047fa7d34848f6316` |
| `_driving_view/left/group2/doorlock_switch_knob_radius_bottom_left` | `2003:10515` | FLOAT | 999; alias → radius/bottom_right/max @2003:8326 | 999; alias → radius/bottom_right/max @2003:8326 | 999; alias → radius/bottom_right/max @2003:8326 | 999; alias → radius/bottom_right/max @2003:8326 | `13198968547170ffb748f69ebef74321a9c823f3` |
| `_driving_view/left/group2/doorlock_switch_knob_radius_bottom_right` | `2003:10516` | FLOAT | 999; alias → radius/bottom_left/max @2003:8324 | 999; alias → radius/bottom_left/max @2003:8324 | 999; alias → radius/bottom_left/max @2003:8324 | 999; alias → radius/bottom_left/max @2003:8324 | `f30c0f0d1580f62a9c4083b25632b933dfcf438d` |
| `_driving_view/left/group2/doorlock_switch_icon_square` | `2003:10533` | FLOAT | 32; alias → square/level6 @2003:7122 | 28; alias → square/level6 @2003:7122 | 27; alias → square/level6 @2003:7122 | 35; alias → square/level6 @2003:7122 | `8263852b03cabe9fe73c1ceaa9eb2597db0edf3d` |
| `_driving_view/left/group1/padding_vertical_top` | `2003:10553` | FLOAT | 4 | 4 | 3 | 0 | `01642ca630e049aa5fb8fbe7efbaeefab8637549` |
| `_driving_view/left/group1/speedometer_number_width` | `2003:10557` | FLOAT | 200 | 177 | 166 | 0 | `74b6c71ec37c25818be013745b274142bb04fed1` |
| `_driving_view/left/group1/speedometer_gap_vertical` | `2003:10558` | FLOAT | -16 | -14 | -13 | 0 | `eb7e9c2adbde4a6bb1a459b936c6ebdb697467cf` |
| `_driving_view/left/group1/speedometer_number_padding_left` | `2003:10559` | FLOAT | 8 | 7 | 7 | 0 | `b6eb050bd627ba39cfbb8d35bc1b77c05a58dcef` |
| `_driving_view/left/group1/mph_gap_horizontal` | `2003:10560` | FLOAT | 4 | 4 | 3 | 0 | `beb7b915694cb9b2c48cc6cf468521fbac6f382a` |
| `_driving_view/left/group1/mph_padding_vertical_top` | `2003:10561` | FLOAT | 22 | 20 | 18 | 0 | `485aac8cfdc80c2ed19098fc31fa8f45ba03eda8` |
| `_driving_view/left/group2/indicator_group_gap_vertical` | `2003:10566` | FLOAT | 16 | 14 | 13 | 0 | `f45afbf98d0bd4c923a9f7aa09a14f38f026cc5b` |
| `_driving_view/left/group2/padding_horizontal_left` | `2003:10567` | FLOAT | 16 | 14 | 16 | 0 | `180a9ca7b8b5fc28e09dbd144e34c78a7265a177` |
| `_driving_view/left/group2/padding_vertical_top` | `2003:10568` | FLOAT | 24 | 21 | 12 | 0 | `2ac59091aeeb22f7862e13ca5a5d5eeb65903680` |
| `_driving_view/left/group2/ad_indicator_gap_vertical` | `2003:10569` | FLOAT | -10 | -9 | -8 | 0 | `03d08ea4f483e5e787df6cb57bb56c7e155fb05f` |
| `_driving_view/left/group2/ad_indicator_square` | `2003:10571` | FLOAT | 100; alias → square/level22 @2003:10570 | 88; alias → square/level22 @2003:10570 | 83; alias → square/level22 @2003:10570 | 106; alias → square/level22 @2003:10570 | `f63960b5de1ce58f48223774d0dcfc15d4466428` |
| `_driving_view/left/group2/ad_indicator_icon_square` | `2003:10573` | FLOAT | 60; alias → square/level13 @2003:10572 | 53; alias → square/level13 @2003:10572 | 50; alias → square/level13 @2003:10572 | 64; alias → square/level13 @2003:10572 | `79b3d14b215c8e7c0cbcd080e1e5a30db9bececf` |
| `_driving_view/left/group2/ad_indicator_ready_width` | `2003:10574` | FLOAT | 46 | 40 | 38 | 0 | `f1aa56a3816d05526ffc80d8aef53555d7b26588` |
| `_driving_view/left/group2/ad_indicator_ready_height` | `2003:10575` | FLOAT | 60 | 46 | 50 | 0 | `93273c6fec9dfbdc46b9483ecc170ccc82f864b5` |
| `_driving_view/left/group2/ad_indicator_gap_horizontal` | `2003:10578` | FLOAT | 4 | 3 | 3 | 0 | `0c8a95d3b83c6cc87cfa4ada9db9223c07b74df6` |
| `_driving_view/left/group2/ad_indicator_auto_square` | `2003:10579` | FLOAT | 24 | 21 | 20 | 0 | `aaad3b6d8b4c2febb8a6e451adaa78288c3c7e11` |
| `_driving_view/left/group2/ad_indicator_auto_radius_top_left` | `2003:10581` | FLOAT | 4; alias → radius/top_left/level2 @2003:10580 | 4; alias → radius/top_left/level2 @2003:10580 | 4; alias → radius/top_left/level2 @2003:10580 | 4; alias → radius/top_left/level2 @2003:10580 | `f74d3fdf74ee33d93ac75f73a558dd4eee01d300` |
| `_driving_view/left/group2/ad_indicator_auto_radius_top_right` | `2003:10583` | FLOAT | 4; alias → radius/top_right/level2 @2003:10582 | 4; alias → radius/top_right/level2 @2003:10582 | 4; alias → radius/top_right/level2 @2003:10582 | 4; alias → radius/top_right/level2 @2003:10582 | `4bc4be4b2e264160752ebd20ef0c15befafb9bf8` |
| `_driving_view/left/group2/ad_indicator_auto_radius_bottom_left` | `2003:10585` | FLOAT | 4; alias → radius/bottom_left/level2 @2003:10584 | 4; alias → radius/bottom_left/level2 @2003:10584 | 4; alias → radius/bottom_left/level2 @2003:10584 | 4; alias → radius/bottom_left/level2 @2003:10584 | `7b9c75f67852aaf9249860e60c148e4c8999e895` |
| `_driving_view/left/group2/ad_indicator_auto_radius_bottom_right` | `2003:10587` | FLOAT | 4; alias → radius/bottom_right/level2 @2003:10586 | 4; alias → radius/bottom_right/level2 @2003:10586 | 4; alias → radius/bottom_right/level2 @2003:10586 | 4; alias → radius/bottom_right/level2 @2003:10586 | `bd3e3edf66a7b741331260c998dbac02fccd8a09` |
| `_driving_view/left/group2/ad_indicator_autopark_p_padding_horizontal_left` | `2003:10588` | FLOAT | 28 | 25 | 23 | 0 | `3f90a894d46e6490274037357fdc5a166cd026f2` |
| `_driving_view/left/group2/ad_indicator_autopark_p_padding_vertical_top` | `2003:10589` | FLOAT | 23 | 20 | 19 | 0 | `4ee756a299ec08b3ed15514e513ac2138d6a3707` |
| `_driving_view/left/group2/ad_indicator_autopark_p_square` | `2003:10590` | FLOAT | 32; alias → square/level6 @2003:7122 | 28; alias → square/level6 @2003:7122 | 27; alias → square/level6 @2003:7122 | 0 | `f39708d9fbb2479c71420ed705678cad571981cd` |
| `_driving_view/left/group2/sign1_group_vertical_gap` | `2003:10615` | FLOAT | -24 | -21 | -20 | 0 | `9026876ae8bf73a2058ff38dadaa77f35c81be31` |
| `_driving_view/left/group2/sign_current_gap_vertical` | `2003:10616` | FLOAT | -10 | -9 | -8 | 0 | `e34316b912b95ee74f87eb1598e517375f31bb32` |
| `_driving_view/left/group2/sign_current_square` | `2003:10617` | FLOAT | 100 | 88 | 83 | 0 | `635692ede379408c0c8b05eb6dda9db12b8cca13` |
| `_driving_view/left/group2/sign_current_number_only_padding_top` | `2003:10618` | FLOAT | 26 | 23 | 22 | 0 | `ee26fd41d1a9a9bc97dcba4631772d561088f4ef` |
| `_driving_view/left/group2/sign_current_number_with_sub_padding_top` | `2003:10621` | FLOAT | 33 | 29 | 26 | 0 | `e4e0133dfdbbbfeeaafa9dcb7e7188a52502d649` |
| `_driving_view/left/group2/sign_next_square` | `2003:10629` | FLOAT | 72; alias → square/level16 @2003:10628 | 63; alias → square/level16 @2003:10628 | 60; alias → square/level16 @2003:10628 | 77; alias → square/level16 @2003:10628 | `aac178bf4761142fed2f72115339f4df4b03b2f3` |
| `_driving_view/left/group2/sign1_mask_height` | `2003:10630` | FLOAT | 40 | 35 | 33 | 0 | `cd80cab0fe56752c5f11bf23895a7e348915ff5f` |
| `_driving_view/left/group2/sign_current_camera_width` | `2003:11221` | FLOAT | 48 | 42 | 40 | 0 | `8b81dd7fd756c2cc5653279ba98e3f6369157dae` |
| `_driving_view/left/group2/sign_current_camera_height` | `2003:11222` | FLOAT | 24 | 21 | 20 | 0 | `1ceb07bb67d7a6ba64599d7b26a0eb77e93539db` |
| `_driving_view/left/group2/sign_current_distance_width` | `2003:11223` | FLOAT | 108 | 95 | 90 | 0 | `7b75e388fcbadb4bf5f0e331979bd3d32c414736` |
| `_driving_view/left/group2/sign_current_distance_height` | `2003:11224` | FLOAT | 52 | 46 | 43 | 0 | `62653d6ee32a06870f6af3873d3d1958690fd93b` |
| `_driving_view/left/group2/sign_current_distance_padding_vertical` | `2003:11225` | FLOAT | 7 | 6 | 5 | 0 | `d6f000ad38a9bc337fbee766bf47301fcc36c80a` |
| `_driving_view/left/group2/sign_current_distance_radius_top_left` | `2003:11226` | FLOAT | 8; alias → radius/top_left/level3 @2003:9007 | 7; alias → radius/top_left/level3 @2003:9007 | 7; alias → radius/top_left/level3 @2003:9007 | 0 | `2cc9760789f06eab0c4a189d5b362c2fd2358727` |
| `_driving_view/left/group2/sign_current_distance_radius_top_right` | `2003:11228` | FLOAT | 8; alias → radius/top_right/level3 @2003:11227 | 7; alias → radius/top_right/level3 @2003:11227 | 8; alias → radius/top_right/level3 @2003:11227 | 0 | `57621eacdf1cbe0b4935b4698f85b0b2a0b6898b` |
| `_driving_view/left/group2/sign_current_distance_radius_bottom_left` | `2003:11229` | FLOAT | 8; alias → radius/bottom_left/level3 @2003:9011 | 7; alias → radius/bottom_left/level3 @2003:9011 | 8; alias → radius/bottom_right/level3 @2003:11230 | 0 | `6f2768a2d9d83abf8dec0e8e21adbba0b7145dc2` |
| `_driving_view/left/group2/sign_current_distance_radius_bottom_right` | `2003:11231` | FLOAT | 8; alias → radius/bottom_right/level3 @2003:11230 | 7; alias → radius/bottom_right/level3 @2003:11230 | 8; alias → radius/bottom_right/level3 @2003:11230 | 0 | `96eafdd3bdf2b497036cb1a04c093a53da98b2e8` |
| `_driving_view/left/group2/sign_current_distance_average_speed_padding_horizontal` | `2003:11232` | FLOAT | 4 | 3 | 3 | 0 | `f248ecdc4a936818c87ca66ca3edd57e07462dfe` |
| `_driving_view/left/group2/sign_current_distance_average_speed_padding_vertical` | `2003:11233` | FLOAT | 12 | 11 | 10 | 0 | `16e764674d9784a8d926d8af42380322c5a71e83` |
| `_driving_view/left/group1/gap_vertical` | `2003:11566` | FLOAT | -4 | -8 | -8 | 0 | `754b9cef34fb6a92fa5084d24d6fc9cbd15f3d80` |
| `_driving_view/left/group1/rpm_padding_vertical_top` | `2003:11567` | FLOAT | 22 | 19 | 25 | 0 | `bb69c276e4593f02fb273e06c06a04df04089501` |
| `_driving_view/3dview/vehicle_control_padding_vertical_top` | `2003:11643` | FLOAT | 434 | 352 | 100 | 0 | `a7718fcf42d0ee69485668aa00f076d237db6ac5` |
| `_driving_view/3dview/vehicle_control_height` | `2003:11644` | FLOAT | 600 | 449 | 743 | 0 | `d3e33a3644862c093a48d8d405fd0c0d9f0c2c04` |
| `_driving_view/3dview/vehicle_control_[U+0008]ring_padding_top` | `2003:11645` | FLOAT | 296 | 222 | 368 | 0 | `000d6ed7666e7958d113a7256bcee8467ec3219b` |
| `_driving_view/3dview/vehicle_control_width` | `2003:11646` | FLOAT | 840 | 628 | 1040 | 0 | `a432a80e7c7fb810b97263fe48bd43246e5a3b62` |
| `_driving_view/3dview/parked_ring_line` | `2003:11647` | FLOAT | 6 | 5 | 8 | 5; alias → line/level5 @2003:7056 | `10ed25dfaa537028b21e81c9bccb3a913e8d7523` |
| `_driving_view/3dview/vehicle_control_[U+0008]ring_width` | `2003:11648` | FLOAT | 640 | 478 | 792 | 0 | `afbbe49ba90a6042f5668a0707ea20f1884f15bf` |
| `_driving_view/3dview/vehicle_control_[U+0008]ring_height` | `2003:11649` | FLOAT | 204 | 152 | 252 | 0 | `b5ff65b6755c13d44f5d2d4d0063b08e4090e7b1` |
| `_driving_view/3dview/vehicle_control_frontquater_sidemirror_padding_left` | `2003:11716` | FLOAT | 420 | 314 | 530 | 0 | `f2196b5babbf5b19a3be1f35f1dc46e6206e15a9` |
| `_driving_view/3dview/vehicle_control_frontquater_sidemirror_padding_top` | `2003:11717` | FLOAT | 456 | 330 | 540 | 0 | `a03291beaa3e2c167f8a6a030f833f294382cf9a` |
| `_driving_view/3dview/vehicle_control_gap_horizontal` | `2003:11718` | FLOAT | 16 | 14 | 13 | 0 | `a0a2afc5e6ee35ee1e7cbf5ec88a6106c8fd3b2a` |
| `_driving_view/3dview/vehicle_control_icon_square` | `2003:11720` | FLOAT | 36; alias → square/level7 @2003:11719 | 28; alias → square/level7 @2003:11719 | 30; alias → square/level7 @2003:11719 | 41; alias → square/level7 @2003:11719 | `51d58ec19c3fc8fb5d2b8bd946422a5f2294830b` |
| `_driving_view/3dview/vehicle_control_frontquater_trunk_padding_left` | `2003:11751` | FLOAT | 648 | 480 | 796 | 0 | `bafbf7c2f2de55a9f1ddba25238111c1a544fb1e` |
| `_driving_view/3dview/vehicle_control_frontquater_trunk_padding_top` | `2003:11752` | FLOAT | 224 | 164 | 296 | 0 | `e8e6993cf406ad233f14be66768f43877f75c5b1` |
| `_driving_view/3dview/vehicle_control_frontquater_frunk_padding_left` | `2003:11753` | FLOAT | 180 | 132 | 224 | 0 | `92b86d4443b9651ae6e29975751b48703a141d9f` |
| `_driving_view/3dview/vehicle_control_frontquater_frunk_padding_top` | `2003:11754` | FLOAT | 264 | 196 | 352 | 0 | `8fa78a1955f1d26b797a937fbf143ec99dd34814` |
| `_driving_view/3dview/vehicle_control_frontquater_charging_port_padding_left` | `2003:11755` | FLOAT | 384 | 286 | 500 | 0 | `a657a7e5dde6c20418fccec214a1701bddff5574` |
| `_driving_view/3dview/vehicle_control_frontquater_charging_port_padding_top` | `2003:11756` | FLOAT | 160 | 116 | 220 | 0 | `46bbb09c6e12264bc71556fe3abb5e9a8c73c895` |
| `_driving_view/3dview/vehicle_control_rearquater_charging_port_padding_left` | `2003:11757` | FLOAT | 342 | 254 | 436 | 0 | `66a128d31919f73257355b7ea3578297ab7c80de` |
| `_driving_view/3dview/vehicle_control_rearquater_charging_port_padding_top` | `2003:11758` | FLOAT | 456 | 342 | 572 | 0 | `7deab25b806a94340887991e11943d897ac1ca00` |
| `_driving_view/3dview/vehicle_control_rearquater_frunk_padding_left` | `2003:11759` | FLOAT | 648 | 480 | 796 | 0 | `4be60f417be262aa39ba4c93f8033a62b22f1b98` |
| `_driving_view/3dview/vehicle_control_rearquater_frunk_padding_top` | `2003:11760` | FLOAT | 240 | 180 | 314 | 0 | `ab94c3e564b151916749fb7981a338bea86ef0ab` |
| `_driving_view/3dview/vehicle_control_rearquater_trunk_padding_left` | `2003:11761` | FLOAT | 180 | 132 | 224 | 0 | `26102b758d685c74090d0aa44fd251447d6e0720` |
| `_driving_view/3dview/vehicle_control_rearquater_trunk_padding_top` | `2003:11762` | FLOAT | 264 | 196 | 352 | 0 | `88802735c639335fabc8bbbf09a56b55bb2ba8ba` |
| `_driving_view/3dview/vehicle_controlr_rearquater_sidemirror_padding_left` | `2003:11763` | FLOAT | 420 | 314 | 530 | 0 | `ff518b80d11c570ad609b57fb65c58ed0cce158c` |
| `_driving_view/3dview/vehicle_control_rearquater_sidemirror_padding_top` | `2003:11764` | FLOAT | 160 | 116 | 220 | 0 | `0336184fdfad2e2f1808458de5d9a7ed236fee49` |
| `_driving_view/left/group1/gap_vertical` | `2003:12651` | FLOAT | -14 | -12 | -12 | 0 | `f53e6d8a2d157cc756f4ea70c280258226442d8b` |
| `_driving_view/left/group2/padding_vertical_top` | `2003:12697` | FLOAT | 24 | 21 | 20 | 0 | `2ac59091aeeb22f7862e13ca5a5d5eeb65903680` |
| `_driving_view/left/group2/ad_indicator_gap_vertical` | `2003:12698` | FLOAT | -10 | -9 | -8 | -7 | `03d08ea4f483e5e787df6cb57bb56c7e155fb05f` |
| `_driving_view/left/group2/ad_indicator_auto_height` | `2003:13182` | FLOAT | 24 | 21 | 20 | 0 | `aaad3b6d8b4c2febb8a6e451adaa78288c3c7e11` |
| `_driving_view/left/group1/rpm_padding_vertical_top` | `2003:14132` | FLOAT | 22 | 19 | 17 | 0 | `bb69c276e4593f02fb273e06c06a04df04089501` |

## language_units — 2003:12695

- collection key: `c47d1788f53837b66e6b75e8942544d1b5db6144`
- 모드 식별자: `Unit 1=22883:0`, `Unit 2=22883:1`

| Token | ID | Type | Unit 1 | Unit 2 | Key |
| --- | --- | --- | --- | --- | --- |
| `KM/Speed 2` | `2003:10565` | STRING | {"textValue":"MPH"} | {"textValue":"KM/H"} | `354ff60ad2c39f533fc9178acdf03aaa257c8613` |
| `KM/Speed 2` | `2003:12696` | STRING | {"textValue":"MPH"} | {"textValue":"KM/H"} | `354ff60ad2c39f533fc9178acdf03aaa257c8613` |

## Number — 2003:11982

- collection key: `60241c1e1396529afe95b81b9c5162329493edab`
- 모드 식별자: `Mode 1=11493:8`

| Token | ID | Type | Mode 1 | Key |
| --- | --- | --- | --- | --- |
| `Spacing/0` | `2003:11983` | FLOAT | 0 | `adb976edbe2b8cb64e3e3f9d0e99984d894cf8fa` |
| `Radius/xs` | `2003:12065` | FLOAT | 0 | `8b1343a7187bde96da5103590484d1d3a58c28d6` |
| `Radius/l` | `2003:14860` | FLOAT | 24 | `45e806eb4249c434832a07383662f7c70d0c9117` |
| `Common/8` | `2003:14940` | FLOAT | 8 | `61a0548c0156aec1101f705d0c70a7394db16c09` |
| `Radius/m` | `2003:14941` | FLOAT | 16 | `1b67c85491e5171e47236b6915f264c39501b09b` |

## gleo.sys.color — 2003:12172

- collection key: `faa653ec6d75ba16fc25998f139118e0e5abb9c6`
- 모드 식별자: `Mode 1=38763:0`

| Token | ID | Type | Mode 1 | Key |
| --- | --- | --- | --- | --- |
| `gleo_blue` | `2003:12173` | COLOR | #596BFFFF | `4799f1b0b68721ceefce7514ca8c325725f829fb` |

## Color0 — 2003:15182

- collection key: `49c4e464ca57831b13efa6ac7031873687f36bf4`
- 모드 식별자: `Light=11229:5`, `Dark=11486:7`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `Icon/gray-tertiary` | `2003:15183` | COLOR | #131417A3 | #FFFFFFA3 | `cb36077dab87b9631a5f951780702604e9a80e72` |

## typo — 2003:41233

- collection key: `48b778430202a82b20d66144775b6f749088a640`
- 모드 식별자: `connect-s=32090:0`, `connect-l=32259:1`, `connect-w=33219:2`, `connect-waterfall=33235:1`

| Token | ID | Type | connect-s | connect-l | connect-w | connect-waterfall | Key |
| --- | --- | --- | --- | --- | --- | --- | --- |
| `size_sp/level20` | `2003:46336` | FLOAT | 112 | 99 | 130 | 119 | `a08e52b4829ae90d6d04305228e93dd2ccf091bf` |
| `line_height_sp/level20` | `2003:46337` | FLOAT | 134 | 118 | 156 | 142 | `046b440010f580495e6b61a283df89f7363ca211` |
| `size_sp/level17` | `2003:46342` | FLOAT | 56 | 49 | 46 | 59 | `550698bba249487c1582a76a20530de9742183d1` |
| `line_height_sp/level17` | `2003:46343` | FLOAT | 72 | 65 | 60 | 77 | `1fd6c78fabc3c27c39a00e6869208a7ef83fa17e` |

## Color — 2003:46332

- collection key: `b11af6e89cb5471aa9036a1917b629e2a971c8e8`
- 모드 식별자: `Light=11229:5`, `Dark=11486:7`

| Token | ID | Type | Light | Dark | Key |
| --- | --- | --- | --- | --- | --- |
| `static/dark/100` | `2003:46339` | COLOR | #131417FF | #131417FF | `a051d50aaefd370b1cc32b463b6259e820acd419` |
| `static/light/100` | `2003:46340` | COLOR | #FFFFFFFF | #FFFFFFFF | `920d75210ad21f5a680599bfdbfff8e2fadfc784` |
| `text/dark/primary` | `2003:46341` | COLOR | #131417FF; alias → static/dark/100 @2003:46339 | #FFFFFFFF; alias → static/light/100 @2003:46340 | `8213605bc9f4c04f55b494b748c7de4a32a298a4` |
| `static/dark/400` | `2003:46345` | COLOR | #13141752 | #13141752 | `fe04e1eb348e739a850030114fb9a78fa5afb7be` |
| `static/light/400` | `2003:46346` | COLOR | #FFFFFF52 | #FFFFFF52 | `e93c86aeff4aa73cccf2ed3920f77f49cb7f0969` |
| `text/dark/quaternary` | `2003:46347` | COLOR | #13141752; alias → static/dark/400 @2003:46345 | #FFFFFF52; alias → static/light/400 @2003:46346 | `df9ec4aa9d3431c95a39cf8870dbc744004f88b7` |

## brand — 2003:58657

- collection key: `ece444b524a12d6c6998abe63e56ad67b4330270`
- 모드 식별자: `hyundai=48511:0`, `kia=48511:1`, `genesis=48511:2`

| Token | ID | Type | hyundai | kia | genesis | Key |
| --- | --- | --- | --- | --- | --- | --- |
| `ivi_font/text` | `2003:58658` | STRING | {"textValue":"HyundaiSansUI_JP_KR_Latin"} | {"textValue":"KiaSignatureUI_JP_KR_Latin"} | {"textValue":"GenesisSansUI_JP_KR_Latin"} | `8cccf5dc8d2b81c6233c846151fc4a30b5b94a9c` |

## theme — 2203:11151

- collection key: `6d660e8fa4ef722fae55ce0dde0bb1f59ffa1f7d`
- 모드 식별자: `Hyundai-Light=100286:0`, `Hyundai-Dark=100286:1`, `Kia-Light=100286:2`, `Kia-Dark=100286:3`, `Genesis-Light=100286:4`, `Genesis-Dark=100286:5`

| Token | ID | Type | Hyundai-Light | Hyundai-Dark | Kia-Light | Kia-Dark | Genesis-Light | Genesis-Dark | Key |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `color/basic/50` | `2203:11152` | COLOR | #F7F8FAFF | #1D1E21FF | #F7F8FAFF | #1D1E21FF | #F7F8FAFF | #1D1E21FF | `e346381b92df5ed35492489db7c113d0e9f8ab79` |
| `driving_view/cid/background_wide` | `2203:11153` | COLOR | #F7F8FAFF; alias → color/basic/50 @2203:11152 | #1D1E21FF; alias → color/basic/50 @2203:11152 | #F7F8FAFF; alias → color/basic/50 @2203:11152 | #1D1E21FF; alias → color/basic/50 @2203:11152 | #F6F8FAFF | #000000FF | `e5537318b8387059601c39fb247a5e0452a2b7bf` |
| `color/alpha/dark/100` | `2203:11158` | COLOR | #1314171A | #FFFFFF1A | #1314171A | #FFFFFF1A | #1314171A | #FFFFFF1A | `d7be767e973b8912aa31e936dec15671b72570a6` |
| `color/gnb/pressed` | `2203:11159` | COLOR | #1314171A; alias → color/alpha/dark/100 @2203:11158 | #FFFFFF1A; alias → color/alpha/dark/100 @2203:11158 | #1314171A; alias → color/alpha/dark/100 @2203:11158 | #FFFFFF1A; alias → color/alpha/dark/100 @2203:11158 | #1314171A; alias → color/alpha/dark/100 @2203:11158 | #FFFFFF1A; alias → color/alpha/dark/100 @2203:11158 | `90f58165dd1099dab661b988a3d54d915f2f0ad9` |
| `color/static/dark/100` | `2203:11162` | COLOR | #131417FF | #131417FF | #131417FF | #131417FF | #131417FF | #131417FF | `4559751f753dcaa8639ba50c4f7a4d5b60aa081c` |
| `color/static/light/100` | `2203:11163` | COLOR | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | `33d7d8d698574e5a34225acdd0f6488aed90af39` |
| `color/icon/dark/primary` | `2203:11164` | COLOR | #131417FF; alias → color/static/dark/100 @2203:11162 | #FFFFFFFF; alias → color/static/light/100 @2203:11163 | #131417FF; alias → color/static/dark/100 @2203:11162 | #FFFFFFFF; alias → color/static/light/100 @2203:11163 | #131417FF; alias → color/static/dark/100 @2203:11162 | #FFFFFFFF; alias → color/static/light/100 @2203:11163 | `a54da1159e00f7bad315dcb026440604b52e612e` |
| `color_hmc/stroke/focused` | `2203:11171` | COLOR | #6ABFFBFF | #6ABFFBFF | #6ABFFBFF | #6ABFFBFF | #6ABFFBFF | #6ABFFBFF | `f1acb7cc0a1000b4c6d6a0d2282beeb86ba23f10` |
| `color_hmc/stroke/focused_pressed` | `2203:11173` | COLOR | #0794F8FF | #0794F8FF | #0794F8FF | #0794F8FF | #0794F8FF | #0794F8FF | `c8f62e2cec2574dac843ca9b7867f2d2aafb5334` |
| `color/basic/700` | `2203:11174` | COLOR | #313236FF | #EDEEF2FF | #313236FF | #EDEEF2FF | #313236FF | #EDEEF2FF | `1dcf9ea942b99ef65cb3fb0e889547d7742f1f13` |
| `color/basic/500` | `2203:11175` | COLOR | #686A72FF | #C7C9CEFF | #686A72FF | #C7C9CEFF | #686A72FF | #C7C9CEFF | `7d42d28b102d5b40811e92ce8e7e4f3572dd1949` |
| `color/button/filled/pressed` | `2203:11176` | COLOR | #313236FF; alias → color/basic/700 @2203:11174 | #C7C9CEFF; alias → color/basic/500 @2203:11175 | #313236FF; alias → color/basic/700 @2203:11174 | #C7C9CEFF; alias → color/basic/500 @2203:11175 | #313236FF; alias → color/basic/700 @2203:11174 | #C7C9CEFF; alias → color/basic/500 @2203:11175 | `eb6043ac3987b0215de9e54d6df032ae5cde1c37` |
| `color/text/dark/primary` | `2203:11182` | COLOR | #131417FF; alias → color/static/dark/100 @2203:11162 | #FFFFFFFF; alias → color/static/light/100 @2203:11163 | #131417FF; alias → color/static/dark/100 @2203:11162 | #FFFFFFFF; alias → color/static/light/100 @2203:11163 | #131417FF; alias → color/static/dark/100 @2203:11162 | #FFFFFFFF; alias → color/static/light/100 @2203:11163 | `34980a0738eb99526a15daae3a8330b60229b261` |
| `color/static/dark/400` | `2203:11193` | COLOR | #13141752 | #13141752 | #13141752 | #13141752 | #13141752 | #13141752 | `b0eb85ed34761ae69c008b11e888114f65ceccfb` |
| `color/static/light/400` | `2203:11194` | COLOR | #FFFFFF52 | #FFFFFF52 | #FFFFFF52 | #FFFFFF52 | #FFFFFF52 | #FFFFFF52 | `bd71c29d5a2e16972a5040893e20281eb2f8ef50` |
| `color/text/dark/quaternary` | `2203:11195` | COLOR | #13141752; alias → color/static/dark/400 @2203:11193 | #FFFFFF52; alias → color/static/light/400 @2203:11194 | #13141752; alias → color/static/dark/400 @2203:11193 | #FFFFFF52; alias → color/static/light/400 @2203:11194 | #13141752; alias → color/static/dark/400 @2203:11193 | #FFFFFF52; alias → color/static/light/400 @2203:11194 | `b59b799c2b1bf2fed9b2cc055b9fdcace6b1939f` |
| `color/static/dark/300` | `2203:11218` | COLOR | #131417A3 | #131417A3 | #131417A3 | #131417A3 | #131417A3 | #131417A3 | `13d243c01afeaa9523802e8e479744c5d935944f` |
| `color_hmc/theme` | `2203:11229` | STRING | {"textValue":"Hyundai"} | {"textValue":"Hyundai"} | {"textValue":"Kia"} | {"textValue":"Kia"} | {"textValue":"Genesis"} | {"textValue":"Genesis"} | `85c4cb0c55f3c872d1465c27dd609db6e64b707c` |
| `color_hmc/shadow/alpha_2` | `2203:11233` | COLOR | #00000029 | #00000029 | #00000029 | #00000029 | #00000029 | #00000029 | `183a2f46512d2dee5331d4182f3ca54d01ed8faa` |
| `color_hmc/shadow/alpha_1` | `2203:11234` | COLOR | #00000014 | #00000014 | #00000014 | #00000014 | #00000014 | #00000014 | `8ac74e7bd07a8b4c885e296a7cac8bf881aea466` |
| `color/alpha/dark/200` | `2203:11235` | COLOR | #13141733 | #FFFFFF33 | #13141733 | #FFFFFF33 | #13141733 | #FFFFFF33 | `ae49ad2eaa75e1c643738b25ad6e274e93341bb8` |
| `color/divider/secondary` | `2203:11236` | COLOR | #13141733; alias → color/alpha/dark/200 @2203:11235 | #FFFFFF33; alias → color/alpha/dark/200 @2203:11235 | #13141733; alias → color/alpha/dark/200 @2203:11235 | #FFFFFF33; alias → color/alpha/dark/200 @2203:11235 | #13141733; alias → color/alpha/dark/200 @2203:11235 | #FFFFFF33; alias → color/alpha/dark/200 @2203:11235 | `ca095cbd89ea0cc21d8cbe4aa7f36f1faebd1a1c` |
| `color/static/light/300` | `2203:11784` | COLOR | #FFFFFFA3 | #FFFFFFA3 | #FFFFFFA3 | #FFFFFFA3 | #FFFFFFA3 | #FFFFFFA3 | `db930a7bb642924d2e472b00a63ee77d244e0372` |
| `color/icon/dark/tertiary` | `2203:11785` | COLOR | #131417A3; alias → color/static/dark/300 @2203:11218 | #FFFFFFA3; alias → color/static/light/300 @2203:11784 | #131417A3; alias → color/static/dark/300 @2203:11218 | #FFFFFFA3; alias → color/static/light/300 @2203:11784 | #131417A3; alias → color/static/dark/300 @2203:11218 | #FFFFFFA3; alias → color/static/light/300 @2203:11784 | `acade426ce5ed57e8ebae7c0ae679df3e4f0fe27` |
| `color/alpha/dark/400` | `2203:11899` | COLOR | #13141766 | #FFFFFF66 | #13141766 | #FFFFFF66 | #13141766 | #FFFFFF66 | `7268f9d4a8bbc851e6135d4efc324905af18b0db` |
| `color/basic/00` | `2203:11900` | COLOR | #FFFFFFFF | #131417FF | #FFFFFFFF | #131417FF | #FFFFFFFF | #131417FF | `5c4c0d142aec9654688bf303824a58b63a6ef05f` |
| `color/basic/100` | `2203:11901` | COLOR | #EDEEF2FF | #313236FF | #EDEEF2FF | #313236FF | #EDEEF2FF | #313236FF | `eaaca94ca80a38a17ea8d515d9b35b4cfa5adef8` |
| `color/background/wide_s2` | `2203:11905` | COLOR | #F7F8FAFF; alias → color/basic/50 @2203:11152 | #1D1E21FF; alias → color/basic/50 @2203:11152 | #F7F8FAFF; alias → color/basic/50 @2203:11152 | #1D1E21FF; alias → color/basic/50 @2203:11152 | #EDEDF1FF | #151515FF | `74425a49b44c13638192f3b5cac5d91d2020d216` |
| `color_hmc/various/green_3` | `2203:11915` | COLOR | #00BA13FF | #00BA13FF | #00BA13FF | #00BA13FF | #00BA13FF | #00BA13FF | `4ff137678a5523d0d7ba961ff10a2f102c8e3143` |
| `color_hmc/various/green_5` | `2203:11916` | COLOR | #0EE87EFF | #0EE87EFF | #0EE87EFF | #0EE87EFF | #0EE87EFF | #0EE87EFF | `78ae39d26eca1ce70e52c4e5f94ad58fcf717e88` |
| `color/informative/active` | `2203:11917` | COLOR | #00BA13FF; alias → color_hmc/various/green_3 @2203:11915 | #0EE87EFF; alias → color_hmc/various/green_5 @2203:11916 | #00BA13FF; alias → color_hmc/various/green_3 @2203:11915 | #0EE87EFF; alias → color_hmc/various/green_5 @2203:11916 | #00BA13FF; alias → color_hmc/various/green_3 @2203:11915 | #0EE87EFF; alias → color_hmc/various/green_5 @2203:11916 | `98cc1fcd47752118f735f416b3acb1974c346429` |
| `color_hmc/various/orange_3` | `2203:11920` | COLOR | #FFA202FF | #FFA202FF | #FFA202FF | #FFA202FF | #FFA202FF | #FFA202FF | `c8001411ab1eadcf9c4e4dda780313e96120fa5b` |
| `color/informative/error` | `2203:11921` | COLOR | #FFA202FF; alias → color_hmc/various/orange_3 @2203:11920 | #FFA202FF; alias → color_hmc/various/orange_3 @2203:11920 | #FFA202FF; alias → color_hmc/various/orange_3 @2203:11920 | #FFA202FF; alias → color_hmc/various/orange_3 @2203:11920 | #FFA202FF; alias → color_hmc/various/orange_3 @2203:11920 | #FFA202FF; alias → color_hmc/various/orange_3 @2203:11920 | `b7b298d76530c9f6892cd6764477f026646e5e13` |
| `color/regulation/green` | `2203:11926` | COLOR | #00BA13FF; alias → color_hmc/various/green_3 @2203:11915 | #00BA13FF; alias → color_hmc/various/green_3 @2203:11915 | #00BA13FF; alias → color_hmc/various/green_3 @2203:11915 | #00BA13FF; alias → color_hmc/various/green_3 @2203:11915 | #00BA13FF; alias → color_hmc/various/green_3 @2203:11915 | #00BA13FF; alias → color_hmc/various/green_3 @2203:11915 | `f8b885b88d9a29cfc5af270d6df14f34728fd4b7` |
| `color_hmc/various/blue_2` | `2203:11933` | COLOR | #297FFFFF | #297FFFFF | #297FFFFF | #297FFFFF | #297FFFFF | #297FFFFF | `8434b5ba10f719a500f7474e7629dc911abb041c` |
| `color/regulation/bluetooth` | `2203:11934` | COLOR | #297FFFFF; alias → color_hmc/various/blue_2 @2203:11933 | #297FFFFF; alias → color_hmc/various/blue_2 @2203:11933 | #297FFFFF; alias → color_hmc/various/blue_2 @2203:11933 | #297FFFFF; alias → color_hmc/various/blue_2 @2203:11933 | #297FFFFF; alias → color_hmc/various/blue_2 @2203:11933 | #297FFFFF; alias → color_hmc/various/blue_2 @2203:11933 | `d5273fc21865fb25c300d38b155af4841770fe07` |
| `color_hmc/various/blue_1` | `2203:11941` | COLOR | #0064FFFF | #0064FFFF | #0064FFFF | #0064FFFF | #0064FFFF | #0064FFFF | `b293acded9969f33fd8c35151b6a59a900077e37` |
| `color/informative/positive` | `2203:11942` | COLOR | #0064FFFF; alias → color_hmc/various/blue_1 @2203:11941 | #297FFFFF; alias → color_hmc/various/blue_2 @2203:11933 | #0064FFFF; alias → color_hmc/various/blue_1 @2203:11941 | #297FFFFF; alias → color_hmc/various/blue_2 @2203:11933 | #0064FFFF; alias → color_hmc/various/blue_1 @2203:11941 | #297FFFFF; alias → color_hmc/various/blue_2 @2203:11933 | `8d13c2eb1459369f67202108951910098dc806a1` |
| `color/basic/300` | `2203:11953` | COLOR | #C7C9CEFF | #686A72FF | #C7C9CEFF | #686A72FF | #C7C9CEFF | #686A72FF | `7748730dca2e13fbf0612d75686a19725e0e4a5f` |
| `color_hmc/various/red_1` | `2203:12244` | COLOR | #FE3D16FF | #FE3D16FF | #FE3D16FF | #FE3D16FF | #FE3D16FF | #FE3D16FF | `f2d1d3914b26e9b16f82461f8e1569bd1d4877e2` |
| `color_hmc/various/red_5` | `2203:12245` | COLOR | #F24239FF | #F24239FF | #F24239FF | #F24239FF | #F24239FF | #F24239FF | `c6be3fe8f9f36b7b59a6bab73afa38c8efa18264` |
| `color/informative/negative` | `2203:12246` | COLOR | #FE3D16FF; alias → color_hmc/various/red_1 @2203:12244 | #F24239FF; alias → color_hmc/various/red_5 @2203:12245 | #FE3D16FF; alias → color_hmc/various/red_1 @2203:12244 | #F24239FF; alias → color_hmc/various/red_5 @2203:12245 | #FE3D16FF; alias → color_hmc/various/red_1 @2203:12244 | #F24239FF; alias → color_hmc/various/red_5 @2203:12245 | `1fa4f4e070dae6d0681ed809e2ea857e628dce97` |
| `color_hmc/container_positive/pressed` | `2203:12248` | COLOR | #13141733; alias → color/alpha/dark/200 @2203:11235 | #FFFFFF33; alias → color/alpha/dark/200 @2203:11235 | #13141733; alias → color/alpha/dark/200 @2203:11235 | #FFFFFF33; alias → color/alpha/dark/200 @2203:11235 | #13141733; alias → color/alpha/dark/200 @2203:11235 | #FFFFFF33; alias → color/alpha/dark/200 @2203:11235 | `2cd8f83ec510367af450721f4a471bbd9bd1bc7a` |
| `color/button/basic/pressed` | `2203:12249` | COLOR | #13141733; alias → color_hmc/container_positive/pressed @2203:12248 | #FFFFFF33; alias → color_hmc/container_positive/pressed @2203:12248 | #13141733; alias → color_hmc/container_positive/pressed @2203:12248 | #FFFFFF33; alias → color_hmc/container_positive/pressed @2203:12248 | #13141733; alias → color_hmc/container_positive/pressed @2203:12248 | #FFFFFF33; alias → color_hmc/container_positive/pressed @2203:12248 | `7531eeea925e9cb864d2f26eef88d98111492ece` |
| `color/static/light/200` | `2203:12257` | COLOR | #FFFFFFD6 | #FFFFFFD6 | #FFFFFFD6 | #FFFFFFD6 | #FFFFFFD6 | #FFFFFFD6 | `9d4959be2d13e1196d15010e474f7aef44c17d7d` |
| `100` | `2203:12270` | COLOR | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | `14c0ebbd7872484097385aed957da10c409f41a9` |
| `color/background/primary` | `2203:12656` | COLOR | #F7F8FAFF; alias → color/basic/50 @2203:11152 | #1D1E21FF; alias → color/basic/50 @2203:11152 | #F7F8FAFF; alias → color/basic/50 @2203:11152 | #1D1E21FF; alias → color/basic/50 @2203:11152 | #F7F8FAFF; alias → color/basic/50 @2203:11152 | #1D1E21FF; alias → color/basic/50 @2203:11152 | `52dd508175c95fff78c18f47b904068d21728828` |
| `color/alpha/dark/300` | `2203:12657` | COLOR | #1314174D | #FFFFFF4D | #1314174D | #FFFFFF4D | #1314174D | #FFFFFF4D | `26def71681338e44af772fbc4a2bb89520bc5420` |
| `color/divider/tertiary` | `2203:12658` | COLOR | #1314174D; alias → color/alpha/dark/300 @2203:12657 | #FFFFFF4D; alias → color/alpha/dark/300 @2203:12657 | #1314174D; alias → color/alpha/dark/300 @2203:12657 | #FFFFFF4D; alias → color/alpha/dark/300 @2203:12657 | #1314174D; alias → color/alpha/dark/300 @2203:12657 | #FFFFFF4D; alias → color/alpha/dark/300 @2203:12657 | `ea56181521f185670db414718e508f50be8eb0bc` |
| `color/alpha/dark/500` | `2203:12681` | COLOR | #13141780 | #FFFFFF80 | #13141780 | #FFFFFF80 | #13141780 | #FFFFFF80 | `8a936f46b8462937883116f54f60d20335d63ace` |

## form_factor — 2203:11154

- collection key: `a35806038c1f086c6c0e6fe52d165fc41c47ffda`
- 모드 식별자: `connect-s=32062:0`, `connect-l=32257:0`, `connect-w=33219:0`, `connect-waterfall=65995:0`, `connect-s-14=72015:0`, `mode:92233:0=92233:0`

| Token | ID | Type | connect-s | connect-l | connect-w | connect-waterfall | connect-s-14 | mode:92233:0 | Key |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `gnb/menu/container_square` | `2203:11157` | FLOAT | 124 | 109 | 108 | 94 | 96 | — | `6e9aa32f69bc262c95876577bb51dc68eff35f2e` |
| `gnb/controller/pressed_square` | `2203:11160` | FLOAT | 100 | 88 | 96 | 96 | 88 | 84 | `ef5052d0a0d798c3a34a5f14b0f1da1a184b0d62` |
| `gnb/menu/radius_top_left` | `2203:11161` | FLOAT | 30 | 25 | 30 | 24 | 30 | — | `4e68d26ef684ca53bb77c610c37075e7b308e156` |
| `HMG_expansion/focus_border` | `2203:11172` | FLOAT | 6 | 6 | 6 | 6 | 6 | 4 | `951cdc590c073810d4defee89777529781397936` |
| `gnb/menu/radius_top_right` | `2203:11177` | FLOAT | 30 | 25 | 30 | 24 | 30 | — | `d0abd9cac45bc19ba8d36fb42c54ec702dbcc04d` |
| `gnb/menu/radius_bottom_left` | `2203:11178` | FLOAT | 30 | 25 | 30 | 24 | 30 | — | `c565860b5d44ea40e7f974537ebfabe8d1de2629` |
| `gnb/menu/radius_bottom_right` | `2203:11179` | FLOAT | 30 | 25 | 30 | 24 | 30 | — | `0e08a182a874a5486d8e1a48404866ebba752d71` |
| `gnb/temperature/container_width` | `2203:11180` | FLOAT | 164 | 116 | 108 | 108 | 132 | — | `17b5d8e9f2b49d152fc41f660689d856cf8a47eb` |
| `gnb/temperature/gap_horizontal` | `2203:11181` | FLOAT | -2 | -2 | -4 | -6 | -2 | -6 | `86322d3e917de77853eb7c8f033007f6c1aa7f2b` |
| `gnb/temperature/number_width` | `2203:11183` | FLOAT | 75 | 69 | 58 | 58 | 60 | 58 | `eef26e3eff18a7e0dc3ba0c7f80f73b30c28e2f4` |
| `gnb/temperature/decimal_places_padding_top` | `2203:11188` | FLOAT | 12 | 11 | 14 | 0 | 6 | 0 | `06a324db74204a85ab5ec08820dede36ca4f2377` |
| `gnb/temperature/decimal_places_witdh` | `2203:11189` | FLOAT | 38 | 33 | 32 | 32 | 36 | 32 | `09c973fb6ab000aa2d8a0f6c43404d68203d4644` |
| `gnb/temperature/wind_icon_square` | `2203:11196` | FLOAT | 48 | 40 | 27 | 27 | 40 | — | `75ef2abee969ff22eeb8f50d840f1ac80c42d8fe` |
| `gnb/controller/arrow_width` | `2203:11210` | FLOAT | 80 | 70 | 108 | 108 | 64 | — | `37af35303fa9afb2cefa1d46b04c9c9b6897e409` |
| `gnb/controller/arrow_height` | `2203:11211` | FLOAT | 0 | 0 | 100 | 80 | 0 | — | `e1cd0d6854972300dca4b5984a586a519bd4da02` |
| `gnb/controller/arrow_icon_sqaure` | `2203:11212` | FLOAT | 64 | 56 | 53 | 53 | 52 | 53 | `52803a212866982841d3b05011bc78db1b4f0a38` |
| `gnb/remove_button/container_square` | `2203:11217` | FLOAT | 44 | 39 | 40 | 40 | 44 | 40 | `882c70f47aaa361fb00fdf4740deafa205fae25a` |
| `gnb/remove_button/background_square` | `2203:11219` | FLOAT | 40 | 35 | 36 | 36 | 40 | 36 | `164575bad30f01ecb596638a25e0d5856a1b03ce` |
| `gnb/remove_button/icon_height` | `2203:11220` | FLOAT | 3 | 3 | 4 | 4 | 3 | 4 | `277abeefacb2f9358c0d7acd7c4576a41d0be24a` |
| `gnb/remove_button/icon_width` | `2203:11221` | FLOAT | 16 | 14 | 16 | 16 | 16 | 16 | `c59960be2f82fa53fda03ab9f981e92e72c18f30` |
| `gnb/application/app_square` | `2203:11230` | FLOAT | 84 | 74 | 70 | 70 | 74 | — | `b5a26b30241fb3c813814e50b95cec314827b4ca` |
| `gnb/menu/HMG_app_icon_radius` | `2203:11231` | FLOAT | 24 | 21 | 20 | 18 | 20 | 18 | `476cdd950b7a12f51ea7d57808063f4a645eff10` |
| `app_market/app_item/app_icon_border` | `2203:11232` | FLOAT | 1 | 1 | 1 | 1 | 1 | 1 | `c718e9d8b9e325955d1f3ab913b7bcc632d6f4ee` |
| `gnb/application/app_activate_width` | `2203:11786` | FLOAT | 8 | 7 | 8 | 8 | 8 | 8 | `5c3dcf6941152bcebd49bb7488d4eee7b8fe218b` |
| `gnb/application/app_activate_height` | `2203:11787` | FLOAT | 8 | 7 | 8 | 8 | 8 | 8 | `7108d405588d3dcc1a3485b76506185d39003859` |
| `window/container_width` | `2203:11902` | FLOAT | 2560 | 1920 | 3840 | 3072 | 2048 | 3072 | `e6635e8e4c59290736becf4abd06e453305fdb04` |
| `window/container_height` | `2203:11903` | FLOAT | 1440 | 1080 | 850 | 680 | 1152 | 680 | `9ee68eedea78472981295c8d2ef58f6e9a022d67` |
| `window/apps/HMG_radius_app` | `2203:11904` | FLOAT | 40 | 35 | 33 | 33 | 32 | 33 | `d3c823b1f236ad9bff1904faa4dd8252c8b273ed` |
| `statusbar/menus/icon_square` | `2203:12193` | FLOAT | 64 | 54 | 48 | 48 | 52 | 46 | `2703e0770053549572f0efd2d65a7781621e1975` |
| `statusbar/HMG_width_2` | `2203:12194` | FLOAT | 0 | 0 | 100 | 80 | 0 | — | `581aa1089a0af7e1957c197238c6340188442289` |
| `statusbar/height` | `2203:12195` | FLOAT | 96 | 84 | 850 | 680 | 76 | 0 | `da8a7e1261cdc354a9fc5e6489d30727d69e7bed` |
| `statusbar/menus/HMG_icon_voice` | `2203:12196` | FLOAT | 100 | 86 | 80 | 72 | 80 | 68 | `ee79205e00183d56732e4575045b99a04ff87952` |
| `statusbar/menus/HMG_icon_call` | `2203:12197` | FLOAT | 180 | 152 | 80 | 72 | 144 | 68 | `c1351cf475eb5a30185cfc9197f7343732aa4176` |
| `statusbar/menus/container_square` | `2203:12238` | FLOAT | 80 | 68 | 80 | 80 | 64 | 66 | `7b8110f2f4f578eaff94526d478f8d738c6056c9` |
| `statusbar/menus/container_radius_top_left` | `2203:12239` | FLOAT | 20 | 18 | 17 | 17 | 20 | 17 | `cc61d550e903bfee8cd55e53272776c4f6e3656f` |
| `statusbar/menus/container_radius_top_right` | `2203:12240` | FLOAT | 20 | 18 | 17 | 17 | 20 | 17 | `f1224a4545b51acbad8d9763e3cc08a256fb5b74` |
| `statusbar/menus/container_radius_bottom_left` | `2203:12241` | FLOAT | 20 | 18 | 17 | 17 | 20 | 17 | `64f849e5f161b56706d804a8da0c224015617981` |
| `statusbar/menus/container_radius_bottom_right` | `2203:12242` | FLOAT | 20 | 18 | 17 | 17 | 20 | 17 | `c9942ceb20f90d1acdee85e3d2d479f8b7a1b512` |
| `statusbar/menus/privacy/padding` | `2203:12243` | FLOAT | 8 | 6 | 10 | 8 | 8 | 7 | `a311890d9089736eb08496e58c76514956eff46a` |
| `statusbar/menus/privacy/dot` | `2203:12247` | FLOAT | 16 | 12 | 14 | 12 | 12 | 8 | `cf277ca8c0616443c34dea4f306140c6facad992` |
| `statusbar/menus/profile_square` | `2203:12250` | FLOAT | 80 | 60 | 70 | 70 | 56 | 50 | `455dce22154427d8f5ae7b3849eb363d270b25b1` |
| `imagery/cover/border` | `2203:12251` | FLOAT | 2 | 2 | 2 | 2 | 2 | 2 | `7b79dd589223495dc4343715eef30d4acde69b01` |
| `imagery/profile/radius_top_left` | `2203:12273` | FLOAT | 999 | 999 | 999 | 999 | 999 | 999 | `1e7a28210fef646b30e149bc5a6c3206d12ae2bb` |
| `imagery/profile/radius_top_right` | `2203:12274` | FLOAT | 999 | 999 | 999 | 999 | 999 | 999 | `74adad89a916b621cdcef518d8a954e511f444c7` |
| `imagery/profile/radius_bottom_left` | `2203:12275` | FLOAT | 999 | 999 | 999 | 999 | 999 | 999 | `82ffac2f6d5fa6bdd9b6716168b0b0bdb04e25f4` |
| `imagery/profile/radius_bottom_right` | `2203:12276` | FLOAT | 999 | 999 | 999 | 999 | 999 | 999 | `769c99f630fb9c61659fce8679570a7ee9554ca0` |
| `statusbar/HMG_extended_height_2` | `2203:12595` | FLOAT | 0 | 0 | 1440 | 0 | 0 | — | `2480f708bbe28454c26dfa9144a6404ca4fdbb4e` |
| `window/apps/portrait_width` | `2203:12659` | FLOAT | 840 | 628 | 800 | 648 | 672 | 870 | `d2ec420223027779a49f45c29e20c2107455213f` |
| `window/apps/application_height` | `2203:12660` | FLOAT | 1184 | 855 | 810 | 664 | 948 | 664 | `d6aba6e77861981058c2d80fa42ac09f6aafc870` |
| `window/apps/landscape_width` | `2203:12661` | FLOAT | 1700 | 1274 | 1640 | 1256 | 1360 | 1740 | `ec26945be7e80aa6991caaa3df9559dee7203e8d` |
| `bars/window_control/padding_horizontal` | `2203:12672` | FLOAT | 8 | 7 | 16 | 8 | 8 | 8 | `6204aa67e9cac5b8fde46cde70fc629b1c99a2ed` |
| `bars/window_control/container_width` | `2203:12673` | FLOAT | 20 | 18 | 30 | 24 | 16 | 30 | `c56786447d07e4cd19b16e620ceabe6705cf0e68` |
| `bars/window_control/container_height` | `2203:12674` | FLOAT | 200 | 176 | 240 | 192 | 200 | 192 | `32dc7a820c233da23321abf0bfa5cb8a50266709` |
| `bars/window_control/handle_width` | `2203:12675` | FLOAT | 4 | 4 | 8 | 6 | 4 | 6 | `284ea40b6702cdc2f1456e6b8b94dc65fc11847e` |
| `bars/window_control/handle_height` | `2203:12676` | FLOAT | 160 | 141 | 132 | 128 | 160 | 128 | `691fa5e7fab2f237656cbc9291adde4ca2899cdd` |
| `bars/radius_top_left` | `2203:12677` | FLOAT | 999 | 999 | 999 | 999 | 999 | 999 | `3d124e143b8c799e2562765aa6eb1c3ba83b792a` |
| `bars/radius_top_right` | `2203:12678` | FLOAT | 999 | 999 | 999 | 999 | 999 | 999 | `3430f6151245a51906fbaaf5cddf8787e9b6c0c8` |
| `bars/radius_bottom_left` | `2203:12679` | FLOAT | 999 | 999 | 999 | 999 | 999 | 999 | `4d7a31a3c5b18f781b3d2d983c0ea689e6dba361` |
| `bars/radius_bottom_right` | `2203:12680` | FLOAT | 999 | 999 | 999 | 999 | 999 | 999 | `b67b43931c8ac313c10af78291c019e7a74a7c0b` |
| `bars/window_control/handle_height_pressed` | `2203:12682` | FLOAT | 80 | 70 | 66 | 66 | 80 | 66 | `119f3f7de0a5d795b0d52f0d7c3c43e467aa2ba8` |
| `gnb/width` | `2203:12690` | FLOAT | 0 | 0 | 140 | 112 | 0 | 112 | `e608bd27cf65a4e0ee2fce4d0986a5b98f000074` |
| `gnb/gap_small` | `2203:12691` | FLOAT | 4 | 4 | 4 | 4 | 4 | 4 | `5c53ab8fdfd9b5ee3640ffad2195a31ffd248c5b` |
| `window/container_extended_height` | `2203:12730` | FLOAT | 0 | 0 | 1440 | 0 | 0 | 0 | `ece50040aa32703a8cee3537a8e03a41314903ad` |

## theme — 2203:11165

- collection key: `65260167b73fc0390d7bab2ceb97e83dd2564bab`
- 모드 식별자: `Hyundai-Light=100286:0`, `Hyundai-Dark=100286:1`, `Kia-Light=100286:2`, `Kia-Dark=100286:3`, `Genesis-Light=100286:4`, `Genesis-Dark=100286:5`

| Token | ID | Type | Hyundai-Light | Hyundai-Dark | Kia-Light | Kia-Dark | Genesis-Light | Genesis-Dark | Key |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `color/static/dark/100` | `2203:11166` | COLOR | #131417FF | #131417FF | #131417FF | #131417FF | #131417FF | #131417FF | `614d7298d7b644621d25b30768be4e6d31eba2e4` |
| `color/static/light/100` | `2203:11167` | COLOR | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | #FFFFFFFF | `cfd1aa037f13429f66cd5e74cb132869523bca2e` |
| `color/icon/dark/primary` | `2203:11168` | COLOR | #131417FF; alias → color/static/dark/100 @2203:11166 | #FFFFFFFF; alias → color/static/light/100 @2203:11167 | #131417FF; alias → color/static/dark/100 @2203:11166 | #FFFFFFFF; alias → color/static/light/100 @2203:11167 | #131417FF; alias → color/static/dark/100 @2203:11166 | #FFFFFFFF; alias → color/static/light/100 @2203:11167 | `97da1b7e5bbc534ad9800b1a85ecc8671af94d63` |
| `color/static/dark/400` | `2203:11954` | COLOR | #13141752 | #13141752 | #13141752 | #13141752 | #13141752 | #13141752 | `7243a4344447031dc901d84cd152d5f850edc076` |
| `color/static/light/400` | `2203:11955` | COLOR | #FFFFFF52 | #FFFFFF52 | #FFFFFF52 | #FFFFFF52 | #FFFFFF52 | #FFFFFF52 | `43b6eca434bf4c3efaa72ec6843f4660323356f2` |
| `color/icon/dark/quaternary` | `2203:11956` | COLOR | #13141752; alias → color/static/dark/400 @2203:11954 | #FFFFFF52; alias → color/static/light/400 @2203:11955 | #13141752; alias → color/static/dark/400 @2203:11954 | #FFFFFF52; alias → color/static/light/400 @2203:11955 | #13141752; alias → color/static/dark/400 @2203:11954 | #FFFFFF52; alias → color/static/light/400 @2203:11955 | `f51895e15a83a5bcd5b88af5766eb0fa9cd13b39` |

## brand — 2203:11156

- collection key: `d88cde2b6417fc5ee51d2036cb820c7595549b46`
- 모드 식별자: `hyundai=48511:0`, `kia=48511:1`, `genesis=48511:2`

| Token | ID | Type | hyundai | kia | genesis | Key |
| --- | --- | --- | --- | --- | --- | --- |
| `ivi_font/text` | `2203:11184` | STRING | {"textValue":"HyundaiSansUI_JP_KR_Latin"} | {"textValue":"KiaSignatureUI_JP_KR_Latin"} | {"textValue":"GenesisSansUI_JP_KR_Latin"} | `2c831faa8bd0a54de300d44cf79cd823899c18db` |

## form_factor_common — 2203:11155

- collection key: `c36b9dc88c8e41da8d87cac804003990fb1a08b5`
- 모드 식별자: `connect-s=32090:0`, `connect-l=32259:1`, `connect-w=33219:2`, `connect-waterfall=33235:1`, `connect-s-14=72636:0`

| Token | ID | Type | connect-s | connect-l | connect-w | connect-waterfall | connect-s-14 | Key |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `font/size_dp/level15` | `2203:11185` | FLOAT | 46 | 42 | 40 | 40 | 42 | `f9ed6029af6582212f8183dba92f343c059ad56b` |
| `font/line_height_dp/level14` | `2203:11186` | FLOAT | 60 | 46 | 50 | 50 | 46 | `d697b7a0e19f6cd5d2e4814643186f53b592507c` |
| `font/size_dp/level12` | `2203:11190` | FLOAT | 38 | 33 | 34 | 32 | 33 | `931d5677a02a93684cabf4389f5b257a704e2016` |
| `font/line_height_dp/level11` | `2203:11191` | FLOAT | 48 | 42 | 42 | 42 | 42 | `46b6b714097532db2a4979f0bb576c42c0dbbbea` |
| `font/size_dp/level5` | `2203:12198` | FLOAT | 24 | 21 | 23 | 23 | 21 | `42c727e208aa45c3ec1e3732e105abe294f1ebf6` |
| `font/line_height_dp/level5` | `2203:12199` | FLOAT | 32 | 28 | 30 | 30 | 28 | `d65fd3b83da16e855bc5c0a5c6ca9424817bbb07` |
| `font/size_sp/level12` | `2203:12697` | FLOAT | 38 | 33 | 34 | 34 | 33 | `f8f31dc69649adcce4f71e91dc36a917db4189e7` |

## Number — 2203:11227

- collection key: `7cee4fff5ccb0f2940e51fc1942a2d5ff954b4c4`
- 모드 식별자: `Mode 1=11493:8`

| Token | ID | Type | Mode 1 | Key |
| --- | --- | --- | --- | --- |
| `Radius/xs` | `2203:11228` | FLOAT | 0 | `5d340ed7eb7993dbc1ecfc9693ec4a8976f3ff63` |

## form_factor_common — 2003:58659

- collection key: `3b1ce012aab0868561a011595493b08bb4a5baa8`
- 모드 식별자: `connect-s=32090:0`, `connect-l=32259:1`, `connect-w=33219:2`, `connect-waterfall=33235:1`, `connect-s-14=72636:0`

| Token | ID | Type | connect-s | connect-l | connect-w | connect-waterfall | connect-s-14 | Key |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `font/size_dp/level15` | `2203:12692` | FLOAT | 46 | 42 | 40 | 40 | 42 | `f52d3db22bbb15b7ea681f95337271f19bfdf040` |
| `font/line_height_dp/level14` | `2203:12693` | FLOAT | 60 | 46 | 50 | 50 | 46 | `c9966fc1d0bec0f83d4db8c8eba28d9efe03fd74` |

## 해석 결과

- 변수 1009개, 해석되지 않은 모드 entry 0개.
- 같은 이름의 컬렉션이라도 원본 ID와 key가 다르면 별도로 유지한다.
- 바인딩된 컴포넌트에서는 토큰의 컬러와 노드/paint opacity를 중복 곱하지 않도록 원본 색상 구조를 확인한다.


## 모드명 정규화 내역

제어문자 U+0008이 붙은 connect-waterfall과 제어문자 없는 동명 모드만 연결했다. 숫자값은 해당 대상 variable entry의 원본 값을 사용했다.

| 요청 Token | 대상 Variable ID | 요청 Mode ID | 연결 Mode ID |
| --- | --- | --- | --- |
| imagery/profile/circle @2003:5973 | 2003:5972 | 33235:0 | 33235:1 |
| osd/control/radius_top_left @2003:14693 | 2003:5555 | 33235:0 | 33235:1 |
| osd/control/radius_top_right @2003:14695 | 2003:14694 | 33235:0 | 33235:1 |
| osd/control/radius_bottom_left @2003:14697 | 2003:14696 | 33235:0 | 33235:1 |
| osd/control/radius_bottom_right @2003:14699 | 2003:14698 | 33235:0 | 33235:1 |
| osd/icon_button_square @2003:14762 | 2003:5972 | 33235:0 | 33235:1 |
| osd/lights/title_prefix_icon_square @2003:14944 | 2003:14943 | 33235:0 | 33235:1 |
| osd/seat_position/title_prefix_icon_square @2003:15154 | 2003:14943 | 33235:0 | 33235:1 |
| utility/radius_top_left @2003:7043 | 2003:7042 | 33235:0 | 33235:1 |
| utility/radius_top_right @2003:7045 | 2003:7044 | 33235:0 | 33235:1 |
| utility/radius_bottom_left @2003:7047 | 2003:7046 | 33235:0 | 33235:1 |
| utility/radius_bottom_right @2003:7049 | 2003:7048 | 33235:0 | 33235:1 |
| utility/border @2003:7051 | 2003:7050 | 33235:0 | 33235:1 |
| utility/handle/arrow_line @2003:7057 | 2003:7056 | 33235:0 | 33235:1 |
| buttons/basic/large/radius_top_left @2003:8062 | 2003:7042 | 33235:0 | 33235:1 |
| buttons/basic/large/icon_sqaure @2003:8120 | 2003:8119 | 33235:0 | 33235:1 |
| buttons/basic/disabled_border @2003:8138 | 2003:8137 | 33235:0 | 33235:1 |
| buttons/basic/medium/radius_top_left_medium @2003:8147 | 2003:8146 | 33235:0 | 33235:1 |
| buttons/basic/medium/icon_sqaure @2003:8150 | 2003:8149 | 33235:0 | 33235:1 |
| buttons/basic/small/radius_bottom_right @2003:8154 | 2003:7455 | 33235:0 | 33235:1 |
| buttons/basic/small/icon_sqaure @2003:8156 | 2003:7122 | 33235:0 | 33235:1 |
| buttons/icon/medium/rounded_radius_top_left @2003:8304 | 2003:8303 | 33235:0 | 33235:1 |
| buttons/icon/medium/rounded_radius_top_right @2003:8306 | 2003:8305 | 33235:0 | 33235:1 |
| buttons/icon/medium/rounded_radius_bottom_left @2003:8308 | 2003:8307 | 33235:0 | 33235:1 |
| buttons/icon/medium/rounded_radius_bottom_right @2003:8310 | 2003:8309 | 33235:0 | 33235:1 |
| buttons/icon/medium/content @2003:8312 | 2003:8311 | 33235:0 | 33235:1 |
| buttons/icon/small/rounded_radius_top_left @2003:8314 | 2003:7449 | 33235:0 | 33235:1 |
| buttons/icon/small/rounded_radius_top_right @2003:8315 | 2003:7451 | 33235:0 | 33235:1 |
| buttons/icon/small/rounded_radius_bottom_left @2003:8316 | 2003:7453 | 33235:0 | 33235:1 |
| buttons/icon/small/rounded_radius_bottom_right @2003:8317 | 2003:7455 | 33235:0 | 33235:1 |
| buttons/icon/small/content @2003:8319 | 2003:8318 | 33235:0 | 33235:1 |
| buttons/icon/circle_radius_top_left @2003:8321 | 2003:8320 | 33235:0 | 33235:1 |
| buttons/icon/circle_radius_top_right @2003:8323 | 2003:8322 | 33235:0 | 33235:1 |
| buttons/icon/circle_radius_bottom_left @2003:8325 | 2003:8324 | 33235:0 | 33235:1 |
| buttons/icon/circle_radius_bottom_right @2003:8327 | 2003:8326 | 33235:0 | 33235:1 |
| imagery/cover/radius_top_left @2003:8368 | 2003:8303 | 33235:0 | 33235:1 |
| imagery/cover/radius_top_right @2003:8369 | 2003:8305 | 33235:0 | 33235:1 |
| imagery/cover/radius_bottom_left @2003:8370 | 2003:8307 | 33235:0 | 33235:1 |
| imagery/cover/radius_bottom_right @2003:8371 | 2003:8309 | 33235:0 | 33235:1 |
| imagery/cover/border @2003:8372 | 2003:8137 | 33235:0 | 33235:1 |
| _driving_view/3dview/parking_icon_square @2003:8605 | 2003:8604 | 33235:0 | 33235:1 |
| notification/vehicle/radius_top_left @2003:9741 | 2003:8146 | 33235:0 | 33235:1 |
| notification/vehicle/radius_top_right @2003:9743 | 2003:9742 | 33235:0 | 33235:1 |
| notification/vehicle/radius_bottom_left @2003:9745 | 2003:9744 | 33235:0 | 33235:1 |
| notification/vehicle/radius_bottom_right @2003:9747 | 2003:9746 | 33235:0 | 33235:1 |
| notification/border @2003:9748 | 2003:7050 | 33235:0 | 33235:1 |
| _driving_view/top/group3/minitbt_radius_top_left @2003:10005 | 2003:8146 | 33235:0 | 33235:1 |
| _driving_view/top/group3/minitbt_radius_top_right @2003:10006 | 2003:9742 | 33235:0 | 33235:1 |
| _driving_view/top/group3/minitbt_radius_bottom_left @2003:10007 | 2003:9744 | 33235:0 | 33235:1 |
| _driving_view/top/group3/minitbt_radius_bottom_right @2003:10008 | 2003:9746 | 33235:0 | 33235:1 |
| _driving_view/bottom/ipedal_radius_top_left @2003:10446 | 2003:9007 | 33235:0 | 33235:1 |
| _driving_view/bottom/ipedal_radius_top_right @2003:10447 | 2003:11227 | 33235:0 | 33235:1 |
| _driving_view/bottom/ipedal_radius_bottom_left @2003:10448 | 2003:9011 | 33235:0 | 33235:1 |
| _driving_view/bottom/driving_mode_radius_top_left @2003:10455 | 2003:9007 | 33235:0 | 33235:1 |
| _driving_view/bottom/driving_mode_radius_top_right @2003:10456 | 2003:11227 | 33235:0 | 33235:1 |
| _driving_view/bottom/driving_mode_radius_bottom_left @2003:10457 | 2003:9011 | 33235:0 | 33235:1 |
| _driving_view/bottom/driving_mode_radius_bottom_right @2003:10458 | 2003:11230 | 33235:0 | 33235:1 |
| _driving_view/left/group2/doorlock_switch_radius_top_left @2003:10503 | 2003:8320 | 33235:0 | 33235:1 |
| _driving_view/left/group2/doorlock_switch_radius_top_right @2003:10504 | 2003:8322 | 33235:0 | 33235:1 |
| _driving_view/left/group2/doorlock_switch_radius_bottom_left @2003:10505 | 2003:8324 | 33235:0 | 33235:1 |
| _driving_view/left/group2/doorlock_switch_knob_radius_top_left @2003:10513 | 2003:8320 | 33235:0 | 33235:1 |
| _driving_view/left/group2/doorlock_switch_knob_radius_top_right @2003:10514 | 2003:8322 | 33235:0 | 33235:1 |
| _driving_view/left/group2/doorlock_switch_knob_radius_bottom_left @2003:10515 | 2003:8326 | 33235:0 | 33235:1 |
| _driving_view/left/group2/doorlock_switch_knob_radius_bottom_right @2003:10516 | 2003:8324 | 33235:0 | 33235:1 |
| _driving_view/left/group2/doorlock_switch_icon_square @2003:10533 | 2003:7122 | 33235:0 | 33235:1 |
| _driving_view/left/group2/ad_indicator_square @2003:10571 | 2003:10570 | 33235:0 | 33235:1 |
| _driving_view/left/group2/ad_indicator_icon_square @2003:10573 | 2003:10572 | 33235:0 | 33235:1 |
| _driving_view/left/group2/ad_indicator_auto_radius_top_left @2003:10581 | 2003:10580 | 33235:0 | 33235:1 |
| _driving_view/left/group2/ad_indicator_auto_radius_top_right @2003:10583 | 2003:10582 | 33235:0 | 33235:1 |
| _driving_view/left/group2/ad_indicator_auto_radius_bottom_left @2003:10585 | 2003:10584 | 33235:0 | 33235:1 |
| _driving_view/left/group2/ad_indicator_auto_radius_bottom_right @2003:10587 | 2003:10586 | 33235:0 | 33235:1 |
| _driving_view/left/group2/sign_next_square @2003:10629 | 2003:10628 | 33235:0 | 33235:1 |
| _driving_view/3dview/parked_ring_line @2003:11647 | 2003:7056 | 33235:0 | 33235:1 |
| _driving_view/3dview/vehicle_control_icon_square @2003:11720 | 2003:11719 | 33235:0 | 33235:1 |