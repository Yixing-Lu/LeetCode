Given two arrays `A` and `B` of equal size, the *advantage of A with respect to B* is the number of indices `i` for which `A[i] > B[i]`.

Return **any** permutation of `A` that maximizes its advantage with respect to `B`.

---

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]

---

We can use the above intuition to create a greedy approach. The current smallest card to beat in `B` will always be `b = sortedB[j]`. For each card `a` in `sortedA`, we will either have `a` beat that card `b` (put `a` into `assigned[b]`), or throw `a` out (put `a` into `remaining`).

Afterwards, we can use our annotations `assigned` and `remaining` to reconstruct the answer. Please see the comments for more details.

```JAVA
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Deque<Integer>> assigned = new HashMap();
        for (int b: B) assigned.put(b, new LinkedList());

        // remaining = list of a that are not assigned to any b
        Deque<Integer> remaining = new LinkedList();

        // populate (assigned, remaining) appropriately
        // sortedB[j] is always the smallest unassigned element in B
        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        // Reconstruct the answer from annotations (assigned, remaining)
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            // if there is some a assigned to b...
            if (assigned.get(B[i]).size() > 0)
                ans[i] = assigned.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }
}
```

- Time Complexity: O*(*N*log*N*), where N is the length of `A` and `B`.
- Space Complexity: O(N)

