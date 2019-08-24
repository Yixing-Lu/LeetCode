Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

---

> Input: 5
> Output: 2
> Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2

---

According to the problem, the result is

1. The `flipped` version of the original `input` but
2. Only flip `N` bits within the range from `LEFTMOST` bit of `1` to `RIGHTMOST`.
   For example input = `5` (the binary representation is `101`), the `LEFTMOST` bit of `1` is the third one from `RIGHTMOST` (`100`, `N` = 3). Then we need to flip 3 bits from `RIGHTMOST` and the answer is `010`

To achieve above algorithm, we need to do 3 steps:

1. Create a bit mask which has `N` bits of `1` from `RIGHTMOST`. In above example, the mask is `111`. And we can use the decent Java built-in function `Integer.highestOneBit` to get the `LEFTMOST` bit of `1`, left shift one, and then minus one. Please remember this wonderful trick to create bit masks with `N` ones at `RIGHTMOST`, you will be able to use it later.
2. Negate the whole input number.
3. `Bit AND` numbers in step `1` and `2`.

```JAVA
public class Solution {
    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
    }
}
```

---

**Note**

Integer.highestOneBit(num): 获得num二进制最高位的1的位置

int mask = (Integer.highestOneBit(num) << 1) - 1：create bit masks with `N` ones at `RIGHTMOST`

