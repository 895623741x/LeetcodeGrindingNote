package String;

public class PalindromicSubstrings647 {
    // TC = O(n^2)
    // SC = O(1)

    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0 ; i < s.length(); i++) {
            count += extractPalindromeSubstring(s, i, i); // odd length, start from 1 character only
            count += extractPalindromeSubstring(s, i, i + 1); // even length, start from 2 characters
        }

        return count;
    }

    public int extractPalindromeSubstring(String s, int left, int right) {
        int count = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }
}
