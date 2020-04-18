package DP;

public class MinimumPathSum {
    //    注意二维矩阵的初始化。每一行每一列（边缘）都需要初始化。

    //    state: f[x][y]从起点走到x,y的最短距离
    //    function: f[x][y] = min(f[x-1][y], f[x][y-1]) + A[x][y]
    //    initialize: f[0][0] = A[0][0]
    //      f[i][0] = sum(0, 0->i, 0)
    //      f[0][i] = sum(0->i, 0, i)
    //    answer: f[n-1][m-1]


    // use an extra 2D array to store the result
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        int i, j;
        // initialize the first row and column
        for (i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }


    // update the exist 2D array to store the result
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) grid[0][j] += grid[0][j - 1];
                if (i != 0 && j == 0) grid[i][0] += grid[i - 1][j];
                if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
