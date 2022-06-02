package semana3;

public class RunCounter {
    public static void main(String[] args) {
        var counter = new Counter();
        for (var i = 0; i < 10 ; i++){
            new Thread( () -> {
                counter.increment();
                System.out.printf("%d para hilo %s\n",
                        counter.getCount(),
                        Thread.currentThread().getName());
            }).start();
        }
    }
}
