package ArraysAndStrings;

// Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

public class Q1_Is_Unique_Bitwise {
    // O(N)
    // Actually the same idea as the boolean array, update checker value,
    // only when encounter duplicate element the (checker & (1 << val)) > 0 will be true.
    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) return false;

        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    // Bitwise OR (|)
    // Bitwise AND (&)
    // Shift Operators
    // >> / << : Shifts the bits of the number to the right/left and fills 0 on voids left as a result.
    // a = 10
    // a >> 1 = 5

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
}
