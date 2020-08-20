# 剑指 Offer 60. n个骰子的点数

DP.

```java
class Solution {
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        double all = Math.pow(6, n);
        double[] ans = new double[5 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i][j] += j > k ? dp[i - 1][j - k] : 0;
                    if (i == n) {
                        ans[j - i] = dp[i][j] / all;
                    }
                }
            }
        }
        return ans;
    }
}
```

为什么一维DP需要从后往前遍历？

因为可以注意到二维循环的时候用到了`dp[i][j] += dp[i - 1][j - k]`，一维的时候变成了`dp[j] += dp[j - k]`， 也就是会用到上一行前几列的值，如果正向遍历的话，求的时候每次 dp[j] 都会被更新，那么后面的 dp[j] += dp[j - k] 加的 dp[j-k] 在前面已经更新过了，就不是上一行的 dp[j-k] 了，所以会出错。

```java
class Solution {
    public double[] twoSum(int n) {
        double[] dp = new double[6 * n + 1];
        double[] ans = new double[5 * n + 1];
        double all = Math.pow(6, n);
        for(int i = 1; i <= 6; i++){
            dp[i] = 1;
            ans[i-1] = 1.0 / 6;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 6 * n; j >= 1; j--) {
                int tmp = 0;
                for (int k = 1; k <= 6; k++) {
                    tmp += j >= k ? dp[j - k] : 0;
                }
                dp[j] = tmp;
                if (i == n && j >= n) {
                    ans[j - i] = dp[j] / all;
                }
            }
        }
        return ans;
    }
}
```
