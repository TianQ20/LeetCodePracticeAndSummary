import java.util.ArrayList;
import java.util.Stack;

public class p6 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    class Solution_1 {
        public int[] reversePrint(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                stack.add(head);
                head = head.next;
            }
            int size = stack.size();
            int[] res = new int[size];
            int i = 0;
            while (!stack.isEmpty()) {
                ListNode tmp = stack.pop();
                res[i] = tmp.val;
                i++;
            }
            return res;
        }
    }



    class Solution_2 {
        ArrayList<Integer> res = new ArrayList<>();
        public int[] reversePrint(ListNode head) {
            if (head != null) {
                if (head.next != null) {
                    reversePrint(head.next);
                }
                res.add(head.val);
            }
            return buildIntArray(res);
        }

        private int[] buildIntArray(ArrayList<Integer> list) {
            int[] ints = new int[list.size()];
            int i = 0;
            for (Integer n : list) {
                ints[i++] = n;
            }
            return ints;
        }
    }
}
