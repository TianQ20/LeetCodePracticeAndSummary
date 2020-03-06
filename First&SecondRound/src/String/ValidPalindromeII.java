package String;

public class ValidPalindromeII {


    // every time use start + 1 or end - 1 to delete one element,
    // then find out if it becomes a valid Palindrome, if not, return false and continue loop.


    class Solution {
        public boolean validPalindrome(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start <= end) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                } else {
                    return isValidPalindrome(s, start + 1, end) || isValidPalindrome(s, start, end - 1);
                }
            }
            return true;
        }

        private boolean isValidPalindrome(String str, int s, int t) {
            while (s <= t) {
                if (str.charAt(s) == str.charAt(t)) {
                    s++;
                    t--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
