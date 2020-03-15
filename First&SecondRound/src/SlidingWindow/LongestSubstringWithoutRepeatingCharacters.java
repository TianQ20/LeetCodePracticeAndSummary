package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public class Solution1 {

        // We use HashSet to store the characters in current window [i, j).
        // Then we slide the index j to the right.
        // If it is not in the HashSet, we slide j further.
        // Doing so until s[j] is already in the HashSet.
        // At this point, we found the maximum size of substrings without duplicate characters start with index i.
        // If we do this for all i, we get our answer.

        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }
    }


    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();

            int counter = map.size();
            int begin = 0, end = 0;
            int d = 0;

            while (end < s.length()) {
                // > 0 means repeating character
                // if(map[s.charAt(end++)]-- > 0) counter++;
                char c = s.charAt(end);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) > 1) {
                    counter++;
                }
                end++;

                while (counter > 0) {
                    // if (map[s.charAt(begin++)]-- > 1) counter--;
                    char tempc = s.charAt(begin);
                    if (map.get(tempc) > 1) {
                        counter--;
                    }
                    map.put(tempc, map.get(tempc) - 1);
                    begin++;
                }
                d = Math.max(d, end - begin);
            }
            return d;
        }
    }
}
