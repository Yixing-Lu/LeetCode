Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

---

>Input: 
>    5
>   / \
>  3   6
> / \   \
>2   4   7
>
>Target = 9
>
>Output: True

---

**Approach 1 HashSet**

The simplest solution will be to traverse over the whole tree and consider every possible pair of nodes to determine if they can form the required sum k*k*. But, we can improve the process if we look at a little catch here.

If the sum of two elements x + y*x*+*y* equals k*k*, and we already know that x*x* exists in the given tree, we only need to check if an element y*y* exists in the given tree, such that y = k - x*y*=*k*−*x*. Based on this simple catch, we can traverse the tree in both the directions(left child and right child) at every step. We keep a track of the elements which have been found so far during the tree traversal, by putting them into a set*s**e**t*.

For every current node with a value of p*p*, we check if k-p*k*−*p* already exists in the array. If so, we can conclude that the sum k*k* can be formed by using the two elements from the given tree. Otherwise, we put this value p*p* into the set*s**e**t*.

If even after the whole tree's traversal, no such element p*p* can be found, the sum k*k*can't be formed by using any two elements.

```java
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
```

- Time complexity : O(n). The entire tree is traversed only once in the worst case. Here, n refers to the number of nodes in the given tree.
- Space complexity : O(n). The size of the set*s**e**t* can grow upto n in the worst case.

---

**Approach 2 BFS and Hashset**

In this approach, the idea of using the set*s**e**t* is the same as in the last approach. But, we can carry on the traversal in a Breadth First Search manner, which is a very common traversal method used in Trees. The way BFS is used can be summarized as given below. We start by putting the root node into a queue*q**u**e**u**e*. We also maintain a set*s**e**t* similar to the last approach. Then, at every step, we do as follows:

1. Remove an element, p*p*, from the front of the queue*q**u**e**u**e*.
2. Check if the element k-p*k*−*p* already exists in the set*s**e**t*. If so, return True.
3. Otherwise, add this element, p*p* to the set*s**e**t*. Further, add the right and the left child nodes of the current node to the back of the queue*q**u**e**u**e*.
4. Continue steps 1. to 3. till the queue*q**u**e**u**e* becomes empty.
5. Return false if the queue*q**u**e**u**e* becomes empty.

```java
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue < TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }
}
```

- Time complexity : O(n). We need to traverse over the whole tree once in the worst case. Here, n*n* refers to the number of nodes in the given tree.
- Space complexity : O(n). The size of the set*s**e**t* can grow atmost upto n.

---

**Approach 3 BST**

In this approach, we make use of the fact that the given tree is a Binary Search Tree. Now, we know that the inorder traversal of a BST gives the nodes in ascending order. Thus, we do the inorder traversal of the given tree and put the results in a list*l**i**s**t*which contains the nodes sorted in ascending order.

Once this is done, we make use of two pointers l*l* and r*r* pointing to the beginning and the end of the sorted list*l**i**s**t*. Then, we do as follows:

1. Check if the sum of the elements pointed by l*l* and r*r* is equal to the required sum k*k*. If so, return a True immediately.
2. Otherwise, if the sum of the current two elements is lesser than the required sum k*k*, update l*l* to point to the next element. This is done, because, we need to increase the sum of the current elements, which can only be done by increasing the smaller number.
3. Otherwise, if the sum of the current two elements is larger than the required sum k*k*, update r*r* to point to the previous element. This is done, because, we need to decrease the sum of the current elements, which can only be done by reducing the larger number.
4. Continue steps 1. to 3. till the left pointer l*l* crosses the right pointer r*r*.
5. If the two pointers cross each other, return a False value.

```JAVA
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
```

- Time complexity : O(n). We need to traverse over the whole tree once to do the inorder traversal. Here, n*n* refers to the number of nodes in the given tree.
- Space complexity : O(n). The sorted list will contain n elements.