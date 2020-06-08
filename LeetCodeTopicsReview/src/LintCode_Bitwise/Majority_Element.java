package LintCode_Bitwise;

import java.util.HashMap;
import java.util.Map;

public class Majority_Element {
    class Solution_1 { // time O(n), space O(n)
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            for (int i : nums) {
                if (map.get(i) > nums.length / 2) {
                    return i;
                }
            }
            return -1;
        }
    }


    class Solution_2 {
        public int majorityElement(int[] nums) {
            int major = nums[0], count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == major) {
                    count++; // same element, can not crash, increase count by 1
                } else if (count == 0) { // crashed, need to update major to a new element
                    count++;
                    major = nums[i];
                } else count--; // crash 1 different element
            }
            return major;
        }
    }
}
