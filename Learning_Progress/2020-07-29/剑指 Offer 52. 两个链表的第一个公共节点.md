# 剑指 Offer 52. 两个链表的第一个公共节点

Time: `O(m + n)`, Space: `O(m + n)`.

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Stack<ListNode> stackA = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }

        Stack<ListNode> stackB = new Stack<>();
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode A = stackA.peek(), B = stackB.peek();
            if (A == B) {
                stackA.pop();
                stackB.pop();
                if (stackA.isEmpty() || stackB.isEmpty()) { // in cass of one of stacks is empty after pop
                    return A;
                }
            } else if (stackA.peek() != stackB.peek()) {
                ListNode tmp = stackA.peek();
                return tmp.next;
            }
        }
        return null;
    }
}
```

Time: `O(m + n)`, Space: `O(1)`.

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            return getRes(headA, headB, diff);
        } else {
            return getRes(headB, headA, diff);
        }
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private ListNode getRes(ListNode longer, ListNode shorter, int diff) {
        int index = 0;
        while (index < diff) {
            longer = longer.next;
            index++;
        }
        while (longer != null && shorter != null) {
            if (longer == shorter) {
                return shorter;
            } else {
                longer = longer.next;
                shorter = shorter.next;
            }
        }
        return null;
    }
}
```
