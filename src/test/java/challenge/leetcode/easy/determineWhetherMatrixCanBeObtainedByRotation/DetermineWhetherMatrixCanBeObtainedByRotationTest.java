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

package challenge.leetcode.easy.determineWhetherMatrixCanBeObtainedByRotation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 07:00 Sun 22 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1886. Determine Whether Matrix Can Be Obtained By Rotation")
class DetermineWhetherMatrixCanBeObtainedByRotationTest
{
	private static final Map<Input, Boolean> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[][]{{0,1},{1,0}},new int[][]{{1,0},{0,1}}),true);
		MAP.put(new Input(new int[][]{{0,1},{1,1}},new int[][]{{1,0},{0,1}}),false);
		MAP.put(new Input(new int[][]{{1,0},{0,0}},new int[][]{{1,0},{0,0}}),true);
		MAP.put(new Input(new int[][]{{1,0},{0,0}},new int[][]{{0,1},{0,0}}),true);
		MAP.put(new Input(new int[][]{{1,0},{0,0}},new int[][]{{0,0},{1,0}}),true);
		MAP.put(new Input(new int[][]{{1,0},{0,0}},new int[][]{{0,0},{0,1}}),true);
		MAP.put(new Input(new int[][]{{0,0,0},{0,0,1},{0,0,1}},new int[][]{{0,0,0},{0,0,1},{0,0,1}}),true);
		MAP.put(new Input(new int[][]{{0,0,0},{0,1,0},{1,1,1}},new int[][]{{1,1,1},{0,1,0},{0,0,0}}),true);
	}

	@Test
	@DisplayName("Find Rotation")
	void findRotation()
	{
		for (Map.Entry<Input, Boolean> entry : MAP.entrySet())
		{
			final int[][] matrix = entry.getKey().mat();
			final int[][] target = entry.getKey().target();
			final boolean expected = entry.getValue();
			final boolean actual = DetermineWhetherMatrixCanBeObtainedByRotation.findRotation(matrix, target);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Matrix", Arrays.deepToString(matrix),
				"Target", Arrays.deepToString(target),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}

	@Test
	@DisplayName("Find Rotation Branchless")
	void findRotationBranchless()
	{
		for (Map.Entry<Input, Boolean> entry : MAP.entrySet())
		{
			final int[][] matrix = entry.getKey().mat();
			final int[][] target = entry.getKey().target();
			final boolean expected = entry.getValue();
			final boolean actual = DetermineWhetherMatrixCanBeObtainedByRotation.findBranchless(matrix, target);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Matrix", Arrays.deepToString(matrix),
				"Target", Arrays.deepToString(target),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}

	@Test
	@DisplayName("Find Rotation Fast")
	void findRotationFast()
	{
		for (Map.Entry<Input, Boolean> entry : MAP.entrySet())
		{
			final int[][] matrix = entry.getKey().mat();
			final int[][] target = entry.getKey().target();
			final boolean expected = entry.getValue();
			final boolean actual = DetermineWhetherMatrixCanBeObtainedByRotation.findFast(matrix, target);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Matrix", Arrays.deepToString(matrix),
				"Target", Arrays.deepToString(target),
				"Output",
				"Expected", expected,
				"Actual", actual,
				""
			);

			assertEquals(actual, expected, message);
		}
	}
}
record Input(int[][] mat, int[][] target)
{

}