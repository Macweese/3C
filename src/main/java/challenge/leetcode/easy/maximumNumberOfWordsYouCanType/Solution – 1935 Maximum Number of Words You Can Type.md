# Intuition

The problem is simple:  
Given a text `text`, return the number of words which do not contain any of the given prohibited letters `letters`.

Instinctively the challenge we think of may be using a nested loop, to check each letter of each word, against each
letter of prohibited letters.

But we can improve the time complexity by consolidating the prohibited letters into a single piece of data that can be
used to qualify a word, by masking the translated letters into bits. Since each integer is represented by 32 bits, there
are 26 letters in the English alphabet, and all letters are guaranteed to be lowercase, there are only 26 possible
letters we need to track. We set the bit of the letter's position in the alphabet to `1`, then bitwise-OR the letter
with the letters mask, to get the new letters mask. Similarly, we do the process for the letters in a word, obtaining a
word mask. And to check if a word qualifies, we perform bitwise-AND, which will yield `0` for words containing none of
the prohibited letters, and `> 0` for words containing letters.

Legend for table:  
<span style="color:#a0a0a0">• Word &emsp; = word in text  </span>  
<span style="color:#a0a0a0">• Letters &nbsp;&hairsp; = Prohibited letters  </span>  
<span style="color:#a0a0a0">• W<sub>m</sub>&emsp;&nbsp;&nbsp;&ensp; = word mask (decimal representation)  </span>  
<span style="color:#a0a0a0">• L<sub>m</sub> &emsp;&emsp;&puncsp; = letters mask (decimal representation)  </span>

| Word   | Letters | W<sub>m</sub> | L<sub>m</sub> | Bitwise-AND |
|--------|---------|---------------|---------------|-------------|
| `leet` | `lt`    | `1,052,704`   | `526,336`     | `526,336`   |
| `code` | `lt`    | `32,824`      | `526,336`     | `0`         |

Using this method means we only have to check each letter in prohibited letters `letters` and words in text `word` once.

This brings the time complexity down from $ O(n^2) $ to $ O(n) $.

---

# Approach

• Iterate over all prohibited letters to get the mask for prohibited letters.  
• Iterate over all letters in the word to get the mask for the word.  
• Perform bitwise-AND `wordMask & lettersMask`, if the mask is `0` it means the word does not contain any of the
letters. Otherwise, the word contains at least one letter from the prohibited letters.

---

# Complexity

$$
\begin{flalign}&
n \ \stackrel{\text{def}}{=}
\text{number of characters in all words}
&\end{flalign}
$$

$$
\begin{flalign} &
m \stackrel{\text{def}}{=} \text{number of prohibited letters}
& \end{flalign}
$$

- Time complexity: $ O(n) $  
  Checking all chars in `text` and `letters` is $ O(n + m) $, `letters` is guaranteed to be $ \lt 27 $, so $ m $
  may be considered constant, thus the overall complexity is $ O(n) $.


- Space complexity: $ O(1) $  
  No extra space is used.

# Code

```java
class Solution
{
	public int canBeTypedWords(String text, String brokenLetters)
	{
		int completeWords = 0;
		int brokenLettersMask = getMask(brokenLetters);

		for (String word : text.split(" "))
		{
			completeWords = (getMask(word) & brokenLettersMask) == 0 ? completeWords + 1 : completeWords;
		}

		return completeWords;
	}

	private int getMask(String word)
	{

		int mask = 0;
		for (int i = 0; i < word.length(); ++i)
		{
			mask |= 1 << (word.charAt(i) - ('a'));
		}
		return mask;
	}
}
```

---
![img.png](maximumNumberOfWordsYouCanTypeAC.png)
![image.png](https://assets.leetcode.com/users/images/4258fdf7-a23b-4584-b234-99dd435b5d7e_1757906899.8984516.png)
