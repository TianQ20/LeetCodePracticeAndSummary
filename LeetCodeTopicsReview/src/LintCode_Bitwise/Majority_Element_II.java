package LintCode_Bitwise;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_II {
    // we can also initialize candidate1, candidate2 = nums[0], will not effect the result,
    // but if we not choose null, we need to set tow counts into different numbers, like count1 = 0, count2 = 1
    // since tow major elements should not be the same
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<>();
            Integer candidate1 = null, candidate2 = null;
            int count1 = 0, count2 = 0;
            for (Integer num : nums) {
                if (num.equals(candidate1)) {
                    count1++;
                } else if (num.equals(candidate2)) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = num;
                    count1++;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }

            count1 = 0;
            count2 = 0;
            for (Integer num : nums) {
                if (num.equals(candidate1)) {
                    count1++;
                } else if (num.equals(candidate2)) {
                    count2++;
                }
            }

            if (count1 > (nums.length / 3)) {
                res.add(candidate1);
            }
            if (count2 > (nums.length / 3)) {
                res.add(candidate2);
            }
            return res;
        }
    }
}
