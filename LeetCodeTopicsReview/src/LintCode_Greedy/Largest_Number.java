package LintCode_Greedy;

import java.util.Arrays;

public class Largest_Number {
    class Solution_1 {
        public String largestNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return "0";
            }

            String[] s_num = new String[nums.length];
            for (int i = 0; i < s_num.length; i++) {
                s_num[i] = String.valueOf(nums[i]); // build string array
            }

            Arrays.sort(s_num, (s1, s2) -> (s2 + s1).compareTo(s1 + s2)); // sort in reverse order
            // special case: all '0'
            if (s_num[0].charAt(0) == '0') {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            for (String s : s_num) {
                sb.append(s);
            }
            return sb.toString();
        }
    }


    static class Solution_2 {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            sort(nums, 0, n - 1);
            StringBuilder sb = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                sb.insert(0, Integer.toString(nums[i]));
            }
            String res = sb.toString();
            // delete the leading '0'
            if (res.charAt(0) == '0') {
                return "0";
            }
            return res;
        }

        // quick sort
        private static int partition(int[] A, int lo, int hi) {
            int i = lo, j = hi + 1;
            int pivot = A[lo];
            while (true) {
                while (less(A[++i], pivot)) {
                    if (i == hi) break;
                }
                while (less(pivot, A[--j])) {
                    if (j == lo) break;
                }
                if (i >= j) break;
                exch(A, i, j);
            }
            exch(A, lo, j);
            return j;
        }

        private static void exch(int[] A, int a, int b) {
            int tmp = A[a];
            A[a] = A[b];
            A[b] = tmp;
        }

        private static boolean less(int a, int b) {
            String s1 = String.valueOf(a) + String.valueOf(b);
            String s2 = String.valueOf(b) + String.valueOf(a);
            int len = s1.length();
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) - '0' < s2.charAt(i) - '0') {
                    return true;
                } else if (s1.charAt(i) == s2.charAt(i)) {
                    continue;
                } else return false;
            }
            return false;
        }

        private static void sort(int[] A, int lo, int hi) {
            if (hi <= lo) return;
            int j = partition(A, lo, hi);
            sort(A, lo, j - 1);
            sort(A, j + 1, hi);
        }
    }
}
