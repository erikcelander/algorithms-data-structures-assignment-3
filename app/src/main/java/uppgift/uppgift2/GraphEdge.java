package uppgift.uppgift2;

public class GraphEdge {
    private int source;
    private int destination;
    private double edgeWeight;

    public GraphEdge(int source, int destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.edgeWeight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public double getWeight() {
        return edgeWeight;
    }

    @Override
    public String toString() {
        return "[" + source + "->" + destination + ", weight: " + edgeWeight + "]";
    }
}
