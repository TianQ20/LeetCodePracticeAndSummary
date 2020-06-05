import java.util.HashMap;
import java.util.Map;

public class p7 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }


    class Solution {
        // preOrder: root -> left -> right
        // inOrder: left -> root -> right
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i); // record inorder position
            }
            TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
            return root;
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
            if (preStart > preEnd || inStart > inEnd) return null;

            TreeNode root = new TreeNode(preorder[preStart]);
            int inRoot = inMap.get(root.val);
            int numsLeft = inRoot - inStart;

            root.left = buildTree(preorder, preStart + 1, preEnd, inorder, inStart, inRoot - 1, inMap);
            root.right = buildTree(preorder, preStart + 1 + numsLeft, preEnd, inorder, inRoot + 1, inEnd, inMap);

            return root;
        }
    }
}
