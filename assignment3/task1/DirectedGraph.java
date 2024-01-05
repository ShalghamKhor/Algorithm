package assignment3.task1;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph extends Graph{

    @Override
    public void addEdge(int vertex1, int vertex2, double weight) {
        addVertex(vertex1);
        addVertex(vertex2);
        adjList.get(vertex1).add(new Edge(vertex1, vertex2, weight));
    }

    @Override
    public void addDefaultWeight(int vertex1, int vertex2) {
        addEdge(vertex1, vertex2, 1.0);
    }

    @Override
    public void removeEdge(int vertex1, int vertex2) {
        adjList.getOrDefault(vertex1, new ArrayList<>()).removeIf(edge -> edge.vertex2 == vertex2);
    }

    @Override
    public int numOfEdges() {
        int count = 0;
        for (List<Edge> edges : adjList.values()){
            count += edges.size();
        }
        return count;
    }

    @Override
    public Iterable<Edge> edges() {
        List<Edge> allEdges = new ArrayList<>();
        for (List<Edge> edges : adjList.values()){
            allEdges.addAll(edges);
        }
        return allEdges;
    }

    @Override
    public String toString(){
        return edges().toString();
    }
}
