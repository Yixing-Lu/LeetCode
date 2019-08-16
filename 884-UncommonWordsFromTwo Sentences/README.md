We are given two sentences `A` and `B`.  (A *sentence* is a string of space separated words.  Each *word* consists only of lowercase letters.)

A word is *uncommon* if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order.

---

> Input: A = "this apple is sweet", B = "this apple is sour"
> Output: ["sweet","sour"]

---

Every uncommon word occurs exactly once in total. We can count the number of occurrences of every word, then return ones that occur exactly once.

```java
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }
}
```

- Time Complexity: O(M + N), where M, N are the lengths of `A` and `B` respectively.
- Space Complexity: O(M + N) the space used by `count`. 