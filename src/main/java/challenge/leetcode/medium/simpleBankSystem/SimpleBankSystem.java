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

/**
 * @author Administrator
 * @Created 26/10/2025, 06:36 Sun 26 October 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class SimpleBankSystem
{
}

class Bank
{
	volatile long[] accounts;

	public Bank(long[] balance)
	{
		this.accounts = balance;
	}

	public synchronized boolean transfer(int accountSource, int accountDest, long amount)
	{
		if (!accountExists(accountSource))
		{
			System.out.printf("Transfer error: account sender {%s} does not exist.%n", accountSource);
			return false;
		}
		if (!accountExists(accountDest))
		{
			System.out.printf("Transfer error: account recipient {%s} does not exist.%n", accountDest);
			return false;
		}
		if (accountSource == accountDest)
		{
			System.out.printf("Transfer error - invalid transfer: account sender {%s} and account recipient {%s} are identical.%n", accountSource, accountDest);
			return false;
		}
		if (amount < 0)
		{
			System.out.printf("Transfer error - invalid amount: account source={%s}, balance={%s}, transfer amount={%s}.%n", accountSource, accounts[accountSource - 1], amount);
			return false;
		}
		if (accounts[accountSource - 1] < 0 || accounts[accountSource - 1] < amount)
		{
			System.out.printf("Transfer error - insufficient funds: account source={%s}, balance={%s}, transfer amount={%s}.%n", accountSource, accounts[accountSource - 1], amount);
			return false;
		}

		accounts[accountSource - 1] -= amount;
		accounts[accountDest - 1] += amount;
		return true;
	}

	public synchronized boolean deposit(int account, long amount)
	{
		if (!accountExists(account))
		{
			System.out.printf("Deposit error: account {%s} does not exist.%n", account);
			return false;
		}

		accounts[account - 1] += amount;
		return true;
	}

	public synchronized boolean withdraw(int account, long amount)
	{
		if (!accountExists(account))
		{
			System.out.printf("Withdraw error: account {%s} does not exist.%n", account);
			return false;
		}

		if (amount < 0)
		{
			System.out.printf("Withdraw error - invalid amount: account={%s}, balance={%s}, transfer amount={%s}.%n", account, accounts[account - 1], amount);
			return false;
		}

		if (accounts[account - 1] < 0 || accounts[account - 1] < amount)
		{
			System.out.printf("Withdraw error - insufficient funds: account={%s}, balance={%s}.%n", account, accounts[account - 1]);
			return false;
		}

		accounts[account - 1] -= amount;
		return true;
	}

	private synchronized boolean accountExists(int accountId)
	{
		return accountId > 0 && accountId <= accounts.length;
	}
}
