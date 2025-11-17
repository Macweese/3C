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
package challenge.leetcode.easy.sqrt;

import challenge.leetcode.easy.sqrt.Sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("69. Sqrt(x)")
class SqrtTest
{
	@Test
	public void findRootSqrt()
	{
		assertEquals(0, Sqrt.sqrt(0));
		assertEquals(1, Sqrt.sqrt(1));
		assertEquals(1, Sqrt.sqrt(2));
		assertEquals(1, Sqrt.sqrt(3));
		assertEquals(2, Sqrt.sqrt(4));
		assertEquals(2, Sqrt.sqrt(5));
		assertEquals(2, Sqrt.sqrt(5));
		assertEquals(2, Sqrt.sqrt(8));
		assertEquals(3, Sqrt.sqrt(9));
		assertEquals(3, Sqrt.sqrt(11));
		assertEquals(3, Sqrt.sqrt(15));
		assertEquals(5, Sqrt.sqrt(35));
		assertEquals(6, Sqrt.sqrt(36));
		assertEquals(9, Sqrt.sqrt(99));
		assertEquals(6817, Sqrt.sqrt(46471489));
		assertEquals(32951, Sqrt.sqrt(1085817232));
		assertEquals(46339, Sqrt.sqrt(2147395599));
	}

	@Test
	public void findRootTest()
	{
		assertEquals(0, Sqrt.test(0));
		assertEquals(1, Sqrt.test(1));
		assertEquals(1, Sqrt.test(2));
		assertEquals(1, Sqrt.test(3));
		assertEquals(2, Sqrt.test(4));
		assertEquals(2, Sqrt.test(5));
		assertEquals(2, Sqrt.test(5));
		assertEquals(2, Sqrt.test(8));
		assertEquals(3, Sqrt.test(9));
		assertEquals(3, Sqrt.test(11));
		assertEquals(3, Sqrt.test(15));
		assertEquals(5, Sqrt.test(35));
		assertEquals(6, Sqrt.test(36));
		assertEquals(9, Sqrt.test(99));
		assertEquals(6817, Sqrt.test(46471489));
		assertEquals(32951, Sqrt.test(1085817232));
		assertEquals(46339, Sqrt.test(2147395599));
	}

	@Test
	public void findRootCheat()
	{
		assertEquals(0, Sqrt.cheat(0));
		assertEquals(1, Sqrt.cheat(1));
		assertEquals(1, Sqrt.cheat(2));
		assertEquals(1, Sqrt.cheat(3));
		assertEquals(2, Sqrt.cheat(4));
		assertEquals(2, Sqrt.cheat(5));
		assertEquals(2, Sqrt.cheat(5));
		assertEquals(2, Sqrt.cheat(8));
		assertEquals(3, Sqrt.cheat(9));
		assertEquals(3, Sqrt.cheat(11));
		assertEquals(3, Sqrt.cheat(15));
		assertEquals(5, Sqrt.cheat(35));
		assertEquals(6, Sqrt.cheat(36));
		assertEquals(9, Sqrt.cheat(99));
		assertEquals(6817, Sqrt.cheat(46471489));
		assertEquals(32951, Sqrt.cheat(1085817232));
		assertEquals(46339, Sqrt.cheat(2147395599));
	}

	@Test
	public void findRootGuyWoo()
	{
		assertEquals(0, Sqrt.findRoot(0));
		assertEquals(1, Sqrt.findRoot(1));
		assertEquals(1, Sqrt.findRoot(2));
		assertEquals(1, Sqrt.findRoot(3));
		assertEquals(2, Sqrt.findRoot(4));
		assertEquals(2, Sqrt.findRoot(5));
		assertEquals(2, Sqrt.findRoot(5));
		assertEquals(2, Sqrt.findRoot(8));
		assertEquals(3, Sqrt.findRoot(9));
		assertEquals(3, Sqrt.findRoot(11));
		assertEquals(3, Sqrt.findRoot(15));
		assertEquals(5, Sqrt.findRoot(35));
		assertEquals(6, Sqrt.findRoot(36));
		assertEquals(9, Sqrt.findRoot(99));
		assertEquals(6817, Sqrt.findRoot(46471489));
		assertEquals(32951, Sqrt.findRoot(1085817232));
		assertEquals(46339, Sqrt.findRoot(2147395599));
	}
}