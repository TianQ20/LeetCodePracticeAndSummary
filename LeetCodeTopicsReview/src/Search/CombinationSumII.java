package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            Arrays.sort(candidates);
            DFS(candidates, target, 0, curr, list);
            return list;
        }

        public void DFS(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> list) {
            if (target == 0) {
                list.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                if (i > start && candidates[i] == candidates[i - 1]) continue; // skip duplicates

                curr.add(candidates[i]);
                DFS(candidates, target - candidates[i], i + 1, curr, list); // can not reuse the same element
                curr.remove(curr.size() - 1);
            }
        }
    }
}
