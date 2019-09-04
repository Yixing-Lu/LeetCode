Given a string `S`, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

---

> Input: "a-bC-dEf-ghIj"
> Output: "j-Ih-gfE-dCba"

---

**Approach 1 Stack**

Collect the letters of `S` separately into a stack, so that popping the stack reverses the letters. (Alternatively, we could have collected the letters into an array and reversed the array.)

Then, when writing the characters of `S`, any time we need a letter, we use the one we have prepared instead.

```java
class Solution {
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }
}
```

- Time Complexity: O(N), where N is the length of `S`.
- Space Complexity: O(N)

----

**Approach 2 Reverse Pointer**Write the characters of `S` one by one. When we encounter a letter, we want to write the next letter that occurs if we iterated through the string backwards.

So we do just that: keep track of a pointer `j` that iterates through the string backwards. When we need to write a letter, we use it.

```java
class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }

        return ans.toString();
    }
}
```

- Time Complexity: O(N), where N is the length of `S`.
- Space Complexity: O(N)