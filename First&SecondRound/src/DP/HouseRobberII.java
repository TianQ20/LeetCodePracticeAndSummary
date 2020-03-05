package DP;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; // edge case
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int curMax = 0;
        int preMax = 0;
        for (int i = start; i <= end; i++) {
            int tmp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = tmp;
        }
        return Math.max(curMax, preMax);
    }
}


// not like house robber I just an one way array, now it's become to a circle.
// to solve this problem, we can figure out that only two possible approach to get the result.
// We can reuse the solution of I and start from index 0 to (length - 2), or 1 to (length - 1).
// So we modify the solution I use preMax and curMax, and tmp to update their value.
