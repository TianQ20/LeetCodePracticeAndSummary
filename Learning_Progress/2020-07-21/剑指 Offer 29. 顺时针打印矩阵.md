# 剑指 Offer 29. 顺时针打印矩阵

draw the picture then you can find the pattern.

```java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[] {};
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1;
        int left = 0, right = n - 1;

        while (res.size() < m * n) {
            for (int j = left; j <= right && res.size() < m * n; j++) {
                res.add(matrix[up][j]);
            }
            up++;

            for (int i = up; i <= down && res.size() < m * n; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            for (int j = right; j >= left && res.size() < m * n; j--) {
                res.add(matrix[down][j]);
            }
            down--;

            for (int i = down; i >= up && res.size() < m * n; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        int[] ans = new int[m * n];
        for (int k = 0; k < m * n; k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }
}
```
