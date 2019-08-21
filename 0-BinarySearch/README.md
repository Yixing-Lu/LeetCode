## Binary Search

---

Time: O(nlogn)

Space: O(1)

---

**Approach 1: Return the match inside the loop**

```java
public int search(int[] nums, int target) {
  int low = 0;
  int high = nums.length - 1;
  while (low <= high) {
    int mid = low + (high - low) / 2;
    if (nums[mid] == target)
      return mid;
    else if (nums[id] > target)
      high = mid - 1;
    else
      low = mid + 1;
  }
  return -1;
}
```

---

**Approach 2: Exit out of the loop and use `low` to return the match**

```java
public int search(int[] nums, int target) {
  int low = 0;
  int high = nums.length - 1;
  while (low < high) {
    int mid = low + (high - low) / 2;
    if (nums[id] > target)
      high = mid;
    else
      low = mid + 1;
  }
  return left;
}
```