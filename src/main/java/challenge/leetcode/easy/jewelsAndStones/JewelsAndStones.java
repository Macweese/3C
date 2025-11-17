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
package challenge.leetcode.easy.jewelsAndStones;

/**
 * @author Administrator
 * @Created 25/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 771
 * @Name Jewels and Stones
 * @Difficulty Easy
 * @Tags hash table
 * string
 * weekly contest 69
 * @link <a href="https://leetcode.com/problems/jewels-and-stones/">www.leetcode.com/771</a>
 * @Description You're given strings <code>jewels</code> representing the types of stones that are jewels,
 * and <code>stones</code> representing the stones you have.
 * Each character in <code>stones</code> is a types of stone you have.
 * You want to know how many of the stones you have are also jewels.<br>
 *
 * <br>Letters are case sensitive, so <code>"a"</code> is considered a different types of stone from <code>"A"</code>.
 *
 * <br>Return the resulting array after performing these operations.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code jewels = "aA", stones = "aAAbbbb"}
 * 			<br><b>Output:</b> {@code 3}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code jewels = "z", stones = "ZZ"}
 * 			<br><b>Output:</b> {@code 0}
 * 		</li>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 * 		<li><code> 1 &le; jewels.length, stones.length &le; 50</code></li>
 * 		<li><code>jewels</code> and <code>stones</code> consist of only English letters.</li>
 * 		<li>All the characters of <code>jewels</code> are <b>unique</b>.</li>
 * </ul>
 * </p>
 **/
public class JewelsAndStones
{
	public static void main(String[] args)
	{

	}

	public static int numJewelsInStones(String jewels, String stones)
	{
		int count = 0;

		outer:
		for (int i = 0; i < stones.length(); i++)
		{
			for (int j = 0; j < jewels.length(); j++)
			{
				if (stones.charAt(i) == jewels.charAt(j))
				{
					count++;
					continue outer;
				}
			}
		}
		return count;
	}
}
