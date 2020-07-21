# 剑指 Offer 24. 反转链表

recursion.

```java
Initial: 1 -> 2 -> 3 -> 4 -> 5 -> null

head = 5, newHead = reverseList(null) = null

head = 4
newHead = reverseList(5)
1 -> 2 -> 3 -> 4 <- 5
               |
               null

head = 3
newHead = reverseList(4)
1 -> 2 -> 3 <- 4 <- 5
          |
          null

head = 2
newHead = reverseList(3)
1 -> 2 <- 3 <- 4 <- 5
     |
     null

head = 1
newHead = reverseList(2)
1 <- 2 <- 3 <- 4 <- 5
|
null

Since it‘s recursion, finally the newHead should be 5, but in the process of recursion, the requence should follow above description.
```

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
```

Iteration.

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmpNext = cur.next; // store next one node information from cur
            cur.next = prev; // point back
            prev = cur; // update prev
            cur = tmpNext; // move to already stored node
        }
        return prev;
    }
}
```

![reverseList](reverseList.jpg)
