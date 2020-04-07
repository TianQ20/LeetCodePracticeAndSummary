package Search_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (char[] row : board) {
                Arrays.fill(row, '.');
            }
            List<List<String>> res = new ArrayList<List<String>>();
            dfs(board, 0, res);
            return res;
        }

        private void dfs(char[][] board, int colIndex, List<List<String>> res) {
            if (colIndex == board.length) {
                res.add(construct(board));
                return;
            }

            for (int i = 0; i < board.length; i++) {
                if (available(board, i, colIndex)) {
                    board[i][colIndex] = 'Q';
                    dfs(board, colIndex + 1, res);
                    board[i][colIndex] = '.';
                }
            }
        }

        private boolean available(char[][] board, int x, int y) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < y; j++) {
                    // 3 possible positions in the left column that can be in conflict with current Q.
                    // 135 degree, horizontally left and 45 degree
                    // (y - j) / (x - i) = -1
                    // (y - j) / (x - i) = 1
                    // x = i
                    if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private List<String> construct(char[][] board) {
            List<String> ans = new ArrayList<String>();
            for (int i = 0; i < board.length; i++) {
                String s = new String(board[i]);
                ans.add(s);
            }
            return ans;
        }
    }
}
