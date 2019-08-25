Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

**Note:** A leaf is a node with no children.

---

> Given binary tree [3,9,20,null,null,15,7],
>
> ​	3
>
>    / \
>   9  20
>       /  \
>    15   7
> return its minimum depth = 2.

---

```JAVA
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
       
    }
}
```

left = 0 != right, not leaf, minDepth = right + 1

left != 0 = right, not leaf, minDepth = left + 1

left = right = 0, minDepth = 1

left != 0, right !=0, minDepth = min(left,right) + 1