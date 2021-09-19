package String;

public class CountBinarySubstrings696 {
    // Take "00110" as the example. Let the last digit 0 be our current position. At this index, the length of the
    // current consecutive number is 1 and the length of the previous consecutive number(1) is 2. If the length of
    // previous consecutive number >= length of current consecutive number, there must exist a substring that ends
    // with the current number and also fulfill the requirement.

    // TC = O(n)
    // SC = O(1)

    public int countBinarySubstrings(String s) {
        int count = 0;
        int previous = 0;
        int current = 0;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i - 1) == s.charAt(i)) {
                current++;
            } else {
                previous = current;
                current = 1;
            }

            if(previous >= current) {
                count++;
            }
        }

        return count;
    }
}
