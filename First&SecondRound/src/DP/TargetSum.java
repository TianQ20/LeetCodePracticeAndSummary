package DP;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        // sum[p] - sum[n] = target
        // both side add sum[p] + sum[n]
        // 2*sum[p] = target + sum[nums] --> if (target + sum[nums]) % 2 != 0, return 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (S > sum || (S + sum) % 2 == 1) return 0;
        return subsetSum(nums, (S + sum) / 2);
    }

    private int subsetSum(int[] nums, int S) {
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[S];
    }
}
