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
package challenge.leetcode.easy.maximumNumberOfWordsFoundInSentences;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @Created 28/07/2025,
 * @Project 3C: Competitive Coding Challenges
 * @Problem 2114
 * @Name Maximum Number of Words Found in Sentences
 * @Difficulty Easy
 * @Tags
 * @link <a href="https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/">www.leetcode.com/2114</a>
 * @Description A sentence is a list of words that are separated by a single space with no leading or trailing spaces.<br>
 * <br>
 * You are given an array of strings sentences, where each sentences[i] represents a single sentence.<br>
 * <br>
 * Return the maximum number of words that appear in a single sentence.
 *
 * <ul>
 * 		<li><b>Example 1:</b>
 * 			<br><b>Input:</b> <code>sentences = ["alice and bob love leetcode", "i think so too", "<u>this is great thanks very much</u>"]</code>
 * 			<br><b>Output:</b> {@code 6}
 * 			<br><b>Explanation:</b>
 * 			<br>&emsp;- The first sentence, "alice and bob love leetcode", has 5 words in total.
 * 			<br>&emsp;- The second sentence, "i think so too", has 4 words in total.
 * 			<br>&emsp;- The third sentence, "this is great thanks very much", has 6 words in total.
 * 			<br>&emsp;Thus, the maximum number of words in a single sentence comes from the third sentence, which has 6 words.
 *
 * 		</li>
 * </ul>
 * <ul>
 * 		<li><b>Example 2:</b>
 * 			<br><b>Input:</b> <code>sentences = ["please wait", "<u>continue to fight</u>", "<u>continue to win</u>"]</code>
 * 			<br><b>Output:</b> {@code 3}
 * 			<br><b>Explanation:</b> It is possible that multiple sentences contain the same number of words.
 * 			<br>&emsp;In this example, the second and third sentences (underlined) have the same number of words.
 * 		</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li><code>1 &le; sentences.length &le; 100</code></li>
 *     <li><code>1 &le; sentences[i].length &le; 100</code></li>
 *     <li><code>sentences[i]</code> consists only of lowercase English letters and <code>' '</code> only.</li>
 *     <li><code>sentences[i]</code> does not have leading or trailing spaces.</li>
 *     <li>All the words in <code>sentences[i]</code> are separated by a single space.</li>
 * </ul>
 * </p>
 **/
@Slf4j
public class MaximumNumberOfWordsFoundInSentences
{
	/**
	 * <h1>Solutions</h1>
	 * <hr>
	 * <h3>Option 1: Fencepost-problem approach</h3>
	 * <p>
	 * Because the sentences only have lowercase letters from the English alphabet,
	 * and are delimited by a single space character, without any leading or trailing spaces.
	 * That means there are <code>n+1</code> words in a sentence with <code>n</code> spaces.<br>
	 * <br>
	 * E.g.<br>
	 * <code>WORD |1| WORD |2| WORD |3| WORD</code>&emsp;&hArr;&emsp;There are <code>3</code> spaces, and <code>3+1</code> words.
	 * </p>
	 * <br>
	 * <hr>
	 * <h3>Option 2: </h3>
	 * <p>
	 * Split sentence by space, and count the length of the new array.<br>
	 * <br>
	 * E.g.<br>
	 * <code>maxWords = Math.max(maxWords, sentence.split("\s+").length);</code>
	 * </p>
	 * <br>
	 * <hr>
	 * <h3>Option 3: </h3>
	 * <p>
	 * Replace all word-spaces with a single character, and count the length of the new sentence.<br>
	 * <br>
	 * E.g.<br>
	 * <code>maxWords = Math.max(maxWords, sentence.replaceAll("\\w+\\s?", " ").length());</code>
	 * </p>
	 * <br>
	 * <hr>
	 * <h3>Option 4: </h3>
	 * <p>
	 * Using a StringTokenizer, and counting spaces.<br>
	 * </p>
	 * <br>
	 * <hr>
	 *
	 * @param sentences
	 * @return
	 */
	public static int mostWordsFound(String[] sentences)
	{
		int max = 0;
		for (String sentence : sentences)
		{
			max = Math.max(max, sentence.split("\s+").length);
		}
		for (String sentence : sentences)
		{
			max = Math.max(max, sentence.replaceAll("\\w+\\s?", " ").length());
		}

		return max;
	}
}
