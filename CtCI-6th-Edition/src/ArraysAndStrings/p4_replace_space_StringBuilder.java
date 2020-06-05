package ArraysAndStrings;

public class p4_replace_space_StringBuilder {
    // O(n)

    public static String replaceSpace (String str) {
        int len = str.length();
        // count the space number
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int trueLength = len + spaceCount * 2; // get the real length after replace space
        StringBuilder sb = new StringBuilder(trueLength);
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Mr John Smith";
        System.out.println(replaceSpace(str));
        // Mr%20John%20Smith
    }
}
