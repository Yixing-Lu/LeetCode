Given two positive integers `x` and `y`, an integer is *powerful* if it is equal to `x^i + y^j` for some integers `i >= 0` and `j >= 0`.

Return a list of all *powerful* integers that have value less than or equal to `bound`.

You may return the answer in any order.  In your answer, each value should occur at most once.

---

> Input: x = 2, y = 3, bound = 10
> Output: [2,3,4,5,7,9,10]
> Explanation: 
> 2 = 2^0 + 3^0
> 3 = 2^1 + 3^0
> 4 = 2^0 + 3^1
> 5 = 2^1 + 3^1
> 7 = 2^2 + 3^1
> 9 = 2^3 + 3^0
> 10 = 2^0 + 3^2

---

If x^i bound, the sum x^i + y^j can't be less than or equal to the bound. Similarly for y^j.

Thus, we only have to check for 0≤*i*,*j*≤log*x*(bound)<18.

We can use a `HashSet` to store all the different values.

```java
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < 20 && Math.pow(x, i) <= bound; ++i)
            for (int j = 0; j < 20 && Math.pow(y, j) <= bound; ++j) {
                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (v <= bound)
                    seen.add(v);
            }

        return new ArrayList(seen);
    }
}
```

- Time Complexity: $O(log^2bound)$.
- Space Complexity: $O(log^2bound)$. 