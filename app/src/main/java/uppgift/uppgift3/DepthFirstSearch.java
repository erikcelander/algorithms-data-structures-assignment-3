package uppgift.uppgift3;

import uppgift.uppgift2.AbstractGraph;
import java.util.*;

public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private final int startVertex;

    public DepthFirstSearch(AbstractGraph graph, int startVertex) {
        this.startVertex = startVertex;
        marked = new boolean[graph.vertexCount()];
        edgeTo = new int[graph.vertexCount()];
        dfs(graph, startVertex);
    }

    private void dfs(AbstractGraph graph, int v) {
        marked[v] = true;
        for (var edge : graph.neighbors(v)) {
            int w = edge.getDestination();
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Integer> path = new LinkedList<>();
        for (int x = v; x != startVertex; x = edgeTo[x])
            path.push(x);
        path.push(startVertex);
        return path;
    }
}
