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
package challenge.leetcode.easy.fizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Created 26/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 412
 * @Name Fizz Buzz
 * @Difficulty Easy
 * @Tags math
 * string
 * simulation
 * @link <a href="https://leetcode.com/problems/fizz-buzz/">www.leetcode.com/412</a>
 * @Description Given an integer <code>n</code>, return <i>a string array</i> <code>answer</code> <i><b>(1-indexed)</b> where</i>:
 *
 * <ol>
 * 		<li><code>answer[i] == "FizzBuzz"</code> if <code>i</code> is divisible by <code>3</code> and <code>5</code>.</li>
 * 		<li><code>answer[i] == "Fizz"</code> if <code>i</code> is divisible by <code>3</code>.</li>
 * 		<li><code>answer[i] == "Buzz"</code> if <code>i</code> is divisible by <code>5</code>.</li>
 * 		<li><code>answer[i] == i</code> (as a string) if none of the above conditions are true.</li>
 * </ol>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code n = 3}
 * 			<br><b>Output:</b> {@code ["1","2","Fizz"]}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code n = 5}
 * 			<br><b>Output:</b> {@code ["1","2","Fizz","4","Buzz"]}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code n = 15}
 * 			<br><b>Output:</b> {@code ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]}
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 * 		<li><code> 1 &le; n &le; 10<sup>4</sup></code></li>
 * </ul>
 * </p>
 **/
public class FizzBuzz
{
	public static void main(String[] args)
	{

		System.out.println(fizzBuzz(3));
		System.out.println(fizzBuzz(5));
		System.out.println(fizzBuzz(15));
	}

	public static List<String> fizzBuzz(int n)
	{

		String s;
		List<String> answer = new ArrayList<>();
		for (int i = 1; i <= n; i++)
		{
			s = "";
			if (i % 3 != 0 && i % 5 != 0)
			{
				s = String.valueOf(i);
			}
			if (i % 3 == 0)
			{
				s = "Fizz";
			}
			if (i % 5 == 0)
			{
				s += "Buzz";
			}
			answer.add(s);
		}
		return answer;
	}
}
