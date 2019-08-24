Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the [Hamming weight](http://en.wikipedia.org/wiki/Hamming_weight)).

---

> Input: 00000000000000000000000000001011
> Output: 3

---

**Approach 1 Loop and Flip**

The solution is straight-forward. We check each of the 32 bits of the number. If the bit is 1, we add one to the number of 1-bits.

We can check the $i^{th}$ bit of a number using a *bit mask*. We start with a mask m=1, because the binary representation of 1 is,

0000 0000 0000 0000 0000 0000 0000 000100000000000000000000000000000001 

Clearly, a logical AND between any number and the mask 1 gives us the least significant bit of this number. To check the next bit, we shift the mask to the left by one.

0000 0000 0000 0000 0000 0000 0000 001000000000000000000000000000000010

And so on.

```java
public int hammingWeight(int n) {
    int bits = 0;
    int mask = 1;
    for (int i = 0; i < 32; i++) {
        if ((n & mask) != 0) {
            bits++;
        }
        mask <<= 1;
    }
    return bits;
}
```

---

**Approach 2 Bit Manipulation Trick**

Instead of checking every bit of the number, we repeatedly flip the least-significant 1-bit of the number to 0, and add 1 to the sum. As soon as the number becomes 0, we know that it does not have any more 1-bits, and we return the sum.

The key idea here is to realize that for any number n*n*, doing a bit-wise AND of n and n - 1 flips the least-significant 1-bit in n to 0. Why? Consider the binary representations of n and n - 1.

In the binary representation, the least significant 1-bit in n*n* always corresponds to a 0-bit in n - 1. Therefore, anding the two numbers n*n* and n - 1 always flips the least significant 1-bit in n to 0, and keeps all other bits the same.

```java
public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
        sum++;
        n &= (n - 1);
    }
    return sum;
}
```

