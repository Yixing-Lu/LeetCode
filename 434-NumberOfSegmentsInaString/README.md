Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any **non-printable** characters.

---

> Input: "Hello, my name is John"
> Output: 5

---

**Approach 1 Using Language Builtins**

If we reach the final return statement, we `split` the trimmed string on sequences of one or more whitespace characters (`split` can take a regular expression) and return the length of the resulting array.

```java
class Solution {
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
```

- Time complexity : O(n)

  All builtin language functionality used here (in both the Java and Python examples) runs in either O(n)*O*(*n*) or O(1)*O*(1) time, so the entire algorithm runs in linear time.

- Space complexity : O(n)

---

**Approach 2 In-place**

To count the number of segments, it is equivalent to count the number of string indices at which a segment begins. Therefore, by formally defining the characteristics of such an index, we can simply iterate over the string and test each index in turn. Such a definition is as follows: a string index begins a segment if it is preceded by whitespace (or is the first index) and is not whitespace itself, which can be checked in constant time. Finally, we simply return the number of indices for which the condition is satisfied.

```java
class Solution {
    public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}
```

- Time complexity : O(n)

  We do a constant time check for each of the string's n*n* indices, so the runtime is overall linear.

- Space complexity : O(1)

  There are only a few integers allocated, so the memory footprint is constant.

