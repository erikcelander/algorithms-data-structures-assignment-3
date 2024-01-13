package uppgift.uppgift2;


import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractGraph implements Iterable<Integer> {
    protected List<List<GraphEdge>> adjacencyList = new ArrayList<>();

    public AbstractGraph(int numVertices) {
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public int vertexCount() {
        return adjacencyList.size();
    }

    public abstract int edgeCount();

    public abstract void createEdge(int src, int dest);
    public abstract void createEdge(int src, int dest, double weight);

    public abstract void deleteEdge(int src, int dest);

    public List<GraphEdge> neighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    public int degree(int vertex) {
        return adjacencyList.get(vertex).size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new GraphVertexIterator(adjacencyList.size());
    }

    public Iterator<GraphEdge> neighborIterator(int vertex) {
        return adjacencyList.get(vertex).iterator();
    }

    public abstract Iterable<GraphEdge> allEdges();
}
