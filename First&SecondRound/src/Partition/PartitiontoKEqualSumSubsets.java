package Partition;

public class PartitiontoKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        if (sum % k != 0 || sum / k < maxNum) {
            return false;
        }
        return canPartitionKSubsets(nums, k, new boolean[nums.length], sum / k, 0, 0);
    }

    private boolean canPartitionKSubsets(int[] nums, int k, boolean[] visited, int targetSubsetSum, int curSubsetSum, int start) {
        if (k == 0) return true;
        if (curSubsetSum == targetSubsetSum) {
            return canPartitionKSubsets(nums, k - 1, visited, targetSubsetSum, 0, 0);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && curSubsetSum <= targetSubsetSum) {
                visited[i] = true;
                if (canPartitionKSubsets(nums, k, visited, targetSubsetSum, curSubsetSum + nums[i], i + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}

// canPartitionKSubsets() is true when there are exactly k subsets with equal subset sum sum / k, and each element are only used once.
// comparison between curSubsetSum and targetSubsetSum indicates whether we find a valid subset.
// k restricts there are k subsets exactly.
// We can take it as a nested recursion. The graph below shows the control flow (not accurate):

// Outer recursion on k subsets:
// Base case: k == 0
// Recursive case: k > 0
//		(Inner recursion on individual subset)
//		Base case: curSubsetSum == targetSubsetSum (return to outer recursion)
//		Recursive case: curSubsetSum < targetSubsetSum