public class p4 {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }

            int row = 0, col = matrix[0].length - 1;
            while (col >= 0 && row <= matrix.length - 1) {
                if (target == matrix[row][col]) {
                    return true;
                } else if (target > matrix[row][col]) {
                    row++;
                } else if (target < matrix[row][col]) {
                    col--;
                }
            }
            return false;
        }
    }
}
