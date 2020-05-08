package FirstWeek;

public class BullsandCows {
    // use two arrays
    class Solution_1 {
        public String getHint(String secret, String guess) {
            int[] arrSecret = new int[10];
            int[] arrGuess = new int[10];
            int bull = 0, cow = 0;

            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    bull++;
                } else {
                    arrSecret[secret.charAt(i) - '0']++;
                    arrGuess[guess.charAt(i) - '0']++;
                }
            }

            for (int i = 0; i < 10; i++) {
                cow += Math.min(arrSecret[i], arrGuess[i]);
            }
            return "" + bull + "A" + cow + "B";
        }
    }


    // use one array
    class Solution_2 {
        public String getHint(String secret, String guess) {
            int[] numbers = new int[10];
            int bull = 0, cow = 0;

            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    bull++;
                } else {
                    if (numbers[secret.charAt(i) - '0']++ < 0) cow++;
                    if (numbers[guess.charAt(i) - '0']-- > 0) cow++;
                }
            }
            return "" + bull + "A" + cow + "B";
        }
    }

/**
 * numbers[secret.charAt(i)-'0'] is negative only if this character appeared in the guess more times then in the secret
 * which means that this character in the secret can be matched with one of the previous characters in the guest.
  */

}
