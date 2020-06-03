package Top50LeetCode.Fibonacci;

public class ClimbStairs {

    // to get to n, we need to know how to get to (n - 1) and (n - 2)

    class Solution {
        public int climbStairs(int n) {
            if (n <= 1) return n;
            if (n == 2) return 2;
            int one_step_before = 1;
            int two_step_before = 2;
            int all_ways = 0;

            for (int i = 2; i < n; i++) {
                all_ways = one_step_before + two_step_before;
                one_step_before =  two_step_before;
                two_step_before = all_ways;
            }
            return all_ways;
        }
    }
}
