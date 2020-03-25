public class MinimumMoves {
    public class Solution {
        /**
         * @param S: a string
         * @return:  return the minimum number of moves
         */
        public int MinimumMoves(String S) {
            // write your code here
            if (S.length() < 3) return 0;

            // for len from 3, 4, 5, 6
            // for len % 3 == 0, swap the middle one, count = len / 3
            // for len % 3 != 0, swap the third one, count = len / 3

            int i = 0, count = 0;
            while (i < S.length()) {
                char c = S.charAt(i);
                i++;
                int len = 1;
                while (i < S.length() && S.charAt(i) == c) {
                    i++;
                    len++;
                }
                count += len / 3;
            }
            return count;
        }
    }
}
