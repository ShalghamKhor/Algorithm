
public class timer {
    long startTime, endTime;

    public void starttime() {
        startTime = System.nanoTime();
    }

    public void endtime() {
        endTime = System.nanoTime();
    }

    public void duration() {
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000.0 + "ms");
    }

}