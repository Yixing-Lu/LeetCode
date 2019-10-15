# Basic

### Numbers

```java
Integer, Double, Float, Long, Short
Integer num1 = 1, num2 = 2;
Integer.MIN_VALUE
Integer.MAX_VALUE
num1.compareTo(nums2); // return 1 if num1 > num2
num1.equals(nums2) // boolean
// String to Integer
Integer.valueOf("17") // Integer
int a = Integer.parseInt("9") // int
int a_2 = Integer.parseInt("9",2) // int, based is 2
// Integer to String
str s = num1.toString()
// math
double pow(double base, double exponent)
double sqrt(double d)
0.0 =< Math.random() < 1.0
```

---

### Character

```java
char[] charArray ={ 'a', 'b', 'c', 'd', 'e' };
boolean isLetter(char ch)
boolean isDigit(char ch)
boolean isWhitespace(char ch)
boolean isUpperCase(char ch)
boolean isLowerCase(char ch)
char toUpperCase(char ch)
char toLowerCase(char ch)
String toString(char ch)
```

---

### String

```java
String str = "hello, world";
int len = str.length()
char charAt(int index)
char[] toCharArray()
// equal
boolean equals(Object anObject)
// substring
String substring(int beginIndex)
String substring(int beginIndex, int endIndex) // [begin, end)
// index
int indexOf(int ch/String str) // -1 if not exist
int indexOf(int chString str, int fromIndex)
//compare
int dif = str1.compareTo(str2) // return the value str1 - str2, 'A' - 'a' = -32

boolean endsWith(String str)
boolean startsWith(String prefix)
// split
String[] split(String regex, int limit) // limit限制分割次数 多个分隔符用 |; //. //| //*

String toLowerCase()
String toUpperCase()
String trim()
```

---

### StringBuilder

```java
StringBuilder sb = new StringBuilder();
// same as String
int sb.length()
char sb.charAt()
String sb.subString(int start)
String sb.subString(int start, int end)
int indexOf(int ch/String str)
// useful
String res = sb.toString()
sb.append()
sb.delete(int start, int end) // [start, end)
sb.reverse()
sb.insert(int offset, char c)
```

---

### HashMap

```java
HashMap< String, String> map = new HashMap< String, String>();
put(key, value) // will replace old value
V get(key) // return null if not exist
V getOrDefault(key, V defaultValue)
boolean containsKey(key)
boolean containsValue(value)
// ---------------------------------------------------------//
isEmpty()
size()
remove()
clear()
```

---

### HashSet

```java
HashSet<String> hashSet = new HashSet<String>();
add()
remove()
contains()
// ------inherited from interface java.util.Collection------//
isEmpty()
size()
clear()
toArray()
iterator()
```

---

### Array

```java
int[] num = new int[6];
int[] num2 = {1,2,3};
num.length;
// sort
Arrays.sort(num);
Arrays.sort(B, Comparator.comparingInt(Math::abs));// sort by abs
// clone
int[] sorted = num.clone();
```

------

### ArrayList

```java
List<Integer> list = new ArrayList<Integer>();
List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(2,3,4));
list.add(i)
list.size()
list.get(index)
Collections.sort(list)
```

---

### LinkedList

```java
List<List<Integer>> list = new LinkedList<List<Integer>>();
List<Integer> sub = new LinkedList<Integer>();
sub.add(1);
sub.add(2);
list.add(0, sub);
```

------

### Queue

```java
// 通过LinkedList实现
Queue<String> queue = new LinkedList<String>();
offer()
poll() 
peak()
// ------inherited from interface java.util.Collection------//
isEmpty()
size()
remove()
clear()
toArray()
contains()
iterator()
```

### PriorityQueue

```java
PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> (a - b)); // 升序
offer()
poll() 
peak()
// ------inherited from interface java.util.Collection------//
isEmpty()
size()
remove()
clear()
toArray()
contains() 
iterator()
```

------

### Stack

```java
Stack<Integer> st = new Stack<Integer>();
push()
pop() 
peak()
// ------inherited from interface java.util.Collection------//
isEmpty()
size()
remove()
clear()
toArray()
contains() 
iterator()
```

------

### Iterator

```java
Iterator<String> iterator = hashSet.iterator();
while (iterator.hasNext())
　　String next = iterator.next()
```

---

### Scanner

```java
Scanner scan = new Scanner(System.in);
// next 以空格为结束
if (scan.hasNext())
String str1 = scan.next();
// nextLine 以换行符为结束
if (scan.hasNextLine())
String str2 = scan.nextLine()
scan.close();
```

# Algorithm

---

### BFS

**Time**: $O(N)$

**Space**: 

```java
public void bfs(TreeNode root) {
  Queue<TreeNode> queue = new LinkedList<TreeNode>();
  queue.offer(root);
  while(!queue.isEmpty()){
    int levelNum = queue.size();
    for(int i=0; i<levelNum; i++) {
      if(queue.peek().left != null) 
        queue.offer(queue.peek().left);
      if(queue.peek().right != null) 
        queue.offer(queue.peek().right);
      queue.poll();
    }
  }
}
```

---

### DFS

**Time**: $ O(N) $

**Space**: recursion stack.

$O(log(N))$ in the best case of completely balanced tree

$O(N)$ in the worst case of completely unbalanced tree

```java
public void dfs(TreeNode root) {
  if (root == null)
    return;
  dfs(root.left);
  dfs(root.right);
}
```

---

### Binary Search

**Time**: $O(NlogN)$

**Space**: $O(1)$

```java
public int search(int[] nums, int target) {
  int left = 0;
  int right = nums.length - 1;
  while (left <= right) {
    int pivot = left + (right - left) / 2;
    if (nums[pivot] == target)
      return pivot;
    else if (nums[pivot] > target)
      right = pivot - 1;
    else
      left = pivot + 1;
  }
}
```

```java
public int search(int[] nums, int target) {
  int left = 0;
  int right = nums.length - 1;
  while (left < right) {
    int pivot = left + (right - left) / 2;
    if (nums[pivot] > target)
      right = pivot;
    else
      left = pivot + 1;
  }
  return left;
}
```

------

### BackTrack

**Time**: $O(2^N)$

**Space**: $O(N)$ : height of tree

```java
private static backtrack(int x, StringBuilder sb, boolean[] visited, int count) {
  	// current step
    String str = "1234";
    sb.append(str);
  	visited[x] = true;
    count++;
  
    // future steps
    backtrack(x + 1, sb, visited, count);
  	backtrack(x + 2, sb, visited, count);
  
    // recover current step
    sb.delete(sb.length() - str.length(), sb.length());
  	visited[x] = false;
  	count--;
  }
```

