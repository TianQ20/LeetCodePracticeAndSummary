# 剑指 Offer: 二叉树的最近公共祖先

**剑指 Offer 68 - I. 二叉搜索树的最近公共祖先**
using the feature of the BST: `root.left.val < root.val < root.right.val`

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
```

**剑指 Offer 68 - II. 二叉树的最近公共祖先**
Recustion.
there is only three circumstances:

1. q, p are on two sides, so current node is the result

2. both on left side (keep recursion)

3. both on rifht side (keep recursion)

Be care of edge case:
when reach the end (a leaf): `left == null && right == null`, it means there is no valid result, just return null.

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
```
