package DynamicProgramming;

public class BestTimetoBuyandSellStock121 {
    // a really easy question, TC = O(n), SC = O(1)

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxValue = Math.max(maxValue, prices[i] - minPrice);
        }
        return maxValue;
    }
}
