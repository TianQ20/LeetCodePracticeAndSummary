package SecondWeek;

public class Sqrt_x {
    class Solution {
        public int mySqrt(int x) {
            if (x < 2) return x;
            int ans = 0;
            int left = 1;
            int right = x/2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid <= x/mid) {
                    left = mid + 1;
                    ans = mid;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
    }
}
