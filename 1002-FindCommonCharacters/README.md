Given an array `A` of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list **(including duplicates)**.  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

---

>Input: ["bella","label","roller"]
Output: ["e","l","l"]

---

Initialize `count` array with `Integer.MAX_VALUE`, loop through the input to count the chars in each string; then find out the minimum for each char.

```JAVA
public List<String> commonChars(String[] A) {
        int[] count = new int[26]; 
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] cnt = new int[26];
            // count each char's frequency in string str.
            str.chars().forEach(c -> ++cnt[c - 'a']); 
            // update minimum frequency.
            for (int i = 0; i < 26; ++i) 
            	count[i] = Math.min(cnt[i], count[i]); 
        }
  			List<String> ans = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; ++c)
            while (count[c - 'a']-- > 0) 
            	ans.add("" + c); //transfer c from char to str
        return ans;
    }
```

Time: O(n), where `n` is the total number of characters in A;
extra space: O(1)

---

**Note ArrayList**

List<String> ans = new ArrayList<>();

Arrays.fill(ans, Integer.MAX_VALUE) 将ans中全部填入最大值

str.chars().forEach(c -> ++cnt[c - 'a']); 将str转为char，对每个字符c 作相应操作