public class p11 {
    class Solution {
        public int minArray(int[] numbers) {
            int lo = 0, hi = numbers.length - 1;
            while (lo < hi) {
                int m = lo + (hi - lo) / 2;
                if (numbers[m] > numbers[hi]) { // narrow to right
                    lo = m + 1;
                } else if (numbers[m] < numbers[lo]) { // narrow to left
                    hi = m;
                } else {
                    hi--; // may not rotated
                }
            }
            return numbers[lo]; // finally, lo == hi
        }
    }
}
