Count the number of prime numbers less than a non-negative number, **n**.

---

> Input: 10
> Output: 4
> Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

---

```java
class Solution {
    public int countPrimes(int n) {
        if(n <= 1) 
            return 0;
    
        boolean[] Prime = new boolean[n];        
        Arrays.fill(Prime, Boolean.TRUE);
      
        Prime[0] = false;
        Prime[1] = false;
        for(int i = 2; i < Math.sqrt(n); i++){
            if(Prime[i]){
                for(int j = 2; j*i < n; j++){
                    Prime[i*j] = false; 
            }
        }
    }
    
    int count = 0; 
    for(int i = 2; i< Prime.length; i++){
        if(Prime[i]) 
            count++;
    }
    return count; 
}
}

```

Time: O(nlog(n))

---

**Note boolean**

boolean默认初始化为false。

```java
boolean[] Prime = new boolean[n];        
Arrays.fill(Prime, Boolean.TRUE);
```

