Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

---

> Input: [1,2], [1,2,3]
>
> Output: 2
>
> Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
> You have 3 cookies and their sizes are big enough to gratify all of the children, 
> You need to output 2.

---

```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int pointG = 0;
        int pointS = 0;
        
        while (pointG<g.length && pointS<s.length) {
            if (g[pointG]<=s[pointS]) {
                pointG++;
                pointS++;
            } 
          	else
                pointS++;
        }
        
        return pointG;
    }
}
```

