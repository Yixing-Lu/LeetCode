In a list of songs, the `i`-th song has a duration of `time[i]` seconds. 

Return the number of pairs of songs for which their total duration in seconds is divisible by `60`.  Formally, we want the number of indices `i < j` with `(time[i] + time[j]) % 60 == 0`.

---

> Input: [30,20,150,100,40]
> Output: 3
> Explanation: Three pairs have a total duration divisible by 60:
> (time[0] = 30, time[2] = 150): total duration 180
> (time[1] = 20, time[3] = 100): total duration 120
> (time[1] = 20, time[4] = 40): total duration 60

---

we want to know that, for each `t`, how many `x` satisfy `(t + x) % 60 = 0`.

`(60 - t % 60) % 60` can get number in range **0 ~ 59**, which is what we want.

```JAVA
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int d = (60 - t % 60) % 60;
            // get the number if adding t equals to a multiple of 60.
            ans += count.getOrDefault(d, 0); 
            // update the number of t % 60.
            count.put(t % 60, 1 + count.getOrDefault(t % 60, 0)); 
        }
        return ans;
    }
}
```

