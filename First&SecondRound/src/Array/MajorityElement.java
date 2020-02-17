package Array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // Sort approach:
    // Arrays.sort(nums);
    // return nums[nums.length / 2];

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                res = num;
                break;
            }
        }
        return res;
    }
}
