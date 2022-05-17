package ArrayAndString;

public class FindPivotIndex724 {
    public int pivotIndex(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;

        for(int i: nums) {
            sum2 += i;
        }

        for(int i = 0; i < nums.length; i++) {
            int dif = sum2 - nums[i] - sum1;

            if(sum1 == dif) {
                return i;
            }

            sum1 += nums[i];
        }

        // for (int i = 0; i < nums.length; i++) {
        //     if (sum1 == sum2 - sum1 - nums[i]) return i;
        //     sum1 += nums[i];
        // }

        return -1;
    }
}
