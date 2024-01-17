package assignment2.task3;

import java.time.Instant;

public class Person{
    String name;
    int priority;
    public Person(String name, int priority){
        this.name = name;
        this.priority = priority;
    }

    public String getName(){return name;}
    public int getPriority(){return priority;}
    public void setPriority(){this.priority=priority;}
}
