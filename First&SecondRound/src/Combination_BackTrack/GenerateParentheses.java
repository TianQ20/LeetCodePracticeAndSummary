package Combination_BackTrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) return list;
        helper(list, "", n, n);
        return list;
    }

    public void helper(List<String> list, String parentheses, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(parentheses);
            return;
        }
        /*
        如果当前左括号数量未超过 n:
        如果左括号多于右括号, 那么此时可以添加一个左括号或右括号, 递归进入下一层
        如果左括号不多于右括号, 那么此时只能添加一个左括号, 递归进入下一层
        */
        if (left > 0) {
            helper(list, parentheses + "(", left - 1, right);
        }

        if (right > 0 && right > left) {
            helper(list, parentheses + ")", left, right - 1);
        }
    }
}
