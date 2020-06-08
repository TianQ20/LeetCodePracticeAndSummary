package LintCode_Greedy;

public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int far = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (i > far) { // mean we can not reach position i
                    break;
                }
                far = Math.max(far, i + nums[i]);
            }
            return far >= nums.length - 1;
        }
    }
}
