package DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem218 {

    // TC = O(n^2), n is the number of points in points array. We also need to spend O(n) time searching the data in
    // the priority queue and it will take O(logn) to remove the height. Therefore, the TC is O(n^2)

    // SC = O(n)

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> points = new ArrayList<>();

        // we preprocess the points, the left point of the building will be given a negative height and the right
        // point will be given the original height
        for(int[] building: buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            points.add(new int[]{left, -height});
            points.add(new int[]{right, height});
        }

        // we sort the points arrayList from left to right, if there are any two points that are the same, we sort
        // them by their height
        Collections.sort(points, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        // create a priority queue which stores points in a descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int prev = 0;
        maxHeap.add(prev);

        for(int[] p: points) {
            int point = p[0];
            int height = p[1];

            if(height < 0) {
                // if the point is the left point of the building, we add the point's height to the maxHeap
                maxHeap.add(-height);
            } else {
                // if the point is the right point of the building, that means we have reached the end of the
                // building line so we remove it
                maxHeap.remove(height);
            }

            // we will check if the current maximum height in the priority queue is equal to the height of the
            // previous point. If it is not, that means the current point is the new skyline so we add the point and
            // height to the result. If it is equal to the height of the previous point, we do nothing because the
            // skyline continues so it is not a new skyline.

            int currentHeight = maxHeap.peek();
            if(currentHeight != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(point);
                list.add(currentHeight);
                res.add(list);
                prev = currentHeight;
            }

        }
        return res;
        // this solution can still be optimized to TC = O(n),
        // check this link to see the optimization: https://leetcode-cn.com/problems/the-skyline-problem/solution/gong-shui-san-xie-sao-miao-xian-suan-fa-0z6xc/
    }
}
