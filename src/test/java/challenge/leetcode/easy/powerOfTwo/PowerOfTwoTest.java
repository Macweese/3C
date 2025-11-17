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
package challenge.leetcode.easy.powerOfTwo;

import challenge.leetcode.easy.powerOfTwo.PowerOfTwo;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("231. Power of Two")
class PowerOfTwoTest
{
	private static final Map<Integer, Boolean> MAP = new HashMap<>();

	static
	{
		MAP.put(1, true);
		MAP.put(1000, false);
		MAP.put(1014, false);
		MAP.put(1021, false);
		MAP.put(1024, true);
		MAP.put(1048576, true);
		MAP.put(1073741824, true);
		MAP.put(117, false);
		MAP.put(128, true);
		MAP.put(129, false);
		MAP.put(131072, true);
		MAP.put(134, false);
		MAP.put(134217728, true);
		MAP.put(16, true);
		MAP.put(16384, true);
		MAP.put(166, false);
		MAP.put(16777216, true);
		MAP.put(174, false);
		MAP.put(176, false);
		MAP.put(187, false);
		MAP.put(2, true);
		MAP.put(20, false);
		MAP.put(200, false);
		MAP.put(2048, true);
		MAP.put(208, false);
		MAP.put(2097152, true);
		MAP.put(226, false);
		MAP.put(247, false);
		MAP.put(255, false);
		MAP.put(256, true);
		MAP.put(258, false);
		MAP.put(26, false);
		MAP.put(261, false);
		MAP.put(262144, true);
		MAP.put(268435456, true);
		MAP.put(269, false);
		MAP.put(276, false);
		MAP.put(290, false);
		MAP.put(297, false);
		MAP.put(298, false);
		MAP.put(3, false);
		MAP.put(311, false);
		MAP.put(32, true);
		MAP.put(327, false);
		MAP.put(32768, true);
		MAP.put(33, false);
		MAP.put(333, false);
		MAP.put(33554432, true);
		MAP.put(355, false);
		MAP.put(360, false);
		MAP.put(362, false);
		MAP.put(379, false);
		MAP.put(381, false);
		MAP.put(392, false);
		MAP.put(395, false);
		MAP.put(4, true);
		MAP.put(407, false);
		MAP.put(408, false);
		MAP.put(409, false);
		MAP.put(4096, true);
		MAP.put(419, false);
		MAP.put(4194304, true);
		MAP.put(428, false);
		MAP.put(442, false);
		MAP.put(446, false);
		MAP.put(457, false);
		MAP.put(46, false);
		MAP.put(48, false);
		MAP.put(480, false);
		MAP.put(481, false);
		MAP.put(489, false);
		MAP.put(49, false);
		MAP.put(493, false);
		MAP.put(496, false);
		MAP.put(50, false);
		MAP.put(503, false);
		MAP.put(511, false);
		MAP.put(512, true);
		MAP.put(524288, true);
		MAP.put(535, false);
		MAP.put(536870912, true);
		MAP.put(539, false);
		MAP.put(548, false);
		MAP.put(562, false);
		MAP.put(576, false);
		MAP.put(583, false);
		MAP.put(590, false);
		MAP.put(593, false);
		MAP.put(609, false);
		MAP.put(616, false);
		MAP.put(624, false);
		MAP.put(627, false);
		MAP.put(64, true);
		MAP.put(65536, true);
		MAP.put(67108864, true);
		MAP.put(695, false);
		MAP.put(701, false);
		MAP.put(704, false);
		MAP.put(745, false);
		MAP.put(753, false);
		MAP.put(760, false);
		MAP.put(768, false);
		MAP.put(781, false);
		MAP.put(782, false);
		MAP.put(798, false);
		MAP.put(799, false);
		MAP.put(8, true);
		MAP.put(800, false);
		MAP.put(804, false);
		MAP.put(8192, true);
		MAP.put(831, false);
		MAP.put(8388608, true);
		MAP.put(845, false);
		MAP.put(852, false);
		MAP.put(859, false);
		MAP.put(864, false);
		MAP.put(866, false);
		MAP.put(889, false);
		MAP.put(897, false);
		MAP.put(902, false);
		MAP.put(932, false);
		MAP.put(939, false);
		MAP.put(950, false);
		MAP.put(96, false);
		MAP.put(962, false);
		MAP.put(973, false);
		MAP.put(994, false);
	}

	@Test
	void isPowerOfTwo()
	{
		String message;
		for (Map.Entry<Integer, Boolean> entry : MAP.entrySet())
		{
			int n = entry.getKey();
			boolean expected = entry.getValue();
			boolean actual = PowerOfTwo.isPowerOfTwo(n);

			message = "Test failed on case: " + n
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}
}