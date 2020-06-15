package Sixth_Week;


public class Balanced_Binary_Tree {
    /**
     * Top to down.
     *
     * call depth need to go through all children as O(n), we do this to every node in tree => O(n^2)
     */
    class Solution_1 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;

            int left = depth(root.left);
            int right = depth(root.right);

            return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int depth(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }


    /**
     * avoid further search, using -1 as unbalanced signal, O(n)
     */
    class Solution_2 {
        public boolean isBalanced(TreeNode root) {
            return getDepth(root) != -1;
        }

        private int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = getDepth(root.left);
            if (left != -1) {
                int right = getDepth(root.right);
                if (right != -1) {
                    return Math.abs(left - right) <= 1 ? 1 + Math.max(left, right) : -1;
                }
            }
            return -1;
        }
    }
}
