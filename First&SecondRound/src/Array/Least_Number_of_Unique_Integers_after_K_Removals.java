package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Least_Number_of_Unique_Integers_after_K_Removals {
    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : arr) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            Set<Integer> keys = map.keySet();
            int[] array = new int[keys.size()];
            int index = 0;
            for(Integer element : keys) {
                array[index++] = map.get(element).intValue();
            }
            Arrays.sort(array);

            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (k > 0) {
                    k -= array[i];
                    if (k >= 0) {
                        count++;
                    }
                }
            }

            return keys.size() - count;
        }
    }
}
