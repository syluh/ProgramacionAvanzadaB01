package semana5.ejem1.v1;

import java.util.stream.IntStream;

public class PrimeTask implements Runnable{
    private int number;

    public PrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (IntStream.range(2, number).anyMatch(div -> number % div == 0)){
            System.out.printf("%d No es primo%n",  number);
        }else {
            System.out.printf("%d Es primo%n", number);
        }
    }
}
