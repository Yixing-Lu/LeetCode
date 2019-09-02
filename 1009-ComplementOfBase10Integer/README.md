Every non-negative integer `N` has a binary representation.  For example, `5` can be represented as `"101"` in binary, `11` as `"1011"` in binary, and so on.  Note that except for `N = 0`, there are no leading zeroes in any binary representation.

The *complement* of a binary representation is the number in binary you get when changing every `1` to a `0` and `0` to a `1`.  For example, the complement of `"101"` in binary is `"010"` in binary.

For a given number `N` in base-10, return the complement of it's binary representation as a base-10 integer.

---

> Input: 5
> Output: 2
> Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.

---

Let's find the first number `X` that `X = 1111....1 > N`
And also, it has to be noticed that,
`N = 0` is a corner case expecting`1` as result.

```
N + bitwiseComplement(N) = 11....11 = X`
Then `bitwiseComplement(N) = X - N
```

```JAVA
public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;
    }
```



