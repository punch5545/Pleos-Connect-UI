"""동봉 자료만 사용하는 결정적 코드 생성기. 실행: python3 tools/generate_spec.py"""
from pathlib import Path
import json, re, shutil, math, xml.etree.ElementTree as ET
R=Path(__file__).resolve().parents[1]
D=R/'docs'
T=R/'pleos-tokens/src/main/java/com/jade/pleos/tokens'
T.mkdir(parents=True,exist_ok=True)
C=R/'pleos-compose/src/main/java/com/jade/pleos/compose'
C.mkdir(parents=True,exist_ok=True)
def q(s): return json.dumps(s,ensure_ascii=True).replace('\\u0008','\\b')
def num(x): return str(float(x))+'f'
web=json.loads((D/'data/web_color_tokens.json').read_text())
rows=web['primitives']+web['semantics']
a=json.loads((D/'data/web_color_alias_mapping.json').read_text())
colors=[]; aliases={}
for x in rows:
 def co(mode):
  c=x[mode];h=c['rgb'].lstrip('#');return f'Color(0xFF{h}).copy(alpha = {num(c["alpha"])})'
 colors.append(f'    {q(x["token"])} to ({co("light")} to {co("dark")})')
 if x.get('figmaName'): aliases[x['figmaName']]=x['token']
# 정확한 source mapping을 우선하고 웹 단독 행의 명시적 namespace 별칭을 보완합니다.
canonical_names={x['token'] for x in rows}
for x in rows:
 name=x['token']; aliases.setdefault(name.replace('_','/',1),name)
for x in json.loads((D/'data/figma_asset_tokens.json').read_text()):
 if x['setId']=='2:15157' and x['type']=='COLOR':
  candidate=x['name'].replace('/','_').lower()
  if candidate in canonical_names: aliases.setdefault(x['name'],candidate)
for x in a['supplementalDividers']:
 assert x['lightTarget']==x['darkTarget']
 aliases[x['figmaName']]=x['lightTarget']
 aliases[x['codeToken']]=x['lightTarget']
for name,token in list(aliases.items()): aliases.setdefault(name.lower(),token)
(R/'tools/token_aliases.json').write_text(json.dumps(aliases,ensure_ascii=False,indent=2)+'\n')
(T/'GeneratedColors.kt').write_text('''// tools/generate_spec.py에서 생성. 웹 최종값만 런타임 색상으로 사용합니다.
package com.jade.pleos.tokens
import androidx.compose.ui.graphics.Color
internal val webColors: Map<String, Pair<Color, Color>> = mapOf(
'''+',\n'.join(colors)+'\n)\ninternal val sourceColorAliases = mapOf(\n'+',\n'.join('    '+q(k)+' to '+q(v) for k,v in sorted(aliases.items()))+'\n)\n')
all_tokens=[]
for fn,source in [('figma_asset_tokens.json','Assets'),('figma_display_tokens.json','Display')]:
 tokens=json.loads((D/'data'/fn).read_text())
 ids={x['id']:x for x in tokens}
 for x in tokens:
  assert all(v['status']=='resolved' for v in x['resolved'].values())
  for mid,entry in x['resolved'].items():
   chain=entry['chain'];assert len(chain)==len(set(chain)),(source,x['id'],chain)
   assert all(i in ids for i in chain)
  all_tokens.append((source,x))
 # 원본 JSON에는 raw alias와 정규화 기록을 보존합니다.
 target=R/'pleos-tokens/src/main/assets/pleos/source'
 target.mkdir(parents=True,exist_ok=True)
 shutil.copyfile(D/'data'/fn,target/fn)
for source_file in (D/'data').glob('*.json'):
 if not source_file.name.startswith('figma_'): shutil.copyfile(source_file,target/source_file.name)
# 모든 source 식별자와 실제 모드값, collection 경계를 보존합니다.
parts=[]
for start in range(0,len(all_tokens),70):
 n=start//70;part=[]
 for source,x in all_tokens[start:start+70]:
  vals=[]
  for mid,mname in x['modes'].items():
   if mid not in x['resolved']: continue
   v=x['resolved'][mid]['value'];mname=''.join(c for c in mname if ord(c)>=32)
   if 'floatValue' in v: value=f'TokenValue.Number({num(v["floatValue"])})'
   elif 'colorValue' in v:
    c=v['colorValue'];value='TokenValue.Rgba('+','.join(num(c[k]) for k in ['r','g','b','a'])+')'
   else: value='TokenValue.Text('+q(v.get('textValue',v.get('stringValue',str(v))))+')'
   vals.append(q(mname)+' to '+value)
  part.append(f'    SourceToken(SourceFile.{source}, {q(x["id"])}, {q(x["key"])}, {q(x["setId"])}, {q(x["setKey"])}, {q(x["name"])}, mapOf('+', '.join(vals)+'))')
 (T/f'GeneratedSource{n}.kt').write_text('package com.jade.pleos.tokens\ninternal fun sourcePart'+str(n)+'(): List<SourceToken> = listOf(\n'+',\n'.join(part)+'\n)\n')
 parts.append(f'sourcePart{n}()')
