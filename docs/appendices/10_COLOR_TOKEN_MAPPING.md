# Web 최신 컬러 이름과 Figma 참조의 연결표

이 부록은 `02`·`03` 및 Figma 상세 부록의 slash 이름/ID를 최신 웹의 canonical 이름으로 연결한다. 별도의 컬러 값을 정의하거나 구버전 테마를 추가하는 표가 아니다. **색상 구현값은 웹 Colors 전체 표의 Light/Dark RGB+alpha다.** 해당 컴포넌트에 더 구체적인 웹 도해 색이 명시된 경우에는 상위 구현 프롬프트의 웹 내부 적용 우선순위를 따른다.

근거: 사용자 첨부 `Pleos_Connect_design_assets_215(1).fig`의 변수 metadata와 공식 Colors 페이지의 이름/target 표. 웹 원문: https://document.pleos.ai/docs/connect/guide/docs-design/foundations/colors

## 적용 순서

1. Figma 참조에 ID/key가 있으면 아래의 ID/key로 canonical 이름을 찾는다. 이름만 있는 경우 같은 collection과 문맥을 확인한다. 슬래시를 밑줄로 바꾸는 규칙만으로 대응을 끝내지 않는다.
2. 대응된 canonical 이름의 **최신 웹 값**을 적용한다. Figma 부록에 병기된 HEX/opacity snapshot으로 웹 값을 덮지 않는다. paint opacity와 색 자체 alpha도 중복 곱하지 않는다.
3. Old name은 입력 이름 호환 및 출처 감사용 alias다. 새 공개 API나 별도 runtime specification profile을 생성하지 않는다.
4. 웹에 정의되지 않은 Figma semantic role은 `[첨부 보완]`으로 명시한다. 같은 색이라는 이유만으로 다른 역할의 웹 토큰에 결합하지 않는다. `divider/*`의 확정된 보완값은 아래 표를 사용한다.
5. 웹 행의 Figma 대응이 확인되지 않은 경우 그 값은 웹에서 그대로 구현한다. 없는 Figma ID/key를 만들지 않는다. 아래의 미확인 표는 design assets에서의 미확인 상태이며, 다른 문서 전체에 존재하지 않는다고 주장하는 표가 아니다.

검증 범위: 웹 primitive 31 + semantic 118 = **149행**, assets COLOR 변수 **209개**. 웹과 직접 대응한 행은 **127행(primitive31 + semantic96)**이고, assets 대응 미확인 웹 행은 **22행**이다. 직접 대응표에 사용되지 않은 Figma COLOR 변수 **82개**는 imported/legacy 중복·별도 역할·추가 보완 변수가 섞여 있으므로 아래에 따로 보존했다.

## 단순 slash 치환으로 연결되지 않는 필수 별칭

| Figma 원본 이름 | 최신 Web canonical | Figma ID |
| --- | --- | --- |
| `alpha/dark/50` | `basic_alpha_dark_50` | 67:4944 |
| `alpha/dark/100` | `basic_alpha_dark_100` | 67:4987 |
| `alpha/dark/200` | `basic_alpha_dark_200` | 67:4988 |
| `alpha/dark/300` | `basic_alpha_dark_300` | 67:4989 |
| `alpha/dark/400` | `basic_alpha_dark_400` | 67:4990 |
| `alpha/dark/500` | `basic_alpha_dark_500` | 67:4991 |
| `alpha/light/50` | `basic_alpha_light_50` | 67:4981 |
| `alpha/light/100` | `basic_alpha_light_100` | 67:4983 |
| `alpha/light/200` | `basic_alpha_light_200` | 67:4982 |
| `alpha/light/300` | `basic_alpha_light_300` | 67:4984 |
| `alpha/light/400` | `basic_alpha_light_400` | 67:4985 |
| `alpha/light/500` | `basic_alpha_light_500` | 67:4986 |
| `static/dark/100` | `basic_static_dark_100` | 2:15158 |
| `static/dark/200` | `basic_static_dark_200` | 67:4995 |
| `static/dark/300` | `basic_static_dark_300` | 67:4996 |
| `static/dark/400` | `basic_static_dark_400` | 67:4997 |
| `static/light/100` | `basic_static_light_100` | 2:15159 |
| `static/light/200` | `basic_static_light_200` | 67:4992 |
| `static/light/300` | `basic_static_light_300` | 67:4993 |
| `static/light/400` | `basic_static_light_400` | 67:4994 |
| `controller/slider/knop` | `controller_slider_knob` | 67:24415 |
| `Miscellaneous/Charging/normal` | `driving_charging_normal` | 67:5026 |
| `Miscellaneous/Charging/deep` | `driving_charging_deep` | 67:5027 |
| `driving_view/gradient_start` | `driving_gradient_start` | 67:5028 |
| `gleo/Olf/surface_primary` | `gleo_surface_primary` | 67:33939 |
| `Feature/Media/radio-primary` | `media_radio_primary` | 67:5068 |
| `Feature/Media/music-primary` | `media_music_primary` | 67:5069 |
| `phone/accept_normal` | `phone_call_normal` | 67:22189 |
| `Button/Call/accept-pressed` | `phone_call_pressed` | 67:5074 |
| `Button/Call/end-pressed` | `phone_end_pressed` | 67:5076 |

