package ArraysAndStrings;

public class Q8_ZeroMatrix {

    public static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // set zero to row
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        // set zero to column
        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    public static void main(String[] args) {
        int nrows = 5;
        int ncols = 5;
        int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);

        AssortedMethods.printMatrix(matrix);

        setZeros(matrix);

        System.out.println();

        AssortedMethods.printMatrix(matrix);
    }
}
