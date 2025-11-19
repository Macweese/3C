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

package challenge.leetcode.easy.validWord;

/**
 * @author Administrator
 * @Created 22/09/2025, 20:21 Mon 22 September 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public class ValidWord
{
	public static boolean isValid(String s)
	{
		if (s.length() < 3)
		{
			return false;
		}

		boolean hasVowel = false;
		boolean hasConsonant = false;

		for (int i = 0; i < s.length(); i++)
		{
			int c = s.charAt(i);

			if (!Character.isLetterOrDigit(c))
			{
				return false;
			}

			if (isVowel((char) c))
			{
				hasVowel = true;
			}
			else if (Character.isLetter(c))
			{
				hasConsonant = true;
			}
		}

		return hasVowel && hasConsonant;
	}

	private static boolean isVowel(char c)
	{
		c = Character.toLowerCase(c);
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
}
