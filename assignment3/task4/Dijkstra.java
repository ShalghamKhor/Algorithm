package assignment3.task4;

import assignment3.task1.Graph;
import assignment3.task3.MinHeap;

import java.util.Arrays;

public class Dijkstra {
    public void dijkstra(Graph graph, int source) {
        int numOfVertices = graph.numOfVertices();
        double[] distances = new double[numOfVertices];
        int[] pred = new int[numOfVertices];
        Arrays.fill(distances, Double.MAX_VALUE);
        distances[source] = 0;

        MinHeap heap = new MinHeap(numOfVertices);
        heap.insert(new Graph.Edge(source, source,0));

        boolean[] visited = new boolean[numOfVertices];

        while (heap.getSize() > 0) {
            Graph.Edge edge = heap.extractMin();

            int vertex1 = edge.getVertex1();
            int vertex2 = edge.getVertex2();

            if (visited[vertex2]) continue;
            visited[vertex2] = true;


            for (Graph.Edge nextEdge : graph.adjacent(vertex2)) {
                int next = nextEdge.getVertex2();
                double newDistance = distances[vertex2] + nextEdge.getWeight();
                if (newDistance < distances[next]){
                    distances[next] = newDistance;
                    pred[next] = vertex2;
                    heap.decreaseKey(next, newDistance);
                }
            }

            printShortestPath(source, distances, pred);
        }
    }

    public void printShortestPath(int source, double[] distance, int[] pred) {
        for (int v = 0; v < distance.length; v++) {
            if (v != source) {
                System.out.print("Path from " + source + " to " + v + ": ");
                if (distance[v] == Double.MAX_VALUE) {
                    System.out.println("No path");
                } else {
                    printPath(v, pred);
                    System.out.println(" - Total distance: " + distance[v]);
                }
            }
        }
    }

    public void printPath(int currentVertex, int [] pred){
        if (currentVertex == -1) return;

        if (pred[currentVertex] == currentVertex){
            System.out.println("Cycle detected in the path ");
            return;
        }
        printPath(pred[currentVertex], pred );
        System.out.println(currentVertex + " ");
    }
}
