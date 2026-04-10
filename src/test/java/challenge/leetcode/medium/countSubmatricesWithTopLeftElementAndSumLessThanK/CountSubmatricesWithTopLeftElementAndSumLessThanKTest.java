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

package challenge.leetcode.medium.countSubmatricesWithTopLeftElementAndSumLessThanK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 09:38 Wed 18 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3070. Count Submatrices with Top-Left Element and Sum Less Than K")
class CountSubmatricesWithTopLeftElementAndSumLessThanKTest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[][]{{1}}, 1), 1);
		MAP.put(new Input(new int[][]{{7, 6, 3}, {6, 6, 1}}, 10), 4);
		MAP.put(new Input(new int[][]{{7, 2, 9}, {1, 5, 0}, {2, 6, 6}}, 20), 6);
		MAP.put(new Input(new int[][]{{10, 12}, {14, 15}, {1, 1}, {3, 90}}, 44), 5);
		MAP.put(new Input(new int[][]{{1000, 1000}, {999, 999}, {888, 888}, {111, 111}}, 900), 0);
		MAP.put(new Input(new int[][]{{1000, 23}, {999, 99}, {99, 199}, {998, 997}, {996, 995}, {994, 991}}, 1000), 1);
		MAP.put(new Input(new int[][]{{10, 12, 12, 1, 2}, {14, 15, 45, 76, 3}, {1, 1, 4, 76, 23}, {3, 90, 87, 54, 876}}, 248), 15);
		MAP.put(new Input(new int[][]{{500, 23, 28}, {499, 69, 39}, {59, 169, 34}, {698, 967, 234}, {956, 925, 888}, {794, 691, 678}, {1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}, {100, 100, 200}}, 3000), 12);
		MAP.put(new Input(new int[][]{{7, 562, 9}, {1, 5, 0}, {2, 6, 6}, {7, 2, 99}, {1, 5, 0}, {2, 6, 6}, {7, 2, 9}, {1, 5, 0}, {2, 6, 6}, {7, 2, 9}, {1, 5, 0}, {2, 6, 6}, {7, 2, 9}, {1, 65, 0}, {2, 6, 6}, {7, 2, 92}, {1, 65, 0}, {2, 63, 6}, {7, 2, 9}, {1, 5, 0}, {2, 6, 6}, {7, 2, 9}, {1, 5, 0}, {2, 6, 56}, {7, 12, 9}, {1, 5, 0}, {2, 6, 6}}, 55), 15);
		MAP.put(new Input(new int[][]{{7, 6, 3}, {6, 6, 1}, {1, 6, 12}, {16, 36, 11}, {7, 6, 3}, {6, 6, 1}, {7, 6, 3}, {6, 6, 1}, {1, 6, 12}, {16, 36, 11}, {7, 6, 3}, {6, 6, 1}, {17, 6, 3}, {6, 69, 1}, {1, 61, 12}, {16, 36, 11}, {7, 6, 3}, {6, 6, 1}, {7, 6, 3}, {6, 6, 1}, {1, 6, 12}, {16, 36, 11}, {7, 6, 3}, {6, 68, 1}, {7, 6, 3}, {6, 65, 1}, {1, 68, 12}, {16, 36, 11}, {7, 6, 3}, {6, 6, 1}}, 18), 5);
	}

	@Test
	void countSubmatrices()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int[][] grid = entry.getKey().grid();
			final int k = entry.getKey().k();
			final int expected = entry.getValue();
			final int actual = CountSubmatricesWithTopLeftElementAndSumLessThanK.countSubmatrices(grid, k);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Grid", Arrays.deepToString(grid),
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

record Input(int[][] grid, int k)
{

}