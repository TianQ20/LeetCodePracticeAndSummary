package Greedy;

public class GasStation {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int curr_tank = 0;
            int total_tank = 0;
            int start_index = 0;

            for (int i = 0; i < n; i++) {
                total_tank += gas[i] - cost[i];
                curr_tank += gas[i] - cost[i];
                if (curr_tank < 0) {
                    curr_tank = 0;
                    start_index = i + 1;
                }
            }
            return total_tank >= 0 ? start_index : -1;
        }
    }
}
