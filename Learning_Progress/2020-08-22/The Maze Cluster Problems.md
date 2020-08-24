# Maze Problems

DFS / BFS.

## 490. The Maze

DFS.

```java
class Solution {
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, dest, visited);
    }

    private boolean dfs(int[][] maze, int[] cur, int[] dest, boolean[][] visited) {
        if (visited[cur[0]][cur[1]]) {
            return false;
        }
        if (cur[0] == dest[0] && cur[1] == dest[1]) {
            return true;
        }
        visited[cur[0]][cur[1]] = true;
        for (int i = 0; i < dirs.length; i++) {
            int[] d = dirs[i];
            int row = cur[0], col = cur[1];
            while (isValid(maze, row + d[0], col + d[1])) {
                row += d[0];
                col += d[1];
            }
            if (dfs(maze, new int[] {row, col}, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int row, int col) {
        return (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] != 1);
    }
}
```

BFS.

```java
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(start);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == dest[0] && cur[1] == dest[1]) {
                return true;
            }
            if (visited[cur[0]][cur[1]]) {
                continue;
            }
            visited[cur[0]][cur[1]] = true;
            int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            for (int[] d : dirs) {
                int x = cur[0];
                int y = cur[1];
                while (isValid(maze, x + d[0], y + d[1])) {
                    x += d[0];
                    y += d[1];
                }
                q.offer(new int[] {x, y});
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int row, int col) {
        return (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] != 1);
    }
}
```

## 505. The Maze II

DFS.

```java
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] dist = new int[maze.length][maze[0].length];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        dfs(maze, start, dist);
        return dist[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dist[dest[0]][dest[1]];
    }

    private void dfs(int[][] maze, int[] start, int[][] dist) {
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dirs) {
            int x = start[0] + d[0];
            int y = start[1] + d[1];
            int count = 0;
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += d[0];
                y += d[1];
                count++;
            }
            if (dist[start[0]][start[1]] + count < dist[x - d[0]][y - d[1]]) {
                dist[x - d[0]][y - d[1]] = dist[start[0]][start[1]] + count;
                dfs(maze, new int[] {x - d[0], y - d[1]}, dist);
            }
        }
    }
}
```

BFS with PriorityQueue.

```java
class Solution {
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        dist[start[0]][start[1]] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(m, (i1,i2) -> (i1[2]-i2[2]));
        q.offer(new int[] {start[0], start[1], 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (visited[cur[0]][cur[1]]) {
                continue;
            }
            if (cur[0] == dest[0] && cur[1] == dest[1]) {
                return cur[2];
            }
            visited[cur[0]][cur[1]] = true;
            for (int[] d : dirs) {
                int x = cur[0];
                int y = cur[1];
                int step = cur[2];
                while (isValid(maze, x + d[0], y + d[1])) {
                    x += d[0];
                    y += d[1];
                    step++;
                }
                if (visited[x][y]) {
                    continue;
                }
                if (dist[x][y] == 0 || dist[x][y] > step) {
                    dist[x][y] = step;
                    q.offer(new int[] {x, y, step});
                }
            }
        }
        return -1;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1);
    }
}
```

BFS.
Remove the visited array, just initialize the dist[][] fill with Integer.MAX_VALUE.

```java
class Solution {
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(m, (i1,i2) -> (i1[2]-i2[2]));
        q.offer(new int[] {start[0], start[1], 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == dest[0] && cur[1] == dest[1]) {
                return cur[2];
            }
            for (int[] d : dirs) {
                int x = cur[0];
                int y = cur[1];
                int step = cur[2];
                while (isValid(maze, x + d[0], y + d[1])) {
                    x += d[0];
                    y += d[1];
                    step++;
                }
                if (dist[x][y] > step) {
                    dist[x][y] = step;
                    q.offer(new int[] {x, y, step});
                }
            }
        }
        return -1;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1);
    }
}
```
