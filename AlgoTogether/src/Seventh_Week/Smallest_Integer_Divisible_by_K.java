package Seventh_Week;

public class Smallest_Integer_Divisible_by_K {
    class Solution {
        public int smallestRepunitDivByK(int K) {
            if (K % 2 == 0 || K % 5 == 0) return -1;
            int r = 0;
            for (int N = 1; N <= K; N++) {
                r = (r * 10 + 1) % K; // avoid overflow
                if (r % K == 0) return N;
            }
            return -1; // will not reach
        }
    }
}
