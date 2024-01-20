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
        System.out.println(minItem);
        return minItem;
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
}
