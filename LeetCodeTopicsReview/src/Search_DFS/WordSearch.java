package Search_DFS;

public class WordSearch {
    class Solution {
        public boolean exist(char[][] board, String word) {
            if (board.length == 0) return false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (find(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean find(char[][] board, String word, int d, int x, int y) {
            if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || word.charAt(d) != board[x][y]) {
                return false;
            }

            if (d == word.length() - 1) {
                return true;
            }
            char cur = board[x][y];
            board[x][y] = 0;
            boolean result = find(board, word, d + 1, x + 1, y)
                    || find(board, word, d + 1, x - 1, y)
                    || find(board, word, d + 1, x, y + 1)
                    || find(board, word, d + 1, x, y - 1);
            board[x][y] = cur;
            return result;
        }
    }
}
