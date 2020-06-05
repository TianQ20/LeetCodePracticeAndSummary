package ArraysAndStrings;

public class Q6_StringCompression_B {

    public static String stringCompression(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() > str.length() ? str : compressed.toString();
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(str);
        System.out.println(stringCompression(str));
    }
}
