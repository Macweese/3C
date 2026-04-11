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

package challenge.leetcode.easy.minimumDistanceBetweenThreeEqualElementsI;

import com.google.common.base.Stopwatch;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * @author Administrator
 * @Created 06:37 Fri 10 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3740. Minimum Distance Between Three Equal Elements I")
class MinimumDistanceBetweenThreeEqualElementsITest
{
	private static final Map<int[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{1,2,1,1,3},6);
		MAP.put(new int[]{1,1,2,3,2,1,2},8);
		MAP.put(new int[]{1},-1);
		MAP.put(new int[]{1,1,1},4);
		MAP.put(new int[]{1,2,3,4,5},-1);
		MAP.put(new int[]{2,2,2,2},4);
		MAP.put(new int[]{1,2,1,2,1},8);
		MAP.put(new int[]{1,1,2,2,1,1},8);
		MAP.put(new int[]{3,3,1,3,3},6);
		MAP.put(new int[]{1,2,3,1,2,3,1},12);
		MAP.put(new int[]{5,4,3,2,1,5,5},12);
		MAP.put(new int[]{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},4);
		MAP.put(new int[]{5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4,5,4},8);
//		MAP.put(new int[],);
	}

	@Test
	@Timeout(3)
	void minimumDistance()
	{
		Stopwatch stopwatch;

		for (Map.Entry<int[], Integer> entry : MAP.entrySet())
		{

			final int[] ints = entry.getKey();
			final int expected = entry.getValue();

			stopwatch = Stopwatch.createStarted();
			final int actual = MinimumDistanceBetweenThreeEqualElementsI.minimumDistance(ints);
			stopwatch.stop();


			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.toString(ints),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}

	@Test
	@Timeout(3)
	void minimumDistanceFast()
	{
		for (Map.Entry<int[], Integer> entry : MAP.entrySet())
		{
			final int[] ints = entry.getKey();
			final int expected = entry.getValue();
			final int actual = MinimumDistanceBetweenThreeEqualElementsI.minimumDistanceFast(ints);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.toString(ints),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}