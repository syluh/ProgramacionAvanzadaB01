package semana1;

public class Demo1 {
    public static void main(String[] args) {
        //System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.printf("%s - ejecutándose\n", Thread.currentThread().getName());

        for (int i = 0; i < 5; i++){
            new Thread(() -> System.out.printf("%s - ejecutándose\n", Thread.currentThread().getName())).start();
        }

        System.out.printf("Fin del %s\n", Thread.currentThread().getName());

        HelloThread myThread = new HelloThread();
        myThread.start();

        Thread myThread2 = new Thread(new HelloRunnable());
        myThread2.start();
    }
}
