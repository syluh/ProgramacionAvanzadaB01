import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import semana8.RunnerSumArray;

public class TaskSumMatrix {
    @Test
    void testSum(){
        int[][] myMatrix = {
                {1, 2, 3},
                {2, 3, 1},
                {3, 1, 2}
        };
        RunnerSumArray runnerSumArray = new RunnerSumArray(myMatrix);
        Assertions.assertEquals(18, runnerSumArray.sumar());
    }
}
