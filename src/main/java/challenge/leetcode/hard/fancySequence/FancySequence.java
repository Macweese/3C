/*
 *
 *     Copyright (C) 2026 Macweese <https://www.github.com/Macweese>
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

package challenge.leetcode.hard.fancySequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Created 07:05 Sun 15 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
public class FancySequence
{

}

public class Fancy
{
	private static final int MOD = 1000000007;
	private List<Long> seq;
	private long addVal;
	private long mulVal;

	public Fancy()
	{
		seq = new ArrayList<>();
		addVal = 0;
		mulVal = 1;
	}

	public void append(int val)
	{
		long invMul = modInverse(mulVal, MOD);
		long actualVal = ((val - addVal) % MOD + MOD) % MOD;
		actualVal = (actualVal * invMul) % MOD;
		seq.add(actualVal);
	}

	public void addAll(int inc)
	{
		addVal = (addVal + inc) % MOD;
	}

	public void multAll(int m)
	{
		mulVal = (mulVal * m) % MOD;
		addVal = (addVal * m) % MOD;
	}

	public int getIndex(int idx)
	{
		if (idx >= seq.size())
		{
			return -1;
		}
		long val = seq.get(idx);
		val = (val * mulVal) % MOD;
		val = (val + addVal) % MOD;
		return (int) val;
	}

	private long modInverse(long a, long m)
	{
		return power(a, m - 2, m);
	}

	private long power(long base, long exp, long mod)
	{
		long result = 1;
		base %= mod;
		while (exp > 0)
		{
			if ((exp & 1) == 1)
			{
				result = (result * base) % mod;
			}
			base = (base * base) % mod;
			exp >>= 1;
		}
		return result;
	}
}