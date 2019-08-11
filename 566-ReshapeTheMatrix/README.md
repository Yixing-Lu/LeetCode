You're given a matrix represented by a two-dimensional array, and two **positive** integers **r** and **c** representing the **row** number and **column**number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same **row-traversing** order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

---

> Input: 
> nums = 
> [[1,2],
>  [3,4]]
> r = 1, c = 4
>
> Output: 
> [[1,2,3,4]]

---

**Approach 1 Queue**

In this implementation, we use a queue to put the extracted elements. Then, we can take out the elements of the queue formed in a serial order and arrange the elements in the resultant required matrix in a row-by-row order again.

```java

public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }
}

```

---

**Approach 2 without extra space**

we can keep putting the numbers in the resultant matrix directly while iterating over the given matrix in a row-by-row order. While putting the numbers in the resultant array, we fix a particular row and keep on incrementing the column numbers only till we reach the end of the required columns indicated by c*c*. At this moment, we update the row index by incrementing it and reset the column index to start from 0 again. 

```java
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int rows = 0, cols = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[rows][cols] = nums[i][j];
                cols++;
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }
        return res;
    }
}
```

---

**Note Queue <  > queue = new LinkedList < > ();**

**add**        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常

**offer**       添加一个元素并返回true       如果队列已满，则返回false

**remove**   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常

**poll**         移除并返问队列头部的元素    如果队列为空，则返回null

**element**  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常

**peek**       返回队列头部的元素             如果队列为空，则返回null