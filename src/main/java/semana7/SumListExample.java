package semana7;

import java.util.List;
import java.util.concurrent.*;

public class SumListExample {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(new SumPrimeList(nums));

        try{
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException exc){
            exc.printStackTrace();
        }
        System.out.println("Fin del método main");
        executorService.shutdown();
    }
}
