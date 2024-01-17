package assignment2.task3;

import java.util.List;

public class CustomQueue {
    public void sortPerson(List<Person> persons){
        Person[] array = persons.toArray(new Person[0]);
        int high = array.length;
        for (int i = high / 2 - 1; i >= 0; i--) {
            heapify(array, high, i);
        }
        for (int i = high-1; i >= 0; i--) {
            Person temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    public void heapify(Person[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l].getPriority() > array[largest].getPriority()) {
            largest = l;
        }

        if (r < n && array[r].getPriority() > array[largest].getPriority()) {
            largest = r;
        }

        if (largest != i) {
            Person swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }
}
