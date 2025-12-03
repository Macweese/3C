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

package challenge.leetcode.hard.countNumberOfTrapezoidsII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:34 Wed 03 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3625. Count Number of Trapezoids II")
class CountNumberOfTrapezoidsIITest
{
	private static final Map<int[][], Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{0,0},{1,0},{0,1},{2,1}},1);
		MAP.put(new int[][]{{-3,2},{3,0},{2,3},{3,2},{2,-3}},2);
		MAP.put(new int[][]{{71,-89},{-75,-89},{-9,11},{-24,-89},{-51,-89},{-77,-89},{42,11}},10);
		MAP.put(new int[][]{{83,-25},{74,11},{-65,-25},{33,-25},{17,-25},{1,30},{-84,-25},{1,-25},{1,-92},{-87,13}},0);
		MAP.put(new int[][]{{92,100},{-4,55},{92,-87},{92,-91},{92,-30},{27,45},{66,82},{92,79},{92,-89},{-4,95},{92,-70},{-10,-18}},21);
		MAP.put(new int[][]{{67,14},{45,-86},{-98,14},{73,-86},{22,47},{73,71},{-32,14},{-42,-16},{33,-69},{-42,47},{73,92},{58,-56},{-32,-20},{-42,8},{71,-86}},30);
		MAP.put(new int[][]{{-80,-47},{-37,52},{-23,75},{-44,-66},{-33,-61},{-80,94},{-38,3},{16,-43},{-38,2},{2,99},{-65,-20},{37,15},{45,2},{21,66},{76,-20},{-84,-43},{-80,-66},{-96,2}},26);
		MAP.put(new int[][]{{209,-385},{-35,319},{379,-93},{452,10},{179,163},{-118,196},{430,-365},{179,-365},{-299,465},{209,-410},{-375,-403},{-163,-227},{77,-365},{268,441},{460,465},{-163,465},{-412,-267},{-412,53},{-46,-280},{61,-209},{-234,32},{-35,296},{-276,-93},{-412,-475},{-470,-181},{-412,-283},{367,175},{-371,218},{209,-79},{-226,-74},{-435,-410},{-80,10},{-433,-365},{-35,-93},{-470,-67},{-378,0},{-82,-331},{144,268},{449,-106},{-470,-28},{452,-370},{449,-204},{-96,-245},{195,465},{-353,422},{-265,-2},{-178,219},{-35,222},{-375,-411},{-118,-93},{-199,71},{49,-209},{-301,-276},{79,219},{-46,32},{-35,181},{435,402},{449,465},{321,-209},{-412,148},{187,465},{367,496},{16,101},{179,244},{-346,151},{-353,319},{-251,-106},{-35,119},{-118,-370},{-102,465},{-35,311},{452,-62},{-118,441},{-412,-259},{375,441},{483,-182},{-35,-471},{462,289},{179,465},{-412,344},{206,302},{449,417},{-25,500},{-118,43},{372,-93},{180,167},{-118,473},{106,144},{151,-370},{-375,-245},{77,-399},{-478,465},{-405,-478},{-25,-291},{359,-347},{-371,-410},{179,250},{-353,206},{414,-494},{-118,-245},{-199,465},{28,-127},{435,175},{187,-436},{209,-250},{-35,-28},{-35,219},{-257,-93},{-25,-24},{-35,-236}},11025);
	}

	@Test
	void countTrapezoids()
	{
		for (Map.Entry<int[][], Integer> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = CountNumberOfTrapezoidsII.countTrapezoids(input);

			String message = String.format("Test failed for case:"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s",
				"Input", Arrays.deepToString(input),
				"Expected", expected,
				"Actual", actual
			);

			assertEquals(expected, actual, message);
		}
	}
}