package SecondWeek;

public class Divide_Two_Integers {
    class Solution {
        /**
         * use 10, 3 as example go through the code
         *
         * 10 - 3 << 1 = 10 - 3 > 0
         * 10 - (3 << 1 << 0) = 10 - 3 > 0
         * x++ -> x = 1
         * res -> 1 << 1 = 10 -> 2
         * a = 10 - b << 1 = 10 - 3 << 1 = 10 - 6 = 4
         *
         * 4 - 3 >= 0
         * 4 - (3 << 1 << 1) = 4 - 6 < 0
         * x = 0
         * res += 1 << 0 = 2 + 1 = 3
         * a -= b << 0 -> a = 4 - 3 << 0 = 1
         *
         * 1 - 3 < 0 -> jump out the while loop
         *
         * @param dividend
         * @param divisor
         * @return
         */
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) { // overflow edge case
                return Integer.MAX_VALUE;
            }
            int res = 0;
            int a = Math.abs(dividend);
            int b = Math.abs(divisor);
            while (a - b >= 0) {
                int x = 0;
                while (a - (b << 1 << x) >= 0) {
                    x++;
                }
                res += 1 << x;
                a -= b << x;
            }
            return (dividend >= 0) == (divisor > 0) ? res : -res;
        }
    }
}
