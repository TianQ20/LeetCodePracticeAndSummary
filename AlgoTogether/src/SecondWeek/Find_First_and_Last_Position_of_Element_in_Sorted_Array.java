package SecondWeek;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    class Solution_1 {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = findFirst(nums, target);
            result[1] = findLast(nums, target);
            return result;
        }

        private int findFirst(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            int idx = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else if (nums[mid] == target) {
                    idx = mid;
                    high = mid - 1; // move to left side [low ... mid - 1]
                }
            }
            return idx;
        }

        private int findLast(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            int idx = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else if (nums[mid] == target) {
                    idx = mid;
                    low = mid + 1; // move to right side [mid + 1 ... high]
                }
            }
            return idx;
        }
    }

    // follow up : one binary search
    class Solution_2 {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = find(nums, target, true);
            result[1] = find(nums, target, false);
            return result;
        }

        private int find(int[] nums, int target, boolean flag) {
            int low = 0, high = nums.length - 1;
            int idx = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else if (nums[mid] == target) {
                    idx = mid;
                    if (flag) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            return idx;
        }
    }
}