(T/'GeneratedSourceIndex.kt').write_text('package com.jade.pleos.tokens\ninternal val generatedSourceTokens: List<SourceToken> by lazy { '+ ' + '.join(parts)+' }\n')
# 동봉 폰트와 출처를 보존합니다.
res=R/'pleos-tokens/src/main/res/font';res.mkdir(parents=True,exist_ok=True)
shutil.copyfile(D/'assets/fonts/asta_sans_variable.ttf',res/'asta_sans_variable.ttf')
lic=R/'pleos-tokens/src/main/assets/pleos/licenses';lic.mkdir(parents=True,exist_ok=True)
for p in (D/'assets/fonts').glob('*'):
 if p.suffix!='.ttf': shutil.copyfile(p,lic/p.name)
# SVG 행렬을 검사하고 VectorDrawable 그룹으로 옮깁니다.
ns='{http://www.w3.org/2000/svg}';an='{http://schemas.android.com/apk/res/android}'
ET.register_namespace('android','http://schemas.android.com/apk/res/android')
icons=json.loads((D/'assets/icons/manifest.json').read_text());items=[]
for ico in icons:
 p=D/'assets/icons'/ico['file'];s=ET.parse(p).getroot();vb=list(map(float,s.attrib['viewBox'].split()))
 name='pleos_'+re.sub('[^a-z0-9_]', '_',p.stem.lower())
 directional='ic_arrow_direction_left' in name or 'ic_arrow_direction_right' in name
 v=ET.Element('vector',{an+'width':str(vb[2])+'dp',an+'height':str(vb[3])+'dp',an+'viewportWidth':str(vb[2]),an+'viewportHeight':str(vb[3]),an+'autoMirrored':str(directional).lower()})
 def visit(node,parent):
  tag=node.tag.removeprefix(ns)
  if tag in ['title','desc']: return
  tr=node.get('transform','')
  if tag=='g':
   attrs={}
   if tr:
    a,b,c,d,e,f=map(float,re.search(r'matrix\((.*?)\)',tr).group(1).replace(',',' ').split())
    sx=math.hypot(a,b); sy=(a*d-b*c)/sx
    assert abs(a*c+b*d)<1e-4,(p,tr)
    attrs={an+'scaleX':str(sx),an+'scaleY':str(sy),an+'rotation':str(math.degrees(math.atan2(b,a))),an+'translateX':str(e),an+'translateY':str(f)}
   g=ET.SubElement(parent,'group',attrs)
   for child in node: visit(child,g)
  elif tag=='path':
   at={an+'pathData':node.attrib['d'],an+'fillType':'evenOdd' if node.get('fill-rule')=='evenodd' else 'nonZero'}
   for src,dst in [('fill','fillColor'),('stroke','strokeColor')]:
    val=node.get(src)
    if val and val!='none': at[an+dst]=val
   if node.get('fill')=='none': at[an+'fillColor']='#00000000'
   for src,dst in [('fill-opacity','fillAlpha'),('stroke-opacity','strokeAlpha'),('stroke-width','strokeWidth'),('stroke-linecap','strokeLineCap'),('stroke-linejoin','strokeLineJoin')]:
    if src in node.attrib: at[an+dst]=node.attrib[src]
   ET.SubElement(parent,'path',at)
  else: raise ValueError((p,tag))
 for child in s: visit(child,v)
 out=R/'pleos-compose/src/main/res/drawable';out.mkdir(parents=True,exist_ok=True)
 ET.indent(v);ET.ElementTree(v).write(out/(name+'.xml'),encoding='utf-8',xml_declaration=True)
 kotlin_name=re.sub('[^A-Za-z0-9]','_',ico['name'])+'_'+ico['id'].replace(':','_')
 items.append(f'    val {kotlin_name}: Int = R.drawable.{name}')
(C/'PleosIcons.kt').write_text('package com.jade.pleos.compose\n/** 동봉 SVG 원본 ID를 보존한 리소스입니다. */\nobject PleosIcons {\n'+'\n'.join(items)+'\n}\n')
# 모든 component master를 검증 fixture 및 추적 자료로 보존합니다.
masters=[]
for p in sorted((D/'appendices/figma_components').glob('*.md')):
 text=p.read_text();chunks=re.split(r'^## ',text,flags=re.M)
 for ch in chunks[1:]:
  ids=re.search(r'원본 node: `([^`]+)`',ch)
  if ids:
   root=next((l for l in ch.splitlines() if '| SYMBOL |' in l),'')
   masters.append({'file':p.name,'name':ch.splitlines()[0],'id':ids[1],'root':root})
(R/'tools/spec_inventory.json').write_text(json.dumps(masters,ensure_ascii=False,indent=2)+'\n')
print(f'Generated {len(rows)} current colors, {len(all_tokens)} source tokens, {len(icons)} vectors, {len(masters)} master fixtures.')
