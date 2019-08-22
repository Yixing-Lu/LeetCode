You are climbing a stair case. It takes *n* steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

----

> Input: 2
> Output: 2
> Explanation: There are two ways to climb to the top.
>
> 1 step + 1 step
>
> 2 steps
>
> ----
>
> Input: 3
> Output: 3
> Explanation: There are three ways to climb to the top.
> 1. 1 step + 1 step + 1 step
> 2. 1 step + 2 steps
> 3. 2 steps + 1 step

---

**Approach 1 Recursion**

 At every step we are calling the function climbStairs for step 1 and 2, and return the sum of returned values of both functions.

climbStairs(i,n)=climbStairs(i + 1, n) + climbStairs(i + 2, n)

where i defines the current step and n defines the destination step.

```java
public class Solution {
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }
    public int climb_Stairs(int i, int n) {
        if (i > n)
            return 0;
        if (i == n)
            return 1;
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}
```

Time complexity : $O(2^n)$.

Space complexity : O(n)

----

**Approach 2 Reursion with Memorization**

In the previous approach we are redundantly calculating the result for every step. Instead, we can store the result at each step in memo array and directly returning the result from the memo array whenever that function is called again.

In this way we are pruning recursion tree with the help of memo array and reducing the size of recursion tree upto n.

```java
public class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) 
            return 0;
        if (i == n) 
            return 1;
        if (memo[i] > 0) 
            return memo[i];
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}
```

Time complexity : O(n)

Space complexity : O(n)

---

**Approach 3 Dynamic Programming**

As we can see this problem can be broken into subproblems, and it contains the optimal substructure property i.e. its optimal solution can be constructed efficiently from optimal solutions of its subproblems, we can use dynamic programming to solve this problem.

One can reach $i^{th}$ step in one of the two ways:

1. Taking a single step from $(i-1)^{th}$ step.
2. Taking a step of 2 from $(i-2)^{th}$ step.

So, the total number of ways to reach i^{th}*i**t**h* is equal to sum of ways of reaching $(i-1)^{th}$ step and ways of reaching $(i-2)^{th}$ step.

Let dp[i]*d**p*[*i*] denotes the number of ways to reach on $i^{th}$ step:

dp[i]=dp[i-1]+dp[i-2]

```java
public class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}
```

Time complexity : O(n)

Space complexity : O(n)

---

**Approach 4 Dynamic Programming with O(1) Space**

In the above approach we have used dp array where dp[i]=dp[i-1]+dp[i-2]

Now we just have to find $n^{th}$ number of the fibonacci series having 1 and 2 their first and second term respectively,

```java
public class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
```

Time complexity : O(n)

Space complexity : O(1)

---

