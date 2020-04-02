package Search_DFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            if (n <= 0) {
                return list;
            }
            DFS(list, "", n, n);
            return list;
        }

        public void DFS(List<String> list, String curr, int left, int right) {
            if (left == 0 && right == 0) {
                list.add(curr);
                return;
            }

            if (left > 0) {
                DFS(list, curr + "(", left - 1, right);
            }

            if (right > 0 && right > left) {
                DFS(list, curr + ")", left, right - 1);
            }
        }
    }
}
