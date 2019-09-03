Given an array of characters, compress it [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm).

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a **character** (not int) of length 1.

After you are done **modifying the input array in-place**, return the new length of the array.

---

> Input:
> ["a","a","b","b","c","c","c"]
>
> Output:
> Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
>
> Explanation:
> "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

---

**Approach 1 Read and Write Head**Let's maintain `anchor`, the start position of the contiguous group of characters we are currently reading.

Now, let's read from left to right. We know that we must be at the end of the block when we are at the last character, or when the next character is different from the current character.

When we are at the end of a group, we will write the result of that group down using our `write` head. `chars[anchor]` will be the correct character, and the length (if greater than 1) will be `read - anchor + 1`. We will write the digits of that number to the array.

```java
class Solution {
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}
```

- Time Complexity: O(N), where N is the length of `chars`.
- Space Complexity: O(1), the space used by `read`, `write`, and `anchor`.

