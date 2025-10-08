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

/**
 * @author Administrator
 * @Created 15/09/2025, 11:58 Mon 15 September 2025
 * @Project 3C: Competitive Coding Challenges
 **/
public enum WordType
{
	ANY(Source.ANY),
	ADJECTIVE(Source.ADJECTIVE),
	ADVERB(Source.ADVERB),
	ARTICLE(Source.ARTICLE),
	CONJUNCTION(Source.CONJUNCTION),
	INTERJECTION(Source.INTERJECTION),
	NOUN(Source.NOUN),
	PHRASE(Source.PHRASE),
	PREPOSITION(Source.PREPOSITION),
	PRONOUN(Source.PRONOUN),
	VERB(Source.VERB),
	UNKNOWN(Source.UNKNOWN);

	public final String source;

	WordType()
	{
		this.source = null;
	}

	WordType(String source)
	{
		this.source = source;
	}

	public static WordType fromTag(String raw)
	{
		if (raw == null)
		{
			return ANY;
		}

		String n = raw.trim().toUpperCase();
		for (WordType wt : values())
		{
			if (wt.name().equals(n))
			{
				return wt;
			}
		}
		return ANY;
	}
}

class Source
{
	static final String ANY = null;
	static final String ADJECTIVE = "/data/lexicography/words/adjectives.csv";
	static final String ADVERB = "/data/lexicography/words/adverbs.csv";
	static final String ARTICLE = null;
	static final String CONJUNCTION = "/data/lexicography/words/conjunctions.csv";
	static final String INTERJECTION = "/data/lexicography/words/interjections.csv";
	static final String NOUN = "/data/lexicography/words/nouns.csv";
	static final String PHRASE = null;
	static final String PREPOSITION = "/data/lexicography/words/prepositions.csv";
	static final String PRONOUN = "/data/lexicography/words/pronouns.csv";
	static final String VERB = "/data/lexicography/words/verbs.csv";
	static final String UNKNOWN = null;
}
