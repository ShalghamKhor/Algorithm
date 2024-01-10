package assignment3.task3;

import assignment3.task1.Graph;

import java.util.Arrays;

public class MinHeap {

    public void heapSort(Graph.Edge[] edges, int low, int high) {
        System.out.println("Initial array: " + Arrays.toString(edges));
        for (int i = high  / 2 - 1; i >= low; i--) {
            heapify(edges, high, i);
        }
        for (int i = high; i > low; i--) {
            Graph.Edge temp = edges[0];
            edges[0] = edges[i];
            edges[i] = temp;
            heapify(edges, i, 0);
            System.out.println("Array after iteration " + i + ": " + Arrays.toString(edges));
        }
        System.out.println("Sorted array: " + Arrays.toString(edges));
    }

    public void heapify(Graph.Edge[] edges, int n, int i) {

        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && edges[l].getWeight() < edges[smallest].getWeight()) {
            smallest = l;
        }

        if (r < n && edges[r].getWeight() < edges[smallest].getWeight()) {
            smallest = r;
        }

        if (smallest != i) {
            System.out.println("Swapping: " + edges[i] + " with " + edges[smallest]);
            Graph.Edge swap = edges[i];
            edges[i] = edges[smallest];
            edges[smallest] = swap;

            heapify(edges, n, smallest);
        }
    }

}
