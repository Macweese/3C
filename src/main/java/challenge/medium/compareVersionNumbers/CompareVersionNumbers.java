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

package challenge.medium.compareVersionNumbers;

/**
 * @author Administrator
 * @Created 23/09/2025, 06:42 Tue 23 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 * @link <a href="">www.leetcode.com/999999999999999999999</a>
 * @Description Description
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>INPUT_INPUT_INPUT</code>
 * 			<br><b>Output:</b> {@code OUTPUT_OUTPUT_OUTPUT}
 * 			<br><b>Explanation:</b>
 * 				<br>&emsp;
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>INPUT_INPUT_INPUT</code>
 * 			<br><b>Output:</b> {@code OUTPUT_OUTPUT_OUTPUT}
 * 			<br><b>Explanation:</b>
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 3:</b>
 * 			<br><b>Input:</b> <code>INPUT_INPUT_INPUT</code>
 * 			<br><b>Output:</b> {@code OUTPUT_OUTPUT_OUTPUT}
 * 			<br><b>Explanation:</b>
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li></li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <a href=""/>1000. NAME (Leetcode)</a><br>
 * <br>
 * {@link solution. 10000. NAME (local)}<br>
 **/
public class CompareVersionNumbers
{
	static void main(String[] args)
	{
		String TEST_1_VER1 = "1.2";
		String TEST_1_VER2 = "1.10";

		System.out.println(compareVersion(TEST_1_VER1, TEST_1_VER2));
	}

	private static final int MAX_REVISIONS = 500;
	public static int compareVersion(String version1, String version2)
	{
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");

		int[] v1 = new int[MAX_REVISIONS];
		int[] v2 = new int[MAX_REVISIONS];

		for (int i = 0; i < MAX_REVISIONS; i++)
		{
			v1[i] = Integer.parseInt(ver1[i]);
		}
		for (int i = 0; i < MAX_REVISIONS; i++)
		{
			v2[i] = Integer.parseInt(ver2[i]);
		}

		for (int i = 0; i < MAX_REVISIONS; i++)
		{
			if (v1[i] < v2[i])
			{
				return -1;
			}
			else if (v1[i] > v2[i])
			{
				return 1;
			}
		}

		return 0;
	}


	public static int alt(String version1, String version2)
	{
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");

		int c = Math.max(ver1.length, ver2.length);
		int[] v1 = new int[c];
		int[] v2 = new int[c];

		for (int i = 0; i < c; i++)
		{
			v1[i] = Integer.parseInt(ver1[i]);
		}
		for (int i = 0; i < c; i++)
		{
			v2[i] = Integer.parseInt(ver2[i]);
		}

		for (int i = 0; i < c; i++)
		{
			if (v1[i] < v2[i])
			{
				return -1;
			}
			else if (v1[i] > v2[i])
			{
				return 1;
			}
		}

		return 0;
	}

	static int golfed(String a,String b){String[]x=a.split("\\."),y=b.split("[.]");for(int i=0,m=x.length,n=y.length;i<m|i<n;i++){int A=i<m?new Integer(x[i]):0,B=i<n?new Integer(y[i]):0;if(A!=B)return A<B?-1:1;}return 0;}
}