Figma 원본 `knop`, `Olf` 및 과거 `accept` 이름은 출처를 추적하기 위해 보존한 문자열이다. 런타임에서는 각각 위 canonical `knob`, `gleo_surface_primary`, `phone_call_*`로 연결한다. 기본 alpha/static 이름에는 웹의 `basic_` 접두사를 추가한다.

웹 semantic target 표의 `alpha_dark_N`, `alpha_light_N`, `static_dark_N`, `static_light_N`도 각각 `basic_alpha_dark_N`, `basic_alpha_light_N`, `basic_static_dark_N`, `basic_static_light_N`을 가리킨다. `N`은 실제 표에 존재하는 단계만 허용한다. 원문의 `alpha_dark100`, `basic_alpha_dark100`, `basic_alpha_dark300`은 숫자 앞 밑줄이 생략된 표기이며 각각 `_100`, `_100`, `_300`으로 정규화한다. Scroll bar 웹 설명의 `gray-alpha-200`은 `basic_alpha_dark_200`, `gray-900`은 `basic_900`으로 연결한다.

## 대응이 확인된 모든 웹 행

원본 파일은 모든 행에서 `Pleos_Connect_design_assets_215(1).fig`다. Node ID는 이 파일의 namespace이며 다른 `.fig`의 ID와 합치지 않는다. 정확한 collection key도 JSON에 보존되어 있다.

### Primitive 31행

| Web canonical | Figma 이름 | Node ID | Collection ID | Variable stable key |
| --- | --- | --- | --- | --- |
| `basic_00` | `basic/00` | 67:4943 | 2:15157 | `4f98376b8f09d0d5b168735f5b387f679ab6a46f` |
| `basic_50` | `basic/50` | 67:4971 | 2:15157 | `e622d5d06eb9cde829ad024f723719f248359b6a` |
| `basic_100` | `basic/100` | 67:4972 | 2:15157 | `effa651fe57cdac371634ce89463e0c0c22866f5` |
| `basic_200` | `basic/200` | 67:4973 | 2:15157 | `75440b021474fe1f428ddb2630e9c04ce9acad71` |
| `basic_300` | `basic/300` | 67:4974 | 2:15157 | `003539e078df5c4f00216d927c3e991c6fe9340e` |
| `basic_400` | `basic/400` | 67:4975 | 2:15157 | `8096a8f9035cf1066f3c5c9b22e76dc9f4fc7428` |
| `basic_500` | `basic/500` | 67:4976 | 2:15157 | `ef6e5fbdb84e8fa8112d919152ab04d601b33983` |
| `basic_600` | `basic/600` | 67:4977 | 2:15157 | `413d29bb7f4b84a10051c2ae8fb39a8c88da34bb` |
| `basic_700` | `basic/700` | 67:4978 | 2:15157 | `362370a488768bb9519f05254f6d03bfdf1142c5` |
| `basic_800` | `basic/800` | 67:4979 | 2:15157 | `471644c46d60d9246701255da74c5f0c4fb27015` |
| `basic_900` | `basic/900` | 67:4980 | 2:15157 | `b1e228e792fc8c68b905f66e7e4f2b375897311c` |
| `basic_alpha_dark_50` | `alpha/dark/50` | 67:4944 | 2:15157 | `3398e4e3a2e25d1d9581f69ac838383d62cdc87d` |
| `basic_alpha_dark_100` | `alpha/dark/100` | 67:4987 | 2:15157 | `47fb07584fd838bf3014d8d81889e9732ca7acec` |
| `basic_alpha_dark_200` | `alpha/dark/200` | 67:4988 | 2:15157 | `fcda5f912e3b3c16b92398226a431963f80ddf50` |
| `basic_alpha_dark_300` | `alpha/dark/300` | 67:4989 | 2:15157 | `d5354b16f8b249e49f1d0e7b4a5b10c15237fd74` |
| `basic_alpha_dark_400` | `alpha/dark/400` | 67:4990 | 2:15157 | `e146ed87bd706553c5231c40b2edd0bc6d153f8f` |
| `basic_alpha_dark_500` | `alpha/dark/500` | 67:4991 | 2:15157 | `3054f2fd4ab571924588b6aba50db84174bf91f0` |
| `basic_alpha_light_50` | `alpha/light/50` | 67:4981 | 2:15157 | `e0ace82938e4b665c754e3e47c3a95116bec2bd0` |
| `basic_alpha_light_100` | `alpha/light/100` | 67:4983 | 2:15157 | `d96856e05cce121b1183a27ee6264f2e35fda775` |
| `basic_alpha_light_200` | `alpha/light/200` | 67:4982 | 2:15157 | `ae9c047304b09f4e241975c68a222c1a40dec806` |
| `basic_alpha_light_300` | `alpha/light/300` | 67:4984 | 2:15157 | `1f0a62d5f3716b72d25e489b89116f2daad74735` |
| `basic_alpha_light_400` | `alpha/light/400` | 67:4985 | 2:15157 | `12c00d132c3943c8667279509d86082149f4fb69` |
| `basic_alpha_light_500` | `alpha/light/500` | 67:4986 | 2:15157 | `46e020e2d4d87d3967aabe617823fe481b0a32bd` |
| `basic_static_dark_100` | `static/dark/100` | 2:15158 | 2:15157 | `1e07d10f0e96dc15d2de8377cad3e3dafc187667` |
| `basic_static_dark_200` | `static/dark/200` | 67:4995 | 2:15157 | `b5bc55e2f8807ce2042818c57583eb6ff879a987` |
| `basic_static_dark_300` | `static/dark/300` | 67:4996 | 2:15157 | `5350c64259b80b4d31f1b8a31d68c29bddaf0e39` |
| `basic_static_dark_400` | `static/dark/400` | 67:4997 | 2:15157 | `997758a4f811828ed5f1c564efac3d06dccbbe09` |
| `basic_static_light_100` | `static/light/100` | 2:15159 | 2:15157 | `4c7bc411bf601f05974f8697deb6c99065532663` |
| `basic_static_light_200` | `static/light/200` | 67:4992 | 2:15157 | `53126f4229f0ce3c3a7cf7a85b97ca6e39fe62f8` |
| `basic_static_light_300` | `static/light/300` | 67:4993 | 2:15157 | `d9c1942a19cd2ba9476a8d677f71692b283fedd7` |
| `basic_static_light_400` | `static/light/400` | 67:4994 | 2:15157 | `5a51c4144648a071f6c2feae46b6885f7905bae6` |

