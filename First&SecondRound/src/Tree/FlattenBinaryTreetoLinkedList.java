package Tree;

public class FlattenBinaryTreetoLinkedList {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    // use a PostOrder traverse to build the LinkedList.

    class Solution {

        private TreeNode prev = null;

        public void flatten(TreeNode root) {

            // post order traversal in (right, left, root) order like [6->5->4->3->2->1].
            if (root == null) {
                return;
            }
            flatten(root.right);
            flatten(root.left);

            // set each node's right pointer as the previous one in [6->5->4->3->2->1],
            // and set the left child as null to get [1->2->3->4->5->6].
            root.left = null;
            root.right = prev;
            prev = root;
        }
    }
}
