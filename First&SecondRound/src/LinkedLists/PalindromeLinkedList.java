package LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    // Copy into an ArrayList, two pointers. O(N)

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode curNode = head;
        while (curNode != null) {
            list.add(curNode.val);
            curNode = curNode.next;
        }

        int start = 0, end = list.size() - 1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}


    // Make recursive calls until you reach the last element.
    // On returning from each recursion, check if it is equal to curr values.
    // curr values are updated to on each recursion.

    class Solution2 {
        ListNode curr;
        public boolean isPalindrome(ListNode head) {
            curr = head;
            return check(head);
        }

        private boolean check(ListNode node) {
            if (node == null) {
                return true;
            }
            boolean res = check(node.next);
            boolean isEqual = (curr.val == node.val ? true : false);
            curr = curr.next;
            return res && isEqual;
        }
    }
