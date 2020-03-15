package PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {


    // To minimize the total wage, we want a small ratio.
    // So we sort all workers with their expected ratio, and pick up K first worker.
    // Now we have a minimum possible ratio for K worker and we their total quality.

    // As we pick up next worker with bigger ratio, we increase the ratio for whole group.
    // Meanwhile we remove a worker with highest quality so that we keep K workers in the group.
    // We calculate the current ratio * total quality = total wage for this group.


    class Solution {
        public double mincostToHireWorkers(int[] q, int[] w, int K) {
            double[][] workers = new double[q.length][2];
            for (int i = 0; i < q.length; ++i)
                workers[i] = new double[]{(double) (w[i]) / q[i], (double) q[i]};

            Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0])); // increasing order. If we want decreasing order, just use Arrays.sort(workers, (a, b) -> b[0] - a[0])
            double res = Double.MAX_VALUE, qsum = 0;
            PriorityQueue<Double> pq = new PriorityQueue<>();

            for (double[] worker : workers) {
                qsum += worker[1];
                pq.add(-worker[1]);
                if (pq.size() > K) qsum += pq.poll();
                if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
            }
            return res;
        }
    }
}
