# 剑指 Offer 30. 包含min函数的栈

use two stacks.

```java
class MinStack {
    Stack<Integer> A, B;
    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        if (B.isEmpty() || B.peek() >= x) {
            B.push(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
```

![1](minStack.jpg)

use one stack.

```java
class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int peek = stack.pop();
        if (peek == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
```

use linkedlist.

```java
class MinStack {
    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(head.min, x), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }
}
```
