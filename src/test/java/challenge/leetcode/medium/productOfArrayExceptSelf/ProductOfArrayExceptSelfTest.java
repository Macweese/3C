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

package challenge.leetcode.medium.productOfArrayExceptSelf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.DataUtils;
import utils.IntArraySpec;

/**
 * @author Administrator
 * @Created 11:25 Wed 15 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("238. Product of Array Except Self")
class ProductOfArrayExceptSelfTest
{
	private static final Map<int[], int[]> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{-15,-9,13,29,29,16,20},new int[]{-31487040,-52478400,36331200,16286400,16286400,29519100,23615280});
		MAP.put(new int[]{21,-16,-12,-13,-21,-23,7},new int[]{-8438976,11076156,14768208,13632192,8438976,7705152,-25316928});
		MAP.put(new int[]{10,-30,-25,-15,-26,23,-4},new int[]{-26910000,8970000,10764000,17940000,10350000,-11700000,67275000});
		MAP.put(new int[]{-26,-11,6,-13,23,19,-26},new int[]{-9748596,-23042136,42243916,-19497192,11020152,13340184,-9748596});
		MAP.put(new int[]{20,21,-12,30,-30,-5,-11},new int[]{12474000,11880000,-20790000,8316000,-8316000,-49896000,-22680000});
		MAP.put(new int[]{20,24,29,5,15,11,-25},new int[]{-14355000,-11962500,-9900000,-57420000,-19140000,-26100000,11484000});
		MAP.put(new int[]{22,22,22,-6,-13,-16,-23},new int[]{13892736,13892736,13892736,-50940032,-23510784,-19102512,-13288704});
		MAP.put(new int[]{27,28,28,8,-19,-25,-17},new int[]{-50646400,-48837600,-48837600,-170931600,71971200,54698112,80438400});
		MAP.put(new int[]{28,-18,-25,-11,-10,22,28},new int[]{30492000,-47432000,-34151040,-77616000,-85377600,38808000,30492000});
		MAP.put(new int[]{-24,-3,-19,-20,25,2,-8,15},new int[]{6840000,54720000,8640000,8208000,-6566400,-82080000,20520000,-10944000});
		MAP.put(new int[]{12,-2,-28,20,9,10,-5,22},new int[]{-11088000,66528000,4752000,-6652800,-14784000,-13305600,26611200,-6048000});
		MAP.put(new int[]{-30,-17,29,-2,-9,-8,-4,-29},new int[]{8235072,14532480,-8519040,123526080,27450240,30881520,61763040,8519040});
		MAP.put(new int[]{-26,-28,-18,-3,5,2,-18,30},new int[]{8164800,7581600,11793600,70761600,-42456960,-106142400,11793600,-7076160});
		MAP.put(new int[]{-7,8,-27,-19,-6,-26,7,11},new int[]{49297248,-43135092,12780768,18162144,57513456,13272336,-49297248,-31370976});
		MAP.put(new int[]{28,-9,-3,19,18,-8,8,-17},new int[]{10046592,-31256064,-93768192,14805504,15628032,-35163072,35163072,-16547328});
		MAP.put(new int[]{-13,-9,21,-9,-22,6,23,-15},new int[]{77463540,111891780,-47953620,111891780,45773910,-167837670,-43783740,67135068});
		MAP.put(new int[]{30,10,-26,-22,30,-11,-6,3},new int[]{33976800,101930400,-39204000,-46332000,33976800,-92664000,-169884000,339768000});
		MAP.put(new int[]{23,-8,-5,16,-20,-24,13,-18},new int[]{-71884800,206668800,330670080,-103334400,82667520,68889600,-127180800,91852800});
		MAP.put(new int[]{23,1,6,-30,2,-9,11,18,-15},new int[]{-9622800,-221324400,-36887400,7377480,-110662200,24591600,-20120400,-12295800,14754960});
		MAP.put(new int[]{-2,-29,9,1,9,-12,13,-25,19},new int[]{-174060900,-12004200,38680200,348121800,38680200,-29010150,26778600,-13924872,18322200});
		MAP.put(new int[]{-21,-5,-1,18,-10,-29,22,1,24},new int[]{13780800,57879360,289396800,-16077600,28939680,9979200,-13154400,-289396800,-12058200});
		MAP.put(new int[]{-28,-21,-1,-4,-23,6,6,-17,-23},new int[]{27194832,36259776,761455296,190363824,33106752,-126909216,-126909216,44791488,33106752});
		MAP.put(new int[]{-1,26,-20,-4,15,25,14,19,4},new int[]{829920000,-31920000,41496000,207480000,-55328000,-33196800,-59280000,-43680000,-207480000});
		MAP.put(new int[]{29,-12,-28,20,-14,9,-27,1,3},new int[]{68584320,-165745440,-71033760,99447264,-142067520,220993920,-73664640,1988945280,662981760});
		MAP.put(new int[]{7,-9,-7,-10,-30,-4,7,-20,23},new int[]{243432000,-189336000,-243432000,-170402400,-56800800,-426006000,243432000,-85201200,74088000});
		MAP.put(new int[]{-24,15,1,-18,18,-11,14,-7,13},new int[]{-68108040,108972864,1634592960,-90810720,90810720,-148599360,116756640,-233513280,125737920});
		MAP.put(new int[]{-6,-10,-29,1,-24,-20,-10,-17,-5},new int[]{-118320000,-70992000,-24480000,709920000,-29580000,-35496000,-70992000,-41760000,-141984000});
		MAP.put(new int[]{-26,14,25,-25,-1,-21,-6,-6,-1,3},new int[]{19845000,-36855000,-20638800,20638800,515970000,24570000,85995000,85995000,515970000,-171990000});
		MAP.put(new int[]{-19,13,-19,-30,-2,-22,8,2,9,-2,-1},new int[]{93899520,-137237760,93899520,59469696,892045440,81095040,-223011360,-892045440,-198232320,892045440,1784090880});
		MAP.put(new int[]{2,-2,5,8,-6,-8,8,-6,1,7,3,5,8},new int[]{154828800,-154828800,61931520,38707200,-51609600,-38707200,38707200,-51609600,309657600,44236800,103219200,61931520,38707200});
		MAP.put(new int[]{6,-2,-9,8,-7,-6,-7,-8,-8,1,-1,7,5},new int[]{94832640,-284497920,-63221760,71124480,-81285120,-94832640,-81285120,-71124480,-71124480,568995840,-568995840,81285120,113799168});
		MAP.put(new int[]{8,-5,6,-1,-1,5,5,7,9,-6,9,-5,8},new int[]{-102060000,163296000,-136080000,816480000,816480000,-163296000,-163296000,-116640000,-90720000,136080000,-90720000,163296000,-102060000});
		MAP.put(new int[]{5,-7,-3,3,8,3,-7,-8,-8,3,9,-8,2},new int[]{292626432,-209018880,-487710720,487710720,182891520,487710720,-209018880,-182891520,-182891520,487710720,162570240,-182891520,731566080});
		MAP.put(new int[]{3,9,3,2,-8,7,-6,6,3,8,5,9,-5},new int[]{-587865600,-195955200,-587865600,-881798400,220449600,-251942400,293932800,-293932800,-587865600,-220449600,-352719360,-195955200,352719360});
		MAP.put(new int[]{-2,9,-4,-4,6,-5,-8,8,8,3,-8,-6,-2},new int[]{-637009920,141557760,-318504960,-318504960,212336640,-254803968,-159252480,159252480,159252480,424673280,-159252480,-212336640,-637009920});
		MAP.put(new int[]{9,-8,3,-8,-8,4,-8,8,2,-1,-3,3,1,9},new int[]{63700992,-71663616,191102976,-71663616,-71663616,143327232,-71663616,71663616,286654464,-573308928,-191102976,191102976,573308928,63700992});
		MAP.put(new int[]{-7,1,-4,-3,9,8,-8,9,-6,-2,3,6,3,-3},new int[]{120932352,-846526464,211631616,282175488,-94058496,-105815808,105815808,-94058496,141087744,423263232,-282175488,-141087744,-282175488,282175488});
		MAP.put(new int[]{-4,-2,-1,-9,-5,6,-9,-5,-9,3,-8,4,3,7},new int[]{440899200,881798400,1763596800,195955200,352719360,-293932800,195955200,352719360,195955200,-587865600,220449600,-440899200,-587865600,-251942400});
		MAP.put(new int[]{4,-5,-5,6,6,1,-7,-6,1,-6,-6,-6,4,9},new int[]{-293932800,235146240,235146240,-195955200,-195955200,-1175731200,167961600,195955200,-1175731200,195955200,195955200,195955200,-293932800,-130636800});
		MAP.put(new int[]{3,2,1,9,-2,3,-7,6,5,-2,3,-7,5,-5,8},new int[]{-190512000,-285768000,-571536000,-63504000,285768000,-190512000,81648000,-95256000,-114307200,285768000,-190512000,81648000,-114307200,114307200,-71442000});
		MAP.put(new int[]{-8,6,3,-3,1,5,3,-5,9,-4,-1,-4,-3,-8,9},new int[]{-125971200,167961600,335923200,-335923200,1007769600,201553920,335923200,-201553920,111974400,-251942400,-1007769600,-251942400,-335923200,-125971200,111974400});
		MAP.put(new int[]{1,3,6,5,-6,-2,-9,9,-3,2,7,-7,-8,-2,-5},new int[]{2057529600,685843200,342921600,411505920,-342921600,-1028764800,-228614400,228614400,-685843200,1028764800,293932800,-293932800,-257191200,-1028764800,-411505920});
		MAP.put(new int[]{-7,-9,-2,-1,-6,-7,-9,1,-7,1,-2,-4,-8,-1,1,-4,-9},new int[]{-109734912,-85349376,-384072192,-768144384,-128024064,-109734912,-85349376,768144384,-109734912,768144384,-384072192,-192036096,-96018048,-768144384,768144384,-192036096,-85349376});
	}

	@Test
	void productExceptSelf()
	{
		for (Map.Entry<int[], int[]> entry : MAP.entrySet())
		{
			final int[] input = entry.getKey();
			final int[] expected = entry.getValue();
			final int[] actual = ProductOfArrayExceptSelf.productExceptSelf(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"ints", Arrays.toString(input),
				"Expected", Arrays.toString(expected),
				"Actual", Arrays.toString(actual),
				""
			);

			assertArrayEquals(expected, actual, message);
		}
	}

//	static void main()
//	{
//		generate();
//	}

	private static void generate()
	{
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 53; i++)
		{
			int size = ThreadLocalRandom.current().nextInt(20) + 1;
			int[] vals = DataUtils.generateArray(IntArraySpec.builder(size)
				.bounds(-9, 9)
				.build());

			int[] ints = new int[0];
			float val = vals[0];
			for (int j = 1; j < vals.length; j++)
			{
				float total = val * vals[j];
				if (total > Integer.MAX_VALUE || total < Integer.MIN_VALUE)
				{
					ints = Arrays.copyOfRange(vals, 0, j);
					break;
				}

				val *= vals[j];
			}

			if (ints.length == 0)
			{
				continue;
			}

			System.out.println(Arrays.toString(ints));
			String a = Arrays.toString(ints)
				.replaceAll("\\[", "{")
				.replaceAll("]", "}")
				.replaceAll(" ", "");
			String b = Arrays.toString(validate(ints))
				.replaceAll("\\[", "{")
				.replaceAll("]", "}")
				.replaceAll(" ", "");

			stringBuilder.append(String.format("MAP.put(new int[]%s,new int[]%s);%n", a, b));
		}
		IO.println(stringBuilder);
	}

	private static int[] validate(int[] ints)
	{
		int n = ints.length;
		int[] ans = new int[n];
		Arrays.fill(ans, 0);
		int product = 1;
		int zeros = 0;

		for (int num : ints)
		{
			if (num == 0)
			{
				zeros++;
				continue;
			}
			product *= num;
		}

		if (zeros == 1)
		{
			for (int i = 0; i < n; i++)
			{
				ans[i] = ints[i] == 0 ? product : 0;
			}
		}
		else if (zeros == 0)
		{
			for (int i = 0; i < n; i++)
			{
				ans[i] = product / ints[i];
			}
		}

		return ans;
	}
}