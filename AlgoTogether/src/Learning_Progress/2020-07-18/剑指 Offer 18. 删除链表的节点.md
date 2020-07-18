# 剑指 Offer 18. 删除链表的节点

two pointers solution, store prev and cur, then connect them.

```java
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;

        ListNode cur = head;
        if (cur.val == val) { // delete the first one
            return head.next;
        }

        // delete others
        ListNode prev = null;
        while (cur.next != null && cur.val != val) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return head;
    }
}

```
