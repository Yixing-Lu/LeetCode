Given a binary search tree and the lowest and highest boundaries as `L` and `R`, trim the tree so that all its elements lies in `[L, R]` (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

---

> Input: 
>     3
>    / \
>   0   4
>    \
>     2
>    /
>   1
>
>   L = 1
>   R = 3
>
> Output: 
>       3
>      / 
>    2   
>   /
>  1

---

**Approach 1 Recursive**

Let `trim(node)` be the desired answer for the subtree at that node. We can construct the answer recursively.

When $\text{node.val > R}$, we know that the trimmed binary tree must occur to the left of the node. Similarly, when $\text{node.val < L}$, the trimmed binary tree occurs to the right of the node. Otherwise, we will trim both sides of the tree.

```JAVA
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
```

- Time Complexity: O(N), where N is the total number of nodes in the given tree. We visit each node at most once.
- Space Complexity: O(N). Even though we don't explicitly use any additional memory, the call stack of our recursion could be as large as the number of nodes in the worst case.

