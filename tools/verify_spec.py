"""동봉 입력, 생성 자산, 라이브러리 경계를 검사합니다. 외부 접속이 없습니다."""
from pathlib import Path
import hashlib,json,re,xml.etree.ElementTree as ET,zipfile,io
R=Path(__file__).resolve().parents[1];D=R/'docs'
def check(condition,message):
 if not condition: raise AssertionError(message)
count=0
for line in (D/'SHA256SUMS.txt').read_text().splitlines():
 if not line.strip():continue
 digest,name=line.split(None,1);p=D/name.strip().removeprefix('*')
 check(p.is_file(),f'Missing input: {name}')
 check(hashlib.sha256(p.read_bytes()).hexdigest()==digest,f'Changed input: {name}');count+=1
all_tokens=[]
for fn,expected in [('figma_asset_tokens.json',722),('figma_display_tokens.json',1009)]:
 tokens=json.loads((D/'data'/fn).read_text());check(len(tokens)==expected,fn)
 ids={t['id'] for t in tokens};check(len(ids)==len(tokens),'Duplicate source ID')
 for t in tokens:
  for e in t['resolved'].values():
   check(e['status']=='resolved','Unresolved alias')
   check(len(e['chain'])==len(set(e['chain'])),'Alias cycle')
   check(all(i in ids for i in e['chain']),'Unresolved chain')
 all_tokens+=tokens
web=json.loads((D/'data/web_color_tokens.json').read_text());check(len(web['primitives'])==31 and len(web['semantics'])==118,'Web color coverage')
colors=(R/'pleos-tokens/src/main/java/com/jade/pleos/tokens/GeneratedColors.kt').read_text()
for t in web['primitives']+web['semantics']:check('"'+t['token']+'" to (' in colors,'Missing current color '+t['token'])
manifest=json.loads((D/'assets/icons/manifest.json').read_text());paths=0
for entry in manifest:
 source=ET.parse(D/'assets/icons'/entry['file']).getroot();ns='{http://www.w3.org/2000/svg}'
 n=sum(1 for _ in source.iter(ns+'path'));check(n==entry['pathCount'],'SVG path count');paths+=n
 resource='pleos_'+re.sub('[^a-z0-9_]','_',Path(entry['file']).stem.lower())+'.xml'
 vector=ET.parse(R/'pleos-compose/src/main/res/drawable'/resource).getroot()
 check(sum(1 for _ in vector.iter('path'))==n,'Vector path count')
check(len(manifest)==80 and paths==217,'Icon coverage')
check((R/'pleos-tokens/src/main/res/font/asta_sans_variable.ttf').read_bytes()==(D/'assets/fonts/asta_sans_variable.ttf').read_bytes(),'Font changed')
check(len(json.loads((R/'tools/spec_inventory.json').read_text()))==302,'Master inventory')
settings=(R/'settings.gradle.kts').read_text();check('include(":pleos-tokens", ":pleos-compose", ":pleos-aaos")' in settings,'Module set')
check(not (R/'app').exists() and not (R/'catalog').exists(),'Unexpected app module')
ns='{http://schemas.android.com/apk/res/android}'
for module in ['pleos-tokens','pleos-compose','pleos-aaos']:
 tree=ET.parse(R/module/'src/main/AndroidManifest.xml').getroot()
 check(not list(tree.iter('uses-permission')),'Injected permission')
 check(not list(tree.iter('service')) and not list(tree.iter('activity')),'Injected component')
 for p in (R/module/'src/main/java').rglob('*.kt'):
  text=p.read_text();check('TODO(' not in text and 'NotImplementedError' not in text,'Incomplete source '+str(p))
  if module!='pleos-aaos':check('import android.car.' not in text,'Car dependency leaked')
  check(not re.search('[\u3040-\u30ff\u3400-\u4dbf\u4e00-\u9fff]',text),'Unexpected non-Hangul CJK in authored source '+str(p))
 aar=R/module/'build/outputs/aar'/f'{module}-release.aar'
 if aar.exists():
  with zipfile.ZipFile(aar) as z:
   check(not re.search(b'<uses-permission',z.read('AndroidManifest.xml')),'AAR permission')
   with zipfile.ZipFile(io.BytesIO(z.read('classes.jar'))) as classes:check(any(n.endswith('.class') for n in classes.namelist()),'Empty AAR '+module)
print(json.dumps({'status':'PASS','inputHashes':count,'sourceTokens':len(all_tokens),'webColors':149,'icons':80,'paths':paths,'masterFixtures':302,'modules':3},ensure_ascii=False))
