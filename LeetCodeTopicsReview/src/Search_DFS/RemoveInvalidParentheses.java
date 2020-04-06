package Search_DFS;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            int l = 0, r = 0;

            for (char c : s.toCharArray()) {
                if (c == '(') l++;
                if (l == 0) {
                    if (c == ')') {
                        r++;
                    }
                } else if (l != 0) {
                    if (c == ')') {
                        l--;
                    }
                }
            }

            List<String> res = new ArrayList<>();
            dfs(s, 0, l, r, res);
            return res;
        }

        private boolean isValid(String s) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    count++;
                } else if (c ==')') {
                    count--;
                }
                if (count < 0) return false;
            }
            return count == 0;
        }

        // l/r: number of left/right parentheses to remove.
        private void dfs(String s, int start, int l, int r, List<String> res) {
            if (l == 0 && r == 0) {
                if (isValid(s)) {
                    res.add(s);
                    return;
                }
            }

            for (int i = start; i < s.length(); ++i) {
                // We only remove the first parenthes if there are consecutive ones to avoid duplications.
                if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;

                char ch = s.charAt(i);
                if (ch == '(' || ch == ')') {
                    String curr = s.substring(0, i) + s.substring(i + 1, s.length());
                    if (r > 0 && s.charAt(i) == ')') {
                        dfs(curr, i, l, r - 1, res);
                    } else if (l > 0 && s.charAt(i) == '(') {
                        dfs(curr, i, l - 1, r, res);
                    }
                }
            }
        }
    }
}
