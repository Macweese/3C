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
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @Created 15/09/2025, 12:50 Mon 15 September 2025
 * @Project 3C: Competitive Coding Challenges
 * <p>
 * Example CSV source (columns configurable).<br>
 * Expected header line contains at least: word,types<br>
 * Extra columns become attributes.<br>
 * <br>
 * CSV header must include: word<br>
 * Optional: types (can be pipe-separated list), attribute<br>
 * Additional columns ignored (or could be used later).<br>
 */
public class CsvWordSource implements WordSource
{
	private final String resourcePath;
	private final List<Word> cached;

	public CsvWordSource(String resourcePath)
	{
		this.resourcePath = resourcePath;
		this.cached = load(resourcePath);
	}

	public CsvWordSource(WordType wordType)
	{
		this.resourcePath = wordType.source;
		this.cached = load(resourcePath);
	}

	private List<Word> load(String path)
	{
		InputStream in = getClass().getResourceAsStream(path);
		if (in == null)
		{
			throw new IllegalArgumentException("Resource not found: " + path);
		}
		List<Word> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(in)))
		{
			String header = br.readLine();
			if (header == null)
			{
				return List.of();
			}
			String[] cols = header.split(",");
			Map<String, Integer> idx = new HashMap<>();
			for (int i = 0; i < cols.length; i++)
			{
				idx.put(cols[i].trim().toLowerCase(), i);
			}
			Integer wIdx = idx.get("word");
			if (wIdx == null)
			{
				throw new IllegalArgumentException("CSV must contain 'word' column");
			}
			Integer typeIdx = idx.get("type");
			Integer attrIdx = idx.get("attribute");
			String line;
			while ((line = br.readLine()) != null)
			{
				String[] parts = line.split(",", -1);
				if (wIdx >= parts.length)
				{
					continue;
				}
				String w = parts[wIdx].trim();
				if (w.isEmpty())
				{
					continue;
				}

				WordType[] types;
				if (typeIdx != null && typeIdx < parts.length && !parts[typeIdx].isBlank())
				{
					types = parseTypes(parts[typeIdx]);
				}
				else
				{
					types = new WordType[]{WordType.UNKNOWN};
				}

				Attribute attribute;
				if (attrIdx != null && attrIdx < parts.length && !parts[attrIdx].isBlank())
				{
					attribute = parseAttributeOrInfer(w, parts[attrIdx]);
				}
				else
				{
					attribute = inferAttribute(w);
				}

				list.add(new Word(w, attribute, types));
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("Failed to load CSV words from " + path, e);
		}
		return List.copyOf(list);
	}

	private WordType[] parseTypes(String raw)
	{
		String[] segs = raw.split("\\|");
		WordType[] out = new WordType[segs.length];
		for (int i = 0; i < segs.length; i++)
		{
			out[i] = WordType.fromTag(segs[i]);
		}
		return out;
	}

	private Attribute parseAttributeOrInfer(String w, String raw)
	{
		try
		{
			return Attribute.valueOf(raw.trim().toUpperCase());
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
		return "CsvWordSource(" + resourcePath + ")";
	}
}