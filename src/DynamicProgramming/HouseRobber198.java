package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber198 {
    // define dp[i] to represent the maximum amount of money we can get when robbing the i th house. Now we can have
    // two options:
    // 1. don't rob the current house, then the cumulative amount of money we have will become dp[i-1]
    // 2. we rob the current house, then the the cumulative amount of money we have will become dp[i - 2]
    // Therefore, the state transition equation of this question will be max(dp[i -1], nums[i-1] + dp[i - 2])

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        int res = 0;

        for(int i = 2; i <= n; i++) {
            res = Math.max(dp[i-1], dp[i] + dp[i-2]);
        }

        return res;
    }

    // Like question 70, we can also optimize the space by using variables
}
