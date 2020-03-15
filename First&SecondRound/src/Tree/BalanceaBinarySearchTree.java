package Tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceaBinarySearchTree {
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
        
        List<Integer> sortedArr = new ArrayList<>();

        public TreeNode balanceBST(TreeNode root) {
            inorderTraverse(root);
            return sortedArrayToBST(0, sortedArr.size() - 1);
        }

        private void inorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }
            inorderTraverse(root.left);
            sortedArr.add(root.val);
            inorderTraverse(root.right);
        }

        TreeNode sortedArrayToBST(int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(sortedArr.get(mid));
            root.left = sortedArrayToBST(start, mid - 1);
            root.right = sortedArrayToBST(mid + 1, end);
            return root;
        }
    }
}
