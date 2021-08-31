package graph;

public class IsGraphBipartite785 {
    // we can use two colors to check if the graph is bipartite. If we see a node that have no color(0), we will
    // color the node with color 1 or -1. if we found that the adjacent node is in the same color, we know the graph
    // can not be bipartite.

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for(int i = 0; i < n; i ++) {
            if(colors[i] == 0 && isValidColor(graph, colors, 1, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidColor(int[][] graph, int[] colors, int color, int node) {
        if(colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;

        for(int next: graph[node]) {
            if(!isValidColor(graph, colors, -color, next)) {
                return false;
            }
        }

        return true;
    }
}
