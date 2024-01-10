package assignment3.task1;

import java.util.*;

public abstract class Graph {

    Map<Integer, List<Edge>> adjList;

    public Graph(){
        adjList = new HashMap<>();
    }

    public void addVertex(int vertex){
        for (int i = 0; i < vertex; i++) {
            adjList.putIfAbsent(i, new ArrayList<>());
        }
    }

    public abstract void addEdge(int vertex1, int vertex2, double weight);
    
    public abstract void addDefaultWeight(int vertex1, int vertex2);

    public abstract void removeEdge(int vertex1, int vertex2);

    public int numOfVertices(){
        return adjList.size();
    };

    public abstract int numOfEdges();

    public int getDegree(int vertex){
        return adjList.getOrDefault(vertex, new ArrayList<>()).size();
    }

    public Iterable<Integer> vertices(){
        return adjList.keySet();
    }

    public Iterable<Edge> adjacent(int vertex) {
        return adjList.getOrDefault(vertex, new ArrayList<>());
    }

    public abstract Iterable<Edge> edges();

    public static class Edge {
        int vertex1, vertex2;
        double weight;

        public Edge(int vertex1, int vertex2, double weight){
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        public int getVertex1(){
            return vertex1;
        }

        public int getVertex2(){
            return vertex2;
        }

        public double getWeight(){
            return weight;
        }
        @Override
        public String toString() {
            return "Edge (" + vertex1 + ", " + vertex2 + ", " + weight + ")";
        }
    }
}
