package semana3;

public class Task implements Runnable{

    @Override
    public void run() {
        try{
            Thread.sleep(1500);
        }catch (InterruptedException ignored){}
            System.out.printf("Estado del hilo: %s (%s) mientras llamaba al método join() en thread2%n",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getState());
        try {
            Thread.sleep(200);
        }catch (InterruptedException ignored){}
    }
}
