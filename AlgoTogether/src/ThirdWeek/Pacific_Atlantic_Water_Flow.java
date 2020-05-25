package ThirdWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pacific_Atlantic_Water_Flow {
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> res = new ArrayList<>();
            if (matrix.length == 0 || matrix[0].length == 0) return res;

            int col = matrix.length;
            int row = matrix[0].length;
            boolean[][] visited_pacific = new boolean[col][row];
            boolean[][] visited_atlantic = new boolean[col][row];

            for (int i = 0; i < col; i++) {
                dfs(matrix, i, 0, visited_pacific, col, row);
                dfs(matrix, i, row - 1, visited_atlantic, col, row);
            }

            for (int j = 0; j < row; j++) {
                dfs(matrix, 0, j, visited_pacific, col, row);
                dfs(matrix, col - 1, j, visited_atlantic, col, row);
            }

            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    if (visited_pacific[i][j] && visited_atlantic[i][j]) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] matrix, int i, int j, boolean[][] visited, int m, int n) {
            visited[i][j] = true;
            int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < matrix[i][j]) {
                    continue;
                }
                dfs(matrix, x, y, visited, m, n);
            }

        }
    }
}
