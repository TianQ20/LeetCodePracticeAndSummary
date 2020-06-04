package ArraysAndStrings;

public class p4_extension_combine_two_sorted_array {
    /**
     * define max = 1024
     */
    public static void main(String[] args) {
        int max = 1024;
        int[] a1 = new int[max];
        a1[0] = 1;
        a1[1] = 2;
        a1[2] = 3;
        a1[3] = 4;
        int[] a2 = new int[max];
        a2[0] = 5;
        a2[1] = 6;
        a2[2] = 7;
        a2[3] = 8;
        int[] res = insert(a1, a2, 4, 4);
        for (int i : res) {
            System.out.print(i);
        }
    }


    public static int[] insert(int[] a1, int[] a2, int len1, int len2) {
        int max = 1024;
        if (a1 == null || a2 == null || len1 + len2 > max) {
            return null;
        }

        int index1 = len1 - 1;
        int index2 = len2 - 1;
        int index = len1 + len2 - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (a1[index1] > a2[index2]) {
                a1[index--] = a1[index1--];
            } else {
                a1[index--] = a2[index2--];
            }
        }

        while (index1 >= 0) {
            a1[index--] = a1[index1--];
        }

        while (index2 >= 0) {
            a1[index--] = a2[index2--];
        }
        return a1;
    }
}
