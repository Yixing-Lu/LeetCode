Given a string *s* consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word in the string.

If the last word does not exist, return 0.

**Note:** A word is defined as a character sequence consists of non-space characters only.

---

```JAVA
public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
}
```

it scans the string backwards from the tail. At first, the length of the last word is set to be zero. If a whitespace is found, we check if it is a trailing whitespace. If it is not a trailing whitespace (i.e. the length is not zero any more), we return the length. If it is a trailing whitespace (i.e. the length is zero), we continue the scan.

```JAVA
public class Solution {
    public int lengthOfLastWord(String s) {
    int len=0;
    for(int i=s.length()-1;i>=0;i--){
        if(s.charAt(i)==' '){
            //If it is not a trailing space, return the length.
           if(len!=0) return len;
        }else{
           len++;
        }
    }
    return len;
}
```



