package DP;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Naive
    class Solution1 {
        public int rob(TreeNode root) {
            if (root == null) return 0;

            int val = 0;

            if (root.left != null) {
                val += rob(root.left.left) + rob(root.left.right);
            }
            if (root.right != null) {
                val += rob(root.right.left) + rob(root.right.right);
            }

            return Math.max(root.val + val, rob(root.left) + rob(root.right));
        }
    }


    // DP : use a hash map to record the results for visited subtrees
    class Solution2 {
        public int rob(TreeNode root) {
            return robHelper(root, new HashMap<>());
        }

        private int robHelper(TreeNode root, Map<TreeNode, Integer> map) {
            if (root == null) return 0;
            if (map.containsKey(root)) return map.get(root);
            int val = 0;

            if (root.left != null) {
                val += robHelper(root.left.left, map) + robHelper(root.left.right, map);
            }
            if (root.right != null) {
                val += robHelper(root.right.left, map) + robHelper(root.right.right, map);
            }

            val = Math.max(root.val + val, robHelper(root.left, map) + robHelper(root.right, map));
            map.put(root, val);

            return val;
        }
    }
}
