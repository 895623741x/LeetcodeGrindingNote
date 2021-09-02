package DataStructure;

public class MaxChunksToMakeSorted769 {
    // TC = O(n), n is the length of the array
    // SC = O(1)

    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int res = 0;

        // we will compare the max element to the sorted array. Every time the max == element at index i, let res++
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if(max == arr[i]) res++;
        }

        return res;
    }
}
