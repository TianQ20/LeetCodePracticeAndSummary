package Tree;

public class InvertBinaryTree {
    class Solution1 {
        private TreeNode tmp = null;

        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            invertTree(root.left);
            invertTree(root.right);
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            return root;
        }
    }


    class Solution2 {
        public TreeNode invertTree(TreeNode root) {
            if (null == root) {
                return null;
            }

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;

            return root;
        }
    }
}
