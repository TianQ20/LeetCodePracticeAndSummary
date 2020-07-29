# 剑指 Offer 48. 最长不含重复字符的子字符串 && 3. Longest Substring Without Repeating Characters

Sliding window.

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, d = 0, counter = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) {
                counter++;
            }
            end++;

            while (counter > 0) {
                char tmp = s.charAt(start);
                if (map.get(tmp) > 1) {
                    counter--;
                }
                map.put(tmp, map.get(tmp) - 1);
                start++;
            }
            d = Math.max(d, end - start);
        }
        return d;
    }
}
```

DP.
Assume the left side closet same character of `s[j]` is `s[i]`.

```java
(1) if i < 0, then dp[j] = dp[j - 1] + 1;
(2) if dp[j - 1] < j - i, means s[i] is not included in dp[j - 1], so dp[j] = dp[j - 1] + 1;
(3) if dp[j - 1] >= j - i, means s[i] is included in dp[j - 1], the left border is determined by s[i], so dp[j] = j - i.
```

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), - 1);
            map.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }
}
```
