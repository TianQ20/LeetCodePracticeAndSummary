package DFS;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true; // jump out of the recursion
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(index)) {
            return false;
        }
        board[i][j] = '0'; // should remember to mark it, The same letter cell may not be used more than once.
        boolean result =
                find(board, i + 1, j, word, index + 1) ||
                find(board, i - 1, j, word, index + 1) ||
                find(board, i, j + 1, word, index + 1) ||
                find(board, i, j - 1, word, index + 1);

        board[i][j] = word.charAt(index); // 回溯
        return result;
    }
}
