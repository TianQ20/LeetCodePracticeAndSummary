package FirstWeek;

import java.util.Stack;

public class DecodeString {
    class Solution {
        public String decodeString(String s) {
            Stack<StringBuilder> strStack = new Stack<>();
            Stack<Integer> intStack = new Stack<>();
            StringBuilder cur = new StringBuilder();
            int k = 0;

            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    k = k * 10 + c - '0'; // nested digit
                } else if (c == '[') {
                    intStack.push(k);
                    strStack.push(cur);
                    cur = new StringBuilder();
                    k = 0;
                } else if (c ==']') {
                    StringBuilder tmp = cur;
                    cur = strStack.pop();
                    for (k = intStack.pop(); k > 0; k--) {
                        cur.append(tmp);
                    }
                } else {
                    cur.append(c);
                }
            }
            return cur.toString();
        }
    }
}
