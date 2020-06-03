package Top50LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



/*
For certain test cases with not very large n,
the runtime of this method can be slower than Approach #2.
The reason is hash table has some overhead in maintaining its property.
One should keep in mind that real world performance can be different from what the Big-O notation says.
The Big-O notation only tells us that for sufficiently large input, one will be faster than the other.
Therefore, when n is not sufficiently large, an O(n) algorithm can be slower than an O(nlogn) algorithm.
 */

public class ContainsDuplicate {

    // Sorting

    class Solution1 {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }
    }

    // Hash Table

    class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }
}
