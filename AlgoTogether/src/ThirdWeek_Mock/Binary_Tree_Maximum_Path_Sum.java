package ThirdWeek_Mock;

public class Binary_Tree_Maximum_Path_Sum {
    class Solution {
        int res;
        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;
            res = Integer.MIN_VALUE;
            getMax(root);
            return res;
        }

        private int getMax(TreeNode root) {
            if (root == null) return 0;
            int l = Math.max(0, getMax(root.left));
            int r = Math.max(0, getMax(root.right));
            int sum = l + r + root.val;
            res = Math.max(sum, res);
            return Math.max(l, r) + root.val;
        }
    }
}
