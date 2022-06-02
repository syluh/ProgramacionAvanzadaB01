package semana5.ejem2.v2;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class PrimeTaskEjem2V2 implements Runnable{
    private int number;
    private boolean isPrime;
    private CountDownLatch endController;

    public PrimeTaskEjem2V2(int number, CountDownLatch endController){
        this.number = number;
        this.endController = endController;
    }

    @Override
    public void run(){
        isPrime = IntStream.range(2, number).noneMatch(div -> number % div == 0);
        endController.countDown();
    }

    public boolean isPrime() {
        return isPrime;
    }
}
