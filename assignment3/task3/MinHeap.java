package assignment3.task3;

import assignment3.task1.Graph;

import java.util.Arrays;

public class MinHeap {
    Graph.Edge[] heap;
    int size;


    public MinHeap(int cap){
        this.heap = new Graph.Edge[cap];
        this.size = 0;


    }

    public void insert(Graph.Edge edge){
        heap[size] = edge;
        int current = size++;
        while (current > 0 && heap[current].getWeight() < heap[getParent(current)].getWeight()) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public Graph.Edge extractMin(){

        Graph.Edge minItem = heap[0];
        heap[0] = heap[size -1];
        size--;
        heapify(0);
        System.out.println(minItem);
        return minItem;
    }



    public void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left].getWeight() < heap[smallest].getWeight()) {
            smallest = left;
        }

        if (right < size && heap[right].getWeight() < heap[smallest].getWeight()) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public void swap(int i , int j){
        Graph.Edge temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int getParent(int i){
        return (i -1)/2;
    }

    public int getSize(){
        return size;
    }

    public void decreaseKey(int vertex, double newWeight){
        int index = findIndex(vertex);
        if (index == -1){
            System.out.println("Vertex " + vertex + " not found in the heap");
            return;
        }
        heap[index].setWeight(newWeight);
        while (index > 0 && heap[index].getWeight() < heap[getParent(index)].getWeight()){
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    public int findIndex(int vertex){
        for (int i = 0; i < size; i++){
            if (heap[i].getVertex2() == vertex){
                return i;
            }
        }
        return -1;
    }

}
