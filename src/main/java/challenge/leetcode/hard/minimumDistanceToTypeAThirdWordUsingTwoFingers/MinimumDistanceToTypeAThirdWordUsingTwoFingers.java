/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.hard.minimumDistanceToTypeAThirdWordUsingTwoFingers;

/**
 * @author Administrator
 * @Created 07:02 Sun 12 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumDistanceToTypeAThirdWordUsingTwoFingers
{
	public static int minimumDistance(String word)
	{
		int n = word.length();
		if (n < 3)
		{
			return 0;
		}

		char[] arr = word.toCharArray();
		int[] store = new int[27];
		for (int i = 0; i < 27; ++i)
		{
			store[i] = Integer.MAX_VALUE;
		}

		store[26] = dist(arr[1], arr[0]);
		store[arr[0] - 'A'] = 0;
		for (int k = 2; k < n; ++k)
		{
			int delta = dist(arr[k], arr[k - 1]), min = store[26];
			for (int i = 0; i < 27; ++i)
			{
				if (store[i] < min)
				{
					min = Math.min(min, store[i] + dist(arr[k], (char) (i + 'A')));
				}
				if (store[i] < Integer.MAX_VALUE)
				{
					store[i] += delta;
				}
			}
			store[arr[k - 1] - 'A'] = Math.min(store[arr[k - 1] - 'A'], min);
		}

		int ans = Integer.MAX_VALUE;
		for (int x : store)
		{
			ans = Math.min(ans, x);
		}

		return ans;
	}

	private static int dist(char a, char b)
	{
		int i = a - 'A';
		int j = b - 'A';
		return Math.abs(i / 6 - j / 6) + Math.abs(i % 6 - j % 6);
	}
}
