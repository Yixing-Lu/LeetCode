Given words `first` and `second`, consider occurrences in some `text` of the form "`first second third`", where `second` comes immediately after `first`, and `third` comes immediately after `second`.

For each such occurrence, add "`third`" to the answer, and return the answer.

---

> Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
> Output: ["girl","student"]

---

Split the `text` into `words` array, then loop through it to check if previous two words are `first` and `second`; If yes, add current word into list.

```java
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < words.length; ++i)
            if (first.equals(words[i - 2]) && second.equals(words[i - 1]))
                ans.add(words[i]);
        return ans.toArray(new String[0]);
    }
}
```

---

**Note String**

string1.equals(string2) 判断两个string是否相等

List<String> ans = new ArrayList<>();  ans.toArray(new String[0])将ArrayList转换为String