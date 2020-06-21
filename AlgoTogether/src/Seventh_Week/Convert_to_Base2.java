package Seventh_Week;

public class Convert_to_Base2 {
    class Solution {
        public String baseNeg2(int N) {
            if (N == 0) return "0";
            StringBuilder sb = new StringBuilder();
            while (N != 0) {
                sb.append(N & 1); // 0001 & with any number will just return the least significant bit
                /**
                 * for base 2: we find 1, 2, 4, 8 => N = N >> 1
                 * for base -2: we find 1, -2, 4, -8 => N = -(N >> 1)
                 *
                 * -3 in 8-bit is 11111101 and -3>>1 is 11111110, which is -2
                 * this is different from -3/2, which is -1
                 */
                N = -(N >> 1);
            }
            return sb.reverse().toString();
        }
    }
}
