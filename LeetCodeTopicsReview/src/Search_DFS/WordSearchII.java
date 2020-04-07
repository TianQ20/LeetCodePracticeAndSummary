package Search_DFS;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    class Solution_DFS {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            for (String word : words) {
                if (exist(board, word)) {
                    res.add(word);
                }
            }
            return res;
        }

        private boolean exist(char[][] board, String word) {
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
            board[x][y] = '#';
            boolean result = find(board, word, d + 1, x + 1, y)
                    || find(board, word, d + 1, x - 1, y)
                    || find(board, word, d + 1, x, y + 1)
                    || find(board, word, d + 1, x, y - 1);
            board[x][y] = cur;
            return result;
        }
    }


    class Solution_Trie {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            TrieNode root = buildTrie(words);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, root, res);
                }
            }
            return res;
        }

        public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
            char c = board[i][j];
            if (c == '#' || p.next[c - 'a'] == null) {
                return;
            }
            p = p.next[c - 'a'];
            if (p.word != null) { // found one
                res.add(p.word);
                p.word = null; // de-duplicate
            }

            board[i][j] = '#';
            if (i > 0) dfs(board, i - 1, j, p, res);
            if (j > 0) dfs(board, i, j - 1, p, res);
            if (i < board.length - 1) dfs(board, i + 1, j, p, res);
            if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
            board[i][j] = c;
        }

        public TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();
            for (String w : words) {
                TrieNode p = root;
                for (char c : w.toCharArray()) {
                    int i = c - 'a';
                    if (p.next[i] == null) {
                        p.next[i] = new TrieNode();
                    }
                    p = p.next[i];
                }
                p.word = w;
            }
            return root;
        }

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            String word;
        }
    }
}
