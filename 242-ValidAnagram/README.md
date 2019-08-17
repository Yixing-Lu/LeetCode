Given two strings *s* and *t* , write a function to determine if *t* is an anagram of *s*.

---

> Input: s = "anagram", t = "nagaram"
> Output: true

---

**Approach 1 Sort**

An anagram is produced by rearranging the letters of s*s* into t*t*. Therefore, if t*t* is an anagram of s*s*, sorting both strings will result in two identical strings. Furthermore, if s*s* and t*t* have different lengths, t*t*must not be an anagram of s*s* and we can return early.

```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
        return false;
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
}
```

Time complexity : O*(*n*log*n). 

Space complexity : O(1)

---

**Approach 2 HashTable**

To examine if t*t* is a rearrangement of s*s*, we can count occurrences of each letter in the two strings and compare them. Since both s*s* and t*t*contain only letters from a-z*a*−*z*, a simple counter table of size 26 is suffice.

```java
class Solution {
    public boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
        return false;
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter)
        if (count != 0)
            return false;
    return true;
    }
}
```

- Time complexity : O(n). Time complexity is O(n) because accessing the counter table is a constant time operation.
- Space complexity : O(1). Although we do use extra space, the space complexity is O(1) because the table's size stays constant no matter how large n is.

