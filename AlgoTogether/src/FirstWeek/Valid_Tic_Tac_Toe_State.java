package FirstWeek;

public class Valid_Tic_Tac_Toe_State {
    class Solution {
        public boolean validTicTacToe(String[] board) {
            if (board == null || board.length == 0) {
                return false;
            }
            int n = board.length;

            int[] rows = new int[n];
            int[] cols = new int[n];
            int diag = 0, antidiag = 0, turns = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int add = 0;
                    if (board[i].charAt(j) == 'X') {
                        add = 1;
                        turns++;
                    } else if (board[i].charAt(j) == 'O') {
                        add = -1;
                        turns--;
                    }
                    rows[i] += add;
                    cols[j] += add;
                    if (i == j) {
                        diag += add;
                    }

                    if (i + j == n - 1) {
                        antidiag += add;
                    }
                }
            }

            boolean xwin = false, owin = false;
            // check rows & cols, diag and antidiag
            for (int i = 0; i < n; i++) {
                xwin = xwin || (rows[i] == n) || (cols[i] == n) || (diag == n) || (antidiag == n);
                owin = owin || (rows[i] == -n) || (cols[i] == -n) || (diag == -n) || (antidiag == -n);
            }

            /**
             * When X wins, O cannot move anymore, so turns must be 1.
             * When O wins, X cannot move anymore, so turns must be 0. 
             * Finally, when we return, turns must be either 0 or 1, and X and O cannot win at same time.
             */
            if (xwin && turns != 1 || owin && turns != 0 || xwin && owin) {
                return false;
            }
            return turns == 0 || turns == 1;

        }
    }
}
