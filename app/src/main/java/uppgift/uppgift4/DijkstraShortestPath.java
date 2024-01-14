package uppgift.uppgift4;

import uppgift.uppgift2.AbstractGraph;
import uppgift.uppgift2.GraphEdge;
import java.util.*;

public class DijkstraShortestPath {
    private GraphEdge[] edgeTo;
    private double[] distTo;
    private PriorityQueue<NodeDistance> priorityQueue;

    private static class NodeDistance implements Comparable<NodeDistance> {
        private final int node;
        private final double distance;

        public NodeDistance(int node, double distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(NodeDistance other) {
            return Double.compare(this.distance, other.distance);
        }
    }

    public DijkstraShortestPath(AbstractGraph graph, int sourceVertex) {
        edgeTo = new GraphEdge[graph.vertexCount()];
        distTo = new double[graph.vertexCount()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[sourceVertex] = 0.0;

        priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new NodeDistance(sourceVertex, 0.0));

        while (!priorityQueue.isEmpty()) {
            NodeDistance nodeDist = priorityQueue.poll();
            int v = nodeDist.node;
            for (GraphEdge edge : graph.neighbors(v)) {
                relax(edge);
            }
        }
    }

    private void relax(GraphEdge edge) {
        int v = edge.getSource(), w = edge.getDestination();
        if (distTo[w] > distTo[v] + edge.getWeight()) {
            distTo[w] = distTo[v] + edge.getWeight();
            edgeTo[w] = edge;
            priorityQueue.removeIf(nd -> nd.node == w);
            priorityQueue.add(new NodeDistance(w, distTo[w]));
        }
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public List<GraphEdge> pathTo(int v) {
        if (!hasPathTo(v) || edgeTo[v] == null) return null;
        List<GraphEdge> path = new LinkedList<>();
        for (int vertex = v; vertex != edgeTo[vertex].getSource(); vertex = edgeTo[vertex].getSource()) {
            path.add(edgeTo[vertex]);
            if (edgeTo[vertex] == null || edgeTo[edgeTo[vertex].getSource()] == null) break; // Prevent NullPointerException
        }
        Collections.reverse(path);
        return path;
    }
    

    public double distTo(int v) {
        return distTo[v];
    }
}