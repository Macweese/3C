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

package challenge.leetcode.hard.maxDotProductOfTwoSubsequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:26 Thu 08 January 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1458. Max Dot Product of Two Subsequences")
class MaxDotProductOfTwoSubsequencesTest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[]{2,1,-2,5}, new int[]{3,0,-6}),18);
		MAP.put(new Input(new int[]{3,-2}, new int[]{2,-6,7}),21);
		MAP.put(new Input(new int[]{-1,-1}, new int[]{1,1}),-1);
		MAP.put(new Input(new int[]{-3,-8,3,-10,1,3,9}, new int[]{9,2,3,7,-9,1,-8,5,-1,-1}),200);
		MAP.put(new Input(new int[]{-5,3,-5,-3,1}, new int[]{-2,4,2,5,-5}),50);
//		MAP.put(new Input(new int[], new int[]),);
	}

	@Test
	void maxDotProduct()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int[] a = entry.getKey().a();
			final int[] b = entry.getKey().b();
			final int expected = entry.getValue();
			final int actual = MaxDotProductOfTwoSubsequences.maxDotProduct(a, b);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"a", Arrays.toString(a),
				"b", Arrays.toString(b),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(int[] a, int[] b)
{

}