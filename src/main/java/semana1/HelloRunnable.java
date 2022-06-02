package semana1;

public class HelloRunnable implements Runnable{

    @Override
    public void run() {
        String helloMess = String.format("Hola, soy %s\n",
                Thread.currentThread().getName());
        System.out.println(helloMess);
    }
}
