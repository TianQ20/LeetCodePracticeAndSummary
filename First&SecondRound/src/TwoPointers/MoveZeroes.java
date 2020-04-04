package TwoPointers;

public class MoveZeroes {

    class Solution_TwoPointers {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) { // only move the non-zero element
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    j++;
                }
            }
        }
    }



    class Solution_Array {
        public void moveZeroes(int[] nums) {
            int snowBallSize = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    snowBallSize++;
                } else if (snowBallSize > 0) { // swap i-th non-zero element with the most left zero
                    int tmp = nums[i];
                    nums[i] = 0;
                    nums[i - snowBallSize] = tmp;
                }
            }
        }
    }
}
