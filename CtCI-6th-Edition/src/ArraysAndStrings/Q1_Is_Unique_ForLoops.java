package ArraysAndStrings;

// use two for loops to compare each two elements
// O(N^2)
public class Q1_Is_Unique_ForLoops {
    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) { // only 26 characters
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
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
