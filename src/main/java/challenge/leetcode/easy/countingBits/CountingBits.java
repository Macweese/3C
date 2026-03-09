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

package challenge.leetcode.easy.countingBits;

/**
 * @author Administrator
 * @Created 05:43 Mon 09 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class CountingBits
{
	public static int[] countBits(int n)
	{
		int[] output = new int[n + 1];

		for (int i = 0; i <= n; ++i)
		{
			output[i] = Integer.bitCount(i);
		}

		return output;
	}

	public static int[] optimized(int n)
	{
		int[] bits = new int[n + 1];
		int i = 1;
		for (; i + 7 <= n; i += 8)
		{
			bits[i] = bits[i >> 1] + (i & 1);
			bits[i + 1] = bits[(i + 1) >> 1];
			bits[i + 2] = bits[(i + 2) >> 1] + ((i + 2) & 1);
			bits[i + 3] = bits[(i + 3) >> 1];
			bits[i + 4] = bits[(i + 4) >> 1] + ((i + 4) & 1);
			bits[i + 5] = bits[(i + 5) >> 1];
			bits[i + 6] = bits[(i + 6) >> 1] + ((i + 6) & 1);
			bits[i + 7] = bits[(i + 7) >> 1];
		}

		for (; i <= n; i++)
		{
			bits[i] = bits[i >> 1] + (i & 1);
		}

		return bits;
	}
}
