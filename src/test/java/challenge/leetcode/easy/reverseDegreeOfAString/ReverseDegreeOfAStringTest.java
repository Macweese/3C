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

package challenge.leetcode.easy.reverseDegreeOfAString;

import data.lexicography.words.Attribute;
import data.lexicography.words.CsvWordSource;
import data.lexicography.words.Word;
import data.lexicography.words.WordProvider;
import data.lexicography.words.WordType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 18:05 Tue 18 November 2025
 * @Project 3C: Competitive Coding Challenges
 **/
@DisplayName("3498. Reverse Degree of a String")
class ReverseDegreeOfAStringTest
{
	private static final Map<String, Integer> MAP = new HashMap<>();
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

	static
	{
		MAP.put("a",26);
		MAP.put("z",1);
		MAP.put("hot",64);
		MAP.put("swim",126);
		MAP.put("rest",105);
		MAP.put("deal",205);
		MAP.put("fits",110);
		MAP.put("fade",230);
		MAP.put("mirth",200);
		MAP.put("watch",268);
		MAP.put("based",304);
		MAP.put("scope",246);
		MAP.put("all",101);
		MAP.put("assure",267);
		MAP.put("suitor",216);
		MAP.put("picked",431);
		MAP.put("secure",325);
		MAP.put("able",209);
		MAP.put("explore",389);
		MAP.put("develop",394);
		MAP.put("adhered",555);
		MAP.put("predict",470);
		MAP.put("dyingly",337);
		MAP.put("abler",254);
		MAP.put("above",242);
		MAP.put("acute",230);
		MAP.put("alien",263);
		MAP.put("alive",240);
		MAP.put("alone",254);
		MAP.put("ample",257);
		MAP.put("angry",158);
		MAP.put("adoption",483);
		MAP.put("decrease",673);
		MAP.put("ocularly",443);
		MAP.put("interest",442);
		MAP.put("scrutiny",357);
		MAP.put("superior",450);
		MAP.put("distance",663);
		MAP.put("ablest",291);
		MAP.put("absent",295);
		MAP.put("absurd",307);
		MAP.put("active",324);
		MAP.put("actual",339);
		MAP.put("afraid",427);
		MAP.put("ampler",311);
		MAP.put("annual",335);
		MAP.put("criticism",674);
		MAP.put("predicted",853);
		MAP.put("heinously",459);
		MAP.put("indolence",849);
		MAP.put("assailant",699);
		MAP.put("adverse",422);
		MAP.put("alright",418);
		MAP.put("amateur",369);
		MAP.put("amplest",354);
		MAP.put("ancient",433);
		MAP.put("angrier",433);
		MAP.put("anxious",285);
		MAP.put("irritation",757);
		MAP.put("conviction",772);
		MAP.put("charitably",845);
		MAP.put("hesitation",781);
		MAP.put("strengthen",851);
		MAP.put("valleyward",831);
		MAP.put("spunkiness",707);
		MAP.put("abnormal",594);
		MAP.put("absenter",521);
		MAP.put("absolute",484);
		MAP.put("abstract",553);
		MAP.put("academic",756);
		MAP.put("accurate",596);
		MAP.put("adequate",589);
		MAP.put("adjacent",626);
		MAP.put("adverser",494);
		MAP.put("advisory",350);
		MAP.put("angriest",482);
		MAP.put("tediousness",814);
		MAP.put("inferiority",758);
		MAP.put("distributes",858);
		MAP.put("torturously",546);
		MAP.put("tentatively",826);
		MAP.put("perfectness",939);
		MAP.put("absentest",576);
		MAP.put("adversest",549);
		MAP.put("aesthetic",758);
		MAP.put("aggregate",828);
		MAP.put("ambiguous",541);
		MAP.put("ambitious",548);
		MAP.put("anonymous",438);
		MAP.put("threatening",1102);
		MAP.put("viviparously",821);
		MAP.put("additional",928);
		MAP.put("aggressive",785);
		MAP.put("intimidation",1215);
		MAP.put("acceptable",1068);
		MAP.put("accessible",1003);
		MAP.put("alternative",980);
		MAP.put("glorification",1471);
		MAP.put("regimentation",1349);
		MAP.put("quasilinearly",1305);
		MAP.put("agricultural",1092);
		MAP.put("administrative",1478);
		MAP.put("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",13013000);
		MAP.put("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz",500500);
	}

	@Test
	void reverseDegreeTest()
	{
		for (Map.Entry<String, Integer> entry : MAP.entrySet())
		{
			final String input = entry.getKey();
			final int expected = entry.getValue();
			final int actual = ReverseDegreeOfAString.reverseDegree(input);

			String message = String.format("Test failed for case:"
					+ "%n%10s : %s"
					+ "%n%10s : %s"
					+ "%n%10s : %s",
				"Input", input,
				"Expected", expected,
				"Actual", actual
			);

			assertEquals(expected, actual, message);
		}
	}

	private static void generateTests()
	{
		List<Word> wordList = wordProvider.query()
			.attributes(Attribute.STANDARD)
			.random()
			.lengthBetween(1, 1000)
			.list(50);

		for (int i = 0; i < 50; i++)
		{
			String word = wordList.get(i).word();
			System.out.printf("MAP.put(\"%s\",);%n", word);
		}
	}
}