package semana3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LivelockExample livelock = new LivelockExample();
        new Thread(livelock::operation1,"T1").start();
        new Thread(livelock::operation2,"T2").start();

    }

    public void operation1 (){
        while (true) {
            tryLock(lock1);
        }
    }

    public void operation2(){

    }

    private void print (String message){
        System.out.printf("Thread %s: %s%n",
                Thread.currentThread().getName(),
                message);
    }

    private void sleep (long milis){
        try{
            TimeUnit.MILLISECONDS.sleep(milis);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    private void tryLock(Lock lock, long millis){
        try {
            lock.tryLock(millis, TimeUnit.MILLISECONDS);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public boolean tryLock(Lock lock){
        return lock.tryLock();
    }
}
