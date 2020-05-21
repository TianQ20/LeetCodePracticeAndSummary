package String;

public class Implement_strStr {
    class Solution_brute_force {
        /**
         * O(mn)
         * @param s
         * @param p
         * @return
         */
        public int strStr(String s, String p) {
            int i, j;
            for (i = 0; i < s.length() - p.length() + 1; i++) {
                for (j = 0; j < p.length(); j++) {
                    if (s.charAt(i + j) != p.charAt(j)) break;
                }
                if (j == p.length()) {
                    return i;
                }
            }
            return -1;
        }
    }

    class Solution_KMP {
        /**
         * O(m+n)
         * @param s
         * @param p
         * @return
         */
        public int strStr(String s, String p) {
            if (s == null || p == null || p.length() > s.length()) {
                return -1;
            }

            int[] nxt = build(p);
            int i = 0, j = 0;
            while (i < s.length() && j < p.length()) {
                if (s.charAt(i) == p.charAt(j)) { // match, move both
                    i++;
                    j++;
                } else if (j > 0) {
                    j = nxt[j - 1];
                } else if (j == 0) {
                    i++;
                }
            }
            if (j == p.length()) {
                return i - j; // since the i is the last index of matched character, to get the start index we need to minus the pattern string length (j)
            } else {
                return -1;
            }
        }

        private int[] build(String p) {
            int i = 1, j = 0;
            int[] nxt = new int[p.length()];
            while (i < p.length()) {
                if (p.charAt(i) == p.charAt(j)) {
                    nxt[i] = j + 1;
                    j++;
                    i++;
                } else {
                    if (j != 0) {
                        j = nxt[j - 1];
                    } else {
                        nxt[i] = 0;
                        i++;
                    }
                }
            }
            return nxt;
        }
    }
}
