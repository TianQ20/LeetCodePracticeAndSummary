package Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    // preOrder : root -> left -> right.
    // inOrder : left -> root -> right.
    // The general approach is use the the root value in preOrder array, then we use the inOrder array to identify left sides nodes and right side nodes, do this recursively.

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    class Solution1 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return helper(0, 0, inorder.length - 1, preorder, inorder);
        }

        private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
            if (preStart > preorder.length - 1 || inStart > inEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            int inIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == root.val) {
                    inIndex = i;
                }
            }
            root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder); // left side
            root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder); // right side
            return root;
        }
    }


    // use HashMap to reduce the time, no need to traverse inOrder array every time to find the current root location.

    class Solution2 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
            return root;
        }

        public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            int inRoot = inMap.get(root.val);
            int numsLeft = inRoot - inStart;

            root.left = helper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
            root.right = helper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

            return root;
        }
    }
}
