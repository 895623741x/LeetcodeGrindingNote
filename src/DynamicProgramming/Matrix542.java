package DynamicProgramming;

public class Matrix542 {
    // the most intuitive way to solve this question is to use breadth first search. However, the worst case TC can
    // be O(m^2n^2) if all the nodes in the the matrix is 1. The simpler way is to use a dp array to build a
    // memoization, but there is an even simpler way to solve this question is to traverse from the top-left corner
    // to the bottom-right corner by using dynamic programming. We can use these two dynamic programming to search 4
    // directions of each node.

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : 10000;
            }
        }

        // 从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 从右下角开始
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }

}
