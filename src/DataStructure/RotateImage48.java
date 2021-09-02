package DataStructure;

public class RotateImage48 {
    // TC = O(n^2)
    // SC = O(1)

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // we first swap the element in each row diagonally
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // then we reverse each row
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < (n / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
