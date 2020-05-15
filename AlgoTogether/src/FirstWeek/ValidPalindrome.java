package FirstWeek;

public class ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            if (s.isEmpty()) {
                return true;
            }
            int start = 0, end = s.length() - 1;
            while (start < end) {
                char charStart = s.charAt(start);
                char charEnd = s.charAt(end);
                if (!Character.isLetterOrDigit(charStart)) {
                    start++;
                } else if (!Character.isLetterOrDigit(charEnd)) {
                    end--;
                } else {
                    if (Character.toLowerCase(charStart) != Character.toLowerCase(charEnd)) {
                        return false;
                    }
                    start++;
                    end--;
                }
            }
            return true;
        }
    }
}
