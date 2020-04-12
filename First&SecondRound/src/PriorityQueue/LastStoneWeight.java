package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int stone : stones) {
                pq.offer(stone);
            }
            while (pq.size() > 1) {
                pq.offer(pq.poll() - pq.poll());
            }
            return pq.peek();
        }
    }
}
