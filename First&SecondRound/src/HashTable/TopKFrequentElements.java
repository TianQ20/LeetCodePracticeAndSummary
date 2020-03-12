package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer>[] bucket = new List[nums.length + 1];
            Map<Integer, Integer> frequencyMap = new HashMap<>();

            for (int n : nums) {
                frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
            }

            for (int key : frequencyMap.keySet()) { // returns a set view of the keys or we can create a new set and store the key elements in them.
                int frequency = frequencyMap.get(key);
                if (bucket[frequency] == null) {
                    bucket[frequency] = new ArrayList<>();
                }
                bucket[frequency].add(key);
            }

            List<Integer> res = new ArrayList<>();

            for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
                if (bucket[pos] != null) {
                    res.addAll(bucket[pos]); // addAll() : appends all of the elements in the specified collection to the end of this list
                }
            }
            return res;
        }
    }
}
