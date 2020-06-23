package Seventh_Week;

public class Bitwise_AND_of_Numbers_Range {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int i = 0; // how many bits are 0 on the right
            while (m != n) {
                m = m >> 1; // move to right, delete the least significant bit
                n = n >> 1;
                i++;
            }
            return m << i; // move to left, add 0 behind the common prefix
        }
    }
}
