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

package challenge.leetcode.medium.earliestFinishTimeForLandAndWaterRidesII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * @author Administrator
 * @Created 06:05 Wed 03 June 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3635. Earliest Finish Time for Land and Water Rides II")
class EarliestFinishTimeForLandAndWaterRidesIITest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[]{2,8},new int[]{4,1},new int[]{6},new int[]{3}),9);
		MAP.put(new Input(new int[]{5},new int[]{3},new int[]{1},new int[]{10}),14);
		MAP.put(new Input(new int[]{742, 115, 893},new int[]{45, 912, 334},new int[]{221, 650},new int[]{104, 789}),787);
		MAP.put(new Input(new int[]{44, 581, 239, 901, 12},new int[]{673, 11, 485, 290, 888},new int[]{333, 712, 198, 555, 802, 64},new int[]{414, 999, 53, 276, 618, 381}),592);
		MAP.put(new Input(new int[]{102, 845, 367, 592, 718, 256, 934, 481},new int[]{215, 678, 142, 895, 331, 564, 789, 412},new int[]{523, 187, 956, 341, 629, 874, 112, 498},new int[]{836, 275, 614, 983, 159, 442, 761, 328}),592);
		MAP.put(new Input(new int[]{312, 789, 45, 621, 934, 178, 543, 890, 267, 714, 88, 432, 976, 351, 689},new int[]{845, 123, 678, 234, 901, 567, 345, 789, 112, 654, 876, 432, 219, 598, 765},new int[]{943, 215, 768, 134, 856, 427, 691, 358, 912, 574, 289, 831},new int[]{176, 892, 435, 718, 259, 941, 634, 185, 752, 396, 824, 517}),564);
		MAP.put(new Input(new int[]{642, 819, 153, 397, 724, 981, 246, 508, 137, 865, 412, 693, 275, 954, 318, 579, 192, 836, 471, 755},new int[]{328, 715, 942, 186, 539, 274, 851, 493, 617, 158, 926, 384, 749, 215, 863, 507, 391, 648, 172, 935},new int[]{827, 354, 691, 148, 973, 526, 285, 719, 462, 938, 175, 843, 596, 231, 764, 419, 892, 657, 314, 985},new int[]{451, 896, 237, 782, 164, 928, 573, 349, 815, 296, 754, 183, 647, 912, 368, 859, 521, 279, 736, 495}),928);
	}

	@Test
	@Timeout(3)
	void earliestFinishTime()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int[] landStartTime = entry.getKey().landStartTime();
			final int[] landDuration = entry.getKey().landDuration();
			final int[] waterStartTime = entry.getKey().waterStartTime();
			final int[] waterDuration = entry.getKey().waterDuration();
			final int expected = entry.getValue();
			final int actual = EarliestFinishTimeForLandAndWaterRidesII.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);

			String message = String.format("Test failed for case:"
					+ "%n%10s "
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s "
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Land Start Time", Arrays.toString(landStartTime),
				"Land Duration", Arrays.toString(landDuration),
				"Water Start Time", Arrays.toString(waterStartTime),
				"Water Duration", Arrays.toString(waterDuration),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration)
{

}