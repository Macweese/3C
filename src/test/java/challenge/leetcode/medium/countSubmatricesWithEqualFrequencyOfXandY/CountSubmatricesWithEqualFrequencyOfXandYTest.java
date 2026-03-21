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

package challenge.leetcode.medium.countSubmatricesWithEqualFrequencyOfXandY;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 07:05 Thu 19 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3212. Count Submatrices With Equal Frequency of X and Y")
class CountSubmatricesWithEqualFrequencyOfXandYTest
{
	private static final Map<char[][], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new char[][]{{'X','Y','.'},{'Y','.','.'}},3);
		MAP.put(new char[][]{{'X','X'},{'X','Y'}},0);
		MAP.put(new char[][]{{'.','.'},{'.','.'}},0);
		MAP.put(new char[][]{{'.','X'},{'.','Y'}},8);
		MAP.put(new char[][]{{'.','Y'},{'Y','X'}},1);
		MAP.put(new char[][]{{'.','X','.'},{'.','.','Y'}},0);
		MAP.put(new char[][]{{'X','Y','.','X'},{'Y','.','X','Y'},{'X','.','Y','.'}},1);
	}

	@Test
	void numberOfSubmatrices()
	{
		for (Map.Entry<char[][], Integer> entry : MAP.entrySet())
		{
			final char[][] grid = entry.getKey();
			final int expected = entry.getValue();
			final int actual = CountSubmatricesWithEqualFrequencyOfXandY.numberOfSubmatrices(grid);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.deepToString(grid),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}
}