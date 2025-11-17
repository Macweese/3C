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

import java.util.Arrays;

/**
 * @author Administrator
 * @Created 10/10/2025, 23:28 Fri 10 October 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 **/
public class TakingMaximumEnergyFromTheMysticDungeon
{
	static void main(String[] args)
	{
		final int[] TEST_1 = {5,2,-10,-5,1};
		final int[] TEST_2 = {-2,-3,-1};

		System.out.println(maximumEnergy(TEST_1, 3));
//		System.out.println(maximumEnergy(TEST_2, 2));

	}

	public static int maximumEnergy(int[] energy, int k)
	{
		int[] sum = new int[k];
		int[] pos = new int[k];
		System.out.println((energy.length / k) * k);
		System.out.println(k);

		System.out.println(Arrays.toString(energy));
		int max = Integer.MIN_VALUE;
		for (int i = energy.length - 1 - k; i > energy.length - (energy.length % k); i--)
		{
			max = Math.max(max, energy[i]);
			System.out.println(Arrays.toString(energy));
			energy[i] = 0;
		}
		System.out.println(Arrays.toString(energy));

		for (int i = 0; i < energy.length; i++)
		{
			sum[i % k] += energy[i];

		}

		System.out.println(Arrays.toString(sum));
		for (int i : sum)
		{
			max = Math.max(max, i);
		}
		return max;
	}
}
