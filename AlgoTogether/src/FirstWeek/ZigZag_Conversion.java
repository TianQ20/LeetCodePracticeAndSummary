package FirstWeek;

public class ZigZag_Conversion {
    class Solution {
        public String convert(String s, int numRows) {
            char[] c = s.toCharArray();
            int len = c.length;
            StringBuilder[] sb = new StringBuilder[numRows];
            boolean forward = false;
            for (int i = 0; i < sb.length; i++) {
                sb[i] = new StringBuilder();
            }

            int i = 0;
            while (i < len) {
                for (int idx = 0; idx < numRows && i < len; idx++) { // move down directly
                    sb[idx].append(c[i]);
                    i++;
                }

                for (int idx = numRows - 2; idx >= 1 && i < len; idx--) { // move up oblique
                    sb[idx].append(c[i]);
                    i++;
                }
            }

            for (int j = 1; j < sb.length; j++) { // combine
                sb[0].append(sb[j]);
            }
            return sb[0].toString();
        }
    }
}
