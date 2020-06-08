package LintCode_Greedy;

public class Jump_Game_II {
    class Solution {
        public int jump(int[] nums) {
            // This is an implicit bfs solution. i == curEnd means you visited all the items on the current level. Incrementing jumps++ is like incrementing the level you are on. And curEnd = curFarthest is like getting the queue size (level size) for the next level you are traversing.
            int curEnd = 0, curFarest = 0, jumps = 0;
            for (int i = 0; i < nums.length - 1; i++) { // no need to calculate the last element
                curFarest = Math.max(curFarest, i + nums[i]);
                if (curFarest < i) { // if its not reachable, return -1
                    return -1;
                }
                if (i == curEnd) {
                    jumps++;
                    curEnd = curFarest;
                }
            }
            return jumps;
        }
    }
}
