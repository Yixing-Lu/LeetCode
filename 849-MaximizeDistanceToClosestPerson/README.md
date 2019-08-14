In a row of `seats`, `1` represents a person sitting in that seat, and `0`represents that the seat is empty. 

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to closest person.

---

>Input: [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.

---

**Approach 1 Group by Zero**

For each group of `K` empty seats between two people, we can take into account the candidate answer `(K+1) / 2`.

For groups of empty seats between the edge of the row and one other person, the answer is `K`, and we should take into account those answers too.

```java
class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int K = 0; //current longest group of empty seats
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) 
                K = 0;
          	else {
                K++;
                ans = Math.max(ans, (K + 1) / 2);
            }
        }

        for (int i = 0; i < N; ++i)  
          	if (seats[i] == 1) {
            	ans = Math.max(ans, i);
            	break;
        		}

        for (int i = N-1; i >= 0; --i)  
          	if (seats[i] == 1) {
            	ans = Math.max(ans, N - 1 - i);
            	break;
        		}

        return ans;
    }
}
```

- Time Complexity: O(N), where N is the length of `seats`.
- Space Complexity: O(1). 

---

**Approach 2 Next Array**

Let `left[i]` be the distance from seat `i` to the closest person sitting to the left of `i`. Similarly, let `right[i]` be the distance to the closest person sitting to the right of `i`. This is motivated by the idea that the closest person in seat `i` sits a distance `min(left[i], right[i])`away.

To construct `left[i]`, notice it is either `left[i-1] + 1` if the seat is empty, or `0` if it is full. `right[i]` is constructed in a similar way.

```java
class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) 
              left[i] = 0;
            else if (i > 0) // special case when i = 0
              left[i] = left[i-1] + 1;
        }

        for (int i = N-1; i >= 0; --i) {
            if (seats[i] == 1) 
              right[i] = 0;
            else if (i < N-1) 
              right[i] = right[i+1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        return ans;
    }
}

```

- Time Complexity: O(N), where N*N* is the length of `seats`.
- Space Complexity: O(N), the space used by `left` and `right`.