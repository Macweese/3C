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

package challenge.leetcode.medium.findUniqueBinaryStrings;

/**
 * @author Administrator
 * @Created 07:05 Sun 08 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class FindUniqueBinaryStrings
{
	public static String findDifferentBinaryString(String[] nums)
	{
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i].charAt(i) == '0')
			{
				result.append('1');
			}
			else
			{
				result.append('0');
			}
		}
		return result.toString();
	}
}
