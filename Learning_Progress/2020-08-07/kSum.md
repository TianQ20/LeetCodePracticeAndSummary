# kSum

```java
public int kSum(int[] A, int k, int target) {
        // 1 <= i <= n
        // 1 <= j <= k && j <= i
        // dp[i][j][target] = dp[i - 1][j - 1][target - A[i - 1]]
        int n = A.length;
        int[][][] dp = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    dp[i][j][t] = 0;
                    if (t >= A[i - 1]) {
                        dp[i][j][t] = dp[i - 1][j - 1][t - A[i - 1]];
                    }
                    dp[i][j][t] += dp[i - 1][j][t];
                }
            }
        }
        return dp[n][k][target];
    }
```
