We define a harmounious array as an array where the difference between its maximum value and its minimum value is **exactly** 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible [subsequences](https://en.wikipedia.org/wiki/Subsequence).

---

> Input: [1,3,2,2,5,2,3,7]
> Output: 5
> Explanation: The longest harmonious subsequence is [3,2,2,2,3].

---

**Approach 1 HashMap**

In this approach, we make use of a hashmap map*m**a**p* which stores the number of times an element occurs in the array along with the element's value in the form (num: count\_num)(*n**u**m*:*c**o**u**n**t*_*n**u**m*), where num*n**u**m*refers to an element in the array and count\_num*c**o**u**n**t*_*n**u**m* refers to the number of times this num*n**u**m* occurs in the nums*n**u**m**s* array. We traverse over the nums*n**u**m**s* array and fill this map*m**a**p* once.

After this, we traverse over the keys of the map*m**a**p* created. For every key of the map*m**a**p* considered, say key*k**e**y*, we find out if the map contains the key + 1*k**e**y*+1. Such an element is found, since only such elements can be counted for the harmonic subsequence if key*k**e**y* is considered as one of the element of the harmonic subsequence. 

Now, whenver we find that key + 1*k**e**y*+1 exists in the keys of map*m**a**p*, we determine the count of the current harmonic subsequence as count_{key} + count_{key+1}*c**o**u**n**t**k**e**y*+*c**o**u**n**t**k**e**y*+1, where count_i*c**o**u**n**t**i* refers to the value corresponding to the key i*i* in map*m**a**p*, which reprents the number of times i*i* occurs in the array nums*n**u**m**s*.

```java
public class Solution {
    public int findLHS(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key: map.keySet())
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        return res;
    }
}
```

Time complexity : O(n).

Space complexity : O(n)

---

