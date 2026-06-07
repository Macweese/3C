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

package challenge.leetcode.medium.increasingTripletSubsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 13:06 Fri 17 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("334. Increase Triplet Subsequence")
class IncreasingTripletSubsequenceTest
{
	private static final Map<int[], Boolean> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{1},false);
		MAP.put(new int[]{1,2,3,4,5},true);
		MAP.put(new int[]{5,4,3,2,1},false);
		MAP.put(new int[]{2,1,5,0,4,6},true);
		MAP.put(new int[]{2,1,5,0,2,3},true);
		MAP.put(new int[]{2,1,9,9,2,3},true);
		MAP.put(new int[]{1,5,0,4,1,3},true);
		MAP.put(new int[]{20,100,10,12,5,13},true);
		MAP.put(new int[]{1,8,5,987,12,120,677,55,505,550,100,22,5,1,1},true);
	}

	@Test
	void increasingTriplets()
	{
		for (Map.Entry<int[], Boolean> entry : MAP.entrySet())
		{
			final int[] input = entry.getKey();
			final boolean expected = entry.getValue();
			final boolean actual = IncreasingTripletSubsequence.increasingTriplets(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"ints", Arrays.toString(input),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}