### Semantic 96행

| Web canonical | Figma 이름 | Node ID | Collection ID | Variable stable key |
| --- | --- | --- | --- | --- |
| `background_primary` | `background/primary` | 67:5015 | 2:15157 | `8663a8b754bb48add9afa8ead97d54221073f0e2` |
| `background_secondary` | `background/secondary` | 67:5016 | 2:15157 | `f43b447f68fcb23ec2c571e36588c818a18774ac` |
| `background_popup` | `background/popup` | 67:5014 | 2:15157 | `1338fe23523cc3e3fede2bde2e1a59569dfe4ec5` |
| `button_basic_enabled` | `button/basic/enabled` | 67:22038 | 2:15157 | `a044c728b9a7ba456db380312936055d555c2a9c` |
| `button_basic_pressed` | `button/basic/pressed` | 67:22108 | 2:15157 | `9515b1ed686495354f6638b5717a13003a4a7235` |
| `button_basic_disabled` | `button/basic/disabled` | 67:22110 | 2:15157 | `cfa48e0b2f19ce63d624329e62f9ba7aabb2ce48` |
| `button_switch_enabled` | `button/switch/enabled` | 67:22164 | 2:15157 | `c4642f382b9682c5e21c15576c627438a86f1a4c` |
| `button_switch_pressed` | `button/switch/pressed` | 67:22165 | 2:15157 | `50fe683b33868dabfdedef67feca5367b52e16ab` |
| `button_switch_disabled` | `button/switch/disabled` | 67:22166 | 2:15157 | `bfb65dafacdad59ad063cfc5a81b34537fb9efae` |
| `button_filled_enabled` | `button/filled/enabled` | 67:22125 | 2:15157 | `e08a55c202cce0a9ccf9699ab56b904f6cf338dc` |
| `button_filled_pressed` | `button/filled/pressed` | 67:22126 | 2:15157 | `9fe853f6b5b1b9109fddd3ab05d11d986a667aee` |
| `button_filled_disabled` | `button/filled/disabled` | 67:22127 | 2:15157 | `18d987510225801541b3ab050454d19691533736` |
| `controller_slider_normal` | `controller/slider/normal` | 67:24397 | 2:15157 | `57c4e92fe4cd21633ef1c692c1070e9d2d305efb` |
| `controller_slider_pressed` | `controller/slider/pressed` | 67:24472 | 2:15157 | `567a064016256b32f554b97f5c87826215cc6806` |
| `controller_slider_knob` | `controller/slider/knop` | 67:24415 | 2:15157 | `9bde8bc7146ca0f882a6dd1064365417aab4955f` |
| `controller_tab_background` | `controller/tab_background` | 67:32609 | 2:15157 | `c2f02edb4f1015c61d5bbfb8c16f393c31214b1e` |
| `controller_stepper_background` | `controller/stepper_background` | 67:25149 | 2:15157 | `10297715441a285b10cdfba045502e2edef5358e` |
| `climate_button_border_enabled` | `climate/button_border_enabled` | 67:24332 | 2:15157 | `50ca1e4f3f24ac90b5ec02d9c7783080aed03b9f` |
| `climate_slider_background` | `climate/slider_background` | 67:24331 | 2:15157 | `b5582653bc2cff861dfb4df9cbc17fc1644c8d35` |
| `dropdown_normal` | `dropdown/normal` | 67:25520 | 2:15157 | `ca6198ca8b5c5fa199e02fbaaf2c2612078a6e4c` |
| `dropdown_pressed` | `dropdown/pressed` | 67:25616 | 2:15157 | `e598e6c906317d47d7ca02809c1bdc0f2f687a1c` |
| `dim_dark_primary` | `dim/dark/primary` | 67:5017 | 2:15157 | `bbcf49cac6fb49b521b15f913d800b4274a3338f` |
| `dim_dark_secondary` | `dim/dark/secondary` | 67:5018 | 2:15157 | `7efc94315de7230448d83821ae8987b286bbfe57` |
| `dim_dark_tertiary` | `dim/dark/tertiary` | 67:5019 | 2:15157 | `707875638556be9cd0c4d90576d080183c519ec6` |
| `dim_light_primary` | `dim/light/primary` | 67:5020 | 2:15157 | `29c158ea4dba66c67e91bdd16b804d3d9419c509` |
| `dim_light_secondary` | `dim/light/secondary` | 67:5021 | 2:15157 | `63bba7c95a5cdce3b662beb97e00e19c81e562c6` |
| `dim_light_tertiary` | `dim/light/tertiary` | 67:5022 | 2:15157 | `98d00cd9f257a07aec10d9f288ecdb327c941f94` |
| `driving_charging_normal` | `Miscellaneous/Charging/normal` | 67:5026 | 1:33 | `59ce862b9f7fe786b3b0cec77f7f026d992a8ab3` |
| `driving_charging_deep` | `Miscellaneous/Charging/deep` | 67:5027 | 1:33 | `ad4a67d8c2f23679a49c442c4f59aef80b042d83` |
| `driving_gradient_start` | `driving_view/gradient_start` | 67:5028 | 2:15157 | `28eb804ca701628ab0e9bbc3868a2786d4344f04` |
| `field_background` | `field/background` | 67:26982 | 2:15157 | `2c2fddde52c845e038a9ec59869d25997445d4e2` |
| `field_focused` | `field/focused` | 67:27000 | 2:15157 | `bcae7a20252492c8d91cce8e79f2f5420f67303d` |
| `gleo_surface_primary` | `gleo/Olf/surface_primary` | 67:33939 | 2:15157 | `b0d5466b340d1a60ae6edbc2baf3fc647dd16d46` |
| `icon_dark_primary` | `icon/dark/primary` | 2:15160 | 2:15157 | `95c481151256faaafdee30ab9b4fff009de006b5` |
| `icon_dark_secondary` | `icon/dark/secondary` | 67:5033 | 2:15157 | `54d7f16d4dc8ef654c565420ac213d0cdf04f8ac` |
| `icon_dark_tertiary` | `icon/dark/tertiary` | 67:5035 | 2:15157 | `02cf653fb2a3f63a9acd7af255de48d4bdf3e658` |
| `icon_dark_quaternary` | `icon/dark/quaternary` | 67:5037 | 2:15157 | `28493bf153fef8c7b72629afdc820ab9ab4a3eec` |
| `icon_light_primary` | `icon/light/primary` | 67:5039 | 2:15157 | `07b74843f3c138433ea738761406d9fde8840f7e` |
| `icon_light_secondary` | `icon/light/secondary` | 67:5041 | 2:15157 | `888cc27764030f6fa554d6cb2fcd7f6e02d678ff` |
| `icon_light_tertiary` | `icon/light/tertiary` | 67:5043 | 2:15157 | `45feb9708adc3e9d0fd4aca77256142820330633` |
| `icon_light_quaternary` | `icon/light/quaternary` | 67:5045 | 2:15157 | `8c2b8fd82b05335540e0b2f59a8aaef80abdea07` |
| `informative_active` | `informative/active` | 67:21959 | 2:15157 | `0544005de32393d44dd987d02a2816878ef7c66a` |
| `informative_positive` | `informative/positive` | 67:22170 | 2:15157 | `fc7cbd576fed110e87ad38960df155c67740ff97` |
| `informative_autonomous_driving` | `informative/autonomous_driving` | 67:5000 | 2:15157 | `b95f1ac8f39bc0153ba9c573bc534d75d51bbe35` |
| `keyboard_normal_primary_normal` | `keyboard/normal/primary_normal` | 67:5046 | 2:15157 | `1935fb096bafd12445fa50f8c0825ce1586ba590` |
| `keyboard_normal_primary_pressed` | `keyboard/normal/primary_pressed` | 67:5047 | 2:15157 | `589bfb1066eabb42598b9e53cb71522df458d8d0` |
| `keyboard_normal_secondary_normal` | `keyboard/normal/secondary_normal` | 67:5048 | 2:15157 | `f0429ff7dff26b156de36f9c4d057270bddd64b1` |
| `keyboard_normal_secondary_pressed` | `keyboard/normal/secondary_pressed` | 67:5049 | 2:15157 | `e2d2a3c60285ef213432c3af61a2af17e3a4d9ca` |
| `keyboard_normal_active_normal` | `keyboard/normal/active_normal` | 67:5050 | 2:15157 | `f8e25ae2349eb69a125853853079b1b79166f479` |
| `keyboard_normal_active_pressed` | `keyboard/normal/active_pressed` | 67:5051 | 2:15157 | `26efad8fd38607109ffbf9ed9a643672f956110d` |
| `keyboard_normal_accents_normal` | `keyboard/normal/accents_normal` | 67:5052 | 2:15157 | `f7df418c73cbc00c64e954c0fddfbd75024a9ba0` |
| `keyboard_normal_accents_pressed` | `keyboard/normal/accents_pressed` | 67:5053 | 2:15157 | `50498952fd11cf95f989a5a635c4607bec34854b` |
| `keyboard_normal_background` | `keyboard/normal/background` | 67:5054 | 2:15157 | `b58c8498ec48293a85af15a808b831cf17233b2e` |
| `keyboard_static_primary_normal` | `keyboard/static/primary_normal` | 67:5055 | 2:15157 | `b0d48f7cc2b8f43135e2421ec0fdfe38b9dfd724` |
| `keyboard_static_primary_pressed` | `keyboard/static/primary_pressed` | 67:5056 | 2:15157 | `b95e47e85f1f19b7c9da7e680d811c7da16598fe` |
| `keyboard_static_secondary_normal` | `keyboard/static/secondary_normal` | 67:5057 | 2:15157 | `f98053865787c3040c8ad5939633e7d91b4d0354` |
| `keyboard_static_secondary_pressed` | `keyboard/static/secondary_pressed` | 67:5058 | 2:15157 | `f9ae373f5e6830b5fa82ac26537e965b734c1781` |
| `keyboard_static_active_normal` | `keyboard/static/active_normal` | 67:5059 | 2:15157 | `d35bf2baef0c145c05bf0796a0227ef4ac084520` |
| `keyboard_static_active_pressed` | `keyboard/static/active_pressed` | 67:5060 | 2:15157 | `fd36d26a65db8d6e801a199743ce29620f020a7a` |
| `keyboard_static_accents_normal` | `keyboard/static/accents_normal` | 67:5061 | 2:15157 | `cb56a4c1b1d217d71226dc87628c3e0be1e54cd9` |
| `keyboard_static_accents_pressed` | `keyboard/static/accents_pressed` | 67:5062 | 2:15157 | `28aefac6e0141aae75a336436494ccb87a994032` |
| `keyboard_static_background` | `keyboard/static/background` | 67:5063 | 2:15157 | `d23e846fd2a07c51e22ba3bf0220abff199d4247` |
| `keyboard_static_icon_light` | `keyboard/static/icon_light` | 67:5064 | 2:15157 | `06828626ae7c1e0804f7ef3ce27219064124681e` |
| `keyboard_static_icon_dark` | `keyboard/static/icon_dark` | 67:5065 | 2:15157 | `d79b9152ba1000e3cb339f4b6abad1c9f5b86387` |
| `keyboard_static_icon_disabled` | `keyboard/static/icon_disabled` | 67:5066 | 2:15157 | `a9799806cfa201ba6b7a9b45b52a8133fed8a95a` |
| `keyboard_static_text` | `keyboard/static/text` | 67:5067 | 2:15157 | `ab3e529e84f9657b4e42fd5742f181c36a364ff2` |
| `media_radio_primary` | `Feature/Media/radio-primary` | 67:5068 | 1:33 | `fdb1fe1c0c2b35a94566fa181075303394b5dc63` |
| `media_music_primary` | `Feature/Media/music-primary` | 67:5069 | 1:33 | `d74ee24502dcf82791c42ff9300d9f25dd04d48f` |
| `media_radio_gradient_start` | `media/radio_gradient_start` | 67:5070 | 2:15157 | `bf0d84d30afeddbeb48976c735cee66858cda8a5` |
| `media_radio_gradient_end` | `media/radio_gradient_end` | 67:5071 | 2:15157 | `a0c15aa46039fa37645e7c3e25666eeae6c0b4bf` |
| `overlay_default` | `overlay/default` | 67:5072 | 2:15157 | `1fe22181337930146eb8d68319174b3a2658e677` |
| `phone_call_normal` | `phone/accept_normal` | 67:22189 | 2:15157 | `ef8e89e40db4bf31f5d6a0dc01f3c499ea9abed5` |
| `phone_call_pressed` | `Button/Call/accept-pressed` | 67:5074 | 1:33 | `7085245927e7ff8d1e563f742f12d75ead4ca414` |
| `phone_end_normal` | `phone/end_normal` | 67:22190 | 2:15157 | `2a2ad45f4a3a817534b17149c5f569cbd49fe441` |
| `phone_end_pressed` | `Button/Call/end-pressed` | 67:5076 | 1:33 | `67cc76041d44679a6fcb32e85ebce013504c1fc2` |
| `regulation_blue` | `regulation/blue` | 67:5089 | 2:15157 | `163aaaf39e9024d8390bbd35d77fccea10449e97` |
| `regulation_green` | `Regulation/green` | 1:6093 | 1:6087 | `742640cbac2ab32a70128c8dfe256e6cf534e639` |
| `regulation_orange` | `Regulation/orange` | 1:6090 | 1:6087 | `aae13c79f4acd8dc6daa9089022b0ed29b1cb47e` |
| `regulation_red` | `regulation/red` | 67:5091 | 2:15157 | `404985165abd2e5ce68b51d802becbfe18d45f7d` |
| `surface_basic` | `surface/basic` | 67:25523 | 2:15157 | `b50041ccfeed4620545be749e2dd6299cd5b87b0` |
| `surface_high` | `surface/high` | 67:27001 | 2:15157 | `9ccf38c6edb52a244a1f3f33373f4d03a4acf684` |
| `surface_accent` | `surface/accent` | 67:22187 | 2:15157 | `593af766359b621984bab5099e6d7ba6eb147ae2` |
| `switch_on` | `switch/on` | 67:25640 | 2:15157 | `c5666f792f45b39e938f45342f109d52e1ca5363` |
| `switch_off` | `switch/off` | 67:5081 | 2:15157 | `a668d6e3c0cfb56bf12f9151bc09992ca32c83df` |
| `switch_disabled` | `switch/disabled` | 67:5082 | 2:15157 | `7ae7a3597ae276d7ea564a7c4cf0b2856ec64880` |
| `switch_knob_on` | `switch/knob_on` | 67:25646 | 2:15157 | `15a3eabc06ef5200c60b262335f5fd852e7df4af` |
| `switch_knob_off` | `switch/knob_off` | 67:25647 | 2:15157 | `d112e120d31aec65a9a9cfe0c9dbf34485358297` |
| `switch_knob_disabled` | `switch/knob_disabled` | 67:25648 | 2:15157 | `f20ddf66d9464e0e6f21f90e9f34b8207af89d74` |
| `text_dark_primary` | `text/dark/primary` | 67:5031 | 2:15157 | `f928e3fcfa99fee2c099909ce794cad7fde4e328` |
| `text_dark_secondary` | `text/dark/secondary` | 67:5032 | 2:15157 | `3c8fc343a92e12738bedb1fdd16b44c65f045d64` |
| `text_dark_tertiary` | `text/dark/tertiary` | 67:5034 | 2:15157 | `fba7bba198b151202aedf827efe6e6596334b173` |
| `text_dark_quaternary` | `text/dark/quaternary` | 67:5036 | 2:15157 | `96f6c74055c01349e285a2f6c07892ec280966ea` |
| `text_light_primary` | `text/light/primary` | 67:5038 | 2:15157 | `3fa8f4bff01b6d0a672785eb95f470dbb5d9a3a7` |
| `text_light_secondary` | `text/light/secondary` | 67:5040 | 2:15157 | `e951025163f8e8948ea5cf5eec4126d6f39fd5a7` |
| `text_light_tertiary` | `text/light/tertiary` | 67:5042 | 2:15157 | `b02411238791e8bd52afb51710888b58dc94f56a` |
| `text_light_quaternary` | `text/light/quaternary` | 67:5044 | 2:15157 | `f6f55cdf43e82484a4448e41c93f442613b055ac` |

