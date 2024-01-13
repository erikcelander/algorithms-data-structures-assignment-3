package uppgift.uppgift3;

import uppgift.uppgift2.AbstractGraph;
import java.util.*;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private final int startVertex;

    public BreadthFirstSearch(AbstractGraph graph, int startVertex) {
        this.startVertex = startVertex;
        marked = new boolean[graph.vertexCount()];
        edgeTo = new int[graph.vertexCount()];
        bfs(graph, startVertex);
    }

    private void bfs(AbstractGraph graph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (var edge : graph.neighbors(v)) {
                int w = edge.getDestination();
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
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
