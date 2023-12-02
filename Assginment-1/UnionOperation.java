import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UnionOperation {
    int[] arraySizes = {10, 100, 1000, 10000, 100000};
    timer timer = new timer();
    Random random = new Random();
    public void quickFindoperation(){


        for(int arraySize : arraySizes){
            unionFind uf = new unionFind(arraySize);
            List<int[]> pairs = randomPair(arraySize, random);

            timer.startTime();
            for (int[] pari : pairs){
                uf.union(pari[0], pari[1]);
            }
            timer.endTime();
            System.out.println("Time quick find for Array of Size: " + arraySize);
            timer.duration();

        }
    }
    public void quickUniondoperation(){

        for(int arraySize : arraySizes){
            QuickUnion qu = new QuickUnion(arraySize);
            List<int[]> pairs = randomPair(arraySize, random);

            timer.startTime();
            for (int[] pari : pairs){
                qu.union(pari[0], pari[1] );
            }
            timer.endTime();
            System.out.println("Time quick union for Array of Size: " + arraySize);
            timer.duration();

        }
    }


    public List<int[]> randomPair(int size, Random random){
        List<int[]> generatedPairs = new ArrayList<>();
        for (int i = 0; i < size; i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            generatedPairs.add(new int[]{a,b});

        }

        return generatedPairs;
    }
}
