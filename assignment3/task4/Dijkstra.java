package assignment3.task4;

import assignment3.task1.Graph;
import assignment3.task3.MinHeap;

import java.util.Arrays;

public class Dijkstra {
    public void dijkstra(Graph graph, int source) {
        int V = graph.numOfVertices();
        double[] distances = new double[V];
        Arrays.fill(distances, Double.MAX_VALUE);
        distances[source] = 0;

        MinHeap heap = new MinHeap(V * V);


        for (Graph.Edge edge : graph.adjacent(source)) {
            heap.insert(edge);
        }

        boolean[] visited = new boolean[V];

        while (heap.getSize() > 0) {
            Graph.Edge edge = heap.extractMin();

            int u = edge.getVertex1();
            int v = edge.getVertex2();

            if (visited[v]) continue;


            if (distances[u] + edge.getWeight() < distances[v]) {
                distances[v] = distances[u] + edge.getWeight();

                for (Graph.Edge nextEdge : graph.adjacent(v)) {
                    heap.insert(nextEdge);
                }
            }

            visited[v] = true;
        }

    }
}
