Given a singly linked list, determine if it is a palindrome.

---

> Input: 1->2->2->1
> Output: true

---

This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example `[1, 1, 2, 1]`.

In the beginning, set two pointers `fast` and `slow` starting at the head.

> 1 -> 1 -> 2 -> 1 -> null 
> sf

(1) **Move:** `fast` pointer goes to the end, and `slow` goes to the middle.

> 1 -> 1 -> 2 -> 1 -> null 
>                s              f

(2) **Reverse:** the right half is reversed, and `slow` pointer becomes the 2nd head.

> 1 -> 1    null <- 2 <- 1           
> h                              s

(3) **Compare:** run the two pointers `head` and `slow` together and compare.

> 1 -> 1    null <- 2 <- 1             
>         h               s

```JAVA
public boolean isPalindrome(ListNode head) {
  	// use slow and fast to find the midpoint
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
  	// fast!=null: odd nodes: let right half smaller
    if (fast != null) { 
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;
    
    while (slow != null) {
        if (fast.val != slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
}
// reverse the list from start to head
public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
```

