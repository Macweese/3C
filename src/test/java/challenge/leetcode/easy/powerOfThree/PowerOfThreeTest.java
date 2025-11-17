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
package challenge.leetcode.easy.powerOfThree;

import challenge.leetcode.easy.powerOfThree.PowerOfThree;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("326. Power of Three")
class PowerOfThreeTest
{
	private static final Map<Integer, Boolean> MAP = new HashMap<>();

	static
	{
		MAP.put(1, true);
		MAP.put(3, true);
		MAP.put(9, true);
		MAP.put(27, true);
		MAP.put(81, true);
		MAP.put(243, true);
		MAP.put(729, true);
		MAP.put(66, false);
		MAP.put(60, false);
		MAP.put(30, false);
		MAP.put(36, false);
		MAP.put(93, false);
		MAP.put(91, false);
		MAP.put(50, false);
		MAP.put(87, false);
		MAP.put(61, false);
		MAP.put(21, false);
		MAP.put(85, false);
		MAP.put(2187, true);
		MAP.put(6561, true);
		MAP.put(193, false);
		MAP.put(697, false);
		MAP.put(902, false);
		MAP.put(613, false);
		MAP.put(778, false);
		MAP.put(866, false);
		MAP.put(984, false);
		MAP.put(254, false);
		MAP.put(381, false);
		MAP.put(993, false);
		MAP.put(237, false);
		MAP.put(990, false);
		MAP.put(781, false);
		MAP.put(283, false);
		MAP.put(590, false);
		MAP.put(319, false);
		MAP.put(444, false);
		MAP.put(808, false);
		MAP.put(845, false);
		MAP.put(453, false);
		MAP.put(859, false);
		MAP.put(322, false);
		MAP.put(357, false);
		MAP.put(437, false);
		MAP.put(347, false);
		MAP.put(409, false);
		MAP.put(124, false);
		MAP.put(681, false);
		MAP.put(138, false);
		MAP.put(456, false);
		MAP.put(432, false);
		MAP.put(986, false);
		MAP.put(832, false);
		MAP.put(494, false);
		MAP.put(958, false);
		MAP.put(596, false);
		MAP.put(496, false);
		MAP.put(863, false);
		MAP.put(526, false);
		MAP.put(542, false);
		MAP.put(328, false);
		MAP.put(451, false);
		MAP.put(511, false);
		MAP.put(212, false);
		MAP.put(251, false);
		MAP.put(720, false);
		MAP.put(872, false);
		MAP.put(289, false);
		MAP.put(723, false);
		MAP.put(250, false);
		MAP.put(547, false);
		MAP.put(291, false);
		MAP.put(232, false);
		MAP.put(949, false);
		MAP.put(513, false);
		MAP.put(739, false);
		MAP.put(311, false);
		MAP.put(946, false);
		MAP.put(439, false);
		MAP.put(602, false);
		MAP.put(372, false);
		MAP.put(512, false);
		MAP.put(661, false);
		MAP.put(611, false);
		MAP.put(694, false);
		MAP.put(607, false);
		MAP.put(957, false);
		MAP.put(813, false);
		MAP.put(889, false);
		MAP.put(835, false);
		MAP.put(764, false);
		MAP.put(757, false);
		MAP.put(727, false);
		MAP.put(604, false);
		MAP.put(890, false);
		MAP.put(565, false);
		MAP.put(912, false);
		MAP.put(184, false);
		MAP.put(751, false);
		MAP.put(932, false);
		MAP.put(682, false);
		MAP.put(766, false);
		MAP.put(615, false);
		MAP.put(717, false);
		MAP.put(543, false);
		MAP.put(732, false);
		MAP.put(743, false);
		MAP.put(19683, true);
		MAP.put(59049, true);
		MAP.put(2169, false);
		MAP.put(2030, false);
		MAP.put(2503, false);
		MAP.put(2282, false);
		MAP.put(1457, false);
		MAP.put(2669, false);
		MAP.put(2984, false);
		MAP.put(1629, false);
		MAP.put(1912, false);
		MAP.put(1946, false);
		MAP.put(1009, false);
		MAP.put(2856, false);
		MAP.put(2138, false);
		MAP.put(1790, false);
		MAP.put(2205, false);
		MAP.put(2086, false);
		MAP.put(2829, false);
		MAP.put(1266, false);
		MAP.put(1015, false);
		MAP.put(2665, false);
		MAP.put(2181, false);
		MAP.put(2359, false);
		MAP.put(1928, false);
		MAP.put(1201, false);
		MAP.put(1393, false);
		MAP.put(2945, false);
		MAP.put(1715, false);
		MAP.put(2632, false);
		MAP.put(2369, false);
		MAP.put(1229, false);
		MAP.put(1449, false);
		MAP.put(2399, false);
		MAP.put(2899, false);
		MAP.put(1267, false);
		MAP.put(1612, false);
		MAP.put(1035, false);
		MAP.put(2450, false);
		MAP.put(1404, false);
		MAP.put(1597, false);
		MAP.put(2987, false);
		MAP.put(1297, false);
		MAP.put(2907, false);
		MAP.put(1547, false);
		MAP.put(2072, false);
		MAP.put(1114, false);
		MAP.put(2977, false);
		MAP.put(1748, false);
		MAP.put(2335, false);
		MAP.put(2911, false);
		MAP.put(1767, false);
		MAP.put(2644, false);
		MAP.put(2350, false);
		MAP.put(1609, false);
		MAP.put(1844, false);
		MAP.put(1539, false);
		MAP.put(2375, false);
		MAP.put(1961, false);
		MAP.put(1089, false);
		MAP.put(1295, false);
		MAP.put(1027, false);
		MAP.put(1239, false);
		MAP.put(2446, false);
		MAP.put(2739, false);
		MAP.put(2834, false);
		MAP.put(2267, false);
		MAP.put(1388, false);
		MAP.put(1939, false);
		MAP.put(1336, false);
		MAP.put(2622, false);
		MAP.put(2477, false);
		MAP.put(1415, false);
		MAP.put(2313, false);
		MAP.put(1060, false);
		MAP.put(2831, false);
		MAP.put(1679, false);
		MAP.put(1680, false);
		MAP.put(1325, false);
		MAP.put(1225, false);
		MAP.put(1942, false);
		MAP.put(1159, false);
		MAP.put(2791, false);
		MAP.put(2568, false);
		MAP.put(2172, false);
		MAP.put(1703, false);
		MAP.put(2704, false);
		MAP.put(2317, false);
		MAP.put(1577, false);
		MAP.put(1653, false);
		MAP.put(2408, false);
		MAP.put(1792, false);
		MAP.put(2348, false);
		MAP.put(1903, false);
		MAP.put(2442, false);
		MAP.put(1381, false);
		MAP.put(1053, false);
		MAP.put(2960, false);
		MAP.put(2202, false);
		MAP.put(1261, false);
		MAP.put(1483, false);
		MAP.put(1757, false);
		MAP.put(1917, false);
		MAP.put(1657, false);
		MAP.put(2063, false);
		MAP.put(1896, false);
		MAP.put(1080, false);
		MAP.put(2979, false);
		MAP.put(2518, false);
		MAP.put(1900, false);
		MAP.put(1880, false);
		MAP.put(2954, false);
		MAP.put(1567, false);
		MAP.put(2537, false);
		MAP.put(2142, false);
		MAP.put(1528, false);
		MAP.put(1213, false);
		MAP.put(1886, false);
		MAP.put(1000, false);
		MAP.put(1862, false);
		MAP.put(2223, false);
		MAP.put(1376, false);
		MAP.put(2054, false);
		MAP.put(2428, false);
		MAP.put(1901, false);
		MAP.put(2578, false);
		MAP.put(2460, false);
		MAP.put(1113, false);
		MAP.put(1772, false);
		MAP.put(2953, false);
		MAP.put(2061, false);
		MAP.put(1994, false);
		MAP.put(2603, false);
		MAP.put(1116, false);
		MAP.put(2173, false);
		MAP.put(2373, false);
		MAP.put(2075, false);
		MAP.put(2811, false);
		MAP.put(2737, false);
		MAP.put(2260, false);
		MAP.put(2199, false);
		MAP.put(1621, false);
		MAP.put(2417, false);
		MAP.put(1339, false);
		MAP.put(1034, false);
		MAP.put(2522, false);
		MAP.put(2068, false);
		MAP.put(2288, false);
		MAP.put(1337, false);
		MAP.put(2106, false);
		MAP.put(2017, false);
		MAP.put(1121, false);
		MAP.put(1018, false);
		MAP.put(1966, false);
		MAP.put(1631, false);
		MAP.put(1977, false);
		MAP.put(2948, false);
		MAP.put(2311, false);
		MAP.put(2633, false);
		MAP.put(2299, false);
		MAP.put(1494, false);
		MAP.put(1379, false);
		MAP.put(1801, false);
		MAP.put(2019, false);
		MAP.put(2793, false);
		MAP.put(1572, false);
		MAP.put(1673, false);
		MAP.put(1824, false);
		MAP.put(1756, false);
		MAP.put(1368, false);
		MAP.put(1487, false);
		MAP.put(2478, false);
		MAP.put(1656, false);
		MAP.put(177147, true);
		MAP.put(531441, true);
		MAP.put(1594323, true);
		MAP.put(4782969, true);
		MAP.put(14348907, true);
		MAP.put(43046721, true);
		MAP.put(129140163, true);
		MAP.put(387420489, true);
		MAP.put(1162261467, true);
		MAP.put(2147483647, false);
	}

	@Test
	void powerOfThree()
	{
		String message;

		for (Map.Entry<Integer, Boolean> entry : MAP.entrySet())
		{
			int n = entry.getKey();
			boolean expected = entry.getValue();
			boolean actual = PowerOfThree.powerOfThree(n);

			message = "Test failed on case: " + n
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}

	}
}