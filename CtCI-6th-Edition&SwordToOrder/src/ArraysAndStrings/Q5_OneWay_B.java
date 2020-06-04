package ArraysAndStrings;

public class Q5_OneWay_B {

    public static boolean oneEditAway(String first, String second) {
        // check length
        if (Math.abs(first.length() - second.length()) > 1) return false;

        // make sure first is the shorter one, second is the longer one.
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0, index2 = 0;
        boolean foundDifference = false;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) { // now have two differences
                    return false;
                }
                foundDifference = true;

                if (s1.length() == s2.length()) { // on replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // if matching, move shorter pointer
            }
            index2++; // always move pointer for longer string
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "palee";
        String b = "pale";
        boolean isOneEdit1 = oneEditAway(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit1);

        String c = "pale";
        String d = "pkle";
        boolean isOneEdit2 = oneEditAway(c, d);
        System.out.println(c + ", " + d + ": " + isOneEdit2);
    }
}
