package Sixth_Week;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Flower_Planting_With_No_Adjacent {
    class Solution {
        public int[] gardenNoAdj(int N, int[][] paths) {
            Map<Integer, HashSet<Integer>> G = new HashMap<>();
            for (int i = 0; i < N; i++) {
                G.put(i, new HashSet<>());
            }
            for (int[] path : paths) {
                G.get(path[0] - 1).add(path[1] - 1); // Due to 1-based indexing
                G.get(path[1] - 1).add(path[0] - 1);
            }

            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                int[] colors = new int[5]; // Use 5 instead of 4 so we can easily use 1-based indexing of the garden colors
                for (int j : G.get(i)) {
                    colors[res[j]] = 1; // Mark the color as used if neighbor has used it before
                }
                // Now just use a color that has not been used yet
                for (int c = 4; c > 0; c--) {
                    if (colors[c] == 0) {
                        res[i] = c; // use it
                    }
                }
            }
            return res;
        }
    }
}
