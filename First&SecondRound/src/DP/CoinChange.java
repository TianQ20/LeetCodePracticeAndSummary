package DP;

import java.util.Arrays;

public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // bottom up
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); // F(3) = min{F(3-c1), F(3-c2), F(3-c3)} + 1
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
