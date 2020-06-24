package Seventh_Week;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Random_Flip_Matrix {
    class Solution {
        private Map<Integer, Integer> map;
        private int rows, cols, total;
        private Random rand;

    public Solution(int n_rows, int n_cols) {
            rows = n_rows;
            cols = n_cols;
            map = new HashMap<>();
            rand = new Random();
            total = rows * cols;
        }

        public int[] flip() {
            int r = rand.nextInt(total--); // generate index, decrease total number of values

            int x = map.getOrDefault(r,r); // check if we have already put something at this index

            map.put(r, map.getOrDefault(total, total)); // swap - put total at index that we generated

            return new int[] {x / cols, x % cols}; // [row.id, col.id]
        }

        public void reset() {
            map.clear();
            total = cols * rows;
        }
    }
}
