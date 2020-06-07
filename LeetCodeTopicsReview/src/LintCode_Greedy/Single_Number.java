package LintCode_Greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Single_Number {
    public class Solution_1 {
        public int singleNumber(int[] A) { // time O(n), space O(n)
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


    public class Solution_2 { // bitwise, XOR is commutative, O(n), one pass
        public int singleNumber(int[] A) {
            // write your code here
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                result ^= A[i];
            }
            return result;
        }
    }



    public class Solution_math {
        public int singleNumber(int[] A) {
            // write your code here
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
}
