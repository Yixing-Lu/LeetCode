Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be **any** subsequence of the other strings.

A **subsequence** is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

---

> Input: "aba", "cdc"
> Output: 3
> Explanation: The longest uncommon subsequence is "aba" (or "cdc"), 
> because "aba" is a subsequence of "aba", 
> but not a subsequence of any other strings in the group of two strings. 

---

These three cases are possible with string a*a* and b*b*:-

- a=b*a*=*b*. If both the strings are identical, it is obvious that no subsequence will be uncommon. Hence, return -1.
- length(a)=length(b) and a \ne b*a*\\=*b*. Example: abc*a**b**c* and abd*a**b**d*. In this case we can consider any string i.e. abc*a**b**c* or abd*a**b**d* as a required subsequence, as out of these two strings one string will never be a subsequence of other string. Hence, return length(a)*l**e**n**g**t**h*(*a*) or length(b)*l**e**n**g**t**h*(*b*).
- length(a) \ne length(b)*l**e**n**g**t**h*(*a*)\\=*l**e**n**g**t**h*(*b*). Example abcd*a**b**c**d* and abc*a**b**c*. In this case we can consider bigger string as a required subsequence because bigger string can't be a subsequence of smaller string. Hence, return max(length(a),length(b))*m**a**x*(*l**e**n**g**t**h*(*a*),*l**e**n**g**t**h*(*b*)).

```java
public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
}
```

