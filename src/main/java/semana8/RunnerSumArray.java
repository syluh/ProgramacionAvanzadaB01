package semana8;

import semana7.TaskSumArray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class RunnerSumArray {

    private int[][] matrix;

    public RunnerSumArray(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumar(){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(matrix.length);

        List<Future<Integer>> rowsResults = new ArrayList<>();

        for (var row: matrix){
            rowsResults.add(executor.submit(new TaskSumArray(row)));
        }

        var total = 0;
        try{
            for (var sum: rowsResults){
                total += sum.get();
            }
        }catch (ExecutionException | InterruptedException exception){}

        executor.shutdown();

        return total;
    }
}
