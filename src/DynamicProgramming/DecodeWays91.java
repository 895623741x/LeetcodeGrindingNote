package DynamicProgramming;

public class DecodeWays97 {

    public int numDecodings(String s) {
        // dp is going to store the number of ways to decode the string of length X. dp[0] represents the number
        // of ways to decode a string of length 0 because there is no way to decode an empty string
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        // now we solve the subproblem 0 and subproblem 1, we start from subproblem 2
        for(int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));

            if(oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            if(twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];

    }
}
