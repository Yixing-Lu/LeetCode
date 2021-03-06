Given two arrays `arr1` and `arr2`, the elements of `arr2` are distinct, and all elements in `arr2` are also in `arr1`.

Sort the elements of `arr1` such that the relative ordering of items in `arr1`are the same as in `arr2`.  Elements that don't appear in `arr2` should be placed at the end of `arr1` in **ascending** order.

---

> Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
> Output: [2,2,2,1,4,3,3,9,6,7,19]

---

```java
public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int k = 0;
        int[] cnt = new int[1001], ans = new int[arr1.length];
  			// Count each number in arr1.
        for (int i : arr1)                      
            ++cnt[i];
  			// Sort the common numbers in both arrays by the order of arr2.
        for (int i : arr2)                      
            while (cnt[i]-- > 0)
                ans[k++] = i;
 				// Sort the numbers only in arr1.
        for (int i = 0; i < 1001; ++i)          
            while (cnt[i]-- > 0)
                ans[k++] = i;
        return ans;
    }
```

Time & space: O(1001).