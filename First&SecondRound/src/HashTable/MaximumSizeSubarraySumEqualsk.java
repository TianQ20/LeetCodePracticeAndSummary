package HashTable;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            int sum = 0;
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1); // in case of sum-k = 0, put(0,-1) in map so that current index - (-1) is the correct size of the subarray that sums up to k.

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k)) { // currentSum - previousSum = k
                    res = Math.max(res, i - map.get(sum - k));
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
            return res;
        }
    }
}
