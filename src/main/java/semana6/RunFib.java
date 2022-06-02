package semana6;

import java.util.concurrent.ForkJoinPool;

public class RunFib {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        for (int nro = 0; nro < 40; nro++){
            int result = pool.invoke(new FibonacciTask(nro));
            System.out.printf("F[%d]: %d\n", nro, result);
        }
    }
}
