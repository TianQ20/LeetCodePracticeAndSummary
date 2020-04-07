package HashTable;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {
    class Solution {
        public int countElements(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int i : arr) {
                set.add(i);
            }
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (set.contains(arr[i] + 1)) {
                    count++;
                }
            }
            return count;
        }
    }
}
