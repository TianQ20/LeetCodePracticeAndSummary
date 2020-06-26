package Seventh_Week_Mock;

import java.util.PriorityQueue;

public class Smallest_String_Starting_From_Leaf {
    class Solution_1 {
        public String smallestFromLeaf(TreeNode root) {
            String s = "";
            return dfs(root, s);
        }

        private String dfs(TreeNode root, String s) {
            if (root == null) {
                return "~";
            }

            s = (char)(root.val + 'a') + s;
            String left = dfs(root.left, s);
            String right = dfs(root.right, s);
            if (left == right && left == "~") { // null node returns '~' which takes care of situations where node has only one child
                return s;
            } else {
                return left.compareTo(right) > 0 ? right : left; // compareTo() method is used for comparing two strings lexicographically
            }
        }
    }

    class Solution_2 {
        PriorityQueue<String> q = new PriorityQueue<>();
        public String smallestFromLeaf(TreeNode root) {
            getPath(root, "");
            return q.peek();
        }

        private void getPath(TreeNode root, String suffix) {
            if (root == null) return;

            suffix = (char)(root.val + 'a') + suffix;
            if (root.left == null && root.right == null) {
                q.add(suffix);
            }
            getPath(root.left, suffix);
            getPath(root.right, suffix);
        }
    }
}
