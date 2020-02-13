package DFS;

public class TargetSum {
    int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        int[] s = new int[nums.length];
        s[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            s[i] = s[i + 1] + nums[i];
        }

        dfs(nums, S, 0, 0, s);
        return res;
    }

    private void dfs(int[] nums, int S, int index, int curSum, int[] s) {
        if (index == nums.length) {
            if (curSum == S) {
                res++;
            }
        } else if (Math.abs(S - curSum) <= s[index]) {
            dfs(nums, S, index + 1, curSum + nums[index], s);
            dfs(nums, S, index + 1, curSum - nums[index], s);
        }
    }
}




class Solution {
    int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int S, int index, int curSum) {
        if (index == nums.length) {
            if (curSum == S) {
                res++;
            }
            return;
        }
        dfs(nums, S, index + 1, curSum + nums[index]);
        dfs(nums, S, index + 1, curSum - nums[index]);
    }
}