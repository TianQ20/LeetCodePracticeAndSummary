package Search_Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofSquarefulArrays {
    class Solution {
        int res = 0;
        public int numSquarefulPerms(int[] A) {
            Arrays.sort(A);
            boolean[] used = new boolean[A.length];
            dfs(A, new ArrayList<Integer>(), used);
            return res;
        }


        private void dfs(int[] A, List<Integer> list, boolean[] used) {
            if (list.size() == A.length) {
                res++;
                return;
            }

            for (int i = 0; i < A.length; i++) {
                if (used[i]) continue;
                if (i > 0 && !used[i - 1] && A[i] == A[i - 1]) continue; // avoid duplicate
                if (list.size() == 0 || squareful(list.get(list.size() - 1) + A[i])) { // Prune invalid solutions
                    used[i] = true;
                    list.add(A[i]);
                    dfs(A, list, used);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }


        private boolean squareful(int x) {
            return (Double)Math.sqrt(x) == (int)Math.sqrt(x);
        }
    }
}
