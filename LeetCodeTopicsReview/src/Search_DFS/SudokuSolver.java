package Search_DFS;

public class SudokuSolver {
    class Solution {
        public void solveSudoku(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            solve(board);
        }

        public boolean solve(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '.') {
                        for (char c = '1'; c <= '9'; c++) {
                            if (isValid(board, i, j , c)) {
                                board[i][j] = c;
                                if (solve(board)) {
                                    return true;
                                } else {
                                    board[i][j] = '.';
                                }
                            }
                        }

                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int row, int col, char c) {
            int block_row = (row / 3) * 3, block_col = (col / 3) * 3;
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == c || board[row][i] == c || board[block_row + i / 3][block_col + i % 3] == c) {
                    return false;
                }
            }
            return true;
        }
    }
}
