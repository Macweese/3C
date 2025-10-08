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

package challenge.easy.richestCustomerWealth;

/**
 * @author Administrator
 * @Created 13/09/2025, 06:58 Sat 13 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1672
 * @Name Richest Customer Wealth
 * @Difficulty Easy
 * @Tags array
 * matrix
 * weekly contest 217
 * @link <a href="https://leetcode.com/problems/richest-customer-wealth/">www.leetcode.com/1672</a>
 * @Description You are given an <code>m * n</code> integer grid <code>accounts</code>
 * where <code>accounts[i][j]</code> is the amount of money
 * the <code>i<sup>th</sup></code> customer has in the <code>j<sup>th</sup></code> bank.
 * Return <i>the <b>wealth</b> that the richest customer has</i>.<br>
 * <br>
 * A customer's <b>wealth</b> is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum <b>wealth</b>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>accounts = [[1,2,3],[3,2,1]]</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; 1<sup>st</sup> customer has <code>wealth = 1 + 2 + 3 = 6</code>
 * 				<br>&emsp; 2<sup>nd</sup> customer has <code>wealth = 3 + 2 + 1 = 6</code>
 * 				<br>&emsp; Both customers are considered the richest with a wealth of 6 each, so return 6.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>accounts = [[1,5],[7,3],[3,5]]</code>
 * 			<br><b>Output:</b> {@code 10}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp; 1<sup>st</sup> customer has <code>wealth = 6</code>
 * 				<br>&emsp; 2<sup>nd</sup> customer has <code>wealth = 10 </code>
 * 				<br>&emsp; 3<sup>rd</sup> customer has <code>wealth = 8</code>
 * 				<br>&emsp; The 2nd customer is the richest with a wealth of 10.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>accounts = [[2,8,7],[7,1,3],[1,9,5]]</code>
 * 			<br><b>Output:</b> {@code 17}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>m == accounts.length</code></li>
 * 		<li><code>n == accounts[i].length</code></li>
 * 		<li><code>1 &le; m, n &le; 50</code></li>
 * 		<li><code>1 &le; accounts[i][j] &le; 100</code></li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <br>
 **/
public class RichestCustomerWealth
{
	public static void main(String[] args)
	{

	}

	public static int maximumWealth(int[][] accounts)
	{
		int maxWealth = 0;

		for (int[] account : accounts)
		{
			int wealth = 0;
			for (int balance : account)
			{
				wealth += balance;
			}
			maxWealth = Math.max(maxWealth, wealth);
		}

		return maxWealth;
	}
}
