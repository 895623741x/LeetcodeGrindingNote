package DataStructure;

public class Searcha2DMatrixII240 {
    // TC = O(n + m), m is the numbe of rows and n is number of columns
    // SC = O(1) since the memory occupation for the 2D matrix is still the same even though we have used some
    // pointers to traverse the matrix

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int i = 0;
        int j = columns - 1;

        // we can start from the top right of the matrix and do binary search to find the target. If target > current
        // node, move down from the current row. If target < current node, move to the left from the current column
        while(i < rows && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                j--;
            } else if(matrix[i][j] < target) {
                i++;
            }
        }

        return false;


    }
}
