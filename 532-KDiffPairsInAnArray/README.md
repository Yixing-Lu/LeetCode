Given an array of integers and an integer **k**, you need to find the number of **unique** k-diff pairs in the array. Here a **k-diff** pair is defined as an integer pair (i, j), where **i** and **j** are both numbers in the array and their [absolute difference](https://en.wikipedia.org/wiki/Absolute_difference) is **k**.

---

> Input: [3, 1, 4, 1, 5], k = 2
> Output: 2

> Input: [1, 3, 1, 5, 4], k = 0
> Output: 1
> Explanation: There is one 0-diff pair in the array, (1, 1).

---

```JAVA
class Solution {
    public int findPairs(int[] nums, int k) {
        // special case
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // count in map
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count elements appear more than twice.
                if (entry.getValue() >= 2)
                    count++;
            }
            else if (map.containsKey(entry.getKey() + k))
                    count++;
        }  
        return count;
    }
}
```

---

**Map.getOrDefault(Object key, V defaultValue)**

当Map集合中有这个key时，就使用这个key值；

如果没有就使用默认值defaultValue。