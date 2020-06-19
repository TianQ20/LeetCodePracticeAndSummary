public class p10_2 {
    class Solution {
        public int numWays(int n) {
            int MOD = 1000000007;
            if (n <= 1) return 1;
            if (n == 2) return 2;
            if (n > 2) {
                int[] dp = new int[n + 1];
                dp[0] = 0;
                dp[1] = 1;
                dp[2] = 2;
                for (int i = 3; i < n + 1; i++) {
                    dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
                }
                return dp[n];
            }
            return -1;
        }
    }
}
