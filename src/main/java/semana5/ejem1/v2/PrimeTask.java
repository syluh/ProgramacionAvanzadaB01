package semana5.ejem1.v2;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class PrimeTask implements Runnable{
    private int number;
    private CountDownLatch endController;

    public PrimeTask(int number, CountDownLatch endController) {
        this.number = number;
        this.endController = endController;
    }

    @Override
    public void run() {
        if (IntStream.range(2, number).anyMatch(div -> number % div == 0)){
            System.out.printf("%d No es primo%n",  number);
        }else {
            System.out.printf("%d Es primo%n", number);
        }
        endController.countDown();
    }
}
