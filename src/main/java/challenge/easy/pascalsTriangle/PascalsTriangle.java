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
package challenge.easy.pascalsTriangle;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @Created 01/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 118
 * @Name Pascal's Triangle
 * @Difficulty Easy
 * @Tags array
 * arrays
 * dp
 * dynamic programming
 * @link <a href="https://leetcode.com/problems/pascals-triangle/">www.leetcode.com/118</a>
 * @Description <p>Given an integer <code>numRows</code>, return the first numRows of <strong>Pascal's triangle</strong>.</p>
 * <br>
 * <p>In <strong>Pascal's triangle</strong>, each number is the sum of the two numbers directly above it as shown:</p>
 * <br>
 * <img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif"/>
 * <img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif" style="height: 240px; width: 260px;"/>
 * <br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>numRows = 5</code>
 * 			<br><b>Output:</b> {@code [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>numRows = 1</code>
 * 			<br><b>Output:</b> {@code [[1]]}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; numsRows &le; 30</code></li>
 * </ul>
 * </p>
 **/
public class PascalsTriangle
{
	public static void main(String[] args)
	{
		for (List<Integer> list : generate(5))
		{
			System.out.println(list);
		}

		String s = "test";
		for (byte b : s.getBytes())
		{
			System.out.printf("%2x", b);
		}
		System.out.println();
		System.out.println(h(s));

	}

	//
	// 00000000: 436f 6465 2047 6f6c 6620 6973 2061 2067  Code Golf is a g
	// 00000010: 616d 6520 6465 7369 676e 6564 2074 6f20  ame designed to
	// 00000020: 6c65 7420 796f 7520 7368 6f77 206f 6666  let you show off
	// 00000030: 2079 6f75 7220 636f 6465 2d66 7520 6279   your code-fu by
	// 00000040: 2073 6f6c 7669 6e67 2070 726f 626c 656d   solving problem
	// 00000050: 7320 696e 2074 6865 206c 6561 7374 206e  s in the least n
	// 00000060: 756d 6265 7220 6f66 2063 6861 7261 6374  umber of charact
	// 00000070: 6572 732e                                ers.
	public static String h(String s)
	{
		return String.format("%040x", new BigInteger(1, s.getBytes()));
	}


	public static List<List<Integer>> generate(int n)
	{
		return generatePascalTriangle(new ArrayList<>(), new int[]{1}, 1, n);
	}

	public static List<List<Integer>> generatePascalTriangle(List<List<Integer>> triangle, int[] previousRow, int currentRow, int maxRow)
	{
		if (currentRow > maxRow)
		{
			return triangle;
		}

		int[] row = new int[currentRow];
		Arrays.fill(row, 1);

		for (int i = 1; i < row.length - 1; i++)
		{
			row[i] = previousRow[i - 1] + previousRow[i];
		}

		triangle.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
		generatePascalTriangle(triangle, row, currentRow + 1, maxRow);
		return triangle;
	}
}
