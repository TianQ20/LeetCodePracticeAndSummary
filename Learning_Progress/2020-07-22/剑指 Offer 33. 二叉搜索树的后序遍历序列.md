# 剑指 Offer 33. 二叉搜索树的后序遍历序列

Naive recursion.

```java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) return true;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < postorder.length; j++) {
            list.add(postorder[j]);
        }
        return isSubTree(list);
    }

    private boolean isSubTree(List<Integer> list) {
        int n = list.size();
        if (n <= 1) return true;
        int root = list.get(n - 1);
        List<Integer> left = new ArrayList<>();
        int i = 0;
        for (; i < n - 1; i++) {
            if (list.get(i) < root) {
                left.add(list.get(i));
            } else break; // seperate left and right area
        }
        List<Integer> right = new ArrayList<>();
        for (; i < n - 1; i++) {
            if (list.get(i) > root) {
                right.add(list.get(i));
            } else return false; // should not have any node.val < root.val in the right subtree
        }
        return isSubTree(left) && isSubTree(right);
    }
}
```

Concise recursion.

```java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1); // root = postorder[postorder.length - 1]
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true; // i >= j ，subtree children number <= 1, return true
        int index = i;
        while (postorder[index] < postorder[j]) {
            index++;
        }

        int m = index; // seperate left: [i, m - 1], right: [m, j - 1]

        while (postorder[index] > postorder[j]) {
            index++;
        }
        return (index == j) && recur(postorder, i, m - 1) && recur(postorder, m, j - 1); // index == j means this tree is valid(left child + right child == length - 1)
    }
}
```

Monotonic stack.

```java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int n  = postorder.length;
        int prev = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            // // 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
            if (postorder[i] > prev) {
                return false;
            }
            // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
            // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
            while (!stack.isEmpty() && postorder[i] < stack.peek()) {
                prev = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
```
