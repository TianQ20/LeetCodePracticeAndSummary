package LinkedLists;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Q2_ReturnKthToLast_C {

    public static LinkedListNode nthToLast(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // Two pointers. p1 is the fast one, p2 is the slow one.
        // When p1 arrive the end, p2 exactly arrive at kth node's location.

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }
        
        /* Move them at the same pace. When p1 hits the end,
         * p2 will be at the right element. */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            LinkedListNode node = nthToLast(head, i);
            String nodeValue = node == null ? "null" : "" + node.data;
            System.out.println(i + ": " + nodeValue);
        }
    }
}
