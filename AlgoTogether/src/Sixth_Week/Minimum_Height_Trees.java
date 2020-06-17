package Sixth_Week;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Height_Trees {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> leaves = new ArrayList<>();

            if (n == 0) {
                return leaves;
            } else if (n == 1) {
                leaves.add(0);
                return leaves;
            }

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < edges.length; i++) {
                graph.get(edges[i][1]).add(edges[i][0]);
                graph.get(edges[i][0]).add(edges[i][1]);
            }


            for (int i = 0; i < n; i++) {
                if (graph.get(i).size() == 1) { // collect all leaves
                    leaves.add(i);
                }
            }

            while (n > 2) {
                int size = leaves.size();
                n -= size;
                List<Integer> newLeaves = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    int leaf = leaves.get(i); // to every leaf
                    int toRemove = graph.get(leaf).get(0); // leaf size = 1, as it should only has one edge
                    graph.get(toRemove).remove(Integer.valueOf(leaf)); // remove leaf
                    if (graph.get(toRemove).size() == 1) {
                        newLeaves.add(toRemove);
                    }
                }
                leaves = newLeaves;
            }
            return leaves;
        }
    }
}
