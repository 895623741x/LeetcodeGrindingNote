package DynamicProgramming;

public class TwoKeysKeyboard650 {
    // TC = O(n^2) SC = O(n)
    // define dp[i] to represent the number of operations to get i A's. Our goal is to get dp[n].
    // sub-problem : n = 6, AA -> AA AA AA, the operation is the same as n = 3, A -> A A A. The logic of the
    // sub-problem is dp[i] = dp[j] + dp[i / j] where j is smaller than i and j can divide i. Thus dp[6] = dp[2] + dp[3]

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0; // since 1 A is alr

        for(int i = 2; i <= n; i++) {
            dp[i] = i;

            // 1. a small optimization for checking if j is a factor of i so that we can avoid duplicate operations such
            // as dp[6] = dp[2] + dp[3] and dp[6] = dp[3] + dp[2]
            // 2. we also avoid starting from j = 1 since it is meaningless to check dp[6] = dp[1] + dp[6] = 0 + dp[6]
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                }

            }
        }
        return dp[n];
    }
}
