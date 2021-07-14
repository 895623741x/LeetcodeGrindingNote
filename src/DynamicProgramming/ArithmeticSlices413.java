package DynamicProgramming;

import java.util.Arrays;

public class ArithmeticSlices413 {
    // Since we are looking for the arithmic sequence, we are sure that we need tp satisfy nums[i] - nums[i - 1] ==
    // nums[i - 1] - nums[i - 2],
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        int res = 0;

        for(int i = 2; i < n; i++) {
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }

        return res;
    }
}
