package assignment2.task4;

import timer.timer;
import java.util.Random;


public class Test {
    int [] arraySize = {100, 1000, 10000, 100000};
    int [] depth = {0, 2, 5, 10, 15, 20};
    Random random = new Random();
    QuickSort quickSort = new QuickSort();
    InsertionSort insertionSort = new InsertionSort();
    timer timer = new timer();


    public void randomArrysize(){
        for (int size: arraySize){
            for (int depth : depth) {
                int[] array = randomArray(size);


                int[] arrayForHeapSort = array.clone();
                int[] arrayForInsertionSort = array.clone();

                timer.startTime();
                quickSort.quickSort(arrayForHeapSort, 0, size - 1, depth, true); // true for HeapSort
                timer.endTime();
                double heapSortTime = timer.duration();

                timer.startTime();
                quickSort.quickSort(arrayForInsertionSort, 0, size - 1, depth, false); // false for InsertionSort
                timer.endTime();
                double insertionSortTime = timer.duration();

                System.out.println("Size: " + size + "| Depth: " + depth + "| HeapSort Time: " + heapSortTime + "| InsertionSort Time: " + insertionSortTime);
            }

            System.out.println("-----------------------------------------------------------------------------------");
        }
    }


    public int[] randomArray(int size){
        int [] generatedArray = new int[size];
        for (int i = 0; i < size; i++){
            generatedArray[i] = random.nextInt(size*10);
        }
        return generatedArray;
    }





}
