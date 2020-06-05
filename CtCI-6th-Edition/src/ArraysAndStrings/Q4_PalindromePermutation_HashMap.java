package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class Q4_PalindromePermutation_HashMap {

    // This approach is only used to check the string is a palindrome or permutations.

    public static boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


    public static boolean isPermutation(String A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : A.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : B.toCharArray()) {
            map.put(c, map.get(c) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String A = "abccba";
        String B = "aabbcc";
        System.out.println(isPalindrome(A));
        System.out.println(isPermutation(A, B));
    }
}
