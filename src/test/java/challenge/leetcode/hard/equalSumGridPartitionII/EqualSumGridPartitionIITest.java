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

package challenge.leetcode.hard.equalSumGridPartitionII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 07:03 Thu 26 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3548. Equal Sum Grid Partition II")
class EqualSumGridPartitionIITest
{
	private static final Map<int[][], Boolean> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{4,1,8},{3,2,6}},false);
		MAP.put(new int[][]{{1,2,4},{2,3,5}},true);

		MAP.put(new int[][]{{1,4},{2,3}},true);
		MAP.put(new int[][]{{1,3},{2,4}},false);
		MAP.put(new int[][]{{28443},{33959}},false);
		MAP.put(new int[][]{{78889},{73816}},false);
		MAP.put(new int[][]{{65917,79299}},false);
		MAP.put(new int[][]{{21257},{99761}},false);
		MAP.put(new int[][]{{49435,34517}},false);
		MAP.put(new int[][]{{49801},{92003}},false);
		MAP.put(new int[][]{{56281},{18537}},false);
		MAP.put(new int[][]{{93378,74996}},false);
		MAP.put(new int[][]{{9,23,1814,17,62},{129,24,2,113,263},{1,472,6,872,43}},true);
		MAP.put(new int[][]{{1220,411,89},{59840,2,24800},{3081,120,198},{33320,5,71836}},true);
		MAP.put(new int[][]{{2859,58111,40592,63369},{69368,46089,11915,49026},{21038,32207,55839,7013}},false);
		MAP.put(new int[][]{{33152,61995,95553,1020},{99596,48375,14523,38704},{7504,48023,19125,62686}},false);
		MAP.put(new int[][]{{21952,92334,99970,55025},{2680,44830,18404,45266},{36243,82132,76223,35831}},false);
		MAP.put(new int[][]{{74659,40905,53492,93275},{28405,79904,78071,20422},{76979,6815,36112,77759}},false);
		MAP.put(new int[][]{{3935,78063,51245},{71886,44801,85952},{19074,30611,30494},{34949,56262,25872}},false);
		MAP.put(new int[][]{{69993,72245,54157},{3173,41473,49412},{32066,89088,21694},{24599,61086,14522}},false);
		MAP.put(new int[][]{{100000,100000,100000,100000},{100000,99425,100000,100000},{100000,100000,55103,100000}},false);
		MAP.put(new int[][]{{27911,2753,34309,43378,87284},{27441,74365,52529,69375,56819},{14398,74424,29772,23742,84310}},false);
		MAP.put(new int[][]{{43912,79446,22279},{98061,59658,32519},{40411,14416,58553},{25134,33784,95847},{77002,86407,3397}},false);
		MAP.put(new int[][]{{1,1,1,198,1,1},{1,1,1,1,17668,1},{1,1,73,1,1,1},{31287,1,1,3,90,1},{10769,13297,6366,103,14429,4373}},true);
		MAP.put(new int[][]{{100000,100000,92095},{100000,51065,100000},{100000,100000,100000},{100000,100000,100000},{100000,2886,33337}},false);
		MAP.put(new int[][]{{2,1,3,7,1582,86,3},{1,6899,23909,14833,1,99,249},{1,1,1,1,2281,41012,1},{1,1,1,1,6,1,1},{19631,6568,36622,18231,1142,7126,1665}},true);
		MAP.put(new int[][]{{33,159,3549,692,73,60406},{23952,75031,58732,24684,68,42210},{57753,82,83918,46517,84640,56957},{28380,45259,958,90270,33345,73019},{77078,100000,100000,23857,100000,100000},{64979,46301,100000,91040,24377,63055}},true);
		MAP.put(new int[][]{{63749,70326,74908,61432,63076,52776,44833},{83368,34963,8369,44939,66055,95854,24675},{82066,94108,88885,87058,64472,50193,41313},{71510,63380,25574,13186,50431,84453,36544},{68438,42579,88162,53491,87075,35189,74604}},false);
		MAP.put(new int[][]{{62769,75348,57590,60879,97693},{80964,12896,64237,75341,89094},{71857,50530,51666,59898,97001},{35764,85190,6925,27267,30135},{31244,80233,32829,62091,26606},{49082,84127,51986,20103,3041},{1732,14562,63599,12215,90704}},false);
		MAP.put(new int[][]{{3833,65002,13332,9860,36798},{31574,28150,78549,43173,19329},{48784,96744,24037,96422,54607},{66339,62572,69185,21772,77605},{81291,91570,95627,61467,23677},{16062,54388,82458,23160,60861},{2713,36882,97731,34890,76350}},false);
		MAP.put(new int[][]{{62655,98124,32002,63072,98833},{38059,75195,46452,14924,89581},{25992,56131,38968,59850,68830},{62956,85675,43993,76409,3248},{98749,46671,36142,13844,98162},{99776,4322,44711,39678,26315},{10233,80227,97713,29693,31401}},false);
		MAP.put(new int[][]{{87392,84357,59352,96487,45188,2214},{6039,61341,10351,8216,16236,30085},{92248,74634,70524,75760,94347,29111},{34021,9302,14465,50835,12637,24815},{77775,25592,31903,31641,11166,70170},{34048,86633,67860,77558,15445,49494}},false);
		MAP.put(new int[][]{{97451,80466,66145,80038,48945,54460},{10009,82642,75618,39744,97227,25605},{44001,9359,9591,55424,77289,39114},{61850,37899,68083,77425,29922,78046},{11984,59730,41439,7940,19010,2210},{16961,22148,22365,50632,25229,54177}},false);
		MAP.put(new int[][]{{100000,100000,100000,100000,100000},{75742,73917,100000,11210,9299},{69400,100000,100000,85931,87892},{100000,41429,4846,32568,37786},{95269,62192,37688,72340,99886},{91009,62486,100000,21447,100000},{100000,15474,64933,12775,54172}},false);
		MAP.put(new int[][]{{58068,1027,18371,19994,38195,17811,28277,46139},{71905,43507,3995,12186,11475,67976,61706,56109},{25332,92530,27101,93432,14666,50201,95675,17069},{71530,34478,93051,73890,75298,32212,70879,54085},{99654,9310,961,65932,38239,590,45048,85604}},false);
		MAP.put(new int[][]{{100000,100000,100000,100000,100000},{100000,100000,100000,100000,100000},{100000,100000,100000,100000,10402},{100000,100000,32356,87815,40425},{56309,38932,100000,100000,100000},{100000,100000,100000,6835,71804},{100000,100000,100000,100000,100000}},false);
	}

	@Test
	void canPartitionGrid()
	{
		for (Map.Entry<int[][], Boolean> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final boolean expected = entry.getValue();
			final boolean actual = EqualSumGridPartitionII.canPartitionGrid(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.deepToString(input),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}