package Partition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaystoAddParentheses {

    // use HashMap to memorize results for an input
    // avoid calculate the same expression several times when input is same

    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String p1 = input.substring(0, i);
                String p2 = input.substring(i + 1);
                List<Integer> l1 = map.getOrDefault(p1, diffWaysToCompute(p1));
                List<Integer> l2 = map.getOrDefault(p2, diffWaysToCompute(p2));
                for (Integer i1 : l1) {
                    for (Integer i2 : l2) {
                        int r = 0;
                        switch (c) {
                            case '+':
                                r = i1 + i2;
                                break;
                            case '-':
                                r = i1 - i2;
                                break;
                            case '*':
                                r = i1 * i2;
                                break;
                        }
                        list.add(r);
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.valueOf(input));
        }
        map.put(input, list);
        return list;
    }
}
