package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII210 {
    // we will use topological sorting algorithm to solve this question. the reason why we use topological sorting
    // algorithm is because this algorithm is a combination of greedy algorithm and BFS. we will only use this
    // algorithm to solve directed graph.

    // TC = O(V + E), V is number of vertices and E is number of edges
    // SC = O(V + E),
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) {
            return new int[0];
        }

        HashSet<Integer>[] adj = new HashSet[numCourses];
        for(int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        int[] inDegree = new int[numCourses];
        for(int[] p: prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.offer(inDegree[i]);
            }
        }

        int[] res = new int[numCourses];
        int count = 0;

        while(!queue.isEmpty()) {
            int head = queue.poll();
            res[count] = head;
            count++;

            Set<Integer> successors = adj[head];

            for(int nextCourse: successors) {
                inDegree[nextCourse]--;

                if(inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        if(count == numCourses) {
            return res;
        }

        return new int[0];


    }
}
