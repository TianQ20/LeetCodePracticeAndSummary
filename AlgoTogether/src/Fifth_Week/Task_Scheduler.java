package Fifth_Week;

import java.util.Arrays;

public class Task_Scheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] counter = new int[26];
            for (int i = 0; i < tasks.length; i++) {
                counter[tasks[i] - 'A']++;
            }

            Arrays.sort(counter);
            int maxFreq = counter[counter.length - 1];

            int p = 0;
            for (int i = 25; i >= 0; i--) {
                if (counter[i] == maxFreq) {
                    p++;
                }
            }
            int res = (maxFreq - 1) * (n + 1) + p;

            return Math.max(res, tasks.length);
        }
    }
}
