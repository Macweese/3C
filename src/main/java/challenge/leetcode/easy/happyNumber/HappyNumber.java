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
package challenge.leetcode.easy.happyNumber;

import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 21/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 202
 * @Name Happy Number
 * @Difficulty Easy
 * @Tags hash table
 * math
 * two pointer
 * two pointers
 * @link <a href="https://leetcode.com/problems/happy-number/">www.leetcode.com/202</a>
 * @Description Write an algorithm to determine if a number <code>n</code> is happy.<br>
 *
 * <br>A <b>happy number</b> is a number defined by the following process:
 *
 * <ul>
 *     <li>Starting with any positive integer, replace the number by the sum of the squares of its digits.</li>
 *     <li>Repeat the process until the number equals 1 (where it will stay), or it <b>loops endlessly in a cycle</b> which does not include 1.</li>
 *     <li>Those numbers for which this process <b>ends in 1</b> are happy.</li>
 * </ul>
 * <p>
 * Return <code>true</code> <i>if</i> <code>n</code> <i>is a happy number, and</i> <code>false</code> <i>if not</i>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code n = 19}
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; 1<sup>2</sup> + 9<suo>2</suo> = 82
 * 				<br>&emsp; 8<sup>2</sup> + 2<suo>2</suo> = 68
 * 				<br>&emsp; 6<sup>2</sup> + 8<suo>2</suo> = 100
 * 				<br>&emsp; 1<sup>2</sup> + 0<suo>2</suo> + 0<sup>2</sup> = 1
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code n = 2}
 * 			<br><b>Output:</b> {@code false}
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 *     <li><code>1 &le; n &le; 2<sup>31</sup>-1</code></li>
 * </ul>
 * </p>
 **/
@Slf4j
public class HappyNumber
{
	static
	{
		BasicConfigurator.configure();
	}

	public static void main(String[] args)
	{

	}

	public static boolean isHappy(int n)
	{
		String number = String.valueOf(n);
		Set<Integer> set = new HashSet<>();
		set.add(n);

		while (true)
		{
			int sum = 0;

			for (char c : number.toCharArray())
			{
				sum = sum + (int) Math.pow(Character.getNumericValue(c), 2);
			}

			if (set.contains(sum))
			{
				return sum == 1;
			}
			set.add(sum);
			number = String.valueOf(sum);
		}
	}
}
