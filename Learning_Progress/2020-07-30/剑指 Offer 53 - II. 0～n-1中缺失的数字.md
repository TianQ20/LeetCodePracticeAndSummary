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
