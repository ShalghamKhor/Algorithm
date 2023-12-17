package assignment2.task1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Queue<Item> implements Iterable<Item> {
    Item [] queue;
    int size;
    Random random;

    public Queue(){
        queue = (Item[]) new Object[2];
        random = new Random();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void enqueue(Item item){
        if (item == null){
            throw new IllegalArgumentException("Item cant be null");

        }
        if (size == queue.length){
            Item[] largerQueue = (Item[]) new Object[queue.length * 2];
            for (int i = 0; i < size; i++){
                largerQueue[i] = queue[i];
            }
            queue = largerQueue;
        }
        queue[size] = item;
        size++;
    }

    public Item dequeue(){
        if (isEmpty()){
            throw new IllegalArgumentException("queue underflow");
        }
        int randomIndex = random.nextInt(size);
        Item item = queue[randomIndex];
        queue[randomIndex] = queue[size - 1];
        queue[size - 1] = null;
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int current = 0;
            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public Item next() {
                if (!hasNext()){
                    throw new NoSuchElementException();
                }
                return queue[current++];
            }
        };
    }
}
