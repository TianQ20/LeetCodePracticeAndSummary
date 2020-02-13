package Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// backtrack
class Permutations2_backtrack {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] visited) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                tempList.add(nums[i]);
                visited[i] = true;
                backtrack(list, tempList, nums, visited);
                visited[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}


// DFS
class Permutations2_DFS {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        Arrays.sort(nums);
        // 使用 visited 数组记录某个数是否被放到 permutation 里了
        boolean[] visited = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums, visited);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] visited) {
        if (nums.length == tempList.size()) {
            list.add(new ArrayList<Integer>(tempList));
            return;
        }
        // 跳过会造成重复的情况
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }

            tempList.add(nums[i]);
            visited[i] = true;
            backtrack(list, tempList, nums, visited);
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
