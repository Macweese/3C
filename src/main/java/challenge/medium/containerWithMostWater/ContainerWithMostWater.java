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

package challenge.medium.containerWithMostWater;

/**
 * @author Administrator
 * @Created 04/10/2025, 08:46 Sat 04 October 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 **/
public class ContainerWithMostWater
{
	static void main(String[] args)
	{

	}

	public static int maxArea(int[] height)
	{
		int left = 0;
		int right = height.length - 1;
		int container = 0;

		while (left < right)
		{
			int h = Math.min(height[left], height[right]);
			container = Math.max(container, h * (right - left));

			if (height[left] < height[right])
			{
				left++;
			}
			else
			{
				right--;
			}
		}

		return container;
	}
}
