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

package challenge.leetcode.medium.takingMaximumEnergyFromTheMysticDungeon;

/**
 * @author Administrator
 * @Created 10/10/2025, 23:28 Fri 10 October 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class TakingMaximumEnergyFromTheMysticDungeon
{
	public static int maximumEnergy(int[] energy, int k)
	{
		int[] sum = new int[k];

		int max = Integer.MIN_VALUE;
		for (int i = energy.length - 1 - k; i > energy.length - (energy.length % k); i--)
		{
			max = Math.max(max, energy[i]);
			energy[i] = 0;
		}

		for (int i = 0; i < energy.length; i++)
		{
			sum[i % k] += energy[i];
		}

		for (int i : sum)
		{
			max = Math.max(max, i);
		}
		return max;
	}
}
