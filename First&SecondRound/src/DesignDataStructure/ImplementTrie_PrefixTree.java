package DesignDataStructure;

public class ImplementTrie_PrefixTree {
    class TrieNode {
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    ws.children[c - 'a'] = new TrieNode();
                }
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        public TrieNode searchHelper(String s) {
            TrieNode ws = root;
            for (int i = 0; i < s.length() && ws != null; i++) {
                char c = s.charAt(i);
                ws = ws.children[c - 'a'];
            }
            return ws;
        }

        public boolean search(String word) {
            TrieNode ws = searchHelper(word);
            return ws != null && ws.isWord;
        }

        public boolean startsWith(String prefix) {
            return searchHelper(prefix) != null;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
