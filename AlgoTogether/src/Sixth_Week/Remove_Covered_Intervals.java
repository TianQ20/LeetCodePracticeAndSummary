package Sixth_Week;

import java.util.Arrays;

public class Remove_Covered_Intervals {
    /**
     * sort by left bound, after removing covered intervals, right bound should increasing at the same time as left bound
     */
    class Solution_1 {
        public int removeCoveredIntervals(int[][] intervals) {
            if (intervals.length == 1) return 1;

//            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int res = 0, left = -1, right = -1;

            for (int[] v : intervals) {
                if (v[0] > left && v[1] > right) {
                    res++; // only count valid intervals
                    left = v[0];
                }
                right = Math.max(right, v[1]);
            }
            return res;
        }
    }


    /**
     * sort by left bound, if they have same left bound, then sort by decreasing order of right bound,
     * so if there are multiple intervals have the same left bound, we greedily choose the max right bound at first.
     */
    class Solution_2 {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            int res = 0, right = 0;
            for (int[] v : intervals) {
                if (v[1] > right) {
                    res++;
                    right = v[1];
                }
            }
            return res;
        }
    }
}
