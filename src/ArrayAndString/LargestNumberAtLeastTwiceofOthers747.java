package ArrayAndString;

public class LargestNumberAtLeastTwiceofOthers747 {
    public int dominantIndex(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }

        int max = 0;
        int index = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= max) {
                max = nums[i];
                // System.out.println(max);
                index = i;
                // System.out.println(i);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(max != nums[i] && max < 2 * nums[i]) {
                return -1;
            }
        }

        return index;
    }
}
