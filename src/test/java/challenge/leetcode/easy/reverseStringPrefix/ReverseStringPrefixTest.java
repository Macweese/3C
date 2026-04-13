/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.easy.reverseStringPrefix;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 13:50 Mon 13 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3794. Reverse String Prefix")
class ReverseStringPrefixTest
{
	private static final Map<Input, String> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input("in",1),"in");
		MAP.put(new Input("hey",1),"hey");
		MAP.put(new Input("xyz",3),"zyx");
		MAP.put(new Input("abcd",2),"bacd");
		MAP.put(new Input("pale",1),"pale");
		MAP.put(new Input("owns",1),"owns");
		MAP.put(new Input("holy",4),"yloh");
		MAP.put(new Input("pleads",2),"lpeads");
		MAP.put(new Input("fitted",5),"ettifd");
		MAP.put(new Input("sucked",5),"ekcusd");
		MAP.put(new Input("travels",5),"evartls");
		MAP.put(new Input("addition",4),"iddation");
		MAP.put(new Input("researches",6),"raeserches");
		MAP.put(new Input("imitatively",7),"itatimively");
		MAP.put(new Input("rescuingmix",6),"iucserngmix");
		MAP.put(new Input("underhandedness",2),"nuderhandedness");
		MAP.put(new Input("sociallyexperience",17),"cneirepxeyllaicose");
		MAP.put(new Input("scornfullyretrieves",2),"csornfullyretrieves");
		MAP.put(new Input("rewardinglyengagedjudging",7),"idrawernglyengagedjudging");
		MAP.put(new Input("austeritytalentedlysenior",15),"tnelatytiretsuaedlysenior");
		MAP.put(new Input("noisilyindependententrenchment",20),"netnednepedniylisiontrenchment");
		MAP.put(new Input("constitutionalityincrementally",11),"oitutitsnocnalityincrementally");
		MAP.put(new Input("accusinglymonitoremphasissailing",13),"nomylgnisuccaitoremphasissailing");
		MAP.put(new Input("satiationcondemnationhonorability",31),"ilibaronohnoitanmednocnoitaitasty");
		MAP.put(new Input("thoughtundoubtedlycheerlydissolves",7),"thguohtundoubtedlycheerlydissolves");
		MAP.put(new Input("wonderfulnessproficientlychallenge",25),"yltneiciforpssenlufrednowchallenge");
		MAP.put(new Input("subjectivityanyuncertaintyswiftestfast",22),"atrecnuynaytivitcejbusintyswiftestfast");
		MAP.put(new Input("physicalitygreetsichilycomparablymanager",20),"hcisteergytilacisyhpilycomparablymanager");
		MAP.put(new Input("startedoppressivelyviceregallycoordinated",7),"detratsoppressivelyviceregallycoordinated");
		MAP.put(new Input("expressesjealousyinfestationmeasurability",28),"noitatsefniysuolaejsesserpxemeasurability");
		MAP.put(new Input("creptvolumetricallytestimperfectionaviation",4),"perctvolumetricallytestimperfectionaviation");
		MAP.put(new Input("practisingdependablenessunconstitutionality",30),"snocnussenelbadnepedgnisitcarptitutionality");
		MAP.put(new Input("dislikedserviceabilitydecreasingtristfullyindoor",23),"dytilibaecivresdekilsidecreasingtristfullyindoor");
		MAP.put(new Input("entrepreneurtidilyrespectedcurabilityslipsinfully",16),"iditruenerpertnelyrespectedcurabilityslipsinfully");
		MAP.put(new Input("exteriorinheritedremobilizationpratinglyinsufficient",1),"exteriorinheritedremobilizationpratinglyinsufficient");
		MAP.put(new Input("accomplishmentpeculiaritiesfrightfulnessauthenticator",38),"enlufthgirfseitirailuceptnemhsilpmoccassauthenticator");
		MAP.put(new Input("concessionyearwarddeceitfulnessslighterdiversification",35),"gilsssenluftieceddrawraeynoissecnochterdiversification");
		MAP.put(new Input("kickunpleasantlyelectronicallytentativelyimmobilization",31),"tyllacinortceleyltnasaelpnukcikentativelyimmobilization");
		MAP.put(new Input("timiditywipesintangibilityuniqueobligationirresponsibly",18),"natnisepiwytidimitgibilityuniqueobligationirresponsibly");
		MAP.put(new Input("superconductivityconcludesloyaltenthhittingrehabilitator",16),"tivitcudnocrepusyconcludesloyaltenthhittingrehabilitator");
		MAP.put(new Input("uproariouslydwellssubcategoryunpleasantlyabackinterrupter",35),"aelpnuyrogetacbussllewdylsuoiraorpusantlyabackinterrupter");
		MAP.put(new Input("measuresimageryrenewedlyassuringperpendicularitygreethelplessly",20),"weneryregamiserusaemedlyassuringperpendicularitygreethelplessly");
		MAP.put(new Input("linguistoccultlyprinterunbiasedlysympathizerconcludingcongestion",62),"itsegnocgnidulcnocrezihtapmysyldesaibnuretnirpyltluccotsiugnilon");
		MAP.put(new Input("swingingappointintuitionindentationchuckingsectionrapidityinitial",5),"gniwsingappointintuitionindentationchuckingsectionrapidityinitial");
		MAP.put(new Input("vestigiallycorrespondenceoriginalitysomedayzappilyfunctionnorthern",31),"nigiroecnednopserrocyllaigitsevalitysomedayzappilyfunctionnorthern");
		MAP.put(new Input("dueeastwardsfearinglawfullyuncontrollablyenjoyablenessclearinterfere",47),"ayojneylballortnocnuyllufwalgniraefsdrawtsaeeudblenessclearinterfere");
		MAP.put(new Input("humblyflagrantlyflirtationassenterraticallyvividattendsvotingperhaps",54),"dnettadivivyllacitarretnessanoitatrilfyltnargalfylbmuhsvotingperhaps");
		MAP.put(new Input("resultallegorymindedbehaviorismviscosityhavenewfreakinessfortification",24),"ahebdednimyrogellatluserviorismviscosityhavenewfreakinessfortification");
		MAP.put(new Input("radioactivelyfetiselycomprehensivedivorceobeyeddebatesforegrounddiversity",55),"fsetabeddeyeboecrovidevisneherpmocylesitefylevitcaoidaroregrounddiversity");
		MAP.put(new Input("credibilitymodestinfractionshaminglytreatmurmurmeagernesselseentersenquire",7),"ibiderclitymodestinfractionshaminglytreatmurmurmeagernesselseentersenquire");
		MAP.put(new Input("appropriatenessglaringlymarvellousundermineburningalterendlessqualifywander",28),"vramylgniralgssenetairporppaellousundermineburningalterendlessqualifywander");
		MAP.put(new Input("followsformallylongevityimplementinghardheadednesssterilizationcommitteddivide",21),"vegnolyllamrofswollofityimplementinghardheadednesssterilizationcommitteddivide");
		MAP.put(new Input("reappointmentcontroversialmigrationsanitizerascertainedoutrageousnessunfashionably",8),"nioppaertmentcontroversialmigrationsanitizerascertainedoutrageousnessunfashionably");
		MAP.put(new Input("repellentvandalicallycollectedobsoletelyreelectionobstinatelyflatulenceseptentrionally",53),"sbonoitceleeryletelosbodetcellocyllaciladnavtnellepertinatelyflatulenceseptentrionally");
		MAP.put(new Input("ventureproposingtepidlysimplyenhancevaluationfavourboostslouderrevitalizationpremonition",10),"orperutnevposingtepidlysimplyenhancevaluationfavourboostslouderrevitalizationpremonition");
		MAP.put(new Input("squishinesscompetentlypratinglynonnormallyenthusiasticchaseaversionvilificationcommonality",42),"yllamronnonylgnitarpyltnetepmocssenihsiuqsenthusiasticchaseaversionvilificationcommonality");
		MAP.put(new Input("addressparticipatestastilyheedlesslyreinstatementjustifyelitistcommitvocalicallytriangularly",20),"tsetapicitrapsserddaastilyheedlesslyreinstatementjustifyelitistcommitvocalicallytriangularly");
		MAP.put(new Input("variablenessapproverousinglybarelyirreverentlywholesomelyupwardlyconstructedobsequiouslythrive",30),"abylgnisuorevorppassenelbairavrelyirreverentlywholesomelyupwardlyconstructedobsequiouslythrive");
	}

	@Test
	void reversePrefix()
	{
		for (Map.Entry<Input, String> entry : MAP.entrySet())
		{
			final String s = entry.getKey().s();
			final int k = entry.getKey().k();
			final String expected = entry.getValue();
			final String actual = ReverseStringPrefix.reversePrefix(s, k);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"String", s,
				"K", k,
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}

}
record Input(String s, int k)
{

}