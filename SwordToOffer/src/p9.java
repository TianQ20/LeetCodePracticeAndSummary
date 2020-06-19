import java.util.LinkedList;
import java.util.Stack;

public class p9 {
    class CQueue_1 {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int size;

        public CQueue_1() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
            size = 0;
        }

        public void appendTail(int value) {
            stack1.push(value);
            size++;
        }

        public int deleteHead() {
            if (size == 0) return -1;
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            size--;
            return stack2.pop();
        }
    }


    class CQueue_2 {
        LinkedList<Integer> A, B;

        public CQueue_2() {
            A = new LinkedList<Integer>();
            B = new LinkedList<Integer>();
        }

        public void appendTail(int value) {
            A.addLast(value);
        }

        public int deleteHead() {
            if (!B.isEmpty()) {
                return B.removeLast();
            }
            if (A.isEmpty()) {
                return -1;
            }
            while (!A.isEmpty()) {
                B.addLast(A.removeLast());
            }
            return B.removeLast();
        }
    }


/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
