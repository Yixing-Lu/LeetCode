Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a *leaf value sequence.*

For example, in the given tree above, the leaf value sequence is `(6, 7, 4, 9, 8)`.

Two binary trees are considered *leaf-similar* if their leaf value sequence is the same.

Return `true` if and only if the two given trees with head nodes `root1` and `root2`are leaf-similar.

---

**Approach 1 DFS**

Let's find the leaf value sequence for both given trees. Afterwards, we can compare them to see if they are equal or not.

To find the leaf value sequence of a tree, we use a depth first search. Our `dfs`function writes the node's value if it is a leaf, and then recursively explores each child. This is guaranteed to visit each leaf in left-to-right order, as left-children are fully explored before right-children.

```JAVA
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null)
                leafValues.add(node.val);
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}
```

- Time Complexity: $O(T_1 + T_2)$, where $T_1, T_2$ are the lengths of the given trees.
- Space Complexity: $O(T_1 + T_2)$, the space used in storing the leaf values. 