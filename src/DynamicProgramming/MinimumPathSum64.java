package DynamicProgramming;

public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {

        //  define a two dimensional dp array, dp[i][j] represents the smallest sum of the node starts from the
        //  top-left. Because every time we can only move right or down, we can use
        //  dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j] to represent the minimum sum.
        // TC =O(n * n) SC = O(n * n)

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if(i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[m][n];
    }
}
