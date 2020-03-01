package Top50LeetCode;

public class ReverseLinkedList {

    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    // Input: 1->2->3->4->5->NULL
    // Output: 5->4->3->2->1->NULL

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                // 每次都更新head及temp，以及prev，直到head == null
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
        }
    }
}
