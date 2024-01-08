package assignment3.task3;

import assignment3.task1.Graph;

public class MinHeap {

    public void heapSort(Graph.Edge[] edges, int low, int high) {

        for (int i = high / 2 - 1; i >= low; i--) {
            heapify(edges, high, i);
        }
        for (int i = high; i > low; i--) {
            Graph.Edge temp = edges[low];
            edges[low] = edges[i];
            edges[i] = temp;
            heapify(edges, i, low);
        }
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
            Graph.Edge swap = edges[i];
            edges[i] = edges[smallest];
            edges[smallest] = swap;

            heapify(edges, n, smallest);
        }
    }

}
