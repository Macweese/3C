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

package challenge.leetcode.easy.oneBitAndTwoBitCharacters;

/**
 * @author Administrator
 * @Created 01:38 Tue 18 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class OneBitAndTwoBitCharacters
{
	static void main()
	{
	}

	public static boolean isOneBitCharacter(int[] bits)
	{
		int countTrailingOnes = 0;
		for (int i = bits.length - 2; i >= 0; i--)
		{
			if (bits[i] == 1)
			{
				countTrailingOnes++;
			}
			else
			{
				break;
			}
		}
		return countTrailingOnes % 2 == 0;
	}
}
