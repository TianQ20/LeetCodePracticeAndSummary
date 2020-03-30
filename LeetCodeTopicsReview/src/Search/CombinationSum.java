package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            Arrays.sort(candidates);
            DFS(candidates, target, 0, cur, list);
            return list;
        }

        public void DFS(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> list) {
            if (target == 0) {
                list.add(new ArrayList<>(cur));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                cur.add(candidates[i]);
                DFS(candidates, target - candidates[i], i, cur, list); // can reuse the same element, so use i rather than i + 1
                cur.remove(cur.size() - 1);
            }
        }
    }
}
