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

package challenge.leetcode.easy.oneBitAndTwoBitCharacters;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 01:39 Tue 18 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("717. 1-bit and 2-bit Characters")
class OneBitAndTwoBitCharactersTest
{
	@Test
	void isOneBitCharacterTest()
	{
		assertTrue(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{0}));
		assertTrue(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{1,0,0}));
		assertTrue(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{1,1,0}));
		assertFalse(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{1,0}));
		assertFalse(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{0,1,0}));
		assertFalse(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{1,0,0,1,0}));
		assertFalse(OneBitAndTwoBitCharacters.isOneBitCharacter(new int[]{1,1,1,0}));
	}
}