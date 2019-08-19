Given an integer array with **even** length, where different numbers in this array represent different **kinds** of candies. Each number means one candy of the corresponding kind. You need to distribute these candies **equally** in number to brother and sister. Return the maximum number of **kinds** of candies the sister could gain.

---

> Input: candies = [1,1,2,3]
> Output: 2
> Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
> The sister has two different kinds of candies, the brother has only one kind of candies. 

---

**Approach 1 Brute Force**

firstly we need to observe one point. The maximum no. of unique candies which the girl can obtain could be atmost n/2*n*/2, where n*n* refers to the number of candies. Further, in case the number of unique candies are below n/2*n*/2, to maximize the number of unique candies that the girl will obtain, we'll assign all the unique candies to the girl. Thus, in such a case, the number of unique candies the girl gets is equal to the total number of unique candies in the given candies*c**a**n**d**i**e**s* array.

Now, let's look at the idea behind this approach. We need to find the total number of unique candies in the given candies*c**a**n**d**i**e**s* array. One way to find the number of unique candies is to traverse over the given candies*c**a**n**d**i**e**s* array. Whenever we encounter an element, say candies[j]*c**a**n**d**i**e**s*[*j*], we can mark all the elements which are the same as candies[j]*c**a**n**d**i**e**s*[*j*] as invalid and increment the count of unique elements by 1.

Thus, we need to do such markings for all the elements of candies*c**a**n**d**i**e**s*array. At the end, count*c**o**u**n**t* gives the required number of unique candies that can be given to the girl. Further, the value to be returned is given by: \text{min}(\frac{n}{2}, count)min(2*n*,*c**o**u**n**t*). Instead of finding the \text{min}min, we can stop the traversal over the given candies*c**a**n**d**i**e**s* array as soon as the count*c**o**u**n**t* exceeds \frac{n}{2}2*n*.

```java
public class Solution {
    public int distributeCandies(int[] candies) {
        int count = 0;
        for (int i = 0; i < candies.length && count < candies.length / 2; i++) {
            if (candies[i] != Integer.MIN_VALUE) {
                count++;
                for (int j = i + 1; j < candies.length; j++) {
                    if (candies[j] == candies[i])
                        candies[j] = Integer.MIN_VALUE;
                }
            }
        }
        return count;
    }
}
```

Time complexity : O(n^2).

Space complexity : O(1)

---

**Approach 2 Sort**

We can sort the given candies*c**a**n**d**i**e**s* array and find out the elements which are unique by comparing the adjacent elements of the sorted array. For every new element found(which isn't the same as the previous element), we need to update the count*c**o**u**n**t*. At the end, we can return the required result as \text{min}(n/2, count)min(*n*/2,*c**o**u**n**t*), as discussed in the previous approach.

```java
public class Solution {
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++)
            if (candies[i] > candies[i - 1])
                count++;
        return count;
    }
}
```

- Time complexity : O(n\log n). Sorting takes O(n\log n) time.
- Space complexity : O(1). Constant space is use

---

**Approach 3 Set**

Another way to find the number of unique elements is to traverse over all the elements of the given candies*c**a**n**d**i**e**s* array and keep on putting the elements in a set. By the property of a set, it will contain only unique elements. At the end, we can count the number of elements in the set, given by, say count*c**o**u**n**t*. The value to be returned will again be given by \text{min}(count, n/2)min(*c**o**u**n**t*,*n*/2), as discussed in previous approaches. Here, n*n* refers to the size of the candies*c**a**n**d**i**e**s* array.

```java
public class Solution {
    public int distributeCandies(int[] candies) {
        HashSet < Integer > set = new HashSet < > ();
        for (int candy: candies)
            set.add(candy);
        return Math.min(set.size(), candies.length / 2);
    }
}
```

- Time complexity : O(n). 
- Space complexity : O(n). set will be of size n in the worst case.