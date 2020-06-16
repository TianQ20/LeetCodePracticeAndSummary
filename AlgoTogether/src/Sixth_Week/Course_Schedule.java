package Sixth_Week;

import java.util.ArrayList;
import java.util.List;

public class Course_Schedule {
    class Solution_I {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
            int[] visit = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (isCyclic(graph, visit, i)) return false;
            }
            return true;
        }

        private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < prerequisites.length; i++) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            return graph;
        }

        private boolean isCyclic(List<List<Integer>> graph, int[] visit, int cur) {
            if (visit[cur] == 1) return true;
            if (visit[cur] == 2) return false;
            visit[cur] = 1; // mark as visiting

            for (int j = 0; j < graph.get(cur).size(); j++) {
                if (isCyclic(graph, visit, (int)graph.get(cur).get(j))) return true; // visit all children
            }
            visit[cur] = 2; // mark as visited
            return false;
        }
    }


    class Solution_II {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
            int[] visit = new int[numCourses];

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                if (isCyclic(graph, visit, i, res)) return new int[0];
            }

            int[] order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = res.get(numCourses - i - 1);
            }
            return order;
        }

        private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < prerequisites.length; i++) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            return graph;
        }

        private boolean isCyclic(List<List<Integer>> graph, int[] visit, int cur, List<Integer> res) {
            if (visit[cur] == 1) return true;
            if (visit[cur] == 2) return false;
            visit[cur] = 1; // mark as visiting

            for (int j = 0; j < graph.get(cur).size(); j++) {
                if (isCyclic(graph, visit, (int)graph.get(cur).get(j), res)) return true; // visit all children
            }
            visit[cur] = 2; // mark as visited
            res.add(cur);
            return false;
        }
    }
}
