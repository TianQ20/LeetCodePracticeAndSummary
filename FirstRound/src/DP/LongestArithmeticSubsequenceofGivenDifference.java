package DP;

import java.util.HashMap;

public class LongestArithmeticSubsequenceofGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int longest = 0;
        HashMap<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], dp.getOrDefault(arr[i] - difference, 0) + 1); // if exist, continue, if not, return to 0 to start again
            longest = Math.max(longest, dp.get(arr[i])); // use greedy strategy
        }
        return longest;
    }
}
