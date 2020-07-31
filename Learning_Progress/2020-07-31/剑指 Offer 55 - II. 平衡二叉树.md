# 剑指 Offer 55 - II. 平衡二叉树

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(left - right) <= 1;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
```

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != - 1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left != - 1) {
            int right = getDepth(root.right);
            if (right != -1) {
                return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
            }
        }
        return - 1;
    }
}
```
