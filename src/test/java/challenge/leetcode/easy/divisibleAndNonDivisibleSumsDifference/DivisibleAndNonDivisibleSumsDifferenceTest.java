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
package challenge.leetcode.easy.divisibleAndNonDivisibleSumsDifference;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 22/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Difficulty
 * @Tags
 * @link
 * @Description
 **/
@DisplayName("2894. Divisible And Non-divisible Sums Difference")
class DivisibleAndNonDivisibleSumsDifferenceTest
{

	private static final Map<Pair<Integer, Integer>, Integer> MAP = new HashMap<>();

	static
	{
		// Map = Pair (left: n, right: m) : result

		MAP.put(Pair.of(10, 3), 19);
		MAP.put(Pair.of(5, 6), 15);
		MAP.put(Pair.of(5, 1), -15);

		MAP.put(Pair.of(43, 1), -946);
		MAP.put(Pair.of(61, 65), 1891);
		MAP.put(Pair.of(60, 23), 1692);
		MAP.put(Pair.of(57, 58), 1653);
		MAP.put(Pair.of(64, 66), 2080);
		MAP.put(Pair.of(62, 70), 1953);
		MAP.put(Pair.of(25, 42), 325);
		MAP.put(Pair.of(56, 76), 1596);
		MAP.put(Pair.of(78, 43), 2995);
		MAP.put(Pair.of(75, 83), 2850);
		MAP.put(Pair.of(89, 84), 3837);
		MAP.put(Pair.of(9, 61), 45);
		MAP.put(Pair.of(66, 87), 2211);
		MAP.put(Pair.of(36, 81), 666);
		MAP.put(Pair.of(94, 71), 4323);
		MAP.put(Pair.of(24, 72), 300);
		MAP.put(Pair.of(73, 33), 2503);
		MAP.put(Pair.of(91, 67), 4052);
		MAP.put(Pair.of(18, 56), 171);
		MAP.put(Pair.of(47, 60), 1128);
		MAP.put(Pair.of(1, 31), 1);
		MAP.put(Pair.of(42, 5), 543);
		MAP.put(Pair.of(31, 16), 464);
		MAP.put(Pair.of(36, 41), 666);
		MAP.put(Pair.of(81, 48), 3225);
		MAP.put(Pair.of(75, 80), 2850);
		MAP.put(Pair.of(49, 1), -1225);
		MAP.put(Pair.of(4, 57), 10);
		MAP.put(Pair.of(46, 90), 1081);
		MAP.put(Pair.of(33, 87), 561);
		MAP.put(Pair.of(78, 1), -3081);
		MAP.put(Pair.of(89, 15), 3555);
		MAP.put(Pair.of(25, 54), 325);
		MAP.put(Pair.of(91, 44), 3922);
		MAP.put(Pair.of(37, 76), 703);
		MAP.put(Pair.of(57, 39), 1575);
		MAP.put(Pair.of(38, 80), 741);
		MAP.put(Pair.of(62, 58), 1837);
		MAP.put(Pair.of(21, 21), 189);
		MAP.put(Pair.of(10, 97), 55);
		MAP.put(Pair.of(91, 31), 4000);
		MAP.put(Pair.of(10, 95), 55);
		MAP.put(Pair.of(31, 96), 496);
		MAP.put(Pair.of(62, 68), 1953);
		MAP.put(Pair.of(7, 61), 28);
		MAP.put(Pair.of(62, 95), 1953);
		MAP.put(Pair.of(68, 76), 2346);
		MAP.put(Pair.of(45, 27), 981);
		MAP.put(Pair.of(19, 66), 190);
		MAP.put(Pair.of(36, 30), 606);
		MAP.put(Pair.of(75, 65), 2720);
		MAP.put(Pair.of(65, 57), 2031);
		MAP.put(Pair.of(97, 76), 4601);
		MAP.put(Pair.of(33, 19), 523);
		MAP.put(Pair.of(45, 66), 1035);
		MAP.put(Pair.of(99, 4), 2550);
		MAP.put(Pair.of(38, 56), 741);
		MAP.put(Pair.of(82, 55), 3293);
		MAP.put(Pair.of(54, 30), 1425);
		MAP.put(Pair.of(14, 68), 105);
		MAP.put(Pair.of(12, 32), 78);
		MAP.put(Pair.of(62, 28), 1785);
		MAP.put(Pair.of(80, 73), 3094);
		MAP.put(Pair.of(14, 51), 105);
		MAP.put(Pair.of(61, 7), 1387);
		MAP.put(Pair.of(72, 62), 2504);
		MAP.put(Pair.of(36, 56), 666);
		MAP.put(Pair.of(3, 75), 6);
		MAP.put(Pair.of(8, 97), 36);
		MAP.put(Pair.of(83, 61), 3364);
		MAP.put(Pair.of(91, 2), 46);
		MAP.put(Pair.of(2, 89), 3);
		MAP.put(Pair.of(58, 94), 1711);
		MAP.put(Pair.of(18, 68), 171);
		MAP.put(Pair.of(11, 27), 66);
		MAP.put(Pair.of(48, 42), 1092);
		MAP.put(Pair.of(77, 55), 2893);
		MAP.put(Pair.of(31, 51), 496);
		MAP.put(Pair.of(77, 65), 2873);
		MAP.put(Pair.of(9, 63), 45);
		MAP.put(Pair.of(3, 40), 6);
		MAP.put(Pair.of(16, 48), 136);
		MAP.put(Pair.of(92, 38), 4050);
		MAP.put(Pair.of(56, 97), 1596);
		MAP.put(Pair.of(13, 16), 91);
		MAP.put(Pair.of(46, 10), 881);
		MAP.put(Pair.of(82, 52), 3299);
		MAP.put(Pair.of(18, 51), 171);
		MAP.put(Pair.of(1, 92), 1);
		MAP.put(Pair.of(30, 80), 465);
		MAP.put(Pair.of(97, 75), 4603);
		MAP.put(Pair.of(33, 51), 561);
		MAP.put(Pair.of(29, 100), 435);
		MAP.put(Pair.of(67, 62), 2154);
		MAP.put(Pair.of(98, 6), 3219);
		MAP.put(Pair.of(13, 50), 91);
		MAP.put(Pair.of(52, 82), 1378);
		MAP.put(Pair.of(5, 92), 15);
		MAP.put(Pair.of(37, 50), 703);
		MAP.put(Pair.of(23, 3), 108);

		MAP.put(Pair.of(804, 266), 320418);
		MAP.put(Pair.of(361, 274), 64793);
		MAP.put(Pair.of(611, 546), 185874);
		MAP.put(Pair.of(917, 976), 420903);
		MAP.put(Pair.of(627, 361), 196156);
		MAP.put(Pair.of(544, 562), 148240);
		MAP.put(Pair.of(821, 716), 335999);
		MAP.put(Pair.of(177, 316), 15753);
		MAP.put(Pair.of(858, 495), 367521);
		MAP.put(Pair.of(331, 643), 54946);
		MAP.put(Pair.of(876, 970), 384126);
		MAP.put(Pair.of(152, 862), 11628);
		MAP.put(Pair.of(877, 555), 383893);
		MAP.put(Pair.of(262, 613), 34453);
		MAP.put(Pair.of(25, 120), 325);
		MAP.put(Pair.of(864, 206), 369560);
		MAP.put(Pair.of(594, 470), 175775);
		MAP.put(Pair.of(873, 676), 380149);
		MAP.put(Pair.of(15, 828), 120);
		MAP.put(Pair.of(376, 387), 70876);
		MAP.put(Pair.of(517, 441), 133021);
		MAP.put(Pair.of(525, 56), 133035);
		MAP.put(Pair.of(531, 578), 141246);
		MAP.put(Pair.of(713, 361), 253819);
		MAP.put(Pair.of(715, 950), 255970);
		MAP.put(Pair.of(509, 842), 129795);
		MAP.put(Pair.of(363, 468), 66066);
		MAP.put(Pair.of(248, 583), 30876);
		MAP.put(Pair.of(940, 361), 440104);
		MAP.put(Pair.of(383, 292), 72952);
		MAP.put(Pair.of(976, 495), 475786);
		MAP.put(Pair.of(60, 818), 1830);
		MAP.put(Pair.of(121, 156), 7381);
		MAP.put(Pair.of(190, 521), 18145);
		MAP.put(Pair.of(668, 764), 223446);
		MAP.put(Pair.of(383, 798), 73536);
		MAP.put(Pair.of(260, 411), 33930);
		MAP.put(Pair.of(785, 22), 280785);
		MAP.put(Pair.of(11, 771), 66);
		MAP.put(Pair.of(182, 902), 16653);
		MAP.put(Pair.of(153, 945), 11781);
		MAP.put(Pair.of(846, 129), 352863);
		MAP.put(Pair.of(887, 45), 376728);
		MAP.put(Pair.of(839, 765), 350850);
		MAP.put(Pair.of(133, 778), 8911);
		MAP.put(Pair.of(622, 649), 193753);
		MAP.put(Pair.of(268, 157), 35732);
		MAP.put(Pair.of(241, 999), 29161);
		MAP.put(Pair.of(987, 61), 470986);
		MAP.put(Pair.of(365, 307), 66181);
		MAP.put(Pair.of(322, 740), 52003);
		MAP.put(Pair.of(306, 195), 46581);
		MAP.put(Pair.of(311, 222), 48072);
		MAP.put(Pair.of(804, 542), 322526);
		MAP.put(Pair.of(916, 880), 418226);
		MAP.put(Pair.of(284, 904), 40470);
		MAP.put(Pair.of(969, 375), 467715);
		MAP.put(Pair.of(13, 72), 91);
		MAP.put(Pair.of(665, 844), 221445);
		MAP.put(Pair.of(629, 341), 197453);
		MAP.put(Pair.of(408, 756), 83436);
		MAP.put(Pair.of(443, 9), 76296);
		MAP.put(Pair.of(603, 967), 182106);
		MAP.put(Pair.of(573, 343), 163765);
		MAP.put(Pair.of(286, 543), 41041);
		MAP.put(Pair.of(748, 982), 280126);
		MAP.put(Pair.of(6, 343), 21);
		MAP.put(Pair.of(876, 383), 381828);
		MAP.put(Pair.of(477, 659), 114003);
		MAP.put(Pair.of(426, 753), 90951);
		MAP.put(Pair.of(974, 564), 473697);
		MAP.put(Pair.of(265, 381), 35245);
		MAP.put(Pair.of(532, 758), 141778);
		MAP.put(Pair.of(662, 580), 218293);
		MAP.put(Pair.of(800, 781), 318838);
		MAP.put(Pair.of(594, 653), 176715);
		MAP.put(Pair.of(413, 687), 85491);
		MAP.put(Pair.of(102, 415), 5253);
		MAP.put(Pair.of(694, 8), 181309);
		MAP.put(Pair.of(599, 728), 179700);
		MAP.put(Pair.of(17, 24), 153);
		MAP.put(Pair.of(94, 410), 4465);
		MAP.put(Pair.of(188, 774), 17766);
		MAP.put(Pair.of(441, 841), 97461);
		MAP.put(Pair.of(919, 441), 420094);
		MAP.put(Pair.of(556, 882), 154846);
		MAP.put(Pair.of(187, 366), 17578);
		MAP.put(Pair.of(521, 716), 135981);
		MAP.put(Pair.of(542, 998), 147153);
		MAP.put(Pair.of(416, 364), 86008);
		MAP.put(Pair.of(379, 779), 72010);
		MAP.put(Pair.of(854, 459), 364167);
		MAP.put(Pair.of(54, 543), 1485);
		MAP.put(Pair.of(344, 300), 58740);
		MAP.put(Pair.of(29, 520), 435);
		MAP.put(Pair.of(396, 878), 78606);
		MAP.put(Pair.of(915, 598), 417874);
		MAP.put(Pair.of(119, 231), 7140);
		MAP.put(Pair.of(938, 550), 439291);
		MAP.put(Pair.of(387, 870), 75078);
	}

	@Test
	void testDifferenceOfSums()
	{
		for (Map.Entry<Pair<Integer, Integer>, Integer> entry : MAP.entrySet())
		{
			final int n = entry.getKey().getLeft();
			final int m = entry.getKey().getRight();
			final int expected = entry.getValue();
			final int actual = DivisibleAndNonDivisibleSumsDifference.differenceOfSums(n, m);

			final String message = "Test failed on case: n=" + n + ", m=" + m
				+ ".\nExpected : " + expected
				+ "\nActual   : " + actual;

			assertEquals(expected, actual, message);
		}
	}
}