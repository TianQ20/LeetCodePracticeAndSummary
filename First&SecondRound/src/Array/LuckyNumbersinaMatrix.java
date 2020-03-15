package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuckyNumbersinaMatrix {
    class Solution {
        public List<Integer> luckyNumbers (int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < matrix.length; j++) {
                int min = matrix[j][0];
                for (int i = 1; i < matrix[0].length; i++) {
                    if (matrix[j][i] < min) {
                        min = matrix[j][i];
                    }
                }
                set.add(min);
            }

            for (int i = 0; i < matrix[0].length; i++) {
                int max = matrix[0][i];
                for (int j = 1; j < matrix.length; j++) {
                    if (matrix[j][i] > max) {
                        max = matrix[j][i];
                    }
                }
                if (set.contains(max)) {
                    result.add(max);
                }
            }
            return result;
        }
    }
}
