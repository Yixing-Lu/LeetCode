Your friend is typing his `name` into a keyboard.  Sometimes, when typing a character `c`, the key might get *long pressed*, and the character will be typed 1 or more times.

You examine the `typed` characters of the keyboard.  Return `True` if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

---

> Input: name = "alex", typed = "aaleex"
> Output: true
> Explanation: 'a' and 'e' in 'alex' were long pressed.

> Input: name = "saeed", typed = "ssaaedd"
> Output: false
> Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

---

**Approach 1 Group into Block**

For a string like `S = 'aabbbbccc'`, we can group it into blocks `groupify(S) = [('a', 2), ('b', 4), ('c', 3)]`, that consist of a *key* `'abc'` and a *count* `[2, 4, 3]`.

Then, the necessary and sufficient condition for `typed` to be a long-pressed version of `name` is that the keys are the same, and each entry of the count of `typed` is at least the entry for the count of `name`.

```java
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        Group g1 = groupify(name);
        Group g2 = groupify(typed);
        if (!g1.key.equals(g2.key))
            return false;

        for (int i = 0; i < g1.count.size(); ++i)
            if (g1.count.get(i) > g2.count.get(i))
                return false;
        return true;
    }

    public Group groupify(String S) {
        StringBuilder key = new StringBuilder();
        List<Integer> count = new ArrayList();
        int anchor = 0;
        int N = S.length();
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || S.charAt(i) != S.charAt(i+1)) { // end of group
                key.append(S.charAt(i));
                count.add(i - anchor + 1);
                anchor = i+1;
            }
        }

        return new Group(key.toString(), count);
    }
}

class Group {
    String key;
    List<Integer> count;
    Group(String k, List<Integer> c) {
        key = k;
        count = c;
    }
}
```

Time Complexity: O(N+T)

Space Complexity: O(N+T)

---

**Approach 2 Two Pointer**

There are some cases for when we are allowed to skip characters of `typed`. Let's use a tuple to denote the case (`name`, `typed`):

- In a case like `('aab', 'aaaaab')`, we can skip the 3rd, 4th, and 5th `'a'` in `typed` because we have already processed an `'a'` in this block.
- In a case like `('a', 'b')`, we can't skip the 1st `'b'` in `typed` because we haven't processed anything in the current block yet.

- For each character in name, if there's a mismatch with the next character in typed:
  - If it's the first character of the block in `typed`, the answer is `False`.
  - Else, discard all similar characers of `typed` coming up. The next (different) character coming must match.

Also, we'll keep track on the side of whether we are at the first character of the block.

```java
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (char c: name.toCharArray()) {
            if (j == typed.length())
                return false;

            // If mismatch...
            if (typed.charAt(j) != c) {
                // If it's the first char of the block, ans is false.
                if (j==0 || typed.charAt(j-1) != typed.charAt(j))
                    return false;

                // Discard all similar chars
                char cur = typed.charAt(j);
                while (j < typed.length() && typed.charAt(j) == cur)
                    j++;

                // If next isn't a match, ans is false.
                if (j == typed.length() || typed.charAt(j) != c)
                    return false;
            }

            j++;
        }

        return true;
    }
}
```

Time Complexity: O(N+T)

Space Complexity: O(1)