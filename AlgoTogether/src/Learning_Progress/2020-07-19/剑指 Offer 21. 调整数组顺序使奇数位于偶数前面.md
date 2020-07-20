# 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面

Two pointers.

`O(n) time, O(1) space.`

```java
class Solution {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 != 0) i++;
            while (i < j && nums[j] % 2 == 0) j--;
            if (i < j) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        return nums;
    }
}
```
