package Array;

import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int room = 0;
        int endItr = 0;
        for (int i = 0; i < len; i++) {
            if (start[i] < end[endItr]) {
                room++;
            } else {
                endItr++;
            }
        }
        return room;
    }
}
