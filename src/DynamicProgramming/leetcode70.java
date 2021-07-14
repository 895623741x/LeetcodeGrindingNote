package DynamicProgramming;

import java.util.Arrays;

public class leetcode70 {
    // first we define an array dp[], dp[i] will represent the number of ways we can reach ith stair. Because every
    // time we can choose to take 1 or 2 steps, we can walk to i th stair from [i-1] or [i - 2] stair. So it means
    // the number of ways to walk to dp[i] th stair will be the sum of dp[i-1] + dp[i-2]

    public int climbStairs(int n) {
        if(n <= 2) return n;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // optimize: SC O(n) -> O(1)
    // use two variables to store the values of dp[i - 1] and dp[i - 2]

    public int climbStairsOptimal(int n) {
        if(n <= 2) return n;
        int step1 = 1, step2 = 2, current = 0;
        for(int i = 2; i < n; i++) {
            current = step1 + step2;
            step2 = step1;
            step1 = current;
        }
        return current;
    }

}
