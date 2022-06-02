package semana7;

import java.util.List;
import java.util.concurrent.Callable;

public class TaskSumArray implements Callable<Integer> {
    private int[] nums;

    public TaskSumArray(int[] nums) {
        this.nums = nums;
    }

    @Override
    public Integer call() throws Exception {
        var sum = 0;
        for (int i: nums){
            sum += i;
        }
        return sum;
    }
}
