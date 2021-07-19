package DynamicProgramming;

import java.util.Arrays;

public class OnesAndZeroes474 {
    // define a dp array dp[i][j][k], represents that the string in [0, i] can use [j] 0's and [k] 1's.
    // TC = O(lmn + L): l is the length of the strs, L is the sum of the length of all the strings in the arrays
    // SC = O(lmn) without the space optimization

    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];

        for(int i = 1; i <= length; i++) {
            int[] count = countZerosAndOnes(strs[i - 1]);

            // number of zeros
            for(int j = 0; j <= m; j++) {
                // number of ones
                for(int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = count[0];
                    int ones = count[1];

                    if(j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public int[] countZerosAndOnes(String s) {
        int[] count = new int[2];
        Arrays.fill(count, 0);

        for(char c: s.toCharArray()) {
            count[c - '0']++;
        }

        return count;
    }
}
