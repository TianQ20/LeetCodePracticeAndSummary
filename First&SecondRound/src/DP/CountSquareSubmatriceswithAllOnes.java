package DP;

public class CountSquareSubmatriceswithAllOnes {
    public int countSquares(int[][] matrix) {
        int count = 0;
        int column = matrix.length;
        int row = matrix[0].length;
        for (int i = 0; i < column; ++i) {
            for (int j = 0; j < row; ++j) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                count += matrix[i][j];
            }
        }
        return count;
    }
}

//        similar with #221. Maximal Square
//        dp[i][j] means the size of biggest square with A[i][j] as bottom-right corner.
//        dp[i][j] also means the number of squares with A[i][j] as bottom-right corner.
//
//        If A[i][j] == 0, no possible square.
//        If A[i][j] == 1,
//        we compare the size of square dp[i-1][j-1], dp[i-1][j] and dp[i][j-1].
//        min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1 is the maximum size of square that we can find.

