Given a fixed length array `arr` of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array **in place**, do not return anything from your function.

---

> Input: [1,0,2,3,0,4,5,0]
> Output: null
> Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

---

We can improve it to `O(N)` time and `O(1)` space.
Basically, we apply two pointers.
`i` is the position in the original array,
`j` is the position in the new array.
(the original and the new are actually the same array.)



The first we pass forward and count the zeros.
The second we pass backward and assign the value from original input to the new array.
so that the original value won't be overridden too early.

```JAVA
public void duplicateZeros(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) countZero++;
        }
        int len = arr.length + countZero;
        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) arr[j] = arr[i];
            } else {
                if (j < arr.length) arr[j] = arr[i];
                j--;
                if (j < arr.length) arr[j] = arr[i]; //copy twice when hit '0'
            }
        }
    }
```

Time O(n)

Space O(1)