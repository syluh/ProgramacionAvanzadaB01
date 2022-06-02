package semana4.ejer1.concurrente;

public class TaskSumDiv implements Runnable{
    private int num;
    private boolean isPerfecto;

    public TaskSumDiv(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        var suma = 0;

        for (var div = 1; div <= num/2; div++){
            if (num % div == 0){
                suma += div;
            }
        }

        if ( suma == num ){
            System.out.printf("%d es PERFECTO%n", num);
            isPerfecto = true;
        } else {
            System.out.println("NO PERFECTO");
            isPerfecto = false;
        }
    }

    public boolean isPerfecto() {
        return isPerfecto;
    }
}
