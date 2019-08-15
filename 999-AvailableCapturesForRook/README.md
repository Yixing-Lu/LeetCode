On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.

The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.

Return the number of pawns the rook can capture in one move.

---

Search for the rock. From the rock, trace empty spaces in four directions. Return 1 if we hit a pawn, zero otherwise.

```java
int cap(char[][] b, int x, int y, int dx, int dy) {
  while (x >= 0 && x < b.length && y >= 0 && y < b[x].length && b[x][y] != 'B') {
    if (b[x][y] == 'p') 
      return 1;
    x += dx; 
    y += dy;
  }
  return 0;
}
public int numRookCaptures(char[][] b) {
  for (int i = 0; i < b.length; ++i)
    for (int j = 0; j < b[i].length; ++j)
      if (b[i][j] == 'R') 
        return cap(b,i,j,0,1)+cap(b,i,j,0,-1)+cap(b,i,j,1,0)+cap(b,i,j,-1,0);
  return 0;
}
```

Runtime: O(n), where n is the total number of cells. In the worst case, we need to check all cells to find the rock, and then check one row and one column.
Memory: O(1).