package DataStructure;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    // TC = O(n), n is the number of elements in array. It will take O(1) time to search target - nums[i] in the hash
    // map
    // SC = O(n), n is the number of elements in array, they are the space that is occupied by hash map
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(hash.containsKey(complement)) {
                res[0] = hash.get(complement);
                res[1] = i;
                break;
            }

            hash.put(nums[i], i);
        }

        return res;
    }
}
