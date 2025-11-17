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

package challenge.leetcode.medium.vowelSpellChecker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @Created 14/09/2025, 11:06 Sun 14 September 2025
 * @Project 3C: Competitive Coding Challenges
 * @Problem 966
 * @Name Vowel Spellchecker
 * @Difficulty Medium
 * @Tags array
 * string
 * hashtable
 * weekly contest 117
 * @link <a href="https://leetcode.com/problems/vowel-spellchecker/">www.leetcode.com/966</a>
 * @Description Given a <code>wordlist</code>, we want to implement a spellchecker that converts a query word into a correct word.<br>
 * <br>
 * For a given <code>query</code> word, the spell checker handles two categories of spelling mistakes:
 * <ul>
 * 		<li> Capitalization:<br>
 * 			If the query matches a word in the wordlist <b>(case-insensitive)</b>,
 * 			then the query word is returned with the same case as the case in the wordlist.
 * 			<ul>
 * 		 		<li>Example:<br>
 * 		 			<code>wordlist = ["yellow"]</code>,<br>
 * 		 			<code>query = "YellOw"</code>,<br>
 * 		 			<code>correct = "yellow"</code></li>
 * 		 		<li>Example:<br>
 * 		 			<code>wordlist = ["Yellow"]</code>,<br>
 * 		 			<code>query = "yellow"</code>,<br>
 * 		 			<code>correct = "Yellow"</code></li>
 * 		 		<li>Example:<br>
 * 		 			<code>wordlist = ["yellow"]</code>,<br>
 * 		 			<code>query = "yellow"</code>,<br>
 * 		 			<code>correct = "yellow"</code></li>
 * 			</ul>
 * 		</li>
 * 		<li> Vowel Errors:<br>
 * 			If after replacing the vowels <code>('a', 'e', 'i', 'o', 'u')</code> of the query word with any vowel individually,
 * 			it matches a word in the wordlist <b>(case-insensitive)</b>,
 * 			then the query word is returned with the same case as the match in the wordlist.
 * 			<ul>
 * 		 		<li>Example:<br>
 * 		 			<code>wordlist = ["YellOw"]</code>,<br>
 * 		 			<code>query = "yollow"</code>,<br>
 * 		 			<code>correct = "YellOw"</code></li>
 * 		 		<li>Example:<br>
 * 		 			<code>wordlist = ["YellOw"]</code>,<br>
 * 		 			<code>query = "yeellow"</code>,<br>
 * 		 			<code>correct = ""</code> (no match)</li>
 * 				<li>Example:<br>
 * 					<code>wordlist = ["YellOw"]</code>,<br>
 * 					<code>query = "yllw"</code>,<br>
 * 					<code>correct = ""</code> (no match)</li>
 * 			</ul>
 * 		</li>
 * </ul>
 * <p>
 * In addition, the spell checker operates under the following precedence rules:
 * <ul>
 * 		<li>When the query exactly matches a word in the wordlist <b>(case-sensitive)</b>, you should return the same word back.</li>
 * 		<li>When the query matches a word up to capitlization, you should return the first such match in the wordlist.</li>
 * 		<li>When the query matches a word up to vowel errors, you should return the first such match in the wordlist.</li>
 * 		<li>If the query has no matches in the wordlist, you should return the empty string.</li>
 * </ul>
 * <p>
 * Given some <code>queries</code>, return a list of words <code>answer</code>,
 * where <code>answer[i]</code> is the correct word for <code>query = queries[i]</code>.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>
 * 				wordlist = ["KiTe","kite","hare","Hare"],
 * 				queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]</code>
 * 			<br><b>Output:</b> {@code ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]}
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>
 * 				wordlist = ["yellow"],
 * 				queries = ["YellOw"]
 * 			</code>
 * 			<br><b>Output:</b> {@code ["yellow"]}
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 * 		<li><code>1 &le; wordlist.length, queries.length &le; 5000</code></li>
 * 		<li><code>1 &le; wordlist[i].length, queries[i].length &le; 7</code></li>
 * 		<li><code>wordlist[i]</code> and <code>queries[i]</code> consist only of only English letters.</li>
 * </ul>
 * </p>
 *
 * <br>
 * <hr>
 * @Similar <br>
 **/
public class VowelSpellchecker
{
	public static void main(String[] args)
	{

	}

	public static String[] spellchecker(String[] wordlist, String[] queries)
	{
		Set<String> words = new HashSet<>(Arrays.asList(wordlist));
		HashMap<String, String> caseMismatched = new HashMap<>();
		HashMap<String, String> vowelMismatched = new HashMap<>();

		for (String word : wordlist)
		{
			String lowercase = word.toLowerCase();
			String lipogram = lowercase.replaceAll("[aeiou]", "*");
			caseMismatched.putIfAbsent(lowercase, word);
			vowelMismatched.putIfAbsent(lipogram, word);
		}

		for (int i = 0; i < queries.length; ++i)
		{
			if (words.contains(queries[i]))
			{
				continue;
			}

			String lowercase = queries[i].toLowerCase();
			String lipogram = lowercase.replaceAll("[aeiou]", "*");

			queries[i] = caseMismatched.containsKey(lowercase)
				? caseMismatched.get(lowercase)
				: vowelMismatched.getOrDefault(lipogram, "");
		}
		return queries;
	}

	// This does not pass the tests because it ignores the levenshtein distance/potentially exact matches,
	// compared to the expected solution, set by the problem statement.
	// Where, the following order is imperative:
	// exact matches must return first,
	// otherwise, case-mismatches must return second,
	// otherwise, vowel-mismatches must return third.
	// This, as mentioned above, does not account for potentially exact matches.
	// Meaning, if the word list contains ["boy", "buy", "bay"],
	// given the query list ["bot", "Big", "ben", "beY", "bay"],
	// then the query for "bay" will return the first lipogram match
	// which would be "boy", because it is indexed 0 in word list.
	public static String[] alternativeSolution(String[] wordlist, String[] queries)
	{
		query:
		for (int i = 0; i < queries.length; ++i)
		{
			for (String word : wordlist)
			{
				if (queries[i].equalsIgnoreCase(word))
				{
					queries[i] = word;
					continue query;
				}
				if (match(queries[i], word))
				{
					queries[i] = word;
					continue query;
				}
			}
			queries[i] = "";
		}
		return queries;
	}

	public static boolean match(String a, String b)
	{
		if (a.length() != b.length())
		{
			return false;
		}

		for (int i = 0; i < a.length(); ++i)
		{
			char c = a.charAt(i);
			char k = b.charAt(i);
			if (isVowel(c) && isVowel(k))
			{
				continue;
			}
			if (Character.toLowerCase(c) != Character.toLowerCase(k))
			{
				return false;
			}
		}
		return true;
	}

	public static boolean isVowel(char c)
	{
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'
			|| c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
