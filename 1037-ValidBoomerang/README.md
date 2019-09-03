A *boomerang* is a set of 3 points that are all distinct and **not** in a straight line.

Given a list of three points in the plane, return whether these points are a boomerang.

---

> Input: [[1,1],[2,3],[3,2]]
> Output: true

---

Assuming three points are A, B, C.

The first idea is that, calculate the area of ABC.
We can reuse the conclusion and prove in 812. Largest Triangle Area

The other idea is to calculate the slope of AB and AC.
K_AB = (p[0][0] - p[1][0]) / (p[0][1] - p[1][1])
K_AC = (p[0][0] - p[2][0]) / (p[0][1] - p[2][1])

We check if K_AB != K_AC, instead of calculate a fraction.

```java
public boolean isBoomerang(int[][] p) {
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }
```



Time O(1) Space O(1)

