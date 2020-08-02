# 剑指 Offer 57. 和为s的两个数字

Two pointers.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else return new int[] {nums[lo], nums[hi]};
        }
        return new int[] {-1, - 1};
    }
}
```
