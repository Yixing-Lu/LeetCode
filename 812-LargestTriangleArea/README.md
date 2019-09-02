You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.

---

> Example:
> Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
> Output: 2
> Explanation: 
> The five points are show in the figure below. The red triangle is the largest.

---

We will have 3 for loops to cycle through each choice of 3 points in the array.

After, we'll need a function to calculate the area given 3 points. Here we have some options:

- We can use the Shoelace formula directly, which tells us the area given the 3 points;

```JAVA
class Solution {
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                for (int k = j+1; k < N; ++k)
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
        return ans;
    }

    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                             -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }
}
```

