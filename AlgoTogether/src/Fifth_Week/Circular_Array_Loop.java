package Fifth_Week;

public class Circular_Array_Loop {
    class Solution {
        public boolean circularArrayLoop(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int slow = i, fast = i;
                boolean ifForward = nums[i] > 0;

                while (true) {
                    slow = getNextPosition(nums, slow, ifForward);
                    if (slow == -1) {
                        break;
                    }

                    fast = getNextPosition(nums, fast, ifForward);
                    if (fast == -1) {
                        break;
                    }

                    fast = getNextPosition(nums, fast, ifForward);
                    if (fast == -1) {
                        break;
                    }

                    if (slow == fast) {
                        return true;
                    }
                }
            }
            return false;
        }

        private int getNextPosition(int[] nums, int index,  boolean ifForward) {
            boolean direction = nums[index] >= 0;
            if (direction != ifForward) {
                return -1;
            }

            int nextIndex = (index + nums[index]) % nums.length;
            if (nextIndex < 0) {
                nextIndex += nums.length;
            }

            if (nextIndex == index) {
                return -1;
            }
            return nextIndex;
        }
    }
}
