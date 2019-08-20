Implement [strStr()](http://www.cplusplus.com/reference/cstring/strstr/).

Return the index of the first occurrence of needle in haystack, or **-1** if needle is not part of haystack.

---

> Input: haystack = "hello", needle = "ll"
> Output: 2

---



```java
class Solution {
    public int strStr(String s, String t) {
        // edge case: "",""=>0  "a",""=>0
        if (t.isEmpty()) return 0; 
        for (int i = 0; i <= s.length() - t.length(); i++)
            for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
                if (j == t.length() - 1) 
                    return i;
        return -1;
    }
}
```

```java
public class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2)
            return -1;
        else if (l2 == 0)
            return 0;
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i)
            if (haystack.substring(i,i+l2).equals(needle))
                return i;
        return -1;
    }
}
```

