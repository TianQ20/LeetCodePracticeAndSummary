package Seventh_Week;

import java.util.Stack;

public class Adding_Two_Negabinary_Numbers {
    class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            int i = arr1.length - 1;
            int j = arr2.length - 1;
            int carry = 0;
            Stack<Integer> stack = new Stack<>();

            while (i >= 0 || j >= 0 || carry != 0) {
                if (i >= 0) carry += arr1[i--];
                if (j >= 0) carry += arr2[j--];
                stack.push(carry & 1);
                carry = - (carry >> 1);
            }

            while (!stack.isEmpty() && stack.peek() == 0) {
                stack.pop(); // remove leading zero
            }

            if (stack.isEmpty()) { // all zero
                return new int[] {0};
            }

            int[] ans = new int[stack.size()];
            int index = 0;
            while (!stack.isEmpty()) {
                ans[index++] = stack.pop();
            }
            return ans;
        }
    }
}
