package semana3;

public class Counter {
    private int count;

    public synchronized void increment() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException ignored){}
        count ++;
    }

    public int getCount() {
        return count;
    }
}
