package ArraysAndStrings;

public class p3_search_in_2D_matrix {
    /**
     * 74. Search a 2D Matrix
     */

    // brute force, O(n^2)
    class Solution_1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { // early break
                return false;
            }

            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
            return false;
        }
    }


    // two binary search in column and row, O(logm) + O(logn)
    class Solution_2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int m = matrix.length;
            int n = matrix[0].length;
            int start = 0, end = m - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target > matrix[mid][n - 1]) {
                    start = mid + 1;
                } else if (target < matrix[mid][0]) {
                    end = mid - 1;
                } else {
                    return findInRow(matrix, mid, target);
                }
            }
            return false;
        }

        private boolean findInRow(int[][] matrix, int rowIndex, int target) {
            int l = 0, r = matrix[0].length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (target > matrix[rowIndex][m]) {
                    l++;
                } else if (target < matrix[rowIndex][m]) {
                    r--;
                } else return true;
            }
            return false;
        }
    }


    // assume it's a sorted list, O(log(m*n))
    // but when n and m is big this solution may cause overflow
    // "%" and "/" are expensive
    class Solution_3 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int m = matrix.length;
            int n = matrix[0].length;
            int start = 0, end = m * n - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (target == matrix[mid / n][mid % n]) {
                    return true;
                } else if (target > matrix[mid / n][mid % n]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
    }


    /**
     * 240. Search a 2D Matrix II
     */

    // O(m + n)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            // start from top right, decrease to left, increase to bottom
            int col = matrix[0].length - 1;
            int row = 0;

            while (col >= 0 && row <= matrix.length - 1) {
                if (target == matrix[row][col]) {
                    return true;
                } else if (target < matrix[row][col]) {
                    col--;
                } else if (target > matrix[row][col]) {
                    row++;
                }
            }
            return false;
        }
    }
}
