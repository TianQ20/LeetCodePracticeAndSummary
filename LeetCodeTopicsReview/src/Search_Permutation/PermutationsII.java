package Search_Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return list;
            }

            Arrays.sort(nums);
            boolean[] visited = new boolean[nums.length];
            List<Integer> curr = new ArrayList<>();
            DFS(nums, curr, list, visited);
            return list;
        }

        public void DFS(int[]nums, List<Integer> curr, List<List<Integer>> list, boolean[] visited) {
            if (curr.size() == nums.length) {
                list.add(new ArrayList<>(curr));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }

                // when a number has the same value with its previous, we can use this number only if his previous is used.
                // Same number can be only used once at each depth.

                if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                    continue;
                }

                curr.add(nums[i]);
                visited[i] = true;
                DFS(nums, curr, list, visited);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}
