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
package challenge.leetcode.easy.sumOfAllSubsetXORTotals;

/**
 * @author Administrator
 * @Created 25/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1863
 * @Name Sum of All Subset XOR Totals
 * @Difficulty Easy
 * @Tags array
 * math
 * maths
 * backtracking
 * bit
 * bits
 * manipulation
 * combinatorics
 * enumeration
 * weekly contest 241
 * @link <a href="https://leetcode.com/problems/sum-of-all-subset-xor-totals/">www.leetcode.com/1863</a>
 * @Description The <b>XOR total</b> of an array is defined as the bitwise <code>XOR</code> of <b>all its elements</b>,
 * or <code>0</code> if the array is empty.<br>
 *
 * <ol>
 * 		<li>For example, the <b>XOR total</b> of the array <code>[2,5,6]</code> is <code>2 XOR 5 XOR 6 = 1</code>.</li>
 * </ol>
 *
 * <br>Given an array <code>nums</code>, return the <i><b>sum</b> of all <b>XOR totals</b> for every <b>subset</b> of</i> <code>nums</code>.<br>
 *
 * <br><b>Note</b>: Subsets with the <b>same</b> elements should be counted <b>multiple</b> times.<br>
 *
 * <br>An array <code>a</code> is a <b>subset</b> of an array <code>b</code> if <code>a</code> can be obtained from
 * <code>b</code> by deleting some (possibly zero) elements of <code>b</code>.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code nums = [1,3]}
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b> The 4 subsets of [1,3] are:
 * 			<br>&emsp;- The empty subset has an XOR total of 0.
 * 			<br>&emsp;- [1] has an XOR total of 1.
 * 			<br>&emsp;- [3] has an XOR total of 3.
 * 			<br>&emsp;- [1,3] has an XOR total of 1 XOR 3 = 2.
 * 			<br>&emsp;0 + 1 + 3 + 2 = 6
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code nums = [5,1,6]}
 * 			<br><b>Output:</b> {@code 28}
 * 			<br><b>Explanation:</b> The 8 subsets of [5,1,6] are:
 * 			<br>&emsp;- The empty subset has an XOR total of 0.
 * 			<br>&emsp;- [5] has an XOR total of 5.
 * 			<br>&emsp;- [1] has an XOR total of 1.
 * 			<br>&emsp;- [6] has an XOR total of 6.
 * 			<br>&emsp;- [5,1] has an XOR total of 5 XOR 1 = 4.
 * 			<br>&emsp;- [5,6] has an XOR total of 5 XOR 6 = 3.
 * 			<br>&emsp;- [1,6] has an XOR total of 1 XOR 6 = 7.
 * 			<br>&emsp;- [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
 * 			<br>&emsp;0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code nums = [3,4,5,6,7,8]}
 * 			<br><b>Output:</b> {@code 480}
 * 			<br><b>Explanation:</b> The sum of all XOR totals for every subset is 480.
 * 		</li>
 * </ul>
 * <p>
 * <b>Constraints:</b><br>
 * <ul>
 * 		<li><code> 1 &le; nums.length &le; 12</code></li>
 * 		<li><code> 1 &le; nums[i] &le; 20</code></li>
 * </ul>
 * </p>
 **/
public class SumOfAllSubsetXORTotals
{
	public static void main(String[] args)
	{
		System.out.println(subsetXORSum(new int[]{1, 8}));
	}

