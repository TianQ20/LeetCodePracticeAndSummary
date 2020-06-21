package Contest_194;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Avoid_Flood_in_The_City {
    class Solution {
        public int[] avoidFlood(int[] rains) {
            Map<Integer, Integer> map = new HashMap<>();
            TreeSet<Integer> zeros = new TreeSet<>();
            int[] res = new int[rains.length];

            for (int i = 0; i < rains.length; i++) {
                if (rains[i] == 0) {
                    zeros.add(i);
                } else {
                    if (map.containsKey(rains[i])) { // find the location of zero that can be used to empty rains[i]
                        Integer next = zeros.ceiling(map.get(rains[i]));
                        if (next == null) return new int[0];

                        res[next] = rains[i];
                        zeros.remove(next);
                    }
                    res[i] = -1;
                    map.put(rains[i], i);
                }
            }
            for (int i : zeros) {
                res[i] = 1; // any integer >= 1 and within the days of rains is ok, so we simply choose 1
            }
            return res;
        }
    }
}
