package Seventh_Week_Mock;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Keys_and_Rooms {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Stack<Integer> dfs = new Stack<>();
            dfs.add(0);

            Set<Integer> seen = new HashSet<>();
            seen.add(0);

            while (!dfs.isEmpty()) {
                int cur = dfs.pop();
                for (int i : rooms.get(cur)) {
                    if (!seen.contains(i)) {
                        dfs.add(i);
                        seen.add(i);
                        if (rooms.size() == seen.size()) {
                            return true;
                        }
                    }
                }
            }
            return rooms.size() == seen.size();
        }
    }
}
