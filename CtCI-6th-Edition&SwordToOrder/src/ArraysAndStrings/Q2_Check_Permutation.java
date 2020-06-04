package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q2_Check_Permutation {
    // Use HashMap to store the frequency of each character, then compare every one.
    public static boolean isPermutation(String A, String B) {
        if (A.length() != B.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : A.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : B.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) != 0) return false;
            }
        }
        return true;
    }


    // Use array to store the frequency
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[128]; // assume ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) return false;
        }
        return true;
    }


    // use Arrays.sort
    public static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content); // sort elements
    }

    public static boolean permutation2(String s, String t) {
        return sort(s).equals(sort(t));
    }


    public static void main(String[] args) {
        String A = "abcd";
        String B = "dcba";
        System.out.println(isPermutation(A, B));
        System.out.println(permutation(A, B));
        System.out.println(permutation2(A, B));
    }
}
