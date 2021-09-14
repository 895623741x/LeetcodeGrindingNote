package String;

public class ValidAnagram242 {
    // TC = O(n), n is the length of string s
    // SC = O(x), x is the number of all characters in s, it can be at most 26

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int n = s.length();
        int[] table = new int[26];

        for(int i = 0; i < n; i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }

        for(int element: table) {
            if(element != 0) return false;
        }

        return true;
    }
}
