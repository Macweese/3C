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

package challenge.leetcode.easy.countOddNumbersInAnIntervalRange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 11:14 Mon 08 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1523. Count Odd Numbers in an Interval Range")
class CountOddNumbersInAnIntervalRangeTest
{
	private static final Map<int[], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[]{3,7}, 3);
		MAP.put(new int[]{8,10}, 1);
		MAP.put(new int[]{8,8}, 0);
		MAP.put(new int[]{9,9}, 1);
		MAP.put(new int[]{9,10}, 1);
		MAP.put(new int[]{9,11}, 2);
		MAP.put(new int[]{10,10}, 0);
		MAP.put(new int[]{10,11}, 1);
		MAP.put(new int[]{10,20}, 5);
		MAP.put(new int[]{10,21}, 6);
		MAP.put(new int[]{10,22}, 6);
		MAP.put(new int[]{11,20}, 5);
		MAP.put(new int[]{11,21}, 6);
		MAP.put(new int[]{11,22}, 6);
		MAP.put(new int[]{719402,719402}, 0);
		MAP.put(new int[]{482096749,482096754}, 3);
		MAP.put(new int[]{237229904,237229906}, 1);
		MAP.put(new int[]{237229904,237229906}, 1);
		MAP.put(new int[]{297817089,297817091}, 2);
		MAP.put(new int[]{383930742,383930747}, 3);
		MAP.put(new int[]{922702628,922702628}, 0);
		MAP.put(new int[]{389429121,389429126}, 3);
		MAP.put(new int[]{828467237,828467237}, 1);
	}

	@Test
	void countOdds()
	{
		for (Map.Entry<int[], Integer> entry : MAP.entrySet())
		{
			final int[] interval = entry.getKey();
			assert interval.length == 2;

			final int expected = entry.getValue();
			final int actual = CountOddNumbersInAnIntervalRange.countOdds(interval[0], interval[1]);

			String message = String.format("Test failed for case:"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s",
				"Interval", Arrays.toString(interval),
				"Expected", expected,
				"Actual", actual
			);

			assertEquals(expected, actual, message);
		}
	}
}