package LintCode_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Jump_Game_III {
    class Solution {
        /**
         * we use a queue to store current level element(index)
         * we can use a boolean array to avoid duplicate steps
         *
         * Take [4,2,3,0,3,1,2], start = 5 as example to go through the code:
         * first, add start into q: 5
         * cur = 5;
         * since arr[5] != 0, jump into the for loop.
         * t will have two values, but we need to check whether t is valid (0 <= t < 7) or visited.
         * then we add valid t into q. q: 6, 4
         * continue, 6 + 2 = 8 > 7, 6 - 2 = 4(visited); 4 + 3 = 7, 4 - 3 = 1(valid) --> q: 1
         * 1 + 2 = 3(valid), 1 - 2 = -1;
         * arr[3] == 0 --> return true;
         * if q is empty and we can not go to an index that arr[index] = 0, just return false.
         */
        public boolean canReach(int[] arr, int start) {
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            boolean[] visited = new boolean[arr.length];
            visited[start] = true;
            while (!q.isEmpty()) {
                int cur = q.peek();
                q.poll();
                if (arr[cur] == 0) return true;
                for (int i : new int[] {-1, 1}) {
                    int t = cur + i * arr[cur];
                    if (t < 0 || t >= arr.length || visited[t]) continue;
                    q.add(t);
                    visited[t] = true;
                }
            }
            return false;
        }
    }
}
