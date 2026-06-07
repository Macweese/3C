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

package challenge.leetcode.hard.blockPlacementQueries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * @author Administrator
 * @Created 07:54 Sat 30 May 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3161. Block Placement Queries")
class BlockPlacementQueriesTest
{
	private static final Map<int[][], List<Boolean>> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{2,1,2}},List.of(false));
		MAP.put(new int[][]{{1,1},{1,11},{1,4},{1,8},{2,13,7}},List.of(false));
		MAP.put(new int[][]{{1,2},{2,3,3},{2,3,1},{2,2,2}},List.of(false,true,true));
		MAP.put(new int[][]{{1,7},{2,7,6},{1,2},{2,7,5},{2,7,6}},List.of(true,true,false));
	}

	@Test
	@Timeout(3)
	void getResults()
	{
		for (Map.Entry<int[][], List<Boolean>> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final List<Boolean> expected = entry.getValue();
			final List<Boolean> actual = BlockPlacementQueries.getResults(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.deepToString(input),
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}