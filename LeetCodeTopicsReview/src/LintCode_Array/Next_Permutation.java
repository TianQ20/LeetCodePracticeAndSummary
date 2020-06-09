package LintCode_Array;

import java.util.Arrays;

public class Next_Permutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            int replace = nums.length - 2;
            while (replace >= 0) {
                if (nums[replace] < nums[replace + 1]) break;
                replace--;
            }

            if (replace < 0) {
                Arrays.sort(nums);
                return;
            }

            int largerIdx = replace + 1;
            while (largerIdx < nums.length && nums[largerIdx] > nums[replace]) {
                largerIdx++; // sorted after the replace index
            }
            // swap the largerIdx - 1 element
            int tmp = nums[replace];
            nums[replace] = nums[largerIdx - 1];
            nums[largerIdx - 1] = tmp;
            // sort after replace index
            Arrays.sort(nums, replace + 1, nums.length);
        }
    }
}
