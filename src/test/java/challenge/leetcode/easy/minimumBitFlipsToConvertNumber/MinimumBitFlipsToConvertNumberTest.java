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

package challenge.leetcode.easy.minimumBitFlipsToConvertNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.DataUtils;
import utils.IntArraySpec;

/**
 * @author Administrator
 * @Created 07:42 Wed 19 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2220. Minimum Bit Flips to Convert Number")
class MinimumBitFlipsToConvertNumberTest
{
	private static final Map<int[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{4,4},0);
		MAP.put(new int[]{4,3},3);
		MAP.put(new int[]{1,4},2);
		MAP.put(new int[]{0,7},3);
		MAP.put(new int[]{10,7},3);
		MAP.put(new int[]{80,0},2);
		MAP.put(new int[]{5,48},4);
		MAP.put(new int[]{4,12},1);
		MAP.put(new int[]{35,9},3);
		MAP.put(new int[]{67,2},2);
		MAP.put(new int[]{1,99},3);
		MAP.put(new int[]{2,35},2);
		MAP.put(new int[]{9,16},3);
		MAP.put(new int[]{74,3},3);
		MAP.put(new int[]{0,27},4);
		MAP.put(new int[]{19,1},2);
		MAP.put(new int[]{7,50},4);
		MAP.put(new int[]{98,1},4);
		MAP.put(new int[]{8,69},4);
		MAP.put(new int[]{0,20},2);
		MAP.put(new int[]{1,17},1);
		MAP.put(new int[]{4,88},4);
		MAP.put(new int[]{16,6},3);
		MAP.put(new int[]{65,8},3);
		MAP.put(new int[]{2,66},1);
		MAP.put(new int[]{44,7},4);
		MAP.put(new int[]{1,56},4);
		MAP.put(new int[]{59,0},5);
		MAP.put(new int[]{89,7},5);
		MAP.put(new int[]{86,2},3);
		MAP.put(new int[]{7,88},6);
		MAP.put(new int[]{66,6},2);
		MAP.put(new int[]{98,2},2);
		MAP.put(new int[]{87,4},4);
		MAP.put(new int[]{3,79},3);
		MAP.put(new int[]{4,25},4);
		MAP.put(new int[]{9,17},2);
		MAP.put(new int[]{2,43},3);
		MAP.put(new int[]{16,1},2);
		MAP.put(new int[]{4,76},2);
		MAP.put(new int[]{26,5},5);
		MAP.put(new int[]{26,9},3);
		MAP.put(new int[]{57,76},5);
		MAP.put(new int[]{77,73},1);
		MAP.put(new int[]{91,78},3);
		MAP.put(new int[]{57,48},2);
		MAP.put(new int[]{90,91},1);
		MAP.put(new int[]{83,27},2);
		MAP.put(new int[]{45,16},5);
		MAP.put(new int[]{70,17},5);
		MAP.put(new int[]{67,77},3);
		MAP.put(new int[]{44,37},2);
		MAP.put(new int[]{32,70},4);
		MAP.put(new int[]{35,64},4);
		MAP.put(new int[]{92,40},4);
		MAP.put(new int[]{83,93},3);
		MAP.put(new int[]{26,39},5);
		MAP.put(new int[]{79,21},4);
		MAP.put(new int[]{37,65},3);
		MAP.put(new int[]{30,38},3);
		MAP.put(new int[]{53,14},5);
		MAP.put(new int[]{53,30},4);
		MAP.put(new int[]{75,77},2);
		MAP.put(new int[]{80,37},5);
		MAP.put(new int[]{54,11},5);
		MAP.put(new int[]{68,83},4);
		MAP.put(new int[]{80,17},2);
		MAP.put(new int[]{50,74},4);
		MAP.put(new int[]{29,83},4);
		MAP.put(new int[]{81,81},0);
		MAP.put(new int[]{34,26},3);
		MAP.put(new int[]{64,48},3);
		MAP.put(new int[]{24,60},2);
		MAP.put(new int[]{99,87},3);
		MAP.put(new int[]{14,11},2);
		MAP.put(new int[]{48,27},4);
		MAP.put(new int[]{45,52},3);
		MAP.put(new int[]{85,50},5);
		MAP.put(new int[]{94,68},3);
		MAP.put(new int[]{19,97},4);
		MAP.put(new int[]{11,26},2);
		MAP.put(new int[]{83,63},4);
		MAP.put(new int[]{10,30},2);
		MAP.put(new int[]{88,98},4);
		MAP.put(new int[]{14,95},3);
		MAP.put(new int[]{36,58},4);
		MAP.put(new int[]{37,94},6);
		MAP.put(new int[]{62,76},4);
		MAP.put(new int[]{47,76},4);
		MAP.put(new int[]{34,11},3);
		MAP.put(new int[]{82,59},4);
		MAP.put(new int[]{70,13},4);
		MAP.put(new int[]{50,61},4);
		MAP.put(new int[]{65,78},4);
		MAP.put(new int[]{44,62},2);
		MAP.put(new int[]{20,47},5);
		MAP.put(new int[]{52,97},4);
		MAP.put(new int[]{32,37},2);
		MAP.put(new int[]{34,12},4);
		MAP.put(new int[]{83,25},3);
		MAP.put(new int[]{86,21},3);
		MAP.put(new int[]{94,59},4);
		MAP.put(new int[]{22,32},4);
		MAP.put(new int[]{83,72},4);
		MAP.put(new int[]{37,63},3);
		MAP.put(new int[]{15,96},6);
		MAP.put(new int[]{68,99},4);
		MAP.put(new int[]{29,86},4);
		MAP.put(new int[]{74,79},2);
		MAP.put(new int[]{20,65},4);
		MAP.put(new int[]{71,35},3);
		MAP.put(new int[]{24,23},4);
		MAP.put(new int[]{54,62},1);
		MAP.put(new int[]{98,53},5);
		MAP.put(new int[]{42,71},5);
		MAP.put(new int[]{24,36},4);
		MAP.put(new int[]{90,83},2);
		MAP.put(new int[]{99,38},3);
		MAP.put(new int[]{32,84},4);
		MAP.put(new int[]{37,42},4);
		MAP.put(new int[]{13,87},4);
		MAP.put(new int[]{33,54},4);
		MAP.put(new int[]{22,66},3);
		MAP.put(new int[]{72,83},4);
		MAP.put(new int[]{79,48},7);
		MAP.put(new int[]{48,92},4);
		MAP.put(new int[]{72,56},3);
		MAP.put(new int[]{70,95},3);
		MAP.put(new int[]{16,15},5);
		MAP.put(new int[]{85,65},2);
		MAP.put(new int[]{74,64},2);
		MAP.put(new int[]{59,91},2);
		MAP.put(new int[]{59,68},7);
		MAP.put(new int[]{23,13},3);
		MAP.put(new int[]{22,79},4);
		MAP.put(new int[]{23,58},4);
		MAP.put(new int[]{93,58},5);
		MAP.put(new int[]{45,51},4);
		MAP.put(new int[]{29,93},1);
		MAP.put(new int[]{64,52},4);
		MAP.put(new int[]{98,66},1);
		MAP.put(new int[]{19,19},0);
		MAP.put(new int[]{47,59},2);
		MAP.put(new int[]{31,20},3);
		MAP.put(new int[]{66,94},3);
		MAP.put(new int[]{90,43},4);
		MAP.put(new int[]{76,30},3);
		MAP.put(new int[]{88,80},1);
		MAP.put(new int[]{39,69},3);
		MAP.put(new int[]{34,33},2);
		MAP.put(new int[]{12,65},4);
		MAP.put(new int[]{21,30},3);
		MAP.put(new int[]{46,60},2);
		MAP.put(new int[]{28,87},4);
		MAP.put(new int[]{17,63},4);
		MAP.put(new int[]{20,96},4);
		MAP.put(new int[]{32,60},3);
		MAP.put(new int[]{34,83},4);
		MAP.put(new int[]{48,21},3);
		MAP.put(new int[]{46,19},5);
		MAP.put(new int[]{74,67},2);
		MAP.put(new int[]{38,20},3);
		MAP.put(new int[]{49,38},4);
		MAP.put(new int[]{39,19},3);
		MAP.put(new int[]{86,11},5);
		MAP.put(new int[]{92,34},6);
		MAP.put(new int[]{41,74},4);
		MAP.put(new int[]{42,98},2);
		MAP.put(new int[]{84,40},5);
		MAP.put(new int[]{74,43},3);
		MAP.put(new int[]{61,74},6);
		MAP.put(new int[]{51,65},4);
		MAP.put(new int[]{95,69},3);
		MAP.put(new int[]{66,55},5);
		MAP.put(new int[]{57,56},1);
		MAP.put(new int[]{33,29},4);
		MAP.put(new int[]{50,53},3);
		MAP.put(new int[]{61,86},5);
		MAP.put(new int[]{20,89},4);
		MAP.put(new int[]{45,65},4);
		MAP.put(new int[]{94,72},3);
		MAP.put(new int[]{50,48},1);
		MAP.put(new int[]{100,2},4);
		MAP.put(new int[]{69,77},1);
		MAP.put(new int[]{38,15},3);
		MAP.put(new int[]{41,91},4);
		MAP.put(new int[]{91,39},5);
		MAP.put(new int[]{48,48},0);
		MAP.put(new int[]{34,77},6);
		MAP.put(new int[]{33,71},4);
		MAP.put(new int[]{86,97},5);
		MAP.put(new int[]{42,61},4);
		MAP.put(new int[]{12,84},3);
		MAP.put(new int[]{97,23},5);
		MAP.put(new int[]{97,84},4);
		MAP.put(new int[]{94,99},5);
		MAP.put(new int[]{44,35},4);
		MAP.put(new int[]{85,82},3);
		MAP.put(new int[]{100,93},4);
		MAP.put(new int[]{100,19},6);
		MAP.put(new int[]{35,100},4);
		MAP.put(new int[]{142477161,8758737},15);
		MAP.put(new int[]{34751216,12635570},12);
		MAP.put(new int[]{426507425,9208782},22);
		MAP.put(new int[]{6573279,270228250},16);
		MAP.put(new int[]{12197699,995126264},20);
		MAP.put(new int[]{16602340,816015825},16);
		MAP.put(new int[]{176889033,65234399},13);
		MAP.put(new int[]{218557500,55055279},19);
		MAP.put(new int[]{22641368,956322174},15);
		MAP.put(new int[]{227819147,96322502},15);
		MAP.put(new int[]{23402911,368502823},15);
		MAP.put(new int[]{26093806,181849486},13);
		MAP.put(new int[]{312975821,81848634},16);
		MAP.put(new int[]{359565339,67927402},15);
		MAP.put(new int[]{418040651,61504501},14);
		MAP.put(new int[]{433207713,433585792},9);
		MAP.put(new int[]{454172187,70314449},18);
		MAP.put(new int[]{461597939,536308763},9);
		MAP.put(new int[]{46396211,785447132},16);
		MAP.put(new int[]{48939383,767923597},19);
		MAP.put(new int[]{568495044,83898436},13);
		MAP.put(new int[]{607352729,758284165},7);
		MAP.put(new int[]{616169270,36340919},15);
		MAP.put(new int[]{641290382,97991577},18);
		MAP.put(new int[]{67332274,680815600},12);
		MAP.put(new int[]{71442139,125080542},12);
		MAP.put(new int[]{81778732,567216178},11);
		MAP.put(new int[]{824402826,71706164},17);
		MAP.put(new int[]{829659678,76263785},19);
		MAP.put(new int[]{837313074,92448054},13);
		MAP.put(new int[]{837554721,10599956},15);
		MAP.put(new int[]{861664019,67947403},16);
		MAP.put(new int[]{929742763,86996482},14);
		MAP.put(new int[]{88274661,748927419},17);
		MAP.put(new int[]{920493003,30200473},13);
		MAP.put(new int[]{921806257,384611712},9);
		MAP.put(new int[]{94718077,598914390},18);
		MAP.put(new int[]{961768319,79649293},17);
		MAP.put(new int[]{980655588,996320677},8);
		MAP.put(new int[]{101446558,770445815},18);
		MAP.put(new int[]{102094436,550992705},14);
		MAP.put(new int[]{110066980,605659756},15);
		MAP.put(new int[]{110607678,701740190},11);
		MAP.put(new int[]{114522912,795513472},15);
		MAP.put(new int[]{116404248,369941756},16);
		MAP.put(new int[]{127897801,634266063},11);
		MAP.put(new int[]{148598567,821587145},14);
		MAP.put(new int[]{152348309,198582748},11);
		MAP.put(new int[]{157518744,771578833},13);
		MAP.put(new int[]{161728431,802458782},16);
		MAP.put(new int[]{170360435,509858062},16);
		MAP.put(new int[]{173092732,597629029},16);
		MAP.put(new int[]{173186318,172837067},14);
		MAP.put(new int[]{175948183,601485151},14);
		MAP.put(new int[]{179570055,530698487},14);
		MAP.put(new int[]{182759097,780796022},18);
		MAP.put(new int[]{183990820,947617569},10);
		MAP.put(new int[]{192126635,587072625},16);
		MAP.put(new int[]{194073215,978479507},17);
		MAP.put(new int[]{212390602,749143672},13);
		MAP.put(new int[]{216571472,550322837},15);
		MAP.put(new int[]{217264579,651072620},18);
		MAP.put(new int[]{224155032,287923771},15);
		MAP.put(new int[]{225933253,513367768},16);
		MAP.put(new int[]{236180809,495739398},20);
		MAP.put(new int[]{238471503,660958848},18);
		MAP.put(new int[]{258012847,193924188},20);
		MAP.put(new int[]{259100512,401625425},13);
		MAP.put(new int[]{260248081,457682115},15);
		MAP.put(new int[]{272332725,683784555},20);
		MAP.put(new int[]{282964554,271761128},12);
		MAP.put(new int[]{291184928,207366128},12);
		MAP.put(new int[]{293582894,103042961},23);
		MAP.put(new int[]{295161573,909920316},17);
		MAP.put(new int[]{296560708,759905308},14);
		MAP.put(new int[]{296656458,553940207},15);
		MAP.put(new int[]{299906658,793184444},21);
		MAP.put(new int[]{312027093,868008850},13);
		MAP.put(new int[]{318425457,424385967},16);
		MAP.put(new int[]{320166258,222659933},16);
		MAP.put(new int[]{321170040,552691116},19);
		MAP.put(new int[]{328430207,769515005},17);
		MAP.put(new int[]{336068169,841261667},13);
		MAP.put(new int[]{336850960,510536743},18);
		MAP.put(new int[]{338506791,770953499},19);
		MAP.put(new int[]{343582270,392108220},13);
		MAP.put(new int[]{359010488,278778660},17);
		MAP.put(new int[]{360665591,824025542},12);
		MAP.put(new int[]{366545580,145121809},20);
		MAP.put(new int[]{371614921,343347012},13);
		MAP.put(new int[]{375706298,700074005},22);
		MAP.put(new int[]{383386334,888653308},13);
		MAP.put(new int[]{387807322,938851620},15);
		MAP.put(new int[]{389592938,626617583},15);
		MAP.put(new int[]{393524725,597964072},13);
		MAP.put(new int[]{410853120,546602575},16);
		MAP.put(new int[]{437417858,298062682},15);
		MAP.put(new int[]{438233014,331024971},19);
		MAP.put(new int[]{448324989,170443027},10);
		MAP.put(new int[]{451620238,258168209},14);
		MAP.put(new int[]{467842695,646964274},18);
		MAP.put(new int[]{468251418,409360460},15);
		MAP.put(new int[]{482761566,810395620},18);
		MAP.put(new int[]{484817334,966023401},17);
		MAP.put(new int[]{488630196,943288825},14);
		MAP.put(new int[]{490695306,244530514},16);
		MAP.put(new int[]{491268344,859961430},14);
		MAP.put(new int[]{493095842,574480668},21);
		MAP.put(new int[]{494657570,273187832},16);
		MAP.put(new int[]{496673238,267497156},13);
		MAP.put(new int[]{500957215,188794507},14);
		MAP.put(new int[]{501832656,397865498},16);
		MAP.put(new int[]{502059647,704542863},13);
		MAP.put(new int[]{502444338,907156662},14);
		MAP.put(new int[]{505119433,457091259},12);
		MAP.put(new int[]{514677850,806778666},17);
		MAP.put(new int[]{516532272,241569764},16);
		MAP.put(new int[]{520138122,796393506},14);
		MAP.put(new int[]{538425850,874357394},11);
		MAP.put(new int[]{543744442,232974952},14);
		MAP.put(new int[]{550318578,629085196},16);
		MAP.put(new int[]{550689800,181223893},19);
		MAP.put(new int[]{560370209,934710131},12);
		MAP.put(new int[]{568592055,478530554},17);
		MAP.put(new int[]{569354410,780843305},13);
		MAP.put(new int[]{573744684,187436957},15);
		MAP.put(new int[]{574814794,200721525},18);
		MAP.put(new int[]{580059976,813177793},13);
		MAP.put(new int[]{584654467,428076192},17);
		MAP.put(new int[]{585885830,776640022},13);
		MAP.put(new int[]{587283040,272821714},17);
		MAP.put(new int[]{597580715,429651997},15);
		MAP.put(new int[]{600148236,896133569},14);
		MAP.put(new int[]{613751685,721711322},18);
		MAP.put(new int[]{623179968,655672881},13);
		MAP.put(new int[]{624432626,748312363},12);
		MAP.put(new int[]{629399631,203289251},15);
		MAP.put(new int[]{636554491,506614534},22);
		MAP.put(new int[]{646153167,554997610},14);
		MAP.put(new int[]{652511003,261028198},19);
		MAP.put(new int[]{656006219,347936568},17);
		MAP.put(new int[]{656761175,814424826},17);
		MAP.put(new int[]{656763597,945024234},17);
		MAP.put(new int[]{670533797,366026373},11);
		MAP.put(new int[]{672724240,426685538},14);
		MAP.put(new int[]{676389182,942672987},13);
		MAP.put(new int[]{676999732,667834274},15);
		MAP.put(new int[]{680389060,353937598},16);
		MAP.put(new int[]{681527439,812804140},13);
		MAP.put(new int[]{698378476,939106242},19);
		MAP.put(new int[]{698862354,782940661},16);
		MAP.put(new int[]{701704038,787531610},13);
		MAP.put(new int[]{701918443,274748004},19);
		MAP.put(new int[]{701991407,322710690},18);
		MAP.put(new int[]{711070611,757323719},11);
		MAP.put(new int[]{722989178,233514231},17);
		MAP.put(new int[]{725123910,221872440},11);
		MAP.put(new int[]{725143666,739169864},13);
		MAP.put(new int[]{726151238,832476637},17);
		MAP.put(new int[]{738673556,212827159},13);
		MAP.put(new int[]{739227016,821089652},19);
		MAP.put(new int[]{739813011,505756875},15);
		MAP.put(new int[]{747964814,282328099},18);
		MAP.put(new int[]{749164690,766652549},11);
		MAP.put(new int[]{751741106,877577816},13);
		MAP.put(new int[]{763887921,765639064},11);
		MAP.put(new int[]{782050667,924136603},11);
		MAP.put(new int[]{787178021,828395509},16);
		MAP.put(new int[]{791139459,269506696},17);
		MAP.put(new int[]{791584531,703488865},14);
		MAP.put(new int[]{793700944,937374471},15);
		MAP.put(new int[]{806608961,618389336},14);
		MAP.put(new int[]{810835771,203096023},15);
		MAP.put(new int[]{819954190,308398594},12);
		MAP.put(new int[]{821213152,975555037},19);
		MAP.put(new int[]{828640824,528487515},15);
		MAP.put(new int[]{832801037,465795220},14);
		MAP.put(new int[]{833682467,489934417},13);
		MAP.put(new int[]{837876154,671112135},16);
		MAP.put(new int[]{840239156,562528230},16);
		MAP.put(new int[]{843373849,248200015},18);
		MAP.put(new int[]{857208044,970485732},14);
		MAP.put(new int[]{862847176,452491991},17);
		MAP.put(new int[]{864147236,324047552},12);
		MAP.put(new int[]{876109654,127775525},18);
		MAP.put(new int[]{877221478,405289348},16);
		MAP.put(new int[]{907939716,709656791},15);
		MAP.put(new int[]{913730770,756565808},17);
		MAP.put(new int[]{922379758,512618749},15);
		MAP.put(new int[]{931636009,977843305},14);
		MAP.put(new int[]{932992634,223845146},16);
		MAP.put(new int[]{935991217,963777741},14);
		MAP.put(new int[]{961536018,817634739},18);
		MAP.put(new int[]{971539527,411144404},12);
		MAP.put(new int[]{977707324,929127662},18);
		MAP.put(new int[]{979343166,406143119},16);
		MAP.put(new int[]{986250408,682878964},16);
		MAP.put(new int[]{987425418,879958256},17);
		MAP.put(new int[]{989666712,409668392},12);
		MAP.put(new int[]{999129730,708386147},16);
	}

	@Test
	void minBitFlips()
	{
		for (Map.Entry<int[], Integer> entry : MAP.entrySet())
		{
			assert entry.getKey().length == 2;
			final int[] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = MinimumBitFlipsToConvertNumber.minBitFlips(input[0], input[1]);

			String message = String.format("Test failed for case:"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s",
				"Input", Arrays.toString(input),
				"Expected", expected,
				"Actual", actual
			);

			assertEquals(expected, actual, message);
		}
	}

	static void generateTests()
	{
		for (int i = 0; i < 200; i++)
		{
			int[] ints = DataUtils.generateArray(IntArraySpec
				.builder(2)
				.fixedSize()
				.bounds(0, 100)
				.build());
			String input = Arrays.toString(ints)
				.replaceAll("\\[", "{")
				.replaceAll("]", "}")
				.replaceAll(" ", "");
			System.out.printf("MAP.put(new int[]%s,%s);%n",input, validate(ints[0], ints[1]));
		}
	}

	static int validate(int a, int b)
	{
		return Integer.bitCount(a ^ b);
	}
}