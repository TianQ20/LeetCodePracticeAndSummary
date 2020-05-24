package ThirdWeek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal {

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }


    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode head = q.poll();
                    level.add(head.val);
                    if (head.left != null) {
                        q.add(head.left);
                    }
                    if (head.right != null) {
                        q.add(head.right);
                    }
                }
                res.add(level);
            }
            return res;
        }
    }
}
