package semana5.ejem1.v1;

import java.util.List;

public class RunPrimeTask {
    public static void main(String[] args) {
        var nums = List.of(2, 3, 4, 5, 6, 7, 8, 9, 11);

        for (var num: nums){
            Thread t = new Thread(new PrimeTask(num));
            t.start();
        }
    }
}