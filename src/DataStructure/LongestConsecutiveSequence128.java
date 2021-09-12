package DataStructure;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    // TC = O(n), n is the number of elements in nums
    // SC = O(n), we will need O(n) space to store n elements

    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        int longestLength = 0;

        for(int num: nums) {
            hash.add(num);
        }

        for(int num: hash) {
            // if hash does not contain num - 1, we know the current num is the smallest num in its consecutive sequence
            if(!hash.contains(num - 1)) {
                int current = num;
                int currentLength = 1;

                // we start checking the consecutive sequence
                while(hash.contains(current + 1)) {
                    current++;
                    currentLength++;
                }

                longestLength = Math.max(currentLength, longestLength);
            }
        }

        return longestLength;
    }
}
