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

package challenge.leetcode.easy.countOddNumbersInAnIntervalRange;

/**
 * @author Administrator
 * @Created 11:13 Mon 08 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class CountOddNumbersInAnIntervalRange
{
	public static int countOdds(int a, int b)
	{
		return (b % 2 == 1) && (a % 2 == 1) ? (((b + 1) - a) / 2) + 1: ((b + 1) - a) / 2;
	}
}
