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
package challenge.leetcode.easy.numberOfEmpoyeesWhoMetTheTarget;

/**
 * @author Administrator
 * @Created 28/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2798
 * @Name Number of Employees Who Met the Target
 * @Difficulty Easy
 * @Tags array
 * weekly contest 356
 * @link <a href="https://leetcode.com/problems/number-of-employees-who-met-the-target/">www.leetcode.com/2798</a>
 * @Description There are <code>n</code> employees in a company, numbered from <code>0</code> to <code>n - 1</code>.
 * Each employee <code>i</code> has worked for <code>hours[i]</code> hours in the company.
 * <br>
 * The company requires each employee to work for <b>at least</b> <code>target</code> hours.<br>
 * <br>
 * You are given a <b>0-indexed</b> array of non-negative integers <code>hours</code> of length <code>n</code> and a non-negative integer <code>target</code>.<br>
 * <br>
 * Return <i>the integer denoting the number of employees who worked at least</i> <code>target</code> hours.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>hours = [0,1,2,3,4], target = 2</code>
 * 			<br><b>Output:</b> {@code 3}
 * 			<br><b>Explanation:</b> The company wants each employee to work for at least 2 hours.
 * 			<br>&emsp;- Employee 0 worked for 0 hours and didn't meet the target.
 * 			<br>&emsp;- Employee 1 worked for 1 hours and didn't meet the target.
 * 			<br>&emsp;- Employee 2 worked for 2 hours and met the target.
 * 			<br>&emsp;- Employee 3 worked for 3 hours and met the target.
 * 			<br>&emsp;- Employee 4 worked for 4 hours and met the target.
 * 			<br>&emsp;There are 3 employees who met the target.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>hours = [5,1,4,2,2], target = 6</code>
 * 			<br><b>Output:</b> {@code 0}
 * 			<br><b>Explanation:</b> The company wants each employee to work for at least 6 hours.
 * 			<br>&emsp;There are 0 employees who met the target.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; n == hours.length &le; 50</code></li>
 *     <li><code>0 &le; hours[i], target &le; 10<sup>5</sup></code></li>
 *     <li><code>words[i]</code> consists only of lowercase English letters.</li>
 * </ul>
 * </p>
 **/
public class NumberOfEmpoyeesWhoMetTheTarget
{
	public static void main(String[] args)
	{

	}

	public static int numberOfEmployeesWhoMetTarget(int[] hours, int target)
	{
		int passed = 0;
		for (int i : hours)
		{
			passed = i >= target ? passed + 1 : passed;
		}

		return passed;
	}
}
