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

package challenge.leetcode.medium.minimumPenaltyForAShop;

/**
 * @author Administrator
 * @Created 01:51 Fri 26 December 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class MinimumPenaltyForAShop
{
	public static int bestClosingTime(String customers)
	{
		int gain = 0;
		int penalty = 0;
		int optimalHour = 0;
		int[][] log = new int[customers.length()][3];
		for (int i = 0; i < customers.length(); i++)
		{
			gain += customers.charAt(i) == 'Y' ? 1 : 0;
			penalty += customers.charAt(i) == 'N' ? 1 : 0;
			log[i][0] = gain;
			log[i][1] = penalty;
			log[i][2] = Math.max(0, gain - penalty);
			optimalHour = log[i][2] > log[optimalHour][2] ? i : optimalHour;
		}

		return log[optimalHour][0] == 0 ? 0 : optimalHour + 1;
	}
}
