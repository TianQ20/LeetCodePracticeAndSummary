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

`O(1)` ListNode solution, only when delete the tail node need `O(n)`, so it's general `O(1)`.

```java
class deleteNode {public static ListNode deleteNode(ListNode head, ListNode val){
        if (head == null || val == null){
            return null;
        }
        if (val.next != null){   // 待删除节点不是尾节点
            ListNode next = val.next;
            val.val = next.val;
            val.next = next.next;
        } else if (head == val){   // 待删除节点只有一个节点，此节点为头节点, 删掉直接返回null了
            head = null;
        } else {   // 待删除节点为尾节点
            ListNode cur = head;
            while (cur.next != val){
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }
}
```