## 웹은 정의되어 있으나 assets 대응 ID/key가 미확인인 22행

이 행들은 웹에 최종 Light/Dark 값이 있으므로 구현에서 누락하지 않는다. 아래 `미확인`은 컬러 값 미정의가 아니라 **첨부 design assets의 대응 변수 metadata 미확인**을 뜻한다. 원본에 없는 ID/key를 추정하여 채우지 않았다.

| Web canonical | Light 구현값 | Dark 구현값 | Figma ID/key |
| --- | --- | --- | --- |
| `climate_button_enabled` | #E0E1E6 | #1D1E21 | 미확인 (`null`) |
| `climate_button_selected` | #FFFFFF | #44464E | 미확인 (`null`) |
| `climate_button_border_disabled` | #131417 @ 5% | #FFFFFF @ 5% | 미확인 (`null`) |
| `climate_toggle_selected` | #131417 @ 10% | #131417 @ 30% | 미확인 (`null`) |
| `climate_toggle_pressed` | #131417 @ 20% | #131417 @ 40% | 미확인 (`null`) |
| `climate_airvent_button_opened` | #FFFFFF | #E0E1E6 | 미확인 (`null`) |
| `climate_airvent_button_closed` | #FFFFFF @ 40% | #FFFFFF @ 20% | 미확인 (`null`) |
| `climate_airvent_symbol_opened` | #131417 @ 84% | #131417 @ 84% | 미확인 (`null`) |
| `climate_airvent_symbol_closed` | #131417 @ 32% | #131417 @ 64% | 미확인 (`null`) |
| `climate_airvent_opened` | #FFFFFF @ 64% | #FFFFFF @ 32% | 미확인 (`null`) |
| `climate_airvent_closed` | #FFFFFF @ 20% | #FFFFFF @ 10% | 미확인 (`null`) |
| `driving_gearshift_background` | #131417 | #313236 | 미확인 (`null`) |
| `driving_gradient_end` | #FFFFFF | #131417 | 미확인 (`null`) |
| `gleo_surface_secondary` | #131417 @ 5% | #131417 @ 20% | 미확인 (`null`) |
| `gleo_bubble_primary` | #9BA8E2 | #545F93 | 미확인 (`null`) |
| `gleo_bubble_secondary` | #8896D3 | #3E4976 | 미확인 (`null`) |
| `gleo_bubble_tertiary` | #FFFFFF | #313236 | 미확인 (`null`) |
| `gleo_bubble_speaker` | #3F4B81 | #B6C1F3 | 미확인 (`null`) |
| `informative_negative` | #FE3D16 | #FF4C28 | 미확인 (`null`) |
| `regulation_yellow` | #FFC224 | #FFC224 | 미확인 (`null`) |
| `regulation_bluetooth` | #0082FC | #0082FC | 미확인 (`null`) |
| `surface_low` | #F7F8FA | #131417 | 미확인 (`null`) |

