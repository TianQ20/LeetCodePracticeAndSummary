package Tree;

public class PathSumIII {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    int result = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return result;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) return;
        if (sum - root.val == 0) {
            result += 1;
        }
        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
    }
}