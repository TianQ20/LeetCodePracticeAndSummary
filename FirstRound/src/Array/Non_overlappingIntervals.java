package Array;

import java.util.Arrays;

public class Non_overlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) {
            return 0;
        }
        // sort the end in ascending order
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
