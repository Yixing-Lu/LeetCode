Given two strings `A` and `B` of lowercase letters, return `true` if and only if we can swap two letters in `A` so that the result equals `B`.

---

> Input: A = "aaaaaaabc", B = "aaaaaaacb"
> Output: true

---

In the case `A[i] == A[j] == B[i] == B[j]`, then the strings `A` and `B` are equal. So if `A == B`, we should check each index `i` for two matches with the same value.

In the case `A[i] == B[j], A[j] == B[i], (A[i] != A[j])`, the rest of the indices match. So if `A` and `B` have only two unmatched indices (say `i` and `j`), we should check that the equalities `A[i] == B[j]` and `A[j] == B[i]`hold.

```java
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }
}
```

- Time Complexity: O(N), where N is the length of `A` and `B`.
- Space Complexity: O(1)