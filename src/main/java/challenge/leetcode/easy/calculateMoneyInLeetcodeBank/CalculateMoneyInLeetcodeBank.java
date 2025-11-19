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

package challenge.leetcode.easy.calculateMoneyInLeetcodeBank;

/**
 * @author Administrator
 * @Created 25/10/2025, 02:04 Sat 25 October 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class CalculateMoneyInLeetcodeBank
{
	public static int totalMoney(int n)
	{
		int balance = 0;
		int week = 0;
		for (; week < (n / 7); week++)
		{
			balance += 28 + week * 7;
		}

		for (int i = 0, day = week * 7; day < n; i++, day++)
		{
			balance += i + (week + 1);
		}

		return balance;
	}
}
