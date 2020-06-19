public class p10_1 {
    class Solution {
        public int fib(int n) {
            int MOD = 1000000007;
            if (n <= 1) return n % MOD;

            int a = 0, b = 1;
            while (n-- > 1) {
                int sum = (a + b) % MOD;
                a = b;
                b = sum;
            }
            return b;
        }
    }
}
