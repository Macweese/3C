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

package data.lexicography.words;

import java.util.stream.Stream;

/**
 * @author Administrator
 * @Created 15/09/2025, 11:59 Mon 15 September 2025
 * @Project 3C: Competitive Coding Challenges
 * <br>
 *
 * A source of words.<br>
 * Implementations may load from memory, files, databases, APIs, etc.<br>
 * Implementations should be side effect free; WordProvider will control lifecycle.
 **/
public interface WordSource
{
	/**
	 * Returns a finite stream of words. Should be repeatable OR documented if not.
	 * Implementations that are not naturally repeatable should pre-buffer.
	 * @return Stream of {@link Word}
	 */
	Stream<Word> stream();

	/**
	 * Human-readable name for logging/debugging.
	 * @return String name
	 */
	default String name()
	{
		return getClass().getSimpleName();
	}
}
