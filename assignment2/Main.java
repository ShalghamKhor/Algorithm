package assignment2;

import assignment2.task1.Queue;
import assignment2.task2.test;
import assignment2.task3.TicketTest;
import assignment2.task4.Test;


public class Main {
    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();

        System.out.println("Is queue empty: " + queue.isEmpty());
        queue.enqueue("taba");
        queue.enqueue("Beta");
        queue.enqueue("Banan");
        System.out.println("size of queue: " +queue.size());

        System.out.println("Rmoved Item: " + queue.dequeue());
        System.out.println("is quee empty: " + queue.isEmpty());
        System.out.println("Size of the queue: " + queue.size());

        for (String item : queue){
            System.out.println(item);
        }

    }
}