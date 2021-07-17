package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {

    // 1. dynamic programming
    public int lengthOfLIS(int[] nums) {
        // define a dp array, dp[i] represents the longest length of a subsequence ends at number i.if the number at
        // position dp[j] is smaller than the number at position dp[i], then we can get a subsequence that has a length
        // of dp[j] + 1. To traverse all the conditions, we will need two layers of for loop. and TC = O(n^2)
        int maxLength = 0, n = nums.length;
        if(n <= 1) return n;

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    // 2. binary search TC = O(n * log n)
    // kind of difficult, will come back later

//    public int lengthOfLIS(int[] nums) {
//
//    }
}
