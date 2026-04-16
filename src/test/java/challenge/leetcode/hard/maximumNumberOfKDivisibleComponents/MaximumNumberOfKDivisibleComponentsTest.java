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

package challenge.leetcode.hard.maximumNumberOfKDivisibleComponents;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.Triple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 17:09 Fri 28 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2872. Maximum Number of K-Divisible Components ")
class MaximumNumberOfKDivisibleComponentsTest
{
	private static final Map<Triple<int[][], int[], Integer>, Integer> MAP = new HashMap<>();

	static
	{

	}

	@Test
	void maxDivisibleComponents()
	{
		for (Map.Entry<Triple<int[][], int[], Integer>, Integer> entry : MAP.entrySet())
		{
			int[][] edges = entry.getKey().getLeft();
			int[] values = entry.getKey().getMiddle();
			final int k = entry.getKey().getRight();
			final int expected = entry.getValue();
			final int actual = MaximumNumberOfKDivisibleComponents.maxDivisibleComponents(edges, values, k);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s",
				"Edges", Arrays.deepToString(edges),
				"Values", Arrays.toString(values),
				"k", k,
				"Expected", expected,
				"Actual", actual
			);

			assertEquals(expected, actual, message);
		}
	}
}