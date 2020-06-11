package Fifth_Week;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_using_Queues {
    class MyStack {
        Queue<Integer> q;

        /** Initialize your data structure here. */
        public MyStack() {
            this.q = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q.add(x);
            for (int i = 0; i < q.size() - 1; i++) {
                q.add(q.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q.poll();
        }

        /** Get the top element. */
        public int top() {
            return q.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
    }

    /**
     * Be careful with queue.poll() is remove the first input element,
     * stack.pop() is remove the last push element.
     *
     * push 1 -> [1]       and no rotate
     * push 2 -> [2,1]     and rotate 1 time : -> [1,2]
     * push 3 -> [2,1,3]   and rotate 2 times: -> [1,3,2] -> [3,2,1]
     */
}
