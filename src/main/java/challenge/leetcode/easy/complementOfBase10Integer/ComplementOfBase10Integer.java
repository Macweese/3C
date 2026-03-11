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

package challenge.leetcode.easy.complementOfBase10Integer;

/**
 * @author Administrator
 * @Created 06:37 Wed 11 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class ComplementOfBase10Integer
{
	public static int bitwiseComplement(int n)
	{
		int clv = 31 - Integer.numberOfLeadingZeros(n - 1);
		int mask = 1;

		while (clv-- > 0)
		{
			mask |= mask << 1;
		}
		return n == 0 ? 1 : (~n & mask);
	}
}
