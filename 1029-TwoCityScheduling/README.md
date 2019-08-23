There are `2N` people a company is planning to interview. The cost of flying the `i`-th person to city `A` is `costs[i][0]`, and the cost of flying the `i`-th person to city `B` is `costs[i][1]`.

Return the minimum cost to fly every person to a city such that exactly `N` people arrive in each city.

---

> Input: [[10,20],[30,200],[400,50],[30,20]]
> Output: 110
> Explanation: 
> The first person goes to city A for a cost of 10.
> The second person goes to city A for a cost of 30.
> The third person goes to city B for a cost of 50.
> The fourth person goes to city B for a cost of 20.
>
> The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

---

```java
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();   
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for (int i = 0; i < costs.length; i++){
            int dif = costs[i][0] - costs[i][1];
            int sum = costs[i][0] + costs[i][1];
            minHeap.offer(dif);
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            if (map.get(dif) != null)
                arrayList = map.get(dif);
            arrayList.add(sum);
            map.put(dif,arrayList);
        }
        int sum = 0;
        for (int i = 0; i < costs.length/2; i++) {
            int mindif = minHeap.poll();
            ArrayList<Integer> arrayList = map.get(mindif);
            int minsum = arrayList.get(0);
            int a = (mindif+minsum)/2;   
            if (arrayList.size()>1)
                arrayList.remove(0); 
            map.put(mindif,arrayList);
            sum += a;
        }
        for (int i = 0; i < costs.length/2; i++) {
            int mindif = minHeap.poll();
            ArrayList<Integer> arrayList = map.get(mindif);
            int minsum = arrayList.get(0);
            int b = -(mindif-minsum)/2;   
            if (arrayList.size()>1)
                arrayList.remove(0); 
            map.put(mindif,arrayList);
            sum += b;
        }
    return sum;   
    }
}
```

