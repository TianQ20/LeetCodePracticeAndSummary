package DP;

public class DominoAndTrominoTiling {
    class Solution {
        public int numTilings(int N) {
            int kMod = 1000000007;
            long[][] dp = new long[N + 1][2];
            dp[0][0] = dp[1][0] = 1;
            for (int i = 2; i <= N; ++i) {
                dp[i][0] = (dp[i-1][0] + dp[i - 2][0] + 2 * dp[i-1][1]) % kMod;
                dp[i][1] = (dp[i - 2][0] + dp[i - 1][1]) % kMod;
            }
            return (int)dp[N][0];
        }
    }
}
