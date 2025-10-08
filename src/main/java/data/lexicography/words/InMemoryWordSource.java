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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @Created 15/09/2025, 12:44 Mon 15 September 2025
 * @Project 3C: Competitive Coding Challenges
 *
 * Simple in-memory source for bootstrapping or tests.
 **/
public class InMemoryWordSource implements WordSource
{
	private final List<Word> words;
	private final String name;

	public InMemoryWordSource(List<Word> words)
	{
		this.name = "Default " + System.nanoTime();
		this.words = List.copyOf(words);
	}

	public InMemoryWordSource(String... words)
	{
		this.name = "Default " + System.nanoTime();
		this.words = Arrays.stream(words).map(Word::new).toList();
	}

	public InMemoryWordSource(Word... words)
	{
		this.name = "Default " + System.nanoTime();
		this.words = Arrays.asList(words);
	}

	public InMemoryWordSource(String name, List<Word> words)
	{
		this.name = name;
		this.words = List.copyOf(words);
	}

	@Override
	public Stream<Word> stream()
	{
		return words.stream();
	}

	@Override
	public String name()
	{
		return name;
	}
}
