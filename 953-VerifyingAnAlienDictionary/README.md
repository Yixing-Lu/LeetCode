In an alien language, surprisingly they also use english lowercase letters, but possibly in a different `order`. The `order` of the alphabet is some permutation of lowercase letters.

Given a sequence of `words` written in the alien language, and the `order` of the alphabet, return `true` if and only if the given `words` are sorted lexicographicaly in this alien language.

---

> Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
> Output: false
> Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

---

Let's check whether all adjacent words `a` and `b` have `a <= b`.

To check whether `a <= b` for two adjacent words `a` and `b`, we can find their first difference. For example, `"applying"` and `"apples"`have a first difference of `y` vs `e`. After, we compare these characters to the index in `order`.

Care must be taken to deal with the blank character effectively. If for example, we are comparing `"app"` to `"apply"`, this is a first difference of `(null)` vs `"l"`.

```JAVA
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }
}
```

- Time Complexity: O(C), where C is the total *content* of `words`.
- Space Complexity: O(1). 