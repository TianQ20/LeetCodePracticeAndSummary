package Fifth_Week;

import java.util.Stack;

public class Implement_Queue_using_Stacks {
    class MyQueue {
        /**
         * use input stack to store the input element, once we need to pop or peek,
         * we need to push input elements into output stack,
         * then we can use output.pop() or output.peek() to simulate queue.poll() or queue.peek(),
         * since go through two stacks, the out coming order will be the reverse order as queue's.
         */
        Stack<Integer> input;
        Stack<Integer> output;
        /** Initialize your data structure here. */
        public MyQueue() {
            this.input = new Stack<>();
            this.output = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            input.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return output.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
