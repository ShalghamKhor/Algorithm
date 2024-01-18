package assignment3.task3;

import assignment3.task1.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskals {
    List<Graph.Edge> edges;
    int vertices;

    public Kruskals(int vertices){
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int vertex1,int vertex2, double weight){
        edges.add(new Graph.Edge(vertex1, vertex2, weight));
    }

    public List<Graph.Edge> MST(){
        MinHeap minHeap = new MinHeap(edges.size());

        for (Graph.Edge edge : edges){
            minHeap.insert(edge);
        }

        UnionFind unionFind = new UnionFind(vertices);
        List<Graph.Edge> mst = new ArrayList<>();

        while (minHeap.size > 0){
            Graph.Edge edge = minHeap.extractMin();
            int x = unionFind.find(edge.getVertex1());
            int y = unionFind.find(edge.getVertex2());

            if (x != y){
                mst.add(edge);
                unionFind.union(x,y);
            }
        }

        return mst;
    }

}
