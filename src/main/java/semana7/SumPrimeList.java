package semana7;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SumPrimeList implements Callable<Integer> {
    List<Integer> nums;

    public SumPrimeList(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public Integer call() throws Exception {
        /*return nums.stream()
                .filter(x -> x < 1)
                .filter(x -> !IntStream.range(2, x-1).anyMatch(y -> x % y == 0))
                .reduce(Integer::sum).get();*/
        return nums.stream().filter(this::isPrime).reduce(Integer::sum).get();
    }

    private boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        for (int i = 2; i < num; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
