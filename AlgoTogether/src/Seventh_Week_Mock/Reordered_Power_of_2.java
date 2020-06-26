package Seventh_Week_Mock;

import java.util.Arrays;

public class Reordered_Power_of_2 {
    class Solution_1 {
        public boolean reorderedPowerOf2(int N) {
            char[] ch1 = String.valueOf(N).toCharArray();
            Arrays.sort(ch1);
            String s1 = new String(ch1);

            for (int i = 0; i < 31; i++) {
                char[] ch2 = String.valueOf((int)(1 << i)).toCharArray();
                Arrays.sort(ch2);
                String s2 = new String(ch2);
                if (s1.equals(s2)) return true;
            }
            return false;
        }
    }


    class Solution_2 {
        public boolean reorderedPowerOf2(int N) {
            long c = counter(N);
            for (int i = 0; i < 32; i++) {
                if (counter(1 << i) == c) return true;
            }
            return false;
        }

        private long counter(int N) {
            long res = 0;
            for (; N > 0; N /= 10) {
                res += (int)Math.pow(10, N % 10);
            }
            return res;
        }
    }
}
