/*
 *
 *     Copyright (C) 2025 Macweese <https://www.github.com/Macweese>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package challenge.medium.vowelSpellChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class VowelSpellcheckerTest
{
	private static final Triple[] T = new Triple[]{
		new ImmutableTriple(new String[]{"final"}, new String[]{"finl"}, new String[]{""}),
		new ImmutableTriple(new String[]{"common"}, new String[]{"oMoC"}, new String[]{""}),
		new ImmutableTriple(new String[]{"bank"}, new String[]{"bAynGk"}, new String[]{""}),
		new ImmutableTriple(new String[]{"save","phone"}, new String[]{"savBe"}, new String[]{""}),
		new ImmutableTriple(new String[]{"need"}, new String[]{"need","ee"}, new String[]{"need",""}),
		new ImmutableTriple(new String[]{"glass","court"}, new String[]{"court"}, new String[]{"court"}),
		new ImmutableTriple(new String[]{"hair","born"}, new String[]{"Dar","oRMn"}, new String[]{"",""}),
		new ImmutableTriple(new String[]{"year"}, new String[]{"ar","yar","year"}, new String[]{"","","year"}),
		new ImmutableTriple(new String[]{"teach","hot","leader"}, new String[]{"leader"}, new String[]{"leader"}),
		new ImmutableTriple(new String[]{"bar","cancer","final"}, new String[]{"bkDA","FiNa"}, new String[]{"",""}),
		new ImmutableTriple(new String[]{"life","as"}, new String[]{"life","has","Rs"}, new String[]{"life","",""}),
		new ImmutableTriple(new String[]{"gas","room"}, new String[]{"room","agas","GA"}, new String[]{"room","",""}),
		new ImmutableTriple(new String[]{"lot","ever","visit","other","body"}, new String[]{"oDy"}, new String[]{""}),
		new ImmutableTriple(new String[]{"admit","state","father","Mr","deal"}, new String[]{"MHr"}, new String[]{""}),
		new ImmutableTriple(new String[]{"six","share","page","where"}, new String[]{"we","Six"}, new String[]{"","six"}),
		new ImmutableTriple(new String[]{"final","affect","pain"}, new String[]{"Wfnal","pain"}, new String[]{"","pain"}),
		new ImmutableTriple(new String[]{"speech","add"}, new String[]{"aDGd","espeech","sGPeec"}, new String[]{"","",""}),
		new ImmutableTriple(new String[]{"table","store"}, new String[]{"aBWl","store","stfoe"}, new String[]{"","store",""}),
		new ImmutableTriple(new String[]{"past","field","late","shoot","along","you"}, new String[]{"PlAte"}, new String[]{""}),
		new ImmutableTriple(new String[]{"deep","what","free","too","fall"}, new String[]{"o","fRee"}, new String[]{"","free"}),
		new ImmutableTriple(new String[]{"player","decade","wind","class"}, new String[]{"clasxS","cOadE"}, new String[]{"",""}),
		new ImmutableTriple(new String[]{"home"}, new String[]{"hoME","Whome","hoMe","JhmE"}, new String[]{"home","","home",""}),
		new ImmutableTriple(new String[]{"check","wonder","bill","gas"}, new String[]{"bill","wonDePr"}, new String[]{"bill",""}),
		new ImmutableTriple(new String[]{"result","finish","alone","low","fish","while"}, new String[]{"lzZoW"}, new String[]{""}),
		new ImmutableTriple(new String[]{"wait","option","song","meet"}, new String[]{"Mee","swaiT","mee"}, new String[]{"","",""}),
		new ImmutableTriple(new String[]{"lead","window","low","four","these","else","want"}, new String[]{"ewt"}, new String[]{""}),
		new ImmutableTriple(new String[]{"what","the","pay","media","sort","check","price"}, new String[]{"meda"}, new String[]{""}),
		new ImmutableTriple(new String[]{"boy","every","answer"}, new String[]{"boyy","eVeRy","boy"}, new String[]{"","every","boy"}),
		new ImmutableTriple(new String[]{"middle","me","coach","note"}, new String[]{"WcOach","Ne","Mcoach"}, new String[]{"","",""}),
		new ImmutableTriple(new String[]{"must","lay","how","son","remain","easy"}, new String[]{"OYn","musNt"}, new String[]{"",""}),
		new ImmutableTriple(new String[]{"effect","spend","expect"}, new String[]{"sIEnqd","Eppecx","ffecT"}, new String[]{"","",""}),
		new ImmutableTriple(new String[]{"result","job","wall","safe"}, new String[]{"TL","safe","saWFE"}, new String[]{"","safe",""}),
		new ImmutableTriple(new String[]{"plant","around","Mr","mouth","anyone"}, new String[]{"arKeHon","awroud"}, new String[]{"",""}),
		new ImmutableTriple(new String[]{"grow","can","enjoy"}, new String[]{"row","groW","grBow","cyn"}, new String[]{"","grow","",""}),
		new ImmutableTriple(new String[]{"even","treat","turn","dream","sort","me"}, new String[]{"KdrHeam","sqOT"}, new String[]{"",""}),
		new ImmutableTriple(new String[]{"half","box","mind"}, new String[]{"haQmlf","vox","mMNd","half"}, new String[]{"","","","half"}),
		new ImmutableTriple(new String[]{"far","short"}, new String[]{"FqAR","shoRT","shorT","Dar"}, new String[]{"","short","short",""}),
		new ImmutableTriple(new String[]{"seek","feel","wind","fear"}, new String[]{"seek","fer","WsbeckEk"}, new String[]{"seek","",""}),
		new ImmutableTriple(new String[]{"ball","middle","hot","age","return","shot"}, new String[]{"hAot","age"}, new String[]{"","age"}),
		new ImmutableTriple(new String[]{"drive","form","still","player"}, new String[]{"still","dVE","rIe"}, new String[]{"still","",""}),
		new ImmutableTriple(new String[]{"win","lead","must","leave"}, new String[]{"WJN","leave","lead"}, new String[]{"","leave","lead"}),
		new ImmutableTriple(new String[]{"good","tax","best","these","help"}, new String[]{"tEQI","gooSd","tax"}, new String[]{"","","tax"}),
		new ImmutableTriple(new String[]{"stay","read","each","office","meet","allow","all","Mr"}, new String[]{"read"}, new String[]{"read"}),
		new ImmutableTriple(new String[]{"might","author","parent"}, new String[]{"parEnt","rT","parent"}, new String[]{"parent","","parent"}),
		new ImmutableTriple(new String[]{"short","keep","occur","for","seat"}, new String[]{"gep","seat","keep"}, new String[]{"","seat","keep"}),
		new ImmutableTriple(new String[]{"pull","firm","TV","the","we","cup","third","Mr","reduce","per"}, new String[]{"Mrr"}, new String[]{""}),
		new ImmutableTriple(new String[]{"second","movie"}, new String[]{"movie","SwncOnLd","second","ove"}, new String[]{"movie","","second",""}),
		new ImmutableTriple(new String[]{"tough","tax","to","all","heat","health","fact","begin"}, new String[]{"To","tug"}, new String[]{"to",""}),
		new ImmutableTriple(new String[]{"avoid","human","study","must","degree","year","answer"}, new String[]{"bmsnt","yr"}, new String[]{"",""}),
		new ImmutableTriple(new String[]{"five","point","food","energy"}, new String[]{"fgive","piSNXt","OFfve","Fbood"}, new String[]{"","","",""}),
		new ImmutableTriple(new String[]{"edge","worker","oil","find"}, new String[]{"woArke","jfin","WeorAmkeV","eGdg"}, new String[]{"","","",""}),
		new ImmutableTriple(new String[]{"throw","course","give","woman"}, new String[]{"thrw","throw","course"}, new String[]{"","throw","course"}),
		new ImmutableTriple(new String[]{"finger","agree","claim","safe","gun"}, new String[]{"QRE","haewe","cAIM","fgr"}, new String[]{"","","",""}),
		new ImmutableTriple(new String[]{"fall","take","onto","though","first","before"}, new String[]{"aMlhKl","ThzgH","Oo"}, new String[]{"","",""}),
		new ImmutableTriple(new String[]{"that","each","well","talk"}, new String[]{"zthat","ch","NeLl","MJea","wLdml"}, new String[]{"","","","",""}),
		new ImmutableTriple(new String[]{"how"}, new String[]{"yNhoR","qow","how","hOw","Cow","hBow","hPw"}, new String[]{"","","how","how","","",""}),
		new ImmutableTriple(new String[]{"tend"}, new String[]{"tepnd","tend","tZienmd","tend","tenGd","ted"}, new String[]{"","tend","","tend","",""}),
		new ImmutableTriple(new String[]{"her","with","later","might","avoid","suffer","class","their","bank"}, new String[]{"mght"}, new String[]{""}),
		new ImmutableTriple(new String[]{"rather","hope","tax","name","buy","accept","sort","little","site"}, new String[]{"bUy"}, new String[]{"buy"}),
		new ImmutableTriple(new String[]{"report","eat","bit","room"}, new String[]{"report","et","report","et"}, new String[]{"report","","report",""}),
		new ImmutableTriple(new String[]{"alone","early","write","indeed","hope","best"}, new String[]{"best","indeE","sLt"}, new String[]{"best","",""}),
		new ImmutableTriple(new String[]{"state","it","him","remove","put","one","loss","kill","agent","tree"}, new String[]{"him"}, new String[]{"him"}),
		new ImmutableTriple(new String[]{"near","image","born","likely","hot","focus","save","own"}, new String[]{"near","HtoT"}, new String[]{"near",""}),
		new ImmutableTriple(new String[]{"item","few","bring","office","draw","cancer","out","idea"}, new String[]{"oMt","item"}, new String[]{"","item"}),
		new ImmutableTriple(new String[]{"then","stay","need","side","model","baby","field","room","from","them"}, new String[]{"Bvkby"}, new String[]{""}),
		new ImmutableTriple(new String[]{"from","watch","health","three"}, new String[]{"shree","ealth","HNeacth","witch"}, new String[]{"","","","watch"}),
		new ImmutableTriple(new String[]{"win","cut","step"}, new String[]{"sT","win","w","sTep","CUt","cut"}, new String[]{"","win","","step","cut","cut"}),
		new ImmutableTriple(new String[]{"than","late"}, new String[]{"plaTxNe","gActe","late","thDZAN","DulaTe","lae"}, new String[]{"","","late","","",""}),
		new ImmutableTriple(new String[]{"real","why","base","per","order","art","leader","fund","will"}, new String[]{"funD","Petr"}, new String[]{"fund",""}),
		new ImmutableTriple(new String[]{"detail","rather","now","admit","each","adult","six","again"}, new String[]{"si","sidx","OVIx"}, new String[]{"","",""}),
		new ImmutableTriple(new String[]{"sense","hour","ready","budget","group","cancer"}, new String[]{"kCancer","sEnFse","ReaDY"}, new String[]{"","","ready"}),
		new ImmutableTriple(new String[]{"choice","others","cell","learn","lot","too","how","expect","feel"}, new String[]{"TOo","epect"}, new String[]{"too",""}),
		new ImmutableTriple(new String[]{"world","force","start","hold"}, new String[]{"start","start","start","istart"}, new String[]{"start","start","start",""}),
		new ImmutableTriple(new String[]{"former","heart","force","market","dark"}, new String[]{"dNARk","dark","hMeaCrPt","HmVCaT"}, new String[]{"","dark","",""}),
		new ImmutableTriple(new String[]{"chair","few","get","there","office","result","either","pay"}, new String[]{"few","resu","paiy"}, new String[]{"few","",""}),
		new ImmutableTriple(new String[]{"people","short","time","meet","order","next","event","reach","claim"}, new String[]{"Ne","Short"}, new String[]{"","short"}),
		new ImmutableTriple(new String[]{"middle","thank","return","guy"}, new String[]{"tnk","gBuy","sgUY","REturWrKn","tRn","rtr"}, new String[]{"","","","","",""}),
		new ImmutableTriple(new String[]{"trade","her","hit"}, new String[]{"gtRde","trade","Trde","hit","trade","hBer"}, new String[]{"","trade","","hit","trade",""}),
		new ImmutableTriple(new String[]{"fast","thing","keep","half","image","school","skin","first","within","lead"}, new String[]{"Kjp","lEA"}, new String[]{"",""}),
		new ImmutableTriple(new String[]{"ready","wall","cut","fly","answer","safe","rule","attack","turn","for"}, new String[]{"GsaBYxFe","rEad"}, new String[]{"",""}),
		new ImmutableTriple(new String[]{"art"}, new String[]{"Fart","AGr","Aprt","Mamt","art","arkt","at","art","SOR"}, new String[]{"","","","","art","","","art",""}),
		new ImmutableTriple(new String[]{"cold","large","field"}, new String[]{"Larg","Ffe","ied","ied","lnarge","cZd","field"}, new String[]{"","","","","","","field"}),
		new ImmutableTriple(new String[]{"skin","order","form","but","lose"}, new String[]{"Iskpin","lose","HosRder","ordFer","but"}, new String[]{"","lose","","","but"}),
		new ImmutableTriple(new String[]{"above","travel","charge","really","you","dream"}, new String[]{"orealLy","traVl","ItraVeZOl","drZa"}, new String[]{"","","",""}),
		new ImmutableTriple(new String[]{"fine"}, new String[]{"Ie","FITe","fie","fine","iNe","Fi","fnE","fine","FZne"}, new String[]{"","","","fine","","","","fine",""}),
		new ImmutableTriple(new String[]{"fine","she","page","too","than","last"}, new String[]{"lAast","kNe","page","lAssSGt","shE"}, new String[]{"","","page","","she"}),
		new ImmutableTriple(new String[]{"find","arrive","hand","scene","strong","voice","miss","future"}, new String[]{"strong","LInd","MW"}, new String[]{"strong","",""}),
		new ImmutableTriple(new String[]{"system","debate","form","adult","rate"}, new String[]{"sysCte","raTe","adlt","dDulZt","fORm"}, new String[]{"","rate","","","form"}),
		new ImmutableTriple(new String[]{"power","huge","early","news","guess","wide"}, new String[]{"owiidlE","widWe","heuge","wFidIE","huEgE"}, new String[]{"","","","",""}),
		new ImmutableTriple(new String[]{"open","care"}, new String[]{"open","cae","care","Yopen","opEn","care","care"}, new String[]{"open","","care","","open","care","care"}),
		new ImmutableTriple(new String[]{"agent","kill"}, new String[]{"kiLl","ageKwnt","kilLl","Lkl","kiLrl","gebNt","geT","kIcll"}, new String[]{"kill","","","","","","",""}),
		new ImmutableTriple(new String[]{"clear","put","me","lot","truth","come","show","theory","those"}, new String[]{"theory","qtogns","comPE"}, new String[]{"theory","",""}),
		new ImmutableTriple(new String[]{"past","behind"}, new String[]{"fpAQs","pArT","Tbehkid","eHnD","behind","bfhn","behind"}, new String[]{"","","","","behind","","behind"}),
		new ImmutableTriple(new String[]{"or","arrive","source","throw"}, new String[]{"sor","or","souRccE","OuRce","tmHrow","rIwvE","or"}, new String[]{"","or","","","","","or"}),
		new ImmutableTriple(new String[]{"while","spring","likely"}, new String[]{"sPring","WIl","LIkeely","blikely","whiLe","wHilee"}, new String[]{"spring","","","","while",""}),
		new ImmutableTriple(new String[]{"one","last"}, new String[]{"sT","oNUe","DlasT","o","lAsft","ne","oe","Ast","last","oE"}, new String[]{"","","","","","","","","last",""}),
		new ImmutableTriple(new String[]{"office","paper","shake","inside","his","into","ever","turn","job","travel"}, new String[]{"VJe","tRvel","papser"}, new String[]{"","",""}),
		new ImmutableTriple(new String[]{"lawyer","above"}, new String[]{"IawyEr","bove","labwyeR","abZE","lawyer","aBove","IKlwer"}, new String[]{"","","","","lawyer","above",""}),
		new ImmutableTriple(new String[]{"away","lawyer","all","game","human"}, new String[]{"Human","away","xGlaEweR","lAWyer","gam"}, new String[]{"human","away","","lawyer",""}),
		new ImmutableTriple(new String[]{"price","if","upon","decide"}, new String[]{"","prqice","f","upon","Dcide","dVeide","if","Ie"}, new String[]{"","","","upon","","","if",""}),
		new ImmutableTriple(new String[]{"choose","onto","catch","animal","bed"}, new String[]{"bEY","Ach","brEO","choose","atch","cVhEopOSe"}, new String[]{"","","","choose","",""}),
		new ImmutableTriple(new String[]{"also","cup","growth","both","minute","night"}, new String[]{"growbTh","Tgrowth","also","also","MnUt"}, new String[]{"","","also","also",""}),
		new ImmutableTriple(new String[]{"all","draw","never","six","short","this"}, new String[]{"all","six","shor","s","nFMvur","never"}, new String[]{"all","six","","","","never"}),
		new ImmutableTriple(new String[]{"human","any","budget","walk","stock","shot","local","report","within"}, new String[]{"iTin","KpSoT","ST","svtock"}, new String[]{"","","",""}),
		new ImmutableTriple(new String[]{"catch"}, new String[]{"cath","atch","cath","uatkh","CAXtcgh","ah","caTh","cLaTch","atcH","sAtc"}, new String[]{"","","","","","","","","",""}),
		new ImmutableTriple(new String[]{"black","color","laugh","should","push","human","really"}, new String[]{"shJuYl","LcBlcyK","haooulsd","lauGh"}, new String[]{"","","","laugh"}),
		new ImmutableTriple(new String[]{"art","wall","from","area","hair","child"}, new String[]{"fRoRm","Wall","al","ThMaiR","fropm","area"}, new String[]{"","wall","","","","area"}),
		new ImmutableTriple(new String[]{"among","seat","always","cost","put","bit","exist","into"}, new String[]{"bit","exis","bit","bit","Gput"}, new String[]{"bit","","bit","bit",""}),
		new ImmutableTriple(new String[]{"little","not","what","phone","clear","nice","guy","second","stage"}, new String[]{"Oar","pHconE","rDliTVle","lttle"}, new String[]{"","","",""}),
		new ImmutableTriple(new String[]{"free","type","six","hotel","if","his","she","dead","I"}, new String[]{"sI","dead","fEe","sge","his","yi"}, new String[]{"","dead","","","his",""}),
		new ImmutableTriple(new String[]{"figure","remain","chance","risk","public"}, new String[]{"rIRZsk","LpubLIc","pyLiZc","cBfhAnce","wfiRYe","cAnce"}, new String[]{"","","","","",""}),
		new ImmutableTriple(new String[]{"nation"}, new String[]{"naion","ation","natiSon","NatioRn","NJNaon","nation","natxin","naTion"}, new String[]{"","","","","","nation","","nation"}),
		new ImmutableTriple(new String[]{"white","since","moment","weapon","work","minute","win"}, new String[]{"worik","mfoEnWt","WeMkapn","NsINLe","vwheite"}, new String[]{"","","","",""}),
		new ImmutableTriple(new String[]{"method","spring","there"}, new String[]{"mehNod","there","HctheRe","ere","srrQdPg","method","pRIng"}, new String[]{"","there","","","","method",""}),
		new ImmutableTriple(new String[]{"shake","admit","who"}, new String[]{"ShAkje","sHHGake","dmt","dmit","who","shake","ADCnGit","UaDMit"}, new String[]{"","","","","who","shake","",""}),
		new ImmutableTriple(new String[]{"wide","task","very","laugh","set","sexual"}, new String[]{"Zexurl","sexBual","ERrgy","St","vCy","set","voery"}, new String[]{"","","","","","set",""}),
		new ImmutableTriple(new String[]{"by","again","kind","same","note","want","behind","north","vote","tax"}, new String[]{"NnOrth","dFCme","again","KrNd"}, new String[]{"","","again",""}),
		new ImmutableTriple(new String[]{"their","dead","today","large","most"}, new String[]{"toVd","larg","teCIr","Vad","larGe","large","cItoy"}, new String[]{"","","","","large","large",""}),
		new ImmutableTriple(new String[]{"board","can","raise","else","month"}, new String[]{"AcA","raisHae","mOTh","qasE","an","GOmotMh","Mont","czZan"}, new String[]{"","","","","","","",""}),
		new ImmutableTriple(new String[]{"off","legal","travel","light"}, new String[]{"StqrVe","trAel","Htravel","J","leGAl","LgOl","Egal","ClBega"}, new String[]{"","","","","legal","","",""}),
		new ImmutableTriple(new String[]{"hotel","want","young","west","base","same","within","air","too","pay"}, new String[]{"pay","pay","air","asa",""}, new String[]{"pay","pay","air","",""}),
		new ImmutableTriple(new String[]{"and","help","middle","myself","test","indeed","why","where","family"}, new String[]{"e","hre","help","mXrself","jhy"}, new String[]{"","","help","",""}),
		new ImmutableTriple(new String[]{"die","charge","rather","travel","model","it","source","either"}, new String[]{"rVaher","Eher","HPre","die","athheitr"}, new String[]{"","","","die",""}),
		new ImmutableTriple(new String[]{"job","media","use","degree","out"}, new String[]{"uSQPre","oUt","jo","edXia","use","usE","ousE","EgCRee"}, new String[]{"","out","","","use","use","",""}),
		new ImmutableTriple(new String[]{"thank","nor","nor","road","south","price","short","during","type","tend"}, new String[]{"type","duriPxmnEg","nor","nr"}, new String[]{"type","","nor",""}),
		new ImmutableTriple(new String[]{"source","walk","score","your","oil","book","final","sea"}, new String[]{"oil","source","your","your","bIl"}, new String[]{"oil","source","your","your",""}),
		new ImmutableTriple(new String[]{"hand","stage","gas","grow","five","often","mother","lead"}, new String[]{"five","stae","haQPd","stae","EgaS","motWHr"}, new String[]{"five","","","","",""}),
		new ImmutableTriple(new String[]{"the","guess","way","see","bag","thank"}, new String[]{"Guegss","Fbag","Hse","thnk","AthFe","see","guesNs","sveE"}, new String[]{"","","","","","see","",""}),
		new ImmutableTriple(new String[]{"yard","might","these","weapon"}, new String[]{"the","wGeapon","yard","mUighzt","these","Ugt","mSigHT","yar"}, new String[]{"","","yard","","these","","",""}),
		new ImmutableTriple(new String[]{"story","cover","every"}, new String[]{"vE","story","eRy","vegr","EeY","ovEr","PvCvr","KHtoRy","oe","Coer"}, new String[]{"","story","","","","","","","",""}),
		new ImmutableTriple(new String[]{"travel","few","heat","order","world","side","short","plan"}, new String[]{"rer","fe","fjkew","eat","tRave","odPe","hat"}, new String[]{"","","","","","",""}),
		new ImmutableTriple(new String[]{"source","cell","movie","as","lawyer","poor","nation","war","part","act"}, new String[]{"moviE","wair","iI","Per","soure"}, new String[]{"movie","","","",""}),
		new ImmutableTriple(new String[]{"tax","upon","and","why","second","all","allow","fight"}, new String[]{"h","KaWll","wh","jaSlBil","an","tax","all"}, new String[]{"","","","","","tax","all"}),
		new ImmutableTriple(new String[]{"bag","as","ahead","watch"}, new String[]{"wATch","BaUg","Kvach","bag","As","as","EbA","kahead","ahqd"}, new String[]{"watch","","","bag","as","as","","",""}),
		new ImmutableTriple(new String[]{"walk","value","legal","among","other","others","five","pay","term","ever"}, new String[]{"VlAluEDe","oztR","evEr","term"}, new String[]{"","","ever","term"}),
		new ImmutableTriple(new String[]{"prove","guy","author","help","see","carry","modern","check","lot","lawyer","just","state","legal"}, new String[]{"ee","odeXn","USt"}, new String[]{"","",""}),
		new ImmutableTriple(new String[]{"finish","hard","movie","lead","two"}, new String[]{"FinI","LNead","OfInsH","finiskh","eMoVie","fiFWniSh","loead","LE"}, new String[]{"","","","","","","",""}),
		new ImmutableTriple(new String[]{"attack","result","once","book","large","often","car"}, new String[]{"cr","attOAc","ZRreslT","often","CAr","erEulIt"}, new String[]{"","","","often","car",""}),
		new ImmutableTriple(new String[]{"into"}, new String[]{"NO","ntO","ito","inteo","into","into","iNto","into","into","INto"}, new String[]{"","","","","into","into","into","into","into","into"}),
		new ImmutableTriple(new String[]{"way","pay","and","lawyer","speech","parent","season","pretty","focus","step"}, new String[]{"eso","way","parOcTqxent","FocuAs"}, new String[]{"","way","",""}),
		new ImmutableTriple(new String[]{"entire","ok","drop","wish","short","agree","red","plan","future","eat","sex","small","attack","find","join","less"}, new String[]{"reD"}, new String[]{"red"}),
		new ImmutableTriple(new String[]{"every"}, new String[]{"Nevery","EUVNe","every","everD","DvEry","evemrjY","Fer","Eer","QEevery","every"}, new String[]{"","","every","","","","","","","every"}),
		new ImmutableTriple(new String[]{"sort","spend","rest","year","allow","summer","for"}, new String[]{"year","fr","smmer","allow","rest","sort"}, new String[]{"year","","","allow","rest","sort"}),
		new ImmutableTriple(new String[]{"above","she","rock","though"}, new String[]{"rock","RCK","QLhog","QAovFE","aove","nAbOVe","twOUuh","shke","aMve"}, new String[]{"rock","","","","","","","",""}),
		new ImmutableTriple(new String[]{"I","south","letter"}, new String[]{"ELetteR","I","kletwer","souh","I","I","I","letTer","HlEtt","fsouth"}, new String[]{"","I","","","I","I","I","letter","",""}),
		new ImmutableTriple(new String[]{"city","word","east","window","lose","lot","money","stand"}, new String[]{"SmOEy","lot","Kney","StAnD","word","Keat"}, new String[]{"","lot","","stand","word",""}),
		new ImmutableTriple(new String[]{"begin","join","father","share"}, new String[]{"father","join","bgiCn","jin","hao","Eatthier","E","sNHe","Egn"}, new String[]{"father","join","","","","","","",""}),
		new ImmutableTriple(new String[]{"sex","half","among","door","single","cancer","he"}, new String[]{"s","dooR","oor","E","do","sex","seX","canCIeR"}, new String[]{"","door","","","","sex","sex",""}),
		new ImmutableTriple(new String[]{"quite","car","house","close","land","worry","during","line","out"}, new String[]{"quite","IQrI","woXy","QuitE","line"}, new String[]{"quite","","","quite","line"}),
		new ImmutableTriple(new String[]{"appear","later","among","send","could","lay"}, new String[]{"appear","cOuld","among","lAY","COuld","laE"}, new String[]{"appear","could","among","lay","could",""}),
		new ImmutableTriple(new String[]{"unit","order","agency","too","miss","author"}, new String[]{"agency","Iss","orDer","Nit","GaGen","miss","rder"}, new String[]{"agency","","order","","","miss",""}),
		new ImmutableTriple(new String[]{"enter","spring","admit","decade","from","bill","sister","third","game","seek"}, new String[]{"gaymE","from","admit","from"}, new String[]{"","from","admit","from"}),
		new ImmutableTriple(new String[]{"value","event","land"}, new String[]{"eveNPt","land","aRluue","land","land","valNue","Evqent","hUVaue","VENT"}, new String[]{"","land","","land","land","","","",""}),
		new ImmutableTriple(new String[]{"end","letter","mouth","drive","back","alone","build","dog","your","peace"}, new String[]{"msioZUT","yoPur","youMr","aLone","bac"}, new String[]{"","","","alone",""}),
		new ImmutableTriple(new String[]{"free","radio"}, new String[]{"radiuo","fYJkree","fnree","free","radio","radio","fRe","radio","frEe"}, new String[]{"","","","free","radio","radio","","radio","free"}),
		new ImmutableTriple(new String[]{"along","would","item","carry"}, new String[]{"UAYtie","carry","item","alqong","woKuOld","item","woSyld","IIitve"}, new String[]{"","carry","item","","","item","",""}),
		new ImmutableTriple(new String[]{"state","ten","face","too","offer"}, new String[]{"state","fAce","offeR","jTen","tJo","stat","sttajUUTe","ten"}, new String[]{"state","face","offer","","","","","ten"}),
		new ImmutableTriple(new String[]{"wide","laugh","week","little"}, new String[]{"laGh","OlJaugh","week","week","qwidce","auh","lLittBe","lsauKgh","wid"}, new String[]{"","","week","week","","","","",""}),
		new ImmutableTriple(new String[]{"card","plan","wide","my"}, new String[]{"wide","pplAIn","card","wiD","my","crd","plan","wIDe","xcaD",""}, new String[]{"wide","","card","","my","","plan","wide","",""}),
		new ImmutableTriple(new String[]{"trade","early","war","nor","need","just","little"}, new String[]{"war","nol","SjuT","itTtle","elwy","traDE","little"}, new String[]{"war","","","","","trade","little"}),
		new ImmutableTriple(new String[]{"reason"}, new String[]{"NrEEson","aso","easOn","reason","reasOvon","PreSon","reason","easn","reaon","refaSon"}, new String[]{"","","","reason","","","reason","","",""}),
		new ImmutableTriple(new String[]{"add","though","blood","decade","create","gun","toward","fire","among"}, new String[]{"toward","mng","d","gun","ad","dgecade"}, new String[]{"toward","","","gun","",""}),
		new ImmutableTriple(new String[]{"reach","star","hang","often","get","better","next","road"}, new String[]{"DstlaR","nxt","star","oFTen","bedTer","oe","ung"}, new String[]{"","","star","often","","",""}),
		new ImmutableTriple(new String[]{"fact","hour","arm","pay","radio","miss","heat","visit","buy","wide","safe","dog","on","fail","lead","heat","rest"}, new String[]{"heat","Fahc"}, new String[]{"heat",""}),
		new ImmutableTriple(new String[]{"item","well","TV","amount","step","bag","front","her","this","win","to","beyond","ok"}, new String[]{"eJMR","tis","bag","V","ItEm"}, new String[]{"","","bag","","item"}),
		new ImmutableTriple(new String[]{"when","one","later","common","camera","risk","lay"}, new String[]{"RiDsk","laer","rSMK","la","camera","lay","lae","odNe"}, new String[]{"","","","","camera","lay","",""}),
		new ImmutableTriple(new String[]{"dream","size","read","sense","offer","in","ground"}, new String[]{"dRetm","eVad","WebnsuvE","iCz","dream","gRoLUnOd","size"}, new String[]{"","","","","dream","","size"}),
		new ImmutableTriple(new String[]{"only","since","most"}, new String[]{"nonly","mMfoAst","since","since","since","sAinJIce","InSMce","OQNBly","os"}, new String[]{"","","since","since","since","","","",""}),
		new ImmutableTriple(new String[]{"range","local","talk","rich","modern"}, new String[]{"modEIn","RFkanmge","taL","talk","RIh","local","range","odEVn"}, new String[]{"","","","talk","","local","range",""}),
		new ImmutableTriple(new String[]{"sense","onto","word","type","make","body","Mr"}, new String[]{"onTo","Body","type","oSKno","Mr","Mjke","ensE","DaKe"}, new String[]{"onto","body","type","","Mr","","",""}),
		new ImmutableTriple(new String[]{"style","ready","cell","run"}, new String[]{"Run","ready","Srun","cell","stYl","ru","syl","cell","clL","TUylE"}, new String[]{"run","ready","","cell","","","","cell","",""}),
		new ImmutableTriple(new String[]{"staff","for","cause","radio"}, new String[]{"staff","Fr","aKe","hstfF","staiff","zfoUr","dc","gRado","cause","adiO"}, new String[]{"staff","","","","","","","","cause",""}),
		new ImmutableTriple(new String[]{"wear","check","bank","air","system"}, new String[]{"system","sysNem","aLnK","bvk","wear","weA","cEC","air","eySTeM"}, new String[]{"system","","","","wear","","","air",""}),
		new ImmutableTriple(new String[]{"rule","threat","middle","space","food","radio","finger","past"}, new String[]{"Bmifddl","Wfood","food","fooD","Mfoo","radio"}, new String[]{"","","food","food","","radio"}),
		new ImmutableTriple(new String[]{"bring","score","how","up","social"}, new String[]{"ow","Ubrig","Ow","bring","sOcIl","scrdore","hOw","Yup","social"}, new String[]{"","","","bring","","","how","","social"}),
		new ImmutableTriple(new String[]{"its","in","future","garden"}, new String[]{"futur","AVrdTEn","Aps","ZVIZn","uue","futur","garE","garden","its","ites"}, new String[]{"","","","","","","","garden","its",""}),
		new ImmutableTriple(new String[]{"kid","though","win","choose","figure"}, new String[]{"cHoOSE","HtbHOugh","choose","fiGre","VRhougH","win","though"}, new String[]{"choose","","choose","","","win","though"}),
		new ImmutableTriple(new String[]{"order","job","eye","guess","spend"}, new String[]{"ORdE","ZorDeR","odrer","gues","joB","eyHE","job","eye","sn","spSend"}, new String[]{"","","","","job","","job","eye","",""}),
		new ImmutableTriple(new String[]{"else","choose","close","blue"}, new String[]{"clos","coSe","close","","ele","choose","blQCue","ble","ChOoose","cosKe"}, new String[]{"","","close","","","choose","","","",""}),
		new ImmutableTriple(new String[]{"eye","ok","least","your","fact","foot","out","land","claim","ask"}, new String[]{"lewand","ey","lAnu","yohur","land","Least","Lk"}, new String[]{"","","","","land","least",""}),
		new ImmutableTriple(new String[]{"before","chance","both","author","where","future"}, new String[]{"bch","bTh","Ubbot","beFIoroe","bjefore","fuBteur","VafuthoQr","weRCe"}, new String[]{"","","","","","","",""}),
		new ImmutableTriple(new String[]{"pull","agent","night","mind","indeed","their","around","buy"}, new String[]{"tHEIr","ThEir","aoun","aYgeynT","indeed","mjind"}, new String[]{"their","their","","","indeed",""}),
		new ImmutableTriple(new String[]{"join","effort","rate","senior","next"}, new String[]{"hjiN","seNiOr","nText","JoIn","RQat","joN","effOor","exmjt","meFforT"}, new String[]{"","senior","","join","","","","",""}),
		new ImmutableTriple(new String[]{"impact","view","above","you","entire","trip"}, new String[]{"aBove","imt","imhpact","yoVu","above","abov","Qyou","zyou","oU"}, new String[]{"above","","","","above","","","",""}),
		new ImmutableTriple(new String[]{"within","very","group","method"}, new String[]{"Mthi","very","veWkr","metbhYod","veRy","metod","grmup","wQthin","metHod"}, new String[]{"","very","","","very","","","","method"}),
		new ImmutableTriple(new String[]{"often","along","court","put","PM","hotel","he","around","love"}, new String[]{"oGng","puT","arouSnd","aBroUnd","ofteN","he","he"}, new String[]{"","put","","","often","he","he"}),
		new ImmutableTriple(new String[]{"grow","image","strong","day","its","it","claim","appear","city","minute"}, new String[]{"clXam","minIte","igGE","it","dminUte","Gppemar"}, new String[]{"","minute","","it","",""}),
		new ImmutableTriple(new String[]{"doctor","me","stuff","garden","stock","growth","city","throw","though","now","close"}, new String[]{"cblose","close","cy","ZOW","though"}, new String[]{"","close","","","though"}),
		new ImmutableTriple(new String[]{"since","help","rate","look","join","house","itself","eat"}, new String[]{"OjoiGn","rate","joiN","oEpok","yeNlp","At","et","itseklf"}, new String[]{"","rate","join","","","","",""}),
		new ImmutableTriple(new String[]{"form","stand","others","in","their"}, new String[]{"i","eIzR","others","forM","or","theur","tLhi","forjm","snD","foUm"}, new String[]{"","","others","form","","their","","","",""}),
		new ImmutableTriple(new String[]{"wear"}, new String[]{"Wean","wear","weaxR","waR","E","ear","Mwear","wear","wawHr","wcar","fRwRwear","qEr","weAr"}, new String[]{"","wear","","","","","","wear","","","","","wear"}),
		new ImmutableTriple(new String[]{"deep","behind","just","degree","raise","pick","serve","page"}, new String[]{"just","ehi","asye","FegSEe","age","serve","pGe","RiPe"}, new String[]{"just","","","","","serve","",""}),
		new ImmutableTriple(new String[]{"life","upon","area","enough","leg","name","study"}, new String[]{"ae","leG","nAMe","stuy","liFe","sAtPuy","lBeG","ILeQ","naCMe"}, new String[]{"","leg","name","","life","","","",""}),
		new ImmutableTriple(new String[]{"it","final","style","same","free","forget"}, new String[]{"rPEe","forget","same","SLe","CfEe","ijt","sTYele","final","FinA"}, new String[]{"","forget","same","","","","","final",""}),
		new ImmutableTriple(new String[]{"your","room","side","fund","late","wait","say","both","month","run"}, new String[]{"fxnd","bDoMh","ypouR","Fund","MoNth","poth","sdUie"}, new String[]{"","","","fund","month","",""}),
		new ImmutableTriple(new String[]{"paper","far","way","night","before"}, new String[]{"befr","ilghht","night","efor","night","hWay","nigPt","fayr","CCpaLpe","ar"}, new String[]{"","","night","","night","","","","",""}),
		new ImmutableTriple(new String[]{"love","word","gas","two","period","nation","happen","check","hot"}, new String[]{"lvE","nagtion","chzeCLk","two","ord","qgs","pBeRid","QoLd"}, new String[]{"","","","two","","","",""}),
		new ImmutableTriple(new String[]{"here","with","after","child","side"}, new String[]{"KhEre","aftEr","siyd","after","her","side","","cId","sSiDe","child"}, new String[]{"","after","","after","","side","","","","child"}),
		new ImmutableTriple(new String[]{"sound","detail","until","we","under","wear"}, new String[]{"hDundER","iwear","wEVuar","sund","dzei","wear","wear","uKnI","under"}, new String[]{"","","","","","wear","wear","","under"}),
		new ImmutableTriple(new String[]{"doctor","major","wear","pretty","month","serve","which","unit","drug"}, new String[]{"unit","exve","Amonth","moPnnTh","uWnIT","majUMYor","sere"}, new String[]{"unit","","","","","",""}),
		new ImmutableTriple(new String[]{"could","none","once","win","here","truth","all"}, new String[]{"nHoYynEe","Tuth","onCE","all","noNe","couL","noE","coUld","gNe"}, new String[]{"","","once","all","none","","","could",""}),
		new ImmutableTriple(new String[]{"memory","loss","third","away","also","road","five","term","life","either","matter","grow","in","and"}, new String[]{"either","aaVW","Tem","Oss","tir"}, new String[]{"either","","","",""}),
		new ImmutableTriple(new String[]{"tax","cut","goal","likely","enter","each"}, new String[]{"gAOAl","tax","enter","gal","cut","WtX","entEr","ily","Vnter","cuZt"}, new String[]{"","tax","enter","","cut","","enter","","",""}),
		new ImmutableTriple(new String[]{"recent","for","write","them","wrong","avoid"}, new String[]{"or","or","oUR","rEcnt","raeCenTt","write","wrOnG","ecen","the","Pthem"}, new String[]{"","","","","","write","wrong","","",""}),
		new ImmutableTriple(new String[]{"occur","long","start","item","fact","base","notice","behind","her","four"}, new String[]{"behind","Ittem","lon","rrfhPAct","FhefR","He","nOEtGie"}, new String[]{"behind","","","","","",""}),
		new ImmutableTriple(new String[]{"allow","first","entire","use","Mr","PM","this","under","sexual"}, new String[]{"PPM","Under","Allo","PM","Entire","UsE","usFE","thQs"}, new String[]{"","under","","PM","entire","use","",""}),
		new ImmutableTriple(new String[]{"claim","office","sea","drive"}, new String[]{"office","dcRpiTvQE","EcLIAm","seA","sa","BcLaim","Sea","DrIve","clkYim","claim"}, new String[]{"office","","","sea","","","sea","drive","","claim"}),
		new ImmutableTriple(new String[]{"single"}, new String[]{"singe","Single","skgle","siMNGLe","single","single","singYFe","SinGl","saIngle","SiNgle","sNgle"}, new String[]{"","single","","","single","single","","","","single",""}),
		new ImmutableTriple(new String[]{"option","just","eat","likely","meet","spend","hang","some","agency","very"}, new String[]{"met","spend","vYery","option","spend","se","otion"}, new String[]{"","spend","","option","spend","",""}),
		new ImmutableTriple(new String[]{"power","set","stop","record","in","check","travel","close","five"}, new String[]{"PCKowVer","pmoyxWer","FseT","CraVE","stop","PwMe","cBin","record"}, new String[]{"","","","","stop","","","record"}),
		new ImmutableTriple(new String[]{"figure","cut","event","may","tell","chance","free","work","minute","yet","period"}, new String[]{"pEriod","eAV","Chancwe","chance","fiGure","Tnll"}, new String[]{"period","","","chance","figure",""}),
		new ImmutableTriple(new String[]{"off","agree","fight","center","suffer","stand","week","parent"}, new String[]{"can","WEeK","entr","GrEe","Off","suFjer","oftf","suffer","figH"}, new String[]{"","week","","","off","","","suffer",""}),
		new ImmutableTriple(new String[]{"floor","real","leader","free","data","people","region","bank"}, new String[]{"lLEder","peple","ea","leadEr","ea","YleaE","bGbak","baNk","real"}, new String[]{"","","","leader","","","","bank","real"}),
		new ImmutableTriple(new String[]{"peace","others","again","across","money","simple"}, new String[]{"ny","money","Crs","aosS","sipE","across","money","simple","sSimcpLe"}, new String[]{"","money","","","","across","money","simple",""}),
		new ImmutableTriple(new String[]{"memory","owner","death","team","offer","hot","world","cold","more","blood"}, new String[]{"offer","kmah","more","Xeam","ood","teea","po","Loo","KAm"}, new String[]{"offer","","more","","","","","",""}),
		new ImmutableTriple(new String[]{"door","help","hang","mouth","new","media","level"}, new String[]{"moV","hang","Hep","dor","help","IhaZnkG","moKuh","ne","neW","mEdui","eLp"}, new String[]{"","hang","","","help","","","","new","media",""}),
		new ImmutableTriple(new String[]{"hour","smile","always"}, new String[]{"awaYs","snMilNe","azlwaSYs","always","smile","Sie","aLways","alwaYs","always","always"}, new String[]{"","","","always","smile","","always","always","always","always"}),
		new ImmutableTriple(new String[]{"ready","price","might","last","record","hang","begin"}, new String[]{"ready","Tready","bEgin","beKin","igoht","aNg","bNzEgIEin","bgGIQN","Zst","qbGaN"}, new String[]{"ready","","begin","","","","","","",""}),
		new ImmutableTriple(new String[]{"ball","game","here","arrive","across","cancer"}, new String[]{"fgaBme","gAMe","aorEivE","cauNcer","karos","cDamincer","here","aRosKs","re","cAncer"}, new String[]{"","game","","","","","here","","","cancer"}),
		new ImmutableTriple(new String[]{"reach","first","air","under","note","moment","begin","memory","the","live"}, new String[]{"rcEaBch","memory","note","note","Reac","abi","Pundlr","begQIN"}, new String[]{"","memory","note","note","","","",""}),
		new ImmutableTriple(new String[]{"upon","that","happy","factor"}, new String[]{"Facio","thKAt","pon","fCtor","duPzH","Factr","hAT","faCtor","that","happy","haWppy","upon"}, new String[]{"","","","","","","","factor","that","happy","","upon"}),
		new ImmutableTriple(new String[]{"legal","least","minute","every","which","see","arrive","over","pick","point"}, new String[]{"Every","EmveRy","lel","pDoin","least","over","evebry","whicrh"}, new String[]{"every","","","","least","over","",""}),
		new ImmutableTriple(new String[]{"major","raise","apply","this","eye","after","draw","heart","drive","lead"}, new String[]{"mAJo","Heoad","kRAie","lVEaAd","MjO","IdrAw","Shs","draw","ad","aPly"}, new String[]{"","","","","","","","draw","",""}),
		new ImmutableTriple(new String[]{"stand","order","fight","race","shake","exist","ask","piece"}, new String[]{"hkE","shake","piece","shak","rrae","ask","foher","E","ask","fight"}, new String[]{"","shake","piece","","","ask","","","ask","fight"}),
		new ImmutableTriple(new String[]{"whom","factor","wind","get","coach","right","drug","spend","them","road","figure","world","body","ball","rock","rise","such","bring","heavy","idea"}, new String[]{"WThe","UCh","FAcTgo"}, new String[]{"","",""}),
		new ImmutableTriple(new String[]{"road","civil","father","anyone","finish","worker","side","force"}, new String[]{"nroad","TwBorkser","ayone","ruCe","iDvil","fInkIh","worker","fc","worker"}, new String[]{"","","","","","","worker","","worker"}),
		new ImmutableTriple(new String[]{"he","want","age","hard","build","ball","guess","school","simply","turn"}, new String[]{"he","waT","School","he","eSwa","GshesIS","ohard","smly","wt","gbuid"}, new String[]{"he","","school","he","","","","","",""}),
		new ImmutableTriple(new String[]{"ever","now","course","lose","test","strong","within","young","cost","for","vote","year","admit","leg","blue","young","chair","hotel","hour"}, new String[]{"u","hoel","yoGuCn","blue"}, new String[]{"","","","blue"}),
		new ImmutableTriple(new String[]{"shoot","class","edge","need","draw","their","while","party","should","leave"}, new String[]{"oclCaks","need","edKge","party","WHl","LBhilE","partY","whiLe"}, new String[]{"","need","","party","","","party","while"}),
		new ImmutableTriple(new String[]{"sort","should","along","matter","trade","true","my","eight","cell"}, new String[]{"MHy","eIhT","zhoulyd","alonHg","along","AonNg","TFade","MtKTer","tRue","sFr"}, new String[]{"","","","","along","","","","true",""}),
		new ImmutableTriple(new String[]{"threat","black","ever","theory","must","myself"}, new String[]{"mysF","bmyself","tEREat","eFEhR","black","black","eVtr","evWeR","Ye","theory","theor"}, new String[]{"","","","","black","black","","","","theory",""}),
		new ImmutableTriple(new String[]{"where"}, new String[]{"heRe","where","whevre","wXherbAE","wHereze","where","wYHe","EuWhere","whEre","Here","WhKrSe","rwerE","heR","hre","Hee"}, new String[]{"","where","","","","where","","","where","","","","","",""}),
		new ImmutableTriple(new String[]{"class","thank","well","west","enter","kind","sort","per","indeed","work"}, new String[]{"work","xEet","emontlr","wefst","wOK","clASps","RJer","sort","LWOrZk","Nter"}, new String[]{"work","","","","","","","sort","",""}),
		new ImmutableTriple(new String[]{"ago","goal"}, new String[]{"goaql","agEo","gozal","go","bRao","gosal","","go","gOal","amgo","AgO","ago","ago","ago","Go","oal","aGo"}, new String[]{"","","","","","","","","goal","","ago","ago","ago","ago","","","ago"}),
		new ImmutableTriple(new String[]{"set","enter","around","its","death"}, new String[]{"around","its","its","romund","Yits","ts","ente","QVdxueiaSth","eE","deth","ENuejr","deEatdh","mdeaAth"}, new String[]{"around","its","its","","","","","","","","","",""}),
		new ImmutableTriple(new String[]{"cost","win","dinner","I","sell","shake","leg","letter","huge","major"}, new String[]{"leg","I","coST","dZNvNeyr","tHge","cEos","shake","win","huge","diNneir"}, new String[]{"leg","I","cost","","","","shake","win","huge",""}),
		new ImmutableTriple(new String[]{"note","one","anyone","bar","offer","church","key","avoid","amount"}, new String[]{"huUrch","amount","AVoiD","rnUote","ffexr","aoId","note","key","akone","one"}, new String[]{"","amount","avoid","","","","note","key","","one"}),
		new ImmutableTriple(new String[]{"true","minute","style","relate","three","like","middle","game"}, new String[]{"ERidle","Tylice","tRpue","Iut","tree","Mdde","htrTUe","Mstyle","inUCltE","RuE","relate"}, new String[]{"","","","","true","","","","","","relate"}),
		new ImmutableTriple(new String[]{"leg","house","young","since","table","thank","team","tell","throw","and"}, new String[]{"ttAbLe","phrw","team","TsainCIe","throw","huse","ESg","ouxg","tjeSlL","since"}, new String[]{"","","team","","throw","","","","","since"}),
		new ImmutableTriple(new String[]{"east","new","reason","town","hit","rock"}, new String[]{"reQasVOn","easZt","s","new","eTas","Ro","unew","rock","town","ToWn","reason","Hist","east"}, new String[]{"","","","new","","","","rock","town","town","reason","","east"}),
		new ImmutableTriple(new String[]{"home","near","late","skin","under","you","answer","forget","chance","thus","of","like","step","pretty","real","part","show","both"}, new String[]{"sZksiN","bXormtH","latTE","NeeaR","rCal","uder"}, new String[]{"","","","","",""}),
		new ImmutableTriple(new String[]{"skill","recent","choose","throw","learn","skin","always","phone"}, new String[]{"YEAEnwt","redcent","choos","FsKin","skill","phone","Ecet","ThRow","Salway","learn"}, new String[]{"","","","","skill","phone","","throw","","learn"}),
		new ImmutableTriple(new String[]{"charge","others","vote","fall","weapon","more","fall","water","rest"}, new String[]{"More","rxWcat","Chawrge","Owadte","morE","mIr","lcHarge","vte","weApon","weapon"}, new String[]{"more","","","","more","","","","weapon","weapon"}),
		new ImmutableTriple(new String[]{"my","show","some"}, new String[]{"my","Ome","show","sHw","","sdhow","how","my","My","my","soqSmE","OmSe","SoSJW","show","y","qow","Some","How"}, new String[]{"my","","show","","","","","my","my","my","","","","show","","","some",""}),
		new ImmutableTriple(new String[]{"thing","cost","player","type","price","leave","weight","home","crime","get","paper","human","face","book","stock"}, new String[]{"cst","EWeigHSt","WeIh","hID","book","ome","crie","book"}, new String[]{"","","","","book","","","book"}),
		new ImmutableTriple(new String[]{"after","social","gas","affect","go","none","myself","season","region","check","bank","here","act","prove","night","force","decide","rest","level","few"}, new String[]{"BnonE","esT","fOcYe","nOnsE","GnOF"}, new String[]{"","","","",""}),
		new ImmutableTriple(new String[]{"should","up","attack","for"}, new String[]{"fOor","attack","attack","fLr","fOr","attak","up","up","u","fshLould","attaTk","dhoud","SsholOd","for","FXoR"}, new String[]{"","attack","attack","","for","","up","up","","","","","","for",""}),
		new ImmutableTriple(new String[]{"name","power","early","new","off","cup","affect","call","rich","get","itself","write","along"}, new String[]{"affet","Itelf","lWrit","itJseif","JI","f","iTsevlF","EXt","tene","nakMe","aTll"}, new String[]{"","","","","","","","","","",""}),
		new ImmutableTriple(new String[]{"memory","three","all","work","dog","memory","now","stand","voice","baby","some"}, new String[]{"g","HmemoRY","ll","sa","woK","nW","tHree","meORMry","mjoRy","voyic","memOrRy","alL"}, new String[]{"","","","","","","three","","","","","all"}),
		new ImmutableTriple(new String[]{"could","you","even","wall","loss","line","woman","blood","value"}, new String[]{"valuE","you","even","waell","oss","woeuma","lOss","Wvman","EOVe","walL","los","evEn"}, new String[]{"value","you","even","","","","loss","","","wall","","even"}),
		new ImmutableTriple(new String[]{"these","soon","media","dinner","your","notice","woman","office","large"}, new String[]{"larGme","KwOma","oticE","media","nTice","media","WOak","wyoUr","ouRr","media","duzinNner"}, new String[]{"","","","media","","media","","","","media",""}),
		new ImmutableTriple(new String[]{"learn","player"}, new String[]{"Player","Larn","PlAr","larn","dpQlaVyer","playEr","pelayEr","plaRyeR","paYe","LearN","lyeR","playger","leUarn","LaJMrpn","pBqLaRyeR"}, new String[]{"player","","","","","player","","","","learn","","","","",""}),
		new ImmutableTriple(new String[]{"manage","should","maybe","food","offer","worry","else","able","still","order","event","group","but","fight","color","help","him","coach","act","have"}, new String[]{"oawch","able","should","ofFxtr","gRsOU"}, new String[]{"","able","should","",""}),
		new ImmutableTriple(new String[]{"rate","your","budget","child","night","ago","summer","anyone","thank","body","eye","result","ok","along","course","push","stay","exist","treat"}, new String[]{"your","niG","nIght","nIght","EyE","raT"}, new String[]{"your","","night","night","eye",""}),
		new ImmutableTriple(new String[]{"sexual","tell","sea","just","piece","after","n't","player","risk"}, new String[]{"PienHe","AFTer","s","Xjust","Jpiekce","aFter","piece","Player","sAfte","j","tsea","sexual"}, new String[]{"","after","","","","after","piece","player","","","","sexual"}),
		new ImmutableTriple(new String[]{"happen","media","want","sport","part","each","head","every"}, new String[]{"sPrbt","head","Ant","kapVnN","wAnt","hEad","Ercy","heaD","IHppN","or","meDia","happen","BGech"}, new String[]{"","head","","","want","head","","head","","","media","happen",""}),
		new ImmutableTriple(new String[]{"go","six","method","civil","water","there","space","human","over","goal","hang","follow"}, new String[]{"hUman","go","hang","wate","YvR","OlSo","hng","gsO","six","foLloWw","spaCVe","shx"}, new String[]{"human","go","hang","","","","","","six","","",""}),
		new ImmutableTriple(new String[]{"north","nor","list","name","them","go","suffer","he","coach","hold","them","size","skill","ahead","son","have","design","fire","image","food"}, new String[]{"nor","skill","ize","HAL","he","skill","sO"}, new String[]{"nor","skill","","","he","skill",""}),
		new ImmutableTriple(new String[]{"risk"}, new String[]{"rishk","risk","rAusk","RiSK","risnk","rSRK","Risk","rfisk","riHsk","Rik","rick","rnSk","risk","riSK","Rk","RiS","risk","riSk","rIS"}, new String[]{"","risk","","risk","","","risk","","","","","","risk","risk","","","risk","risk",""}),
		new ImmutableTriple(new String[]{"when","pretty","our","either","force","serve","land","adult","arrive"}, new String[]{"force","hen","AdUlbt","serv","lan","our","preIt","pretty","whesN","pretty","wHhen","pretty"}, new String[]{"force","","","","","our","","pretty","","pretty","","pretty"}),
		new ImmutableTriple(new String[]{"suffer"}, new String[]{"sufFer","Suffer","SuAffer","uffEr","SfF","SLuFFe","HsUffEr","suFFeuR","suufmER","suffer","ufFLer","sUfer","scuWffr","suifer","sffEr","FfEU","sZur"}, new String[]{"suffer","suffer","","","","","","","","suffer","","","","","","",""}),
		new ImmutableTriple(new String[]{"unit","will","young","whole","will","large","pick","office"}, new String[]{"UniOt","ffice","wQilOl","unit","kweholFe","younDG","wilBL","Qpik","ofnfie","UlaOrE","whoLKe","will","vunsit","lRp"}, new String[]{"","","","unit","","","","","","","","will","",""}),
		new ImmutableTriple(new String[]{"price","north","nor","step","tend","window","every","people","no","Mrs","theory","real","ahead"}, new String[]{"pEicTe","prBce","evDery","every","XtHrFy","NCor","prYcE","reAl","iMndw","MRs","eSAP"}, new String[]{"","","","every","","","","real","","Mrs",""}),
		new ImmutableTriple(new String[]{"camera","two","move","never","list","these","walk","phone","no","unit","city","with","around","where","human","task","vote","story","notice"}, new String[]{"cITy","Wherpe","whFERe","wdhqere","UnEver","noticD","walk"}, new String[]{"city","","","","","","walk"}),
		new ImmutableTriple(new String[]{"raise","where","price","every","simple","face","entire","heart"}, new String[]{"prICe","pricE","fa","every","fAce","YMkhert","everFy","face","raise","etiPrOe","prce","were","pricLe"}, new String[]{"price","price","","every","face","","","face","raise","","","",""}),
		new ImmutableTriple(new String[]{"why","fight","until","series","son","blue","what","ever","step","travel","create","vote","color","minute","fish","still","door","begin","image"}, new String[]{"GtaveEL","vfote","eve","IhNfigHt","cLepfaRe","lstill","EP","travel"}, new String[]{"","","","","","","","travel"}),
		new ImmutableTriple(new String[]{"like","she","bar"}, new String[]{"bar","lIkX","fliE","like","ba","he","bar","baR","lIikje","like","ike","she","baNPr","bar","Bar","lUike","like","BlRi","she","svhe"}, new String[]{"bar","","","like","","","bar","bar","","like","","she","","bar","bar","","like","","she",""}),
		new ImmutableTriple(new String[]{"place","heart","second","memory","leg","recent","some","friend","man","ago","anyone","we","enter","year","strong"}, new String[]{"xfrhiEd","LetEr","year","ago","M","rOecewNT","PyedaR","mn","Eter","strong","trOg"}, new String[]{"","","year","ago","","","","","","strong",""}),
		new ImmutableTriple(new String[]{"same","push","fight","in","glass","since","wife","artist","both","wide","action","leg","check","fire","no","nation"}, new String[]{"wifSe","natifon","iNe","fir","wsiDe","fight","in","fight","action","wif","LMeg"}, new String[]{"","","","","","fight","in","fight","action","",""}),
		new ImmutableTriple(new String[]{"know","dinner","why","cell","accept"}, new String[]{"h","why","","accept","know","knodw","ceLl","ceLl","khNhOw","cfEll","hfy","nw","acCEPt","kNow","ucll","why","wY","acOcLept"}, new String[]{"","why","","accept","know","","cell","cell","","","","","accept","know","","why","",""}),
		new ImmutableTriple(new String[]{"try","fear","center","from","news","each","arm","thank","two","above","board","often","policy","later","mouth","again","yard","doctor"}, new String[]{"wceNtewr","MdosCtor","MoeUTh","dfEAr","aTr","thanTk","thanPk","ArVm","CenE","agapI"}, new String[]{"","","","","","","","","",""}),
		new ImmutableTriple(new String[]{"only","common","former","wonder","people","large","man","tend","she","land","term","they","value","bit","huge","whole","close","always","system","soon"}, new String[]{"wOnder","she","oE","son","clDoe","mMArQn","Huge","only"}, new String[]{"wonder","she","","","","","huge","only"}),
		new ImmutableTriple(new String[]{"value","wide","think","energy","year","join","film","air","though","stop","always","action","give","rather","cancer","sport","cover","so"}, new String[]{"tHUgh","rather","ORwidtYE","vaGLUe","rathem","cvr","yeaR","wKspqOt","stko"}, new String[]{"","rather","","","","","year","",""}),
		new ImmutableTriple(new String[]{"health","wife","check","stay","black","fine","up","him","dark"}, new String[]{"wfBe","finKe","wIUF","bAVGc","staqY","U","lack","faiqE","bZXlack","hNim","health","him","ine","xlk","nHEealt","Ofe","check"}, new String[]{"","","","","","","","","","","health","him","","","","","check"}),
		new ImmutableTriple(new String[]{"two","sort","sing","eat","simply","stand","rather","fail","but"}, new String[]{"simpIly","TW","sing","faYi","siNg","LfaIl","Sort","sort","sbrt","sand","stand","but","Rthe","sort","Ai","siNg"}, new String[]{"","","sing","","sing","","sort","sort","","","stand","but","","sort","","sing"}),
		new ImmutableTriple(new String[]{"dinner","local","lot","call","same","song","boy","expect","buy","along"}, new String[]{"calpl","zdinne","DEaSloNg","ALl","sae","samCe","boy","bexpect","cLall","same","tdinNer","boy","sGonSg","aL","SoKVng","bUy"}, new String[]{"","","","","","","boy","","","same","","boy","","","","buy"}),
		new ImmutableTriple(new String[]{"threat","rise","pick","like","cold","skill","dead","than","foot"}, new String[]{"Oitke","tqhRa","cold","thn","piLcK","threaT","skLKll","HeAt","skikll","YDHKed","SkiL","CLLol","YliyKE","threat","Isll","tEwBat"}, new String[]{"","","cold","","","threat","","","","","","","","threat","",""}),
		new ImmutableTriple(new String[]{"pass","what","before","course","under","me","room","inside","step","draw"}, new String[]{"mxce","MDe","paS","pdraw","unVder","ME","a","inie","NSGiE","tP","ME","Pa","unFpdR","undesR","tep","mE","roM","ere","BefobRTe"}, new String[]{"","","","","","me","","","","","me","","","","","me","","",""}),
		new ImmutableTriple(new String[]{"right","this","green","safe","long","head","moment","major","read","study","nearly","better","like","large","her","ask","last"}, new String[]{"this","lAs","ie","eXr","lG","MoMxent","StluRdy","NeArly","LarYge","beTTer","ber","hEaR"}, new String[]{"this","","","","","","","nearly","","better","",""}),
		new ImmutableTriple(new String[]{"wall","girl","his","eye","rock","people","I","last","debate","reason","off","learn","state","public","girl","way","reveal","girl","crime","whom"}, new String[]{"ureqOn","reoveaL","girl","roCk","leIr","FWa","off","last","ofaf","I","oDff"}, new String[]{"","","girl","rock","","","off","last","","I",""}),
		new ImmutableTriple(new String[]{"fall","tree","us","black","shot","level","bar","reason","very","memory"}, new String[]{"lJeel","fal","bar","bR","memOy","shot","rEason","CmeoRy","VAbmar","emEmory","ar","leVqEl","us","v","br","lEL","shot","mlLEEl"}, new String[]{"","","bar","","","shot","reason","","","","","","us","","","","shot",""}),
		new ImmutableTriple(new String[]{"work","fact","carry","once","ask","guy","woman","try","world","use","person","owner","about","space","get","expert"}, new String[]{"Once","eLpegrt","onc","spaHNc","Ocpa","juE","work","woIrL","aBouLat","XjpeQRt","abozt","ak","LexErT","aC"}, new String[]{"once","","","","","","work","","","","","","",""}),
		new ImmutableTriple(new String[]{"water","finish","want","friend","fund","by","next","task","drug"}, new String[]{"fRiN","ate","bY","Bund","tgsK","nxT","GfrAieN","finiEsh","fund","Y","usneET","Pfund","strgIenMd","DFqnd","wAn","mt","fu","Zdrtuo","dbJBy","ZY"}, new String[]{"","","by","","","","","","fund","","","","","","","","","","",""}),
		new ImmutableTriple(new String[]{"else","down","detail","trade","inside","give","avoid","yet","garden"}, new String[]{"enLsE","Et","eye","RVad","kareN","RGaRde","et","gvAaivE","else","dowXn","give","Pcauvoid","AyeT","else","IGsEFiTE","detAil","Nelse","dW"}, new String[]{"","","","","","","","","else","","give","","","else","","detail","",""}),
		new ImmutableTriple(new String[]{"health","late","focus","with","first","way","member","work","may","card","class","new","its","throw","kill"}, new String[]{"FirsT","carRKd","ss","Throw","KL","atqe","itS","with","skiL","with","card","wiTh","fVcus","late"}, new String[]{"first","","","throw","","","its","with","","with","card","with","","late"}),
		new ImmutableTriple(new String[]{"take","west","guess","blood","word","such","child","arm","system","hold","again","myself","boy","police","long","get"}, new String[]{"akE","DMelf","wEtSt","ystem","gxet","bLood","esEt","lngG","yselVf","dtaK","arm","IGecs","lcvhlbd","systEm"}, new String[]{"","","","","","blood","","","","","arm","","","system"}),
		new ImmutableTriple(new String[]{"decade","nation","west","top","civil","her","at","above","field","among","pretty"}, new String[]{"rtTy","at","SoP","natLioUN","nQaTiO","preTty","At","prety","weiCs","Civil","et","daD","at","Muong","t","natiYDon","dvecBcad","A"}, new String[]{"","at","","","","pretty","at","","","civil","at","","at","","","","",""}),
		new ImmutableTriple(new String[]{"wait","well","we","speech","while","chair","factor","I","time","score","boy","hear","system","stage","to","play"}, new String[]{"iwhiLe","chair","tMe","yscre","styStem","while","wait","hear","boRMEY","WE","boy","while","eLl","stae"}, new String[]{"","chair","","","","while","wait","hear","","we","boy","while","",""}),
		new ImmutableTriple(new String[]{"she","late","guess","victim","lose","weapon","land","during","bar","line","raise","so","goal","they"}, new String[]{"wEaPon","WepON","bar","djUriNvg","line","He","Goal","GoNa","WaApKon","ueSs","they","guescs","gtuErsS","uesiS","viytQim"}, new String[]{"weapon","","bar","","line","","goal","","","","they","","","",""}),
		new ImmutableTriple(new String[]{"save","rule","not","stage","person","door","news","item","work","hand","sex","least"}, new String[]{"haZnd","ot","oor","smTa","NEews","work","Not","SeX","saoVe","sEx","rle","FhanBKd","sae","jstae","jYtem","nuews","etRson","Wor","wok"}, new String[]{"","","","","","work","not","sex","","sex","","","","","","","","",""}),
		new ImmutableTriple(new String[]{"run","travel","answer","have","sing","buy","year","summer","from","those","ready","able","use","author","drug","put","person"}, new String[]{"ready","Pt","run","those","anSWer","aSWeCr","thoe","read","sUMMEr","u","answReR","oaNswer","anweGr"}, new String[]{"ready","","run","those","answer","","","","summer","","","",""}),
		new ImmutableTriple(new String[]{"beat","travel","red","why","keep","father","south","these","period","up","above","light","skill"}, new String[]{"sizll","P","south","reD","Yather","above","beat","aboVe","Yp","theSe","thGjESiE","waMkep","wrHY","theS","aboVve","skipll"}, new String[]{"","","south","red","","above","beat","above","","these","","","","","",""}),
		new ImmutableTriple(new String[]{"cause","law","foot","these","shot","class","itself","power","story","cause","before","kill","expect","method"}, new String[]{"CAUSE","cause","Scl","SXbfore","mCmeTHod","Kil","itself","class","POTwe","JCAs","tssel","MEed","law","thhSe","LAYw"}, new String[]{"cause","cause","","","","","itself","class","","","","","law","",""}),
		new ImmutableTriple(new String[]{"friend","bad","easy","blood","dog","of","design","else"}, new String[]{"Eese","blood","MoodD","Vbad","easy","dEsCn","design","easy","easY","pdog","fienWd","friend","Asy","friend","blood","oF","EaS","vESe","design"}, new String[]{"","blood","","","easy","","design","easy","easy","","","friend","","friend","blood","of","","","design"}),
		new ImmutableTriple(new String[]{"walk","by","him","to","play","window","player","budget","this","catch","sex","about","growth","argue","myself","real","nation","ok","goal"}, new String[]{"natiIon","Vgol","bY","plafy","catch","nTaO","BTs","sex","gXTRwth","aoU","this","gRoH","bY","reaVl","acl","retal"}, new String[]{"","","by","","catch","","","sex","","","this","","by","","",""}),
		new ImmutableTriple(new String[]{"able","cause","option","call","huge","or","big","cancer","water","office","father","court","way","office","book","pain","sort"}, new String[]{"wATeR","QoffIice","ftheR","aNt","ro","Gsrt","ay","way","oxfFiCe","hugE","CAnCeCr","offce","tCARurfse","water","ou","wArter","pXami"}, new String[]{"water","","","","","","","way","","huge","","","","water","","",""}),
		new ImmutableTriple(new String[]{"source","tough","simply","upon","stay","scene","sing","center","Mrs","second","source","window","public","legal","period","catch"}, new String[]{"sorzce","pupblic","scEne","ZleGAl","sing","caCtch","qupovn","scoZd","GScoSn","catch","pon","cAth","lEga","upoN","catUh","eL","wiDow"}, new String[]{"","","scene","","sing","","","","","catch","","","","upon","","",""}),
		new ImmutableTriple(new String[]{"fear","this","there","spend","miss","even","spend","idea","trip","energy","call","money","follow","pain","group","head","then"}, new String[]{"thqeQrE","trip","tjhV","Th","scAEn","tDhi","thEAYRCe","fEAR","Ten","Jnd","fEVar","tHherE","tPueTre","even","Paiumn","Spnd","Fear","Enehsrg","then"}, new String[]{"","trip","","","","","","fear","","","","","","even","","","fear","","then"}),
		new ImmutableTriple(new String[]{"board","those","plant","amount","little","drug","summer","option","use","time","most","my","her","chance","minute","since","set","pain","he"}, new String[]{"h","moZuYnt","Zthose","plant","chace","OaRd","EsUMEr","BoArD","umme","drug","sUmmer","minUte","MBYnut","gdwRbug","Qt","OLItlTlE","opto","meT"}, new String[]{"","","","plant","","","","board","","drug","summer","minute","","","","","",""}),
		new ImmutableTriple(new String[]{"foot","which","almost","radio","crime","least","shot","water","other","fire","victim","paper","long","run","which","person","edge","war","shake","man"}, new String[]{"run","rLun","vicbtim","fot","crie","Hrao","which","WHchich","water","man","QwqAr","whic","which","laST","dge","zHOt","run","WACrtR","vctiM"}, new String[]{"run","","","","","","which","","water","man","","","which","","","","run","",""}),
	};

	private static final String[] WORDS = new String[]{"able", "about", "above", "accept", "across", "act", "action", "add", "admit", "adult", "affect", "after", "again", "age", "agency", "agent", "ago", "agree", "ahead", "air", "all", "allow", "almost", "alone", "along", "also", "always", "among", "amount", "and", "animal", "answer", "any", "anyone", "appear", "apply", "area", "argue", "arm", "around", "arrive", "art", "artist", "as", "ask", "assume", "at", "attack", "author", "avoid", "away", "baby", "back", "bad", "bag", "ball", "bank", "bar", "base", "be", "beat", "become", "bed", "before", "begin", "behind", "best", "better", "beyond", "big", "bill", "bit", "black", "blood", "blue", "board", "body", "book", "born", "both", "box", "boy", "break", "bring", "budget", "build", "but", "buy", "by", "call", "camera", "can", "cancer", "car", "card", "care", "career", "carry", "case", "catch", "cause", "cell", "center", "chair", "chance", "change", "charge", "check", "child", "choice", "choose", "church", "city", "civil", "claim", "class", "clear", "close", "coach", "cold", "color", "come", "common", "cost", "could", "couple", "course", "court", "cover", "create", "crime", "cup", "cut", "dark", "data", "day", "dead", "deal", "death", "debate", "decade", "decide", "deep", "degree", "design", "detail", "die", "dinner", "do", "doctor", "dog", "door", "down", "draw", "dream", "drive", "drop", "drug", "during", "each", "early", "east", "easy", "eat", "edge", "effect", "effort", "eight", "either", "else", "end", "energy", "enjoy", "enough", "enter", "entire", "even", "event", "ever", "every", "exist", "expect", "expert", "eye", "face", "fact", "factor", "fail", "fall", "family", "far", "fast", "father", "fear", "feel", "few", "field", "fight", "figure", "fill", "film", "final", "find", "fine", "finger", "finish", "fire", "firm", "first", "fish", "five", "floor", "fly", "focus", "follow", "food", "foot", "for", "force", "forget", "form", "former", "four", "free", "friend", "from", "front", "full", "fund", "future", "game", "garden", "gas", "get", "girl", "give", "glass", "go", "goal", "good", "great", "green", "ground", "group", "grow", "growth", "guess", "gun", "guy", "hair", "half", "hand", "hang", "happen", "happy", "hard", "have", "he", "head", "health", "hear", "heart", "heat", "heavy", "help", "her", "here", "high", "him", "his", "hit", "hold", "home", "hope", "hot", "hotel", "hour", "house", "how", "huge", "human", "I", "idea", "if", "image", "impact", "in", "indeed", "inside", "into", "issue", "it", "item", "its", "itself", "job", "join", "just", "keep", "key", "kid", "kill", "kind", "know", "land", "large", "last", "late", "later", "laugh", "law", "lawyer", "lay", "lead", "leader", "learn", "least", "leave", "left", "leg", "legal", "less", "let", "letter", "level", "lie", "life", "light", "like", "likely", "line", "list", "listen", "little", "live", "local", "long", "look", "lose", "loss", "lot", "love", "low", "main", "major", "make", "man", "manage", "many", "market", "matter", "may", "maybe", "me", "mean", "media", "meet", "member", "memory", "method", "middle", "might", "mind", "minute", "miss", "model", "modern", "moment", "money", "month", "more", "most", "mother", "mouth", "move", "movie", "Mr", "Mrs", "much", "music", "must", "my", "myself", "name", "nation", "nature", "near", "nearly", "need", "never", "new", "news", "next", "nice", "night", "no", "none", "nor", "north", "not", "note", "notice", "now", "n't", "number", "occur", "of", "off", "offer", "office", "often", "oh", "oil", "ok", "old", "on", "once", "one", "only", "onto", "open", "option", "or", "order", "other", "others", "our", "out", "over", "own", "owner", "page", "pain", "paper", "parent", "part", "party", "pass", "past", "pay", "peace", "people", "per", "period", "person", "phone", "pick", "piece", "place", "plan", "plant", "play", "player", "PM", "point", "police", "policy", "poor", "power", "pretty", "price", "prove", "public", "pull", "push", "put", "quite", "race", "radio", "raise", "range", "rate", "rather", "reach", "read", "ready", "real", "really", "reason", "recent", "record", "red", "reduce", "region", "relate", "remain", "remove", "report", "rest", "result", "return", "reveal", "rich", "right", "rise", "risk", "road", "rock", "role", "room", "rule", "run", "safe", "same", "save", "say", "scene", "school", "score", "sea", "season", "seat", "second", "see", "seek", "seem", "sell", "send", "senior", "sense", "series", "serve", "set", "seven", "sex", "sexual", "shake", "share", "she", "shoot", "short", "shot", "should", "show", "side", "sign", "simple", "simply", "since", "sing", "single", "sister", "sit", "site", "six", "size", "skill", "skin", "small", "smile", "so", "social", "some", "son", "song", "soon", "sort", "sound", "source", "south", "space", "speak", "speech", "spend", "sport", "spring", "staff", "stage", "stand", "star", "start", "state", "stay", "step", "still", "stock", "stop", "store", "story", "street", "strong", "study", "stuff", "style", "such", "suffer", "summer", "sure", "system", "table", "take", "talk", "task", "tax", "teach", "team", "tell", "ten", "tend", "term", "test", "than", "thank", "that", "the", "their", "them", "then", "theory", "there", "these", "they", "thing", "think", "third", "this", "those", "though", "threat", "three", "throw", "thus", "time", "to", "today", "too", "top", "total", "tough", "toward", "town", "trade", "travel", "treat", "tree", "trial", "trip", "true", "truth", "try", "turn", "TV", "two", "type", "under", "unit", "until", "up", "upon", "us", "use", "value", "very", "victim", "view", "visit", "voice", "vote", "wait", "walk", "wall", "want", "war", "watch", "water", "way", "we", "weapon", "wear", "week", "weight", "well", "west", "what", "when", "where", "which", "while", "white", "who", "whole", "whom", "whose", "why", "wide", "wife", "will", "win", "wind", "window", "wish", "with", "within", "woman", "wonder", "word", "work", "worker", "world", "worry", "would", "write", "writer", "wrong", "yard", "yeah", "year", "yes", "yet", "you", "young", "your"};

	@Test
	void spellchecker()
	{
		String message;

		for (Triple<String[], String[], String[]> t : T)
		{
			final String[] wordlist = t.getLeft();
			final String[] queries = t.getMiddle();
			final String[] expected = t.getRight();
			final String[] actual = VowelSpellchecker.spellchecker(wordlist, queries);

			message = String.format("Test failed for case:"
				+ "\n%10s : %s"
				+ "\n%10s : %s"
				+ "\n%10s : %s"
				+ "\n%10s : %s"
				+ "\n%10s",
				"Wordlist", Arrays.toString(wordlist),
				"Queries", Arrays.toString(queries),
				"Expected", Arrays.toString(expected),
				"Actual", Arrays.toString(actual),
				"");

			assertArrayEquals(expected, actual, message);
		}
	}

//	public static void main(String[] args)
//	{
//		generateTests(50);
//	}

	private static void generateTests(int quantity)
	{
		for (int i = 0; i < quantity; ++i)
		{
			generateTest();
		}
	}

	private static void generateTest()
	{
		Random r = new Random();
		// The size of the arrays don't have to match
		String[] words = new String[(r.nextInt(20) + 1)];
		String[] queries = new String[(r.nextInt(20) + 1)];
		for (int i = 0; i < words.length; ++i)
		{
			words[i] = "\"" + WORDS[r.nextInt(WORDS.length)] + "\"";
		}

		for (int i = 0; i < queries.length; ++i)
		{
			queries[i] = mutateString(words[r.nextInt(words.length)]);
		}

		String w = Arrays.toString(words).replaceAll("[\\[\\] ]", "");
		String q = Arrays.toString(queries).replaceAll("[\\[\\] ]", "");
		String a = Arrays.toString(validate(words, queries)).replaceAll("[\\[\\] ]", "");
		System.out.printf("new ImmutableTriple(new String[]{%s}, new String[]{%s}, new String[]{%s}),%n", w, q, a);
	}

	private static String mutateString(String s)
	{
		List<Character> chars = new ArrayList<>();
		for (char c : s.toCharArray())
		{
			chars.add(c);
		}

		Random rand = new Random();
		int numMutations = rand.nextInt((s.length()) + 1);

		for (int i = 0; i < numMutations; i++)
		{
			if (chars.isEmpty())
			{
				// Can't mutate an empty list
				break;
			}

			int mutationType = rand.nextInt(3);
			int index = rand.nextInt(chars.size());

			// Quotation marks must remain unsullied
			if (chars.get(index) == '"')
			{
				continue;
			}

			switch (mutationType)
			{
				case 0 -> // Capitalize
				{
					char c = chars.get(index);
					chars.set(index, Character.toUpperCase(c));
				}
				case 1 -> // Remove
					chars.remove(index);
				case 2 -> // Add a random letter
				{
					char newChar = (char) ('A' + rand.nextInt(26));
					newChar = rand.nextBoolean() ? Character.toLowerCase(newChar) : newChar;
					chars.add(index, newChar);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : chars)
		{
			sb.append(c);
		}
		return sb.toString();
	}

	private static String[] validate(String[] wordlist, String[] queries)
	{
		Set<String> words = new HashSet<>(Arrays.asList(wordlist));
		HashMap<String, String> caseMismatched = new HashMap<>();
		HashMap<String, String> vowelMismatched = new HashMap<>();

		for (String word : wordlist)
		{
			String lowercase = word.toLowerCase();
			String lipogram = lowercase.replaceAll("[aeiou]", "*");
			caseMismatched.putIfAbsent(lowercase, word);
			vowelMismatched.putIfAbsent(lipogram, word);
		}

		for (int i = 0; i < queries.length; ++i)
		{
			if (words.contains(queries[i]))
			{
				continue;
			}

			String lowercase = queries[i].toLowerCase();
			String lipogram = lowercase.replaceAll("[aeiou]", "*");

			queries[i] = caseMismatched.containsKey(lowercase)
				? caseMismatched.get(lowercase)
				: vowelMismatched.getOrDefault(lipogram, "\"\"");
		}
		return queries;
	}
}