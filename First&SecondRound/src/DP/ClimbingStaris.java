package DP;

public class ClimbingStaris {
    public int climbStairs(int n) {
        if (n <= 1) return n;
        int stepOne = 1;
        int stepTwo = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = stepOne + stepTwo;
            stepOne = stepTwo;
            stepTwo = result;
        }
        return result;
    }
}
