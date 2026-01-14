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

package challenge.leetcode.medium.separateSquaresI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 13:59 Tue 13 January 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("Separate Squares I")
class SeparateSquaresITest
{
	private static final Map<int[][], Double> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{0,0,1},{2,2,1}},1.00000);
		MAP.put(new int[][]{{0,0,2},{1,1,1}},1.16667);
		MAP.put(new int[][]{{75,80,39},{141,150,38},{123,132,53},{44,84,99}},141.96382);
		MAP.put(new int[][]{{75,80,39},{141,150,38},{123,132,53},{44,84,99}},141.96382);
		MAP.put(new int[][]{{102,171,57},{69,112,40},{7,179,51},{187,196,84}},213.50521);
		MAP.put(new int[][]{{89,186,6},{125,146,32},{75,165,91},{160,168,50}},200.53546);
		MAP.put(new int[][]{{58,94,66},{184,193,100},{36,116,68},{46,178,31}},197.01145);
		MAP.put(new int[][]{{183,194,89},{191,195,25},{62,195,36},{23,49,74}},208.96000);
		MAP.put(new int[][]{{102,171,57},{69,112,40},{7,179,51},{187,196,84}},213.50521);
		MAP.put(new int[][]{{89,186,6},{125,146,32},{75,165,91},{160,168,50}},200.53546);
		MAP.put(new int[][]{{183,194,89},{191,195,25},{62,195,36},{23,49,74}},208.96000);
		MAP.put(new int[][]{{58,94,66},{184,193,100},{36,116,68},{46,178,31}},197.01145);
		MAP.put(new int[][]{{45,94,15},{184,185,81},{118,137,94},{110,138,45}},196.78000);
		MAP.put(new int[][]{{92,158,83},{98,138,60},{103,126,83},{118,195,25}},180.76770);
		MAP.put(new int[][]{{45,94,15},{184,185,81},{118,137,94},{110,138,45}},196.78000);
		MAP.put(new int[][]{{92,158,83},{98,138,60},{103,126,83},{118,195,25}},180.76770);
		MAP.put(new int[][]{{18,154,72},{134,198,59},{117,159,76},{173,193,39}},204.72358);
		MAP.put(new int[][]{{18,154,72},{134,198,59},{117,159,76},{173,193,39}},204.72358);
		MAP.put(new int[][]{{522215,95664,461743},{62872,718652,21764},{6197368,9410679,911},{35502,65618,43726},{66,965,853},{816,839,815},{5807,653,6919},{186,252,357},{1,909,9906},{2,935,4625}},324796.03371);
		MAP.put(new int[][]{{522261215,954313664,225462},{628661372,718610752,10667},{619734768,941310679,44788},{352367502,656774918,289036},{860247066,905800565,100123},{817623994,962847576,71460},{691552058,782740602,36271},{911356,152015365,513881},{462847044,859151855,233567},{672324240,954509294,685569}},954521423.80202);
	}

	@Test
	void separateSquares()
	{
		for (Map.Entry<int[][], Double> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final double expected = entry.getValue();
			final double actual = SeparateSquaresI.separateSquares(input);

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