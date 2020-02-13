package Combination_BackTrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), k, 1, n);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int start, int n) {
        if (tempList.size() > k) {
            return;
        }

        if (tempList.size() == k && n == 0) {
            list.add(new ArrayList<Integer>(tempList));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (n - i >= 0) {
                tempList.add(i);
                backtrack(list, tempList, k, i + 1, n - i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
