package BinarySearch;

import java.util.List;

public class LeftmostColumnwithatLeastaOne {

    interface BinaryMatrix {
        int get(int row, int col);

        List<Integer> dimensions();
    };

    /**
     * Optimal solution: from the right top move left or down to find the most left index
     * O(m + n)
     */
    class Solution1 {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            int index = -1;
            List<Integer> dimensions = binaryMatrix.dimensions();
            int row = dimensions.get(0);
            int column = dimensions.get(1);

            for (int i = 0, j = column - 1; i < row && j >= 0; ) {
                if (binaryMatrix.get(i, j) == 1) {
                    index = j;
                    j--;
                } else {
                    i++;
                }
            }
            return index;
        }
    }


    /**
     * Binary Search
     * O(mlogn), m is the row, n is the column
     */
    class Solution2 {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            List<Integer> dimensions = binaryMatrix.dimensions();
            int row = dimensions.get(0);
            int column = dimensions.get(1);
            int left = 0, right = column - 1, res = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (exist(binaryMatrix, row, mid)) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }

        private boolean exist(BinaryMatrix binaryMatrix, int row, int col) {
            for (int i = 0; i < row; i++) {
                if (binaryMatrix.get(i, col) == 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
