package DataStructure;

import java.util.Stack;

public class DailyTemperatures739 {
    // TC = O(n), n is the length of temperatures
    // SC = O(n), n is the length of temperatures

    // solution link: https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        Stack<Integer> days = new Stack<>();
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            int temp = temperatures[i];

            while(!days.isEmpty() && temp > temperatures[days.peek()]) {
                res[days.peek()] = i - days.pop();
            }

            days.push(i);
        }

        return res;
    }
}
