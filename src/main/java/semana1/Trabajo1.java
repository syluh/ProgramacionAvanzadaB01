package semana1;

import java.util.List;

public class Trabajo1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(2,3,5,1,7,8,10,11,15,20,34,40);

        System.out.println("Secuencial");
        list.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        System.out.println("Paralelo");
        //list.parallelStream().filter(x -> x % 2 == 0).forEach(System.out::println);

        for (Integer x : list) new Thread(new EvenParallel(x)).start();

    }
}

class EvenParallel implements Runnable{
    int num;

    public EvenParallel(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        if(num % 2 == 0){
            System.out.println(num);
        }
    }
}
