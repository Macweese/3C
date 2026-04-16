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

package challenge.leetcode.easy.smallestEvenMultiple;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 17:49 Tue 18 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2413. Smallest Even Multiple")
class SmallestEvenMultipleTest
{
	private static final Map<Integer, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(1,2);
		MAP.put(8,8);
		MAP.put(3,6);
		MAP.put(6,6);
		MAP.put(4,4);
		MAP.put(9,18);
		MAP.put(27,54);
		MAP.put(32,32);
		MAP.put(84,84);
		MAP.put(43,86);
		MAP.put(14,14);
		MAP.put(19,38);
		MAP.put(50,50);
		MAP.put(72,72);
		MAP.put(40,40);
		MAP.put(86,86);
		MAP.put(49,98);
		MAP.put(98,98);
		MAP.put(48,48);
		MAP.put(21,42);
		MAP.put(24,24);
		MAP.put(23,46);
		MAP.put(12,12);
		MAP.put(88,88);
		MAP.put(60,60);
		MAP.put(30,30);
		MAP.put(10,10);
		MAP.put(58,58);
		MAP.put(25,50);
		MAP.put(80,80);
		MAP.put(90,90);
		MAP.put(52,52);
		MAP.put(78,78);
		MAP.put(44,44);
		MAP.put(56,56);
		MAP.put(94,94);
		MAP.put(34,34);
		MAP.put(77,154);
		MAP.put(61,122);
		MAP.put(73,146);
		MAP.put(81,162);
		MAP.put(93,186);
		MAP.put(55,110);
		MAP.put(67,134);
		MAP.put(83,166);
		MAP.put(59,118);
		MAP.put(87,174);
		MAP.put(69,138);
		MAP.put(95,190);
		MAP.put(51,102);
		MAP.put(85,170);
		MAP.put(91,182);
		MAP.put(57,114);
		MAP.put(118,118);
		MAP.put(132,132);
		MAP.put(144,144);
		MAP.put(131,262);
		MAP.put(122,122);
		MAP.put(120,120);
		MAP.put(148,148);
		MAP.put(142,142);
		MAP.put(141,282);
		MAP.put(128,128);
		MAP.put(113,226);
		MAP.put(109,218);
		MAP.put(125,250);
		MAP.put(111,222);
		MAP.put(134,134);
		MAP.put(114,114);
		MAP.put(117,234);
	}

	@Test
	void smallestEvenMultiple()
	{
		for (Map.Entry<Integer, Integer> entry : MAP.entrySet())
		{
			final int input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = SmallestEvenMultiple.smallestEvenMultiple(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s",
				"Input", input,
				"Expected", expected,
				"Actual", actual,
				"");

			assertEquals(expected, actual, message);
		}
	}
}