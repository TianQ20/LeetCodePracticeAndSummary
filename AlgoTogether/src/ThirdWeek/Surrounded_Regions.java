package ThirdWeek;

import java.util.HashMap;
import java.util.Map;

public class Surrounded_Regions {
    class Solution {
        public void solve(char[][] board) {
            int m = board.length;
            if (m == 0) return;
            int n = board[0].length;

            for (int y = 0; y < m; ++y) {
                dfs(board, 0, y);
                dfs(board, n - 1, y);
            }

            for (int x = 0; x < n; ++x) {
                dfs(board, x, 0);
                dfs(board, x, m - 1);
            }

            Map<Character, Character> map = new HashMap<>();
            map.put('G', 'O'); // no need to flip
            map.put('O', 'X');
            map.put('X', 'X');

            for (int y = 0; y < m; ++y) {
                for (int x = 0; x < n; ++x) {
                    board[y][x] = map.get(board[y][x]);
                }
            }
        }

        private void dfs(char[][] board, int x, int y) {
            int n = board[0].length;
            int m = board.length;

            if (x < 0 || x >= n || y < 0 || y >= m || board[y][x] != 'O') return;
            board[y][x] = 'G';
            dfs(board, x - 1, y);
            dfs(board, x + 1, y);
            dfs(board, x, y - 1);
            dfs(board, x, y + 1);
        }
    }
}
