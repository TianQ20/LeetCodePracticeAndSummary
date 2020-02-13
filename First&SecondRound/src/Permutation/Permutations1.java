package Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// backtrack

class Permutaions1_backtrack {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<Integer>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;  // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}


// DFS

class Permutations1_DFS {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, new ArrayList<Integer>(), results);
        return results;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> permute, List<List<Integer>> results) {
        if (nums.length == permute.size()) {
            results.add(new ArrayList<Integer>(permute));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            permute.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permute, results);
            visited[i] = false;
            permute.remove(permute.size() - 1);
        }
    }
}

