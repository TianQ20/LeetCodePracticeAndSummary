package Search_Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> curr = new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();
            if (nums == null) {
                return list;
            }
            Arrays.sort(nums);
            boolean[] visited = new boolean[nums.length];
            DFS(nums, curr, list, visited);
            return list;
        }

        public void DFS(int[] nums, List<Integer> curr, List<List<Integer>> list, boolean[] visited) {
            if (curr.size() == nums.length) {
                list.add(new ArrayList<>(curr));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
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
