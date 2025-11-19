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

package challenge.leetcode.easy.reverseDegreeOfAString;

/**
 * @author Administrator
 * @Created 18:04 Tue 18 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class ReverseDegreeOfAString
{
	public static int reverseDegree(String s)
	{
		int degree = 0;
		for (int i = 0; i < s.length(); ++i)
		{
			degree += (i + 1) * ('z' - s.charAt(i) + 1);
		}

		return degree;
	}
}
