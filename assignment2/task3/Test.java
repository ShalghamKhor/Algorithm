package assignment2.task3;

import java.util.Random;

public class Test extends Ticket{

    public void randomPerson(int numOfPersons){
        Random random = new Random();
        for (int i = 0; i < numOfPersons; i++){
            String name = "person " + 1;
            int priority = random.nextInt(100) +1;
            insert_person(name, priority);
        }
    }



}
