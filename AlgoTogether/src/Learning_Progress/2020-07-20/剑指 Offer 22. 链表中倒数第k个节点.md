# 剑指 Offer 22. 链表中倒数第k个节点

record lenght, then find the `(len + 1 - k)` one.

```java
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }

        int idx = len + 1 - k; // fix with index the last one is related with 1
        int j = 1; // fix index start from 1
        ListNode node = head;
        while (j <= idx) {
            node = node.next;
            idx--;
        }
        return node;
    }
}
```

two pointers.

```java
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && k-- > 1) { // fix index
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```
