Given a list of sorted characters `letters` containing only lowercase letters, and given a target letter `target`, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is `target = 'z'` and `letters = ['a', 'b']`, the answer is `'a'`

---

> letters = ["c", "f", "j"]
> target = "a"
> Output: "c"

> Input:
> letters = ["c", "f", "j"]
> target = "k"
> Output: "c"

---

**Approach 1 Record Letter Seen**

Let's scan through `letters` and record if we see a letter or not. We could do this with an array of size 26, or with a Set structure.

Then, for every next letter (starting with the letter that is one greater than the target), let's check if we've seen it. If we have, it must be the answer.

```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c: letters)
            seen[c - 'a'] = true;

        while (true) {
            target++;
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }
}
```

Time Complexity: O(N)

Space Complexity: O(1)

---

**Approach 2 Linear Scan**

Since `letters` are sorted, if we see something larger when scanning form left to right, it must be the answer. Otherwise, (since `letters` is non-empty), the answer is `letters[0]`.

```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }
}
```

Time Complexity: O(N)

Space Complexity: O(1)

----

**Approach 3 Binary Search**

Binary search for the character which comes immediately after character target in the alphabets, or if the target is greater than or equal to the last character in the input list, then search for the first character in the list.

```java
class Solution {
    public char nextGreatestLetter(char[] a, char x) {
        int n = a.length;

        //hi starts at 'n' rather than the usual 'n - 1'. 
        //It is because the terminal condition is 'lo < hi' and if hi starts from 'n - 1', 
        //we can never consider value at index 'n - 1'
        int lo = 0, hi = n;

        //Terminal condition is 'lo < hi', to avoid infinite loop when target is smaller than the first element
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > x)     
              hi = mid;
            else    //a[mid] <= x
              lo = mid + 1;                 
        }
 
        //Because lo can end up pointing to index 'n', in which case we return the first element
        return a[lo % n];
    }
}
```

