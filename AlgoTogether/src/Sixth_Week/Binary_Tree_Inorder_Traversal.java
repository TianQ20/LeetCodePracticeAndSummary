package Sixth_Week;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {
    /**
     * recursive, O(n)
     */
    class Solution_1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }

        private void dfs(TreeNode node, List<Integer> res) {
            if (node == null) return;

            dfs(node.left, res);
            res.add(node.val);
            dfs(node.right, res);
        }
    }

    /**
     * iterative, O(n)
     */
    class Solution_2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) { // Travel to each node's left child, till reach the left leaf
                    stack.push(cur);
                    cur = cur.left;
                }

                cur = stack.pop(); // backtrack to higher node A
                res.add(cur.val); // add this node into res
                cur = cur.right; // switch to A's right branch
            }
            return res;
        }
    }
}
