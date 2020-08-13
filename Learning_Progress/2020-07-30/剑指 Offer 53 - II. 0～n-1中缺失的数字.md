# 剑指 Offer 53 - II. 0～n-1中缺失的数字

Count Sort: `O(n)`.

```java
class Solution {
    public int missingNumber(int[] nums) {
        int[] counter = new int[nums.length + 1];
        for (int num : nums) {
            counter[num]++;
        }

        for (int i = 0; i <= nums.length; i++) {
            if (counter[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
```

Binary Search.

```java
class Solution {
    public int missingNumber(int[] nums) {
        int lo = 0, hi = nums.length -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] != mid) { // [lo, mid - 1]
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return lo;
    }
}
```

## 268. Missing Number

**Unsorted array** with `O(n)` time, `O(1)` space.

The basic idea is to use XOR operation. We all know that `a^b^b = a`, which means two xor operations with the same number will eliminate the number and reveal the original number.

In this solution, we apply XOR operation to both the index and value of the array. In a complete array with no missing numbers, the index and value should be perfectly corresponding(`nums[index] = index`), so in a missing array, what left finally is the missing number.

```java
class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}
```
