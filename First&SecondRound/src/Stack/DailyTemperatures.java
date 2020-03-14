package Stack;

import java.util.Stack;

public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            // stack.pop() will delete the top element, stack.peek() just retrive the element
            int n = T.length;
            int[] res = new int[n];
            Stack<Integer> stack = new Stack();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return res;
        }
    }
}

/*

Here is a worked example of the contents of the stack as we work through T = [73, 74, 75, 71, 69, 72, 76, 73] in reverse order, at the end of the loop (after we add T[i]).
For clarity, stack only contains indices i, but we will write the value of T[i] beside it in brackets, such as 0 (73).

When i = 7, stack = [7 (73)]. ans[i] = 0.
When i = 6, stack = [6 (76)]. ans[i] = 0.
When i = 5, stack = [5 (72), 6 (76)]. ans[i] = 1.
When i = 4, stack = [4 (69), 5 (72), 6 (76)]. ans[i] = 1.
When i = 3, stack = [3 (71), 5 (72), 6 (76)]. ans[i] = 2.
When i = 2, stack = [2 (75), 6 (76)]. ans[i] = 4.
When i = 1, stack = [1 (74), 2 (75), 6 (76)]. ans[i] = 1.
When i = 0, stack = [0 (73), 1 (74), 2 (75), 6 (76)]. ans[i] = 1.

 */