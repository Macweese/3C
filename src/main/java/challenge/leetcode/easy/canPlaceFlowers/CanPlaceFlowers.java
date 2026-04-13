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

package challenge.leetcode.easy.canPlaceFlowers;

/**
 * @author Administrator
 * @Created 18:34 Mon 13 April 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class CanPlaceFlowers
{
	public static boolean canPlaceFlowers(int[] ints, int n)
	{
		int count = 0;

		for (int i = 0; i < ints.length && count < n; i++)
		{
			int prev = 1 ^ ints[Math.max(0, i - 1)];
			int curr = 1 ^ ints[i];
			int next = 1 ^ ints[Math.min(i + 1, ints.length - 1)];
			int possible = prev * curr * next;

			ints[i] |= possible;
			count += possible;
			// skip next if this index was counted, since then next will always be invalid
			// if the next is occupied, then it cannot be counted, neither can the one after that, thus, jump 2 extra
			i += (next ^ 1) * 2;
		}

		return count >= n;
	}

	public static boolean golfed(int[]a,int n){for(int i=0,q=a.length;i<q;i++)if(a[i]<1&(i<1||a[i-1]<1)&(i+1==q||a[i+1]<1))a[i]=n--;return n<1;}
}
