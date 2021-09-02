package DataStructure;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray448 {
    // TC = O(n)
    // SC = O(1) since the question indicates that the returned list will be counted as extra space

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        // we traverse each integer x in nums and we add n to nums[x - 1]. Since each integer is within the range of [1,
        // n], adding n to x will make the element outside the range.
        for(int num: nums) {
            int position = (num - 1) % n; // we need to mod the num because the number may have been added by n
            // previously
            nums[position] += n;
        }

        // In the end, we traverse nums again. If nums[i] <= n, we know the integer i + 1 disappears.
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] <= n) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
