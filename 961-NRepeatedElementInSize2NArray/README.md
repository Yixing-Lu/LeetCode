In a array `A` of size `2N`, there are `N+1` unique elements, and exactly one of these elements is repeated N times.

Return the element repeated `N` times.

---

> Input: [2,1,2,5,3,2]
> Output: 2

---

```JAVA
class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> count = new HashMap();
        for (int x: A)
            count.put(x, count.getOrDefault(x, 0) + 1);
        for (int k: count.keySet())
            if (count.get(k) > 1)
                return k;
        throw null;
    }
}
```

- Time Complexity: O(N), where N is the length of `A`.

- Space Complexity: O(N). 

  