package SecondWeek;

public class H_Index {
    class Solution_1 {
        /**
         * unsorted array, use bucket sort O(N)
         * @param citations
         * @return
         */
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] bucket = new int[n + 1];
            for (int i = 0; i < n; i++) {
                if (citations[i] > n) {
                    bucket[n]++;
                } else {
                    bucket[citations[i]]++;
                }
            }

            int count = 0;
            for (int i = n; i >= 0; i--) {
                count += bucket[i];
                if (count >= i) {
                    return i;
                }
            }
            return 0;
        }
    }



    class Solution_2 {
        /**
         * sorted array, use binary search O(logN)
         * @param citations
         * @return
         */
        public int hIndex(int[] citations) {
            int n = citations.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (citations[mid] >= n - mid) {
                    right = mid - 1; // search in left half
                } else {
                    left = mid + 1; // search in right half
                }
            }
            return n - left;
        }
    }
}
