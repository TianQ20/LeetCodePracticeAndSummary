package DP;

public class MinimumPathSum {
    //    注意二维矩阵的初始化。每一行每一列（边缘）都需要初始化。

    //    state: f[x][y]从起点走到x,y的最短距离
    //    function: f[x][y] = min(f[x-1][y], f[x][y-1]) + A[x][y]
    //    initialize: f[0][0] = A[0][0]
    //      f[i][0] = sum(0, 0->i, 0)
    //      f[0][i] = sum(0->i, 0, i)
    //    answer: f[n-1][m-1]


    public int minPathSum(int[][] grid) {
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
