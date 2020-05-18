package SecondWeek;

public class Find_the_Smallest_Divisor_Given_a_Threshold {
    class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int left = 1, right = (int)1e6; // if set left = 0, will go to infinite loop
            while (left < right) {
                int mid = left + (right - left) / 2, sum = 0;
                for (int i : nums) {
                    sum += (i + mid - 1) / mid; // divide
                }
                if (sum > threshold) { // divisor too small
                    left = mid + 1;
                } else { // divisor too big
                    right = mid;
                }
            }
            return left;
        }
    }
}
