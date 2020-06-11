package Fifth_Week;

public class Decoded_String_at_Index {
    class Solution {
        /**
         ha22 -> haha2 -> hahahahaha

         1. rebuild the string -> may cause overflow

         2. record the decoded string length


         Exp: ha22, k = 5

         'a', count = 2
         the first '2', count = count * 2 = 4
         last '2', count = count * 2 = 8 > k = 5

         count = count % "last 2" = 8 / 2 = 4
         k % 4 = 5 % 4 = 1

         count = count % "first 2" = 4 / 2 = 2
         1 % 2 = 1

         move to 'a', count-- => count = 1, index i move to 'h'
         1 % 1 = 0 => return S.charAt(i)

         */
        public String decodeAtIndex(String S, int K) {
            long cnt = 0;
            for (char c : S.toCharArray()) {
                cnt = Character.isDigit(c) ? (cnt * (c - '0')) : (cnt + 1); // update cnt
            }

            for (int i = S.length() - 1; i >= 0; i--) {
                K %= cnt;

                if (K == 0 && Character.isLetter(S.charAt(i))) { // find
                    return Character.toString(S.charAt(i));
                }

                if (Character.isDigit(S.charAt(i))) {
                    cnt /= S.charAt(i) - '0';
                } else {
                    cnt--;
                }
            }
            return null;
        }
    }
}
