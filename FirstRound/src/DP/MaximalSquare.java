package DP;

public class MaximalSquare {

    // dp[i][j] represents the length of the square which lower right corner is located at (i, j).
    // If the value of this cell is also 1,
    // then the length of the square is the minimum of:
    // the one above, its left, and diagonal up-left value +1.
    // Because if one side is short or missing, it will not form a square.

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    result = Math.max(result, dp[i][j]); // update result
                }
            }
        }
        return result * result;
    }
}
