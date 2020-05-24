package SecondWeek;

import java.util.ArrayDeque;
import java.util.Queue;

public class Swim_in_Rising_Water {
    class Solution {
        public int swimInWater(int[][] grid) {
            int n = grid.length;
            int l = 0, r = n * n;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (hasPath(grid, m)) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }

        private boolean hasPath(int[][] grid, int t) {
            int n = grid.length;
            if (grid[0][0] > t) return false;
            Queue<Integer> q = new ArrayDeque<Integer>();
            int[] seen = new int[n * n];
            int[] dirs = new int[] {1, 0, -1, 0, 1};
            q.add(0);

            while (!q.isEmpty()) {
                int x = q.peek() % n;
                int y = q.peek() / n;
                q.poll();
                if (x == n - 1 && y == n - 1) return true;
                for (int i = 0; i < 4; ++i) {
                    int tx = x + dirs[i];
                    int ty = y + dirs[i + 1];
                    if (tx < 0 || ty < 0 || tx >= n || ty >= n || grid[tx][ty] > t) continue;
                    int key = ty * n + tx;
                    if (seen[key] == 1) continue;
                    seen[key] = 1;
                    q.add(key);
                }
            }
            return false;
        }
    }
}
