package DP;



class MinimumFallingPathSum1 {
    public static int minFallingPathSum(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        // DP matrix has 2 extra columns
        int[][] dp = new int[rows][cols + 2];
        // Fill the first row of DP matrix
        for (int i = 1; i <= cols; i++) {
            dp[0][i] = A[0][i - 1];
        }
        // Fill Integer.MAX_VALUE into first and last column of DP matrix
        for (int i = 0; i < rows; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][cols + 1] = Integer.MAX_VALUE;
        }
        // Building the DP matrix
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j <= cols; j++) {
                // Find the minimum neighbor from previous row in DP matrix
                // i是第几个array，j是代表那个array里的index
                int minNeighbor = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                minNeighbor = Math.min(minNeighbor, dp[i - 1][j + 1]);
                dp[i][j] = A[i][j - 1] + minNeighbor;
            }
        }
        // The minimum path sum is minimum of the last row in DP matrix
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= cols; i++) {
            min = Math.min(min, dp[rows - 1][i]);
        }
        return min;
    }
}



class MinimumFallingPathSum2 {
    public int minFallingPathSum(int[][] A) {
        int topLeft, topRight;
        for (int i = 1; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                topLeft = A[i - 1][Math.max(j - 1, 0)];
                topRight = A[i - 1][Math.min(j + 1, A.length - 1)];
                A[i][j] += Math.min(A[i - 1][j], Math.min(topLeft, topRight));
            }
        }
        int result = A[A.length - 1][0];
        for (int j = 0; j < A.length; ++j) {
            result = Math.min(A[A.length - 1][j], result);
        }
        return result;
    }
}
