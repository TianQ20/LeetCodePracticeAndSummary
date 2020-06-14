package BinarySearch;

public class Minimum_Number_of_Days_to_Make_m_Bouquets {
    class Solution {
        public int minDays(int[] A, int m, int k) {
            int n = A.length;
            int left = 0, right = (int)1e9;
            if (m * k > n) return -1;

            while (left < right) {
                int mid = left + (right - left) / 2, flow = 0, bouq = 0;
                for (int i = 0; i < n; ++i) {
                    if (A[i] > mid) {
                        flow = 0;
                    } else {
                        flow++;
                        if (flow >= k) {
                            bouq++;
                            flow = 0;
                        }
                    }
                }
                if (bouq < m) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
