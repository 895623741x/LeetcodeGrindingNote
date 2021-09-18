package String;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {
    // TC = O(n), n is the length of string s
    // SC = O(|x|), x is the number of different kinds of alphabets in in string s and t

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if((s2t.containsKey(sChar) && s2t.get(sChar) != tChar) || (t2s.containsKey(tChar) && t2s.get(tChar) != sChar)) {
                return false;
            }

            s2t.put(sChar, tChar);
            t2s.put(tChar, sChar);
        }

        return true;
    }
}
