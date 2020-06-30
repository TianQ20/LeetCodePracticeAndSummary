package EighthWeek;

import java.util.Arrays;

public class Allocate_Books {
    public static void main(String[] args) {
        int[] arr = new int[] {12, 34, 67, 90};
        int n = 4;
        int B = 2;
        int res = allocate_books(n, B, arr);
        System.out.println(res);
    }

    public static int allocate_books(int n, int B, int[] arr) {
        int res = 0;
        if (n <= 0 || B <= 0 || n < B) return -1;

        if (n == B) {
            Arrays.sort(arr);
            return arr[n - 1];
        }




        return res;
    }
}
