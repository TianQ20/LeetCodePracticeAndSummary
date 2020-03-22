package Math;

public class FourDivisors {
    class Solution {
        int res = 0;
        public int sumFourDivisors(int[] nums) {
            for (int num : nums) {
                helper(num);
            }
            return res;
        }

        private void helper(int n) {
            int count = 0, sum = 0;
            for (int i = 1; i <= Math.sqrt(n) && count < 5; i++) {
                if (n % i == 0) {
                    count += 2;
                    sum += i;
                    if (n / i == i) {
                        count--; // same element only add once
                    } else {
                        sum += n / i;
                    }
                }
            }
            if (count == 4) {
                res += sum;
            }
            return;
        }
    }
}
