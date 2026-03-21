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

package challenge.leetcode.hard.fancyNumber;

import challenge.leetcode.hard.fancySequence.Fancy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 00:07 Mon 16 March 2026
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("1622. Fancy Sequence")
class FancySequenceTest
{
	@Test
	void testFancyNumber()
	{
		Fancy fancy = new Fancy();
		fancy.append(2);		// fancy sequence: [2]
		fancy.addAll(3);	// fancy sequence: [2+3] -> [5]
		fancy.append(7);		// fancy sequence: [5, 7]
		fancy.multAll(2);	// fancy sequence: [5*2, 7*2] -> [10, 14]
		fancy.getIndex(0);	// return 10
		fancy.addAll(3);	// fancy sequence: [10+3, 14+3] -> [13, 17]
		fancy.append(10);		// fancy sequence: [13, 17, 10]
		fancy.multAll(2);	// fancy sequence: [13*2, 17*2, 10*2] -> [26, 34, 20]
		fancy.getIndex(0);	// return 26
		fancy.getIndex(1);	// return 34
		fancy.getIndex(2);	// return 20
	}
}