package BFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // use HashSet.contains is faster than List.contains
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }

        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        // check if the endWord actually exists in the wordList before even processing
        if (!wordSet.contains(endWord)) return 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}
