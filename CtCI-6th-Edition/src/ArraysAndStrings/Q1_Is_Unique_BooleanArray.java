package ArraysAndStrings;

public class Q1_Is_Unique_BooleanArray {

    // O(N)
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) { // ASCII start from 0 to 127
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            if (char_set[str.charAt(i)]) {
                // Since default value of char_set[i] will be all false
                // Once encounter the duplicate character, the char_set[i] is already true, so we return false
                return false;
            }
            char_set[str.charAt(i)] = true;
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
