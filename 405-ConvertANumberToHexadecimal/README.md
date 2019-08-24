Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, [two’s complement](https://en.wikipedia.org/wiki/Two's_complement) method is used.

---

> Input:
> 26
>
> Output:
> "1a"

---

Basic idea: each time we take a look at the last four digits of binary verion of the input, and maps that to a hex char shift the input to the right by 4 bits, do it again until input becomes 0.

```JAVA
public class Solution {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }
}
```

