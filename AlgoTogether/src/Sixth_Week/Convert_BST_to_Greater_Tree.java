package Sixth_Week;

public class Convert_BST_to_Greater_Tree {
    class Solution_1 { // reverse inorder traversal
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            if (root == null) return null;

            convertBST(root.right);

            root.val += sum;
            sum = root.val;

            convertBST(root.left);
            return root;
        }
    }


    /**
     * avoid use global variable
     */
    class Solution_2 {
        public TreeNode convertBST(TreeNode root) {
            dfs(root, 0);
            return root;
        }

        // sum   : all nodes which we have traversed thus far
        // return: root.val + sum of all nodes greater than root
        private int dfs(TreeNode root, int sum) {
            if (root == null) return sum;

            int rightSum = dfs(root.right, sum);
            root.val += rightSum;
            return dfs(root.left, root.val);
        }
    }
}
