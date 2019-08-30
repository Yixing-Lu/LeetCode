A binary tree is *univalued* if every node in the tree has the same value.

Return `true` if and only if the given tree is univalued.

---

> Input: [1,1,1,1,1,null,1]
> Output: true
>
> Input: [2,2,2,5,2]
> Output: false

---

**Approach 1 DFS**

Let's output all the values of the array. After, we can check that they are all equal.

To output all the values of the array, we perform a depth-first search.

```JAVA
class Solution {
    List<Integer> vals;
    public boolean isUnivalTree(TreeNode root) {
        vals = new ArrayList();
        dfs(root);
        for (int v: vals)
            if (v != vals.get(0))
                return false;
        return true;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            vals.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
}
```

- Time Complexity: O(N), where N is the number of nodes in the given tree.
- Space Complexity: O(N)

---

**Approach 2 Recursive**

A tree is univalued if both its children are univalued, plus the root node has the same value as the child nodes.

We can write our function recursively. `left_correct` will represent that the left child is correct: ie., that it is univalued, and the root value is equal to the left child's value. `right_correct` will represent the same thing for the right child. We need both of these properties to be true.

```java
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }
}
```

- Time Complexity: O(N), where N is the number of nodes in the given tree.
- Space Complexity: O(H), where H is the height of the given tree. 