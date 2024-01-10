package assignment3.task2;

import assignment3.task1.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphSearch {

    public boolean depthFirstSearch(Graph graph, int start, int end){
        Set<Integer> visited = new HashSet<>();

        return dfsHelper(graph, start, end, visited);
    }

    public boolean dfsHelper(Graph graph, int start, int end, Set<Integer> visited){
        if (start == end) return true;
        visited.add(start);

        for (Graph.Edge edge : graph.adjacent(start)){
            int neihgbor = edge.getVertex2();
            if (!visited.contains(neihgbor) && dfsHelper(graph, neihgbor, end, visited)){
                return true;
            }
        }
        return false;
    }

    public boolean breadthFirstSearch(Graph graph, int start, int end){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int current = queue.poll();
            if (current == end){
                return true;
            }
            visited.add(current);

            for (Graph.Edge edge : graph.adjacent(current)){
                int neihbor = edge.getVertex2();
                if (!visited.contains(neihbor)){
                    queue.add(neihbor);
                }
            }

        }
        return false;
    }
}
