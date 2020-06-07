package LintCode_Greedy;

import java.util.HashMap;
import java.util.Map;

public class Single_Number {
    public class Solution {
        /**
         * @param A: An integer array
         * @return: An integer
         */
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
}
