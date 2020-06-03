package TopFacebookQuestions;

public class SubarraySumEqualsK {

//    sum[i] is used to store the cumulative sum of nums array
//    upto the element corresponding to the (i−1)th index.
//    Thus, to determine the sum of elements for the subarray nums[i:j],
//    we can directly use sum[j+1] - sum[i].

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                if (sum[end] - sum[start] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}