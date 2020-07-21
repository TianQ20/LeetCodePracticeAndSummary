# 剑指 Offer 26. 树的子结构

```java
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recursion(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recursion(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        return (A.val == B.val) && recursion(A.left, B.left) && recursion(A.right, B.right);
    }
}
```
