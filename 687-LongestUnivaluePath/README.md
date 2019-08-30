Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

---

> Input:
>
> ​			 5
> ​             / \
> ​            4   5
> ​           / \   \
> ​          1   1   5
>
> Output: 2

---

 for each node, we want to know what is the longest possible arrow extending left, and the longest possible arrow extending right? We can solve this using recursion.

Let `arrow_length(node)` be the length of the longest arrow that extends from the `node`. That will be `1 + arrow_length(node.left)` if `node.left` exists and has the same value as `node`. Similarly for the `node.right` case.

While we are computing arrow lengths, each candidate answer will be the sum of the arrows in both directions from that node. We record these candidate answers and return the best one.

```JAVA
class Solution {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left)
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
```

- Time Complexity: O(N), where N is the number of nodes in the tree. We process every node once.
- Space Complexity: O(H), where H is the height of the tree. Our recursive call stack could be up to H layers deep.