package SecondWeek;

import java.util.Arrays;

public class Heaters {
    class Solution_1 {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int res = 0, i = 0;
            for (int house : houses) {
                while (i + 1 < heaters.length && Math.abs(heaters[i] - house) >= Math.abs(heaters[i + 1] - house)) {
                    i++; // move heater to rightward in case it is closer to the given house
                }
                res = Math.max(res, Math.abs(heaters[i] - house)); // get the max radius
            }
            return res;
        }
    }

    
    /**
     我们可以用二分查找法来快速找到第一个大于等于当前house位置的数，
     如果这个数存在，那么我们可以算出其和house的差值，
     并且如果这个数不是heater的首数字，我们可以算出house和前面一个数的差值，
     这两个数中取较小的为cover当前house的最小半径，然后我们每次更新结果res即可
     */
    class Solution_2 {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(heaters);
            int res = 0, n = heaters.length;
            for (int house : houses) {
                int left = 0, right = n;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (heaters[mid] < house) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                int dist1 = right == n ? Integer.MAX_VALUE : heaters[right] - house;
                int dist2 = right == 0 ? Integer.MAX_VALUE : house - heaters[right - 1];
                res = Math.max(res, Math.min(dist1, dist2));
            }
            return res;
        }
    }
}
