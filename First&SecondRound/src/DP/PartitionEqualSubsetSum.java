package DP;

public class PartitionEqualSubsetSum {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            // early break
            if (sum % 2 != 0) return false;
            sum /= 2;
            for (int n : nums) {
                if (n > sum) return false;
            }

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;

            // if we take the num, then we need to find whether the (new sum = i - num) can be constructed.
            for (int num : nums) {
                for (int i = sum; i >= num; i--) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
            return dp[sum];
        }
    }
}
