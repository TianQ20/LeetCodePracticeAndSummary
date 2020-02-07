package Combination_BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), 1, n, k);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int start, int n, int k) {
        if (k == 0) {
            list.add(new ArrayList<Integer>(tempList));
            return;
        } else {
            for (int i = start; i <= n - k + 1; i++) {
                tempList.add(i);
                backtrack(list, tempList, i + 1, n, k - 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

/*
i <= end -k + 1, don't use i < = n

For anyone stumped by why this change is necessary,
it's because you should not continue exploring (recursing)
when you know that there won't be enough numbers left until n to fill the needed k slots.
If n = 10, k = 5, and you're in the outermost level of recursion, you choose only i = 1...6 ,
because if you pick i=7 and go into backTracking() you only have 8,9,10 to pick from,
so at most you will get [7,8,9,10]... but we need 5 elements!
*/