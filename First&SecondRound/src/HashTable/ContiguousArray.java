package HashTable;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    class Solution {
        public int findMaxLength(int[] nums) {
            int sum = 0, max = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1); // map<Sum, Index>

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    sum++;
                } else {
                    sum--;
                }
                if (map.containsKey(sum)) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
            return max;
        }
    }
}
