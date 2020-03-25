public class LongestPrefixofArray {
    public class Solution {
        /**
         * @param X: a integer
         * @param Y: a integer
         * @param nums: a list of integer
         * @return: return the maximum index of largest prefix
         */
        public int LongestPrefix(int X, int Y, int[] nums) {
            // write your code here
            int count_x = 0, count_y = 0;
            int index = 0;
            boolean isEqual = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == X) count_x++;
                if (nums[i] == Y) count_y++;
                if (count_x == count_y && count_x >=1) {
                    isEqual= true;
                    index = i;
                }
            }
            return isEqual ? index : -1;
        }
    }
}
