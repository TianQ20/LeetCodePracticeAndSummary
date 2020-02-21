package Stack;

public class NextGreaterElementII {

    // array approach

    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int n = nums.length;
        int[] res = new int[n];
        int[] temp = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            temp[i] = nums[i % n];
        }

        for (int i = 0; i < n; i++) {
            res[i] = -1;
            if (nums[i] == max) continue;
            for (int j = i + 1; j < 2 * n; j++) {
                if (temp[j] > nums[i]) {
                    res[i] = temp[j];
                    break;
                }
            }
        }

        return res;
    }
}
