Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

---

[
     [1],
     [3,2,4],
     [5,6]
]

---

```java
public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        
        if (root == null) return ret;
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
          	// list of node in this level
            List<Integer> curLevel = new LinkedList<>();
          	// number of nodes in this level
            int len = queue.size();
          	// for each node in queue
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
              	// add it to subresult
                curLevel.add(curr.val);
              	// add it to queue
                for (Node c : curr.children)
                    queue.offer(c);
            }
          	// add subresult to result
            ret.add(curLevel);
        }
        
        return ret;
    }
```

