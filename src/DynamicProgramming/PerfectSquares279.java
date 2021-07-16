package DynamicProgramming;

import java.util.Arrays;

public class PerfectSquares279 {

    // We define an one dimensional dp. dp[i] represents at least how many perfect square numbers can sum to the
    // number i.
    // TC = O(n * sqrt(n)), SC = O(n)

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }


}
