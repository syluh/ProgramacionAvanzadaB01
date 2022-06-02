package semana4.ejer1.concurrente;

import java.util.List;
import java.util.stream.IntStream;

public class RunTaskSumDiv {
    public static void main(String[] args) {
        //var nums = List.of(6,28,45,89);
        IntStream.range(100_000, 1_000_000).forEach(num ->{
            TaskSumDiv task = new TaskSumDiv(num);
            new Thread(task).start();
        });
        /*for (var num: nums){
            TaskSumDiv task = new TaskSumDiv(num);
            new Thread(task).start();
        }*/
    }
}
