package assignment3.task5;

import assignment3.task1.DirectedGraph;
import assignment3.task1.Graph;

import java.util.*;

public class Sort {
    public List<Integer> topologicalSort(Graph graph){
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (Integer vertex : graph.vertices()){
            if (!visited.contains(vertex)){
                topologicalSorthelper(graph, vertex, visited, stack);
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!stack.isEmpty()){
            order.add(stack.pop());

        }
        return order;
    }

    public void topologicalSorthelper(Graph graph, int vertex, Set<Integer> visited, Stack<Integer> stack){
        visited.add(vertex);
        for (Graph.Edge edge : graph.adjacent(vertex)){
            int neighbor = edge.getVertex2();
            if (!visited.contains(neighbor)){
                topologicalSorthelper(graph, neighbor, visited, stack);
            }
        }
        stack.push(vertex);
    }

}
