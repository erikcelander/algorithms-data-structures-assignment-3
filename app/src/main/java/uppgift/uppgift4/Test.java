package uppgift.uppgift4;

import java.util.List;

import uppgift.uppgift2.AbstractGraph;
import uppgift.uppgift2.GraphEdge;
import uppgift.uppgift2.DirectedGraph;
import uppgift.uppgift2.UndirectedGraph;
import uppgift.uppgift3.BreadthFirstSearch;
import uppgift.uppgift3.DepthFirstSearch;


public class Test {

  public static void main(String[] args) {
    // Test Directed Graph
    System.out.println("Testing Directed Graph:");
    DirectedGraph directedGraph = new DirectedGraph(5);
    addTestEdges(directedGraph);
    testGraphAlgorithms(directedGraph, 0); // Source vertex for algorithms

    // Test Undirected Graph
    System.out.println("\nTesting Undirected Graph:");
    UndirectedGraph undirectedGraph = new UndirectedGraph(5);
    addTestEdges(undirectedGraph);
    testGraphAlgorithms(undirectedGraph, 0); // Source vertex for algorithms
  }

  private static void addTestEdges(AbstractGraph graph) {
    // Add edges to the graph (adjust weights as needed)
    graph.createEdge(0, 1, 2.0);
    graph.createEdge(0, 2, 6.0);
    graph.createEdge(1, 2, 3.0);
    graph.createEdge(1, 3, 1.0);
    graph.createEdge(2, 3, 1.0);
    graph.createEdge(3, 4, 5.0);
  }

  private static void testGraphAlgorithms(AbstractGraph graph, int sourceVertex) {
    // Test BFS
    System.out.println("BFS Paths:");
    testBFS(graph, sourceVertex);

    // Test DFS
    System.out.println("DFS Paths:");
    testDFS(graph, sourceVertex);

    // Test Dijkstra
    System.out.println("Dijkstra's Shortest Paths:");
    testDijkstra(graph, sourceVertex);
  }

  private static void testBFS(AbstractGraph graph, int sourceVertex) {
    BreadthFirstSearch bfs = new BreadthFirstSearch(graph, sourceVertex);
    for (int v = 0; v < graph.vertexCount(); v++) {
      System.out.print("BFS Path from " + sourceVertex + " to " + v + ": ");
      if (bfs.hasPathTo(v)) {
        for (int x : bfs.pathTo(v)) {
          System.out.print(x + " ");
        }
      } else {
        System.out.print("No path found");
      }
      System.out.println();
    }
  }

  private static void testDFS(AbstractGraph graph, int sourceVertex) {
    DepthFirstSearch dfs = new DepthFirstSearch(graph, sourceVertex);
    for (int v = 0; v < graph.vertexCount(); v++) {
      System.out.print("DFS Path from " + sourceVertex + " to " + v + ": ");
      if (dfs.hasPathTo(v)) {
        for (int x : dfs.pathTo(v)) {
          System.out.print(x + " ");
        }
      } else {
        System.out.print("No path found");
      }

      System.out.println();
    }
  }

  
 private static void testDijkstra(AbstractGraph graph, int sourceVertex) {
    DijkstraShortestPath dsp = new DijkstraShortestPath(graph, sourceVertex);
    for (int v = 0; v < graph.vertexCount(); v++) {
        System.out.printf("Dijkstra Path from %d to %d (distance %.2f): ", sourceVertex, v, dsp.distTo(v));
        List<GraphEdge> path = dsp.pathTo(v);
        if (path != null) {
            for (GraphEdge e : path) {
                System.out.print(e + " ");
            }
        } else {
            System.out.print("No path found");
        }
        System.out.println();
    }
}


}