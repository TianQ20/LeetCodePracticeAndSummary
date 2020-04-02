package Search_Combination;

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

        public void DFS(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> list) {
            if (target == 0) {
                list.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                curr.add(candidates[i]);
                DFS(candidates, target - candidates[i], i, curr, list); // can reuse the same element, so use i rather than i + 1
                curr.remove(curr.size() - 1);
            }
        }
    }


    class Solution2 {
        // 要求短的先输出，即输出有顺序要求
        // n代表最多的元素个数，即n <= target / candidates[0]，此时candidates已按升序排序
        // 增加一个递归深度d，判断d与n的大小关系。

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            Arrays.sort(candidates);
            for (int n = 1; n <= target / candidates[0]; ++n) {
                DFS(candidates, target, 0, 0, n, curr, list);
            }
            return list;
        }

        public void DFS(int[] candidates, int target, int start, int depth, int n, List<Integer> curr, List<List<Integer>> list) {
            if (depth == n) {
                if (target == 0) {
                    list.add(new ArrayList<>(curr));
                    return;
                }
            }

            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                curr.add(candidates[i]);
                DFS(candidates, target - candidates[i], i, depth + 1, n, curr, list); // can reuse the same element, so use i rather than i + 1
                curr.remove(curr.size() - 1);
            }
        }
    }
}
