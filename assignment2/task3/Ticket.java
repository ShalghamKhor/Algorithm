package assignment2.task3;

import java.util.*;

public class Ticket {

    PriorityQueue<Person> queue;
    HashMap<String, Person> personMap;
    HashMap<String, Integer> insertOrderMAp = new HashMap<>();
    int insertionCounter = 0;
    Deque<Person> insertOrder;

    public Ticket(){
        queue = new PriorityQueue<>((a,b) -> b.priority - a.priority);
        personMap = new HashMap<>();
        insertOrder = new LinkedList<>();
    }

    public void insert_person(String name, int priority){
        Person person = new Person(name , priority);
        queue.offer(person);
        personMap.put(name, person);
        insertOrder.addLast(person);
        insertOrderMAp.put(name, insertionCounter++);
    }

    public Person get_person(){
        if (insertOrder.isEmpty()){
            throw new NoSuchElementException("No more perosnin queue");
        }

        Person nextPerson = queue.poll();
        personMap.remove(nextPerson.getName());
        insertOrder.remove(nextPerson);
        return nextPerson;
    }

    public void delete_max_prio(){
        if (queue.isEmpty()){
            throw new NoSuchElementException("No person in the queue");
        }
        Person person = queue.poll();
        personMap.remove(person.name);
        insertOrder.remove(person);
    }

    public void swap_priority(String firstPerson, String secondPerson){
        Person person1 = personMap.get(firstPerson);
        Person person2 = personMap.get(secondPerson);

        if (person1 == null || person2 == null){
            throw new NoSuchElementException("Person not found");
        }
        int temporary = person1.priority;
        person1.priority = person2.priority;
        person2.priority = temporary;

        refreshQueue();
    }

    public List<Person> get_n_person(int n){
        List<Person> persons = new ArrayList<>();
        for (int i  = 0; i < n; i++){
            if (queue.isEmpty()) break;;
        }

        persons.add(get_person());
        return persons;
    }

    public void refreshQueue(){
        PriorityQueue<Person> newQueue = new PriorityQueue<>((a,b) ->
        {
            if (b.priority != a.priority) {
                return b.priority - a.priority;
            }
            return insertOrderMAp.get(a.getName()) - insertOrderMAp.get(b.getName());
        });
        for (Person person : insertOrder){
            newQueue.offer(person);
        }
        queue = newQueue;
    }

    public void currentQueue(){
        for (Map.Entry<String, Person> entry : personMap.entrySet()){
            System.out.println("name: " + entry.getKey() + ", Priority: " + entry.getValue().priority);
        }
    }

}
