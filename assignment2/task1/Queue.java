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
        size --;

        if (size > 0 && size == queue.length/4){
            Item [] smallerQueue = (Item[]) new Object[queue.length/2];
            for (int i = 0; i < size; i ++){
                smallerQueue[i] = queue[i];
            }
            queue = smallerQueue;
        }

        return item;
    }


    @Override
    public Iterator<Item> iterator() {

        Item[] shuffledQueue = (Item[]) new Object[size];
        for (int i = 0; i <size; i++){
            shuffledQueue[i] = queue[i];
        }

        for (int i = size -1; i > 0; i--){
            int index = random.nextInt(i + 1);
            Item temporary = shuffledQueue[index];
            shuffledQueue[index] = shuffledQueue[i];
            shuffledQueue[i] = temporary;
        }

        return new Iterator<Item>() {
            int current = 0;
            int iterationSize = size;

            @Override
            public boolean hasNext() {
                return current < iterationSize;
            }

            @Override
            public Item next() {
                if (!hasNext()){
                    throw new NoSuchElementException();
                }
                return shuffledQueue[current++];
            }
        };
    }
}
