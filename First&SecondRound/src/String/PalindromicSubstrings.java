package String;

public class PalindromicSubstrings {

    // start from each index and try to extend palindrome for both odd and even length.
    // avoid use class variable

    class Solution {
        public int countSubstrings(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                res += extendPalindrome(s, i, i);
                res += extendPalindrome(s, i, i + 1);
            }
            return res;
        }

        private int extendPalindrome(String s, int left, int right) {
            int count = 0;
            while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
                left--;
                right++;
                count++;
            }
            return count;
        }
    }
}
