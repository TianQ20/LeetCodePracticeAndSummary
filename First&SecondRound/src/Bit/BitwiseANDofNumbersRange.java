package Bit;

public class BitwiseANDofNumbersRange {
    /**
     * find the general rule: only bits which are the same in both m and n will remain, others would be come 0
     */
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int i = 0;
            while (m != n) {
                m >>= 1;
                n >>= 1;
                i++;
            }
            return m << i;
        }
    }
}
