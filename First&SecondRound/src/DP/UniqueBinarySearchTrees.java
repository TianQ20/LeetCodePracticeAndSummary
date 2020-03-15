package DP;

public class UniqueBinarySearchTrees {
    class Solution {
        public int numTrees(int n) {
            // treat each number as root, and then left part * right part is the answer.
            int[] dp = new int[n + 1];
            // only one combination to construct a BST out of a sequence of length 1 (only a root) or 0 (empty tree).
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j]; // F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
                }
            }
            return dp[n];
        }
    }
}
