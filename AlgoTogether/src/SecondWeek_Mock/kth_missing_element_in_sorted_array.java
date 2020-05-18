package SecondWeek_Mock;

public class kth_missing_element_in_sorted_array {
    /**
     * A[i] = i + 1
     * missing part: A[i] - (i + 1)
     * @param A
     * @param k
     * @return
     */

    public static int findK(int[] A, int k) {
        int left = 0, right = A.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (k > getMissing(A, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int pre = getMissing(A, left - 1);
        int val = 0;
        if (left > 0) {
            val = A[left - 1];
        }
        return k + val - pre;
    }

    static private int getMissing(int[] A, int pivot) {
        if (pivot < 0) return 0;
        if (pivot >= A.length) return 1 << 30;
        return A[pivot] - (pivot + 1);
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 5, 8, 13};
        for (int i = 0; i <= 10; i++) {
            System.out.print(" " + findK(A, i));
        }
    }
}
