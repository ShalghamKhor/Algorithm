package assignment3.task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UndirectedGraph extends Graph{

    @Override
    public void addEdge(int vertex1, int vertex2, double weight) {
        addVertex(vertex1);
        addVertex(vertex2);
        adjList.get(vertex1).add(new Edge(vertex1,vertex2,weight));
        adjList.get(vertex2).add(new Edge(vertex2, vertex1, weight));
    }

    @Override
    public void addDefaultWeight(int vertex1, int vertex2) {
        addEdge(vertex1, vertex2, 1.0);
    }

    @Override
    public void removeEdge(int vertex1, int vertex2) {
        adjList.getOrDefault(vertex1, new ArrayList<>()).removeIf(edge -> edge.vertex2 == vertex2);
        adjList.getOrDefault(vertex2, new ArrayList<>()).removeIf(edge -> edge.vertex2 == vertex1);
    }


    @Override
    public int numOfEdges() {
        int count = 0;
        for (List<Edge> edges : adjList.values()){
            count += edges.size();
        }
        return count / 2;
    }

    @Override
    public Iterable<Graph.Edge> edges() {
        Set<Edge> allEdges = new HashSet<>();
        for (List<Edge> edges : adjList.values()){
            for (Edge edge : edges){
                if (edge.vertex1 < edge.vertex2){
                    allEdges.add(edge);
                }
            }
        }
        return allEdges;
    }
}
