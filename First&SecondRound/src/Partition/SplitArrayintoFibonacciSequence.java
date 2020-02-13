package Partition;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayintoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backtrack(list, S, 0);
        return list;
    }

    private boolean backtrack(List<Integer> list, String s, int start) {
        if (start == s.length() && list.size() >= 3) {
            return true;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(start) == '0' && i > start) {
                break;
            }
            long num = Long.parseLong(s.substring(start, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = list.size();
            if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == list.get(size - 1) + list.get(size - 2)) {
                list.add((int) num);
                if (backtrack(list, s, i + 1)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
