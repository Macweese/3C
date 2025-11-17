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
package challenge.leetcode.easy.trionicArrayI;

/**
 * @author Administrator
 * @Created 04/08/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 3637
 * @Name Trionic Array I
 * @Difficulty Easy
 * @Tags weekly contest 461
 * @link <a href="https://leetcode.com/problems/trionic-array-i/">www.leetcode.com/3637</a>
 * @Description You are given an integer array <code>nums</code> of length <code>n</code>.
 * An array is <b>trionic</b> if there exist indices<br>
 *
 * <br>
 * <code>0 &lt; p &lt; q &lt; n − 1</code><br>
 *
 * <br> such that:
 * <ul>
 * 		<li><code>nums[0...p]</code> is <b>strictly</b> increasing,</li>
 * 		<li><code>nums[p...q]</code> is <b>strictly</b> decreasing,</li>
 * 		<li><code>nums[q...n − 1]</code> is <b>strictly</b> increasing.</li>
 * </ul>
 * <p>
 * Return <code>true</code> if <code>nums</code> is trionic, otherwise return <code>false</code>.<br>
 * Return <code>true</code> if <code>nums</code> is trionic, otherwise return <code>false</code>.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>nums = [1,3,5,4,2,6]</code>
 * 			<br><b>Output:</b> {@code true}
 * 			<br><b>Explanation:</b> Pick <code>p = 2</code>, <code>q = 4</code>:
 * 				<br>&emsp;<code>nums[0...2]=[1,3,5]</code> is strictly increasing (<code>1&lt;3&lt;5</code>)
 * 				<br>&emsp;<code>nums[2...4]=[5,4,2]</code> is strictly decreasing (<code>5&gt;4&gt;2</code>)
 * 				<br>&emsp;<code>nums[4...5]=[2,6]</code> is strictly increasing (<code>2&lt;6</code>)
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>nums = [2,1,3]</code>
 * 			<br><b>Output:</b> {@code false}
 * 			<br><b>Explanation:</b> There is no way to pick <code>p</code> and <code>q</code> to form the required three segments.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>3 &le; n &le; 100</code></li>
 * 		<li><code>-1000 &le; nums[i] &le; 1000</code></li>
 * </ul>
 * </p>
 *
 * <b>Authored solution:</b><br>
 * <a href="https://leetcode.com/problems/trionic-array-i/solutions/7045233/single-pass-mathematical-intuition">www.leetcode.com/3637/solution</a>
 **/
public class TrionicArrayI
{
	public static void main(String[] args)
	{

	}

	public static boolean isTrionic(int[] ints)
	{
		int sign = ints[1] - ints[0];
		boolean ascending = 0 < sign;

		if (sign < 1)
		{
			return false;
		}

		int signChanges = 0;
		for (int i = 1; i < ints.length; ++i)
		{
			sign = ints[i] - ints[i - 1];
			if (ascending && sign < 1 || !ascending && sign > -1)
			{
				ascending = !ascending;
				signChanges++;
			}

			if (sign == 0 || signChanges > 2)
			{
				return false;
			}
		}

		return signChanges == 2 && ascending;
	}


	public static boolean golfed(int[] a)
	{
		int m = a[1] - a[0], c = 0, i = 1;
		boolean s = m > 0;
		for (; ++i < a.length; s ^= m > 0 != s)
		{
			m = a[i] - a[i - 1];
			if (m == 0 | c > 2)
			{
				return 0 > 1;
			}
			c += m > 0 != s ? 1 : 0;
		}
		return c == 2 & s;
	}

//	static boolean g(int[]a){
//		int c=0,i=1;
//		boolean s=a[1]>a[0];
//		for(;i++<a.length;){
//			int m=a[i]-a[i-1];
//			s^=m>0!=s;
//			if(m==0|c++>1)return 0>1;
//		}return c==2&s;}


	//turbo golfed xd
//	static boolean g(int[]a){
//		int m,c=0,i=0;
//		var s=a[1]>a[0];
//		for(;++i<a.length;) {
//			m=a[i]-a[i-1];
//			if(m==0|c>2) return 0>1;
//			if(m>0!=s)c++;s=m>0;
//		}
//		return c==2&s;}

	// CRAZY GOLFED
//	static boolean g(int[]a) {
//		int m,c=0,i=0;
//		var s=a[1]>a[0];
//		for(;++i<a.length;s=m>0)
//			if((m=a[i]-a[i-1])==0|c>2) return 0>1;
//		else if(m>0!=s) c++;
//		return c==2&s;
//	}

	// Best yet
//	static boolean g(int[]a){
//		int m,c=0,i=0;
//		var s=a[1]>a[0];
//		for(;++i<a.length;s=m>0)
//			if((m=a[i]-a[i-1])==0|++c>3)return 0>1;
//		else c-=m>0==s?1:0;
//		return c==2&s;
//	}


	static boolean g(int[] a)
	{
		int m, c = 0, i = 0;
		var s = a[1] > a[0];
		for (; ++i < a.length; s = m > 0)
		{
			if ((m = a[i] - a[i - 1]) == 0 | ++c > 3)
			{
				return 0 > 1;
			}
			else
			{
				c -= m > 0 == s ? 1 : 0;
			}
		}
		return c == 2 & s;
	}


}
