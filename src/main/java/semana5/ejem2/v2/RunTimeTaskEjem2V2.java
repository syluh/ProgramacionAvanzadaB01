package semana5.ejem2.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RunTimeTaskEjem2V2 {
    public static void main(String[] args) throws InterruptedException{
        var nums = List.of(2, 3, 4, 5, 6, 7, 8, 9, 11);
        List<PrimeTaskEjem2V2> threads = new ArrayList<>();
        CountDownLatch endController = new CountDownLatch(nums.size());
        var numCores = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCores);

        for(var num: nums){
            PrimeTaskEjem2V2 primeTaskEjem2 = new PrimeTaskEjem2V2(num, endController);
            threads.add(primeTaskEjem2);
            executor.execute(primeTaskEjem2);
        }

        endController.await();
        System.out.println("Fin");
        System.out.println(threads.stream().filter(PrimeTaskEjem2V2::isPrime).count());
        executor.shutdown();
    }
}
