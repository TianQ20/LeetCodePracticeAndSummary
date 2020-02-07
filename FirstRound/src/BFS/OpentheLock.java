package BFS;

import java.util.*;

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        int depth = -1;
        q.addAll(Arrays.asList("0000"));
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (node.equals(target)) {
                    return depth;
                }
                if (visited.contains(node)) continue;
                visited.add(node);
                q.addAll(success(node));
            }
        }
        return -1;
    }

    private static List<String> success(String s) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            // 正序 和 逆序
            res.add(s.substring(0, i) + (s.charAt(i) == '0' ? 9 : s.charAt(i) - '0' - 1) + s.substring(i + 1));
            res.add(s.substring(0, i) + (s.charAt(i) == '9' ? 0 : s.charAt(i) - '0' + 1) + s.substring(i + 1));
        }
        return res;
    }
}
