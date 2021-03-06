# 剑指 Offer 35. 复杂链表的复制 138. Copy List with Random Pointer

HashMap `O(n)` time & space solution.

```java
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node oldHead = head;
        Node newHead = null;
        Map<Node, Node> map = new HashMap<>();

        // store mapping from old node to new node(copied node)
        while (oldHead != null) {
            newHead = new Node(oldHead.val);
            map.put(oldHead, newHead);
            oldHead = oldHead.next;
        }

        // build a linkedlist from copied nodes(new)
        oldHead = head;
        while (oldHead != null) {
            newHead = map.get(oldHead);
            newHead.next = map.get(oldHead.next);
            newHead.random = map.get(oldHead.random);
            oldHead = oldHead.next;
        }
        return map.get(head); // copied new linkedlist head
    }
}
```

```java
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node c = head;
        while (c != null) {
            Node next = c.next;
            c.next = new Node(c.val);
            c.next.next = next;
            c = next;
        }

        c = head;
        while (c != null) {
            if (c.random != null) {
                c.next.random = c.random.next;
            }
            c = c.next.next;
        }

        c = head;
        Node copyHead = head.next;
        Node copy = copyHead;
        while (copy.next != null) {
            c.next = c.next.next;
            c = c.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }
        c.next = c.next.next; // seperate head and copyHead
        return copyHead;
    }
}
```

![1](1.jpg)
