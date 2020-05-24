package SecondWeek;

public class Kth_Smallest_Element_in_a_Sorted_Matrix {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int count = 0, j = n - 1;
                for (int i = 0; i < n; i++) {
                    while (j >= 0 && matrix[i][j] > mid) {
                        j--; // move upward, since it's sorted
                    }
                    count += (j + 1); // count numbers which smaller than mid
                }
                if (count < k) { // move to right
                    lo = mid + 1;
                } else { // move to left
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
