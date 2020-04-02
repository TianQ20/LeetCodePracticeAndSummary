package Search;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<Integer> curr = new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();
            DFS(k, n, 1, curr, list);
            return list;
        }

        public void DFS(int k, int n, int start, List<Integer> curr, List<List<Integer>> list) {
            if (curr.size() > k) {
                return;
            }

            if (curr.size() == k && n == 0) {
                list.add(new ArrayList<>(curr));
            }

            for (int i = start; i <= 9; i++) {
                if (n - i >= 0) {
                    curr.add(i);
                    DFS(k, n - i, i + 1, curr, list);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}
