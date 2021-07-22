package DynamicProgramming;

public class BestTimetoBuyandSellStockIV188 {
    // because it requires two days to buy and sell stocks, we will sell the stock whenever the current price is
    // higher than the price we bought the stock if k >= prices.length / 2

    // define dp[i][j][k], i represents the maximum profit at ith day after k transactions. j represents if we
    // currently have a stock, 1 represents holding a stock and 0 represents no stock is held

    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        if(days < 2) {
            return 0;
        }

        k = Math.min(k, days / 2);

        int[][][] dp = new int[days][2][k + 1];


        // dp[i][j][k]
        for(int i = 0; i <= k; i++) {
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }

        // dp[i][0][k]: currently have no stock, look at the previous day's status
        // dp[i][1][k]: currently have a stock, look at the previous day's status

        for(int i = 1; i < days; i++) {
            for(int j = 1; j <= k; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
            }
        }
        return dp[days - 1][0][k];
    }


}
