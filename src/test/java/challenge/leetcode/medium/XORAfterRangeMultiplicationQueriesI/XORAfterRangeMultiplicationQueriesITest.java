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

package challenge.leetcode.medium.XORAfterRangeMultiplicationQueriesI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 07:02 Wed 08 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3653. XOR After Range Multiplication Queries I")
class XORAfterRangeMultiplicationQueriesITest
{
	private static final Map<Input, Integer> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[]{1,1,1},new int[][]{{0,2,1,4}}),4);
		MAP.put(new Input(new int[]{2,3,1,5,4},new int[][]{{1,4,2,3},{0,2,1,2}}),31);
		MAP.put(new Input(new int[]{780},new int[][]{{0,0,1,13},{0,0,1,17},{0,0,1,9},{0,0,1,18},{0,0,1,16},{0,0,1,6},{0,0,1,4},{0,0,1,11},{0,0,1,7},{0,0,1,18},{0,0,1,8},{0,0,1,15},{0,0,1,12}}),523618060);
//		MAP.put(new Input(new int[],new int[][]),);
	}

	@Test
	void xorAfterQueries()
	{
		for (Map.Entry<Input, Integer> entry : MAP.entrySet())
		{
			final int[] ints = entry.getKey().ints();
			final int[][] queries = entry.getKey().queries();
			final int expected = entry.getValue();
			final int actual = XORAfterRangeMultiplicationQueriesI.xorAfterQueries(ints, queries);

			String message = String.format("Test failed for case:"
					+ "%n%10s :"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s :"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Ints", Arrays.toString(ints),
				"Queries", Arrays.deepToString(queries),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(expected, actual, message);
		}
	}
}
record Input(int[] ints, int[][] queries)
{

}