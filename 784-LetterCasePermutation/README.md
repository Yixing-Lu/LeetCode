Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

---

> Input: S = "a1b2"
> Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

---

When I saw a problem, my first step is to draw a figure. See the figure below:
`abc`
`abc Abc` 0
`abc aBc Abc ABc` 1
`abc abC aBc aBC Abc AbC ABc ABC` 2

```java
class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;            
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
                
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        
        return new LinkedList<>(queue);
    }
}
```

