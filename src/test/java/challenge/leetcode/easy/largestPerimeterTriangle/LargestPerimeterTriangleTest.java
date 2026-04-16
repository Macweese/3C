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

package challenge.leetcode.easy.largestPerimeterTriangle;

import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("976. Largest Perimeter Triangle")
class LargestPerimeterTriangleTest
{
	@RepeatedTest(value = 100)
	void largestPerimeterTest()
	{
		final int[] input = generateTest();
		final int expected = validate(input);
		final int actual = LargestPerimeterTriangle.largestPerimeter(input);

		String message = String.format("Test failed for case:"
				+ "%n%10s : %s"
				+ "%n%10s : %s"
				+ "%n%10s : %s"
				+ "%n%10s",
			"Input", Arrays.toString(input),
			"Expected", expected,
			"Actual", actual,
			"");

		assertEquals(expected, actual, message);
	}

	private static int[] generateTest()
	{
		Random r = new Random();
		int n = r.nextInt(9_997) + 3;
		int[] sides = new int[n];

		for (int i = 0; i < n; i++)
		{
			sides[i] = r.nextInt(100_000) + 1;
		}

		return sides;
	}

	private static int validate(int[] nums)
	{
		Arrays.sort(nums);

		for (int i = nums.length - 3; i >= 0; --i)
		{
			if (nums[i] + nums[i + 1] > nums[i + 2])
			{
				return nums[i] + nums[i + 1] + nums[i + 2];
			}
		}
		return 0;
	}
}