package DP;

public class DeleteAndEarn {
    class Solution {
        public int deleteAndEarn(int[] nums) {

            // sum[i] = Max(sum[i-1], sum[i-2] + sum[i])

            // similar to the House Robber problem, can not use the near two elements(can not robber two neighbor house).
            // Noticed that duplicate element can not be deleted, since the first time we have removed their neighbir.
            // So use bucket sort to store them in to array sum.

            int[] sum = new int[10002];
            for (int i = 0; i < nums.length; i++) {
                sum[nums[i]] += nums[i];
            }

            for (int i = 2; i < sum.length; i++) {
                sum[i] = Math.max(sum[i - 1], sum[i - 2] + sum[i]);
            }
            return sum[10001];
        }
    }
}