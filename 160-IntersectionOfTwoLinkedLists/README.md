Write a program to find the node at which the intersection of two singly linked lists begins.

---

**Approach 1 Brute Force**

For each node ai in list A, traverse the entire list B and check if any node in list B coincides with ai.

- Time complexity : O(mn).
- Space complexity : O(1). 

---

**Approach 2 Hash Table**

Traverse list A and store the address / reference to each node in a hash set. Then check every node bi in list B: if bi appears in the hash set, then bi is the intersection node.

- Time complexity : O(m+n).
- Space complexity : O(m) or O(n). 

---

**Approach 3 Two Pointer**

- Maintain two pointers pA and pB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
- When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pB reaches the end of a list, redirect it the head of A.
- If at any point pA meets pB, then pA/pB is the intersection node.
- To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'. Since B.length (=4) < A.length (=6), pBwould reach the end of the merged list first, because pB traverses exactly 2 nodes less than pA does. By redirecting pB to head A, and pA to head B, we now ask pB to travel exactly 2 more nodes than pA would. So in the second iteration, they are guaranteed to reach the intersection node at the same time.
- If two lists have intersection, then their last nodes must be the same one. So when pA/pB reaches the end of a list, record the last element of A/B respectively. If the two last elements are not the same one, then the two lists have no intersections.

Actually we don't care about the "value" of difference, we just want to make sure two pointers reach the intersection node at the same time.

We can use two iterations to do that. In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist after it reaches the tail node. In the second iteration, we will move two pointers until they points to the same node. Our operations in first iteration will help us counteract the difference. So if two linkedlist intersects, the meeting point in second iteration must be the intersection point. If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be the tail node of both lists, which is null

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	//boundary check
    	if(headA == null || headB == null) 
      	return null;
    
    	ListNode a = headA;
    	ListNode b = headB;
    
    	while( a != b){
        	a = a == null? headB : a.next;
        	b = b == null? headA : b.next;    
    	}
    	return a;
	}
}
```

- Time complexity : O(m+n).
- Space complexity : O(1).

