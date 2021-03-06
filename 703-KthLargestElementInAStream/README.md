Design a class to find the **k**th largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your `KthLargest` class will have a constructor which accepts an integer `k` and an integer array `nums`, which contains initial elements from the stream. For each call to the method `KthLargest.add`, return the element representing the kth largest element in the stream.

---

> int k = 3;
> int[] arr = [4,5,8,2];
> KthLargest kthLargest = new KthLargest(3, arr);
> kthLargest.add(3);   // returns 4
> kthLargest.add(5);   // returns 5
> kthLargest.add(10);  // returns 5
> kthLargest.add(9);   // returns 8
> kthLargest.add(4);   // returns 8

---

```java
class KthLargest {
    final PriorityQueue<Integer> q;
        final int k;

    public KthLargest(int k, int[] a) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int n : a)
                add(n);
        }

    public int add(int n) {
            if (q.size() < k)
                q.offer(n);
            else if (q.peek() < n) {
                q.poll();
                q.offer(n);
            }
            return q.peek();
        }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
```

