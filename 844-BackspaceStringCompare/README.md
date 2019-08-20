Given two strings `S` and `T`, return if they are equal when both are typed into empty text editors. `#` means a backspace character.

---

> Input: S = "ab#c", T = "ad#c"
> Output: true
> Explanation: Both S and T become "ac".

---

**Approach 1 Stack**

To build the result of a string `build(S)`, we'll use a stack based approach, simulating the result of each keystroke.

```java
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
```

Time Complexity: O(M + N)

Space Complexity: O(M + N)

---

**Approach 2 Two Pointer**

Iterate through the string in reverse. If we see a backspace character, the next non-backspace character is skipped. If a character isn't skipped, it is part of the final answer.

```java
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {
                  skipS++; 
                  i--;
                }
                else if (skipS > 0) {
                  skipS--; 
                  i--;
                }
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {
                  skipT++; 
                  j--;
                }
                else if (skipT > 0) {
                  skipT--; 
                  j--;
                }
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; 
          	j--;
        }
        return true;
    }
}
```

Time Complexity: O(M + N)

Space Complexity: O(1)