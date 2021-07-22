package DynamicProgramming;

public class BestTimetoBuyandSellStockwithCooldown309 {
    public int maxProfit(int[] prices) {
        int days=prices.length;
        if(days <= 1) return 0;

        int[][] dp=new int[days][3];

        for(int i = 0; i < days; i++){
            dp[i][0] = -prices[i];
            dp[i][1] = 0;
            dp[i][2] = 0;
        }


        for(int i = 1; i < days; i++){
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);

        }
        return Math.max(dp[days - 1][0], Math.max(dp[days - 1][1], dp[days - 1][2]));
    }
}
