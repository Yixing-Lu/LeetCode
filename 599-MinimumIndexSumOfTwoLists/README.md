Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their **common interest** with the **least list index sum**. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

---

> Input:
> ["Shogun", "Tapioca Express", "Burger King", "KFC"]
> ["KFC", "Shogun", "Burger King"]
> Output: ["Shogun"]
> Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

---

**Approach 1 HashMap**

In this approach, we compare every string in list1 and list2 by traversing over the whole list list2 for every string chosen from list1. We make use of a hashmap map, which contains elements of the form (sum : list_{sum}). Here, sum refers to the sum of indices of matching elements and list_{sum} refers to the list of matching strings whose indices' sum equals sum.

```java
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap < Integer, List < String >> map = new HashMap < > ();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j))
                        map.put(i + j, new ArrayList < String > ());
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int min_index_sum = Integer.MAX_VALUE;
        for (int key: map.keySet())
            min_index_sum = Math.min(min_index_sum, key);
        String[] res = new String[map.get(min_index_sum).size()];
        return map.get(min_index_sum).toArray(res);
    }
}
```

- Time complexity : O(l1*l2*x)
- Space complexity : O(l1*l2*x)

---

**Approach 2 HashMap (linear)**

Firstly, we traverse over the whole list1 and create an entry for each element of list1 in a HashMap map, of the form (list[i], i). Here, i** refers to the index of the i^{th}*i**t**h* element, and list[i]*l**i**s**t*[*i*] is the i^{th}*i**t**h* element itself. Thus, we create a mapping from the elements of list1*l**i**s**t*1 to their indices.

Now, we traverse over list2*l**i**s**t*2. For every element ,list2[j]*l**i**s**t*2[*j*], of list2*l**i**s**t*2encountered, we check if the same element already exists as a key in the map*m**a**p*. If so, it means that the element exists in both list1*l**i**s**t*1 and list2*l**i**s**t*2. Thus, we find out the sum of indices corresponding to this element in the two lists, given by sum = map.get(list[j]) + j*s**u**m*=*m**a**p*.*g**e**t*(*l**i**s**t*[*j*])+*j*. If this sum*s**u**m* is lesser than the minimum sum obtained till now, we update the resultant list to be returned, res*r**e**s*, with the element list2[j]*l**i**s**t*2[*j*] as the only entry in it.

---

```java
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap < String, Integer > map = new HashMap < String, Integer > ();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        List < String > res = new ArrayList < > ();
        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum)
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
```

Time complexity : O(l_1+l_2).

Space complexity : O(l_1*x).