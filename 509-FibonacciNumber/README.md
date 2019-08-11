The **Fibonacci numbers**, commonly denoted `F(n)` form a sequence, called the **Fibonacci sequence**, such that each number is the sum of the two preceding ones, starting from `0` and `1`

---

```
Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
```

---

**Approach 1 Iterative**

```java
class Solution 
{
    public int fib(int N)
    {
        if(N <= 1)
            return N;
    
				int a = 0, b = 1;
		
				while(N > 1){
					int sum = a + b;
					a = b;
					b = sum;
          N --;
		}
        return b;
    }
}
```

Time complexity: `O(n)`
Space complexity: `O(1)`

---

**Approach 2 Recursive**

```java
class Solution 
{
    public int fib(int N)
    {
        if(N <= 1)
            return N;
        else
            return fib(N - 1) + fib(N - 2);
    }
}
```

Time complexity: `O(2^n)`- since `T(n) = T(n-1) + T(n-2)`is an exponential time
Space complexity: `O(n)` - space for recursive function call stack

---

**Approach 3 Dynamic Programming - Top Down Approach**

```java
class Solution 
{
    int[] fib_cache = new int[31];
		public int fib(int N)
    {
    		if(N <= 1)
            return N;
        else if (fib_cache[N] != 0)
            return fib_cache[N];
				else 
            return fib_cache[N] = fib(N - 1) + fib(N - 2);
    }
}
```

Time complexity: `O(n)`
Space complexity: `O(n)`

---

**Approach 4 Dynamic Programming - Bottom Up Approach**

```java
class Solution 
{
    public int fib(int N)
    {
        if(N <= 1)
            return N;
				int[] fib_cache = new int[N + 1];
				fib_cache[1] = 1;

				for(int i = 2; i <= N; i++)
					fib_cache[i] = fib_cache[i - 1] + fib_cache[i - 2];
      
				return fib_cache[N];
    }
}
```

Time complexity: `O(n)`
Space complexity: `O(n)`

