# 剑指 Offer 14- I. 剪绳子 || 343. Integer Break

DP solution.

```java
class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}
```

Math solution.
when n > 4, 3 * (n - 3) > n, 6 = 2 + 2 + 2 = 3 + 3, 2^3 < 3^2, so we need use more 3 and no more than two 2.

```java
class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int max = 1;
        while (n > 4) {
            max *= 3;
            n -= 3;
        }
        max *= n;
        return max;
    }
}
```
