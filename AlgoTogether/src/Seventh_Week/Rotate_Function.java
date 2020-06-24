package Seventh_Week;

public class Rotate_Function {
    class Solution_1 {
        public int maxRotateFunction(int[] A) {
            if (A.length == 0) {
                return 0;
            }

            int res = Integer.MIN_VALUE;
            int[] B = new int[A.length * 2];
            for (int i = 0; i < B.length; i++) {
                B[i] = A[i % A.length]; // copy from A
            }

            for (int i = 0; i < A.length; i++) {
                res = Math.max(res, getValue(B, i, i + A.length));
            }
            return res;
        }

        private int getValue(int[] a, int start, int end) {
            int ans = 0, count = 0;
            for (int i = start; i < end; i++) {
                ans += count * a[i];
                count++;
            }
            return ans;
        }
    }


    class Solution_2 {
        public int maxRotateFunction(int[] A) {
            int allSum = 0;
            int len = A.length;
            int F = 0;
            for (int i = 0; i < len; i++) {
                F += i * A[i];
                allSum += A[i];
            }

            int max = F;
            for (int i = len - 1; i >= 1; i--) {
                F = F + allSum - len * A[i];
                max = Math.max(max, F);
            }
            return max;
        }
    }
}
