package LinkedLists;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Q3_DeleteMiddleNode {

    public static boolean deleteNode(LinkedListNode node) {
        if (node == null || node.next == null) {
            return false; // failure
        }
        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }


    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
        deleteNode(head.next); // delete node 1 and 4
        System.out.println(head.printForward());
    }
}