## 웹에 없는 Divider: Figma 보완값

최신 웹 Colors 표에는 Divider category와 `divider_primary/secondary/tertiary` 행이 없다. 다음은 assets의 주 Color collection `2:15157`에 저장된 확정된 보완 역할이다. 웹 primitive를 재사용하되 **Divider 역할 자체의 출처는 Figma**로 표시한다.

| Figma 역할 → 코드 이름 | Node ID | 양 모드 alias target | Light | Dark |
| --- | --- | --- | --- | --- |
| `divider/primary` → `divider_primary` | 67:4945 | `basic_alpha_dark_50` | #131417 @ 5% | #FFFFFF @ 5% |
| `divider/secondary` → `divider_secondary` | 67:5023 | `basic_alpha_dark_100` | #131417 @ 10% | #FFFFFF @ 10% |
| `divider/tertiary` → `divider_tertiary` | 67:5024 | `basic_alpha_dark_200` | #131417 @ 20% | #FFFFFF @ 20% |

다른 collection `39667:4700`의 `color/divider/secondary`(39667:4702)는 브랜드별 모드와 20% alpha를 포함한 별도 imported 변수다. 위 주 collection의 `divider/secondary`(10%)와 이름만으로 병합하지 않는다. 일반 컴포넌트 `02`·`03`의 `divider/secondary`는 위 67:5023을 참조한다.

