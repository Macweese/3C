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
package challenge.leetcode.medium.new21Game;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("837. New 21 Game")
class New21GameTest
{
	private static final Map<Triple<Integer, Integer, Integer>, Double> MAP = new HashMap<>();

	static
	{
		MAP.put(new ImmutableTriple<>(10, 1, 10), 1.0);
		MAP.put(new ImmutableTriple<>(6, 1, 10), 0.6);
		MAP.put(new ImmutableTriple<>(21, 17, 10), 0.73278);
	}

	@Test
	void new21Game()
	{
		for (int i = 0; i < 651; i++)
		{
			int n = ThreadLocalRandom.current().nextInt(21) + 1;
			int k = ThreadLocalRandom.current().nextInt(21) + 1;
		}
	}
}