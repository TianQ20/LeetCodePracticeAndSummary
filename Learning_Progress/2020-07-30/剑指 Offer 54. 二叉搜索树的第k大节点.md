# 剑指 Offer 54. 二叉搜索树的第k大节点

Inorder traversal + stack.

```java
class Solution {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        inorder(root, stack);
        while (k-- > 1) {
            stack.pop();
        }
        return stack.peek().val;
    }

    private void inorder(TreeNode root, Stack<TreeNode> stack) {
        if (root == null) return;
        inorder(root.left, stack);
        stack.push(root);
        inorder(root.right, stack);
    }
}
```
