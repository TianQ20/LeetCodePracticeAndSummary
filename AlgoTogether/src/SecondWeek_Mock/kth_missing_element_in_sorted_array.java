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
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (k > getMissing(A, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return k + A[left - 1] - getMissing(A, left);
    }

    static private int getMissing(int[] A, int pivot) {
        if (pivot < 0 || pivot > A.length - 1) return -1;
        return A[pivot] - (pivot + 1);
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 5, 8, 13};
        int k = 2;
        System.out.println(findK(A, k));
    }
}
