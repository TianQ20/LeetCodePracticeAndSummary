package Top50LeetCode;

public class MergeTwoSortedLists {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Divide and Conquer
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode lastNode = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    lastNode.next = l2;
                    l2 = l2.next;
                } else {
                    lastNode.next = l1;
                    l1 = l1.next;
                }
                lastNode = lastNode.next;
            }
            if (l1 != null) {
                lastNode.next = l1;
            } else {
                lastNode.next = l2;
            }
            return dummy.next;
        }
    }
}
