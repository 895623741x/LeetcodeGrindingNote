package DynamicProgramming;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        // TC = O(amount * c) where c is the amount of coins (coins.length), SC = O(amount)

        if(coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && amount - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        return dp[amount];

    }
}
