package assignment2;

import assignment2.task3.Person;
import assignment2.task3.Ticket;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Test tes = new Test();
        //tes.randomArrysize();

        //TicketTest t = new TicketTest();
        //t.randomPerson(8);
        Ticket ticketSystem = new Ticket();
        ticketSystem.insert_person("Alice", 5);
        ticketSystem.insert_person("Bob", 10);
        ticketSystem.insert_person("Charlie", 3);

        // Display the current queue
        System.out.println("Initial Queue:");
        ticketSystem.currentQueue();
        ticketSystem.swap_priority("Alice", "Charlie");
        System.out.println("-----");
        ticketSystem.currentQueue();
        ticketSystem.swap_priority("Bob", "Charlie");
        System.out.println("--------------");
        ticketSystem.currentQueue();

        // Test getting the highest priority person



        /*
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
        }*/

    }
}