## 웹에 기록된 Old name alias 9개

| 원문 Old name | 최신 canonical | 적용 범위 |
| --- | --- | --- |
| `button-basic-active-enabled` | `button_switch_enabled` | metadata·입력 이름 호환 |
| `button-basic-active-pressed` | `button_switch_pressed` | metadata·입력 이름 호환 |
| `button-basic-active-disabled` | `button_switch_disabled` | metadata·입력 이름 호환 |
| `ambient_ai_surface_primary` | `gleo_surface_primary` | metadata·입력 이름 호환 |
| `ambient_ai_surface_secondary` | `gleo_surface_secondary` | metadata·입력 이름 호환 |
| `ambient_ai_bubble_primary` | `gleo_bubble_primary` | metadata·입력 이름 호환 |
| `ambient_ai_bubble_secondary` | `gleo_bubble_secondary` | metadata·입력 이름 호환 |
| `ambient_ai_bubble_tertiary` | `gleo_bubble_tertiary` | metadata·입력 이름 호환 |
| `ambient_ai_bubble_speaker` | `gleo_bubble_speaker` | metadata·입력 이름 호환 |

Icon/Text 웹 PNG의 하단 4행은 위쪽과 `dark` 이름이 중복된다. 그 `sourceToken` 문자열을 전역 alias로 등록하면 올바른 dark 토큰을 덮게 된다. 이 중복 문자열은 원문 행 위치로만 식별하고, 하단 행의 canonical `icon_light_*`/`text_light_*`를 사용한다.

