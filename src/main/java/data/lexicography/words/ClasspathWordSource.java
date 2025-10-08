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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @Created 15/09/2025, 12:47 Mon 15 September 2025
 * @Project 3C: Competitive Coding Challenges
 * <p>
 * Loads a plain text resource from the classpath where each non-blank line is:<br>
 * word<br>
 * or optionally:<br>
 * word,types<br>
 * <p>
 * Line format: <br>
 * &emsp;<code>word</code> <br>
 * &emsp;<code>word,types</code> <br>
 * &emsp;<code>word,type1|type2</code> <br>
 * &emsp;<code>word,type1|type2,ATTRIBUTE</code>   (ATTRIBUTE optional; if absent it will be inferred) <br>
 * <br>
 * If ATTRIBUTE present it must match an Attribute constant (<code>STANDARD, DIACRITIC, PUNCTUATION_MARK, BOTH, ANY</code>). <br>
 * If not present, attribute is inferred from characters. <br>
 * </p>
 */
public class ClasspathWordSource implements WordSource
{
	private final String resourcePath;
	private final List<Word> cached;

	public ClasspathWordSource(String resourcePath, WordType defaultType)
	{
		this.resourcePath = resourcePath;
		this.cached = load(resourcePath, defaultType);
	}

	private List<Word> load(String path, WordType defaultType)
	{
		List<Word> list = new ArrayList<>();
		InputStream in = getClass().getResourceAsStream(path);
		if (in == null)
		{
			throw new IllegalArgumentException("Resource not found: " + path);
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_16)))
		{
			br.lines()
				.map(String::trim)
				.filter(line -> !line.isEmpty() && !line.startsWith("#"))
				.forEach(line -> {
					String[] parts = line.split(",", 3);
					String rawWord = parts[0];
					WordType[] types;
					Attribute attr;

					if (parts.length == 1)
					{
						types = new WordType[]{defaultType};
						attr = inferAttribute(rawWord);
					}
					else if (parts.length == 2)
					{
						types = parseTypes(parts[1]);
						attr = inferAttribute(rawWord);
					}
					else
					{
						types = parseTypes(parts[1]);
						attr = parseAttributeOrInfer(rawWord, parts[2]);
					}

					list.add(new Word(rawWord, attr, types));
				});
		}
		catch (Exception e)
		{
			throw new RuntimeException("Failed to read words from " + path, e);
		}

		return List.copyOf(list);
	}

	private WordType[] parseTypes(String raw)
	{
		String[] segments = raw.split("\\|");
		WordType[] out = new WordType[segments.length];

		for (int i = 0; i < segments.length; i++)
		{
			out[i] = WordType.fromTag(segments[i]);
		}

		return out;
	}

	private Attribute parseAttributeOrInfer(String w, String raw)
	{
		String r = raw.trim().toUpperCase();
		try
		{
			return Attribute.valueOf(r);
		}
		catch (IllegalArgumentException ex)
		{
			return inferAttribute(w);
		}
	}

	private static final Pattern PUNCT_PATTERN = Pattern.compile("[-'’‐‑–—\\p{Punct}]");

	private Attribute inferAttribute(String w)
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

	private boolean hasDiacritic(String w)
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

	@Override
	public Stream<Word> stream()
	{
		return cached.stream();
	}

	@Override
	public String name()
	{
		return "ClasspathWordSource(" + resourcePath + ")";
	}
}