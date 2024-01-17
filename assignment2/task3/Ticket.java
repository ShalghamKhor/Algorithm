package assignment2.task3;

import java.util.*;

public class Ticket {

    List<Person> queue;
    HashMap<String, Person> personMap;
    HashMap<String, Integer> insertOrderMAp = new HashMap<>();
    int insertionCounter = 0;
    Deque<Person> insertOrder;
    CustomQueue customQueue;

    public Ticket(){
        queue = new ArrayList<>();
        personMap = new HashMap<>();
        insertOrder = new LinkedList<>();
        customQueue = new CustomQueue();

    }

    public void insert_person(String name, int priority){
        Person person = new Person(name , priority);
        queue.add(person);
        personMap.put(name, person);
        insertOrder.addLast(person);
        insertOrderMAp.put(name, insertionCounter++);
        customQueue.sortPerson(queue);

    }

    public Person get_person(){
        if (insertOrder.isEmpty()){
            System.out.println("No more person queue");
        }
        Person nextPerson = queue.remove(0);
        personMap.remove(nextPerson.getName());
        insertOrder.remove(nextPerson);
        return nextPerson;
    }

    public void delete_max_prio(){
        if (queue.isEmpty()){
            System.out.println("No person in the queue");
        }
        Person person = queue.remove(0);
        personMap.remove(person.name);
        insertOrder.remove(person);
    }

    public void swap_priority(String firstPerson, String secondPerson){
        Person person1 = personMap.get(firstPerson);
        Person person2 = personMap.get(secondPerson);

        if (person1 == null || person2 == null){
            System.out.println("Person not found");
        }
        int temporary = person1.priority;
        person1.priority = person2.priority;
        person2.priority = temporary;
        customQueue.sortPerson(queue);
    }

    public List<Person> get_n_person(int n){
        List<Person> persons = new ArrayList<>();
        for (int i  = 0; i < n; i++){
            if (queue.isEmpty()) break;;
        }

        persons.add(get_person());
        return persons;
    }

    public void currentQueue(){
        for (Map.Entry<String, Person> entry : personMap.entrySet()){
            System.out.println("name: " + entry.getKey() + ", Priority: " + entry.getValue().priority);
        }
    }
}
