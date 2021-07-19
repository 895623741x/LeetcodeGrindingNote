package DynamicProgramming;

public class PartitionEqualSubsetSum416 {
    //TC = O(m * n), SC = O(m * n)
    // m = nums.length, n = total / 2

    public boolean canPartition(int[] nums) {
        int total = 0;
        int length = nums.length;

        for(int num: nums) {
            total += num;
        }

        if(total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        boolean[][] dp = new boolean[length][target + 1];

        if(nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for(int i = 1; i < length; i++) {
            for(int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if(nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if(nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[length - 1][target];
    }

}
