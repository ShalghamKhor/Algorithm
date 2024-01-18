package assignment3.task4;

import assignment3.task1.Graph;

import java.util.Arrays;

public class Dijkstra {
    public void dijkstra(Graph graph, int source) {
        int numOfVertices = graph.numOfVertices();
        double[] distances = new double[numOfVertices];
        int[] pred = new int[numOfVertices];
        Arrays.fill(pred, -1);
        Arrays.fill(distances, Double.MAX_VALUE);
        distances[source] = 0;

        Heap heap = new Heap(numOfVertices);
        heap.insert(new VertexDistance(source,0));

        boolean[] visited = new boolean[numOfVertices];

        while (heap.getSize() > 0) {
            VertexDistance vertexDistance = heap.extractMin();
            int currentVertex = vertexDistance.getVertex();

            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;


            for (Graph.Edge nextEdge : graph.adjacent(currentVertex)) {
                int next = nextEdge.getVertex2();
                if (next < 0|| next >= numOfVertices) {
                    continue;
                }
                double newDistance = distances[currentVertex] + nextEdge.getWeight();
                if (newDistance < distances[next]){
                    distances[next] = newDistance;
                    pred[next] = currentVertex;
                    heap.insert(new VertexDistance(next, newDistance));
                }
            }
        }
        printShortestPath(source, distances, pred);
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
        if (pred[currentVertex] == 0 &&currentVertex == 0){
            System.out.println("Incorrect predecessor setup for vertex: " + currentVertex);
            return;
        }

        printPath(pred[currentVertex], pred );
        System.out.println(currentVertex + " ");
    }
}
