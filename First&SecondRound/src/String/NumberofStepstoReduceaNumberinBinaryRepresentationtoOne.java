package String;

public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
    class Solution {
        public int numSteps(String s) {
            int ans = 0;
            int carry = 0;
            // The highest bit must be 1, process to the 2nd highest bit
            for (int i = s.length() - 1; i > 0; --i) {
                if (s.charAt(i) - '0' + carry == 1) {
                    ans += 2; // odd: + 1 even: / 2
                    carry = 1; // always has a carry
                } else {
                    ans += 1; // even: / 2
                    // carry remains
                }
            }
            return ans + carry;
        }
    }
}
