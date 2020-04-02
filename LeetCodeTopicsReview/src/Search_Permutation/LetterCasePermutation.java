package Search_Permutation;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    class Solution_XOR {
        public List<String> letterCasePermutation(String S) {
            List<String> list = new ArrayList<>();
            if (S == null || S.length() == 0) {
                return list;
            }
            DFS(S.toCharArray(), 0, list);
            return list;
        }

        public void DFS(char[] S, int i, List<String> list) {
            if (i == S.length) {
                list.add(new String(S));
                return;
            }
            DFS(S, i + 1, list);
            if (!Character.isLetter(S[i])) {
                return;
            }
            S[i] ^= 1 << 5; // 'a' - 'A' = 32
            DFS(S, i + 1, list);
            S[i] ^= 1 << 5;
        }
    }

    

    class Solution_UpperCase_LowerCase {
        public List<String> letterCasePermutation(String S) {
            List<String> list = new ArrayList<>();
            if (S == null || S.length() == 0) {
                return list;
            }
            DFS(S.toCharArray(), 0, list);
            return list;
        }

        public void DFS(char[] S, int i, List<String> list) {
            if (i == S.length) {
                list.add(new String(S));
                return;
            }

            if (S[i] >= '0' && S[i] <= '9') {
                DFS(S, i + 1, list);
                return;
            }

            S[i] = Character.toLowerCase(S[i]);
            DFS(S, i + 1, list);

            S[i] = Character.toUpperCase(S[i]);
            DFS(S, i + 1, list);
        }
    }
}
