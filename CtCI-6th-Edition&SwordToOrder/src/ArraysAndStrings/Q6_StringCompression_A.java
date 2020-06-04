package ArraysAndStrings;

public class Q6_StringCompression_A {

    public static String stringCompression(String str) {
        String compressdString = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressdString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressdString.length() > str.length() ? str : compressdString;
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(str);
        System.out.println(stringCompression(str));
    }
}
