There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot **ends up at (0, 0)** after it completes its moves.

The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.

---

> Input: "UD"
> Output: true 
> Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.

----

Initially, the robot is at `(x, y) = (0, 0)`. If the move is `'U'`, the robot goes to `(x, y-1)`; if the move is `'R'`, the robot goes to `(x, y) = (x+1, y)`, and so on.

```JAVA
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
```

- Time Complexity: O(N), where N is the length of `moves`. We iterate through the string.
- Space Complexity: *O*(*N*).