# 剑指 Offer 46. 把数字翻译成字符串

DP.

```java
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String tmp = s.substring(i - 2, i);
            if ((tmp).compareTo("10") >= 0 && (tmp).compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
```
