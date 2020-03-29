package ArraysAndStrings;

public class Q9_StringRotation_B {

    // only consider using Substring element to construct the rotation will be true.
    // not a simple boolean permutation problem, can not just use hash map store elements frequency.

    /*

    String indexOf(String str) :
    This method returns the index within this string of the first occurrence of the specified substring.
    If it does not occur as a substring, -1 is returned.

    */

    public static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else return false;
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            // concatenate s1 and s1 within new buffer
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "caemra"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }

}
