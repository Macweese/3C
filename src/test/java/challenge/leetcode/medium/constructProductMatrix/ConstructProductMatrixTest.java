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

package challenge.leetcode.medium.constructProductMatrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 06:31 Tue 24 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2906. Construct Product Matrix")
class ConstructProductMatrixTest
{
	private static final Map<int[][], int[][]> MAP = new HashMap<>();

	static
	{
		MAP.put(new int[][]{{1,2},{3,4}},new int[][]{{24,12},{8,6}});
		MAP.put(new int[][]{{12345},{2},{1}},new int[][]{{2},{0},{0}});
		MAP.put(new int[][]{{414750857},{449145368},{767292749}},new int[][]{{1462},{3103},{9436}});
		MAP.put(new int[][]{{3,2,5},{6,4,3},{6,3,1}},new int[][]{{615,7095,7776},{6480,9720,615},{6480,615,1845}});
		MAP.put(new int[][]{{137048688,395034800,51674655,853813001,66020662,108245761}},new int[][]{{6270,8220,8250,8865,6900,3375}});
		MAP.put(new int[][]{{4,3,9},{3,9,10},{9,7,8},{8,4,7},{6,1,3}},new int[][]{{3255,225,75},{225,75,11178},{75,1860,7800},{7800,3255,1860},{6285,675,225}});
		MAP.put(new int[][]{{1,5,5,6},{4,7,6,1},{2,3,3,6},{3,6,3,7}},new int[][]{{6570,11190,11190,1095},{7815,11520,1095,6570},{3285,2190,2190,1095},{2190,1095,2190,11520}});
	}

	@Test
	void constructProductMatrix()
	{
		for (Map.Entry<int[][], int[][]> entry : MAP.entrySet())
		{
			final int[][] input = entry.getKey();
			final int[][] expected = entry.getValue();
			final int[][] actual = ConstructProductMatrix.constructProductMatrix(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s ",
				"Input", Arrays.deepToString(input),
				"Expected", Arrays.deepToString(expected),
				"Actual", Arrays.deepToString(actual),
				""
			);

			assertArrayEquals(expected, actual, message);
		}
	}
}