Given an integer, write a function to determine if it is a power of two.

---

> Input: 16
> Output: true
> Explanation: 24 = 16

---

Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case

```JAVA
class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n>0&&((n&(n-1))==0));
    }
}
```

