Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

---

> Input: "A man, a plan, a canal: Panama"
> Output: true

---

```java
public class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
```

```java
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
        	return true;
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead))
        		head++;
        	else if(!Character.isLetterOrDigit(cTail))
        		tail--;
        	else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail))
        			return false;
        		head++;
        		tail--;
        	}
        }
        return true;
    }
}
```

---

**Note**

```java
s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();//将非字母和数字的字符替换为空，并转为小写字母
```

```java
StringBuffer(actual).reverse().toString();//创建StringBuffer，后翻转字符串，最后转为string
```

```java
Character.isLetterOrDigit(c);//判断字符c是否为数字或字母
```

