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

import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * @Created 15/09/2025, 11:28 Mon 15 September 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public record Word(String word, Attribute attribute, HashSet<WordType> types)
{
	private static final Pattern PUNCT_PATTERN = Pattern.compile("[-'’‐‑–—\\p{Punct}]");

	public Word(String word)
	{
		this(word, inferAttribute(word), WordType.UNKNOWN);
	}

	public Word(String word, WordType... types)
	{
		this(word, inferAttribute(word), new HashSet<>(Arrays.asList(types)));
	}

	public Word(String word, Attribute attribute, WordType... types)
	{
		this(word, attribute, new HashSet<>(Arrays.asList(types)));
	}

	public Word
	{
		Objects.requireNonNull(word, "word");
		Objects.requireNonNull(types, "type");
		Objects.requireNonNull(attribute, "attribute");
	}

	public int length()
	{
		return word.length();
	}

	public Attribute attribute()
	{
		return attribute;
	}

	/**
	 * Convenience accessor returning a safe copy (array is already final here but defensive clone can be used if desired).
	 */
	public WordType[] typesAsArray()
	{
		return types.toArray(WordType[]::new); // safe because record component is final; callers should treat as read-only
	}

	public boolean hasType(WordType t)
	{
		for (WordType wt : types)
		{
			if (wt == t)
			{
				return true;
			}
		}
		return false;
	}

	public static Word of(String word)
	{
		return new Word(word, inferAttribute(word), WordType.UNKNOWN);
	}

	public static Word of(String word, WordType type)
	{
		return new Word(word, inferAttribute(word), type);
	}

	public static Word of(String word, WordType... type)
	{
		return of(word, inferAttribute(word), type);
	}

	public static Word of(String word, Attribute attribute, WordType... type)
	{
		return new Word(word, attribute, type);
	}

	private static Attribute inferAttribute(String w)
	{
		boolean punctuation = PUNCT_PATTERN.matcher(w).find();
		boolean diacritic = hasDiacritic(w);

		if (punctuation && diacritic)
		{
			return Attribute.BOTH;
		}
		if (punctuation)
		{
			return Attribute.PUNCTUATION_MARK;
		}
		if (diacritic)
		{
			return Attribute.DIACRITIC;
		}

		return Attribute.STANDARD;
	}

	private static boolean hasDiacritic(String w)
	{
		String norm = Normalizer.normalize(w, Normalizer.Form.NFD);

		for (int i = 0; i < norm.length(); i++)
		{
			if (Character.getType(norm.charAt(i)) == Character.NON_SPACING_MARK)
			{
				return true;
			}
		}

		return false;
	}
}
