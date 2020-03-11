package DP;

import java.util.Arrays;

public class CoinChange {
    class Solution1 { // Bottom Up
        public int coinChange(int[] coins, int amount) {
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



    class Solution2 { // Top Down
        public int coinChange(int[] coins, int amount) {
            if (amount < 1) return 0;
            return coinChange(coins, amount, new int[amount]);
        }

        private int coinChange(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
            if (rem < 0) return -1; // not valid
            if (rem == 0) return 0; // completed
            if (count[rem - 1] != 0) { // already computed, so reuse
                return count[rem - 1];
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min) {
                    min = 1 + res;
                }
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }
    }

/*

Suppose we have already found out the best way to sum up to amount a,
then for the last step, we can choose any coin type which gives us a remainder r where r = a - coins[i] for all i's.
For every remainder, go through exactly the same process as before until either the remainder is 0 or less than 0 (meaning not a valid solution).
With this idea, the only remaining detail is to store the minimum number of coins needed to sum up to r so that we don't need to recompute it over and over again.

*/
}
