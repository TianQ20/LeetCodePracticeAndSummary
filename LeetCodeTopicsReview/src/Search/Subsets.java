package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> curr = new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();
            if (nums == null) {
                return list;
            }

            if (nums.length == 0) {
                list.add(new ArrayList<>(curr));
                return list;
            }

            Arrays.sort(nums);
            DFS(nums, 0, curr, list);
            return list;
        }

        public void DFS(int[] nums, int start, List<Integer> curr, List<List<Integer>> list) {
            list.add(new ArrayList<>(curr));

            for (int i = start; i < nums.length; i++) {
                curr.add(nums[i]);
                DFS(nums, i + 1, curr, list);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
