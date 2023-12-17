package assignment2.task4;

import java.util.Arrays;
import java.util.Random;


public class Test {
    int [] arraySize = {10, 100, 1000, 1000};
    Random random = new Random();
    QuickSort quickSort = new QuickSort();


    public void randomArrysize(){
        for (int size: arraySize){
            int [] randomArray  = randomArray(size);
            int depth = random.nextInt(size);
            System.out.println("before sorted :" + Arrays.toString(randomArray));
            quickSort.quickSort(randomArray, 0, randomArray.length-1, depth);
            System.out.println("After sorted: "+Arrays.toString(randomArray));
            System.out.println("--------------------------------------------");

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
