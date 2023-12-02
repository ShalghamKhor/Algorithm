import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        timer t = new timer();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        B3Sum b3Sum = new B3Sum();

        //b3Sum.bruteForce(nums, 0);
        b3Sum.quick3Sum(nums,0);

    }

}