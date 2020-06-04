package ArraysAndStrings;

public class Q7_RotateMatrix {

    // rotate the matrix clockwise by 90 degree.

    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) { // not a square
            return false;
        }
        int n = matrix.length;

        for(int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - layer - 1;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top as a temp variable

                matrix[first][i] = matrix[last - offset][first]; // left -> top

                matrix[last - offset][first] = matrix[last][last - offset]; // bottom -> left

                matrix[last][last - offset] = matrix[i][last]; // right -> bottom

                matrix[i][last] = top; // saved top -> right
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = randomMatrix(3, 3, 0, 9);
        printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        printMatrix(matrix);
    }


    // helper methods
    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
