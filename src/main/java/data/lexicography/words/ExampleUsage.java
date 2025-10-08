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

import java.util.List;

/**
 * @author Administrator
 * @Created 15/09/2025, 13:52 Mon 15 September 2025
 * @Project 3C: Competitive Coding Challenges
 *
 * Just testing stuff
 *
 */
public class ExampleUsage
{
	public static void main(String[] args)
	{
		WordProvider provider = WordProvider.builder()
			.addSource(new InMemoryWordSource(List.of(
				new Word("café", Attribute.DIACRITIC, WordType.NOUN),
				new Word("co-op", Attribute.PUNCTUATION_MARK, WordType.NOUN),
				new Word("mañana", Attribute.DIACRITIC, WordType.NOUN),
				Word.of("run", WordType.VERB),
				new Word("fast", Attribute.STANDARD, WordType.ADVERB),
				new Word("greenish-blue", Attribute.PUNCTUATION_MARK, WordType.ADJECTIVE),
				new Word("über-cool", Attribute.BOTH, WordType.ADJECTIVE),
				Word.of("foo", WordType.UNKNOWN),
				Word.of("bar", WordType.UNKNOWN),
				Word.of("fizzle", WordType.VERB),
				Word.of("fix", WordType.VERB),
				Word.of("fake", WordType.VERB, WordType.ADJECTIVE),
				Word.of("friend", WordType.NOUN),
				Word.of("fantasy", WordType.NOUN),
				Word.of("FANTASTIC", WordType.ADJECTIVE),
				Word.of("fine", WordType.ADJECTIVE),
				Word.of("feather", WordType.NOUN, WordType.VERB),
				Word.of("friendly", WordType.ADJECTIVE),
				Word.of("fiend", WordType.NOUN),
				Word.of("face", WordType.NOUN),
				Word.of("face-mask", WordType.NOUN),
				Word.of("facilitate", WordType.VERB),
				Word.of("frown", WordType.NOUN),
				Word.of("fiendish", WordType.ADJECTIVE),
				Word.of("fall", WordType.NOUN, WordType.VERB),
				Word.of("follow", WordType.VERB),
				Word.of("follower", WordType.NOUN),
				Word.of("frog", WordType.NOUN),
				Word.of("fan", WordType.NOUN, WordType.VERB),
				Word.of("fat", WordType.ADJECTIVE),
				Word.of("fatten", WordType.VERB),
				Word.of("far", WordType.ADJECTIVE),
				Word.of("full", WordType.ADJECTIVE),
				Word.of("fulfill", WordType.VERB),
				Word.of("facade", WordType.NOUN),
				Word.of("façade", WordType.NOUN),
				Word.of("freak", WordType.NOUN)
			)))
			.build();

		WordProvider verbProvider = WordProvider.builder()
			.addSource(new CsvWordSource(WordType.VERB.source))
			.build();

		verbProvider.query()
			.startsWith("re")
			.list(5)
			.forEach(word -> System.out.println(word.word()));

		System.out.println("Any words starting with \"f\"");
		List<Word> words = provider.query()
			.types(WordType.NOUN)
			.startsWith("f")
			.list();
		words.forEach(word -> System.out.println(word.word()));
		System.out.println("-----");

		System.exit(1);
		// 1. 100 random nouns
		List<Word> randomNouns = provider.query()
			.types(WordType.NOUN)
			.random()
			.limit(100)
			.list();
		System.out.println("Random nouns: " + randomNouns);

		// 2. First 25 verbs starting with 'f'
		List<Word> verbsStartingF = provider.query()
			.types(WordType.VERB)
			.startsWith("f")
			.limit(25)
			.list();
		System.out.println("Verbs starting with f: " + verbsStartingF);

		// 3. 119 of any words (random)
		List<Word> anyRandom = provider.query()
			.random()
			.limit(119)
			.list();
		System.out.println("Random any (size=" + anyRandom.size() + "): " + anyRandom);

		// 4. Adjectives that have punctuation
		List<Word> punctAdj = provider.query()
			.types(WordType.ADJECTIVE)
			.attributes(Attribute.PUNCTUATION_MARK, Attribute.BOTH)
			.list();
		System.out.println("Adjectives w/ punctuation: " + punctAdj);

		// 5. Words with diacritics
		List<Word> diacritics = provider.query()
			.attributes(Attribute.DIACRITIC, Attribute.BOTH)
			.list();
		System.out.println("Diacritic words: " + diacritics);
	}
}
