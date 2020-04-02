package Search_Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
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
                if (i > start && nums[i] == nums[i - 1]) continue; // avoid duplicates. For the same depth, among the same numbers, only the first number can be used.
                curr.add(nums[i]);
                DFS(nums, i + 1, curr, list);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
