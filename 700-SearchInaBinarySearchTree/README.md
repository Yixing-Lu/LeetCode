Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

---

> Given the tree:
>         4
>        / \
>       2   7
>      / \
>     1   3
>
> And the value to search: 2
> You should return this subtree:
>
>   2     
>  / \   
> 1   3

----

**Approach 1 Recursive**

```java
public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return root;
        if(root.val == val){
            return root;
        }
        else{
            return val<root.val? searchBST(root.left,val):searchBST(root.right,val);
        }
    }
```

---

**Approach 2 Iterative**

```java
public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val<root.val? root.left:root.right;
        }
        return root;
    }
```

