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
package challenge.leetcode.easy.findIndexFirstOccurrenceString;

import challenge.leetcode.easy.findIndexFirstOccurrenceString.FindIndexFirstOccuranceString;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Administrator
 * @Created 04/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem
 * @Difficulty
 * @Tags
 * @link
 * @Description
 **/
@DisplayName("28. Find the Index of the First Occurrence in a String")
class FindIndexFirstOccuranceStringTest
{

	static final Map<String, String> MAP = Map.of(
		"sadbutsad", "sad",
		"leetcode", "leeto",
		"aaa", "aaaa",
		"monkey", "key",
		"bbbbbbbb", "b",
		"accidentally", "dental",
		"hgeriludvnbedoberihbipniourvbeprhgowrpoeruhvreisudbvpswreiubgiesdylvhosedhbvkjudyg8uwsrjivlbeyvgorshfvbsuyrfvrsugbwoalhybvkesuveoslgveirufhvbrgorfsjutsdrfjytgskdjrgkljfhjgjkglfgjuflgibusjvhnhgddcyhrgddjyjgdcgfhgnjyrdgxjyjytdhtdvhytydcdjtryddjutrdkdsrwidwytwwdwqydrcwujcytdesdryrehdyjttrddjuygffkcubfvkuuuu", "jyjy",
		"muumin", "in",
		"owituowrhgwrpejsdfbgviegdyhgroishgfnvwrjugbhvesolrguhoebgr", "socc"
	);

	static final Map<String, Integer> ANSWERS = Map.of(
		"sadbutsad", 0,
		"leetcode", -1,
		"aaa", -1,
		"monkey", 3,
		"bbbbbbbb", 0,
		"accidentally", 4,
		"hgeriludvnbedoberihbipniourvbeprhgowrpoeruhvreisudbvpswreiubgiesdylvhosedhbvkjudyg8uwsrjivlbeyvgorshfvbsuyrfvrsugbwoalhybvkesuveoslgveirufhvbrgorfsjutsdrfjytgskdjrgkljfhjgjkglfgjuflgibusjvhnhgddcyhrgddjyjgdcgfhgnjyrdgxjyjytdhtdvhytydcdjtryddjutrdkdsrwidwytwwdwqydrcwujcytdesdryrehdyjttrddjuygffkcubfvkuuuu", 218,
		"muumin", 4,
		"owituowrhgwrpejsdfbgviegdyhgroishgfnvwrjugbhvesolrguhoebgr", -1
	);

	@Test
	void find()
	{
		for (Map.Entry<String, String> entry : MAP.entrySet())
		{
			String haystack = entry.getKey();
			String needle = entry.getValue();
			int expected = ANSWERS.get(entry.getKey());
			int index = FindIndexFirstOccuranceString.find(entry.getKey(), entry.getValue());

			String message = "Actual=" + index + ", Expected=" + expected + "\nHaystack = " + haystack + "\nNeedle = " + needle;
			assertEquals(expected, index, message);
		}
	}
}