package BinarySearch;

class BinarySearch1 {

    // brute force

    public int search(int[] nums, int target) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = i;
            }
        }
        return res;
    }
}


class BinarySearch2 {

    // Binary Search

    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}
