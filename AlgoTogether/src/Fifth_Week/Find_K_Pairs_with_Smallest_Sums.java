package Fifth_Week;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Find_K_Pairs_with_Smallest_Sums {
    // brute force, think it as a 2D matrix, sort it by sum (using min Heap)
    // time O(n * m * log(n * m)), space O(m * n)

    class Solution_1 {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<>();
            int n1 = nums1.length, n2 = nums2.length;
            // provide all pairs, sort by sum -> min heap
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> (a[0] + a[1]) - (b[0] + b[1]));
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < n2; j++) {
                    pq.add(new int[] {nums1[i], nums2[j]});
                }
            }
            while (!pq.isEmpty() && k-- > 0) {
                int[] poped = pq.poll();
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(poped[0]);
                tmpList.add(poped[1]);
                res.add(tmpList);
            }
            return res;
        }
    }


    // Time O(klog(Math.min(nums1.length, k))
    // first add all pairs with nums1[i], nums2[0]
    // then if there are a better choice, for specific element in nums1,
    // we should choose the specific element according index + 1 element in nums2 (since they all sorted)

    class Solution_2 {
        class Triple {
            int val;
            int one;
            int two;
            Triple(int val, int one, int two) {
                this.val = val;
                this.one = one;
                this.two = two;
            }
        }

        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k == 0 || nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return res;
            }

            PriorityQueue<Triple> pq = new PriorityQueue<Triple>(Math.min(nums1.length, k), new Comparator<Triple>() {
                public int compare(Triple a, Triple b) {
                    return Integer.compare(a.val, b.val);
                }
            });

            for (int i = 0; i < Math.min(nums1.length, k); i++) {
                pq.offer(new Triple(nums1[i] + nums2[0], i, 0));
            }

            while (k-- > 0 && !pq.isEmpty()) {
                Triple curr = pq.poll();
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(nums1[curr.one]);
                tmpList.add(nums2[curr.two]);
                res.add(tmpList);
                if (curr.two + 1 < nums2.length) {
                    pq.offer(new Triple(nums1[curr.one] + nums2[curr.two + 1], curr.one, curr.two + 1));
                }
            }
            return res;
        }
    }
}
