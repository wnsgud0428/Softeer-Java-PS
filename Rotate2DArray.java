public class Rotate2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        System.out.println("\n90 Degrees Clockwise Rotation:");
        matrix = rotate90(matrix);
        printMatrix(matrix);

        System.out.println("\n180 Degrees Rotation:");
        matrix = rotate180(matrix);
        printMatrix(matrix);

        System.out.println("\n270 Degrees Clockwise Rotation:");
        matrix = rotate270(matrix);
        printMatrix(matrix);
    }

    public static int[][] rotate90(int[][] matrix) {
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    public static int[][] rotate180(int[][] matrix) {
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[n - 1 - i][n - 1 - j] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    public static int[][] rotate270(int[][] matrix) {
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[i][j] = matrix[n - 1 - j][i];
            }
        }

        return rotatedMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    
    /** 배열 복사 */
    public static int[][] copy2DArray(int[][] original) {
        int n = original.length;
        int m = original[0].length; // Assuming rectangular matrix

        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = original[i][j];
            }
        }

        return copy;
    }
}