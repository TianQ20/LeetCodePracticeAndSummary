package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class FindtheDuplicateNumber {
    class Solution1 {
        public int findDuplicate(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num: nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for (int num : nums) {
                if (map.get(num) > 1) {
                    return num;
                }
            }
            return 0;
        }
    }

    /*
    exactly the same idea with problem Linked List Cycle II.
    Use two pointers the fast and the slow. The fast one goes forward two steps each time, while the slow one goes only step each time.
    They must meet the same item when slow == fast.
    In fact, they meet in a circle, the duplicate number must be the entry point of the circle when visiting the array from nums[0].
    Next we just need to find the entry point.
    We use a point to visit from beginning with one step each time,
    do the same job to slow. When fast == slow, they meet at the entry point of the circle.
    */
    class Solution2 {
        public int findDuplicate(int[] nums) {
            if (nums.length > 1) {
                int slow = nums[0];
                int fast = nums[nums[0]];
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[nums[fast]];
                }

                fast = 0;
                while (fast != slow) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return slow;
            }
            return -1;
        }
    }
}
