package semana3;

public class RunCounter2 {
    public static void main(String[] args) {
        var counter = new Counter2();
        for (var i = 0; i < 10 ; i++){
            new Thread( () -> {
                counter.increment();
                System.out.printf("%d para hilo %s\n",
                        Counter2.getCount(),
                        Thread.currentThread().getName());
            }).start();
        }
    }
}
