Given a non-empty string `s`, you may delete **at most** one character. Judge whether you can make it a palindrome.

---

> Input: "abca"
> Output: True
> Explanation: You could delete the character 'c'.

---



```java
public boolean validPalindrome(String s) {
    int l = -1, r = s.length();
    while (++l < --r) 
        if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
    return true;
}

public boolean isPalindromic(String s, int l, int r) {
    while (++l < --r) 
        if (s.charAt(l) != s.charAt(r)) return false;
    return true;
}
```

