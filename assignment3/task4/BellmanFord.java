package assignment3.task4;

import assignment3.task1.Graph;

import java.util.Arrays;

public class BellmanFord {

    int vertex1, vertex2;
    double weight;

    public boolean bellmanFord(Graph graph, int source){
        int numberOfVertices = graph.numOfVertices();
        double[] distances = new double[numberOfVertices];
        int[] pred = new int[numberOfVertices];

        Arrays.fill(distances, Double.MAX_VALUE);
        Arrays.fill(pred, -1);
        distances[source] = 0;

        // relax all edges v-1
        for (int i = 0; i < numberOfVertices-1; i++){
            for (Graph.Edge edge : graph.edges()){
                vertex1 = edge.getVertex1();
                vertex2 = edge.getVertex2();
                weight = edge.getWeight();
                if (distances[vertex1] != Double.MAX_VALUE && distances[vertex1] + weight < distances[vertex2] ){
                    distances[vertex2] = distances[vertex1] + weight;
                    pred[vertex2] = vertex1;
                }
            }
        }
        for (Graph.Edge edge : graph.edges()){
            vertex1 = edge.getVertex1();
            vertex2 = edge.getVertex2();
            weight = edge.getWeight();
            if (distances[vertex1] != Double.MAX_VALUE && distances[vertex1] + weight < distances[vertex2]){
                System.out.println("contains a negative weight cycle");
                return false;

            }
        }
        printShortestPath(distances, source, pred);
        return true;

    }

    public void printShortestPath(double[] distances, int source, int[] pred){
        System.out.println("shortest paths form [" + source + "] using Bellman Ford ");
        for (int v = 0; v < distances.length; v++){
            if (v != source) {
                System.out.print("Path from " + source + " to " + v + ": ");
                printPath(v, pred);
                System.out.println(" - Total distance: " + distances[v]);
            }
        }
    }

    public void printPath(int currentVertex, int[] pred){
        if (currentVertex == -1) return;
        printPath(pred[currentVertex], pred);
        System.out.print(currentVertex + " ");
    }

}
