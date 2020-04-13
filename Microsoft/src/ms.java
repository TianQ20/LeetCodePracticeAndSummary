public class ms {
    public static int findIndex(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return -1;
        }

        int i, j;
        for (i = 0; i < s1.length() - s2.length() + 1; i++) {
            for (j = 0; j < s2.length(); j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    break;
                }
            }
            if (j == s2.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "ababab";
        String s2 = "ab";
        System.out.println(findIndex(s1, s2));

    }
}