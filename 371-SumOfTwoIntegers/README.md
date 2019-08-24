Calculate the sum of two integers *a* and *b*, but you are **not allowed** to use the operator `+` and `-`.

---

> Input: a = 1, b = 2
> Output: 3

---

> 3  => 011 
> 2  => 010 
>
> 3 ^2        =>  001 
> (3&2)<<1    =>  100 
>
> Now xor them, which will give 101(5) , we can continue this until the carry becomes zero.

```JAVA
class Solution {
    public int getSum(int a, int b) {
      int c; 
      while(b !=0 ) {
        c = (a&b);
        a = a ^ b;
        b = (c)<<1;
      }
      return a;
        
    }
}
```

