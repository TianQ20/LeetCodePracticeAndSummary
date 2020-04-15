package String;

public class PerformStringShifts {
    class Solution {
        public String stringShift(String s, int[][] shift) {
            int val = 0;
            for (int i = 0; i < shift.length; i++) {
                val += shift[i][0] == 0 ? -shift[i][1] : shift[i][1];
            }

            int len = s.length();
            val %= len;
            String res = "";
            if (val > 0) { // move right
                res = s.substring(len - val, len) + s.substring(0, len - val);
            } else { // move left
                res = s.substring(-val) + s.substring(0, -val);
            }
            return res;
        }
    }
}
