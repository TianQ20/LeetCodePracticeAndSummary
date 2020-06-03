public class MinDeletionsToObtainStringinRightFormat {
    public class Solution {
        /**
         * @param s: the string
         * @return: Min Deletions To Obtain String in Right Format
         */
        public int minDeletionsToObtainStringInRightFormat(String s) {
            // write your code here
            int cntA = 0, cntB = 0, cntRemove = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'A') {
                    cntA++;
                    if (cntB > cntRemove) { // A出现在B后面，remove A
                        cntRemove++;
                    }
                } else {
                    cntB++;
                    if (cntA == 0) cntRemove++; // B出现在A前面，remove B
                }
            }
            return Math.min(Math.min(cntA, cntB), cntRemove);
        }
    }

    /*

                B A A A B A B
    cntA        1       2   3
    cntB          1 2 3   4
    cntRemove   1         2

     */
}
