Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

---

> Input: 
> paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
> banned = ["hit"]
> Output: "ball"
> Explanation: 
> "hit" occurs 3 times, but it is a banned word.
> "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
> Note that words in the paragraph are not case sensitive,
> that punctuation is ignored (even if adjacent to words, such as "ball,"), 
> and that "hit" isn't the answer even though it occurs more because it is banned.

---

We'll need some `count` of words (converted to lowercase) that we have seen in the paragraph. As we iterate through the paragraph, we will collect these words (with punctuation removed and converted to lowercase).

There are two ways we could try to collect these words: we could try to split the paragraph (delimited by spaces) and then clean up the fragment like `"Bob!"`to be `"bob"`. Or, we could add characters one by one to build the next word, stopping when we reach a character that isn't a letter.

For each word (lowercase, and free of punctuation), we'll update our count and update the answer if the count of that word is highest (and the word is not banned.)

```java
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }
}
```

- Time Complexity: O(P + B), where P is the size of `paragraph` and B is the size of `banned`.
- Space Complexity: O(P + B), to store the `count` and the banned set.

