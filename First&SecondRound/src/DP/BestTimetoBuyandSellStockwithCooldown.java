package DP;

public class BestTimetoBuyandSellStockwithCooldown {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n <= 1) return 0;
            int[] s0 = new int[n];
            int[] s1 = new int[n];
            int[] s2 = new int[n];
            s0[0] = 0;
            s1[0] = -prices[0];
            s2[0] = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                s0[i] = Math.max(s0[i - 1], s2[i - 1]);
                s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
                s2[i] = s1[i - 1] + prices[i];
            }
            return Math.max(s0[n - 1], s2[n - 1]);
        }
    }

/*

draw a state machine diagram.

s0:
[Consequence] State not immediate after selling; Doesn't have any stock;
[Action can take] Buy a new stock / Continue to take a rest

s1:
[Consequence] State with stock in hand;
[Action can take] Sell a stock / Continue to take a rest

s2:
[Consequence] State immediate after selling; Doesn't have any stock (since just sell one to enter this state)
[Action can take] Enters next state by taking a rest (since s2 is only for state immediate after selling, we cannot stay here.

*/

}
