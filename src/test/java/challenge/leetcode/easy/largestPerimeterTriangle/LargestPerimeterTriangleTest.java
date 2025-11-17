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

import challenge.leetcode.easy.largestPerimeterTriangle.LargestPerimeterTriangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("976. Largest Perimeter Triangle")
class LargestPerimeterTriangleTest
{
	@Test
	void largestPerimeter()
	{
		for (int[] TEST_CASE : TEST_CASES)
		{
			final int expected = largestPerimeter(TEST_CASE);
			final int actual = LargestPerimeterTriangle.largestPerimeter(TEST_CASE);

			String message = String.format("Test failed for case:"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s",
				"Input", Arrays.toString(TEST_CASE),
				"Expected", expected,
				"Actual", actual,
				"");

			assertEquals(expected, actual, message);
		}
	}

	static void main()
	{
		generateFailTest();
		for (int i = 0; i < 50; i++)
		{
			generateTest();
		}
	}

	private static void generateTest()
	{
		Random r = new Random();
		int n = r.nextInt(9_997) + 3;
		int[] sides = new int[n];

		for (int i = 0; i < n; i++)
		{
			sides[i] = r.nextInt(100_000) + 1;
		}

		TEST_CASES.add(sides);

		System.out.println(Arrays.toString(sides));
//		String input = Arrays.toString(sides).replaceAll("[\\[\\] ]", "");
//		System.out.printf("new int[]{%s}%n", input);
	}

	private static void generateFailTest()
	{
		Random r = new Random();
		int n = r.nextInt(9997) + 3;
		int[] sides = new int[n];

		for (int i = 0; i < n; i++)
		{
//			sides[i] = FIB[r.nextInt(FIB.length)];
			sides[i] = FIB[r.nextInt(1_000_000) + 1];
		}
		System.out.println(Arrays.toString(sides));
	}

	private static final int[] FIB = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025};

	private static final ArrayList<int[]> TEST_CASES = new ArrayList<>();

	private static int largestPerimeter(int[] nums)
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