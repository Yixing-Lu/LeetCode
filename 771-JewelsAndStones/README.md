You're given strings `J` representing the types of stones that are jewels, and `S` representing the stones you have.  Each character in `S` is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in `J` are guaranteed distinct, and all characters in `J` and `S` are letters. Letters are case sensitive, so `"a"` is considered a different type of stone from `"A"`.

---

> Input: J = "aA", S = "aAAbbbb"
> Output: 3

---

1. read `J` and build jewels hash set.
2. read `S` and count jewels.

```java
public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set setJ = new HashSet();
        for (char j: J.toCharArray()) 
          setJ.add(j);
        for (char s: S.toCharArray()) 
          if (setJ.contains(s)) 
            res++;
        return res;
    }
```

Time **O(M+N)**

