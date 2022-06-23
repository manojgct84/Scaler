package dc.mock.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javafx.util.Pair;

public class TimeSeries {

    public static void main(String[] args) {

    }

    public TimeSeries() {
        reset ();
    }
    List<Pair> newValue = new ArrayList<>();
    long time = 0;
    long startTimeNanos;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void calculateTime (Pair pair) {

           time = calculateMinUsingNano() / milliseconds;
           if (time > 5) {
               startTimeNanos = System.nanoTime();
               fireReqToKafaService(newValue);
               reset();
           } else {
               lock.writeLock().lock();
                   newValue.add(pair);
               lock.writeLock().unlock();
           }
    }

    private void fireReqToKafaService(List<Pair> newValue) {
         lock.readLock().lock();
             for (Pair p : newValue) {

             }
            newValue = new ArrayList<>();
         lock.readLock().unlock();
    }
    int NANO_TO_MILL = 1000000;
    long milliseconds = 1000000;
    private long calculateMinUsingNano() {
        if (time > 5) {
            time = 0;
            reset ();
        }
        return (System.nanoTime() - startTimeNanos / NANO_TO_MILL);
    }

    private void reset ()
    {
        startTimeNanos = System.nanoTime();
    }
}
