package Stack;

import java.util.Stack;

public class BackspaceStringCompare {
    class Solution_Stack {
        public boolean backspaceCompare(String S, String T) {
            return helper(S).equals(helper(T));
        }

        private Stack<Character> helper(String str) {
            Stack<Character> stack = new Stack<>();
            for (char c : str.toCharArray()) {
                if (c != '#') {
                    stack.push(c);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            return stack;
        }
    }


    class Solution_BuildString {
        public boolean backspaceCompare(String S, String T) {
            String s = getString(S);
            String t = getString(T);
            return s.equals(t);
        }

        private String getString(String s) {
            StringBuilder str = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (ch == '#') {
                    if (str.length() != 0) {
                        str.deleteCharAt(str.length() - 1);
                    }
                } else {
                    str.append(ch);
                }
            }
            return str.toString();
        }
    }


    class Solution_TwoPointer {
        public boolean backspaceCompare(String S, String T) {
            int i = S.length() - 1;
            int j = T.length() - 1;
            int skipS = 0, skipT = 0;

            while (i >= 0 || j >= 0) {
                while (i >= 0) {
                    if (S.charAt(i) == '#') {
                        skipS++;
                        i--;
                    } else if (skipS > 0) {
                        skipS--;
                        i--;
                    } else break;
                }

                while (j >= 0) {
                    if (T.charAt(j) == '#') {
                        skipT++;
                        j--;
                    } else if (skipT > 0) {
                        skipT--;
                        j--;
                    } else break;
                }

                if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                    return false;
                }
                if ((i >= 0) != (j >= 0)) {
                    return false;
                }
                i--;
                j--;
            }
            return true;
        }
    }
}
