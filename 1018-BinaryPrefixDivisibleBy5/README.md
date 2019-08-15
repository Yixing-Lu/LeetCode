Given an array `A` of `0`s and `1`s, consider `N_i`: the i-th subarray from `A[0]` to `A[i]` interpreted as a binary number (from most-significant-bit to least-significant-bit.)

Return a list of booleans `answer`, where `answer[i]` is `true` if and only if `N_i` is divisible by 5.

---

> Input: [0,1,1]
> Output: [true,false,false]
> Explanation: 
> The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.

---

For appending a digit **d** at the end of a binary number **old_number** = **akak-1...a0**, we can just do **new_number** = old_number*2 + **d**.

Use the fact that (a*b + c)%d is same as ((a%d)*(b%d) + c%d)%d.

```java
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<Boolean>();
        int num=0;
        for(int i=0; i<A.length; i++)
        {
            num = (num*2 + A[i])%5;
            ans.add(num  == 0);
        }
        return ans;
    }
}
```

Time: O(n)