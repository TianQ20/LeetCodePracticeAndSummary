package Fifth_Week;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Distant_Barcodes {
    // sort by frequency, put most frequent element in even position, then fill the odd position
    // time O(nlogn), space O(n)

    class Solution_1 {
        public int[] rearrangeBarcodes(int[] barcodes) {
            if (barcodes == null || barcodes.length <= 1) return barcodes;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : barcodes) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>((i, j)-> map.get(j) - map.get(i));
            pq.addAll(map.keySet());

            int[] ans = new int[barcodes.length];
            int index = 0;
            while (!pq.isEmpty()) {
                int code = pq.poll();
                int freq = map.get(code);
                while (freq-- > 0) {
                    if (index >= barcodes.length) {
                        index = 1;
                    }
                    ans[index] = code;
                    index += 2;
                }
            }
            return ans;
        }
    }


    // time O(n), space O(n)
    // we just need to put the most frequent one in even position, then we can put others in any orders (problem statement said the answer is always exist)

    class Solution_2 {
        public int[] rearrangeBarcodes(int[] barcodes) {
            int index = 0, maxFreqCode = 0, n = barcodes.length;
            int[] freq = new int[10001], ans = new int[n];

            for (int c : barcodes) { // find the max frequent code
                if (++freq[c] > freq[maxFreqCode]) {
                    maxFreqCode = c;
                }
            }

            for (int j = 0; j < freq.length; j++) {
                int code = j == 0 ? maxFreqCode : j;
                while (freq[code]-- > 0) {
                    ans[index] = code;
                    index = index + 2 < n ? index + 2 : 1;
                }
            }
            return ans;
        }
    }
}
