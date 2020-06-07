package LintCode_Greedy;

public class GasStation {
    class Solution_1 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int currGas = 0;
            int totalGas = 0;
            int startIndex = 0;
            for (int i = 0; i < n; i++) {
                totalGas += gas[i] - cost[i];
                currGas += gas[i] - cost[i];
                if (currGas < 0) {
                    currGas = 0;
                    startIndex = i + 1;
                }
            }
            return totalGas >= 0 ? startIndex : -1;
        }
    }


    class Solution_2 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int start = gas.length - 1;
            int end = 0;
            int sum = gas[start] - cost[start];
            while (end < start) {
                if (sum >= 0) {
                    sum += gas[end] - cost[end];
                    end++;
                } else {
                    start--;
                    sum += gas[start] - cost[start];
                }
            }
            return sum >= 0 ? start : -1;
        }
    }

// The basic idea is every time we start from a station, we go as far as possible by increasing end until remaining gas is less than 0.
// If 'end' finally hits start we know we can travel around from 'start'.
// If we haven't traveled around, we know we cannot start from this station.
// Then we check the station before our start station if we can start from this station. Repeat until we have checked all stations.
    
}
