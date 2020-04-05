package Tree;

public class CousinsinBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            preOrder(root, x, y, null, 0);
            return dx == dy && px != py;
        }

        private TreeNode px, py;
        private int dx, dy;

        private void preOrder(TreeNode root, int x, int y, TreeNode p, int d) {
            if (root == null) {
                return;
            }

            if (root.val == x) {
                px = p;
                dx = d;
            }
            if (root.val == y) {
                py = p;
                dy = d;
            }

            preOrder(root.left, x, y, root, d + 1);
            preOrder(root.right, x, y, root, d + 1);
        }
    }
}
