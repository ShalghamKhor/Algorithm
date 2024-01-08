package assignment3.task3;

import assignment3.task1.Graph;
import assignment1.unionFind;
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
        Graph.Edge[] edgesArray = edges.toArray(new Graph.Edge[0]);

        minHeap.heapSort(edgesArray, 0, edgesArray.length -1);
        unionFind unionFind = new unionFind(vertices);
        List<Graph.Edge> mst = new ArrayList<>();

        for (Graph.Edge edge : edgesArray){
            int x = unionFind.find(edge.getVertex1());
            int y = unionFind.find(edge.getEdgeVertex2());

            if (x != y){
                mst.add(edge);
                unionFind.union(x,y);
            }
        }


        return mst;
    }


}
