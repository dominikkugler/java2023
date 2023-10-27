public class Matrix {
    public static int[][] add(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matrix dimensions must be the same for addition.");
        }

        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Matrix1 columns must be equal to Matrix2 rows for multiplication.");
        }

        int rows = matrix1.length;
        int columns = matrix2[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int sum = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] result = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static int sumRow(int[][] matrix, int rowIndex) {
        int sum = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            sum += matrix[rowIndex][j];
        }
        return sum;
    }

    public static int sumColumn(int[][] matrix, int columnIndex) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][columnIndex];
        }
        return sum;
    }

    public static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}

public class ZadDom2 {
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrix2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int[][] sum = Matrix.add(matrix1, matrix2);
        int[][] product = Matrix.multiply(matrix1, matrix2);
        int[][] transposed = Matrix.transpose(matrix1);

        int sumRow1 = Matrix.sumRow(matrix1, 0);
        int sumColumn2 = Matrix.sumColumn(matrix2, 1);
        int sumMatrix1 = Matrix.sumMatrix(matrix1);

        // Wydrukowanie wyników
        System.out.println("Sum:");
        for (int[] row : sum) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("Product:");
        for (int[] row : product) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("Transposed:");
        for (int[] row : transposed) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("Sum of Row 1: " + sumRow1);
        System.out.println("Sum of Column 2: " + sumColumn2);
        System.out.println("Sum of Matrix 1: " + sumMatrix1);
    }
}
