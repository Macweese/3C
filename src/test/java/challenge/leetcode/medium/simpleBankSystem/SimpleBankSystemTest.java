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

package challenge.leetcode.medium.simpleBankSystem;

import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 00:46 Tue 18 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("2043. Simple Bank System")
class SimpleBankSystemTest
{

	@Test
	@DisplayName("Test Bank System")
	void simpleBankSystemTest()
	{
		Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
		assertArrayEquals(new long[]{10, 100, 20, 50, 30}, bank.accounts);

		bank.withdraw(3, 10);
		assertArrayEquals(new long[]{10, 100, 10, 50, 30}, bank.accounts);

		bank.transfer(5, 1, 20);
		assertArrayEquals(new long[]{30, 100, 10, 50, 10}, bank.accounts);

		bank.deposit(5, 20);
		assertArrayEquals(new long[]{30, 100, 10, 50, 30}, bank.accounts);

		assertFalse(bank.transfer(3, 4, 15));

		bank.withdraw(10, 50);
		assertArrayEquals(new long[]{30, 100, 10, 50, 30}, bank.accounts);

		assertFalse(bank.withdraw(1, Long.MAX_VALUE));
		assertFalse(bank.transfer(3, 2, Long.MAX_VALUE));
	}

	@Test
	@DisplayName("Test Bank Transfer")
	void bankTransferTest()
	{
		Bank bank = createBank();
		assertFalse(bank.transfer(1, 2, Long.MAX_VALUE));
		assertFalse(bank.transfer(1, 1, 1));
		assertFalse(bank.transfer(1, 2, -100));
		assertTrue(bank.accounts[1] > 0 && bank.accounts.length > 1 && bank.transfer(1, 2, 1));

		bank = new Bank(new long[]{100, 100, 100, 100, 0});
		assertEquals(100, bank.accounts[1]);
		assertEquals(0, bank.accounts[4]);

		assertTrue(bank.transfer(1, 5, 100));
		assertEquals(0, bank.accounts[0]);
		assertEquals(100, bank.accounts[4]);

		assertTrue(bank.transfer(2, 5, 50));
		assertEquals(50, bank.accounts[1]);
		assertEquals(150, bank.accounts[4]);

		assertTrue(bank.transfer(3, 5, 75));
		assertEquals(25, bank.accounts[2]);
		assertEquals(225, bank.accounts[4]);

		assertTrue(bank.transfer(5, 2, 200));
		assertEquals(25, bank.accounts[4]);
		assertEquals(250, bank.accounts[1]);

		assertTrue(bank.transfer(2, 3, 250));
		assertEquals(0, bank.accounts[1]);
		assertEquals(275, bank.accounts[2]);

		assertTrue(bank.transfer(3, 5, 275));
		assertEquals(0, bank.accounts[2]);
		assertEquals(300, bank.accounts[4]);
	}

	@Test
	@DisplayName("Test Bank Withdraw")
	void bankWithdrawTest()
	{
		Bank bank = createBank();
		assertFalse(bank.withdraw(1, Long.MAX_VALUE));
		assertTrue(bank.accounts[1] > 0 && bank.withdraw(1, 1));
		assertFalse(bank.withdraw(1, -100));

		long balance = bank.accounts[0];
		assertTrue(bank.withdraw(1, balance));
		assertEquals(0, bank.accounts[0]);
	}

	private Bank createBank()
	{
		int accounts = ThreadLocalRandom.current().nextInt((int) 1e5) + 1;
		long[] accountBalances = new long[accounts];
		for (int i = 0; i < accounts; i++)
		{
			accountBalances[i] = ThreadLocalRandom.current().nextLong((long) 1e12 + 1);
		}
		return new Bank(accountBalances);
	}
}