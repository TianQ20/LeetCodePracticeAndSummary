package LintCode_Bitwise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Single_Number {
    public class Solution_1 {
        public int singleNumber(int[] A) { // O(n) time and space
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : A) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            for (int i : A) {
                if (map.get(i) == 1) {
                    return i;
                }
            }
            return 0;
        }
    }


    public class Solution_3 { // O(n) time and space
        public int singleNumber(int[] A) {
            Set<Integer> set = new HashSet<>();
            for (int i : A) {
                set.add(i);
            }

            int set_sum = 0;
            for (int i : set) {
                set_sum += i;
            }

            int sum = 0;
            for (int i : A) {
                sum += i;
            }
            return set_sum * 2 - sum;
        }
    }


    public class Solution_2 { // bitwise, XOR is commutative, O(n) time, O(1) space, one pass
        public int singleNumber(int[] A) {
            // write your code here
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                result ^= A[i];
            }
            return result;
        }
    }

    /**
     * General rule for bitwise k times and p times template
     *
     * 137. Single Number II
     */

    class Solution_II {
        public int singleNumber(int[] nums) {
            int x1 = 0, x2 = 0, mask = 0;

            for (int i : nums) {
                x2 ^= x1 & i;
                x1 ^= i;
                mask = ~(x1 & x2); // k = 3 => '11'
                x2 &= mask;
                x1 &= mask;
            }
            return x1 | x2;
        }
    }


    class Solution_XOR {
        public int[] singleNumber(int[] nums) {
            /**
             XOR elements in nums -> a ^ b (a != b)
             get diff by: diff &= -diff (revert then plus 1 at the end bit)
             separate to two groups
             if (i && diff == 0) -> find a
             then use (a ^ b) ^ a -> get b
             */

            int diff = 0;
            for (int i : nums) {
                diff ^= i;
            }
            diff &= -diff;
            int[] res = {0, 0};
            for (int i: nums) {
                if ((i & diff) == 0) {
                    res[0] ^= i;
                } else {
                    res[1] ^= i;
                }
            }
            return res;
        }
    }
}
