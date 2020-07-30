# 剑指 Offer 53 - I. 在排序数组中查找数字 I && 34. Find First and Last Position of Element in Sorted Array

Binary Search.

```java
class Solution {
    public int search(int[] nums, int target) {
        int first = find(nums, target, true);
        int last = find(nums, target, false);
        return (first == last && last == - 1) ? 0 : last - first + 1;
    }

    private int find(int[] nums, int target, boolean flag) {
        int lo = 0, hi = nums.length - 1;
        int idx = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] == target) {
                idx = mid;
                if (flag) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return idx;
    }
}
```

Find the right border.

```java
class Solution {
    public int search(int[] nums, int target) {
        return find(nums, target) - find(nums, target - 1);
    }

    private int find(int[] nums, int target) { // find the right border
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
```

34.Find First and Last Position of Element in Sorted Array

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        int lo = 0, hi = n - 1;
        // Search for the left one
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else hi = mid;
        }
        if (nums[lo] != target) {
            return res;
        } else {
            res[0] = lo;
        }
        // Search for the right one
        hi = n - 1; // We don't have to set i to 0 the second time.
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2; // make mid right biased
            if (nums[mid] > target) {
                hi = mid - 1;
            } else lo = mid;
        }
        res[1] = hi;
        return res;
    }
}
```
