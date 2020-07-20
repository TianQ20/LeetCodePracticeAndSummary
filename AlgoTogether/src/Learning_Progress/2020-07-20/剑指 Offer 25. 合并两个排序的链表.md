# 剑指 Offer 25. 合并两个排序的链表

Verbose but easy understand Iteration.

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;

        // early break
        if (l1 == null && l2 == null) { // both null, return null
            return head;
        }

        if (l1 != null && l2 == null) { // l2 is null, just return l1
            return l1;
        }

        if (l1 == null && l2 != null) { // l1 is null, just return l2
            return l2;
        }

        // if both are not null, choose a smaller value one as head
        if (l1 != null && l2 != null && l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else if (l1 != null && l2 != null && l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        }


        ListNode cur = head; // make a copy of head
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        // if one list have longer length, we just append that to the cur

        // while (l1 != null) {
        //     cur.next = l1;
        //     l1 = l1.next;
        //     cur = cur.next;
        // }

        // while (l2 != null) {
        //     cur.next = l2;
        //     l2 = l2.next;
        //     cur = cur.next;
        // }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head;
    }
}
```
