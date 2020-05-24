package ThirdWeek;

import java.util.Stack;

public class Flatten_Binary_Tree_to_LinkedList {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    /**
     An in-place algorithm is an algorithm that does not need an extra space
     and produces an output in the same memory that contains the data by transforming the input ‘in-place’.
     However, a small constant extra space used for variables is allowed.
     */

    class Solution_stack {
        public void flatten(TreeNode root) {
            if (root == null) return;

            Stack<TreeNode> stack = new Stack();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode curr_node = stack.pop();

                if (curr_node.right != null) {
                    stack.push(curr_node.right);
                }

                if (curr_node.left != null) {
                    stack.push(curr_node.left);
                }

                if (!stack.isEmpty()) {
                    curr_node.right = stack.peek();
                }

                curr_node.left = null;
            }
        }
    }


    class Solution_recursion {
        public void flatten(TreeNode root) {
            if (root == null) return;

            flatten(root.left);
            flatten(root.right);
            if (root.left == null) return;

            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right; // after the loop the node will be the last leaf of left subtree
            }

            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
