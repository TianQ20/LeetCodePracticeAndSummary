package Fifth_Week;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Recent_Calls {
    class RecentCounter {
        Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            while (!q.isEmpty() && t - q.peek() > 3000) {
                q.poll();
            }
            q.add(t);
            return q.size();
        }
    }
}
