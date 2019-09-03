Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

---

> Input: s = "abcdefg", k = 2
> Output: "bacdfeg"

---

We will reverse each block of `2k` characters directly.

Each block starts at a multiple of `2k`: for example, `0, 2k, 4k, 6k, ...`. One thing to be careful about is we may not reverse each block if there aren't enough characters.

To reverse a block of characters from `i` to `j`, we can swap characters in positions `i++` and `j--`.

```java
class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
```

- Time Complexity: O(N), where N is the size of `s`. We build a helper array, plus reverse about half the characters in `s`.
- Space Complexity: O(N), the size of `a`.