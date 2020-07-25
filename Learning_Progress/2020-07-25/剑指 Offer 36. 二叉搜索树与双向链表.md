# 剑指 Offer 36. 二叉搜索树与双向链表 && 426. Convert Binary Search Tree to Sorted Doubly Linked List

divide and conquer

```java
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        return connect(connect(leftHead, root), rightHead);
    }

    private Node connect(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        Node tail1 = n1.left;
        Node tail2 = n2.left;

        tail1.right = n2;
        n2.left = tail1;
        tail2.right = n1;
        n1.left = tail2;

        return n1;
    }
}
```

in order traversal.

```java
class Solution {
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        // pre record node which on the left of cur
        if (pre == null) { // cur is the first node
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur; // pre point to current "cur" node
        dfs(cur.right);
    }
}
```
