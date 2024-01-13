package uppgift.uppgift2;

import java.util.List;
import java.util.ArrayList;

public class DirectedGraph extends AbstractGraph {

    public DirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public int edgeCount() {
        int count = 0;
        for (List<GraphEdge> edges : adjacencyList) {
            count += edges.size();
        }
        return count;
    }

    @Override
    public void createEdge(int src, int dest) {
        createEdge(src, dest, 1.0); // Default weight is 1.0
    }

    @Override
    public void createEdge(int src, int dest, double weight) {
        if (isValidVertex(src) && isValidVertex(dest)) {
            adjacencyList.get(src).add(new GraphEdge(src, dest, weight));
        } else {
            throw new IllegalArgumentException("Invalid source or destination vertex.");
        }
    }

    @Override
    public void deleteEdge(int src, int dest) {
        if (isValidVertex(src)) {
            adjacencyList.get(src).removeIf(edge -> edge.getDestination() == dest);
        }
    }

    @Override
    public Iterable<GraphEdge> allEdges() {
        List<GraphEdge> allEdges = new ArrayList<>();
        for (List<GraphEdge> edges : adjacencyList) {
            allEdges.addAll(edges);
        }
        return allEdges;
    }

    private boolean isValidVertex(int vertex) {
        return vertex >= 0 && vertex < vertexCount();
    }
}
