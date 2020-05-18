package SecondWeek;

import java.util.Arrays;

public class Find_Minimum_in_Rotated_Sorted_Array {
    /**
     Sort: O(nlogn)
     */
    class Solution_1 {
        public int findMin(int[] nums) {
            Arrays.sort(nums);
            return nums[0];
        }
    }

    /**
     Linear search: O(n)
     */
    class Solution_2 {
        public int findMin(int[] nums) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                min = Math.min(min, nums[i]);
            }
            return min;
        }
    }

    /**
     Two pointers: O(n/2) -> O(n)
     */
    class Solution_3 {
        public int findMin(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int start = 0, end = nums.length - 1;
            int min = Integer.MAX_VALUE;
            while (start <= end) { // after they overlap, break
                min = Math.min(min, Math.min(nums[start], nums[end]));
                start++;
                end--;
            }
            return min;
        }
    }

    /**
     Binary search: O(logn)
     Requirements: (1) If rotate, nums[min] < nums[min - 1]; (2) If not, nums[0]
     */
    class Solution_4 {
        public int findMin(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int start = 0, end = nums.length - 1;
            while (start < end) {
                if (nums[start]<nums[end]) { // early break
                    return nums[start];
                }

                int mid = start + (end - start) / 2;
                if (nums[mid] >= nums[start]) { // rotation in second half array
                    start = mid + 1;
                } else { //rotation in first half array
                    end = mid;
                }
            }
            return nums[start];
        }
    }

    /**
     * Time to use "<" or "<="
     *
     * You use while (start <= end) if you are returning the match from inside the loop.
     *
     * You use while (start < end) if you want to exit out of the loop first,
     * and then use the result of start or end to return the match.
     */
}
