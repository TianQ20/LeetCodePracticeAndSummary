package TopAmazonQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
    Time: O(n^2)
    Space: O(1)
    */

    class Solution_bruteforce {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] + nums[j] == target) {
                        res[0] = j;
                        res[1] = i;
                        return res;
                    }
                }
            }
            return res;
        }
    }

    /*
    Time: O(nlogn)
    Space: O(n)
     */

    class Solution_TwoPointers {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null) return null;
            int[] nums2 = Arrays.copyOf(nums, nums.length);
            Arrays.sort(nums2);
            int a = 0, b = 0;
            int start = 0, end = nums2.length - 1;

            while (start < end) {
                int sum = nums2[start] + nums2[end];
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    a = nums2[start];
                    b = nums2[end];
                    break;
                }
            }

            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == a) {
                    res[0] = i;
                    break;
                }
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] == b) {
                    res[1] = j;
                    break;
                }
            }
            return res;
        }
    }

    /*
    Time: O(n)
    Space: O(n)
     */

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                    return res;
                }
                map.put(nums[i], i);
            }
            return res;
        }
    }

}
