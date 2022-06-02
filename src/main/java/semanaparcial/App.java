package semanaparcial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main( String[] args ) {
        //Puedes usar esta lista o tú propia lista.
        List<Integer> nums = IntStream.generate(() ->
                        ThreadLocalRandom.current().nextInt(1, 100_000)).limit(24)
                .boxed()
                .collect(Collectors.toList());


        System.out.println( results(nums) );
    }
    /**
     * Crea tantos hilos como cores tiene el procesador y asigna una porción de los datos a cada hilo y cumple con lo
     * que plantea la pregunta en canvas.
     * @param numbers Una lista de números enteros
     * @return Devuelve la cantidad de números perfectos que están en la lista.
     **/
    public static int results(List<Integer> numbers) {
        var result = 0;

        int numCores = Runtime.getRuntime().availableProcessors();
        int sizeList = numbers.size();
        int sizePartition = sizeList/numCores;

        if (sizePartition == 0){
            sizePartition = 1;
            if (numbers.size() == 0 || numbers == null){
                throw new IllegalArgumentException();
            }
        }

        List<List<Integer>> partitions = new ArrayList<>();
        List<Tarea> tasks = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < sizePartition; i++){
            partitions.add(new ArrayList<>());
        }

        int i = 0;
        for(int n: numbers){
            if (sizePartition == i){
                i = 0;
            }
            partitions.get(i).add(n);
            i++;
        }

        for (List<Integer> l: partitions){
            Tarea task = new Tarea(l);
            Thread t = new Thread(task);
            t.start();
            tasks.add(task);
            threads.add(t);
        }

        for (Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (Tarea l: tasks){
            result += l.getListNumAb().size();
        }

        System.out.println(partitions);

        return result;
    }
}
