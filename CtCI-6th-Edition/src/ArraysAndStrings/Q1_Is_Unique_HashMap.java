package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class Q1_Is_Unique_HashMap {

    // use HashMap to store the character
    // O(N)
    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
}
