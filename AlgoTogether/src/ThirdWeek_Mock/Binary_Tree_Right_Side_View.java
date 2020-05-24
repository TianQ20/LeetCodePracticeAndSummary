package ThirdWeek_Mock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();

                while (size-- > 0) { // Do the level order traversal, and add the last node on every layer.
                    TreeNode cur = q.poll();
                    if (size == 0) {
                        res.add(cur.val);
                    }

                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
            }
            return res;
        }
    }
}
