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

package challenge.leetcode.easy.maximumNumberOfWordsYouCanType;

import challenge.leetcode.easy.maximumNumberOfWordsYouCanType.MaximumNumberOfWordsYouCanType;
import data.lexicography.words.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

@DisplayName("1935. Maximum Number of Words You Can Type")
class MaximumNumberOfWordsYouCanTypeTest
{
	private static List<ImmutableTriple<String, String, Integer>> triples = new ArrayList<>();

	private static final WordProvider wordProvider = WordProvider.builder()
			.addSource(new CsvWordSource(WordType.ADJECTIVE.source))
			.addSource(new CsvWordSource(WordType.ADVERB.source))
			.addSource(new CsvWordSource(WordType.CONJUNCTION.source))
			.addSource(new CsvWordSource(WordType.INTERJECTION.source))
			.addSource(new CsvWordSource(WordType.NOUN.source))
			.addSource(new CsvWordSource(WordType.PREPOSITION.source))
			.addSource(new CsvWordSource(WordType.PRONOUN.source))
			.addSource(new CsvWordSource(WordType.VERB.source))
			.build();

	@Test
	void canBeTypedWords()
	{
		generateTest(1);

		for (ImmutableTriple<String, String, Integer> triple : triples)
		{
			final String text = triple.getLeft();
			final String letters = triple.getMiddle();
			final int expected = triple.getRight();
			final int actual = MaximumNumberOfWordsYouCanType.canBeTypedWords(text, letters);

			String message = String.format("Test failed for case:"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s : %s"
					+ "\n%10s",
				"Text", text,
				"Letters", letters,
				"Expected", expected,
				"Actual", actual,
				"");

			assertEquals(expected, actual, message);
		}
	}

	private static void generateTest(int quantity)
	{
		for (int i = 0; i < quantity; ++i)
		{
			generateTest();
		}
	}

	private static void generateTest()
	{
		Random r = new Random();
		StringBuilder wordBuilder = new StringBuilder();
		StringBuilder letterBuilder = new StringBuilder();
		Consumer<Word> addToText = (word ->
			wordBuilder.append(word.word().toLowerCase()).append(" ")
		);

		int textSize = r.nextInt(1001) + 1;
//		int wordCount = 0;
//		System.out.println("Text length: " + textSize);
		while (wordBuilder.length() < textSize)
		{
			// Don't bother,
			// the randomness of the wordQuery will
			// cause this to loop unnecessarily much
			if ((textSize - wordBuilder.length()) < 2)
			{
				break;
			}

			wordProvider.query()
				.attributes(Attribute.STANDARD)
				.random()
				.lengthBetween(1, textSize - wordBuilder.length())
				.any()
				.ifPresent(addToText);
//			System.out.println("Word count: " + ++wordCount);
//			System.out.println("Remaining text length: " + (textSize - wordBuilder.length()));
		}
		wordBuilder.delete(wordBuilder.length() - 1, wordBuilder.length());
//		System.out.println(wordBuilder);

		int letterCount = r.nextInt(26);
		for (int i = 0; i < letterCount; ++i)
		{
			int c = r.nextInt(26);
			if (letterBuilder.toString().indexOf((c + 'a')) != -1)
			{
				--i;
				continue;
			}
			letterBuilder.append((char) (c + 'a'));
		}

		triples.add(new ImmutableTriple<>(wordBuilder.toString(), letterBuilder.toString(), validate(wordBuilder.toString(), letterBuilder.toString())));
	}

	private static int validate(String text, String brokenLetters)
	{
		boolean[] broken = new boolean[0x80];
		for (char c : brokenLetters.toCharArray())
		{
			broken[c] = true;
		}

		int count = 0;
		boolean word = true;
		text = text + " ";
		for (char c : text.toCharArray())
		{
			word &= (!broken[c]);
			boolean isSpace = (c) == ' ';
			count += (word && isSpace) ? 1 : 0;
			word |= isSpace;
		}
		return count;
	}
}