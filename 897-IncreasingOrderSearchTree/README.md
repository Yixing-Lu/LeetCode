Given a binary search tree, rearrange the tree in **in-order** so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

---

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

​		 5
​      / \
​    3    6

   / \       \
  2   4     8
 /            / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  

---

**Approach 1 In-Order Traversal**

an *in-order traversal* of the nodes will yield all the values in increasing order.

Once we have traversed all the nodes in increasing order, we can construct new nodes using those values to form the answer.

```java
class Solution {    
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }
}
```

- Time Complexity: O(N), where N is the number of nodes in the given tree.
- Space Complexity: O(N), the size of the answer. 

---

**Approach 2 Traversal with Relinking**

We can perform the same in-order traversal as in *Approach 1*. During the traversal, we'll construct the answer on the fly, reusing the nodes of the given tree by cutting their left child and adjoining them to the answer.

```java
class Solution {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
}
```

- Time Complexity: O(N), where N is the number of nodes in the given tree.
- Space Complexity: O(H) in *additional* space complexity, where H is the height of the given tree, and the size of the implicit call stack in our in-order traversal. 