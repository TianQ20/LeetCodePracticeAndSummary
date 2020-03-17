package Tree;

public class SymmetricTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    // Recursion

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }

        private boolean isMirror(TreeNode t1, TreeNode t2) {
            if (t1 == null || t2 == null) return (t1 == t2);
            return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        }
    }
}
