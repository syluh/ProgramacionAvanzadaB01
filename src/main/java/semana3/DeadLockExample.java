package semana3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        DeadLockExample deadLock = new DeadLockExample();
        new Thread(deadLock::operation1, "f1").start();
        new Thread(deadLock::operation2, "f2").start();
    }

    public void operation1() {
        lock1.lock();
        System.out.println("lock1 adquirido, esperado adquirir lock2");

        lock2.lock();
        System.out.println("lock2 adquirido");

        System.out.println("Ejecutando primera operación");

        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        lock2.lock();
        System.out.println("lock1 adquirido, esperado adquirir lock2");

        lock1.lock();
        System.out.println("lock2 adquirido");

        System.out.println("Ejecutando primera operación");

        lock1.unlock();
        lock2.unlock();
    }
}
