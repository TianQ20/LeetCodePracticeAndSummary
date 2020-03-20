package Greedy;

public class HouseRobberIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 0 means not robbed, 1 means has been robbed
    class Solution {
        public int rob(TreeNode root) {
            int[] res = robHelper(root);
            return Math.max(res[0], res[1]);
        }

        private int[] robHelper(TreeNode root) {
            if (root == null) return new int[2];
            int[] left = robHelper(root.left);
            int[] right = robHelper(root.right);
            int[] res = new int[2];

            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            res[1] = root.val + left[0] + right[0];
            return res;
        }
    }
}