## 직접 대응표에 사용되지 않은 Figma COLOR 변수 82개

이 목록은 웹 미정의 변수만의 목록이 아니다. 같은 역할의 과거 이름/다른 collection, 디자인 도구용 토큰 및 추가 역할이 포함된다. 전체 이름을 최신 웹 API로 자동 공개하거나, 같은 HEX라는 이유로 canonical에 임의 합치지 않는다. 위에서 명시한 Divider 3개 외에 이 목록의 값이 필요하면 원본 collection/key 및 실제 컴포넌트 참조를 확인해 `[첨부 보완]` 여부를 기록한다. 최신 웹 값과 충돌하는 구버전 값은 재적용하지 않는다.

| Figma 이름 | Node ID | Collection ID | 판정 |
| --- | --- | --- | --- |
| `Gray/50` | 1:34 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `GrayAlpha/100` | 1:35 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Static/white-primary` | 1:80 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Gray/00` | 67:5029 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Miscellaneous/Textfields/background` | 67:5030 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Button/Call/accept-normal` | 67:5073 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Button/Call/end-normal` | 67:5075 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Surface/container` | 67:5078 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Informative/active` | 67:5079 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Miscellaneous/Switch/background-on` | 67:5080 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Gray/900` | 67:5083 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Miscellaneous/Switch/button-on` | 67:5084 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Gray/400` | 67:5085 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Miscellaneous/Switch/button-off` | 67:5086 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `GrayAlpha/200` | 67:5087 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Miscellaneous/Switch/button-disabled` | 67:5088 | 1:33 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Color/Base/Black` | 1:4751 | 1:4750 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Color/Base/White` | 1:4752 | 1:4750 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Color/Cool Gray/200` | 1:4766 | 1:4750 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Color/Cool Gray/700` | 1:4767 | 1:4750 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Color/Cool Gray/500` | 1:4769 | 1:4750 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Color/Cool Gray/300` | 1:4813 | 1:4750 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Color/Cool Gray/100` | 1:4815 | 1:4750 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Color/Cool Gray/800` | 1:4816 | 1:4750 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Text/text-primary` | 1:4754 | 1:4753 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Icon/icon-primary` | 1:4757 | 1:4753 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Border/border-primary` | 1:4768 | 1:4753 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Icon/icon-secondary` | 1:4770 | 1:4753 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Text/text-secondary` | 1:4772 | 1:4753 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Text/text-primary-muted` | 1:4814 | 1:4753 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Border/border-primary-muted` | 1:4817 | 1:4753 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Gray/900` | 1:5957 | 1:5956 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Icon/gray-primary` | 1:5958 | 1:5956 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Regulation/blue` | 1:6088 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Regulation/red` | 1:6089 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Gray/900` | 1:6091 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Icon/gray-primary` | 1:6092 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Feature/Driving/Normal/Alert` | 1:6094 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Feature/Driving/Normal/Warning` | 1:6096 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Gray/00` | 1:6097 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Icon/white-primary` | 1:6098 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Feature/Driving/Normal/Positive` | 1:6099 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Legacy/Scale/White/White` | 1:6100 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Informative/autonomous driving` | 1:6102 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `System/Grayscale/Opaque/White` | 1:6103 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `System/Grayscale/Opaque/Black` | 1:6104 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Feature/Driving/Normal/Danger` | 1:6105 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Legacy/Scale/Black/Black` | 67:14533 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Button/Call/end-normal` | 67:14534 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Legacy/Solid/Cool/900` | 67:14535 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Button/Call/accept-normal` | 67:14536 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Icon/gray-tertiary` | 67:14537 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Icon/gray-quaternary` | 67:14580 | 1:6087 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `color/basic/00` | 1:6455 | 67:15011 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `color/basic/900` | 1:6456 | 67:15011 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `static/light/100` | 67:15008 | 67:15011 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `static/dark/100` | 67:15009 | 67:15011 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `icon/light/primary` | 67:15010 | 67:15011 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `icon/dark/primary` | 67:22192 | 67:15011 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Legacy/Scale/Black/Black` | 67:28961 | 67:15011 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `static/dark/100` | 67:28962 | 67:15011 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `static/light/100` | 67:28963 | 67:15011 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `icon/dark/primary` | 67:28964 | 67:15011 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `divider/primary` | 67:4945 | 2:15157 | 웹 역할 미정의; 위 Figma 보완표 적용 |
| `divider/secondary` | 67:5023 | 2:15157 | 웹 역할 미정의; 위 Figma 보완표 적용 |
| `divider/tertiary` | 67:5024 | 2:15157 | 웹 역할 미정의; 위 Figma 보완표 적용 |
| `_System/Brand/Primary/Normal` | 67:15012 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Legacy/Scale/Black/Black` | 67:15062 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Legacy/Scale/White/White` | 67:15071 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Legacy/Solid/Warm/300` | 67:15072 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Legacy/Solid/Cool/900` | 67:22191 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Brand/Teritary/Black` | 67:24416 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Feature/Driving/Normal/Positive` | 67:25571 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `System/Grayscale/Opaque/White` | 67:25572 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `color/feature/driving_view/mask/subtle_secondary` | 67:29027 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `color/feature/driving_view/mask/filled_secondary` | 67:29028 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `_Legacy/Solid/Cool/500` | 67:33983 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Common/Empty/Content` | 67:33984 | 2:15157 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `gleo_blue` | 67:15074 | 67:15073 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `color/alpha/dark/200` | 39667:4701 | 39667:4700 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `color/divider/secondary` | 39667:4702 | 39667:4700 | 직접 canonical 매핑 미확정; 원본 별도 보존 |
| `Color/Neutral/60` | 39667:4704 | 39667:4703 | 직접 canonical 매핑 미확정; 원본 별도 보존 |

## 기계 검증 결과

- 149개 canonical 이름은 모두 고유하다.
- 직접 대응한 127개 Node ID가 모두 assets COLOR 변수 목록에 존재하며 원본 이름이 일치한다.
- 대응한 127개 행 모두 variable key, collection ID/key, 원본 파일명이 JSON에 있다.
- 미확인 22행의 ID/name/key/collection은 명시적인 null이다. 임의 ID를 생성하지 않았다.
- 대응 127개 + 잔여 82개 = assets COLOR 209개이며, 동일 이름의 다른 collection을 제거하지 않았다.
- 이 작업은 metadata만 보강했다. Colors 표의 최신 웹 RGB, alpha, alias target, 원문명 및 웹 우선 충돌 결정을 변경하지 않았다.
