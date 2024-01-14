package assignment3;

import assignment3.task1.DirectedGraph;
import assignment3.task1.Graph;
import assignment3.task3.Kruskals;
import assignment3.task4.Dijkstra;

import java.util.List;

public class Main {
/*
    public static void main(String[] args) {
        Graph graph = new DirectedGraph();
        GraphSearch graphSearch = new GraphSearch();

        graph.addVertex(15);
        graph.addDefaultWeight(2,0);
        graph.addDefaultWeight(2,3);
        graph.addDefaultWeight(3,1);
        graph.addDefaultWeight(3,4);
        graph.addDefaultWeight(4,3);
        graph.addDefaultWeight(5,4);
        graph.addDefaultWeight(5,6);
        graph.addDefaultWeight(6,4);
        graph.addDefaultWeight(6,10);
        graph.addDefaultWeight(7,6);
        graph.addDefaultWeight(7,8);
        graph.addDefaultWeight(8,9);
        graph.addDefaultWeight(10,9);

        graph.addDefaultWeight(12,11);
        graph.addDefaultWeight(12,13);
        graph.addDefaultWeight(13,14);
        graph.addDefaultWeight(14,12);

        System.out.println(graph.numOfEdges());
        System.out.println(graph.numOfVertices());

        System.out.println(graph.getDegree(6));
        System.out.println(graph.getDegree(0));


        System.out.println(graphSearch.depthFirstSearch(graph, 6, 1));
        System.out.println(graphSearch.depthFirstSearch(graph, 6, 7));


        /*
        graph.addDefaultWeight(2,1);
        graph.addEdge(2, 3, 2.5);
        boolean pathExist = graphSearch.breadthFirstSearch(graph,2, 3);
        boolean pathExi = graphSearch.depthFirstSearch(graph, 2, 3);
        System.out.println(pathExist);
        System.out.println(pathExi);
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

    public static void main(String[] args) {
        int vertices = 8;
        Kruskals graph = new Kruskals(vertices);
        graph.addEdge(0, 1, 7);

        graph.addEdge(0,3, 6);
        graph.addEdge(1, 3, 2);
        graph.addEdge(0, 6, 9);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 10);
        graph.addEdge(2, 4, 4);
        graph.addEdge(2,7, 13);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 3);
        graph.addEdge(4, 7, 8);
        graph.addEdge(5,6,14);
        graph.addEdge(5, 7, 16);

        List<Graph.Edge> edges = graph.MST();

        for (Graph.Edge edge : edges){
            System.out.println(edge);
        }
    }*/

    public static void main(String[] args) {
        Graph graph = new DirectedGraph();
        graph.addEdge(0,1,5);
        graph.addEdge(0,3,8);
        graph.addEdge(0,6,9);
        graph.addEdge(1,2,15);
        graph.addEdge(1,3,4);
        graph.addEdge(2,7,9);
        graph.addEdge(3,4,7);
        graph.addEdge(3,5,6);
        graph.addEdge(4,2,3);
        graph.addEdge(4,7,11);
        graph.addEdge(5,7,13);
        graph.addEdge(6,3,5);
        graph.addEdge(6,4,7);
        graph.addEdge(6,7,20);

        Dijkstra dj = new Dijkstra();
        dj.dijkstra(graph, 0);
    }
}
