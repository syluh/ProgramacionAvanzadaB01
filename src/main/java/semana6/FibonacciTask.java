package semana6;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Integer> {
    private final int nro;

    public FibonacciTask(int nro){
        this.nro = nro;
    }

    @Override
    protected Integer compute() {
        if (nro <= 1){
            return nro;
        }

        FibonacciTask f1 = new FibonacciTask(nro -1);
        f1.fork();

        FibonacciTask f2 = new FibonacciTask(nro -2);

        return f2.compute() + f1.join();
    }
}
