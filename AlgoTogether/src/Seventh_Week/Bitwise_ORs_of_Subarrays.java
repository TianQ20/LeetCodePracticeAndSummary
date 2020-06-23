package Seventh_Week;

import java.util.HashSet;
import java.util.Set;

public class Bitwise_ORs_of_Subarrays {
    class Solution {
        public int subarrayBitwiseORs(int[] A) {
            Set<Integer> res = new HashSet<>(), prev = new HashSet<>(), cur;
            for (int num : A) {
                cur = new HashSet<>();
                cur.add(num);
                for (int old : prev) {
                    cur.add(old | num);
                }
                res.addAll(cur);
                prev = cur;
            }
            return res.size();
        }
    }
}
