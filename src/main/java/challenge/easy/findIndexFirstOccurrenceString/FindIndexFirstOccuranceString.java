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
 *
 */
package challenge.easy.findIndexFirstOccurrenceString;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

/**
 * @author Administrator
 * @Created 04/06/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 28
 * @Name Find the Index of the First Occurrence in a String
 * @Difficulty Easy
 * @Tags two pointers,
 * string,
 * string matching
 * @link <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">www.leetcode.com/28</a>
 * @Description Given two strings <code>needle</code> and <code>haystack</code>,
 * return the index of the first occurrence of <code>needle</code> in <code>haystack</code>,
 * or <code>-1</code> if <code>needle</code> is not part of <code>haystack</code>.<br>
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> {@code haystack = "sadbutsad", needle = "sad"}
 * 			<br><b>Output:</b> {@code 0}
 * 			<br><b>Explanation:</b> {@code "sad"} occurs at index 0 and 6. The first occurrence is at index 0, so we return {@code 0}.
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> {@code haystack = "leetcode", needle = "leeto"}
 * 			<br><b>Output:</b> {@code -1}
 * 			<br><b>Explanation:</b> {@code "leeto"} did not occur in {@code "leetcode"}, so we return {@code -1}.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code 1 <= haystack.length, needle.length <= 10^4}</li>
 *     <li>{@code haystack} and {@code needle} consists of only lowercase English characters.</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class FindIndexFirstOccuranceString
{
	public static void main(String[] args)
	{
		BasicConfigurator.configure();

//		log.info("sadbutsad: {}", find("sadbutsad", "sad"));
//		log.info("leetcode: {}", find("leetcode", "leeto"));
//		log.info("monkey: {}", find("monkey", "key"));
//		log.info("aaa: {}", find("aaa", "aaaa"));
//		log.info("hgeriludvnbedoberihbipniourvbeprhgowrpoeruhvreisudbvpswreiubgiesdylvhosedhbvkjudyg8uwsrjivlbeyvgorshfvbsuyrfvrsugbwoalhybvkesuveoslgveirufhvbrgorfsjutsdrfjytgskdjrgkljfhjgjkglfgjuflgibusjvhnhgddcyhrgddjyjgdcgfhgnjyrdgxjyjytdhtdvhytydcdjtryddjutrdkdsrwidwytwwdwqydrcwujcytdesdryrehdyjttrddjuygffkcubfvkuuuu: {}", find("hgeriludvnbedoberihbipniourvbeprhgowrpoeruhvreisudbvpswreiubgiesdylvhosedhbvkjudyg8uwsrjivlbeyvgorshfvbsuyrfvrsugbwoalhybvkesuveoslgveirufhvbrgorfsjutsdrfjytgskdjrgkljfhjgjkglfgjuflgibusjvhnhgddcyhrgddjyjgdcgfhgnjyrdgxjyjytdhtdvhytydcdjtryddjutrdkdsrwidwytwwdwqydrcwujcytdesdryrehdyjttrddjuygffkcubfvkuuuu", "jyjy"));
	}

	public static int cheatFind(String haystack, String needle)
	{
		return haystack.indexOf(needle);
	}

	// "naive" greedy solution
	public static int find(String haystack, String needle)
	{
		int index = -1;
		char[] h = haystack.toCharArray();
		char[] n = needle.toCharArray();

		for (int i = 0; i < h.length; i++)
		{
			if (h[i] == n[0])
			{
				index = i;
			}

			if (index != -1)
			{
				for (int j = 0; j < n.length; j++)
				{
					if (i + j > h.length - 1 || h[i + j] != n[j])
					{
						break;
					}
					if (j == n.length - 1)
					{
						return index;
					}
				}
			}
			index = -1;
		}
		return index;
	}
}
