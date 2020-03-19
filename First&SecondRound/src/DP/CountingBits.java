package DP;

public class CountingBits {
    // An even number in binary ends with 0
    // An odd number in binary ends with 1

    //num:      101010101010
    //num >> 1: 10101010101

    //num:     101010101011
    //num - 1: 101010101010
    
    class Solution {
        public int[] countBits(int num) {
            int[] res = new int[num + 1];
            res[0] = 0;

            for (int i = 1; i <= num; i++) {
                if ((i & 1) == 0) { // even
                    res[i] = res[i >> 1];
                } else { // odd
                    res[i] = res[i >> 1] + 1;
                }
            }
            return res;
        }
    }
}
