package semana1;

import java.util.List;

public class Trabajo2{
    public static void main(String[] args) {
        List<Integer> list = List.of(2,3,5,1,7,8,10,11,15,20,34,40);

        Count c = new Count();
        for (Integer x: list) {
            new Thread(new EvenParallelCount(x, c)).start();
        }

        try {
            Thread.currentThread().join(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Hay %d pares\n", c.count);
    }
}

class EvenParallelCount implements Runnable{

    int num;
    Count count;

    public EvenParallelCount(int num, Count count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public void run() {
        if (num % 2 == 0) {
            count.count ++;
            // System.out.printf("Hay %d pares\n", count.count);
        }
    }
}

class Count {
    int count;
}