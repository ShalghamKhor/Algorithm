package timer;

public class timer {
    long startTime, endTime;

    public void startTime() {
        startTime = System.nanoTime();
    }

    public void endTime() {
        endTime = System.nanoTime();
    }

    public double duration() {
        long duration = (endTime - startTime);
        return (duration / 1000000.0);
    }

}