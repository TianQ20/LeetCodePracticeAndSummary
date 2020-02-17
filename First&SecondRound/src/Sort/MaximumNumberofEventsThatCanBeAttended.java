package Sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumNumberofEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        // store the events that end sooner
        Arrays.sort(events, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        Set<Integer> occupied = new HashSet<>();
        for (int[] e : events) {
            for (int i = e[0]; i <= e[1]; i++) {
                if (!occupied.contains(i)) {
                    occupied.add(i);
                    break;
                }
            }
        }
        return occupied.size();
    }
}
