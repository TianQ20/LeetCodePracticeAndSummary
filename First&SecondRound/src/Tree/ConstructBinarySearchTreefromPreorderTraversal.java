package Tree;

public class ConstructBinarySearchTreefromPreorderTraversal {

    // Time: O(nlogn)
    // Space: O(2^n)

    class Solution_1 {
        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, 0, preorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int start, int end) {
            if (start > end) return null;
            TreeNode root = new TreeNode(preorder[start]); // preorder the first one will be root

            // example: Input: [8,5,1,7,10,12]
            int i;
            for (i = start; i <= end; i++) {
                if (preorder[i] > root.val) break; // only left side can continue
            }

            root.left = helper(preorder, start + 1, i - 1); // left subtree
            root.right = helper(preorder, i, end); // right subtree
            return root;
        }
    }

    
    // Time: O(n)
    // Space: O(2^n)
    class Solution_2 {
        int i = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            return bstHelper(preorder, Integer.MAX_VALUE);
        }

        private TreeNode bstHelper(int[] preorder, int bound) {
            if (i == preorder.length || preorder[i] > bound) return null;

            TreeNode root = new TreeNode(preorder[i++]);
            root.left = bstHelper(preorder, root.val); // take the elements smaller than node.val
            root.right = bstHelper(preorder, bound); // take the remaining elements smaller than bound
            return root;
        }
    }
}
