package Top50LeetCode;

public class BestTimetoBuyandSellStock {

    // Brute Force O(n^2)

    class Solution1 {
        public int maxProfit(int[] prices) {
            int max = 0;
            int n = prices.length;
            if (n == 0) return max;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (prices[i] > prices[j]) {
                        max = Math.max(max, prices[i] - prices[j]);
                    }
                }
            }
            return max;
        }
    }

    // Iteration O(n)

    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n == 0) return 0;
            int max = 0;
            int sofarMin = prices[0];
            for (int i = 0; i < n; i++) {
                if (prices[i] > sofarMin) {
                    max = Math.max(max, prices[i] - sofarMin);
                } else {
                    sofarMin = prices[i];
                }
            }
            return max;
        }
    }
}
