Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

---

> Input: "Hello"
> Output: "hello"

---

```java
class Solution {
    public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }
}
```

