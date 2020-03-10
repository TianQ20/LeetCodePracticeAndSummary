package DivideAndConquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class KthLargestElementInAnArray {

    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            if (nums.length == 0) return 0;
            Arrays.sort(nums);

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(i, nums[i]);
            }
            return map.get(map.size() - k);
        }
    }


    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            if (nums.length == 0) return 0;
            Arrays.sort(nums);
            int i = nums.length - k; return nums[i];
        }
    }


    // quickSelect
    class Solution3 {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, k);
        }

        private int quickSelect(int[] nums, int low, int high, int k) {
            int pivot = low;

            // use quick sort's idea
            // put nums that are <= pivot to the left
            // put nums that are  > pivot to the right
            for (int j = low; j < high; j++) {
                if (nums[j] <= nums[high]) {
                    swap(nums, pivot++, j);
                }
            }
            swap(nums, pivot, high);

            // count the nums that are > pivot from high
            int count = high - pivot + 1;
            // pivot is the one!
            if (count == k) return nums[pivot];
            // pivot is too small, so it must be on the right
            if (count > k) return quickSelect(nums, pivot + 1, high, k);
            // pivot is too big, so it must be on the left
            return quickSelect(nums, low, pivot - 1, k - count);
        }

        private void swap(int[] a, int i, int j) {
            final int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }


    // randomize the input to get O(n) guaranteed

    class Solution4 {
        public int findKthLargest(int[] nums, int k) {

            shuffle(nums);
            k = nums.length - k;
            int lo = 0;
            int hi = nums.length - 1;
            while (lo < hi) {
                final int j = partition(nums, lo, hi);
                if(j < k) {
                    lo = j + 1;
                } else if (j > k) {
                    hi = j - 1;
                } else {
                    break;
                }
            }
            return nums[k];
        }

        private int partition(int[] nums, int lo, int hi) {
            int pivot = nums[hi];
            int i = lo;
            for (int j = lo; j < hi; j++) {
                if (nums[j] <= pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, hi);
            return i;
        }

        private void shuffle(int a[]) {

            final Random random = new Random();
            for(int ind = 1; ind < a.length; ind++) {
                final int r = random.nextInt(ind + 1);
                swap(a, ind, r);
            }
        }


        private void swap(int[] a, int i, int j) {
            final int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
