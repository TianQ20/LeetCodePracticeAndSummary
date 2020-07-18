# 剑指 Offer 13. 机器人的运动范围

## Intuition

Since we know m and n, we can use a 2D array to store their status, fill it with all 0, start from (0, 0), once we visited a point, we put it to 1 as visited, then go 4 directions until meet the end.
To get the digits sum of y and x, I use a tricky string helper, update with math helper.

```java
class Solution {
    int ans = 0;
    public int movingCount(int m, int n, int k) {
        int[][] grid = new int[m][n];
        dfs(m, n, k, 0, 0, grid);
        return ans;
    }

    private void dfs(int m, int n, int k, int y, int x, int[][] grid) {
        if (y > m - 1 || y < 0 || x > n - 1 || x < 0 || get(y) + get(x) > k || grid[y][x] == 1) return;
        ans += 1;
        grid[y][x] = 1;
        dfs(m, n, k, y + 1, x, grid);
        dfs(m, n, k, y - 1, x, grid);
        dfs(m, n, k, y, x + 1, grid);
        dfs(m, n, k, y, x - 1, grid);
    }

    private int get(int x) {
        String s = String.valueOf(x);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(i) - '0';
        }
        return res;
    }

    // math helper
    private int get(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
```
