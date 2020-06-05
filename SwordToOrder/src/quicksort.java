public class quicksort {
    private static int partition(int[] A, int lo, int hi) {
        int i = lo, j = hi + 1;
        int pivot = A[lo];
        while (true) {
            while (less(A[++i], pivot)) {
                if (i == hi) break;
            }
            while (less(pivot, A[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(A, i, j);
        }
        exch(A, lo, j);
        return j;
    }

    private static void exch(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    private static boolean less(int a, int b) {
        if (a < b) return true;
        return false;
    }

    private static void sort(int[] A, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(A, lo, hi);
        sort(A, lo, j - 1);
        sort(A, j + 1, hi);
    }

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        sort(arr, 0, n - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