	/**
	 * <h1>Bit-manipulation & combinatorics</h1>
	 *
	 * <h2>Explanation</h2>
	 * Any given element <code>s</code> in the set <code>S</code>
	 * is present in exactly half of all the subsets of <code>S</code>.
	 * Because of this, it is unnecessary to calculate what the subsets are and their elements,
	 * since specific subsets and their elements are trivial:
	 *
	 * <ol>
	 * 		<li>the total number of occurrences of an element <code>s</code> is already known</li>
	 * 		<li>the number of subsets is equal to the number of <i>combinations</i> given a set of numbers, which is the cardinality of the power set:
	 * 		<br><i>|&#8473;(S)| = 2<sup>|S|</sup></i></li>
	 * </ol>
	 *
	 * <br>
	 * <p>
	 * 		Calculating the power set is trivial,
	 * 		because knowing or keeping track of the constitution of any subset is unimportant in our mission,
	 * 		as any given element of <i>S</i> will be found in the half of the cardinality of the power set.<br>
	 * 		<br>
	 * 		<h4>
	 * 			Mathematical note:<br>
	 * 			This is proven to us by combinatorial reasoning.<br>
	 * 			The frequency of element <i>s</i> in all the subsets of <i>S</i> can be calculated by:<br>
	 * 			<i>Frequency</i> = 2<sup>|S|-1</sup>
	 * 		</h4>
	 * </p>
	 * <br>
	 *
	 * <p>
	 * 		Thus, to calculate the sum of <code>XOR</code> of all subsets,
	 * 		the number given by setting all possible occupied bit-positions from the elements of <code>S</code> to <code>1</code>,
	 * 		can be multiplied by the frequency that the respective bit position is set to <code>1</code> for that number,
	 * 		which is half the size of the set</sup>.<br>
	 * <br>
	 * </p>
	 *
	 * <br>
	 * <h2>Simplified explanation</h2>
	 * The possible bit positions for any number s of a set S will be set to <code>1</code> exactly <code>set_size/2</code> times.
	 * Calculate what the number is where all the possible bit positions are set to <code>1</code>, and multiply it by half the set size.<br>
	 * <br>
	 * Take a set S where <code>S = {2, 8}</code>,
	 * the subsets of S are:<br>
	 * <code>S<sub>1</sub> = {} &#9;&#9;= {0000}</code><br>
	 * <code>S<sub>2</sub> = {2} &#9;&#9;= {0010}</code><br>
	 * <code>S<sub>3</sub> = {8} &#9;&#9;= {1000}</code><br>
	 * <code>S<sub>4</sub> = {2, 8} &#9;= {0010, 1000}</code><br>
	 * <br>
	 * <p>
	 * The highest number achievable from the "enabled" bit-positions, is <code>10</code>:<br>
	 * &#9;<code>&nbsp;&nbsp;&nbsp;&nbsp;0010</code>&#9;<code>= 2</code><br>
	 * &#9;<code>XOR&nbsp;1000</code>&#9;<code></code>= 8<br>
	 * &#9;<code>=&nbsp;&nbsp;&nbsp;1010</code>&#9;<code>= 10</code><br>
	 * &#9;<code></code>
	 * <br>
	 * So, take this max number,
	 * and multiply it by the amount of times that the bit-positions for <code>10</code> are occupied from an XOR operation,
	 * which is half the set size.<br>
	 * <br>
	 * Count the occurrence of the <code>1</code> bits in their respective position:<br>
	 * &#9; <code>S<sub>1</sub> = 0000</code><br>
	 * &#9; <code>S<sub>2</sub> = 00<b>1</b>0</code><br>
	 * &#9; <code>S<sub>3</sub> = <b>1</b>000</code><br>
	 * &#9; <code>S<sub>4</sub> = 00<b>1</b>0</code><br>
	 * &#9; <code>S<sub>4</sub> = <b>1</b>000</code><br>
	 * <!--- &#9; &mdash;&mdash;&mdash;&mdash;&mdash;<br> --->
	 * &#9; <code>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>^ ^ </b>&nbsp;&nbsp;= 2</code><br>
	 * &#9; &mdash;&mdash;&mdash;&mdash;&mdash;<br>
	 * &#9; <code>2&nbsp;&nbsp;&times;&nbsp;1010&nbsp;&nbsp;= 2 &times; 10</code><br>
	 * &#9; <code>&nbsp;&nbsp;&nbsp;=&nbsp;20</code><br>
	 *
	 * <br>
	 * <br>
	 *
	 * <hr> <!--- line separator --->
	 *
	 * <br>
	 * <h3>Example</h3>
	 * Given the set <code>S</code> such that<br>
	 * <code>S = {1, 5, 6}</code><br>
	 *
	 * <br>The subsets of <code>S</code> are:<br>
	 * <code>S<sub>1</sub> = {}</code><br>
	 * <code>S<sub>2</sub> = {1}</code><br>
	 * <code>S<sub>3</sub> = {5}</code><br>
	 * <code>S<sub>4</sub> = {6}</code><br>
	 * <code>S<sub>5</sub> = {1, 5}</code><br>
	 * <code>S<sub>6</sub> = {1, 6}</code><br>
	 * <code>S<sub>7</sub> = {5, 6}</code><br>
	 * <code>S<sub>8</sub> = {1, 5, 6}</code><br>
	 *
	 * <br>Binary representation of each element of <code>S</code>:<br>
	 * <code>1 = 0001</code><br>
	 * <code>5 = 0101</code><br>
	 * <code>6 = 0110</code><br>
	 *
	 * <br>The highest number achievable from <code>bitwise-XOR</code> on the elements of a subset of <code>S</code> is <code>7</code>.
	 * Which is obtained from the subset <code>S<sub>6</sub> = {1, 6}</code> :<br>
	 * <code>&#9;1 = 0001</code><br>
	 * <code>&emsp;&emsp;XOR&#9;6 = 0110</code><br>
	 * <code>&#9;________</code><br>
	 * <code>&#9;7 = 0111</code><br>
	 *
	 * <br>This is because, of all binary values of the elements of <code>S</code>,
	 * 7 is the value obtained where all the bits of the possible occupied bit-positions are <code>1</code> ("enabled").<br>
	 *
	 * <br>This discovery can be achieved by either
	 * <ol>
	 * 		<li>iterating through all elements of each subset of <code>S</code>,
	 * 		and keeping track of the highest <code>XOR</code> result so far</li>
	 *
	 * 		<i>or</i>
	 *
	 * 		<li>iterating through all elements of <code>S</code>,
	 * 		and keeping track of the value yielded by performing a <code>bitwise-OR</code></li>
	 * </ol>
	 * Applying solution option 2, on the set <code>S</code>, would be the following:<br>
	 * <code>s<sub><i>max</i></sub></code> &#8797; 0<br>
	 * <br>
	 * <br><b>1.</b>&#9;<code>s<sub><i>1</i></sub>=&#8709;&#9;0 = 0000</code><br>
	 * &#9;bitwise-<code>OR</code>&#9;&mdash;&mdash;&mdash;&mdash;&mdash;<br>
	 * &#9;<code>s<sub><i>1-max</i></sub> = &#9;0 = 0000</code><br>
	 * &#9;<code>s<sub><i>max</i></sub> = &#9;0 = 0000</code><br>
	 * <br>
	 * <br><b>2.</b>&#9;<code>s<sub><i>2</i></sub>={1}&#9;1 = 0001</code><br>
	 * &#9;&emsp;<code>OR</code>&#9;&mdash;&mdash;&mdash;&mdash;&mdash;<br>
	 * &#9;<code>s<sub><i>2-max</i></sub> = &#9;1 = 0001</code><br>
	 * &#9;<code>s<sub><i>max</i></sub> = &#9;1 = 0001</code><br>
	 * <br>
	 * <br><b>3.</b>&#9;<code>s<sub><i>3</i></sub>={5}&#9;5 = 0101</code><br>
	 * &#9;&emsp;<code>OR</code>&#9;&mdash;&mdash;&mdash;&mdash;&mdash;<br>
	 * &#9;<code>s<sub><i>3-max</i></sub> = &#9;5 = 0101</code><br>
	 * &#9;<code>s<sub><i>max</i></sub> = &#9;5 = 0101</code><br>
	 * <br>
	 * <br><b>4.</b>&#9;<code>s<sub><i>4</i></sub>={6}&#9;6 = 0110</code><br>
	 * &#9;&emsp;<code>OR</code>&#9;&mdash;&mdash;&mdash;&mdash;&mdash;<br>
	 * &#9;<code>s<sub><i>4-max</i></sub> = &#9;6 = 0110</code><br>
	 * &#9;<code>s<sub><i>max</i></sub> = &#9;6 = 0111</code><br>
	 * <br>
	 * <br><b>5.</b>&#9;<code>s<sub><i>5</i></sub>={1,5}&#9;1 = 0001</code><br>
	 * &#9;<code>&#9;5 = 0101</code><br>
	 * &#9;&emsp;<code>OR</code>&#9;&mdash;&mdash;&mdash;&mdash;&mdash;<br>
	 * &#9;<code>s<sub><i>5-max</i></sub> = &#9;4 = 0100</code><br>
	 * &#9;<code>s<sub><i>max</i></sub> = &#9;6 = 0111</code><br>
	 * <br>
	 * <br><b>6.</b>&#9;<code>s<sub><i>6</i></sub>={1,6}&#9;1 = 0001</code><br>
	 * &#9;<code>&#9;6 = 0110</code><br>
	 * &#9;&emsp;<code>OR</code>&#9;&mdash;&mdash;&mdash;&mdash;&mdash;<br>
	 * &#9;<code>s<sub><i>6-max</i></sub> = &#9;7 = 0111</code><br>
	 * &#9;<code>s<sub><i>max</i></sub> = &#9;7 = 0111</code><br>
	 * <br>
	 * <br><b>7.</b>&#9;<code>s<sub><i>7</i></sub>={5,6}&#9;5 = 0101</code><br>
	 * &#9;<code>&#9;6 = 0110</code><br>
	 * &#9;&emsp;<code>OR</code>&#9;&mdash;&mdash;&mdash;&mdash;&mdash;<br>
	 * &#9;<code>s<sub><i>7-max</i></sub> = &#9;3 = 0010</code><br>
	 * &#9;<code>s<sub><i>max</i></sub> = &#9;7 = 0111</code><br>
	 * <br>
	 * <br><b>8.</b>&#9;<code>s<sub><i>8</i></sub>=&#9;1 = 0001</code><br>
	 * &#9;<code>{1,5,6}&#9;5 = 0101</code><br>
	 * &#9;<code>&#9;6 = 0110</code><br>
	 * &#9;&emsp;<code>OR</code>&#9;&mdash;&mdash;&mdash;&mdash;&mdash;<br>
	 * &#9;<code>s<sub><i>8-max</i></sub> = &#9;2 = 0010</code><br>
	 * &#9;<code>s<sub><i>max</i></sub> = &#9;7 = 0111</code><br>
	 *
	 * <br>s<sub><i>max</i></sub> = 7<br>
	 * Thus, 7 is taken, and multiplied by the frequency <i>f</i> where each respective bit position for 7 is set to <code>1</code>, which is<br>
	 * &#9;<i>f</i> = 2<sup>|S|-1</sup><br>
	 * &#9;<i>f</i> = 2<sup>3-1</sup> = 2<sup>2</sup><br>
	 * &#9;<i>f</i> = 4<br>
	 * <br>Finally, the XOR-total of all subsets can be calculated<br>
	 * &#9;<i>sum<sub>XOR</sub></i> = s<sub><i>max</i></sub> &times; <i>f</i><br>
	 * &#9;<i>sum<sub>XOR</sub></i> = s<sub><i>max</i></sub> &times; <i>f</i><br>
	 * &#9;<i>sum<sub>XOR</sub></i> = 7 &times; 4<br>
	 * &#9;<i>sum<sub>XOR</sub></i> = 28<br>
	 *
	 * @param ints
	 * @return
	 */
	public static int subsetXORSum(int[] ints)
	{
		int sum = 0;
		for (int i : ints)
		{
			sum |= i;
		}

		return sum * (int) Math.pow(2, ints.length - 1);
	}
}