package LintCode_Greedy;

public class JumpGame {
    class Solution_1 {
        // scan left to right, record the max reachable length
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


    class Solution_2 {
        // scan from end, record every time least reachable index to last position,
        // when last == 0 means it reachs the index 0
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int last = nums[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                last = last <= i + nums[i] ? i : last;
            }
            return last == 0;
        }
    }
}
