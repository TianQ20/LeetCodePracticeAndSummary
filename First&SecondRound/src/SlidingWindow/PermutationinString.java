package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationinString {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }

            Map<Character, Integer> map = new HashMap<>();
            for (char c : s1.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int start = 0, end = 0;
            int counter = map.size();

            while (end < s2.length()) {
                char c = s2.charAt(end);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        counter--;
                    }
                }
                end++;
                while (counter == 0) {
                    char tempc = s2.charAt(start);
                    if (map.containsKey(tempc)) {
                        map.put(tempc, map.get(tempc) + 1);
                        if (map.get(tempc) > 0) {
                            counter++;
                        }
                    }
                    if (end - start == s1.length()) {
                        return true;
                    }
                    start++;
                }
            }
            return false;
        }
    }
}
