package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int start = 0, end = 0, counter = 0, len = 0;

            while (end < s.length()) {
                char c = s.charAt(end);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == 1) {
                    counter++;
                }
                end++;
                while (counter > 2) { // at most 2 distinct characters
                    char tempc = s.charAt(start);
                    map.put(tempc, map.get(tempc) - 1);
                    if (map.get(tempc) == 0) {
                        counter--;
                    }
                    start++;
                }
                len = Math.max(len, end - start);
            }
            return len;
        }
    }
}
