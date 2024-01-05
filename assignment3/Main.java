package assignment3;

import assignment3.task1.DirectedGraph;
import assignment3.task1.Graph;
import assignment3.task1.UndirectedGraph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new DirectedGraph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addDefaultWeight(2,1);
        graph.addEdge(2, 3, 2.5);

        System.out.println("Number of vertices " + graph.numOfVertices());
        System.out.println("Number of edges: " + graph.numOfEdges());

        System.out.println("Vertices: ");
        for (int vertex : graph.vertices()){
            System.out.println(vertex);
        }

        System.out.println("degree " + graph.getDegree(2));

        System.out.println("Edges from vertex 2:");
        //Iterable<Graph.Edge> edges = graph.adjacent(2);
        for (Graph.Edge edge1 : graph.adjacent(2)){
            System.out.println("Edges from 2 to " + edge1.getEdgeVertex2() + " with weight " + edge1.getWeight());
        }

        graph.removeEdge(1,2);
        System.out.println("number of edges after removing an edge " + graph.numOfEdges());

    }
}
