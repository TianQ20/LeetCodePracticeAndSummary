package Seventh_Week;

import java.util.HashSet;
import java.util.Set;

public class Minimum_Area_Rectangle_II {
    class Solution {
        public double minAreaFreeRect(int[][] points) {
            double minArea = Double.MAX_VALUE;
            Set<String> set = new HashSet<>();
            for(int[] p:points) {
                set.add(p[0] + " " + p[1]);
            }

            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points.length; j++) {
                    for (int k = j + 1; k < points.length; k++) {
                        if (i == j || i == k) continue;
                        int[] p1 = points[i];
                        int[] p2 = points[j];
                        int[] p3 = points[k];
                        // vector dot product: a * b = x1 * x2 + y1 * y2
                        if ((p1[0] - p2[0]) * (p1[0] - p3[0]) + (p1[1] - p2[1]) * (p1[1] - p3[1]) != 0) continue;
                        int x = p3[0] + p2[0] - p1[0];
                        int y = p3[1] + p2[1] - p1[1];
                        if (!set.contains(x + " " + y)) continue;
                        minArea = Math.min(minArea, getArea(p1, p2, p3));
                    }
                }
            }
            return minArea == Double.MAX_VALUE ? 0 : minArea;
        }

        private double getArea(int[] p1, int[] p2, int[] p3) {
            double L1 = getDist(p1, p2);
            double L2 = getDist(p1, p3);
            return L1 * L2;
        }

        private double getDist(int[] p1, int[] p2) {
            return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
        }
    }
}
