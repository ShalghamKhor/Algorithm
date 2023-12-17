package assignment2.task4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    HeapSort heapSort = new HeapSort();
    public void quickSort(int[] array, int low, int high, int depht){
        if (low < high){
            if (depht <= 0){
                heapSort.heapSort(array, low, high);
            }else {
                int pivot = medianOfThree(array, low, high);
                int partitionIndex = partition(array, low, high, pivot);
                quickSort(array, low, partitionIndex-1, depht-1);
                quickSort(array, partitionIndex+1, high, depht-1);

            }
        }
    }


    public int partition(int[] array, int low, int high, int pivot){
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;
            if (i <= j) {
                int temporary = array[i];
                array[i] = array[j];
                array[j] = temporary;
                i++;
                j--;
            }
        }
        return i;
    }



    public int medianOfThree(int [] randomArray, int low, int high){
        int mid = low + (high-low) / 2;
        int [] threeNumber ={randomArray[low], randomArray[mid], randomArray[high]};
        Arrays.sort(threeNumber);
        return threeNumber[1];

    }


}
