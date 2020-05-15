package FirstWeek;

public class RotateImage {
    /**
     * clockwise rotate
     * 1 2 3     1 4 7     7 4 1
     * 4 5 6  => 2 5 8  => 8 5 2
     * 7 8 9     3 6 9     9 6 3
     *
     * If we want to get the anti-clockwise, just need to swap the top and bottom elements.
     * time complexity: O(n^2), since we have to traverse the matrix to transpose it.
     * space complexity: O(n).
     */

    class Solution {
        public void rotate(int[][] matrix) {
            int column = matrix.length, row = matrix[0].length;
            // transpose the matrix
            for (int i = 0; i < column; i++) {
                for (int j = i + 1; j < row; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
            // swap left and right side
            int start = 0, end = matrix.length - 1;
            while (start < end) {
                for (int i = 0; i < column; i++) {
                    int tmp = matrix[i][end];
                    matrix[i][end] = matrix[i][start];
                    matrix[i][start] = tmp;
                }
                start++;
                end--;
            }
        }
    }
}
