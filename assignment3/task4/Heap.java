package assignment3.task4;

import assignment3.task1.Graph;

public class Heap {
    VertexDistance[] heap;
    int size;


    public Heap(int cap){
        this.heap = new VertexDistance[cap];
        this.size = 0;

    }

    public void insert(VertexDistance distance){
        heap[size] = distance;
        int current = size++;
        while (current > 0 && heap[current].getDistance() < heap[getParent(current)].getDistance()) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public VertexDistance extractMin(){
        VertexDistance minItem = heap[0];
        heap[0] = heap[size -1];
        size--;
        heapify(0);
        //System.out.println("min vertex in Heap" + minItem);
        return minItem;
    }

    private void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < size && heap[left].getDistance() < heap[i].getDistance()) {
            smallest = left;
        }
        if (right < size && heap[right].getDistance() < heap[smallest].getDistance()) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public void swap(int i , int j){
        VertexDistance temp = heap[i];
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
