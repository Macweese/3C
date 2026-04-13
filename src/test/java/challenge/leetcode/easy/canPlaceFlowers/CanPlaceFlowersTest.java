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

package challenge.leetcode.easy.canPlaceFlowers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 18:35 Mon 13 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("605. Can Place Flowers")
class CanPlaceFlowersTest
{
	private static final Map<Input, Boolean> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[]{0},1),true);
		MAP.put(new Input(new int[]{0,0},1),true);
		MAP.put(new Input(new int[]{0,0},2),false);
		MAP.put(new Input(new int[]{0,1},1),false);
		MAP.put(new Input(new int[]{0,0,1},1),true);
		MAP.put(new Input(new int[]{1,0,0},1),true);
		MAP.put(new Input(new int[]{1,0,0,0,1},1),true);
		MAP.put(new Input(new int[]{0,1,0,0,0},1),true);
		MAP.put(new Input(new int[]{0,0,1,0,0},2),true);
		MAP.put(new Input(new int[]{1,0,0,0,1},2),false);
		MAP.put(new Input(new int[]{1,0,0,0,1},2),false);
		MAP.put(new Input(new int[]{0,1,0,0,0},2),false);
		MAP.put(new Input(new int[]{0,1,0,0,0},3),false);
		MAP.put(new Input(new int[]{0,0,1,0,0,0,0,0,1,0,0},4),true);
	}

	@Test
	void canPlaceFlowers()
	{
		for (Map.Entry<Input, Boolean> entry : MAP.entrySet())
		{
			final int[] flowerbed = entry.getKey().flowerbed();
			final int n = entry.getKey().n();
			final boolean expected = entry.getValue();
			final boolean actual = CanPlaceFlowers.canPlaceFlowers(flowerbed.clone(), n);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Flowerbed", Arrays.toString(flowerbed),
				"N", n,
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(int[] flowerbed, int n)
{

}