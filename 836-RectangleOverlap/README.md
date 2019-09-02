A rectangle is represented as a list `[x1, y1, x2, y2]`, where `(x1, y1)` are the coordinates of its bottom-left corner, and `(x2, y2)` are the coordinates of its top-right corner.

Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two (axis-aligned) rectangles, return whether they overlap.

---

> Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
> Output: true

---

The answer for whether they *don't* overlap is `LEFT OR RIGHT OR UP OR DOWN`, where `OR` is the logical OR, and `LEFT` is a boolean that represents whether `rec1` is to the left of `rec2`. The answer for whether they do overlap is the negation of this.

The condition "`rec1` is to the left of `rec2`" is `rec1[2] <= rec2[0]`, that is the right-most x-coordinate of `rec1` is left of the left-most x-coordinate of `rec2`. The other cases are similar.

```JAVA
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                 rec1[3] <= rec2[1] ||   // bottom
                 rec1[0] >= rec2[2] ||   // right
                 rec1[1] >= rec2[3]);    // top
    }
}
```

- Time and Space Complexity: O(1)

---

If the rectangles overlap, they have positive area. This area must be a rectangle where both dimensions are positive, since the boundaries of the intersection are axis aligned.

Thus, we can reduce the problem to the one-dimensional problem of determining whether two line segments overlap.

Say the area of the intersection is `width * height`, where `width` is the intersection of the rectangles projected onto the x-axis, and `height` is the same for the y-axis. We want both quantities to be positive.

The `width` is positive when `min(rec1[2], rec2[2]) > max(rec1[0], rec2[0])`, that is when the smaller of (the largest x-coordinates) is larger than the larger of (the smallest x-coordinates). The `height` is similar.

```JAVA
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
    }
}
```

- Time and Space Complexity: O(1)

