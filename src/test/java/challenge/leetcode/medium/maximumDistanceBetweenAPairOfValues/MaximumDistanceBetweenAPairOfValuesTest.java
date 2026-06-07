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

package challenge.leetcode.medium.maximumDistanceBetweenAPairOfValues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:04 Sun 19 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1855. Maximum Distance Between a Pair of Values")
class MaximumDistanceBetweenAPairOfValuesTest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[]{2,2,2},new int[]{10,10,1}),1);
		MAP.put(new Input(new int[]{55,30,5,4,2},new int[]{100,20,10,10,5}),2);
		MAP.put(new Input(new int[]{30,29,19,5},new int[]{25,25,25,25,25}),2);
		MAP.put(new Input(new int[]{10,9,8,7,6,5},new int[]{4,4,4,4,4,4,3,3,3,3,3,3,3,2,2,2,2,2,1,1,1,1,1}),0);
	}

	@Test
	void maxDistance()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int[] a = entry.getKey().a();
			final int[] b = entry.getKey().b();
			final int expected = entry.getValue();
			final int actual = MaximumDistanceBetweenAPairOfValues.maxDistance(a, b);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Ints A", Arrays.toString(a),
				"Ints B", Arrays.toString(b),
				"Output",
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