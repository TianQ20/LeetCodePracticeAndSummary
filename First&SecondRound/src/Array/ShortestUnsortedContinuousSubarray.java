package Array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);

        int start = 0;
        while (start < n && temp[start] == nums[start]) {
            start++;
        }

        int end = n - 1;
        while (end > start && temp[end] == nums[end]) {
            end--;
        }
        return end - start + 1;
    }
}
