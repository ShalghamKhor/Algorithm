public class B3Sum {
    public void bruteForce(int[] listOfnunmbers, int sumTarget){
        boolean found = false;
        for (int i = 0; i < listOfnunmbers.length; i++){
            for (int j = i + 1; j < (listOfnunmbers.length); j++){
                for(int k = j + 1 ; k <listOfnunmbers.length; k++){
                    if (listOfnunmbers[i] + listOfnunmbers[j] + listOfnunmbers[k] == sumTarget){
                        System.out.println(listOfnunmbers[i] + " " + listOfnunmbers[j] + " " + listOfnunmbers[k]);
                        found = true;
                    }

                }
            }
        }
        if(!found) {
            System.out.println("no numbber in the list equals the target");
        }
    }


    public void quick3Sum(int [] listOfNumbers, int targetSum){
        int lower = 0;
        int higher = listOfNumbers.length-1;
        while(lower <= higher){
            int midPoint = (lower + higher)/2;
            if (listOfNumbers[lower] + listOfNumbers[midPoint] + listOfNumbers[higher] == targetSum){
                System.out.println(listOfNumbers[lower] +"," + listOfNumbers[midPoint] +"," + listOfNumbers[higher]);
            } else if (listOfNumbers[lower] + listOfNumbers[midPoint] + listOfNumbers[higher] < targetSum) {
                lower++;
            }
            else higher--;
        }
    }
}
