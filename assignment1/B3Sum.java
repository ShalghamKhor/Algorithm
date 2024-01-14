package assignment1;

import timer.timer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class B3Sum {
    timer timer = new timer();
    int [] arraySize = {10, 100, 1000};
    Random random = new Random();

    public void randomArryTest(){
        for(int size : arraySize){
            int[] randomArray = randomArray(size);
            int targetSum = random.nextInt(size);

            timer.startTime();
            bruteForce(randomArray, targetSum);
            timer.endTime();
            System.out.print("Time: " +timer.duration() + "ms " + " using BruteForce  of array size:" + size + ": ");
            timer.startTime();
            twoPointer(randomArray, targetSum);
            timer.endTime();
            System.out.print("Time: "+ timer.duration()+"ms " +"for using quicker 3sum of array size " + size + ": ");
            System.out.println(" ");
        }
    }

    public int[] randomArray(int size){
        int [] generatedArray = new int[size];
        for(int i = 0; i < size; i++){
            generatedArray[i] = random.nextInt(size);
        }
        return generatedArray;
    }

    public void bruteForce(int[] listOfNumbers, int sumTarget){
        Arrays.sort(listOfNumbers);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < listOfNumbers.length; i++){
            for (int j = i + 1; j < (listOfNumbers.length); j++){
                for(int k = j + 1 ; k <listOfNumbers.length; k++){
                    if (listOfNumbers[i] + listOfNumbers[j] + listOfNumbers[k] == sumTarget){
                        result.add(Arrays.asList(listOfNumbers[i], listOfNumbers[j],listOfNumbers[k]));
                    }
                }
            }
        }
        /**
        for (List<Integer> res : result){
            System.out.println(res);
        }**/

    }


    public void twoPointer(int [] listOfNumbers, int targetSum){
        Arrays.sort(listOfNumbers);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i <listOfNumbers.length - 2; i++) {
            if (i == 0 || (i > 0 && listOfNumbers[i] != listOfNumbers[i - 1])) {
                int lower = i+1;
                int higher = listOfNumbers.length-1;
                while (lower < higher) {
                    int sum = listOfNumbers[i] + listOfNumbers[lower] + listOfNumbers[higher];
                    //int midPoint = (lower + higher) / 2;
                    if (sum == targetSum) {
                        result.add(Arrays.asList(listOfNumbers[i], listOfNumbers[lower], listOfNumbers[higher]));
                        lower++;
                        higher--;
                    } else if (sum < targetSum) {
                        lower++;
                    } else higher--;
                }
            }
        }
        /**
        for (List<Integer> res : result){
            System.out.println(res);
        }**/
    }
}
