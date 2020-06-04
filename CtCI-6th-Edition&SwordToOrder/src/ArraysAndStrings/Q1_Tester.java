package ArraysAndStrings;

public class Q1_Tester {

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            boolean wordA = Q1_Is_Unique_ForLoops.isUniqueChars(word);
            boolean wordB = Q1_Is_Unique_BooleanArray.isUniqueChars(word);
            if (wordA == wordB) {
                System.out.println(word + ": " + wordA);
            } else {
                System.out.println(word + ": " + wordA + " vs " + wordB);
            }
        }
    }
}


/*

abcde: true
hello: false
apple: false
kite: true
padle: true

*/