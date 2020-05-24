package SecondWeek;

public class Find_Peak_Element {
    class Solution {
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
