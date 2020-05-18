package SecondWeek_Mock;

public class minimum_absolute_search {
    // linear search O(N)
    public static int[] abs_search(int[] nums, int k, int c) {
        int[] res = new int[2];
        int A = Integer.MAX_VALUE, B = Integer.MIN_VALUE;
        for (int num : nums) {
            if (k - c <= num && num <= k + c) {
                A = Math.min(A, num);
                B = Math.max(B, num);
            }
        }
        res[0] = A;
        res[1] = B;
        return res;
    }

    // binary search: O(logN)
    public static int[] abs_search_2(int[] nums, int k, int c) {
        int[] res_2 = new int[2];
        res_2[0] = helper_A(nums, k, c);
        res_2[1] = helper_B(nums, k, c);
        return res_2;
    }

    private static int helper_A(int[] nums, int k, int c) {
        int A = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (k - c <= nums[mid] && nums[mid] <= k + c) {
                A = Math.min(A, nums[mid]);
                right = mid;
            }
            if (nums[mid] < k - c) {
                left = mid + 1;
            }
            if (nums[mid] > k + c){
                right = mid - 1;
            }
        }
        return A;
    }

    private static int helper_B(int[] nums, int k, int c) {
        int B = Integer.MIN_VALUE;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (k - c <= nums[mid] && nums[mid] <= k + c) {
                B = Math.max(B, nums[mid]);
                left = mid + 1;
            }
            if (nums[mid] < k - c) {
                left = mid + 1;
            }
            if (nums[mid] > k + c){
                right = mid - 1;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 8, 10, 11};
        int k = 7;
        int c = 3;

        int[] nums2 = {1, 2, 3, 4, 8, 10, 11};
        int j = 11;
        int q = 3;

        int[] nums3 = {1, 3, 5, 7, 9, 11, 13, 15, 19, 20, 31};
        int a = 15;
        int b = 9;

        System.out.println(java.util.Arrays.toString(abs_search(nums, k, c)));
        System.out.println(java.util.Arrays.toString(abs_search(nums2, j, q)));
        System.out.println(java.util.Arrays.toString(abs_search(nums3, a, b)));

        System.out.println(java.util.Arrays.toString(abs_search_2(nums, k, c)));
        System.out.println(java.util.Arrays.toString(abs_search_2(nums2, j, q)));
        System.out.println(java.util.Arrays.toString(abs_search_2(nums3, a, b)));
    }
}
