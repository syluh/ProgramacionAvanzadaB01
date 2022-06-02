package semana3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter2 {
    private static int count = 0;
    private final Lock counterLook;

    public Counter2() {counterLook = new ReentrantLock();}

    public void increment(){
        counterLook.lock();
        try {
            TimeUnit.MILLISECONDS.sleep(100L);
        }catch (InterruptedException ignored){}
        try{
            count ++;
        }finally {
            counterLook.unlock();
        }
    }

    public static int getCount() {
        return count;
    }
}
