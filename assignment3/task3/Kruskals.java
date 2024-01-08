package assignment3.task3;

import assignment3.task1.Graph;
import java.util.ArrayList;
import java.util.List;
public class Kruskals {
    List<Graph.Edge> edges = new ArrayList<>();
    int vertices;

    public Kruskals(int vertices){
        this.vertices = vertices;
    }

    public void addEdge(int vertex1,int vertex2, double weight){
        edges.add(new Graph.Edge(vertex1, vertex2, weight));
    }

    public List<Graph.Edge> MST(){
        MinHeap minHeap = new MinHeap();
        Graph.Edge[] edges = MST().toArray(new Graph.Edge[0]);

        minHeap.heapSort(edges, 0, edges.length -1);
        return null;
    }


}
