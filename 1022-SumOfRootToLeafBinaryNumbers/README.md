Given a binary tree, each node has value `0` or `1`.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is `0 -> 1 -> 1 -> 0 -> 1`, then this could represent `01101` in binary, which is `13`.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

---

> Input: [1,0,1,0,1,0,1]
> Output: 22
> Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

---

```JAVA
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    
    int ans = 0;
    void dfs(TreeNode root, int val){
        if(root == null) return;
        val = val << 1 | root.val;
        if(root.left == null && root.right == null) ans += val;
        dfs(root.left, val);
        dfs(root.right, val);
    }
}
```

