package Search_Combination;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            DFS(n, k, 1, curr, list);
            return list;
        }

        public void DFS(int n, int k, int start, List<Integer> curr, List<List<Integer>> list) {
            if (k == 0) {
                list.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i <= n - k + 1; i++) { // should not continue recursing there won't be enough numbers left until n to fill the needed k slots.
                curr.add(i);
                DFS(n, k - 1, i + 1, curr, list);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
