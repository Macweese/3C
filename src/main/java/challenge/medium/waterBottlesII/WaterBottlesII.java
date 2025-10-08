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

package challenge.medium.waterBottlesII;

/**
 * @author Administrator
 * @Created 02/10/2025, 06:46 Thu 02 October 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 **/
public class WaterBottlesII
{
	static void main(String[] args)
	{
		System.out.println(maxBottlesDrunk(13, 6));
		System.out.println(maxBottlesDrunk(10, 3));
	}

	public static int maxBottlesDrunk(int numBottles, int numExchange)
	{
		int full = 0;
		int empty = numBottles;
		int rate = numExchange;
		int consumed = numBottles;


		while ((empty + full) >= rate)
		{
			if (full > 0)
			{
				consumed += full;
				empty += full;
				full -= full;
			}

			empty -= rate;
			rate++;
			full++;
		}

		return consumed + full;

//		return consumed(numBottles, numExchange, 0);
	}

	public static int consumed(int bottles, int exchangeRate, int consumed)
	{
		if (bottles < exchangeRate)
		{
			return consumed;
		}

		return consumed(bottles - (bottles % exchangeRate), exchangeRate + 1, consumed + bottles);
	}
}
