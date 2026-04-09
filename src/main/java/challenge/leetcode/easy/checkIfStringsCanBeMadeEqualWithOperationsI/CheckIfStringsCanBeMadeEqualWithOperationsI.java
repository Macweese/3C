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

package challenge.leetcode.easy.checkIfStringsCanBeMadeEqualWithOperationsI;

/**
 * @author Administrator
 * @Created 06:56 Sun 29 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class CheckIfStringsCanBeMadeEqualWithOperationsI
{
	public static boolean canBeEqual(String a, String b)
	{
		boolean evenCheck = (a.charAt(0) == b.charAt(0) && a.charAt(2) == b.charAt(2))
			|| (a.charAt(0) == b.charAt(2) && a.charAt(2) == b.charAt(0));

		boolean oddCheck = (a.charAt(1) == b.charAt(1) && a.charAt(3) == b.charAt(3))
			|| (a.charAt(1) == b.charAt(3) && a.charAt(3) == b.charAt(1));

		return evenCheck && oddCheck;
	}
}
