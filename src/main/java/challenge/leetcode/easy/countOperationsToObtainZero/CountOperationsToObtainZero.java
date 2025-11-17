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

package challenge.leetcode.easy.countOperationsToObtainZero;

/**
 * @author Administrator
 * @Created 09/11/2025, 01:30 Sun 09 November 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Name
 * @Difficulty
 * @Tags
 **/
public class CountOperationsToObtainZero
{
	static void main(String[] args)
	{
		System.out.println("Answer       (0): " + countOperations(0, 10000));
		System.out.println("Answer GCD   (0): " + GCD(0, 10000));
		System.out.println("Answer       (1): " + countOperations(10, 10));
		System.out.println("Answer GCD   (1): " + GCD(10, 10));
		System.out.println("Answer       (3): " + countOperations(3, 2));
		System.out.println("Answer GCD   (3): " + GCD(3, 2));
		System.out.println("Answer      (10): " + countOperations(270, 300));
		System.out.println("Answer GCD  (10): " + GCD(270, 300));
		System.out.println("Answer      (11): " + countOperations(456, 2356));
		System.out.println("Answer GCD  (11): " + GCD(456, 2356));
		System.out.println("Answer      (32): " + countOperations(77772, 6786));
		System.out.println("Answer GCD  (32): " + GCD(77772, 6786));
		System.out.println("Answer      (37): " + countOperations(32556, 8899));
		System.out.println("Answer GCD  (37): " + GCD(32556, 8899));
		System.out.println("Answer      (43): " + countOperations(10360, 45754));
		System.out.println("Answer GCD  (43): " + GCD(10360, 45754));
		System.out.println("Answer      (50): " + countOperations(3451, 56786));
		System.out.println("Answer GCD  (50): " + GCD(3451, 56786));
		System.out.println("Answer     (100): " + countOperations(436, 34567));
		System.out.println("Answer GCD (100): " + GCD(436, 34567));
		System.out.println("Answer     (234): " + countOperations(234, 1));
		System.out.println("Answer GCD (234): " + GCD(234, 1));
//		System.out.println("Answer (): " + countOperations());
	}

	public static int countOperations(int a, int b)
	{
		if (a == b)
		{
			return 1;
		}
		if (a == 0 || b == 0)
		{
			return 0;
		}

		int operations = 0;
		while (a != 0 && b != 0)
		{
			if (a > b)
			{
				a = a - b;
			}
			else
			{
				b = b - a;
			}

			operations++;
		}

		return operations;
	}

	static int GCD(int a, int b)
	{
	    return (b == 0) ? (a) : GCD(b, a % b);
	}
}
