package uppgift.uppgift2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UndirectedGraph extends AbstractGraph {

    public UndirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public int edgeCount() {
        int count = 0;
        for (List<GraphEdge> edges : adjacencyList) {
            count += edges.size();
        }
        return count / 2; // since each edge is counted twice
    }

    @Override
    public void createEdge(int src, int dest) {
        createEdge(src, dest, 1.0); // default weight is 1.0
    }

    @Override
    public void createEdge(int src, int dest, double weight) {
        if (isValidVertex(src) && isValidVertex(dest)) {
            adjacencyList.get(src).add(new GraphEdge(src, dest, weight));
            adjacencyList.get(dest).add(new GraphEdge(dest, src, weight));
        } else {
            throw new IllegalArgumentException("Invalid source or destination vertex.");
        }
    }

    @Override
    public void deleteEdge(int src, int dest) {
        if (isValidVertex(src) && isValidVertex(dest)) {
            adjacencyList.get(src).removeIf(edge -> edge.getDestination() == dest);
            adjacencyList.get(dest).removeIf(edge -> edge.getDestination() == src);
        }
    }

    @Override
    public Iterable<GraphEdge> allEdges() {
        List<GraphEdge> allEdges = new ArrayList<>();
        Set<String> addedEdges = new HashSet<>();
        for (List<GraphEdge> edges : adjacencyList) {
            for (GraphEdge edge : edges) {
                String edgeKey = edge.getSource() + "-" + edge.getDestination();
                if (!addedEdges.contains(edgeKey)) {
                    allEdges.add(edge);
                    addedEdges.add(edgeKey);
                }
            }
        }
        return allEdges;
    }

    private boolean isValidVertex(int vertex) {
        return vertex >= 0 && vertex < vertexCount();
    }
}
