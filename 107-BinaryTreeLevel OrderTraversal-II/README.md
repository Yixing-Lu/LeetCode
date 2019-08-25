Given a binary tree, return the *bottom-up level order* traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

---

> Given binary tree [3,9,20,null,null,15,7],
>     3
>    / \
>   9  20
>     /  \
>    15   7
> return its bottom-up level order traversal as:
> [
>   [15,7],
>   [9,20],
>   [3]
> ]

---

**Approach 1 BFS**

```JAVA
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
     		// for BFS
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
      	// record result
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
          	// number of treenode in this level
            int levelNum = queue.size();
          	// tree nodes in this level
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
              	// bfs
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
              	// add tree node to sublist
                subList.add(queue.poll().val);
            }
          	// add this level to result
            wrapList.add(0, subList);
        }
        return wrapList;
    }
}
```

---





