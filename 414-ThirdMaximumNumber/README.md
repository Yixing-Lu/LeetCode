Given a **non-empty** array of integers, return the **third** maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

---

```
Input: [3, 2, 1]

Output: 1
```

```
Input: [1, 2]

Output: 2
```

```
Input: [2, 2, 3, 1]

Output: 1
```

---

```java
class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.add(n)) {
                pq.offer(n);
                if (pq.size() > 3) 
                    pq.poll();
            }
        }
        if (pq.size() == 2)
            pq.poll();
        return pq.peek();
    }
}
```

---

Note:

PriorityQueue: 队列的头是按指定排序方式确定的*最小* 元素。

offer(): 将指定的元素插入此优先级队列。

peek(): 获取但不移除此队列的头。

poll(): 获取并移除此队列的头。

size():