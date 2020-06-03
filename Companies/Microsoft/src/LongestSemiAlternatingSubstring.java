public class LongestSemiAlternatingSubstring {
    public class Solution {
        /**
         * @param s: the string
         * @return: length of longest semi alternating substring
         */
        public int longestSemiAlternatingSubstring(String s) {
            // write your code here
            if(s == null || s.length() == 0)
                return 0;
            if(s.length() < 3)
                return s.length();
            int cnt = 1, l = 0, lastSeen = 0;
            int res = 0;
            for(int r = 1;r < s.length();r++) {
                char c = s.charAt(r);
                if(s.charAt(r-1) == c) {
                    cnt++;
                }else {
                    cnt = 1;
                    lastSeen = r;
                }
                if(cnt > 2 && l < lastSeen)
                    l = lastSeen;
                while(cnt > 2) {
                    l++;
                    cnt--;
                }
                res = Math.max(res, r - l + 1);
            }
            return res;
        }
    }
}
