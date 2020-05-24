package ThirdWeek;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_in_Binary_Matrix {
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

            int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
            Queue<int[]> q = new LinkedList();
            q.add(new int[] {0, 0});
            grid[0][0] = 1;
            int res = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] coordinates = q.poll();
                    for (int[] dir : directions) {
                        if (coordinates[0] == n - 1 && coordinates[1] == n - 1) {
                            return res + 1;
                        }
                        int x = coordinates[0] + dir[0];
                        int y = coordinates[1] + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                            q.add(new int[] {x, y});
                            grid[x][y] = 1;
                        }
                    }
                }
                res++;
            }
            return -1;
        }
    }
}
