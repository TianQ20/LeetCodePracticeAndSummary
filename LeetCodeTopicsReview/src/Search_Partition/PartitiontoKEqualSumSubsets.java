package Search_Partition;

public class PartitiontoKEqualSumSubsets {
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0, maxNum = 0;
            for (int num : nums) {
                sum += num;
                maxNum = Math.max(num, maxNum);
            }

            if (sum % k != 0 || sum / k < maxNum) {
                return false;
            }
            return dfs(nums, k, new boolean[nums.length], sum / k, 0, 0);
        }

        private boolean dfs(int[] nums, int k, boolean[] visited, int target, int curSum, int start) {
            if (k == 0) {
                return true;
            }

            if (curSum == target) {
                return dfs(nums, k - 1, visited, target, 0, 0);
            }

            for (int i = start; i < nums.length; i++) {
                if (!visited[i] && curSum <= target) {
                    visited[i] = true;
                    if (dfs(nums, k, visited, target, curSum + nums[i], i + 1)) { // nested recursion
                        return true;
                    }
                    visited[i] = false;
                }
            }
            return false;
        }
    }
}
