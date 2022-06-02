package semana7;

import java.util.List;
import java.util.concurrent.Callable;

public class TaskSumList implements Callable<Integer> {
    private List<Integer> nums;

    public TaskSumList(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    public Integer call() throws Exception {
        /* var sum = 0;
        for (int i: nums){
            sum += i;
        }
        return sum;*/
        return nums.stream().reduce(Integer::sum).get();
    }
}
