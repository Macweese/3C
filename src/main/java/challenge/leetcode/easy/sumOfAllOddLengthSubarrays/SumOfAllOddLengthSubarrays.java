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
package challenge.leetcode.easy.sumOfAllOddLengthSubarrays;

import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @Created 15/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 1588
 * @Difficulty Easy
 * @Tags array
 * arrays
 * math
 * prefix sum
 * @link <a href="https://leetcode.com/problems/sum-of-all-odd-length-subarrays/">www.leetcode.com/1588</a>
 * @Description Given an array of positive integers <code>arr</code>,
 * return <i>the sum of all possible <b>odd-length subarrays</b> of</i> <code>arr</code>.<br>
 *
 * <br>A <b>subarray</b> is a contiguous subsequence of the array.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code arr = [1,4,2,5,3]}
 * 			<br><b>Output:</b> {@code 58}
 * 			<br><b>Explanation:</b> The odd-length subarrays of arr and their sums are:
 * 			<br>{@code [1] = 1}
 * 			<br>{@code [4] = 4}
 * 			<br>{@code [2] = 2}
 * 			<br>{@code [5] = 5}
 * 			<br>{@code [3] = 3}
 * 			<br>{@code [1,4,2] = 7}
 * 			<br>{@code [4,2,5] = 11}
 * 			<br>{@code [2,5,3] = 10}
 * 			<br>{@code [1,4,2,5,3] = 15}
 * 			<br>If we add all these together we get <br>{@code 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code arr = [1,2]}
 * 			<br><b>Output:</b> {@code 3}
 * 			<br><b>Explanation:</b> There are only 2 subarrays of odd length:
 * 			<br>{@code [1] = 1}
 * 			<br>{@code [2] = 2}
 * 			<br>{@code 1 + 2 = 3}.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> {@code arr = [10,11,12]}
 * 			<br><b>Output:</b> {@code 66}
 * 			<br><b>Explanation:</b>
 * 			<br>{@code [10] = 10}
 * 			<br>{@code [11] = 11}
 * 			<br>{@code [12] = 12}
 * 			<br>{@code [10,11,12] = 33}
 * 			<br>{@code 10 + 11 + 12 + 33 = 66}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; arr.length &le; 100</code></li>
 * 		<li><code>1 &le; arr[i] &le; 1000</code></li>
 * </ul>
 * </p>
 * <br>
 * <h3>Follow up</h3>
 * • Could you solve this problem in O(n) time complexity?
 **/
@Slf4j
public class SumOfAllOddLengthSubarrays
{
	public static int sumOddLengthSubarrays(int[] arr)
	{
		int sum = 0;
		for (int i = 0; i < arr.length; i += 2)
		{
			sum += sumSubArray(arr, i + 1);
		}

		return sum;
	}

	static int sumSubArray(int arr[], int k)
	{
		int sum = 0;
		for (int i = 0; i < k; i++)
		{
			sum += arr[i];
		}

		int subSum = sum;
		for (int i = k; i < arr.length; i++)
		{
			subSum += arr[i] - arr[i - k];
			sum = sum + subSum;
		}

		return sum;
	}

	/**
	 * For each element <code>i</code> of the passed array <code>arr[]</code>,
	 * the solution to this problem is to sum together all:
	 * <code>arr[i] *</code> (number of odd length subarrays that include <code>a[i]</code>)<br>
	 *
	 * <br>Examples of multipliers for arrays of various lengths are shown below.<br>
	 * For the given length of <code>arr[]</code>,
	 * multiply all <code>arr[i]</code> by the i<sup>th</sup> number in the corresponding line of the examples below,
	 * then sum all products for the solution to the problem.<br>
	 * <br>From the example below, if <code>arr.length</code> is 5, then the answer to this problem is:<br>
	 * <code>arr[0] * <b>3</b> + arr[1] * <b>4</b> + arr[2] * <b>5</b> + arr[3] * <b>4</b> + arr[4] * <b>3</b><br></code>
	 * where the bold numbers are the multipliers from the examples below.<br>
	 *
	 *
	 * <br>The example below graphically shows how the multipliers are related to odd length subarrays for <code>arr.length == 7</code>.
	 * The odd length subarrays are shown in square brackets "<code>[--]</code>", for length 1, 3, 5, and 7 subarrays.<br>
	 * <p>
	 * Within a vertical column in the example below,
	 * count the number of subarrays in that column,
	 * to get the multiplier shown on the last line of the example.
	 *
	 * <br>
	 * <code>
	 * <br> |[-] [-] [-] [-] [-] [-] [-]|
	 * <br> |[---------]&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;| subarrays of length 1
	 * <br> |&nbsp;.&nbsp;&nbsp;[---------]&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;| subarrays of length 3
	 * <br> |&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;[---------]&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;|
	 * <br> |&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;[---------]&nbsp;&nbsp;.&nbsp;|
	 * <br> |&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;[---------]|
	 * <br> |[-----------------]&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;| subarrays of length 5
	 * <br> |&nbsp;.&nbsp;&nbsp;[-----------------]&nbsp;&nbsp;.&nbsp;|
	 * <br> |&nbsp;.&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;[-----------------]|
	 * <br> |[-------------------------]| subarray of length 7
	 * <br> |&nbsp;4&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;8&nbsp;&nbsp;&nbsp;8&nbsp;&nbsp;&nbsp;8&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;4&nbsp;| multipliers
	 * </code>
	 * <br>
	 *
	 * <br><code>arr.length == <b>2</b></code>  : 1 1
	 * <br><code>arr.length == <b>3</b></code>  : 2 2 2
	 * <br><code>arr.length == <b>4</b></code>  : 2 3 3 2
	 * <br><code>arr.length == <b>5</b></code>  : 3 4 5 4 3
	 * <br><code>arr.length == <b>6</b></code>  : 3 5 6 6 5 3
	 * <br><code>arr.length == <b>7</b></code>  : 4 6 8 8 8 6 4
	 * <br><code>arr.length == <b>8</b></code>  : 4 7 9 10 10 9 7 4
	 * <br><code>arr.length == <b>9</b></code>  : 5 8 11 12 13 12 11 8 5
	 * <br><code>arr.length == <b>10</b></code> : 5 9 12 14 15 15 14 12 9 5
	 * <br><code>arr.length == <b>11</b></code> : 6 10 14 16 18 18 18 16 14 10 6
	 * <br><code>arr.length == <b>12</b></code> : 6 11 15 18 20 21 21 20 18 15 11 6
	 * <br>
	 *
	 * <br>
	 * The multipliers in the examples above, can be calculated for index <code>i</code> in <code>arr[]</code> by:<br>
	 * <code>((i + 1) * (arr.length - i) + 1) / 2</code>
	 *
	 * @param arr
	 * @return
	 */
	/*
	 * [-] [-] [-] [-] [-] [-] [-]   subarrays of length 1
	 * [---------]  .   .   .   .    subarrays of length 3
	 *  .  [---------]  .   .   .
	 *  .   .  [---------]  .   .
	 *  .   .   .  [---------]  .
	 *  .   .   .   .  [---------]
	 * [-----------------]  .   .    subarrays of length 5
	 *  .  [-----------------]  .
	 *  .   .  [-----------------]
	 * [-------------------------]   subarray of length 7
	 *  4   6   8   8   8   6   4    multipliers
	 */
	static int solution(int[] arr)
	{
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
		{
			sum += (arr[i] * ((((i + 1) * (arr.length - i)) + 1) / 2));
		}
		return sum;
	}
}
