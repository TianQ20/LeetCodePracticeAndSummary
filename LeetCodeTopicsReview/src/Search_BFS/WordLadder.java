package Search_BFS;

import java.util.*;

public class WordLadder {
    // One way BFS, looking for goal during the one way search.

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<>();
            for (String word : wordList) {
                dict.add(word);
            }
            if (!dict.contains(endWord)) {
                return 0;
            }

            Queue<String> q = new ArrayDeque<>();
            q.offer(beginWord);

            int step = 0;
            int l = beginWord.length();

            while (!q.isEmpty()) {
                ++step;
                for (int s = q.size(); s > 0; --s) {
                    String w = q.poll();
                    char[] chs = w.toCharArray();
                    for (int i = 0; i < l; ++i) {
                        char ch = chs[i];
                        for (char c = 'a'; c <= 'z'; ++c) {
                            if (c == ch) {
                                continue; // skip duplicate extra route
                            }
                            chs[i] = c;
                            String t = new String(chs);
                            if (t.equals(endWord)) {
                                return step + 1;
                            }
                            if (!dict.contains(t)) {
                                continue;
                            }
                            dict.remove(t);
                            q.offer(t);
                        }
                        chs[i] = ch;
                    }
                }
            }
            return 0;
        }
    }
}
