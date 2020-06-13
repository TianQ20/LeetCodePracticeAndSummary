package Sixth_Week;

import java.util.*;

public class Cheapest_Flights_Within_K_Stops {
    class Solution_DFS {
        int ans;
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            ans = Integer.MAX_VALUE;
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int[] f : flights) {
                map.putIfAbsent(f[0], new ArrayList<>());
                map.get(f[0]).add(new int[]{f[1], f[2]});
            }
            int[] visited = new int[n];
            visited[src] = 1;
            dfs(src, dst, K + 1, visited, map, 0); // K = 0 means we need to fly straightforward but not stop, so we need to use K + 1 in dfs process
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        public void dfs(int src, int dst, int k, int[] visited, Map<Integer, List<int[]>> map, int cost) {
            if (src == dst) {
                ans = cost;
                return;
            }

            if (k == 0) return;

            if (!map.containsKey(src)) return;
            for (int[] i : map.get(src)) {
                if (visited[i[0]] == 1) continue; // do not visit the same city twice
                if (cost + i[1] > ans) continue; // prunning
                visited[i[0]] = 1;
                dfs(i[0], dst, k - 1, visited, map, cost + i[1]);
                visited[i[0]] = 0;
            }
        }
    }


    class Solution_pq {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
            for (int[] f : flights) {
                if (!prices.containsKey(f[0])) {
                    prices.put(f[0], new HashMap<>());
                }
                prices.get(f[0]).put(f[1], f[2]);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0]))); // min pq
            pq.add(new int[]{0, src, K + 1}); // add original source city to pq with price = 0 & distance allowed = k + 1
            while (!pq.isEmpty()) {
                int[] top = pq.remove();
                int price = top[0];
                int city = top[1]; // current src
                int stops = top[2];

                if (city == dst) {
                    return price;
                }

                if (stops > 0) {
                    Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                    for (int a : adj.keySet()) {
                        pq.add(new int[] {price + adj.get(a), a, stops - 1});
                    }
                }
            }
            return -1;
        }
    }
}
