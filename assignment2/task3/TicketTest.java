package assignment2.task3;

import assignment2.task3.Ticket;

import java.util.Random;

public class TicketTest extends Ticket {

    public void randomPerson(int numOfPersons){
        Random random = new Random();
        int a = 1;
        for (int i = 0; i < numOfPersons; i++){
            String name = "person " + a++;
            int priority = random.nextInt(100) +1;
            insert_person(name, priority);
            currentQueue();
        }
    }


}
