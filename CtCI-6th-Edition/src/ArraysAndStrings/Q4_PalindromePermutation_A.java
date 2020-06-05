package ArraysAndStrings;

public class Q4_PalindromePermutation_A {
    public static boolean checkMaxOneOdd(int[] table) {
        // only can have at most one odd character
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
            }
            foundOdd = true;
        }
        return true;
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = Q4_Common.buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        System.out.println(isPermutationOfPalindrome(pali));
    }
}
