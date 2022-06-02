package semana3;

import java.util.concurrent.atomic.AtomicInteger;

public class Option2 {
    public static void main(String[] args) {
        var counter = new AtomicInteger();
        for (var i = 0; i < 10 ; i++){
            new Thread( () -> {
                counter.incrementAndGet();
                System.out.printf("%d para hilo %s\n",
                        counter.get(),
                        Thread.currentThread().getName());
            }).start();
        }
    }
}
