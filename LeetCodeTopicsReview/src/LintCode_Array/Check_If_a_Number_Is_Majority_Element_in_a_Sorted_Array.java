package LintCode_Array;

public class Check_If_a_Number_Is_Majority_Element_in_a_Sorted_Array {
    class Solution_1 { // Assume all test cases have a valid majority element
        public boolean isMajorityElement(int[] nums, int target) {
            return nums[(nums.length + 1) / 2 - 1] == target ? true : false;
        }
    }

    class Solution_2 { // General case: O(logn)
        public boolean isMajorityElement(int[] nums, int target) {
            int firstIdx = firstOccur(nums, target);
            int idxPlusNBy2 = firstIdx + nums.length / 2;
            if (idxPlusNBy2 < nums.length && nums[idxPlusNBy2] == target) {
                return true;
            }
            return false;
        }

        private int firstOccur(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
