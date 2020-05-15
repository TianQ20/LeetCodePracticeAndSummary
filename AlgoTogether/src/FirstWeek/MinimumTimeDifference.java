package FirstWeek;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int res = Integer.MAX_VALUE;
            int[] t = new int[timePoints.size()];
            for (int i = 0; i < timePoints.size(); i++) { // parse to integer
                t[i] = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3, 5));
            }

            Arrays.sort(t); // sort
            for (int i = 1; i < timePoints.size(); i++) {
                res = Math.min(res, t[i] - t[i - 1]);
            }
            res = Math.min(res, t[0] + (24 * 60 - t[timePoints.size() - 1])); // corner case
            return res;
        }
    }
}
