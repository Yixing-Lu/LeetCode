You are given an array of strings `words` and a string `chars`.

A string is *good* if it can be formed by characters from `chars` (each character can only be used once).

Return the sum of lengths of all good strings in `words`.

---

> Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
> Output: 10
> Explanation: 
> The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.

---

```JAVA
class Solution {
    private boolean isGood(String s, int[] arr) {
        for(int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a'] > 0) 
                arr[s.charAt(i) - 'a']--;
            else return false;
        }
        return true;
    }
    
    public int countCharacters(String[] words, String chars) {
        int[] arr = new int[26];
        for(int i = 0; i < chars.length(); i++)
            arr[chars.charAt(i) - 'a']++;
        int res = 0;
        for(int i = 0; i < words.length; i++)
            if(isGood(words[i], arr.clone()))
                res += words[i].length();
        return res;
    }
}
```

