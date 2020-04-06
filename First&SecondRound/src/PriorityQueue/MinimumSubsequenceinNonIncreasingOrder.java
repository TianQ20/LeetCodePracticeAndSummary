package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSubsequenceinNonIncreasingOrder {
    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            List<Integer> list = new ArrayList<>();
            int total_sum = 0, sub_sum = 0;
            var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
            for (var n : nums) {
                pq.offer(n);
                total_sum += n;
            }

            while (sub_sum <= total_sum / 2) {
                list.add(pq.peek());
                sub_sum += pq.poll();
            }
            return list;
        }
    }
}
