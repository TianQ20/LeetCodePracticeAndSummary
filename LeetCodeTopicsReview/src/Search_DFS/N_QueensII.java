package Search_DFS;

public class N_QueensII {
    class Solution {
        int res = 0;
        public int totalNQueens(int n) {
            boolean[] cols = new boolean[n];
            boolean[] diag1 = new boolean[2 * n - 1];
            boolean[] diag2 = new boolean[2 * n - 1];
            dfs(n, cols, diag1, diag2, 0);
            return res;
        }

        private void dfs(int n, boolean[] cols, boolean[] diag1, boolean[] diag2, int row) {
            if (row == n) {
                res++;
                return;
            }

            for (int col = 0; col < n; col++) {
                if (cols[col] || diag1[col + row] || diag2[row - col + n - 1]) continue;
                cols[col] = diag1[col + row] = diag2[row - col + n - 1] = true;
                dfs(n, cols, diag1, diag2, row + 1);
                cols[col] = diag1[col + row] = diag2[row - col + n - 1] = false;
            }
        }
    }
}
