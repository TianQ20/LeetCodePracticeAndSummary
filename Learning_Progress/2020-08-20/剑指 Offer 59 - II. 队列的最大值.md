# 剑指 Offer 59 - II. 队列的最大值

```java
class MaxQueue {
    private Deque<Integer> queue;
    private Deque<Integer> help;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : help.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!help.isEmpty() && help.peekLast() < value) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int val = queue.pop();
        if (help.peek() == val) {
            help.pop();
        }
        return val;
    }
}
```
