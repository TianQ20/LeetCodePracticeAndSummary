package Sixth_Week;

import java.util.HashMap;
import java.util.Map;

public class Add_and_Search_Word_Trie {
    class WordDictionary {

        private class TrieNode {
            Map<Character, TrieNode> children;
            boolean endOfWord;
            public TrieNode() {
                children = new HashMap<>();
                endOfWord = false;
            }
        }
        private final TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.children.get(ch);
                if (node == null) {
                    node = new TrieNode();
                    current.children.put(ch, node);
                }
                current = node;
            }
            current.endOfWord = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return searchRecursive(root, word, 0);
        }

        private boolean searchRecursive(TrieNode current, String word, int index) {
            if (index == word.length()) {
                return current.endOfWord;
            }
            char ch = word.charAt(index);
            if (ch != '.') { // regular trie
                TrieNode node = current.children.get(ch);
                if (node == null) {
                    return false;
                }
                return searchRecursive(node, word, index + 1);
            } else { // ch == '.'
                for (char c : current.children.keySet()) { // search from all exist characters
                    TrieNode tmp = current.children.get(c);
                    if (searchRecursive(tmp, word, index + 1)) { // search for next character
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
