package LintCode_Greedy;

import java.util.Stack;

public class Remove_K_Digits {
    class Solution_1 {
        public String removeKdigits_1(String num, int k) {
            Stack<Character> s = new Stack<>();
            char[] ch = num.toCharArray();
            int n = ch.length;
            for (char c : ch) {
                while (!s.isEmpty() && k > 0 && s.peek() > c) { // continue remove the first peek
                    s.pop();
                    k -= 1;
                }
                if (!s.isEmpty() || c != '0') {
                    s.push(c);
                }
            }

            // special case
            while (!s.isEmpty() && k-- > 0) { // sorted increasing, and k > 0
                s.pop();
            }
            if (s.isEmpty()) {
                return "0";
            }

            while (!s.isEmpty()) {
                ch[n - 1] = s.peek();
                s.pop();
                n--;
            }
            String res = String.valueOf(ch);
            return res.substring(n);

//            StringBuilder sb = new StringBuilder(s.size());
//            while (!s.isEmpty()) {
//                sb.insert(0, Integer.toString(s.pop() - '0')); // append to front
//            }
//            return sb.toString();
        }
    }
}
