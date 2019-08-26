Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

> a binary tree in which the depth of the two subtrees of *every* node never differ by more than 1.

---

Given the following tree `[3,9,20,null,null,15,7]`:

> ​    3
>    / \
>   9  20
> ​      /  \
>    15   7

---

**Approach 1 Top Down**

The first method checks whether the tree is balanced strictly according to the definition of balanced binary tree: the difference between the heights of the two sub trees are not bigger than 1, and both the left sub tree and right sub tree are also balanced. With the helper function depth(), we could easily write the code;

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        else
            return false;
        
    }
    int depth (TreeNode root) {
        if (root == null)
            return 0;
        int dep = Math.max(depth(root.left),depth(root.right));
        return dep + 1;
    }
}
```

