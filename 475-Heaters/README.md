Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

> Input: [1,2,3],[2]
> Output: 1
> Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.

---

The idea is to leverage decent `Arrays.binarySearch()` function provided by Java.

1. For each `house`, find its position between those `heaters` (thus we need the `heaters` array to be sorted).
2. Calculate the distances between this `house` and left `heater` and right `heater`, get a `MIN` value of those two values. Corner cases are there is no left or right heater.
3. Get `MAX` value among distances in step 2. It's the answer.

```java
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0)
        	    index = -(index + 1);
            int dist1 = index == 0 ? Integer.MAX_VALUE : house - heaters[index - 1];
            int dist2 = index == heaters.length ? Integer.MAX_VALUE : heaters[index] - house;
        
            result = Math.max(result, Math.min(dist1, dist2));
        }
        
        return result;
    }
}
```

---

**Note Arrays.binarySearch**

index = binarySearch(Object[], Object key)​

```java
if (index < 0)
	index = -(index + 1);
```

将index统一转换为插入点，原来的元素向后移动，使得数组依然升序。

