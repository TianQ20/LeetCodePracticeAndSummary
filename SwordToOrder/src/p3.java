public class p3 {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            int n = nums.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[nums[i]] += 1;
                if (arr[nums[i]] > 1) {
                    return nums[i];
                }
            }
            return -1;
        }
    }
}
