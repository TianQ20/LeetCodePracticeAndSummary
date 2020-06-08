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
        class Solution {
            public int majorityElement(int[] nums) {
                int candidate = 0, count = 0;
                for (int num : nums) {
                    if (count == 0) {
                        candidate = num;
                        count++;
                    } else if (candidate == num) {
                        count++;
                    } else count--;
                }
                return candidate;
            }
        }
    }
}
