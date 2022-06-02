package semana7;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Notas {
    public static void main(String[] args) {
        int numCores = 8;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCores);
    }
}
