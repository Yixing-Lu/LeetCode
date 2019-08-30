Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

---

> Input:
>     3
>    / \
>   9  20
>     /  \
>    15   7
> Output: [3, 14.5, 11]
> Explanation:
> The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

---

**Approach 1 DFS**

To make use of DFS to solve the given problem, we make use of two lists count and res. Here, count[i] refers to the total number of nodes found at the $i^{th}$level(counting from root at level 0) till now, and res[i] refers to the sum of the nodes at the $i^{th}$ level encountered till now during the Depth First Search.

We make use of a function `average(t, i, res, count)`, which is used to fill the res and count array if we start the DFS from the node t*t* at the $i^{th}$ level in the given tree. We start by making the function call `average(root, 0, res, count)`. After this, we do the following at every step:

1. Add the value of the current node to the res (or sum) at the index corresponding to the current level. Also, increment the count at the index corresponding to the current level.
2. Call the same function, `average`, with the left and the right child of the current node. Also, update the current level used in making the function call.
3. Repeat the above steps till all the nodes in the given tree have been considered once.
4. Populate the averages in the resultant array to be returned.

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
public class Solution {
    public List < Double > averageOfLevels(TreeNode root) {
        List < Integer > count = new ArrayList < > ();
        List < Double > res = new ArrayList < > ();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }
    public void average(TreeNode t, int i, List < Double > sum, List < Integer > count) {
        if (t == null)
            return;
      	// Same Level
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } 
      	// New level
      	else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }
}
```

- Time complexity : O(n). The whole tree is traversed once only. Here, n refers to the total number of nodes in the given binary tree.
- Space complexity : O(h). res and count array of size h are used. Here, h*h*refers to the height(maximum number of levels) of the given binary tree. Further, the depth of the recursive tree could go upto h only.

---

**Approach 2 BFS**

In BFS, we start by pushing the root node into a queue*q**u**e**u**e*. Then, we remove an element(node) from the front of the queue*q**u**e**u**e*. For every node removed from the queue*q**u**e**u**e*, we add all its children to the back of the same queue*q**u**e**u**e*. We keep on continuing this process till the queue*q**u**e**u**e* becomes empty. In this way, we can traverse the given tree on a level-by-level basis.

But, in the current implementation, we need to do a slight modification, since we need to separate the nodes on one level from that of the other.

The steps to be performed are listed below:

1. Put the root node into the queue*q**u**e**u**e*.
2. Initialize sum*s**u**m* and count*c**o**u**n**t* as 0 and temp*t**e**m**p* as an empty queue.
3. Pop a node from the front of the queue*q**u**e**u**e*. Add this node's value to the sum*s**u**m*corresponding to the current level. Also, update the count*c**o**u**n**t* corresponding to the current level.
4. Put the children nodes of the node last popped into the a temp*t**e**m**p*queue(instead of queue*q**u**e**u**e*).
5. Continue steps 3 and 4 till queue*q**u**e**u**e* becomes empty. (An empty queue*q**u**e**u**e*indicates that one level of the tree has been considered).
6. Reinitialize queue*q**u**e**u**e* with its value as temp*t**e**m**p*.
7. Populate the res*r**e**s* array with the average corresponding to the current level.
8. Repeat steps 2 to 7 till the queue*q**u**e**u**e* and temp*t**e**m**p* become empty.

At the end, res*r**e**s* is the required result.

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
public class Solution {
    public List < Double > averageOfLevels(TreeNode root) {
        List < Double > res = new ArrayList < > ();
        Queue < TreeNode > queue = new LinkedList < > ();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue < TreeNode > temp = new LinkedList < > ();
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                sum += n.val;
                count++;
                if (n.left != null)
                    temp.add(n.left);
                if (n.right != null)
                    temp.add(n.right);
            }
            queue = temp;
            res.add(sum * 1.0 / count);
        }
        return res;
    }
}
```

- Time complexity : O(n). The whole tree is traversed atmost once. Here, n refers to the number of nodes in the given binary tree.
- Space complexity : O(m). The size of queue or temp can grow upto atmost the maximum number of nodes at any level in the given binary tree. Here, m*m*refers to the maximum mumber of nodes at any level in the input tree.