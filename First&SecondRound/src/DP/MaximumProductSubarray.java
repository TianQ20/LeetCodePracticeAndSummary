package DP;

public class MaximumProductSubarray {
    class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE, imax = 1, imin = 1; // when we just choose single element, imax and imin should be 1, since 1 * nums[i] = nums[i]
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    // swap(imax, imin);
                    int tmp = imax;
                    imax = imin;
                    imin = tmp;
                }

                // when nums[i] < 0, then the imax would be imin this time, since the max number times a negative number will be the min number.
                // max/min product for the current number is either the current number itself
                // or the max/min by the previous number times the current one

                imax = Math.max(nums[i], imax * nums[i]);
                imin = Math.min(nums[i], imin * nums[i]);
                max = Math.max(max, imax);
            }
            return max;
        }
    }
}
