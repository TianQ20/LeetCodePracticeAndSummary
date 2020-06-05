package ArraysAndStrings;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Q9_StringRotation_A {

    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        return isSubstring(s1 + s1, s2); // concatenate s1 and s1 within new buffer
    }


    /*
    java.lang.String.contains() method searches the sequence of characters in the given string.
    It returns true if sequence of char values are found in this string otherwise returns false.
    */

    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
