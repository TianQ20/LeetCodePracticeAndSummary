package Search_Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    class Solution_DFS {
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

    class Solutions_Bitwise {
        public List<List<Integer>> subsets(int[] nums) {
            if (nums.length == 0) return new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();

            for (int s = 0; s < (1 << nums.length); ++s) {
                List<Integer> curr = new ArrayList<>();
                for (int i = 0; i < nums.length; ++i) {
                    if ((s & (1 << i)) != 0) { // s & (1 << i) => nums[i] selected
                        curr.add(nums[i]);
                    }
                }
                list.add(new ArrayList<>(curr));
            }
            return list;
        }
    }
}
