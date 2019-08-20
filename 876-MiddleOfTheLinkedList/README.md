Given a non-empty, singly linked list with head node `head`, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

---

**Approach 1 Slow Fast Pointer**

When traversing the list with a pointer `slow`, make another pointer `fast` that traverses twice as fast. When `fast` reaches the end of the list, `slow` must be in the middle.

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```

Time Complexity: O(N)

Space Complexity: O(1)