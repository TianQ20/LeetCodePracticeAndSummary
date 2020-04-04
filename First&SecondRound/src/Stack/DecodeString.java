package Stack;

import java.util.Stack;

public class DecodeString {

    // use two stack to record the repeat times and according characters

    class Solution {
        public String decodeString(String s) {
            Stack<Integer> intStack = new Stack<>();
            Stack<StringBuilder> strStack = new Stack<>();
            StringBuilder cur = new StringBuilder();
            int k = 0;

            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    k = k * 10 + ch - '0'; // calculate the digit, like 23
                } else if (ch =='[') {
                    intStack.push(k);
                    strStack.push(cur);
                    cur = new StringBuilder();
                    k = 0;
                } else if (ch ==']') {
                    StringBuilder tmp = cur;
                    cur = strStack.pop();
                    for (k = intStack.pop(); k > 0; --k) {
                        cur.append(tmp); // append k times of tmp (original cur appended ch)
                    }
                } else {
                    cur.append(ch); // until all other circumstances finished, append ch to cur
                }
            }
            return cur.toString();
        }
    }
}
