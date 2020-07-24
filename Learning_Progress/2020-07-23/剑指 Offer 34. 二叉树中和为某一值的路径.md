# 剑指 Offer 34. 二叉树中和为某一值的路径 && 113. Path Sum II

backtracking.

```java
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        dfs(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> tmp) {
        if (root == null) return;

        target -= root.val;
        tmp.add(root.val);

        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(tmp));
        }
        dfs(root.left, target, res, tmp);
        dfs(root.right, target, res, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
```
