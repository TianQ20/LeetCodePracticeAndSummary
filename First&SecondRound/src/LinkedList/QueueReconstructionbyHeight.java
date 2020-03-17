package LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionbyHeight {

    // pick up the tallest guy first
    // when insert the next tall guy, just need to insert him into kth position
    // repeat until all people are inserted into list

    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (b[0] - a[0]));
            List<int[]> list = new LinkedList<>();
            for (int[] p : people) {
                list.add(p[1], p);
            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
