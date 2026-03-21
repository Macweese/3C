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

package challenge.leetcode.easy.flipSquareSubmatrixVertically;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.DataUtils;
import utils.IntArraySpec;

/**
 * @author Administrator
 * @Created 01:07 Sat 21 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3643. Flip Square Submatrix Vertically")
class FlipSquareSubmatrixVerticallyTest
{
	private static final Map<Input, int[][]> MAP = new HashMap<>();

	static
	{
		MAP.put(new Input(new int[][]{{3,87}},0,1,1),new int[][]{{3,87}});
		MAP.put(new Input(new int[][]{{81,52,71,97,63}},0,4,1),new int[][]{{81,52,71,97,63}});
		MAP.put(new Input(new int[][]{{3,4,2,3},{2,3,4,2}},0,2,2),new int[][]{{3,4,4,2},{2,3,2,3}});
		MAP.put(new Input(new int[][]{{100,60,9,24,9,66,80}},0,5,1),new int[][]{{100,60,9,24,9,66,80}});
		MAP.put(new Input(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}},1,0,3),new int[][]{{1,2,3,4},{13,14,15,8},{9,10,11,12},{5,6,7,16}});
		MAP.put(new Input(new int[][]{{61,72,75},{53,50,50},{30,59,43},{88,36,7},{18,54,22},{24,38,8}},5,1,1),new int[][]{{61,72,75},{53,50,50},{30,59,43},{88,36,7},{18,54,22},{24,38,8}});
		MAP.put(new Input(new int[][]{{63,25,36,4,27,46,53,3},{9,95,28,32,1,41,82,88},{82,21,46,59,85,98,84,37}},2,0,1),new int[][]{{63,25,36,4,27,46,53,3},{9,95,28,32,1,41,82,88},{82,21,46,59,85,98,84,37}});
		MAP.put(new Input(new int[][]{{79,2,99},{84,28,83},{36,34,60},{56,97,32},{72,91,97},{6,44,88},{71,42,91}},4,0,2),new int[][]{{79,2,99},{84,28,83},{36,34,60},{56,97,32},{6,44,97},{72,91,88},{71,42,91}});
		MAP.put(new Input(new int[][]{{35,96,55,94},{15,11,22,78},{20,10,98,28},{71,30,35,98},{28,64,24,31},{36,49,40,57}},4,0,1),new int[][]{{35,96,55,94},{15,11,22,78},{20,10,98,28},{71,30,35,98},{28,64,24,31},{36,49,40,57}});
		MAP.put(new Input(new int[][]{{17,90,2,70,81,81,63,81,89,28},{58,52,25,18,18,18,9,88,41,20},{66,83,63,86,55,1,46,63,17,98}},0,4,1),new int[][]{{17,90,2,70,81,81,63,81,89,28},{58,52,25,18,18,18,9,88,41,20},{66,83,63,86,55,1,46,63,17,98}});
		MAP.put(new Input(new int[][]{{64,6,99,13,24,31,39},{51,17,2,20,70,42,41},{48,16,3,21,22,22,68},{88,95,75,30,74,52,18},{93,46,56,97,30,7,14}},3,1,2),new int[][]{{64,6,99,13,24,31,39},{51,17,2,20,70,42,41},{48,16,3,21,22,22,68},{88,46,56,30,74,52,18},{93,95,75,97,30,7,14}});
		MAP.put(new Input(new int[][]{{58,18,66,1,42,80},{59,41,91,51,10,27},{36,53,95,39,93,100},{4,85,39,72,54,36},{84,38,30,55,28,83},{55,36,98,64,51,20}},0,4,2),new int[][]{{58,18,66,1,10,27},{59,41,91,51,42,80},{36,53,95,39,93,100},{4,85,39,72,54,36},{84,38,30,55,28,83},{55,36,98,64,51,20}});
		MAP.put(new Input(new int[][]{{77,14,18,6,20,97},{36,89,93,11,56,83},{40,27,90,59,55,28},{51,63,52,8,13,68},{85,49,76,96,32,85},{1,24,82,86,46,40},{93,47,72,48,21,59}},1,2,1),new int[][]{{77,14,18,6,20,97},{36,89,93,11,56,83},{40,27,90,59,55,28},{51,63,52,8,13,68},{85,49,76,96,32,85},{1,24,82,86,46,40},{93,47,72,48,21,59}});
		MAP.put(new Input(new int[][]{{99,76,37,57,23,21,4},{2,7,75,4,74,64,7},{99,72,75,33,24,77,22},{15,86,66,7,14,68,63},{51,90,21,26,49,21,58},{72,35,68,5,40,24,55},{59,50,90,90,46,7,33}},1,3,1),new int[][]{{99,76,37,57,23,21,4},{2,7,75,4,74,64,7},{99,72,75,33,24,77,22},{15,86,66,7,14,68,63},{51,90,21,26,49,21,58},{72,35,68,5,40,24,55},{59,50,90,90,46,7,33}});
		MAP.put(new Input(new int[][]{{24,50,21,44,34,24,39,56},{27,78,68,67,69,50,76,97},{72,63,38,16,99,43,90,42},{42,77,12,53,34,95,99,34},{58,76,68,14,76,69,54,14},{16,90,69,50,70,30,70,87}},2,3,4),new int[][]{{24,50,21,44,34,24,39,56},{27,78,68,67,69,50,76,97},{72,63,38,50,70,30,70,42},{42,77,12,14,76,69,54,34},{58,76,68,53,34,95,99,14},{16,90,69,16,99,43,90,87}});
		MAP.put(new Input(new int[][]{{4,8,100,22,89,83,74,97},{12,73,40,28,91,76,96,27},{94,75,1,53,33,58,32,60},{26,56,55,29,7,11,8,58},{52,37,57,95,8,51,95,54},{9,15,33,78,2,38,92,9},{88,15,50,15,53,33,98,96}},5,2,1),new int[][]{{4,8,100,22,89,83,74,97},{12,73,40,28,91,76,96,27},{94,75,1,53,33,58,32,60},{26,56,55,29,7,11,8,58},{52,37,57,95,8,51,95,54},{9,15,33,78,2,38,92,9},{88,15,50,15,53,33,98,96}});
		MAP.put(new Input(new int[][]{{83,42,53,64,59,22},{24,78,87,94,90,4},{1,21,84,32,64,26},{41,30,77,98,36,4},{91,97,77,46,46,63},{50,95,80,1,60,15},{70,62,67,15,5,88},{7,2,58,96,12,67},{4,95,68,73,82,9},{93,25,45,17,70,35}},7,3,3),new int[][]{{83,42,53,64,59,22},{24,78,87,94,90,4},{1,21,84,32,64,26},{41,30,77,98,36,4},{91,97,77,46,46,63},{50,95,80,1,60,15},{70,62,67,15,5,88},{7,2,58,17,70,35},{4,95,68,73,82,9},{93,25,45,96,12,67}});
		MAP.put(new Input(new int[][]{{43,53,35,47,61,76,88,61,19,72},{46,86,98,66,60,27,18,62,99,85},{57,97,85,2,100,63,47,49,87,99},{44,81,56,20,46,43,86,57,37,27},{93,52,42,27,96,48,62,39,64,40},{19,52,27,33,51,98,69,83,25,87},{73,15,14,36,75,58,3,27,21,39},{37,67,54,4,7,74,7,3,51,65},{68,95,47,60,73,99,16,51,25,6}},5,2,4),new int[][]{{43,53,35,47,61,76,88,61,19,72},{46,86,98,66,60,27,18,62,99,85},{57,97,85,2,100,63,47,49,87,99},{44,81,56,20,46,43,86,57,37,27},{93,52,42,27,96,48,62,39,64,40},{19,52,47,60,73,99,69,83,25,87},{73,15,54,4,7,74,3,27,21,39},{37,67,14,36,75,58,7,3,51,65},{68,95,27,33,51,98,16,51,25,6}});
	}

	@Test
	void reverseSubmatrix()
	{
		for (Map.Entry<Input, int[][]> entry : MAP.entrySet())
		{
			final int[][] grid = entry.getKey().grid();
			final int x = entry.getKey().x();
			final int y = entry.getKey().y();
			final int k = entry.getKey().k();
			final int[][] expected = entry.getValue();
			final int[][] actual = FlipSquareSubmatrixVertically.reverseSubmatrix(grid, x, y, k);

			String message = String.format("Test failed for case:"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input",
				"Grid", Arrays.deepToString(grid),
				"X", x,
				"Y", y,
				"K", k,
				"Output",
				"Expected", Arrays.deepToString(expected),
				"Actual", Arrays.deepToString(actual),
				""
			);

			assertArrayEquals(actual, expected, message);
		}
	}

	private static void generateTests()
	{
		final int count = 16;
		final int maxValue = 100;
		final int maxDimension = 10;

		List<Input> list = new ArrayList<>();

		for (int c = 0; c < count; ++c)
		{
			int m = ThreadLocalRandom.current().nextInt(maxDimension) + 1;
			int n = ThreadLocalRandom.current().nextInt(maxDimension) + 1;
			int x = ThreadLocalRandom.current().nextInt(m);
			int y = ThreadLocalRandom.current().nextInt(n);
			int k = Math.min(Math.min(m - x, n - y), Math.max(1, ThreadLocalRandom.current().nextInt(Math.min(m, n))));
			int[][] grid = new int[m][n];

			for (int i = 0; i < m; ++i)
			{
				grid[i] = DataUtils.generateArray(IntArraySpec.builder(n).lowerBound(1).upperBound(maxValue).build());
			}
			list.add(new Input(grid, x, y, k));
		}

		for (Input item : list)
		{
			String s = Arrays.deepToString(item.grid()) + ", " +
				item.x() + ", " +
				item.y() + ", " +
				item.k();
			System.out.println(s.replaceAll("]", "}").replaceAll("\\[", "{").replaceAll(" ", ""));
		}
		System.out.println();
		for (Input item : list)
		{
			System.out.printf("%s%n%s%n%s%n%s%n", Arrays.deepToString(item.grid()), item.x(), item.y(), item.k());
		}
	}
}

record Input(int[][] grid, int x, int y, int k)
{

}