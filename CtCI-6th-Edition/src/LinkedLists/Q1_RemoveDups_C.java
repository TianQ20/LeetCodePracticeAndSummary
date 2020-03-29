package LinkedLists;

import CtCILibrary.LinkedListNode;

public class Q1_RemoveDups_C {

    public static void deleteDups(LinkedListNode head) {
        if (head == null) {
            return;
        }
        LinkedListNode previous = head;
        LinkedListNode current = previous.next;
        while (current != null) {
            LinkedListNode runner = head; // runner 每次都从head开始，然后沿着指向遍历，每次都只需要删除一个重复的节点，因为之前的重复节点必已被删掉。

            while (runner != current) {
                if (runner.data == current.data) {
                    LinkedListNode tmp = current.next;
                    previous.next = tmp;
                    current = tmp;
                    break;
                }
                runner = runner.next;
            }

            if (runner == current) { // 此时runner刚好移到current的节点上，此时不需要比较，因为自己和自己不是重复节点。
                previous = current;
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDups(head);
        System.out.println(head.printForward());
    }
}
